import javax.swing.*;

import java.awt.*;
import java.util.Date;
import com.google.gson.*;
import nanomsg.exceptions.*;
import nanomsg.pipeline.PullSocket;

public class MiriamGUI {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PullSocket sock = new PullSocket();
		sock.setRecvTimeout(-1);
		sock.setSendTimeout(-1);
		 sock.bind("tcp://127.0.0.1:40000");

		Font fTime=new Font("Arial",Font.ITALIC, 30);
		Font fDate=new Font("Arial",Font.ITALIC, 15);
		Font fEmail=new Font("Arial",Font.ITALIC, 15);

		DatePan MDatePanel;
		TimePan MTimePanel;
		EmailPan MEmailPanel=new EmailPan();
		JLabel Lemailunread=new JLabel();
		EventPan MEventPanel=new EventPan();
		JLabel LeventN=new JLabel();
		
		JLabel imgemail=new JLabel();
		JLabel imgevent=new JLabel();
		JLabel Mhello= new JLabel();

		JFrame MGUI;
		MGUI= new JFrame("Miriam GUI");
		MGUI.setResizable(false);
		MGUI.setSize(900,500);

		//creation of all the panel
		JPanel Pan1=new JPanel();
		JPanel Pan2= new JPanel();
		JPanel Pan3= new JPanel();
		JPanel Pan4= new JPanel();
		JPanel Pan5= new JPanel();
		JPanel Pan6= new JPanel();
		JPanel Pan7= new JPanel();
		JPanel Pan8= new JPanel();
		JPanel Pan9= new JPanel();
		JPanel Pan10= new JPanel();

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

		//Initialization of the text area to show the email
		MEmailPanel.setBackground(Color.black);
		MEmailPanel.setForeground(Color.white);
		MEmailPanel.setFont(fEmail);
		Lemailunread.setBackground(Color.black);
		Lemailunread.setForeground(Color.white);		
		Lemailunread.setFont(fEmail);
		
		Pan3.add(MEmailPanel);	

		//Initialization of the text area to show the event
		MEventPanel.setBackground(Color.black);
		MEventPanel.setForeground(Color.white);
		MEventPanel.setFont(fEmail);
		LeventN.setBackground(Color.black);
		LeventN.setForeground(Color.white);		
		LeventN.setFont(fEmail);	

		Pan4.add(MEventPanel);	

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
		BagC.gridwidth=1;
		GBL.setConstraints(Pan1, BagC);
		MCont.add(Pan1);
		
		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=1;
		BagC.weighty=0;
		BagC.gridx=1;
		BagC.gridy=0;
		BagC.gridwidth=2;
		GBL.setConstraints(Pan9, BagC);
		MCont.add(Pan9);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=3;
		BagC.gridy=0;
		BagC.gridwidth=1;
		GBL.setConstraints(Pan2, BagC);
		MCont.add(Pan2);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=0;
		BagC.gridy=3;
		BagC.gridwidth=1;
		GBL.setConstraints(Pan7, BagC);
		MCont.add(Pan7);
		
		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=1;
		BagC.weighty=0;
		BagC.gridx=1;
		BagC.gridy=3;
		BagC.gridwidth=1;
		GBL.setConstraints(Pan3, BagC);
		MCont.add(Pan3);
		
		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=2;
		BagC.gridy=3;
		BagC.gridwidth=1;
		GBL.setConstraints(Pan8, BagC);
		MCont.add(Pan8);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=1;
		BagC.weighty=0;
		BagC.gridx=3;
		BagC.gridy=3;
		BagC.gridwidth=1;
		GBL.setConstraints(Pan4, BagC);
		MCont.add(Pan4);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=0;
		BagC.gridy=2;
		BagC.gridwidth=1;
		GBL.setConstraints(Pan5, BagC);
		MCont.add(Pan5);
		
		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=0;
		BagC.weighty=0;
		BagC.gridx=2;
		BagC.gridy=2;
		BagC.gridwidth=1;
		GBL.setConstraints(Pan10, BagC);
		MCont.add(Pan10);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=1;
		BagC.weighty=1;
		BagC.gridx=0;
		BagC.gridy=1;
		BagC.gridwidth=4;
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
		BagCpan1.weightx=0;
		BagCpan1.weighty=0;
		BagCpan1.gridx=0;
		BagCpan1.gridy=0;
		GBLpan1.setConstraints(MTimePanel, BagCpan1);
	
		BagCpan1.fill=GridBagConstraints.BOTH;
		BagCpan1.weightx=0;
		BagCpan1.weighty=0;
		BagCpan1.gridx=0;
		BagCpan1.gridy=1;
		GBLpan1.setConstraints(MDatePanel, BagCpan1);
		
		//panel7 setting
		ImageIcon imgemailico= new ImageIcon("./img/email.png","Email Icon");
		Image xemail=imgemailico.getImage();
		xemail=xemail.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		imgemailico.setImage(xemail);
		imgemail= new JLabel(imgemailico);
		imgemail.setMaximumSize(new Dimension(100,100));
		Pan7.add(imgemail);
		Pan7.setVisible(false);
		
		//panel8 setting
		ImageIcon imgeventico= new ImageIcon("./img/calendario.jpg","Calendar Icon");
		Image xevent=imgeventico.getImage();
		xevent=xevent.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		imgeventico.setImage(xevent);
		imgevent= new JLabel(imgeventico);
		imgevent.setMaximumSize(new Dimension(100,100));
		Pan8.add(imgevent);
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
		
		ImageIcon imgicon6= new ImageIcon("./img/nebbia.jpg","Nebbia");
		Image x6=imgicon6.getImage();
		x6=x6.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		imgicon6.setImage(x6);
		
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
				String tmpNU="Unread:"+Minfo.getUnread();
				Lemailunread.setText(tmpNU);
				Pan5.setVisible(true);
				
				int ne=Minfo.getNumberOfEmail();
				String[] emailtxt=new String[ne];
				for(int i=0;i<ne;i++){
					String[] parts=Minfo.getxSendertoString(i).split(",");
					String tmpEmail="<html>"+parts[0]+"<br>"+parts[1]+"<br>"+parts[2]+"<br></html>";
					emailtxt[i]=tmpEmail;			
				}
				MEmailPanel.setEmailtxt(emailtxt);
				Pan3.setVisible(true);
				if(ne>0)
					Pan7.setVisible(true);
				
				//Event setting text			
				int nev=Minfo.getNumberOfEvents();
				String tmpNev="Event:"+nev;			
				LeventN.setText(tmpNev);
				Pan10.setVisible(true);
				
				String[] eventtxt=new String[nev];
				for(int i=0;i<nev;i++){
					String[] parts=Minfo.getxEventtoString(i).split(",");
					String tmpEvent="<html>"+parts[0]+"<br>"+parts[1]+"<br></html>";
					eventtxt[i]=tmpEvent;			
				}
				MEventPanel.setEventtxt(eventtxt);
				Pan4.setVisible(true);
				if(nev>0)
					Pan8.setVisible(true);

				//hello panel
				
				Date date=new Date();
				int h=date.getHours();
				String Muserinfo;
				if(h<=12)
					Muserinfo="<html>Good Morning "+Minfo.getClientinfo()+"</html>";
				else
					Muserinfo="<html>Good Evening "+Minfo.getClientinfo()+"</html>";
				Mhello.setText(Muserinfo);
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
