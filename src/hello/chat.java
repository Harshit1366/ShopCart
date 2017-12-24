package hello;

import javax.swing.*;

//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class chat implements ActionListener {
	

	JFrame f;
	JButton b1, b2, b;
	JTextArea ta;
	JTextField tf;
	JLabel l1;
	JScrollPane v;
	static Connection conn;
	JPanel p;
static PreparedStatement ps2 ;
static ResultSet rs2;
List<String> stored_messages = new ArrayList<String>();
	chat() {

		f = new JFrame();
		f.setSize(500, 500);
		String hello = "Hello " + first.name + " !";
		l1 = new JLabel(hello);
		b1 = new JButton("CHAT WITH ADMIN");
		b1.setEnabled(false);
		p = new JPanel();
		p.setBounds(100, 120, 300, 200);
		ta = new JTextArea(12, 25);
		v = new JScrollPane(ta);
		v.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p.add(v);
		f.add(p);
		
		ta.setEditable(false);
		
		tf = new JTextField();
		tf.setToolTipText("Type your message !");
		b2 = new JButton("Send");
		b = new JButton("Back");
		b.setBounds(400, 50, 80, 30);
		b.addActionListener(this);
		f.add(b);
		
		b1.setBounds(100, 100, 300, 20);
		
		tf.setBounds(100, 320, 300, 30);
		b2.setBounds(100, 350, 300, 30);
		
		
		f.add(b1);
		
		try {
			conn  =ConnectionFactory.getConnection();
			ps2= conn.prepareStatement("Select message,reply from chat where username=?");
			ps2.setString(1, first.a);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		f.add(tf);
		f.add(b2);
		
		// f.add(sb);
		//if (adminchat.flag == 1) {
			//System.out.println("FLAG TO 1");
			thread.setDaemon(false);
			thread.start();
			
		//}
		b2.addActionListener(this);
		b.addActionListener(this);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(3);
	}

	/*
	 * public static void main(String[] args) { try { conn =
	 * ConnectionFactory.getConnection(); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } new chat(); }
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) {

			// t.setDaemon(true);
			// t.start();
			ta.setText(ta.getText() + "\nYou : " + tf.getText());

			try {
				// while(true){
				
				PreparedStatement ps1 = conn
						.prepareStatement("insert into chat(username,message) values(?,?)");
				ps1.setString(1, first.a);
				ps1.setString(2, tf.getText());
				System.out.println(ps1.executeUpdate());// }
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			tf.setText("");

		}

		if (e.getSource() == b) {
			this.f.dispose();
			new cart();
		}

	}
	
 
	Thread thread = new Thread(new Thread() {
		@Override
		public void run() {

			try {

				while (true) {
					
					rs2= ps2.executeQuery();
					while (rs2.next()) {
						//System.out.println("THREAD RUNNING");
						String mess = rs2.getString("message");
						String reply = rs2.getString("reply");
						//System.out.println("CHAT.JAVA:"+mess+" "+reply);
						if(reply!=null){
						if (!stored_messages.contains(reply)) {
							ta.setText(ta.getText()+"\nADMIN : " + reply);
							stored_messages.add(reply);
						}}
						
					}
					
				
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	});

	/*
	 * Thread t=new Thread( new Thread(){
	 * 
	 * @Override public void run(){ ta.setText(ta.getText() + "\nYou : " +
	 * tf.getText());
	 * 
	 * try { // while(true){ conn = ConnectionFactory.getConnection();
	 * java.sql.PreparedStatement ps1 = conn
	 * .prepareStatement("insert into chat(username,message) values(?,?)");
	 * ps1.setString(1, first.a); ps1.setString(2, tf.getText());
	 * System.out.println(ps1.executeUpdate());//} } catch (Exception e1) {
	 * e1.printStackTrace(); } finally { ConnectionFactory.close(conn);
	 * tf.setText(""); } } });
	 */

}
