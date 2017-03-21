import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class EmailPan extends JLabel{
	private static final long serialVersionUID = 1l;
	private int index;
	private String[] emailtxt;
	private int n;
	
	public EmailPan(){
		super();
		index=0;
		n=0;
		
		new Timer(3500,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(n!=0){
					setText(emailtxt[index]);
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

	public String[] getEmailtxt() {
		return emailtxt;
	}

	public void setEmailtxt(String[] emailtxt) {
		this.emailtxt = emailtxt;
		this.n=this.emailtxt.length;
	}

	@Override
	public String toString() {
		int n = emailtxt.length;
		String e="";
		for(int i=0;i<n;i++)
			e=e+emailtxt[i]+" ";
		return "EmailPan [index=" + index + ", emailtxt=" + e + ", n=" + n + "]";
	}	
	
	
}
