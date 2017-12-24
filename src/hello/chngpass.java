package hello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class chngpass implements ActionListener {
	
	JFrame f;
	JLabel l,l2;
	JPasswordField t,t2;
	JButton b;
	static Connection conn;
	
	chngpass(){
		
		f=new JFrame();
		f.setSize(380,300);
		
		l=new JLabel("New Password : ");
		t=new JPasswordField();
		l2=new JLabel("Confirm Password : ");
		t2=new JPasswordField();
		
		b= new JButton("CHANGE PASSWORD");
		
		l.setBounds(30, 40, 130, 30);
		t.setBounds(150, 40, 150, 30);
		l2.setBounds(30, 100, 130, 30);
		t2.setBounds(150, 100, 150, 30);
		b.setBounds(80, 180, 180, 30);
		b.addActionListener(this);
		
		
		f.add(l);
		f.add(t);
		f.add(l2);
		f.add(t2);
		f.add(b);
		
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new chngpass();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b){
			
			String pas="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
			Pattern p3=Pattern.compile(pas);
			Matcher m4=p3.matcher(t.getText());
			if(!m4.matches()){
				JOptionPane.showMessageDialog(f,"Enter a valid password! Password must consist of atleast "
						+ "8 characters, 1 uppercase, 1 lowercase, 1 numeral & 1 special symbol and should be "
						+ "without any blanks.","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(! t.getText().equals(t2.getText())){
				
				JOptionPane.showMessageDialog(f,"Passwords doesn't match !","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else{
			try{
				conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement ps1=conn.prepareStatement("update login set password = ? where username=?");
			 ps1.setString(1, t.getText());
			 ps1.setString(2, first.a);
    		 int rs1 = ps1.executeUpdate();
    		 System.out.println(rs1);
    		 JOptionPane.showMessageDialog(f,"Password updated successfully !");
    	  }catch(Exception e1){
        	e1.printStackTrace();
        }
		}
		}
	}

}
