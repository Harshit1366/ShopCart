package hello;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;

public class feedback implements ActionListener{

	JFrame f;
	JLabel l,l1,l2,lb,l3,lg;
	JRadioButton r1,r2,r3,r4,r5;
	ButtonGroup bg;
	JTextArea ta;
	JButton b,b1,b2;
	static Connection conn;
	
	
	feedback(){
		
		f=new JFrame();
		f.setSize(625, 550);
		l=new JLabel("FEEDBACK");
		l.setFont(new Font("TimesRoman",Font.BOLD,25));
		b2=new JButton("BACK");
		lb=new JLabel("All fields marked with * are mandatory.");
		l1=new JLabel("1. How do you feel about the service you received? *");
		r1=new JRadioButton("Very satsified");
		r2=new JRadioButton("Satisfied");
		r3=new JRadioButton("Neither satisfied or dissatisfied");
		r4=new JRadioButton("Dissatisfied");
		r5=new JRadioButton("Very dissatisfied");
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);
		bg.add(r5);
		l2=new JLabel("2. How could we improve this service? (Limit : 100 words) *");
		ta=new JTextArea();
		b=new JButton("SUBMIT");
		b1=new JButton("Count");
		ImageIcon img=new ImageIcon(getClass().getResource("/images/feedback1.jpg"));
		
		lg=new JLabel(img);
		lg.setBounds(0, 0, 625, 550);
		//String text=ta.getText();
		l3=new JLabel();
	    
		//String words[]=text.split("\\s");  
		//l3=new JLabel("Words : "+words.length);
		l3.setBounds(440,330,100,20);
		
		
		
		
		//lg.setIcon(new javax.swing.ImageIcon(getClass().getResource("\images\feedback.jpg")));
		l.setBounds(210, 10, 150, 100);
		lb.setBounds(80, 110, 300, 30);
		l1.setBounds(100, 160, 300, 30);
		r1.setBounds(100, 190, 300, 20);
		r2.setBounds(100, 210, 300, 20);
		r3.setBounds(100, 230, 300, 20);
		r4.setBounds(100, 250, 300, 20);
		r5.setBounds(100, 270, 300, 20);
		l2.setBounds(100, 300, 400, 30);
		ta.setBounds(100, 350, 400,100);
		b.setBounds(230,470,100,30);
		b1.setBounds(520, 370, 80, 30);
		b2.setBounds(515, 30, 80, 30);
		
		f.add(l);
		f.add(l1);
		f.add(l2);
		f.add(lb);
		f.add(r1);
		f.add(r2);
		f.add(r3);
		f.add(r4);
		f.add(r5);
		f.add(ta);
		f.add(b);
		f.add(l3);
		f.add(b1);
		f.add(b2);
		f.add(lg);
		
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		f.setLayout(null);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b2){
			this.f.dispose();
			new cart();
		}
		
		if(e.getSource()==b1){
		l3.setText("Words : "+String.valueOf(ta.getText().split("\\s").length));
		}
		
		if(e.getSource()==b){
			if(!r1.isSelected() && !r2.isSelected() && !r3.isSelected() && !r4.isSelected() && !r5.isSelected()){
				JOptionPane.showMessageDialog(f,"Please select your reaction about service received.");  
			}
			else if(ta.getText().equals("")){
				JOptionPane.showMessageDialog(f,"Please fill your response about improvement."); 
			}
			else{
	try {
		conn = ConnectionFactory.getConnection();
		java.sql.PreparedStatement ps1 = conn.prepareStatement(
				"insert into feedback values(?,?,?)");
		ps1.setString(1, first.a);
		
		if(r1.isSelected()){
		ps1.setString(2, r1.getText());
		}
		else if(r2.isSelected()){
			ps1.setString(2, r2.getText());
		}
		else if(r3.isSelected()){
			ps1.setString(2, r3.getText());
		}
		else if(r4.isSelected()){
			ps1.setString(2, r4.getText());
		}
		else if(r5.isSelected()){
			ps1.setString(2, r5.getText());
		}
		
		ps1.setString(3, ta.getText());
		
		
		System.out.println(ps1.executeUpdate());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	
		
		JOptionPane.showMessageDialog(f, "You have submitted your feedback successfully!");
			}
		}}
	
	
	public static void main(String[] args) {
		new feedback();
	}
	
}
