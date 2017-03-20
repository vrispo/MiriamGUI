import java.awt.event.*;
import java.text.DateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class DatePan extends JLabel{
	private static final long serialVersionUID = 1l;
	private static final DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, Locale.ITALIAN);

	public DatePan(){
		super(dateFormat.format(Calendar.getInstance().getTime()));

		new Timer(1000,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setText(dateFormat.format(Calendar.getInstance().getTime()));
			}
		}).start();
	}
}