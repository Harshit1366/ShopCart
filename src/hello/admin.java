package hello;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.*;
public class admin implements ActionListener{

	JFrame f;
	JButton b1,b2,b3,bl;
	JTextArea ta;
	JTextField tf;
	JLabel l1;
	static Connection conn;
	int i=0;
	
	admin(){
		f=new JFrame();
		f.setSize(400,400);
		try{
			conn = ConnectionFactory.getConnection();
		java.sql.PreparedStatement ps3=conn.prepareStatement("Select count(message) from chat");
        ResultSet rs3 = ps3.executeQuery();
        while(rs3.next()){
        	i=rs3.getInt("count(message)");
        }
        System.out.println(rs3);
		}catch(Exception e1){
	    	e1.printStackTrace();
	    }
		l1=new JLabel("... WELCOME ADMIN ...");
		l1.setBounds(120,50,160,30);
		 bl=new JButton("LOGOUT");
		 bl.setBounds(290,20,90,30);
		String chat="Chats ("+i+")";
		b1=new JButton(chat);
		b1.setBounds(100, 150, 150, 30);
		b1.addActionListener(this);
		b2=new JButton("Make Notice");
		b2.setBounds(100, 200, 150, 30);
		b2.addActionListener(this);
		b3=new JButton("Products Database");
		b3.setBounds(100,250,150,30);
		b3.addActionListener(this);
		bl.addActionListener(this);
		f.add(l1);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(bl);
		f.setLayout(null);
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			this.f.dispose();
			new adminchat();
		}
		
		if(e.getSource()==b2){
			this.f.dispose();
			new notice();
		}
		
		if(e.getSource()==b3){
			this.f.dispose();
			new prodata();
		}
		
		if(e.getSource()==bl){
			this.f.dispose();
			new firstpage();
		}
		
	}

}
