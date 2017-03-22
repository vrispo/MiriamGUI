import nanomsg.pipeline.PushSocket;

public class Prova {
    public static void main(String[] args) {
        PushSocket sock = new PushSocket();
        sock.setRecvTimeout(-1);
        sock.setSendTimeout(-1);
        sock.connect("tcp://127.0.0.1:40000");
        String j="{\"weather\":\"08\",\"temperature\":18.71,\"unread\":2," +
				"\"email_list\":[{\"name\":\"rossella carletti\",\"email\":\"carletti.rossella@gmail.com\",\"subject\":\"prova2\"}," +
				"{\"name\":\"veronica rispo\",\"email\":\"veronica.rispo@gmail.com\",\"subject\":\"fottiti\"}],\"" +
				"events\":[{\"name\":\"esame x\",\"time\":\"21 marzo 2017 11:00\"}," +
				"{\"name\":\"esame y\",\"time\":\"27 marzo 2017 10:00\"},"
				+ "{\"name\":\"bla bla bla y\",\"time\":\"27 marzo 2017 10:00\"}]" +
				",\"user_id\":\"stupido chi legge\",\"command\":\"d\"}";

        sock.send(j);
        sock.close();
    }
}
/*
"{\"weather\":\"\",\"temperature\":0,\"unread\":0, \"email_list\":null,\"events\":null,\"user_id\":\"\",\"command\":\"s\"}";
     
        
        


*/