package hello;

import javax.swing.*;

public class thnx {
	
	JFrame f;
	JLabel l;
	
	thnx(){
		f=new JFrame();
		f.setSize(500, 700);
		
		l=new JLabel("THANKYOU FOR SHOPPING AT TECHSHOP");
		l.setBounds(120, 200, 300, 100);
		
		f.add(l);
		
		f.setLayout(null);
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new thnx();
	}

}
