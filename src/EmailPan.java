import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class EmailPan extends JLabel{
	private static final long serialVersionUID = 1l;
	private static int index;
	private String[] emailtxt;
	private static int n;
	
	public EmailPan(){
		super();
		index=0;
		n=0;
	}
	
	public static void StartEmail(final EmailPan a, final EmailPan b, final EmailPan c){
		new Timer(3000,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(n!=0){
					a.setText(a.emailtxt[index]);
					b.setText(b.emailtxt[index]);
					c.setText(c.emailtxt[index]);
					index=(index+1)%n;
				}
			}
		}).start();
	}

	public int getIndex() {
		return EmailPan.index;
	}

	public static void setIndex(int index) {
		EmailPan.index = index;
	}

	public String[] getEmailtxt() {
		return emailtxt;
	}
	
	public String getEmailtxt(int i) {
		return emailtxt[i];
	}

	public void setEmailtxt(String[] emailtxt) {
		this.emailtxt = emailtxt;
		//EmailPan.n=this.emailtxt.length;
	}

	public static int getN() {
		return n;
	}

	public static void setN(int n) {
		EmailPan.n = n;
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
