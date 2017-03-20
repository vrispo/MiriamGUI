import javax.swing.*;

import java.awt.*;
import java.util.Date;
import com.google.gson.*;
//import nanomsg.pipeline.PullSocket;

public class MiriamGUI {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*PullSocket sock = new PullSocket();
		 sock.connect("tcp://localhost:6789");
	        for (int i=0; i<3; i++) {
	            System.out.println("Hello " + sock.recvString());
	        }

	        sock.close();*/

		Font fTime=new Font("Arial",Font.ITALIC, 25);
		Font fEmail=new Font("Arial",Font.ITALIC, 17);

		DatePan MDatePanel;

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

		//general configuration of all the panel
		Pan1.setBackground(Color.black);
		Pan2.setBackground(Color.black);
		Pan3.setBackground(Color.black);
		Pan4.setBackground(Color.black);
		Pan5.setBackground(Color.black);

		Pan1.setPreferredSize(new Dimension(500,100));
		Pan2.setPreferredSize(new Dimension(500,100));
		Pan3.setPreferredSize(new Dimension(500,400));
		Pan4.setPreferredSize(new Dimension(500,400));
		Pan5.setPreferredSize(new Dimension(500,50));

		//Initialization of the text area to show the email

		Pan3.setLayout(new GridLayout(20,1));
		JLabel Lemailnumber[]=new JLabel[5];
		JLabel Lemailname[]=new JLabel[5];
		JLabel Lemail[]=new JLabel[5];
		JLabel Lemailsubject[]=new JLabel[5];
		for(int i=0;i<5;i++){
			Lemailname[i]=new JLabel();
			Lemail[i]=new JLabel();
			Lemailsubject[i]=new JLabel();
			Lemailnumber[i]=new JLabel();

			Lemailname[i].setFont(fEmail);
			Lemail[i].setFont(fEmail);
			Lemailsubject[i].setFont(fEmail);
			Lemailnumber[i].setFont(fEmail);

			Lemailname[i].setBackground(Color.black);
			Lemail[i].setBackground(Color.black);
			Lemailsubject[i].setBackground(Color.black);
			Lemailnumber[i].setBackground(Color.black);

			Lemailname[i].setForeground(Color.white);
			Lemail[i].setForeground(Color.white);
			Lemailsubject[i].setForeground(Color.white);
			Lemailnumber[i].setForeground(Color.white);

			Pan3.add(Lemailnumber[i]);
			Pan3.add(Lemailname[i]);
			Pan3.add(Lemail[i]);
			Pan3.add(Lemailsubject[i]);
		}

		//Initialization of the text area to show the event
		Pan4.setLayout(new GridLayout(20,1));
		JLabel Leventname[]=new JLabel[5];
		JLabel Leventtime[]=new JLabel[5];
		JLabel Leventnumber[]=new JLabel[5];
		for(int i=0;i<5;i++){
			Leventname[i]=new JLabel();
			Leventtime[i]=new JLabel();
			Leventnumber[i]=new JLabel();

			Leventname[i].setFont(fEmail);
			Leventtime[i].setFont(fEmail);
			Leventnumber[i].setFont(fEmail);

			Leventname[i].setBackground(Color.black);
			Leventtime[i].setBackground(Color.black);
			Leventnumber[i].setBackground(Color.black);

			Leventname[i].setForeground(Color.white);
			Leventtime[i].setForeground(Color.white);
			Leventnumber[i].setForeground(Color.white);

			Pan4.add(Leventnumber[i]);
			Pan4.add(Leventname[i]);
			Pan4.add(Leventtime[i]);
		}

		Container MCont=MGUI.getContentPane();
		MCont.setBackground(Color.black);

		//layout
		GridBagLayout GBL=new GridBagLayout();
		MCont.setLayout(GBL);
		GridBagConstraints BagC=new GridBagConstraints();

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=1;
		BagC.weighty=0;
		BagC.gridx=0;
		BagC.gridy=0;
		GBL.setConstraints(Pan1, BagC);
		MCont.add(Pan1);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=1;
		BagC.weighty=0;
		BagC.gridx=1;
		BagC.gridy=0;
		GBL.setConstraints(Pan2, BagC);
		MCont.add(Pan2);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=1;
		BagC.weighty=1;
		BagC.gridx=0;
		BagC.gridy=2;
		GBL.setConstraints(Pan3, BagC);
		MCont.add(Pan3);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=1;
		BagC.weighty=1;
		BagC.gridx=1;
		BagC.gridy=2;
		GBL.setConstraints(Pan4, BagC);
		MCont.add(Pan4);

		BagC.fill=GridBagConstraints.BOTH;
		BagC.weightx=1;
		BagC.weighty=0;
		BagC.gridx=0;
		BagC.gridy=1;
		BagC.gridwidth=2;
		GBL.setConstraints(Pan5, BagC);
		MCont.add(Pan5);

		MGUI.setVisible(false);

		//JSON get
		Gson g= new Gson();
		String j="{\"weather\":\"08\",\"temperature\":18.71,\"unread\":2," +
				"\"email_list\":[{\"name\":\"rossella carletti\",\"email\":\"carletti.rossella@gmail.com\",\"subject\":\"prova2\"}," +
				"{\"name\":\"rossella carletti\",\"email\":\"carletti.rossella@gmail.com\",\"subject\":\"prova\"}],\"" +
				"events\":[{\"name\":\"esame x\",\"time\":\"21 marzo 2017 11:00\"}," +
				"{\"name\":\"esame y\",\"time\":\"27 marzo 2017 10:00\"}]" +
				",\"user_id\":\"stupido chi legge\",\"command\":\"s\"}";
		InfoGUI Minfo=(InfoGUI) g.fromJson(j, InfoGUI.class);
		System.out.println(Minfo.toString());

		if(Minfo.getCommand()=='s'){
			//Time panel
			Pan1.add(MDatePanel=new DatePan());
			MDatePanel.setFont(fTime);
			MDatePanel.setForeground(Color.white);

			//Email setting text
			int ne=Minfo.getNumberOfEmail();
			for(int i=0;i<ne;i++){
				String[] parts=Minfo.getxSendertoString(i).split(",");
				String tmpN=parts[0];
				String tmpE=parts[1];
				String tmpS=parts[2];
				String tmpNU="Unread:"+Minfo.getUnread();

				Lemailname[i].setText(tmpN);
				Lemail[i].setText(tmpE);
				Lemailsubject[i].setText(tmpS);
				if(i==0)
					Lemailnumber[i].setText(tmpNU);
			}

			//Event setting text
			int nev=Minfo.getNumberOfEvents();
			for(int i=0;i<nev;i++){
				String[] parts=Minfo.getxEventtoString(i).split(",");
				String tmpN=parts[0];
				String tmpE=parts[1];
				String tmpNU="Event number:"+nev;

				Leventname[i].setText(tmpN);
				Leventtime[i].setText(tmpE);
				if(i==0)
					Leventnumber[i].setText(tmpNU);
			}

			//hello panel
			JLabel Mhello= new JLabel();
			Date date=new Date();
			int h=date.getHours();
			String Muserinfo;
			if(h<=12)
				Muserinfo="Good Morning  "+Minfo.getClientinfo();
			else
				Muserinfo="Good Evening "+Minfo.getClientinfo();
			Mhello.setText(Muserinfo);
			Mhello.setForeground(Color.white);
			Pan5.add(Mhello);

			//meteo panel
			int currW=Integer.parseInt(Minfo.getWeather());
			System.out.println(currW);
			JLabel img;
			switch(currW){
				case 1: ImageIcon imgicon1= new ImageIcon("./img/sole.png","Sereno");
						Image x=imgicon1.getImage();
						x=x.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
						imgicon1.setImage(x);
						img= new JLabel(imgicon1);
						img.setMaximumSize(new Dimension(100,100));
					break;
				case 2:
				case 3:
				case 4: ImageIcon imgicon2= new ImageIcon("./img/solenuvole.png","Nuvoloso");
						Image x2=imgicon2.getImage();
						x2=x2.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
						imgicon2.setImage(x2);
						img= new JLabel(imgicon2);
						img.setMaximumSize(new Dimension(100,100));
					break;
				case 5:
				case 6: ImageIcon imgicon3= new ImageIcon("./img/pioggia.png","Pioggia");
						Image x3=imgicon3.getImage();
						x3=x3.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
						imgicon3.setImage(x3);
						img= new JLabel(imgicon3);
						img.setMaximumSize(new Dimension(100,100));
					break;
				case 7: ImageIcon imgicon4= new ImageIcon("./img/temporale.png","Temporale");
						Image x4=imgicon4.getImage();
						x4=x4.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
						imgicon4.setImage(x4);
						img= new JLabel(imgicon4);
						img.setMaximumSize(new Dimension(100,100));
					break;
				case 8: ImageIcon imgicon5= new ImageIcon("./img/neve.png","Neve");
						Image x5=imgicon5.getImage();
						x5=x5.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
						imgicon5.setImage(x5);
						img= new JLabel(imgicon5);
						img.setMaximumSize(new Dimension(100,100));
					break;
				case 9: ImageIcon imgicon6= new ImageIcon("./img/nebbia.jpg","Nebbia");
						Image x6=imgicon6.getImage();
						x6=x6.getScaledInstance(100, 100,Image.SCALE_DEFAULT);
						imgicon6.setImage(x6);
						img= new JLabel(imgicon6);
						img.setMaximumSize(new Dimension(100,100));
					break;
				default: img=new JLabel();
			}
			Pan2.add(img);
			MGUI.setVisible(true);
		}
	}

}
