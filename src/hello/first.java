package hello;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.*;

//import org.omg.CORBA.portable.InputStream;

                                                                                                                     
public class first extends JFrame implements ActionListener {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton b1,b2,b,b3;
JTextField t1;
JLabel l1,l2,l3,lg;
JPasswordField t2;
static JFrame f;
static firstpage fp;
static String a;
static String name;
String type[]={"--- Select type ---","ADMIN","USER"};
JComboBox c1;
static Connection conn;


public void setfp(firstpage f) {
	fp = f;
}

public firstpage getfp() {
	return fp;
}
    first(){
        
            f=new JFrame();
            f.setSize(300,300);
            b=new JButton("HOME");
            b.setBounds(190, 10, 100, 30);
            l1=new JLabel("Username");
            l1.setBounds(20, 70, 80, 40);
            t1=new JTextField();
            t1.setBounds(100, 70, 80, 40);
            l2=new JLabel("Password");
            l2.setBounds(20, 120, 80, 40);
            t2=new JPasswordField();
            t2.setBounds(100, 120, 80, 40);
            t2.setToolTipText("Enter your Password");  
            b1=new JButton("Submit");
            b1.setBounds(20, 170, 80, 40);
            b2=new JButton("Cancel");
            b2.setBounds(130, 170, 80, 40);
            b3=new JButton("Forgot password?");
            b3.setBounds(40, 230, 180, 40);
            l3=new JLabel("");
            l3.setBounds(50,180,140,40);
            
            
            
            ImageIcon img=new ImageIcon(getClass().getResource("/images/login.jpg"));
    		lg=new JLabel(img);
    		lg.setBounds(0, 0, 300, 300);
            
            c1=new JComboBox(type);
            c1.setBounds(30,20,120,35);
         
            f.add(l1);
            f.add(l2);
            f.add(b1);
            f.add(b2);
            f.add(t1);
            f.add(t2);
            f.add(l3);
            f.add(b);
            f.add(c1);
            f.add(lg);
            f.add(b3);
            b1.addActionListener(this);
            b2.addActionListener(this);
            b3.addActionListener(this);
            b.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				new firstpage();
    				first.f.dispose();
    			}
    		});
            f.setLayout(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setResizable(false);
            f.setVisible(true);
        }
        

   
        @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==b1){
            	if(t1.getText().equals("") && t2.getText().equals("")){
            		JOptionPane.showMessageDialog(f,"Please fill your username and password.");
            	}
            	else if(t1.getText().equals("")){
            		JOptionPane.showMessageDialog(f,"Please fill your username.");
            	}
            	else if(t2.getText().equals("")){
            		JOptionPane.showMessageDialog(f,"Please fill your paasword.");
            	}
            	else if(c1.getSelectedItem().toString().equals("--- Select type ---")){
            		JOptionPane.showMessageDialog(f,"Please select your type.");
            	}
            	if(c1.getSelectedItem().toString().equals("ADMIN")){
            		if(t1.getText().equals("admin") && t2.getText().equals("admin")){
                		JOptionPane.showMessageDialog(f,"LOGIN SUCCESSFULL ADMIN ! ");
                		first.f.dispose();
                		new admin();
                	}
            	}
            	
            	else if(c1.getSelectedItem().toString().equals("USER")){
                try{
                	conn = ConnectionFactory.getConnection();
                    java.sql.PreparedStatement ps1=conn.prepareStatement("Select * from login where username=? and password=?");
                    	ps1.setString(1,t1.getText());
                    	ps1.setString(2,t2.getText());
                    	ResultSet rs = ps1.executeQuery();
                    	//t1.setText("");
                    	//t2.setText("");
                    	
                    	if(rs.next()){
                   a=t1.getText();
                   System.out.println(a);
                   java.sql.PreparedStatement ps2=conn.prepareStatement("Select name from login where username=?");
                   ps2.setString(1, a);
                   ResultSet rs2 = ps2.executeQuery();
                   while(rs2.next()){
                	   name=rs.getString("name");
                	
                   }
                   System.out.println(name);
                    		
                    		JOptionPane.showMessageDialog(f,"LOGIN SUCCESSFULL !");
                    		first.f.dispose();
            				new cart();
                    		 java.sql.PreparedStatement ps3=conn.prepareStatement("update login set logged_in = 'Active' where username=?");
                    		 ps3.setString(1, a);
                    		 int rs3 = ps3.executeUpdate();
                    		 System.out.println(rs3);
                    	} else {
                    		
                    		JOptionPane.showMessageDialog(f,"LOGIN FAILED !");
                    		
                    	}
                 
                }catch(Exception e1){
                	e1.printStackTrace();
                }}}
                
            else if (e.getSource()==b2)
                {
                	t1.setText("");
                	t2.setText("");
                	JOptionPane.showMessageDialog(f,"Sign In Cancelled!");
                }
            
            else if(e.getSource()==b3){
            	new emailpage();
				first.f.dispose();
            }
           
    }

		
}
