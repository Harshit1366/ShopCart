package hello;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class product implements MouseListener {
	
	JFrame f;
	JButton b1,b2,b3,b4,b5;
	JTable table;
	JScrollPane jScrollPane1;

	product(){
		f=new JFrame();
		f.setSize(800,1000);
		
		ImageIcon img=new ImageIcon(getClass().getResource("/images/feedback1.jpg"));
		
		
		
	/*	 table.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {img, null, null, null},
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
		                "ITEM", "ITEMNAME", "QUANTITY", "PRICE"
		            }
		        ));*/
		          
		
		String header[]={"ITEM","ITEMNAME","QUANTITY","PRICE"};
        String values[][]=new String[30][4];
       
        
        int i=0;
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "root");
			java.sql.PreparedStatement ps1 = con.prepareStatement("select itemname,quantity,price from itemdetails");
            ResultSet rs2= ps1.executeQuery();
            while(rs2.next())
            {
                String a=rs2.getString(1);
                String b=rs2.getString(2);
                String c=rs2.getString(3);
                //d=rs2.getString(4);
                System.out.println(a+b+c);
                values[i][1]=a;
                values[i][2]=b;
                values[i][3]=c;
               // values[i][3]=d;
                i++;
            }
            DefaultTableModel model=new DefaultTableModel();
    		JTable table = new JTable( model )
            {
                /**
    			 * 
    			 */
    			private static final long serialVersionUID = 1L;

    			//  Returning the Class of each column will allow different
                //  renderers to be used based on Class
                @SuppressWarnings({ "rawtypes", "unchecked" })
    			public Class getColumnClass(int column)
                {
                    return getValueAt(0, column).getClass();
                }
            };
    		
            table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
     	       table.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
     	       
            
            table.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {
		                {img, null, null, null},
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
		                "ITEM", "ITEMNAME", "QUANTITY", "PRICE"
		            }
		        ));
            
            model.setDataVector(values,header);
            table.setModel(model);
         
         }
        catch(Exception e)
        {
            System.out.println("ERROR:"+e);
        }    
        
      
		
	//	  table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	   //     table.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
	       
	          
		

		//jTable1 = new JTable();
		
		
	
		
		
	    /*    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jTable1MouseClicked(evt);
	            }
	        });*/
	        jScrollPane1=new JScrollPane();
	        jScrollPane1.setViewportView(table);

	        f.add(jScrollPane1);
	        jScrollPane1.setBounds(54, 45, 566, 118);
	        
	        
	       
			
		
	        
	        
	        f.setLayout(null);
	        f.setVisible(true);
		}
	
	
	 public static void main(String[] args) {
			new product();
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
}
