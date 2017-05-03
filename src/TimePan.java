import java.awt.event.*;
import java.text.DateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TimePan extends JLabel{
	private static final long serialVersionUID = 1l;
	private static final DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.FRANCE);

	public TimePan(){
		super(dateFormat.format(Calendar.getInstance().getTime()));
		new Timer(1000,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//String t="<html><div style= margin-left:15px; padding:10px>"+dateFormat.format(Calendar.getInstance().getTime())+"</div></html>";
				String t=dateFormat.format(Calendar.getInstance().getTime());
				setText(t);
			}
		}).start();
	}
}