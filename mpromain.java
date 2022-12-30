import java.awt.*;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.Component;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.StyleSheet;

public class mpromain
{

     static designclass dc;

		public static void main(String []args)
		{

           	dc=new designclass();

		    dc.homepage();


	        dc.setbuttoneve();

            dc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



		}



}

final class designclass extends JFrame
{
   private int row=0,ii=0;

   private long t=0;

   private JButton btnh,btna,btnu,btnla,btnlu,btnlo,btnaddm,btndelm,btnuptm,btnlistm,btnadduser,addnewuser,addprobtn,printbill,btnref;

   private JLabel wlc_head,wlc_des,user,pass,loginerror,pron,proi,prop,proa,proc,addproerror,verheading,total,iconimg;

   private Font btn,head,simple,texbox;

   private TextField usera_box,passa_box,useru_box,passu_box,search_box,userboxaddu,passboxaddu,addproid,addproname,addproprice,addproava,addprocompany;

   private String connectionurl,sql,templogin,proidforsqlquery;

   private String[][] bill;

   private JList listofproinadmin;

   private JTable tofpro,tofbill;

   private Connection conn;

   private PreparedStatement sqlquery;

   private ResultSet result;

   private addusersubdailog addudailog;

   private StyleSheet sty;

   private String[][] data;

   private JPanel mainpanel;




  // private Panel top;

  public designclass()
   {
       super("Medical Management Software");
       super.setSize(1367,1000);
       setLayout(new FlowLayout());

	   //super.setBackground(Color.green);



	   sty=new StyleSheet();

       //mainpanel=new JPanel();



       //mainpanel.setBounds(154,576,1006,500);

	   usera_box=new TextField("admin123",50);
	   passa_box=new TextField("admin12345",50);

	   useru_box=new TextField("mohit12345",50);
	   passu_box=new TextField("mohit123456",50);

	   userboxaddu=new TextField(50);
	   passboxaddu=new TextField(50);

	   addproid=new TextField(50);
	   addproname=new TextField(50);
	   addproprice=new TextField(20);
	   addproava=new TextField(20);
	   addprocompany=new TextField(50);

	   btnh=new JButton("Home Panel");
	   btna=new JButton("Admin Panel");
	   btnu=new JButton("User Panel");
	   btnla=new JButton("Login");
	   btnlu=new JButton("Login");
	   btnaddm=new JButton("ADD NEW");
	   btnuptm=new JButton("UPDATE");
	   btndelm=new JButton("DELETE");
	   btnlistm=new JButton("REFRESH");
	   btnadduser=new JButton("ADD NEW USERS");
	   addnewuser=new JButton("ADD");
	   addprobtn=new JButton("ADD");
	   btnref=new JButton("REFRESH");

	   printbill=new JButton("PRINT");

	   btn=new Font("Impact", Font.PLAIN, 15);
	   head=new Font("Times New Roman", Font.BOLD, 40);
	   simple=new Font("Dialog", Font.PLAIN, 19);
	   texbox=new Font("Dialog",Font.BOLD, 15);

	   wlc_head=new JLabel("Welcome to Medical Managament Software");
	   wlc_des=new JLabel("This is Medical Managament Software which allow you to handle your all medical related task. to login as admin or user click on below buttons");
       user=new JLabel("Username :");
       pass=new JLabel("Password :");
       loginerror=new JLabel();
       loginerror.setForeground(new Color(255,0,0));
       loginerror.setFont(new Font("Dialog",Font.BOLD, 19));

       proi=new JLabel("ID : ");
       pron=new JLabel("NAME : ");
       prop=new JLabel("PRICE : ");
       proa=new JLabel("STOCK : ");
       proc=new JLabel("COMPANY : ");
       addproerror=new JLabel();

       total=new JLabel("Total = 0");

       bill=new String[100][5];

      // addproheading=new JLabel();


       try
       {

       connectionurl="jdbc:mysql://localhost:3306/medicalprodata";
       Class.forName("com.mysql.jdbc.Driver");
       conn=DriverManager.getConnection(connectionurl,"root","");


       }
       catch(Exception excp)
       {
          System.out.println("Hello 1: "+excp);
       }




       //top=new Panel();
   }

   public void homepage()
   {


       mpromain.dc.getContentPane().removeAll();

	   revalidate();
       repaint();



          try
	   	   {
	   	    setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("home_back.jpg")))));
	          }
	          catch(IOException e)
	          {
	   		   System.out.println("sasa "+e);
		}
       	   try
	   	   {
	   	      iconimg=new JLabel(new ImageIcon(ImageIO.read(new File("mini_icon.png"))));
	          }
	          catch(IOException e)
	          {
	   		   System.out.println("sasa "+e);
	   		}

       iconimg.setBounds(100,70,100,100);
       add(iconimg);
      // wlc_head.setForegound(Color.blue);
       wlc_head.setText("Welcome to Medical Managament Software");
       wlc_head.setForeground(new Color(225,125,55));
       wlc_head.setFont(head);
       wlc_head.setBounds(200,65,900,100);
       add(wlc_head);

       wlc_des.setForeground(Color.orange);
       wlc_des.setText("This is Medical Managament Software which allow you to handle your all medical related task. to login as admin or user click on below buttons");
       wlc_des.setFont(simple);
	   wlc_des.setBounds(50,300,1250,50);
       //add(wlc_des);


       btna.setFont(btn);
       btna.setBounds(300,500,200,50);
       add(btna);


       btnu.setFont(btn);
	   btnu.setBounds(600,500,200,50);
       add(btnu);

       //add(mainpanel);

       setVisible(false);
       setVisible(true);

     /*  top.setBackground(Color.red);
       top.setBounds(0,0,1367,500);

       add(top);*/

   }
   public void adminlogin()
   {

	   mpromain.dc.getContentPane().removeAll();

       revalidate();
       repaint();

               try
	   	   	   {
	   	   	    setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("login_back.jpg")))));
	   	          }
	   	          catch(IOException e)
	   	          {
	   	   		   System.out.println("sasa "+e);
		       }

       JPanel temp1=new JPanel();
       temp1.setBounds(200,50,900,50);
       temp1.setBackground(new Color(50,50,150));

       wlc_head.setForeground(new Color(240,240,240));
	   wlc_head.setFont(head);
	   wlc_head.setText("Welcome to Admin Login Panel");
	   //wlc_head.
	   temp1.add(wlc_head);
	   add(temp1);

	   wlc_des.setFont(simple);
	   wlc_des.setText("Please prove admin login details below to login in admin panel or press back button  for home panel");
	   wlc_des.setBounds(50,150,1250,50);
       add(wlc_des);



       loginerror.setFont(simple);
       loginerror.setBounds(300,230,400,25);
       add(loginerror);



       user.setFont(texbox);
       user.setBounds(300,300,100,25);
       add(user);

       usera_box.setFont(texbox);
       usera_box.setBounds(400,300,200,25);
       add(usera_box);

       pass.setFont(texbox);
	   pass.setBounds(300,350,100,25);
       add(pass);

       passa_box.setFont(texbox);
       passa_box.setEchoChar('*');
	   passa_box.setBounds(400,350,200,25);
       add(passa_box);


       //btnl.setFont(btn);
	   btnla.setBounds(400,400,100,30);
       add(btnla);


	   btnh.setFont(btn);
	   btnh.setBounds(800,500,200,50);
       add(btnh);

       setVisible(false);
       setVisible(true);


	   }

	 public void userlogin()
	 {

	   mpromain.dc.getContentPane().removeAll();

	   revalidate();
       repaint();



              	   try
	   	   	   {
	   	   	    setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("login_back.jpg")))));
	   	          }
	   	          catch(IOException e)
	   	          {
	   	   		   System.out.println("sasa "+e);
		       }

	   wlc_head.setFont(head);
	   wlc_head.setText("Welcome to User Login Panel");
	   wlc_head.setBounds(200,50,700,50);


	   JPanel temp3=new JPanel();
	   temp3.setBounds(300,50,700,50);
       temp3.setBackground(new Color(250,250,250));
       temp3.add(wlc_head);

	   add(temp3);

	   wlc_des.setFont(simple);
	   wlc_des.setText("Please prove user login details below to login in user panel or press home button  for home panel");
	   wlc_des.setBounds(50,150,1250,50);
      // add(wlc_des);

       loginerror.setFont(simple);
	   loginerror.setBounds(300,230,400,25);
       add(loginerror);

       user.setFont(texbox);
       user.setBounds(300,300,100,25);
       add(user);

       useru_box.setFont(texbox);
       useru_box.setBounds(400,300,200,25);
       add(useru_box);

       pass.setFont(texbox);
	   pass.setBounds(300,350,100,25);
       add(pass);

       passu_box.setFont(texbox);
       passu_box.setEchoChar('*');
	   passu_box.setBounds(400,350,200,25);
       add(passu_box);


       //btnl.setFont(btn);
	   btnlu.setBounds(400,400,100,30);
       add(btnlu);


	   btnh.setFont(btn);
	   btnh.setBounds(800,500,200,50);
       add(btnh);

       setVisible(false);
	   setVisible(true);


	}

	   public void setbuttoneve()
	   {


			  adminbtneventlisner lisa=new adminbtneventlisner();
			  btna.addActionListener(lisa);


			  userbtneventlisner lisu=new userbtneventlisner();
			  btnu.addActionListener(lisu);

			  homebtneventlisner lish=new homebtneventlisner();
			  btnh.addActionListener(lish);

			  adminloginbtneventlisner lisla=new adminloginbtneventlisner();
			  btnla.addActionListener(lisla);

			  userloginbtneventlisner lislu=new userloginbtneventlisner();
			  btnlu.addActionListener(lislu);

			  addbtneventlisner lisadd=new addbtneventlisner();
			  btnaddm.addActionListener(lisadd);

			  uptbtneventlisner lisupt=new uptbtneventlisner();
			  btnuptm.addActionListener(lisupt);

			  delbtneventlisner lisdel=new delbtneventlisner();
			  btndelm.addActionListener(lisdel);

			  listbtneventlisner lislist=new listbtneventlisner();
			  btnlistm.addActionListener(lislist);

			  adduserbtneventlisner lisadduser=new adduserbtneventlisner();
			  btnadduser.addActionListener(lisadduser);



              userbtnrefeventlisner userref=new userbtnrefeventlisner();
			  btnref.addActionListener(userref);
	   }

	  public void checkuserlogin()
	  {

		if(useru_box.getText().equals("admin123"))
           {
              loginerror.setText("admin username can not be used here");
	       }
	    else
	    {


			try
			{
				sqlquery=conn.prepareStatement("SELECT userpass FROM users WHERE username=?");
			    sqlquery.setString(1,useru_box.getText());
			    result=sqlquery.executeQuery();
			    result.next();
			    templogin=result.getString(1);
			    if(templogin.equals(passu_box.getText())==true)
			       {

					userpanel();
				    }
					else
					{
					 loginerror.setText("Login unsuccessfully");

					}
				}
				catch(Exception exp)
				{
			      loginerror.setText("Login unsuccessfully");

			    }
		}



	}

	public void userpanel()
	{


       mpromain.dc.getContentPane().removeAll();

	   revalidate();
       repaint();

       	   try
	   	   {
	   	    setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("user_back.jpg")))));
	          }
	          catch(IOException e)
	          {
	   		   System.out.println("sasa "+e);
		       }
       wlc_head.setFont(head);
	   wlc_head.setText("Welcome to User Panel");
	   wlc_head.setBounds(200,50,700,50);


       //btnref=new JButton("REFRESH");
       btnref.setFont(btn);
       btnref.setBounds(850,200,100,25);
       add(btnref);


	   JPanel temp4=new JPanel();
	   temp4.setBounds(300,50,700,50);
       temp4.setBackground(new Color(250,250,250));
       temp4.add(wlc_head);

	   add(temp4);

	   wlc_des.setFont(simple);
	   wlc_des.setText("this is user panel here you can manage all things related to medical exmple billing ");
	   wlc_des.setBounds(50,150,1250,50);
       //add(wlc_des);

       total.setFont(new Font("Times New Roman", Font.BOLD,25));
       total.setBounds(950,600,300,50);
       total.setForeground(new Color(255,255,255));

       JPanel temp5=new JPanel();
	   temp5.setBounds(950,600,300,50);
	   temp5.setBackground(new Color(255,0,0));
       temp5.add(total);

       printbill.setBounds(1250,600,100,50);

       add(temp5);
       add(printbill);

         String[] col={"ID","NAME","PRICE","AVALIBILITY","COMPANY"};
         int i=0,j=0,c=0;

         try
         {

		  sqlquery=conn.prepareStatement("SELECT * FROM products");

		  result=sqlquery.executeQuery();

		  while(result.next())
		  {
			  c++;
			  }

		   data=new String[c][7];

		   result=sqlquery.executeQuery();
		  while(result.next())
		  {

             for(j=0;j<5;j++)
             {

			   data[i][j]=result.getString(j+2);
			  }

			  //data[i][j]="<html><span style='background-color:green; color:white;'>Update</span></html>";
			  //data[i][j+1]="<html><span style='background-color:red; color:white;'>Delete</span></html>";
			  i++;

		   }

           tofpro=new JTable(data,col);
           //tofpro.setEnabled(false);
	      }
	      catch(Exception e)
	      {

			  System.out.println(" ERORR 101 : "+e);
			  }

	      show_bill();

          JScrollPane sp=new JScrollPane(tofpro,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


          sp.setBounds(50,350,800,500);

          JPanel p=new JPanel(new BorderLayout());

          p.add(sp);


          JScrollPane s=new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


          s.setBounds(50,350,800,250);

          add(s);

          tofpro.addMouseListener(new MouseAdapter()
          {
			  public void mouseClicked(MouseEvent e)
			  {

				  //int selr=tofpro.getSelectedRow();



				 // int modi=e.getModifiers();

				  Point p=e.getPoint();

				  row=tofpro.rowAtPoint(p);


                  proidforsqlquery=(String)tofpro.getValueAt(row,0);


				  //
                  // System.out.println(e.getJButton());
				  if(e.getButton()==3)
				  {

                     proidforsqlquery="ID : "+proidforsqlquery;

				     JDialog usertempdailog=new JDialog(mpromain.dc,"Add quantity",true);

				     usertempdailog.setSize(250,200);
				     usertempdailog.setResizable(false);
				     usertempdailog.setLayout(null);

                     usertempdailog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				     JButton addqu=new JButton("ADD");
                     TextField addquantity=new TextField(10);
                     JLabel quantityerror=new JLabel();


				     addqu.setBounds(80,100,70,50);
				     addquantity.setBounds(75,50,50,25);
				     quantityerror.setBounds(10,25,240,30);

                     usertempdailog.add(quantityerror);
				     addqu.addActionListener(new ActionListener(){ public void  actionPerformed(ActionEvent actnEvnt){


						  try
						 {
						 	sqlquery=conn.prepareStatement("SELECT * FROM products WHERE pro_id=?");


						 		    	sqlquery.setString(1,data[row][0]);


						                         int j=0,c=0,d=0,p=0,uu=0,ll=0;


										   		  //sqlquery=conn.prepareStatement("SELECT * FROM products");



										   		  result=sqlquery.executeQuery();
                                                  result.next();
												  uu=Integer.parseInt(result.getString(5));
												  c=Integer.parseInt(addquantity.getText());

												  if(uu<c)

												  {
													  quantityerror.setText("Product Quantity is greater than stock");
													  }

										   		  else
										   		  {
										   		  result=sqlquery.executeQuery();
										   		  while(result.next())
										   		  {

										              for(j=0;j<4;j++)
										              {

										   			    bill[ii][j]=result.getString(j+2);
                                                        if(j==2)
                                                        {
															p=Integer.parseInt(result.getString(j+2));
														}
										   			  }



										   			  d=c*p;
										   			  t=t+d;
										   			  bill[ii][3]=addquantity.getText();
										   			  bill[ii][4]=addquantity.getText()+" x "+p+" = "+d;
										   			  ll= uu-c;

                                                      String terr=String.valueOf(t);
                                                      total.setText("Total = "+terr);

										   			  //data[i][j]="<html><span style='background-color:green; color:white;'>Update</span></html>";
										   			  //data[i][j+1]="<html><span style='background-color:red; color:white;'>Delete</span></html>";
										   			  ii++;

										   		   }
                                                           try
														    {
																 sqlquery=conn.prepareStatement("UPDATE products SET pro_ava=? WHERE pro_id=?");

                                                                    String lll=String.valueOf(ll);
															    	sqlquery.setString(1,lll);
															    	sqlquery.setString(2,data[row][0]);


													               if(sqlquery.executeUpdate()==1)
									               	               {
																	   System.out.println("cghjgchj");


																   }
																   else
																   {

																	   throw new Exception("1055 Last query did not executed");

																	}
															 }
															 catch(Exception e)
															 {
																 System.out.println("Hello 47575: "+e);

															 }


										          show_bill();    //tofpro.setEnabled(false);
											     }






						 }
						 catch(Exception e)
						 {
						 			 System.out.println("Hello 10200: "+e);

						 }






						 } });


				     usertempdailog.add(addqu);
				     usertempdailog.add(addquantity);


       			     usertempdailog.setVisible(true);



			       }
			    }


	   }



          );

     setVisible(false);
     setVisible(true);

	}
  public void show_bill()
  {
	 String[] col1={"ID","NAME","PRICE","QUANTITY","TOTAL"};

     tofbill=new JTable(bill,col1);

	 JScrollPane sp1=new JScrollPane(tofbill,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


	 sp1.setBounds(950,350,400,500);

	 JPanel p1=new JPanel(new BorderLayout());

	 p1.add(sp1);


	 JScrollPane s1=new JScrollPane(p1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


	 s1.setBounds(950,350,400,250);

	 add(s1);

     setVisible(false);
     setVisible(true);
   }
     public void checkadminlogin()
     {
         if(usera_box.getText().equals("admin123"))
           {
              try
              {
				  sqlquery=conn.prepareStatement("SELECT userpass FROM users WHERE username=?");
              sqlquery.setString(1,usera_box.getText());
              result=sqlquery.executeQuery();
              result.next();
              templogin=result.getString(1);
              if(templogin.equals(passa_box.getText())==true)
              {

				  adminpanel();
			   }
			   else
			   {
				    loginerror.setText("Login unsuccessfully");

				   }
		      }
		      catch(Exception exp)
		      {
                     loginerror.setText("Login unsuccessfully");

			  }
	       }
	    else
	    {

			loginerror.setText("admin username is wrong");
		}

      }

      public void adminpanel()
      {

       mpromain.dc.getContentPane().removeAll();

	   revalidate();
       repaint();
       	   try
	   	   {
	   	    setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("admin_back.jpg")))));
	          }
	          catch(IOException e)
	          {
	   		   System.out.println("sasa "+e);
		}

	   wlc_head.setFont(head);
	   wlc_head.setText("Welcome to Admin Panel");
	   wlc_head.setBounds(300,50,600,50);


	   JPanel temp2=new JPanel();
	   temp2.setBounds(300,50,600,50);
       temp2.setBackground(new Color(50,50,50));
       temp2.add(wlc_head);
       add(temp2);

	   wlc_des.setFont(simple);
	   wlc_des.setText("this is admin panel here you can manage all things related to medical exmple update,delete ect..");
	   wlc_des.setBounds(50,150,1250,50);
      // add(wlc_des);

       btnaddm.setFont(btn);
	   btnaddm.setBounds(100,250,100,25);
       add(btnaddm);

       btnuptm.setFont(btn);
	   btnuptm.setBounds(310,250,100,25);
       add(btnuptm);

       btndelm.setFont(btn);
	   btndelm.setBounds(520,250,100,25);
       add(btndelm);

       btnlistm.setFont(btn);
	   btnlistm.setBounds(730,250,100,25);
       add(btnlistm);

       btnadduser.setFont(btn);
	   btnadduser.setBounds(940,250,150,25);
       add(btnadduser);



		 //listpro lp=new listpro(mpromain.dc,"LIST OF ALL PRODUCT");


         String[] col={"ID","NAME","PRICE","AVALIBILITY","COMPANY"};
         int i=0,j=0,c=0;

         try
         {

		  sqlquery=conn.prepareStatement("SELECT * FROM products");

		  result=sqlquery.executeQuery();

		  while(result.next())
		  {
			  c++;
			  }

		   data=new String[c][7];

		   result=sqlquery.executeQuery();
		  while(result.next())
		  {

             for(j=0;j<5;j++)
             {

			   data[i][j]=result.getString(j+2);
			  }

			  //data[i][j]="<html><span style='background-color:green; color:white;'>Update</span></html>";
			  //data[i][j+1]="<html><span style='background-color:red; color:white;'>Delete</span></html>";
			  i++;

		   }

           tofpro=new JTable(data,col);
           //tofpro.setEnabled(false);
	      }
	      catch(Exception e)
	      {

			  System.out.println(" ERORR 101 : "+e);
			  }

          JScrollPane sp=new JScrollPane(tofpro,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


          sp.setBounds(50,400,1200,500);

          JPanel p=new JPanel(new BorderLayout());

          p.add(sp);


          JScrollPane s=new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


          s.setBounds(50,400,1200,250);

          add(s);


          tofpro.addMouseListener(new MouseAdapter()
          {
			  public void mouseClicked(MouseEvent e)
			  {

				  //int selr=tofpro.getSelectedRow();



				 // int modi=e.getModifiers();

				  Point p=e.getPoint();

				  row=tofpro.rowAtPoint(p);


                  proidforsqlquery=(String)tofpro.getValueAt(row,0);


				  //
                  // System.out.println(e.getJButton());
				  if(e.getButton()==3)
				  {

                     proidforsqlquery="ID : "+proidforsqlquery;

				     JDialog admintempdailog=new JDialog(mpromain.dc,"Verify Operation",true);

				     admintempdailog.setSize(225,200);
				     admintempdailog.setResizable(false);
				     admintempdailog.setLayout(null);

                     admintempdailog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				     JButton verbtnupt=new JButton("Update");
				     JButton verbtndel=new JButton("Delete");

                     verheading=new JLabel(proidforsqlquery);
                     verheading.setBounds(25,20,220,25);

				     verbtnupt.setBounds(25,50,75,50);
				     verbtndel.setBounds(125,50,75,50);

				     verbtnupt.addActionListener(new ActionListener(){ public void  actionPerformed(ActionEvent actnEvnt){ mpromain.dc.updateproduct(); } });
				     verbtndel.addActionListener(new ActionListener(){ public void  actionPerformed(ActionEvent actnEvnt){ mpromain.dc.deleteproduct(); } });


				     admintempdailog.add(verbtnupt);
				     admintempdailog.add(verbtndel);
				     admintempdailog.add(verheading);



       			     admintempdailog.setVisible(true);



			       }
			    }



			  }


          );

       setVisible(false);
       setVisible(true);
	  }

	  public void adduser()
	  {


        try{
	    addudailog=new addusersubdailog(mpromain.dc,"ADD NEW USERS");

        loginerror.setText("");

	    loginerror.setFont(new Font("Dialog",Font.BOLD, 15));
		loginerror.setBounds(20,50,450,25);
		addudailog.add(loginerror);


		user.setFont(texbox);
		user.setBounds(10,100,100,25);
        addudailog.add(user);

		userboxaddu.setBounds(120,100,250,25);
		addudailog.add(userboxaddu);
        //userboxaddu.requestFocusInWindow();

		pass.setFont(texbox);
		pass.setBounds(10,150,100,25);
        addudailog.add(pass);

		passboxaddu.setBounds(120,150,250,25);
		addudailog.add(passboxaddu);

		addnewuser.setFont(new Font("Impact", Font.PLAIN, 13));
	    addnewuser.setBounds(200,200,100,50);
		addudailog.add(addnewuser);

		addnewuseractionlis anuc=new addnewuseractionlis();
		addnewuser.addActionListener(anuc);

		keylisforadduser adduser_userboxkey=new keylisforadduser();
		userboxaddu.addKeyListener(adduser_userboxkey);

		keylisforadduser2 adduser_passboxkey=new keylisforadduser2();
		passboxaddu.addKeyListener(adduser_passboxkey);

		addudailog.setVisible(true);

		//addudailog.requestFocus();
	    }
	    catch(Exception e)
	    {

			System.out.println("add user dailog : "+e);
		}

	}
	public void adduserusernamewarning()
	{

		String str=new String();


	    str=userboxaddu.getText();

		if(str.length()>19||str.length()<5)
		{
		  loginerror.setText("Error : username should be of length 5>username<20 charcter ");

		}
		else
		{

			loginerror.setText(" ");

	    }

	}

	public void adduserpasswordwarning()
	{

		String str=new String();


	    str=passboxaddu.getText();

		if(str.length()>19||str.length()<5)
		{
		  loginerror.setText("Error : password length should be 5>upassword<20 charcter");

		}
		else
		{

			loginerror.setText(" ");

	    }

	}

	public void performadduser()
	{

		String stru,strp;

		stru=userboxaddu.getText();

		strp=passboxaddu.getText();

		if(stru.length()<20&&stru.length()>5&&strp.length()>5&&strp.length()<20)
		{
           if(stru.equals("admin123")==true)

           { loginerror.setText("Error : Username should not be admin123"); }
           else
           {
			try
			{
			 sqlquery=conn.prepareStatement("INSERT INTO users(username,userpass) VALUES(?,?)");
		    	sqlquery.setString(1,stru);
		    	sqlquery.setString(2,strp);
               if(sqlquery.executeUpdate()==1)
               {
				   loginerror.setText("Error : User successfully added");
				   userboxaddu.setText("");
				   passboxaddu.setText("");

			   }
			   else
			   {

				   throw new Exception("Last query did not executed");

				   }
		 }
		 catch(Exception e)
		 {
			 System.out.println("Hello : "+e);

			 }
	       }
		}

		else
		{
			loginerror.setText("Error : User can not be added");

		}
	}

   public void addm()
   {
	   addpro addproobj=new addpro(mpromain.dc,"ADD NEW PRODUCT");

       addproerror.setText("");


       addproerror.setForeground(new Color(255,0,0));

       addproerror.setFont(new Font("Dialog",Font.BOLD, 15));
       addproerror.setBounds(50,30,600,25);
       addproobj.add(addproerror);

       proi.setFont(texbox);
	   proi.setBounds(50,100,100,25);
	   addproobj.add(proi);

	   addproid.setBounds(160,100,200,25);
	   addproobj.add(addproid);

	   pron.setFont(texbox);
	   pron.setBounds(50,150,100,25);
	   addproobj.add(pron);

	   addproname.setBounds(160,150,200,25);
	   addproobj.add(addproname);

	   prop.setFont(texbox);
	   prop.setBounds(50,200,100,25);
	   addproobj.add(prop);

	   addproprice.setBounds(160,200,50,25);
	   addproobj.add(addproprice);

	   proa.setFont(texbox);
	   proa.setBounds(50,250,100,25);
	   addproobj.add(proa);

	   addproava.setBounds(160,250,50,25);
	   addproobj.add(addproava);

	   proc.setFont(texbox);
	   proc.setBounds(50,300,100,25);
	   addproobj.add(proc);

	   addprocompany.setBounds(160,300,200,25);
	   addproobj.add(addprocompany);

	   addprobtn.setBounds(200,350,100,50);
	   addproobj.add(addprobtn);

	   addprobtnlis addprolis=new addprobtnlis();
	   addprobtn.addActionListener(addprolis);

       addproobj.setVisible(true);

	}

	public void performaddpro()
	{


		try
		{
			String str[]={"","","","",""};

			str[0]=addproid.getText();
			str[1]=addproname.getText();
			str[2]=addproprice.getText();
			str[3]=addproava.getText();
			str[4]=addprocompany.getText();

			if(str[0].length()>4&&str[0].length()<51&&str[1].length()>4&&str[1].length()<101&&str[2].length()>0&&str[2].length()<61&&str[3].length()>0&&str[3].length()<6&&str[4].length()>4&&str[4].length()<101)
			{

				sqlquery=conn.prepareStatement("INSERT INTO products(pro_id,pro_name,pro_price,pro_ava,pro_company) VALUES(?,?,?,?,?)");

				sqlquery.setString(1,str[0]);
				sqlquery.setString(2,str[1]);
				sqlquery.setString(3,str[2]);
				sqlquery.setString(4,str[3]);
				sqlquery.setString(5,str[4]);

				if(sqlquery.executeUpdate()==1)
				  {
					addproerror.setText("Product successfully added");
					addproid.setText("");
				    addproname.setText("");
				    addproprice.setText("");
				    addproava.setText("");
				    addprocompany.setText("");

				  }
				  else
				  {

					throw new Exception("Last query did not executed");

				   }

			}
			else
			{
			    addproerror.setText("Error : Product can not be added");

				}




		}
		catch(Exception e)

		{

			System.out.println("Error : "+e);
			}




    }

    public void listm()
    {


		adminpanel();
	}

public void updateproduct()
 {

        try
	    {
			 sqlquery=conn.prepareStatement("UPDATE products SET pro_id=?,pro_name=?,pro_price=?,pro_ava=?,pro_company=? WHERE pro_id=?");


		    	sqlquery.setString(1,data[row][0]);
		    	sqlquery.setString(2,data[row][1]);
		    	sqlquery.setString(3,data[row][2]);
		    	sqlquery.setString(4,data[row][3]);
		    	sqlquery.setString(5,data[row][4]);
		    	sqlquery.setString(6,data[row][0]);

               if(sqlquery.executeUpdate()==1)
               {
				   adminpanel();
				   verheading.setText("OPERATION SUCCESSFULL");

			   }
			   else
			   {

				   throw new Exception("Last query did not executed");

				}
		 }
		 catch(Exception e)
		 {
			 System.out.println("Hello : "+e);

			 }




}

	public void deleteproduct()
	{

        try
	    {
			 sqlquery=conn.prepareStatement("DELETE FROM products WHERE pro_id=?");


		     sqlquery.setString(1,data[row][0]);


               if(sqlquery.executeUpdate()==1)
               {
				   adminpanel();

			   }
			   else
			   {

				   throw new Exception("Last query did not executed");

				}
		 }
		 catch(Exception e)
		 {
			 System.out.println("Hello : "+e);

			 }



	}

}

class adminbtneventlisner implements ActionListener
{

	public void actionPerformed(ActionEvent actnEvnt)
	{

         mpromain.dc.adminlogin();

    }


}

class userbtneventlisner implements ActionListener
{

	public void actionPerformed(ActionEvent actnEvnt)
	{

        mpromain.dc.userlogin();

    }


}

class homebtneventlisner implements ActionListener
{

	public void actionPerformed(ActionEvent actnEvnt)
	{

         mpromain.dc.homepage();

    }
}
class adminloginbtneventlisner implements ActionListener
{

	public void actionPerformed(ActionEvent actnEvnt)
	{

         mpromain.dc.checkadminlogin();

    }


}


class userloginbtneventlisner implements ActionListener
{

	public void actionPerformed(ActionEvent actnEvnt)
	{

         mpromain.dc.checkuserlogin();

    }

}
class addbtneventlisner implements ActionListener
{

	public void actionPerformed(ActionEvent actnEvnt)
	{

         mpromain.dc.addm();

    }
}
class uptbtneventlisner implements ActionListener
{

	public void actionPerformed(ActionEvent actnEvnt)
	{

         //mpromain.dc.uptm();

    }
}
class delbtneventlisner implements ActionListener
{

	public void actionPerformed(ActionEvent actnEvnt)
	{

         //mpromain.dc.delm();

    }
}
class listbtneventlisner implements ActionListener
{

	public void actionPerformed(ActionEvent actnEvnt)
	{

        mpromain.dc.listm();

    }
}
class adduserbtneventlisner implements ActionListener
{

	public void actionPerformed(ActionEvent actnEvnt)
	{

         mpromain.dc.adduser();

    }
}

class userbtnrefeventlisner implements ActionListener
{

	public void actionPerformed(ActionEvent actnEvnt)
	{

         mpromain.dc.userpanel();

    }
}
class addusersubdailog extends Dialog implements ActionListener
{

	addusersubdailog(Frame parent,String str)
	{

		super(parent,str,true);
        setLayout(null);
        setSize(500,500);
        setBackground(Color.yellow);
        setResizable(false);

        JLabel llb=new JLabel("Press this button");
        llb.setBounds(10,330,100,50);
		add(llb);

		JButton btnCancel;
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(100,330,100,20);
		add(btnCancel);
		btnCancel.addActionListener(this);

	}


	public void actionPerformed(ActionEvent actnEvnt)
	{

		dispose();

	 }


}


class keylisforadduser implements KeyListener
{

	public void keyPressed(KeyEvent keyEvnt)
	{
        mpromain.dc.adduserusernamewarning();


	}

	public void keyReleased(KeyEvent keyEvnt)
	{

	}

	public void keyTyped(KeyEvent keyEvnt)
	{

    }


}
class keylisforadduser2 implements KeyListener
{

	public void keyPressed(KeyEvent keyEvnt)
	{
        mpromain.dc.adduserpasswordwarning();


	}

	public void keyReleased(KeyEvent keyEvnt)
	{

	}

	public void keyTyped(KeyEvent keyEvnt)
	{

    }


}
class addnewuseractionlis implements ActionListener
{


	public void actionPerformed(ActionEvent actnEvnt)
		{

			mpromain.dc.performadduser();

		 }

}
class addpro extends Dialog implements ActionListener
{
	addpro(Frame parent,String str)
		{

		  super(parent,str,true);
	      setLayout(null);
	      setSize(500,500);
	      setBackground(Color.yellow);
          setResizable(false);



	    JButton btnCancel2;
		btnCancel2 = new JButton("Cancel");
		btnCancel2.setBounds(100,430,100,20);
		add(btnCancel2);
		btnCancel2.addActionListener(this);

	   }


	public void actionPerformed(ActionEvent actnEvnt)
	{

		dispose();

	 }

}
class addprobtnlis implements ActionListener
{



		public void actionPerformed(ActionEvent actnEvnt)
		{

			mpromain.dc.performaddpro();

	    }



}
class listpro extends Dialog implements ActionListener
{
	listpro(Frame parent,String str)
		{

		  super(parent,str,true);
	      setLayout(null);
	      setSize(500,500);
	      setBackground(Color.yellow);
          setResizable(false);



	    JButton btnCancel3;
		btnCancel3 = new JButton("Cancel");
		btnCancel3.setBounds(100,470,100,20);
		add(btnCancel3);
		btnCancel3.addActionListener(this);

	   }


	public void actionPerformed(ActionEvent actnEvnt)
	{

		dispose();

	 }

}


