#!/bin/bash

################################################################################
# Copyright 2017 Davide "FunkyAss" Del Zompo
#
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in all
# copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
# SOFTWARE.
################################################################################

chip_address=""
chip_user="chip"
artifacts_preserve=0
dest_dir="miriam_gui"

tmp_template="/tmp/miriam_gui_deployXXX"
tmp_dir=""

class_dir="target/classes"
lib_dir="lib"
img_dir="img"
source_dirs=("$class_dir" "$lib_dir" "$img_dir")

run_script="contrib/mgui_run.sh"
target_tar="miriam_gui.tar.gz"

function print_help
{
    printf -- "Usage: %s -a address [-d dest][-u user][-p][-h]\n" $1
    printf -- "-a address   chip address\n"
    printf -- "-d dest      destination directory on chip file system\n"
    printf -- "-u user      ssh user\n"
    printf -- "-p           preserve artifacts\n"
    printf -- "-h           print this help and exit\n"
}

while getopts "a:d:u:ph" opt; do
    case $opt in
        a)  chip_address="$OPTARG";;
        d)  dest_dir="$OPTARG";;
        u)  chip_user="$OPTARG";;
        p)  artifacts_preserve=1;;
        h)  print_help $0; exit 0;;
    esac
done

if [ -z "$chip_address" ]; then
    printf -- "The -a argument is mandatory\n" >&2
    print_help $0>&2
    exit 1
fi

tmp_dir=$(mktemp -d "$tmp_template")
if [ -z "$tmp_dir" ]; then
    printf -- "Cannot create temporary directory. Aborting\n" >&2
    exit 2
fi
mkdir "$tmp_dir/classes" "$tmp_dir/lib" "$tmp_dir/img"

for dir in ${source_dirs[@]}; do
    if [ ! -d "$dir" ]; then
        printf -- "Cannot stat %s directory\n" $dir >&2
        printf -- "Make sure you launched %s from the project root\n" >&2 $0
        exit 3
    fi
done

if [ ! -f "$run_script" ]; then
    printf -- "Cannot stat %s. Aborting\n" "$run_script"
    exit 4
fi

printf -- "Destination user: %s\n" "$chip_user"
printf -- "Destination address: %s\n" "$chip_address"
printf -- "Destination directory: %s\n" "$dest_dir"
printf -- "Temp directory: %s\n" "$tmp_dir"

find "$class_dir" -name '*.class' -exec cp -t "$tmp_dir/classes" {} \+
find "$lib_dir" -name '*.jar' -exec cp -t "$tmp_dir/lib" {} \+
find "$img_dir" -name '*.png' -exec cp -t "$tmp_dir/img" {} \+
cp -t "$tmp_dir/" "$run_script"

pushd "$tmp_dir" >/dev/null
tar czf "$target_tar" "classes" "lib" "img" "mgui_run.sh"
popd >/dev/null

printf -- "Running ssh...\n"
cat "$tmp_dir/$target_tar" | ssh ${chip_user}@${chip_address} \
    "mkdir -p $dest_dir; tar xzf - -C $dest_dir; chmod +x $dest_dir/mgui_run.sh"

ssh_status=$?
if [ $artifacts_preserve -eq 1 ] ||  [ $ssh_status -ne 0 ]; then
    printf -- "Preserving deploy artifacts in %s\n" "$tmp_dir"
else
    rm -rf "$tmp_dir"
fi
