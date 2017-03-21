import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class EventPan extends JLabel{
	private static final long serialVersionUID = 1l;
	private int index;
	private String[] eventtxt;
	private int n;
	
	public EventPan(){
		super();
		index=0;
		n=0;
		
		new Timer(3500,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(n!=0){
					setText(eventtxt[index]);
					index=(index+1)%n;
				}
			}
		}).start();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String[] getEventtxt() {
		return eventtxt;
	}

	public void setEventtxt(String[] eventtxt) {
		this.eventtxt = eventtxt;
		this.n=this.eventtxt.length;
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