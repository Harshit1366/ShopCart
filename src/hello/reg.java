package hello;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.regex.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;


public class reg extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b1, b2, b,b3;
	JTextField t1, t2, t3, t4, t5;
	JLabel l1, l2, l3, l4, l5, l6,pic,lg;
	JPasswordField t6;
	static firstpage fp;
	String path,user;
	JFrame f;
	static Connection conn;
	Border blackline;

	public void setfp(firstpage f) {
		fp = f;
	}

	public firstpage getfp() {
		return fp;
	}

	

	reg() {

	f = new JFrame();
		f.setSize(700, 500);
		//ImageIcon img=new ImageIcon(getClass().getResource("/images/register.png"));
        //lg=new JLabel(img);
		//lg.setBounds(0, 0, 700, 500);
		//f.add(lg);
		b = new JButton("HOME");
		b.setBounds(590, 10, 100, 40);
		l1 = new JLabel("Name : ");
		l1.setBounds(20, 20, 100, 40);
		t1 = new JTextField(25);
		t1.setBounds(140, 20, 120, 40);
		l2 = new JLabel("Email Address : ");
		l2.setBounds(20, 70, 100, 40);
		t2 = new JTextField();
		t2.setBounds(140, 70, 120, 40);
		l3 = new JLabel("City : ");
		l3.setBounds(20, 120, 100, 40);
		t3 = new JTextField(20);
		t3.setBounds(140, 120, 120, 40);
		l4 = new JLabel("Contact No : ");
		l4.setBounds(20, 170, 100, 40);
		t4 = new JTextField(10);
		t4.setBounds(140, 170, 120, 40);
		l5 = new JLabel("Username : ");
		l5.setBounds(20, 220, 100, 40);
		t5 = new JTextField();
		t5.setBounds(140, 220, 120, 40);
		l6 = new JLabel("Password : ");
		l6.setBounds(20, 270, 100, 40);
		t6 = new JPasswordField();
		t6.setBounds(140, 270, 120, 40);
		t6.setToolTipText("Password should be of atleast 8 characters, with atleast one numeral, one lowercase alphabet,"
				+ " one uppercase alphabet, one special character and without any spaces.");  
		b1 = new JButton("Register");
		b1.setBounds(20, 320, 100, 40);
		b2 = new JButton("Clear");
		b2.setBounds(140, 320, 80, 40);
		pic=new JLabel();
		pic.setBounds(350,50,200,300);
		pic.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		b3=new JButton("BROWSE");
		b3.setBounds(400,400,100,50);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JFileChooser file=new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				
				FileNameExtensionFilter filter= new FileNameExtensionFilter("*.Images", "gif","jpg","png");
				file.addChoosableFileFilter(filter);
				int result=file.showSaveDialog(null);
				if(result==JFileChooser.APPROVE_OPTION){
					File selectedfile=file.getSelectedFile();
					path=selectedfile.getAbsolutePath();
					pic.setIcon(ResizeImage(path));
				}
				else if(result==JFileChooser.CANCEL_OPTION){
					System.out.println("No file selected!");
				}
			}
		});
		f.add(b3);
		f.add(pic);
		b.addActionListener(this);

	/*	b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new firstpage();
				this.f.dispose();
				//fp.getContentPane().setVisible(true);
			}
		});*/
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.add(l1);
		f.add(l2);
		f.add(b1);
		f.add(b2);
		f.add(t1);
		f.add(t2);
		f.add(l3);
		f.add(l4);
		f.add(t3);
		f.add(t4);
		f.add(l5);
		f.add(l6);
		f.add(t5);
		f.add(t6);
		f.add(b);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			 
			if(t1.getText().equals("")){
				JOptionPane.showMessageDialog(f, "Please fill your name.","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(t2.getText().equals("")){
				JOptionPane.showMessageDialog(f, "Please fill your E-mail Address.","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(t3.getText().equals("")){
				JOptionPane.showMessageDialog(f, "Please fill your city.","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(t4.getText().equals("")){
				JOptionPane.showMessageDialog(f, "Please fill your contact number.","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(t5.getText().equals("")){
				JOptionPane.showMessageDialog(f, "Please fill your username.","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else if(t6.getText().equals("")){
				JOptionPane.showMessageDialog(f, "Please fill your password.","Alert",JOptionPane.WARNING_MESSAGE);
			}
			else{
			try { 
				conn = ConnectionFactory.getConnection();
				java.sql.PreparedStatement ps2 = conn.prepareStatement(
						"select username from login");
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next()){
             	   user=rs2.getString("username");
             	
                }
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if(user.equals(t5.getText())){
         		JOptionPane.showMessageDialog(f, "Please use a different username. "
         				+ "This username is already there!","Alert",JOptionPane.WARNING_MESSAGE);
         	}
			else{
				String ex = "^[0-9]{10}$";
				String em= "^[a-zA-Z0-9.!#$%&'*+/="
						+ "?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\."
						+ "[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
				String cit= "[a-zA-Z]+";
				String pas="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
				String nam="[a-zA-z ]+";
				
				Pattern p=Pattern.compile(ex);
				Matcher m=p.matcher(t4.getText());
				Pattern p1=Pattern.compile(em);
				Matcher m1=p1.matcher(t2.getText());
				Pattern p2=Pattern.compile(cit);
				Matcher m2=p2.matcher(t3.getText());
				Pattern p4=Pattern.compile(nam);
				Matcher m3=p4.matcher(t1.getText());
				Pattern p3=Pattern.compile(pas);
				Matcher m4=p3.matcher(t6.getText());
				
				if(!m.matches()){
					JOptionPane.showMessageDialog(f, "Please enter a valid contact number !","Alert",JOptionPane.WARNING_MESSAGE);
				}
				else if(!m1.matches()){
					JOptionPane.showMessageDialog(f, "Please enter a valid email address !","Alert",JOptionPane.WARNING_MESSAGE);
				}
				else if(!m2.matches()){
					JOptionPane.showMessageDialog(f, "Please enter a valid city !","Alert",JOptionPane.WARNING_MESSAGE);
				}
				else if(!m3.matches()){
					JOptionPane.showMessageDialog(f, "Please enter a valid name !","Alert",JOptionPane.WARNING_MESSAGE);
				}
				else if(!m4.matches()){
					JOptionPane.showMessageDialog(f, "Please enter a valid password !","Alert",JOptionPane.WARNING_MESSAGE);
				}
				//if(m.matches() && m1.matches() && m2.matches()){
				else{	
				int a=JOptionPane.showConfirmDialog(f,"Are you sure you want to submit the details ?");  
					if(a==JOptionPane.YES_OPTION){  
					try {
					
					java.sql.PreparedStatement ps1 = conn.prepareStatement(
							"insert into login(Name,email,City,Contact_No,username,password) values(?,?,?,?,?,?)");
					//File imgfile = new File(path);
					//FileInputStream fin = new FileInputStream(imgfile);
					ps1.setString(1, t1.getText());
					ps1.setString(2, t2.getText());
					ps1.setString(3, t3.getText());
					ps1.setString(4, t4.getText());
					ps1.setString(5, t5.getText());
					ps1.setString(6, t6.getText());
					//ps1.setBinaryStream(7,(FileInputStream)fin,(int)imgfile.length());
					System.out.println(ps1.executeUpdate());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(f, "You have registered successfully!");
					new first();
					this.f.dispose();
				}
			}
			}
				/*t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");*/
	
			}
		} else if (e.getSource() == b2) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			JOptionPane.showMessageDialog(f, "Form cleared...");
		}
	 else if(e.getSource()==b)
         {
         	
         	new firstpage();
         	this.f.dispose();	
         	
         }

	}
	public ImageIcon ResizeImage(String ImagePath){
		ImageIcon MyImage=new ImageIcon(ImagePath);
		Image img=MyImage.getImage();
		Image newimg=img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image=new ImageIcon(newimg);
		return image;
	}
}