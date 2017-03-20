
public class Senders {
	private String name;
	private String email;
	private String subject;

	public Senders(String n, String e, String o){
		this.name=n;
		this.email=e;
		this.subject=o;
	}

	public Senders(){
		this.name="";
		this.email="";
		this.subject="";
	}

	public String getName(){
		return this.name;
	}

	public String getEmail(){
		return this.email;
	}

	public String getObject(){
		return this.subject;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setObject(String object) {
		this.subject = object;
	}

	public String toString() {
		return "name:" + name + ",email: " + email + ",subject:"
				+ subject;
	}

}
