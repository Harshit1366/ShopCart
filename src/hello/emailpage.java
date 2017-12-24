package hello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

public class emailpage implements ActionListener {
	
	JFrame f;
	JButton b,b1;
	JLabel l,l2;
	JTextField t;
	static Connection conn;
	
	emailpage(){
		
		f=new JFrame();
		f.setSize(400, 320);
		b1=new JButton("HOME");
        b1.setBounds(280, 10, 100, 30);
		l=new JLabel("Enter your username");
		l.setBounds(90, 40, 300, 40);
		t=new JTextField();
		t.setBounds(50, 100, 250, 40);
		b=new JButton("Send password");
		b.setBounds(95, 180, 140, 30);
		l2=new JLabel("");
		l2.setBounds(20	, 220, 320, 30);
		
		b.addActionListener(this);
		b1.addActionListener(this);
		
		
		f.add(l);
		f.add(l2);
		f.add(t);
		f.add(b);
		f.add(b1);
		
		  f.setLayout(null);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          f.setResizable(false);
          f.setVisible(true);

		
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1){
			
			new first();
			this.f.dispose();
		
		}
		
		if(e.getSource()==b){
			try{
            	conn = ConnectionFactory.getConnection();
                java.sql.PreparedStatement ps1=conn.prepareStatement("Select name,email,password from login where username=?");
                ps1.setString(1, t.getText());
                
                ResultSet rs = ps1.executeQuery();
                
                if(rs.next()){
                	
                	String email=rs.getString("email");
                	String email1=email;
                	
                	for(int i=0;i<email1.length();i=i+2){
                		email1.replace(email1.charAt(i), '*');
                	}
                	System.out.println(email1);
                
                
                	l2.setText("            Your password is sent to your email address.");
                
                	JOptionPane.showMessageDialog(f,"Your password is sent to your email address "+email1+".\n             Please check it and login again!");
                
                	String pass=rs.getString("Password");
                	String name =rs.getString("Name");
                	
                	Properties properties = System.getProperties();
            		properties.put("mail.smtp.auth", "true");
            		properties.put("mail.smtp.starttls.enable", "true");
            		properties.put("mail.smtp.host", "smtp.gmail.com");
            		properties.put("mail.smtp.user", "harsh1366@gmail.com"); // User name
            		properties.put("mail.smtp.password", "Harshit@31"); // password
            		properties.put("mail.smtp.port", "587");
            		

            		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            			protected PasswordAuthentication getPasswordAuthentication() {
            				return new PasswordAuthentication("harsh1366@gmail.com", "Harshit@31");
            			}
            		});
            		try {
            			MimeMessage message = new MimeMessage(session);
            			message.setFrom(new InternetAddress("harsh1366@gmail.com"));
            			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            			message.setSubject("Forgot Password request!");
            			message.setText("Hello "+name+",\nYou sent a request of forgot password on techshop. Your current password is '"+pass+"'.\n\nThankyou...");
            			Transport.send(message);
            		} catch (Exception e2) {
            			e2.printStackTrace();
            		}

                	
                	
                }
                	
                else{
                	l2.setText("                       Username not found!");
                }
                
                
			}catch (Exception e1) {
				
		}
		
	}

	}}
