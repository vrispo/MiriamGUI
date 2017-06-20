import nanomsg.pipeline.PushSocket;

public class Prova {
    public static void main(String[] args) {
        PushSocket sock = new PushSocket();
        sock.setRecvTimeout(-1);
        sock.setSendTimeout(-1);
        sock.connect("tcp://127.0.0.1:40000");
        String j="{\"weather\":\"02\",\"temperature\":31.71,\"unread\":3,"
        		+ "\"email_list\":[{\"name\":\"GearBest.com\",\"email\":\"newsletter@edm.gearbest.com\",\"subject\":\"THE VERY BEST OF XIAOMI SALE | Tech Perfection from Under $20\"},{\"name\":\"Davide Del Zompo (tramite Presentazioni Google)\",\"email\":\"davide.delzompo@gmail.com\",\"subject\":\"industrial application - Invito a modificare\"}],"
        		+ "\"events\":null,\"user_id\":\"Davide\",\"command\":\"d\"}";  

        sock.send(j);
        sock.close();
    }
}
/*
"{\"weather\":\"\",\"temperature\":0,\"unread\":0, \"email_list\":null,\"events\":null,\"user_id\":\"\",\"command\":\"s\"}";
     
"{\"weather\":\"02\",\"temperature\":31.71,\"unread\":3,"
        		+ "\"email_list\":[{\"name\":\"GearBest.com\",\"email\":\"newsletter@edm.gearbest.com\",\"subject\":\"THE VERY BEST OF XIAOMI SALE | Tech Perfection from Under $20\"},{\"name\":\"Davide Del Zompo (tramite Presentazioni Google)\",\"email\":\"davide.delzompo@gmail.com\",\"subject\":\"industrial application - Invito a modificare\"}],"
        		+ "\"events\":null,\"user_id\":\"Davide\",\"command\":\"d\"}";      
        

"{\"weather\":\"04\",\"temperature\":18.99,\"unread\":4,\"email_list\":[{\"name\":\"Google\",\"email\":\"no-reply@accounts.google.com\",\"subject\":\"Nuovo accesso da Chrome su Mac\"},{\"name\":\"Sketchfab\",\"email\":\"notifications@sketchfab.com\",\"subject\":\"Your weekly digest\"},{\"name\":\"Sketchfab\",\"email\":\"notifications@sketchfab.com\",\"subject\":\"Some inspiration for you\"}],"
        		+ "\"events\":[{\"name\":\"ciao2\",\"time\":\"2017-06-17T07:00:00+02:00\"}],\"user_id\":\"Rossella\",\"command\":\"d\"}";




"{\"weather\":\"02\",\"temperature\":18.71,\"unread\":2," +
				"\"email_list\":[{\"name\":\"rossella carletti\",\"email\":\"carletti.rossella@gmail.com\",\"subject\":\"prova2lungalungalungalungalungalungalunga123456789012345678901234567890\"}," +
				"{\"name\":\"veronica rispo\",\"email\":\"veronica.rispo@gmail.com\",\"subject\":\"fottiti\"},{\"name\":\"veronica rispo\",\"email\":\"veronica.rispo@gmail.com\",\"subject\":\"fottiti2\"}],\"" +
				"events\":[{\"name\":\"esame xlungalungalungalungalungalungalunga123456789012345678901234567890\",\"time\":\"2017-04-03T16:00:00+02:00\"}," +
				"{\"name\":\"esame utente 2\",\"time\":\"2017-04-03T16:00:00+02:00\"},"
				+ "{\"name\":\"bla bla bla y\",\"time\":\"2017-04-03T16:00:00+02:00\"}]" +
				",\"user_id\":\"utente 2\",\"command\":\"d\"}";
*/