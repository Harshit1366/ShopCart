package hello;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class prodata implements ActionListener {

	JFrame f;
	JLabel l1, l2, l3, l4, l5, l6,l7 ,l8, l9, l10;
	JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
	JButton b1, b2, b, b3;
	JPanel p, p1, p2, p3;
	JTable j1;
	JScrollPane s1;
    static String s;
	static Connection conn;

	prodata() {
		f = new JFrame();
		b = new JButton("Back");
		b.setBounds(1180, 15, 70, 30);
		b.addActionListener(this);
		f.add(b);

		p = new JPanel();
		p.setBounds(10, 60, 200, 280);
		p.setBackground(Color.gray);

		l1 = new JLabel("Category : ");
		t1 = new JTextField();
		l2 = new JLabel("Itemname : ");
		t2 = new JTextField();
		l3 = new JLabel("Quantity : ");
		t3 = new JTextField();
		l4 = new JLabel("Price : ");
		t4 = new JTextField();
		b1 = new JButton("ADD PRODUCT");

		l1.setBounds(10, 50, 80, 30);
		l2.setBounds(10, 90, 80, 30);
		l3.setBounds(10, 130, 80, 30);
		l4.setBounds(10, 170, 80, 30);
		t1.setBounds(90, 50, 100, 30);
		t2.setBounds(90, 90, 100, 30);
		t3.setBounds(90, 130, 100, 30);
		t4.setBounds(90, 170, 100, 30);
		b1.setBounds(35, 220, 130, 30);
		b1.addActionListener(this);

		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(l3);
		p.add(t3);
		p.add(l4);
		p.add(t4);
		p.add(b1);
		p.setLayout(null);

		f.add(p);

		p1 = new JPanel();
		p1.setBounds(230, 60, 200, 280);
		p1.setBackground(Color.gray);

		l5 = new JLabel("Category : ");
		t5 = new JTextField();
		l6 = new JLabel("Itemname : ");
		t6 = new JTextField();
		b2 = new JButton("REMOVE PRODUCT");

		l5.setBounds(10, 50, 80, 30);
		l6.setBounds(10, 90, 80, 30);
		t5.setBounds(90, 50, 100, 30);
		t6.setBounds(90, 90, 100, 30);
		b2.setBounds(20, 220, 160, 30);
		b2.addActionListener(this);

		p1.add(l5);
		p1.add(t5);
		p1.add(l6);
		p1.add(t6);

		p1.add(b2);
		p1.setLayout(null);

		f.add(p1);
		
		
		p2 = new JPanel();
		p2.setBounds(450, 60, 200, 280);
		p2.setBackground(Color.gray);

		l7 = new JLabel("Category : ");
		t7 = new JTextField();
		l8 = new JLabel("Itemname : ");
		t8 = new JTextField();
		l9 = new JLabel("Quantity : ");
		t9 = new JTextField();
		l10 = new JLabel("Price : ");
		t10 = new JTextField();
		b3 = new JButton("EDIT PRODUCT");

		l7.setBounds(10, 50, 80, 30);
		l8.setBounds(10, 90, 80, 30);
		l9.setBounds(10, 130, 80, 30);
		l10.setBounds(10, 170, 80, 30);
		t7.setBounds(90, 50, 100, 30);
		t8.setBounds(90, 90, 100, 30);
		t9.setBounds(90, 130, 100, 30);
		t10.setBounds(90, 170, 100, 30);
		b3.setBounds(35, 220, 130, 30);
		b3.addActionListener(this);

		p2.add(l7);
		p2.add(t7);
		p2.add(l8);
		p2.add(t8);
		p2.add(l9);
		p2.add(t9);
		p2.add(l10);
		p2.add(t10);
		p2.add(b3);
		p2.setLayout(null);

		f.add(p2);
		
		//p3 = new JPanel();
		//p3.setBounds(670, 30, 600, 280);
		//p3.setBackground(Color.gray);
		
	
		j1=new JTable();
		//j1.setEnabled(false);
        j1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        j1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        j1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CATEGORY", "ITEMNAME", "QUANTITY", "PRICE"
            }
        ));
        s1=new JScrollPane();
        s1.setViewportView(j1);

       //p3.add(s1);
        f.add(s1);
        //s1.setBounds(10, 10, 400, 70);
       s1.setBounds(670, 60, 566, 280);  
	        //f.add(p3);
       
       
       DefaultTableModel model1=new DefaultTableModel();
       
       String a;
       String b;
       String c;
       String d;
       String header[]={"CATEGORY","ITEMNAME","QUANTITY","PRICE"};
       String values[][]=new String[30][4];
       int i1=0;
       try
       {
       	Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "root");
			java.sql.PreparedStatement ps1 = con.prepareStatement("select * from itemdetails");
           ResultSet rs2= ps1.executeQuery();
           while(rs2.next())
           {
        	   // u dere? han bhai run it
               a=rs2.getString(1);
               b=rs2.getString(2);
               c=rs2.getString(3);
               d=rs2.getString(4);
               values[i1][0]=a;
               values[i1][1]=b;
               values[i1][2]=c;
               values[i1][3]=d;
               i1++;
           }
           model1.setDataVector(values,header);
           j1.setModel(model1);
        
        }
       catch(Exception e)
       {
           System.out.println("ERROR:"+e);
       }    
       
       
       j1.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent evt) {
               j1MouseClicked(evt);
           }
       });
       

		f.setSize(1280, 450);
		f.setLayout(null);
		f.setVisible(true);

	}



    private void j1MouseClicked(java.awt.event.MouseEvent evt) {
       try
       {
           int row = j1.getSelectedRow();
           String z = (j1.getModel().getValueAt(row,1).toString());
           String q = "select * from ITEMDETAILS where ITEMNAME='"+z+"'";
    //       connect c3 = new connect();
           Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "root");
           java.sql.PreparedStatement ps2 = con.prepareStatement(q);
           ResultSet rs4 = ps2.executeQuery();
           if(rs4.next())
           {
             String r = rs4.getString("category");
              t5.setText(r);
              t7.setText(r);
              s = rs4.getString("itemname");
              t6.setText(s);
              t8.setText(s);
              String x= rs4.getString("quantity");
              t9.setText(x);
              String y= rs4.getString("price");
              t10.setText(y);
           }
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e);
           
       }
    }
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == b) {
			this.f.dispose();
			new admin();
		}
		if (e.getSource() == b1) {

			try {
				conn = ConnectionFactory.getConnection();
				java.sql.PreparedStatement ps1 = conn.prepareStatement("insert into itemdetails values(?,?,?,?)");

				ps1.setString(1, t1.getText());
				ps1.setString(2, t2.getText());
				ps1.setString(3, t3.getText());
				ps1.setString(4, t4.getText());

				System.out.println(ps1.executeUpdate());
				JOptionPane.showMessageDialog(f, "Product added successfully!");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}

		if (e.getSource() == b2) {

			try{
				java.sql.PreparedStatement ps2 = conn.prepareStatement("delete from itemdetails where category=? and itemname = ?");

				ps2.setString(1, t5.getText());
				ps2.setString(2, t6.getText());
				int rs2 = ps2.executeUpdate();
       		 System.out.println(rs2);
       		 if(rs2 >=1){
       			JOptionPane.showMessageDialog(f, "Product removed successfully!");
       		 }
       		 else{
       			JOptionPane.showMessageDialog(f, "Invalid product details !");
       		 }
       		 
       		
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource() == b3){
			try {
				conn = ConnectionFactory.getConnection();
				java.sql.PreparedStatement ps3 = conn.prepareStatement("update itemdetails set category=?,itemname=?,quantity=?,price=? where itemname=?");

				ps3.setString(1, t7.getText());
				ps3.setString(2, t8.getText());
				ps3.setString(3, t9.getText());
				ps3.setString(4, t10.getText());
				ps3.setString(5, s);
				int rs3 = ps3.executeUpdate();
	    		 System.out.println(rs3);
				JOptionPane.showMessageDialog(f, "Product edited successfully!");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}

	}


	public static void main(String[] args) {
		new prodata();
	}

}
