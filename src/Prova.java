import nanomsg.pipeline.PushSocket;

public class Prova {
    public static void main(String[] args) {
        PushSocket sock = new PushSocket();
        sock.setRecvTimeout(-1);
        sock.setSendTimeout(-1);
        sock.connect("tcp://127.0.0.1:40000");

        String[] people = new String[5];
        people[0]="Foo";
        people[1]="Bar";
        people[2]="Baz";
        
        String j="{\"weather\":\"08\",\"temperature\":18.71,\"unread\":2," +
				"\"email_list\":[{\"name\":\"rossella carletti\",\"email\":\"carletti.rossella@gmail.com\",\"subject\":\"prova2\"}," +
				"{\"name\":\"rossella carletti\",\"email\":\"carletti.rossella@gmail.com\",\"subject\":\"prova\"}],\"" +
				"events\":[{\"name\":\"esame x\",\"time\":\"21 marzo 2017 11:00\"}," +
				"{\"name\":\"esame y\",\"time\":\"27 marzo 2017 10:00\"}]" +
				",\"user_id\":\"stupido chi legge\",\"command\":\"d\"}";

        /*for(int i=0; i<people.length; ++i) {
            sock.send(people[i]);
            System.out.println(people[i]);
        }*/

        sock.send(j);
        sock.close();
    }
}
