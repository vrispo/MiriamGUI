import java.awt.event.*;
import java.text.DateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class DatePan extends JLabel{
	private static final long serialVersionUID = 1l;
	private static final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALIAN);

	public DatePan(){
		super(dateFormat.format(Calendar.getInstance().getTime()));

		new Timer(1000,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String t="<html><div style= margin-left:15px; padding:10px>"+dateFormat.format(Calendar.getInstance().getTime())+"</div></html>";
				setText(t);
			}
		}).start();
	}
}
