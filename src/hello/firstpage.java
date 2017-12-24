package hello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class firstpage extends JFrame implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JButton b1,b2;
	JLabel l1,lg;
	JFrame f;
	firstpage page;
	    firstpage(){
	        
	    	f=new JFrame();
	            f.setSize(300,400);
	            ImageIcon img=new ImageIcon(getClass().getResource("/images/shop.jpg"));
                lg=new JLabel(img);
	    		lg.setBounds(0, 0, 300, 400);
	    		f.add(lg);
	    		
	            b1=new JButton("SIGN UP");
	            b1.setBounds(20, 120, 80, 40);
	            b2=new JButton("SIGN IN");
	            b2.setBounds(170, 120, 80, 40);
	            
	            l1=new JLabel("WELCOME TO TECHSHOP");
	            l1.setBounds(60,10,180,40);
	            f.add(l1);
	            f.add(b1);
	            f.add(b2);
	            
	            b1.addActionListener(this);
	            b2.addActionListener(this);
	            f.setLayout(null);
	            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            f.setResizable(false);
	            f.setVisible(true);
	        }
	        
	    public static void main(String args[]){
	    fp= new firstpage();
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1){
				this.f.dispose();	
				r = new reg();
				r.setfp(fp);
			}
			else if(e.getSource()==b2)
			{
				
				this.f.dispose();	
				fr=new first();
				fr.setfp(fp);
	
			}
			
		}
		
		static first fr;
		static reg r ;
		static firstpage fp ;
		
}
