
public class InfoGUI {
	private String weather;
	private float temperature;
	private int unread;
	private Senders []email_list;
	private Events []events;
	private String user_id;
	private char command;

	public InfoGUI(String weather,float temp, int unread, Senders[] sender,
			Events[] event, String clientinfo, char command) {
		this.weather = weather;
		this.temperature= temp;
		this.unread = unread;
		this.email_list = sender;
		this.events = event;
		this.user_id = clientinfo;
		this.command = command;
	}

	public InfoGUI(){
		this.weather = "";
		this.temperature= 0;
		this.unread = 0;
		this.email_list = null;
		this.events = null;
		this.user_id = "";
		this.command = 's';
	}

	public float getTemp() {
		return temperature;
	}


	public void setTemp(float temp) {
		this.temperature = temp;
	}


	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public int getUnread() {
		return unread;
	}

	public void setUnread(int unread) {
		this.unread = unread;
	}

	public Senders[] getSender() {
		return email_list;
	}

	public void setSender(Senders[] sender) {
		this.email_list = sender;
	}

	public Events[] getEvent() {
		return events;
	}

	public void setEvent(Events[] event) {
		this.events = event;
	}

	public String getClientinfo() {
		return user_id;
	}

	public void setClientinfo(String clientinfo) {
		this.user_id = clientinfo;
	}

	public char getCommand() {
		return command;
	}

	public void setCommand(char command) {
		this.command = command;
	}

	public int getNumberOfEmail(){
		if(email_list!=null)
			return email_list.length;
		else
			return 0;
	}

	public int getNumberOfEvents(){
		if(events!=null)
			return events.length;
		else
			return 0;
	}

	public String getxSendertoString(int i){
			if(i >= email_list.length)
				return "Email non esistente";
		return email_list[i].toString();
	}

	public String getxEventtoString(int i){
		if(i >= events.length)
			return "Event non esistente";
	return events[i].toString();
}

	public String toString() {
		int n = email_list.length;
		String e="";
		for(int i=0;i<n;i++)
			e=e+email_list[i].toString();
		return "InfoGUI [weather=" + weather + ", temp=" + temperature + ", unread="
				+ unread + ", sender=" + e + ", event=" + events
				+ ", clientinfo=" + user_id + ", command=" + command + "]";
	}


}
