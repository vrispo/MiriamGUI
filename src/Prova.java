import nanomsg.pipeline.PushSocket;

public class Prova {
    public static void main(String[] args) {
        PushSocket sock = new PushSocket();
        sock.setRecvTimeout(-1);
        sock.setSendTimeout(-1);
        sock.connect("tcp://127.0.0.1:40000");
        String j="{\"weather\":\"08\",\"temperature\":18.71,\"unread\":2," +
				"\"email_list\":[{\"name\":\"rossella carletti\",\"email\":\"carletti.rossella@gmail.com\",\"subject\":\"prova2lungalungalungalungalungalungalunga123456789012345678901234567890\"}," +
				"{\"name\":\"veronica rispo\",\"email\":\"veronica.rispo@gmail.com\",\"subject\":\"fottiti\"}],\"" +
				"events\":[{\"name\":\"esame xlungalungalungalungalungalungalunga123456789012345678901234567890\",\"time\":\"2017-04-03T16:00:00+02:00\"}," +
				"{\"name\":\"esame utente 2\",\"time\":\"2017-04-03T16:00:00+02:00\"},"
				+ "{\"name\":\"bla bla bla y\",\"time\":\"2017-04-03T16:00:00+02:00\"}]" +
				",\"user_id\":\"utente 2\",\"command\":\"d\"}";


        sock.send(j);
        sock.close();
    }
}
/*
"{\"weather\":\"\",\"temperature\":0,\"unread\":0, \"email_list\":null,\"events\":null,\"user_id\":\"\",\"command\":\"s\"}";
     
        
        

*/