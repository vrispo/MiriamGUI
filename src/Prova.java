import nanomsg.pipeline.PushSocket;

public class Prova {
    public static void main(String[] args) {
        PushSocket sock = new PushSocket();
        sock.bind("tcp://*:6789");

        String[] people = new String[5];
        people[0]="Foo";
        people[1]="Bar";
        people[2]="Baz";

        for(int i=0; i<people.length; ++i) {
            sock.send(people[i]);
        }

        sock.close();
    }
}
