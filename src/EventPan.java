import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class EventPan extends JLabel{
	private static final long serialVersionUID = 1l;
	private static int index;
	private String[] eventtxt;
	private static int n;
	
	public EventPan(){
		super();
		EventPan.index=0;
		EventPan.n=0;
	}
	
	public static void StartEvent(final EventPan a, final EventPan b) {		
		new Timer(3000,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(n!=0){
					a.setText(a.eventtxt[EventPan.index]);
					b.setText(b.eventtxt[EventPan.index]);
					EventPan.index=(EventPan.index+1)%n;
				}
			}
		}).start();
	}

	public int getIndex() {
		return EventPan.index;
	}

	public void setIndex(int index) {
		EventPan.index = index;
	}

	public String[] getEventtxt() {
		return eventtxt;
	}

	public void setEventtxt(String[] eventtxt) {
		this.eventtxt = eventtxt;
	}

	public static int getN() {
		return n;
	}

	public static void setN(int n) {
		EventPan.n = n;
	}

	@Override
	public String toString() {
		int n = eventtxt.length;
		String e="";
		for(int i=0;i<n;i++)
			e=e+eventtxt[i]+" ";
		return "EventPan [index=" + index + ", eventtxt=" + e + ", n=" + n + "]";
	}	
	
	
}