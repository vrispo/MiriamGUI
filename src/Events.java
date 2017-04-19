import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;


public class Events {
	private String name;
	private Date time;

	public Events(String name, Date time) {
		this.name = name;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String toString() {
		DateFormat sdf=DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.ITALIAN);
		return name + "," + sdf.format(time);
	}

}
