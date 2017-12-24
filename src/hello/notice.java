package hello;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;
public class notice implements ActionListener{

	JFrame f;
	JLabel l;
	JTextField t;
	static JButton b;
	JButton b1;
	static String note;
	static Connection conn;
	
	notice(){
		
		f=new JFrame();
		f.setSize(300, 240);
		b1 = new JButton("Back");
		b1.setBounds(210, 20, 70, 30);
		b1.addActionListener(this);
		f.add(b1);
		l=new JLabel("Enter notice");
		t=new JTextField();
		b=new JButton("Announce");
		
		l.setBounds(105, 40, 100, 30);
		t.setBounds(45, 80, 200, 50);
		b.setBounds(95, 160, 100, 30);
		b.addActionListener(this);
		
		note=t.getText();
		
		f.add(l);
		f.add(t);
		f.add(b);
		
		f.setLayout(null);
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == b1) {
			this.f.dispose();
			new admin();
		}
		if(e.getSource()==b){
			
			try {
				conn = ConnectionFactory.getConnection();
				java.sql.PreparedStatement ps1 = conn.prepareStatement("insert into note values(?)");
			
				ps1.setString(1, t.getText());
				
				System.out.println(ps1.executeUpdate());
				JOptionPane.showMessageDialog(f, "Announcemnt made successfully!");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			//JLabel ln=new JLabel("NOTE : "+note);
			//ln.setBounds(20, 70	, 300, 40);
			//new cart().f.add(ln);
		}
		
	}
	
	/*public static void main(String[] args) {
		new notice();
	}*/
}
