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

java_classpath='classes/:lib/*:/usr/share/java/*'
miriam_bin='MiriamGUI'
log_file="MiriamGUI.log"

required=(xset)

for r in ${required[@]}; do
    which "$r" >/dev/null 2>&1 || { printf -- "%s not found\n" "$r"; exit 1; }
done

export DISPLAY=:0

#### setup #####################################################################
xset -dpms
################################################################################

#launch miriamGUI
printf -- "START === %s\n" "$(date)" >> $log_file
java -cp $java_classpath MiriamGUI 2>&1 | tee -a $log_file &
printf -- "STOP === %s\n" "$(date)" >> $log_file
mgui_pid=$!

wait $mgui_pid

#### cleanup ###################################################################
xset +dpms
################################################################################
