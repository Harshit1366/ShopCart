package hello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.*;

public class cart extends JFrame implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JFrame f;
JLabel pic,l1,ln,lg;
JButton b,b2,b1,b3,b4,b5;
static Connection conn;

	cart(){
		f=new JFrame();
		f.setSize(500, 400);
		
		/*ImageIcon img=new ImageIcon(getClass().getResource("/images/cart.jpg"));
		lg=new JLabel(img);
		lg.setBounds(0, 0, 500, 500);
		f.add(lg);*/
		
		
	l1=new JLabel("Welcome to Techiez Online Shopping. You are logged in as "+first.name);
		 l1.setBounds(20, 70, 500, 30);
		 b=new JButton("WANNA HAVE A CHAT?");
		 b.setBounds(80,130,300,30);
		 b2=new JButton("LOGOUT");
		 b2.setBounds(370,20,100,30);
		 b4=new JButton("CHANGE PASSWORD");
		 b4.setBounds(20, 20, 170, 30);
		 b1=new JButton("FEEDBACK ?");
		 b1.setBounds(80, 180, 300, 30);
		 b3=new JButton("Wanna go shopping?");
		 b3.setBounds(80, 230, 300, 30);
		 b5=new JButton("Send Query?");
		 b5.setBounds(80, 280, 300, 30);
		 ln=new JLabel("");
		 ln.setBounds(20, 100, 300, 30);
				String note="";
			 try {
					conn = ConnectionFactory.getConnection();
					java.sql.PreparedStatement ps2 = conn.prepareStatement("select notice from note");
					ResultSet rs2=ps2.executeQuery();
					while(rs2.next()){
	                	   note=rs2.getString("notice");
	                	
	                   }
					
					if(!(note.equals(""))){
						 ln.setText("NOTE : "+note);
					}
			   
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
         	
         	
         
			 f.add(ln);

		f.add(l1);
		f.add(b);
		f.add(b2);
		f.add(b1);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		b.addActionListener(this);
		b2.addActionListener(this);
		b1.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new cart();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b5){
			this.f.dispose();
			new query();
			
		}
		if(e.getSource()==notice.b){
			ln=new JLabel("NOTE : "+notice.note);
         	ln.setBounds(20, 70	, 300, 40);
         	f.add(ln);
		}
		if(e.getSource()==b3){
			this.f.dispose();
			PRODUCTS P=new PRODUCTS();
			P.setVisible(true);
		}
		if(e.getSource()==b4){
		
			new chngpass();
		}
		
		if(e.getSource()==b){
			this.f.dispose();
			new chat();
		}
		else if(e.getSource()==b1){
			this.f.dispose();
			new feedback();
		}
		else if(e.getSource()==b2){
			this.f.dispose();
			new firstpage();
			try{
				conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement ps1=conn.prepareStatement("update login set logged_in = 'Inactive' where username=?");
			 ps1.setString(1, first.a);
    		 int rs1 = ps1.executeUpdate();
    		 System.out.println(rs1);
    	  }catch(Exception e1){
        	e1.printStackTrace();
        }
		}
		
	}
}
