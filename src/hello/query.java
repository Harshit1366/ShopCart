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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class query implements ActionListener{
	
	JFrame f;
	JButton b,b1;
	JLabel l,l2;
	JTextArea t;
	static Connection conn;
	
query(){
		
		f=new JFrame();
		f.setSize(400, 340);
		b1=new JButton("HOME");
        b1.setBounds(280, 10, 100, 30);
		l=new JLabel("Enter your query");
		l.setBounds(90, 40, 300, 40);
		t=new JTextArea();
		t.setBounds(50, 100, 250, 80);
		b=new JButton("Send query");
		b.setBounds(95, 200, 140, 30);
		l2=new JLabel("");
		l2.setBounds(20	, 240, 320, 30);
		
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
		
		new cart();
		this.f.dispose();
	
	}
	
	if(e.getSource()==b){
		try{
        	conn = ConnectionFactory.getConnection();
            java.sql.PreparedStatement ps1=conn.prepareStatement("select email from login where username=?");
            ps1.setString(1, first.a);
            
            ResultSet rs = ps1.executeQuery();
            
            if(rs.next()){
            	
            	String email=rs.getString("email");
            
            	l2.setText("            Your query is successfully sent to the admin.");
            
            	
            	Properties properties = System.getProperties();
        		properties.put("mail.smtp.auth", "true");
        		properties.put("mail.smtp.starttls.enable", "true");
        		properties.put("mail.smtp.host", "smtp.gmail.com");
        		properties.put("mail.smtp.user", "*************"); // User name
        		properties.put("mail.smtp.password", "*************"); // password
        		properties.put("mail.smtp.port", "587");
        		

        		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        			protected PasswordAuthentication getPasswordAuthentication() {
        				return new PasswordAuthentication("***************", "*************");
        			}
        		});
        		try {
        			MimeMessage message = new MimeMessage(session);
        			message.setFrom(new InternetAddress("*******************"));
        			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        			message.setSubject("Query from user : "+first.a);
        			message.setText(t.getText());
        			Transport.send(message);
        		} catch (Exception e2) {
        			e2.printStackTrace();
        		}

            	
            	
            }
            	
		}catch (Exception e1) {
			
	}
	
}

}
	
}
