package hello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class adminchat implements ActionListener {

	JFrame f;
	JButton b1, b2, b;
	JTextArea ta;
	JTextField tf, tf2;
	JLabel l1, l2;
	//static int flag = 0;
	JScrollPane v;
	JPanel p;
	static Connection conn;
	// String i;

	// int i=0;
	static ResultSet rs;
	static PreparedStatement ps1;
	List<String> stored_messages = new ArrayList<String>();
	Thread thread = new Thread(new Thread() {
		@Override
		public void run() {
			try {

				while (true) {

					rs = ps1.executeQuery();

					while (rs.next()) {
						String user = rs.getString("username");
						String mes = rs.getString("message");

						//System.out.println(stored_messages);

						// System.out.println("THREAD RUNNING"+ " "+conn);
						// System.out.println("ADMINCHAT.JAVA"+user+" "+mes);
						if (!stored_messages.contains(mes)) {
							ta.setText(ta.getText() + "\n" + user + " : " + mes);
							stored_messages.add(mes);
							System.out.println(mes);
						}
						// Bro, error nahi thi, sirf instance ka problem tha, in
						// loop always use fresh instance of anyobject,
						// like string mes tha na, wo assign nahi ho rha tha
						// isiliye khaali aa rha tha, ya to har bar while k
						// andar use mes = new String() kar and the code chala
						// ya fir String ms= rs.getString("message");
						// second aisa kuch chahiye tha jo purane messages ka
						// track rkh ske jisse puri list na aaye...isiliye ek
						// bar dikhaye hue messaes to ek list me daal diya
						// aur har check kiya ki ane wale msg us list me hai ya
						// nahi.
						// instance of string ka problem tha CORE JAVA acha but
						// ye while true ko to theek kr YE THEEK HAI BECAUSE
						// ISKE BINA THREAD NAI CHALEGA

						// "\n"+ta.getText()+"\n"+user+" : "+mes
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	});

	/*
	 * java.sql.PreparedStatement
	 * ps3=con.prepareStatement("Select count(message) from chat"); ResultSet
	 * rs3 = ps3.executeQuery(); while(rs3.next()){
	 * i=rs3.getInt("count(message)"); } System.out.println(rs3);
	 */
	// java.sql.PreparedStatement ps2=con.prepareStatement("Select
	// count(message) from chat");
	// ResultSet rs2 = ps2.executeQuery();
	// i=rs.getString("count(message)");
	// System.out.println(i);
	// System.out.println(rs2);

	adminchat() {
		f = new JFrame();
		f.setSize(550, 700);
		// ta.setEnabled(false);
		p = new JPanel();
		p.setBounds(15, 0, 500, 400);
		// setPreferredSize(new Dimension(200, 250));
		ta = new JTextArea("CHATS :- ", 18, 28);
		ta.setEditable(false);
		v = new JScrollPane(ta);
		v.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p.add(v);
		f.add(p);
		// ta.setBounds(100, 100, 300, 200);
		// f.add(ta);

		try {
			conn = ConnectionFactory.getConnection();
			ps1 = conn.prepareStatement("Select username,message from chat");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		thread.setDaemon(false);
		thread.start();

		b = new JButton("Back");
		b.setBounds(450, 20, 70, 30);
		b.addActionListener(this);
		f.add(b);
		l2 = new JLabel("USERNAME :-");
		l2.setBounds(100, 400, 100, 30);
		tf = new JTextField();
		tf.setBounds(100, 430, 300, 30);
		l1 = new JLabel("Reply :- ");
		l1.setBounds(100, 460, 100, 30);
		tf2 = new JTextField();
		tf2.setBounds(100, 490, 300, 30);
		b1 = new JButton("SEND");
		b1.setBounds(190, 550, 100, 30);

		f.add(l2);
		f.add(tf);
		f.add(l1);
		f.add(tf2);
		f.add(b1);
		b1.addActionListener(this);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(3);

	}


 public static void main(String[] args) { new adminchat(); }


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == b) {
			this.f.dispose();
			new admin();
		}
		if (e.getSource() == b1) {
			try {

				java.sql.PreparedStatement ps2 = conn.prepareStatement("update chat set reply=? where username=?");
				ps2.setString(1, tf2.getText());
				ps2.setString(2, tf.getText());
				int rs2 = ps2.executeUpdate();
				//flag = 1;
				System.out.println(rs2);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			tf2.setText("");
		}

	}
}
