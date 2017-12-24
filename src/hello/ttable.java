package hello;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class ttable {

	JFrame f;
	JTable j1,j2;
	JScrollPane s1,s2,s4,s5;
	JTextArea a1,a2;
	
	ttable(){
		
		f=new JFrame();
		f.setSize(800, 400);
		
/*		j2=new JTable();
		j2.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null},
	                {null, null, null, null}
	            },
	            new String [] {
	                "Title 1", "Title 2", "Title 3", "Title 4"
	            }
	        ));
		s2=new JScrollPane();
	        s2.setViewportView(j2);

	        a1=new JTextArea();
	        a1.setColumns(20);
	        a1.setRows(5);
	        s4=new JScrollPane();
	        s4.setViewportView(a1);
a2=new JTextArea();
	        a2.setColumns(20);
	        a2.setRows(5);
	        s5=new JScrollPane();
	        s5.setViewportView(a2);*/

j1=new JTable();
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

	       f.add(s1);
	        s1.setBounds(54, 45, 566, 118);
	        
	        f.setLayout(null);
			f.setVisible(true);
	        
	        
	        

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
	         
	          
	      

	}
	
	
	public static void main(String[] args) {
		new ttable();
		
	}
	
	

}
