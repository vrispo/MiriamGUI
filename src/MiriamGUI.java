import javax.swing.*;

import java.awt.*;
import java.util.Date;
import com.google.gson.*;
//import nanomsg.exceptions.*;
import nanomsg.pipeline.PullSocket;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;

public class MiriamGUI {
	static GraphicsDevice device = GraphicsEnvironment
	        .getLocalGraphicsEnvironment().getScreenDevices()[0];
	
	public static void main(String[] args) {

		PullSocket sock = new PullSocket();
		sock.setRecvTimeout(-1);
		sock.setSendTimeout(-1);
		sock.bind("tcp://127.0.0.1:40000");

		Font fTime=new Font("Arial",Font.ITALIC, 40);
		Font fDate=new Font("Arial",Font.ITALIC, 15);
		Font fEmail=new Font("Arial",Font.ITALIC, 15);
		Font fTemp=new Font("Arial",Font.ITALIC, 40);
		
		DatePan MDatePanel;
		TimePan MTimePanel;
		
		EmailPan EmailName=new EmailPan();
		EmailPan EmailSubject=new EmailPan();
		EmailPan Email=new EmailPan();
		EmailPan.StartEmail(Email, EmailName, EmailSubject);		
		JLabel Lemailunread=new JLabel();
		
		EventPan EventName=new EventPan();	
		EventPan EventTime=new EventPan();
		EventPan.StartEvent(EventName, EventTime);
		JLabel LeventN=new JLabel();
		
		JLabel Ltemp=new JLabel();		
		JLabel imgemail=new JLabel();
		JLabel imgname=new JLabel();
		JLabel imgsubj=new JLabel();
		JLabel imgevent=new JLabel();
		JLabel imgtime=new JLabel();
		JLabel Mhello= new JLabel();

		JFrame MGUI;
		//Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		MGUI= new JFrame("Miriam GUI");
		MGUI.setResizable(false);
		//MGUI.setSize(1200,900);
		MGUI.setUndecorated(true);
		device.setFullScreenWindow(MGUI);
		//MGUI.set(JFrame.MAXIMIZED_BOTH);
		MGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//creation of all the panel
		JPanel Pan1=new JPanel(new FlowLayout(FlowLayout.LEFT)); //date-time panel
		JPanel Pan2= new JPanel(new FlowLayout(FlowLayout.RIGHT)); //meteo panel
		JPanel Pan3= new JPanel(); //email text
		JPanel Pan4= new JPanel(); //event text
		JPanel Pan5= new JPanel(new FlowLayout(FlowLayout.CENTER)); //title mail
		JPanel Pan6= new JPanel();
		JPanel Pan7= new JPanel(); //email ico
		JPanel Pan8= new JPanel(); //event ico
		JPanel Pan9= new JPanel(); //hello panel
		JPanel Pan10= new JPanel(new FlowLayout(FlowLayout.CENTER)); //title event

		//general configuration of all the panel
		Pan1.setBackground(Color.black);
		Pan2.setBackground(Color.black);
		Pan3.setBackground(Color.black);
		Pan4.setBackground(Color.black);
		Pan5.setBackground(Color.black);
		Pan6.setBackground(Color.black);
		Pan7.setBackground(Color.black);
		Pan8.setBackground(Color.black);
		Pan9.setBackground(Color.black);
		Pan10.setBackground(Color.black);
		
		Pan1.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));//top-left-bottom-right
		Pan2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 70));
		
		Pan3.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		Pan4.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 70));
		Pan7.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		Pan8.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		Pan10.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 70));
		
		Pan3.setPreferredSize(new Dimension(400,150));
		Pan4.setPreferredSize(new Dimension(400,150));

		//Initialization of the text area to show the email
		EmailName.setBackground(Color.black);
		EmailName.setForeground(Color.white);
		EmailName.setFont(fEmail);
		EmailSubject.setBackground(Color.black);
		EmailSubject.setForeground(Color.white);
		EmailSubject.setFont(fEmail);
		Email.setBackground(Color.black);
		Email.setForeground(Color.white);
		Email.setFont(fEmail);
		Lemailunread.setBackground(Color.black);
		Lemailunread.setForeground(Color.white);		
		Lemailunread.setFont(fEmail);
		
		Lemailunread.setHorizontalAlignment(Label.LEFT);
		Lemailunread.setBackground(Color.GREEN);
		
		Pan3.setLayout(new GridLayout(3,1));	
		Pan3.add(Email);
		Pan3.add(EmailName);
		Pan3.add(EmailSubject);

		//Initialization of the text area to show the event
		EventName.setBackground(Color.black);
		EventName.setForeground(Color.white);
		EventName.setFont(fEmail);
		EventTime.setBackground(Color.black);
		EventTime.setForeground(Color.white);
		EventTime.setFont(fEmail);
		LeventN.setBackground(Color.black);
		LeventN.setForeground(Color.white);		
		LeventN.setFont(fEmail);	

		Pan4.setLayout(new GridLayout(3,1));
		Pan4.add(EventName);
		Pan4.add(EventTime);	

		Container MCont=MGUI.getContentPane();
		MCont.setBackground(Color.black);

		Pan5.add(Lemailunread);
		
		Mhello.setForeground(Color.white);
		Pan9.add(Mhello);
		
		Pan10.add(LeventN);
		
		//layout
		GridBagLayout GBL=new GridBagLayout();
		MCont.setLayout(GBL);
		GridBagConstraints BagC=new GridBagConstraints();

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=0;
		BagC.gridy=0;
		BagC.gridwidth=2;
		GBL.setConstraints(Pan1, BagC);
		MCont.add(Pan1);
		
		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=1;
		BagC.weighty=0;
		BagC.gridx=2;
		BagC.gridy=0;
		BagC.gridwidth=1;
		GBL.setConstraints(Pan9, BagC);
		MCont.add(Pan9);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=3;
		BagC.gridy=0;
		BagC.gridwidth=2;
		GBL.setConstraints(Pan2, BagC);
		MCont.add(Pan2);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=0;
		BagC.gridy=3;
		BagC.gridwidth=1;
		BagC.insets.left=10;
		GBL.setConstraints(Pan7, BagC);
		MCont.add(Pan7);
		
		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=1;
		BagC.gridy=3;
		BagC.gridwidth=1;
		GBL.setConstraints(Pan3, BagC);
		MCont.add(Pan3);
		
		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=3;
		BagC.gridy=3;
		BagC.gridwidth=1;
		GBL.setConstraints(Pan8, BagC);
		MCont.add(Pan8);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=4;
		BagC.gridy=3;
		BagC.gridwidth=1;
		GBL.setConstraints(Pan4, BagC);
		MCont.add(Pan4);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=0;
		BagC.gridy=2;
		BagC.gridwidth=2;
		BagC.anchor=GridBagConstraints.WEST;
		GBL.setConstraints(Pan5, BagC);
		MCont.add(Pan5);
		
		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=3;
		BagC.gridy=2;
		BagC.gridwidth=2;
		BagC.anchor=GridBagConstraints.WEST;
		GBL.setConstraints(Pan10, BagC);
		MCont.add(Pan10);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=1;
		BagC.weighty=1;
		BagC.gridx=0;
		BagC.gridy=1;
		BagC.gridwidth=5;
		GBL.setConstraints(Pan6, BagC);
		MCont.add(Pan6);
		
		//DateTime panel setting
		Pan1.add(MTimePanel=new TimePan());
		MTimePanel.setFont(fTime);
		MTimePanel.setForeground(Color.white);
		Pan1.add(MDatePanel=new DatePan());
		MDatePanel.setFont(fDate);
		MDatePanel.setForeground(Color.white);
	
		GridBagLayout GBLpan1=new GridBagLayout();
		Pan1.setLayout(GBLpan1);
		GridBagConstraints BagCpan1=new GridBagConstraints();
	
		BagCpan1.fill=GridBagConstraints.BOTH;
		BagCpan1.weightx=1;
		BagCpan1.weighty=0;
		BagCpan1.gridx=0;
		BagCpan1.gridy=0;
		GBLpan1.setConstraints(MTimePanel, BagCpan1);
	
		BagCpan1.fill=GridBagConstraints.BOTH;
		BagCpan1.weightx=1;
		BagCpan1.weighty=0;
		BagCpan1.gridx=0;
		BagCpan1.gridy=1;
		GBLpan1.setConstraints(MDatePanel, BagCpan1);
		
		//panel7 setting
		Pan7.setLayout(new GridLayout(3,1));
		ImageIcon imgnameico= new ImageIcon("./img/name.png","Name Icon");
		Image xname=imgnameico.getImage();
		xname=xname.getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		imgnameico.setImage(xname);
		imgname= new JLabel(imgnameico);
		imgname.setMaximumSize(new Dimension(20,20));
		Pan7.add(imgname);
		
		ImageIcon imgemailico= new ImageIcon("./img/email.png","Email Icon");
		Image xemail=imgemailico.getImage();
		xemail=xemail.getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		imgemailico.setImage(xemail);
		imgemail= new JLabel(imgemailico);
		imgemail.setMaximumSize(new Dimension(20,20));
		Pan7.add(imgemail);
		
		ImageIcon imgsubjico= new ImageIcon("./img/subject.png","Subject Icon");
		Image xsubj=imgsubjico.getImage();
		xsubj=xsubj.getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		imgsubjico.setImage(xsubj);
		imgsubj= new JLabel(imgsubjico);
		imgsubj.setMaximumSize(new Dimension(20,20));
		imgsubj.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		Pan7.add(imgsubj);
		
		Pan7.setVisible(false);
		
		//panel8 setting
		Pan8.setLayout(new GridLayout(3,1));
		ImageIcon imgeventico= new ImageIcon("./img/date.png","Date Icon");
		Image xevent=imgeventico.getImage();
		xevent=xevent.getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		imgeventico.setImage(xevent);
		imgevent= new JLabel(imgeventico);
		imgevent.setMaximumSize(new Dimension(20,20));
		Pan8.add(imgevent);
		
		ImageIcon imgtimeico= new ImageIcon("./img/time.png","Time Icon");
		Image xtime=imgtimeico.getImage();
		xtime=xtime.getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		imgtimeico.setImage(xtime);
		imgtime= new JLabel(imgtimeico);
		imgtime.setMaximumSize(new Dimension(20,20));
		Pan8.add(imgtime);
		Pan8.setVisible(false);
		
		//meteoicon
		JLabel meteoimg;
		meteoimg= new JLabel();
		meteoimg.setMaximumSize(new Dimension(100,100));
		
		ImageIcon imgicon1= new ImageIcon("./img/sole.png","Sereno");
		Image x=imgicon1.getImage();
		x=x.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		imgicon1.setImage(x);
		
		ImageIcon imgicon2= new ImageIcon("./img/solenuvole.png","Nuvoloso");
		Image x2=imgicon2.getImage();
		x2=x2.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		imgicon2.setImage(x2);
		
		ImageIcon imgicon3= new ImageIcon("./img/pioggia.png","Pioggia");
		Image x3=imgicon3.getImage();
		x3=x3.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		imgicon3.setImage(x3);
		
		ImageIcon imgicon4= new ImageIcon("./img/temporale.png","Temporale");
		Image x4=imgicon4.getImage();
		x4=x4.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		imgicon4.setImage(x4);
		
		ImageIcon imgicon5= new ImageIcon("./img/neve.png","Neve");
		Image x5=imgicon5.getImage();
		x5=x5.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		imgicon5.setImage(x5);
		
		ImageIcon imgicon6= new ImageIcon("./img/nebbia.png","Nebbia");
		Image x6=imgicon6.getImage();
		x6=x6.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		imgicon6.setImage(x6);
		
		Pan2.add(Ltemp);
		Ltemp.setFont(fTemp);
		Ltemp.setForeground(Color.white);
		Pan2.add(meteoimg);
		
		Pan1.setVisible(false);
		Pan2.setVisible(false);
		Pan3.setVisible(false);
		Pan4.setVisible(false);
		Pan4.setVisible(false);
		Pan5.setVisible(false);
		Pan6.setVisible(false);
		Pan7.setVisible(false);
		Pan8.setVisible(false);
		Pan9.setVisible(false);
		Pan10.setVisible(false);
		MGUI.setVisible(true);
		while(true){	
			//JSON get
			String jnew=sock.recvString();
		
			System.out.println(jnew);
			Gson g= new Gson();

			InfoGUI Minfo=(InfoGUI) g.fromJson(jnew, InfoGUI.class);
			System.out.println(Minfo.toString());

			if(Minfo.getCommand()=='d'){
				
				Pan1.setVisible(true);
				Pan6.setVisible(true);
				//Email setting text
				String tmpNU="<html><text aling=left>YOU HAVE "+Minfo.getUnread()+" UNREAD MAIL:</text></html>";
				Lemailunread.setText(tmpNU);
				Pan5.setVisible(true);
				
				int ne=Minfo.getNumberOfEmail();
				String[] emailtxt=new String[ne];
				String[] nametxt=new String[ne];
				String[] subjecttxt=new String[ne];
				for(int i=0;i<ne;i++){
					String[] parts=Minfo.getxSendertoString(i).split(",");
					emailtxt[i]=parts[0];	
					nametxt[i]=parts[1];
					subjecttxt[i]=parts[2];
				}
				Email.setEmailtxt(emailtxt);
				EmailName.setEmailtxt(nametxt);
				EmailSubject.setEmailtxt(subjecttxt);
				EmailPan.setN(ne);
				Pan3.setVisible(true);
				if(ne>0)
					Pan7.setVisible(true);
				
				//Event setting text			
				int nev=Minfo.getNumberOfEvents();
				String tmpNev=nev+" UPCOMING EVENTS:";
				LeventN.setText(tmpNev);
				Pan10.setVisible(true);
				
				String[] eventntxt=new String[nev];
				String[] eventttxt=new String[nev];
				for(int i=0;i<nev;i++){
					String[] parts=Minfo.getxEventtoString(i).split(",");
					eventntxt[i]=parts[0];	
					eventttxt[i]=parts[1];
				}
				EventName.setEventtxt(eventntxt);
				EventTime.setEventtxt(eventttxt);
				EventPan.setN(nev);
				Pan4.setVisible(true);
				if(nev>0)
					Pan8.setVisible(true);

				//hello panel
				
				Date date=new Date();
				int h=date.getHours();
				String Muserinfo;
				if(h<=12)
					Muserinfo="Good Morning "+Minfo.getClientinfo();
				else
					Muserinfo="Good Evening "+Minfo.getClientinfo();
				Mhello.setText(Muserinfo.toUpperCase());
				Pan9.setVisible(true);
	
				//meteo panel
				int currW=Integer.parseInt(Minfo.getWeather());
				System.out.println(currW);
				switch(currW){
					case 1: meteoimg.setIcon(imgicon1);
						break;
					case 2:
					case 3:
					case 4: meteoimg.setIcon(imgicon2);
						break;
					case 5:
					case 6: meteoimg.setIcon(imgicon3);
						break;
					case 7: meteoimg.setIcon(imgicon4);
						break;
					case 8: meteoimg.setIcon(imgicon5);
						break;
					case 9: meteoimg.setIcon(imgicon6);
						break;
					default:
				}
				String t=Minfo.getTemp()+"°";
				Ltemp.setText(t);
				Pan2.setVisible(true);
			}
			else{
				Pan1.setVisible(false);
				Pan2.setVisible(false);
				Pan3.setVisible(false);
				Pan4.setVisible(false);
				Pan4.setVisible(false);
				Pan5.setVisible(false);
				Pan6.setVisible(false);
				Pan7.setVisible(false);
				Pan8.setVisible(false);
				Pan9.setVisible(false);
				Pan10.setVisible(false);
			}
		}
	}

}
