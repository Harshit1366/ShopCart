package hello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.charset.MalformedInputException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.regex.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class search  implements ActionListener,ItemListener,DocumentListener{
	
	JFrame f;
	JLabel l;
	JTextField t;
	static JButton b;
	JButton b1;
	static String note;
	static Connection conn;
    String item;
	int flag=0;
	
	public search(){
		
		f=new JFrame();
		f.setSize(300, 640);
		b1 = new JButton("Back");
		b1.setBounds(210, 20, 70, 30);
		b1.addActionListener(this);
		f.add(b1);
		l=new JLabel("Search : ");
		t=new JTextField();
		b=new JButton("SEARCH");
		
		l.setBounds(105, 40, 100, 30);
		t.setBounds(45, 80, 200, 50);
		b.setBounds(95, 160, 100, 30);
		b.addActionListener(this);
		t.getDocument().addDocumentListener(this);
		
		
		
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
				java.sql.PreparedStatement ps1 = conn.prepareStatement("Select itemname from itemdetails");
				ResultSet rs = ps1.executeQuery();
				if(rs.next()){
					rs.previous();
					while(rs.next()){
						item=rs.getString("itemname");
						Pattern p=Pattern.compile("["+item+"]*");
						Matcher m=p.matcher(t.getText());
						if(m.matches()){
						System.out.println(item);
						flag=0;
						}
						else{
							flag=1;
							
						}
					}
				}
				
				if(flag==1){
					System.out.println("No match");
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		
	}
		

	
}
	
	public static void main(String[] args) {
		new search();
	}


	@Override
	public void itemStateChanged(ItemEvent e1) {
		
	}


	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void insertUpdate(DocumentEvent arg0) {
		try {
			conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement ps1 = conn.prepareStatement("Select itemname from itemdetails");
			ResultSet rs = ps1.executeQuery();
			if(rs.next()){
				rs.previous();
				while(rs.next()){
					item=rs.getString("itemname");
					Pattern p=Pattern.compile("["+item+"]*");
					Matcher m=p.matcher(t.getText());
					if(m.matches()){
					System.out.println(item);
					flag=0;
					}
					else{
						flag=1;
						
					}
				}
			}
			
			if(flag==1){
				System.out.println("No match");
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeUpdate(DocumentEvent arg0) {
		try {
			conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement ps1 = conn.prepareStatement("Select itemname from itemdetails");
			ResultSet rs = ps1.executeQuery();
			if(rs.next()){
				rs.previous();
				while(rs.next()){
					item=rs.getString("itemname");
					Pattern p=Pattern.compile(""+item+"+");
					Matcher m=p.matcher(t.getText());
					if(m.matches()){
					System.out.println(item);
					flag=0;
					}
					else{
						flag=1;
						
					}
				}
			}
			
			if(flag==1){
				System.out.println("No match");
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
}
