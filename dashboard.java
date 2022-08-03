//Program to create TabbedPane and add different componenets in different panel

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.*; 
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class dashboard implements ActionListener
   {
         JProgressBar jb;
         int num=0,i=0;

	//feedback
	JButton submit;     //global variables
    	JButton reset;
    JTextField tname;
    JTextField tmail;
    JTextField tfeedback;
    Container cp;
    JFrame f;
    JRadioButton one;
    JRadioButton two;
    JRadioButton three;
    JRadioButton four;
    JRadioButton five;
    ButtonGroup rating;

	//order variables
	private JPanel contentPane;
	private JLabel lblname;
	private JLabel lblphno;
	private JLabel lbladdr;
	private JLabel lblTypeCake;
	private JLabel lblFlavors;
	private JTextField tbname;
	private JTextField tbphno;
	private JTextArea tbaddr;
	private JComboBox comboCakeType;
	private JComboBox comboFlavors;
	private JLabel lblSizePrice;
	private JRadioButton rdoRegular;
	private JRadioButton rdoLarge;
	private JLabel lblAddCandles;
	private JButton btnCandleMinus;
	private JLabel lblCandle1;
	private JButton btnCandlePlus;
	private JLabel lblAddLayer;
	private JButton btnLayerMinus;
	private JLabel lblLayer1;
	private JButton btnLayerPlus;
	private JButton btnBillOut;
	private JLabel lblOrderDetails;
	private JTextArea textAreaOrderDetails;
	private JLabel lblRegularPrice;
	private JLabel lblLargePrice;
	private final ButtonGroup buttonGroup = new ButtonGroup();
    private int addCandles = 1, addlayers = 1;
    private double candlePrice = 10.00, layerPrice = 50.00;

         public dashboard()
           {
            JFrame f1=new JFrame();
            f1.setSize(950,900);
            f1.setVisible(true);
	   f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            f1.getContentPane().setBackground(Color.PINK);
            JTabbedPane tp1=new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.WRAP_TAB_LAYOUT);
            
            //Components of panel1 Home
            JLabel l1,l2,l3,l4,l5;
            l1=new JLabel("ManG's Cakes"); 
          l2=new JLabel("Welcome to Our Mini Bakery!");
          l3=new JLabel("We offer Here various types of cakes with good quality!");
           String text="<html>At manGs cakes, we offer a wide range of products like<br>cake and cupcakes.Our offerings include indulgent brownies,<br>cupcakes cakes & desserts.</html>";
          l4=new JLabel(text);
          l5=new JLabel("Here are some cake flavour that we offer!");

            Font fo1=new Font("Times New Roman",Font.BOLD,35);
               l1.setForeground(Color.RED);
               l1.setFont(fo1); 
             
               Font fo2=new Font("Times New Roman",Font.BOLD,30);
               l2.setForeground(Color.BLUE);
               l2.setFont(fo2);

               Font fo3=new Font("Times New Roman",Font.BOLD,25);
               l3.setForeground(Color.BLACK);
               l3.setFont(fo3); 
          
               Font fo4=new Font("Times New Roman",Font.BOLD,20);
               l4.setForeground(Color.BLACK);
               l4.setFont(fo4); 

               Font fo5=new Font("Times New Roman",Font.BOLD,25);
               l5.setForeground(Color.BLACK);
               l5.setFont(fo5); 
          

          DefaultMutableTreeNode cake1=new DefaultMutableTreeNode("Cakes We Offer");  
            DefaultMutableTreeNode Vanilla=new DefaultMutableTreeNode("Vanilla");  
   	    DefaultMutableTreeNode Chocolate=new DefaultMutableTreeNode("Chocolate");  
    	    cake1.add(Vanilla);  
    	    cake1.add(Chocolate);  
            DefaultMutableTreeNode v1=new DefaultMutableTreeNode("Pineapple");  
            DefaultMutableTreeNode v2=new DefaultMutableTreeNode("Strawberry");  
   	    DefaultMutableTreeNode v3=new DefaultMutableTreeNode("Butterscotch");  
    	    DefaultMutableTreeNode v4=new DefaultMutableTreeNode("Rasmalai");  
            DefaultMutableTreeNode v5=new DefaultMutableTreeNode("Gulkand"); 
            DefaultMutableTreeNode v6=new DefaultMutableTreeNode("VerryBerry");  
            DefaultMutableTreeNode v7=new DefaultMutableTreeNode("Pista"); 
   	    Vanilla.add(v1); 
	    Vanilla.add(v2);
            Vanilla.add(v3);
            Vanilla.add(v4);
            Vanilla.add(v5);
            Vanilla.add(v6);
            Vanilla.add(v7);
            DefaultMutableTreeNode c1=new DefaultMutableTreeNode("Basic Chocolate");  
            DefaultMutableTreeNode c2=new DefaultMutableTreeNode("Choco Coffee");  
   	    DefaultMutableTreeNode c3=new DefaultMutableTreeNode("Choco Vanilla");  
    	    DefaultMutableTreeNode c4=new DefaultMutableTreeNode("Ferrero Rocher");  
            DefaultMutableTreeNode c5=new DefaultMutableTreeNode("HazelNut"); 
            DefaultMutableTreeNode c6=new DefaultMutableTreeNode("Choco-Truffle"); 
            DefaultMutableTreeNode c7=new DefaultMutableTreeNode("Choco-Loaded"); 
            Chocolate.add(c1);
            Chocolate.add(c2);
            Chocolate.add(c3);
            Chocolate.add(c4);
            Chocolate.add(c5);
            Chocolate.add(c6);
            Chocolate.add(c7);
 
  	    JTree jt=new JTree(cake1);
           l1.setBounds(210,50,600,40);
          l2.setBounds(150,100,600,40);
          l3.setBounds(100,150,800,40);
          l4.setBounds(150,200,800,100);
          l5.setBounds(100,300,800,40);
          jt.setBounds(150,350,500,400);

        //Components of panel4 Aboutus
          JLabel l6,l7,l8,l9,l10,l11,l12,l13,l14;
          l6=new JLabel("Hi good to see you here!");
        String text1="<html>Welcome to Our Mini Bakery! We offer Here various types of cakes with good quality!<br>Our speciality is offering Pure Homemade veg cakes with Complete Hygine.We can<br>Offer Customized Cake As Per Your Occasion.From our humble beginnings<br> in 2020, when the first manGs cakes store opened itsdoors at the Kothrud,<br>  we've grown to become a Pan-Pune chain of cakes, cupcakes across kothrud,bavdhan,baner and balewadi.Our mission is to spread happiness by serving <br>smiles on a plate, and this journey continues as we open manGs cakes across the country.<br></html>";
         l7=new JLabel(text1);

         l8=new JLabel("Our values:-");

         String text2="<html>-Authetic Recipes baked with love <br>-honestly priced<br>-Committed Quality and Hygine<br></html>";
         l9=new JLabel(text2);

         l10=new JLabel("Our Baker:-");
         l11=new JLabel("Manjiri Marne");
         String text3="<html>Manjiri Is a cake artist from Pune.She runs home based baking business called manGs cakes since 2020.Her creations are unique, artistic and customized to reflect the client's profession/ interests/ hobbies or anything else that the client wants. Baking is now her Part-time profession with education.<br></html>";
         l12=new JLabel(text3); 

         l13=new JLabel("Contact Us:-");
         String text4="<html>You can contact us via following details if you have any queries <br>Mobile no:-8080352937 <br>Mail-mangscakes@email.com</html>";
         l14=new JLabel(text4);
               Font fo6=new Font("Times New Roman",Font.BOLD,35);
               l6.setForeground(Color.RED);
               l6.setFont(fo6); 
             
               Font fo7=new Font("Times New Roman",Font.BOLD,18);
               l7.setForeground(Color.BLACK);
               l7.setFont(fo7);

               Font fo8=new Font("Times New Roman",Font.BOLD,30);
               l8.setForeground(Color.RED);
               l8.setFont(fo8);
            
               Font fo9=new Font("Times New Roman",Font.BOLD,18);
               l9.setForeground(Color.BLACK);
               l9.setFont(fo9);

              Font fo10=new Font("Times New Roman",Font.BOLD,30);
               l10.setForeground(Color.RED);
               l10.setFont(fo10);
            
               Font fo11=new Font("Times New Roman",Font.BOLD,25);
               l11.setForeground(Color.BLACK);
               l11.setFont(fo11);

               Font fo12=new Font("Times New Roman",Font.BOLD,18);
               l12.setForeground(Color.BLACK);
               l12.setFont(fo12);

               Font fo13=new Font("Times New Roman",Font.BOLD,30);
               l13.setForeground(Color.RED);
               l13.setFont(fo13);
          
               Font fo14=new Font("Times New Roman",Font.BOLD,18);
               l14.setForeground(Color.BLACK);
               l14.setFont(fo14);
  	   
          l6.setBounds(210,50,600,40);
          l7.setBounds(100,100,700,300);
          l8.setBounds(300,400,700,40);
          l9.setBounds(100,450,700,100);
          l10.setBounds(300,550,700,40);
          l11.setBounds(300,600,700,40);
          l12.setBounds(100,650,700,100);
          l13.setBounds(300,750,700,40);
          l14.setBounds(100,800,700,100);

	//feedback code
        cp= new Container();
        this.cp.setBackground(new java.awt.Color(0xA6E3E9));

        JLabel heading= new JLabel();
        heading.setText("FEEDBACK");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(370,50,440,45);
        this.cp.add(heading);

        JLabel lname= new JLabel();
        lname.setText("Name: ");
        lname.setFont(new Font("Calibri", Font.PLAIN, 18));
        lname.setBounds(200,150,80,28);
        this.cp.add(lname);

        tname = new JTextField();
        tname.setFont(new Font("Calibri", Font.PLAIN, 16));
        tname.setBounds(420, 150, 240, 28);
        this.cp.add(tname);

        JLabel lmail= new JLabel();
        lmail.setText("Email Address: ");
        lmail.setFont(new Font("Calibri", Font.PLAIN, 18));
        lmail.setBounds(200,220, 150, 28);
        this.cp.add(lmail);

        tmail = new JTextField();
        tmail.setFont(new Font("Calibri", Font.PLAIN, 16));
        tmail.setBounds(420, 220, 240, 28);
        this.cp.add(tmail);

        JLabel lrating= new JLabel();
        lrating.setText("Rating: ");
        lrating.setFont(new Font("Calibri", Font.PLAIN, 18));
        lrating.setBounds(200,300,100,28);
        this.cp.add(lrating);

        one=new JRadioButton("1");
        two=new JRadioButton("2");
        three=new JRadioButton("3");
        four=new JRadioButton("4");
        five=new JRadioButton("5");

        one.setBounds(420, 300, 40, 28);
        two.setBounds(470, 300, 40, 28);
        three.setBounds(520, 300, 40, 28);
        four.setBounds(570, 300, 40, 28);
        five.setBounds(620, 300, 40, 28);
        five.setSelected(true);

        cp.add(one);
        cp.add(two);
        cp.add(three);
        cp.add(four);
        cp.add(five);

        rating= new ButtonGroup();  //A buttongroup ensures only one of the 5 radio buttons are selected at a time
        rating.add(one);
        rating.add(two);
        rating.add(three);
        rating.add(four);
        rating.add(five);

        JLabel lfeedback= new JLabel();
        lfeedback.setText("Feedback (optional): ");
        lfeedback.setFont(new Font("Calibri", Font.PLAIN, 18));
        lfeedback.setBounds(200,380,170,28);
        this.cp.add(lfeedback);

        tfeedback = new JTextField();
        tfeedback.setFont(new Font("Calibri", Font.PLAIN, 16));
        tfeedback.setBounds(420, 380, 240, 84);
        this.cp.add(tfeedback);

        submit= new JButton("Submit");
        submit.setFont(new Font("Calibri", Font.PLAIN, 18));
        submit.setBounds(250, 540, 100, 28);
        submit.addActionListener(this);
        this.cp.add(submit);

        reset= new JButton("Reset");
        reset.setFont(new Font("Calibri", Font.PLAIN, 18));
        reset.setBounds(470, 540, 100, 28);
        reset.addActionListener(this);
        this.cp.add(reset);

	//Order form
		comboCakeType = new JComboBox();
		comboCakeType.addItem("Birthday Cake");
		comboCakeType.addItem("Wedding Cake");

		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JLabel heading1= new JLabel();
        		heading1.setText("Place Your Orders");
        		heading1.setFont(new Font("Arial", Font.BOLD, 30));
       		heading1.setBounds(300,20,440,45);
        		contentPane.add(heading1);
		
		lblname = new JLabel("Enter your Name:");
		lblname.setBounds(120, 80, 169, 20);
		contentPane.add(lblname);
		tbname=new JTextField();
		tbname.setBounds(120, 100, 193, 22);
		contentPane.add(tbname);

		lblphno= new JLabel("Enter your Phone No.:");
		lblphno.setBounds(120, 130, 169, 20);
		contentPane.add(lblphno);
		tbphno=new JTextField();
		tbphno.setBounds(120, 150, 193, 22);
		contentPane.add(tbphno);

		lbladdr= new JLabel("Enter your Address:");
		lbladdr.setBounds(120, 180, 169, 20);
		contentPane.add(lbladdr);
		tbaddr=new JTextArea(10,2);
		tbaddr.setBounds(120, 200, 193, 52);
		contentPane.add(tbaddr);

		lblTypeCake = new JLabel("Type of Cake:");
		lblTypeCake.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTypeCake.setBounds(120, 260, 169, 20);
		contentPane.add(lblTypeCake);
		
		comboCakeType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comboCakeType.removeAllItems();
				if(comboCakeType.getSelectedIndex() == 0) {
					lblRegularPrice.setText("500.00");
					lblRegularPrice.setBounds(260, 380, 77, 23);
					lblLargePrice.setText("850.00");
					lblLargePrice.setBounds(260, 400, 77, 23);
				}
				else{
				
					lblRegularPrice.setText("1200.00");
					lblRegularPrice.setBounds(260, 380, 77, 23);
					lblLargePrice.setText("1500.00");
					lblLargePrice.setBounds(260, 400, 77, 23);
				}
			}
		});
		comboCakeType.setBounds(120, 280, 193, 22);
		contentPane.add(comboCakeType);
		
		lblFlavors = new JLabel("Flavors:");
		lblFlavors.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFlavors.setBounds(120, 310, 169, 20);
		contentPane.add(lblFlavors);
		comboFlavors = new JComboBox();
		comboFlavors.setBounds(120, 330, 193, 22);
		comboFlavors.addItem("Chocolate");
		comboFlavors.addItem("Mocha");
		contentPane.add(comboFlavors);
		
		lblSizePrice = new JLabel("Size & Price:");
		lblSizePrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSizePrice.setBounds(120, 360, 169, 20);
		contentPane.add(lblSizePrice);
		
		rdoRegular = new JRadioButton("Regular");
		buttonGroup.add(rdoRegular);
		rdoRegular.setBackground(Color.LIGHT_GRAY);
		rdoRegular.setBounds(120, 380, 77, 23);
		contentPane.add(rdoRegular);
		
		rdoLarge = new JRadioButton("Large");
		buttonGroup.add(rdoLarge);
		rdoLarge.setBackground(Color.LIGHT_GRAY);
		rdoLarge.setBounds(120, 400, 77, 23);
		contentPane.add(rdoLarge);
		
		lblAddCandles = new JLabel("Add Candles:");
		lblAddCandles.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddCandles.setBounds(120, 430, 169, 20);
		contentPane.add(lblAddCandles);
		
		btnCandleMinus = new JButton("-");
		btnCandleMinus.setBackground(Color.YELLOW);
		btnCandleMinus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCandleMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCandles--;
				candlePrice -= 10;
				lblCandle1.setText(String.valueOf(addCandles));
			}
		});
		btnCandleMinus.setBounds(120, 455, 44, 38);
		contentPane.add(btnCandleMinus);
		
		lblCandle1 = new JLabel("1");
		lblCandle1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCandle1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandle1.setBounds(200, 455, 49, 48);
		contentPane.add(lblCandle1);
		
		btnCandlePlus = new JButton("+");
		btnCandlePlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCandles++;
				candlePrice += 10;
				lblCandle1.setText(String.valueOf(addCandles));
			}
		}
		);
		btnCandlePlus.setBackground(Color.GREEN);
		btnCandlePlus.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCandlePlus.setBounds(280, 455, 48, 38);
		contentPane.add(btnCandlePlus);
		
		lblAddLayer = new JLabel("Add Layer:");
		lblAddLayer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddLayer.setBounds(120, 500, 169, 20);
		contentPane.add(lblAddLayer);
		
		btnLayerMinus = new JButton("-");
		btnLayerMinus.setBackground(Color.YELLOW);
		btnLayerMinus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLayerMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addlayers--;
				layerPrice -= 50.00;
				lblLayer1.setText(String.valueOf(addlayers));
			}
		});
		btnLayerMinus.setBounds(120, 525, 44, 38);
		contentPane.add(btnLayerMinus);
		
		lblLayer1 = new JLabel("1");
		lblLayer1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayer1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLayer1.setBounds(200, 525, 49, 48);
		contentPane.add(lblLayer1);
		
		btnLayerPlus = new JButton("+");
		btnLayerPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addlayers++;
				layerPrice += 50.00;
				lblLayer1.setText(String.valueOf(addlayers));
			}
		});
		btnLayerPlus.setBackground(Color.GREEN);
		btnLayerPlus.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLayerPlus.setBounds(280, 525, 48, 38);
		contentPane.add(btnLayerPlus);
		
		btnBillOut = new JButton("Bill Out");
		btnBillOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderDetails();
			}
		});
		btnBillOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBillOut.setBounds(170, 600, 111, 23);
		contentPane.add(btnBillOut);
		
		lblOrderDetails = new JLabel("Order Details:");
		lblOrderDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOrderDetails.setBounds(430, 100, 169, 20);
		contentPane.add(lblOrderDetails);
		
		textAreaOrderDetails = new JTextArea();
		textAreaOrderDetails.setBounds(430, 150, 280, 389);
		contentPane.add(textAreaOrderDetails);
		
		lblRegularPrice = new JLabel("");
		contentPane.add(lblRegularPrice);
		
		lblLargePrice = new JLabel("");
		contentPane.add(lblLargePrice);
           
            //Panel creation
            JPanel p1=new JPanel();//Home
            p1.setLayout(null);
            JPanel p4=new JPanel();//about us
            p4.setLayout(null);
            
           //adding components of panel1(HomePage)
            p1.add(l1);
            p1.add(l2);
            p1.add(l3);
            p1.add(l4);
            p1.add(l5);
            p1.add(jt);
            
          //adding components of panel4(HomePage)
          p4.add(l6);
          p4.add(l7);
          p4.add(l8);
          p4.add(l9);
          p4.add(l10);
          p4.add(l11);
          p4.add(l12);
          p4.add(l13);
          p4.add(l14);

	final JScrollPane scrollPanel = new JScrollPane(p4,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPanel.setBounds(0, 0, 700, 700);
	p4.setPreferredSize(new Dimension(1920, 1080));

	try{
            tp1.add("Home",p1);
            tp1.add("Order",contentPane);
            tp1.add("FeedBack",cp);
            tp1.add("About Us",scrollPanel);
           }catch(Exception e)
	  { System.out.println("Exception is: "+e);
		}
            f1.add(tp1);
            
            }
		
    public void actionPerformed(ActionEvent e){
        boolean flag=false;
        String emailvalidation = "^[a-zA-Z0-9+_.-]+@(.+)$";  
        Pattern p= Pattern.compile(emailvalidation);
        Matcher mat= p.matcher(tmail.getText());
        f= new JFrame();

        if(e.getSource()==submit)
        {
            if((tname.getText().isEmpty()) || (tname.getText() == null))
            {
                JOptionPane.showMessageDialog(f, "Name cannot be empty");
            }
            else if((tmail.getText().isEmpty()) || (tmail.getText() == null))
            {
                JOptionPane.showMessageDialog(f, "Email cannot be empty");
            }
           else if(!mat.matches())
            {
                JOptionPane.showMessageDialog(f, "Please Enter a valid Email");
            }
            else
                flag=true; 
                
            if(flag)
            {
                String r;
                if(one.isSelected())
                    r="One star";
                else if(two.isSelected())
                    r="Two stars";
                else if(three.isSelected())
                    r="Three stars";    
                else if(four.isSelected())
                    r="Four stars";
                else
                    r="Five stars";
                String s1= "Thank you for your valuable Feeedback!\n\nYour Responses:-\n";
                String s2= "Name: "+tname.getText()+"\nEmail: "+tmail.getText()+"\nRating: "+r+"\nFeedback: "+tfeedback.getText();
                String disp=s1+s2;
                JOptionPane.showMessageDialog(f, disp);
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user_name="system";
		String pwd="sakshi";
		int ch=0;

		try {
			Class.forName(driver);
			
			Connection con= DriverManager.getConnection(url,user_name,pwd);
		    	PreparedStatement ps = con.prepareStatement("INSERT INTO feedback(name,email,rating,descr) VALUES (?,?,?,?)");
			ps.setString(1, (String) tname.getText());
			ps.setString(2, (String) tmail.getText());
			ps.setString(3, (String) r);
			ps.setString(4, (String) tfeedback.getText());
			int x = ps.executeUpdate();
			if(x > 0) {
				JOptionPane.showMessageDialog(null, "Order Details Saved.", null, JOptionPane.YES_OPTION);
				}
			else {
				JOptionPane.showMessageDialog(null, "Order Details Not Saved.", null, JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
            }
            
        }

        else if( e.getSource()==reset){
            tname.setText(null);
            tmail.setText(null);
            tfeedback.setText(null);
            one.setSelected(false); 
            two.setSelected(false);   
            three.setSelected(false); 
            four.setSelected(false); 
            five.setSelected(true);       
        }

    }

private String getCakeSize() {
		String size = "";
		if(rdoRegular.isSelected()) {
			size = rdoRegular.getText();
		}
		else
			size = rdoLarge.getText();
		
		return size;
	}
	
	private double getCakePrice() {
		double price = 0;
		
		if(rdoRegular.isSelected()) {
			price = Double.parseDouble(lblRegularPrice.getText());
		}
		else
			price = Double.parseDouble(lblLargePrice.getText());
		return price;
	}
	
	private double compute() {
		double totalPrice = 0;
		totalPrice = totalPrice + getCakePrice() + candlePrice + layerPrice; 
		return totalPrice;
	}
	
	private void orderDetails() {
		textAreaOrderDetails.setText("NAME: \t" + tbname.getText() +
						"\n\nPHONE NUMBER: " + tbphno.getText() +
						"\n\nADDRESS: \t" + tbaddr.getText() 
						+"\n\nCAKE: \t" + comboCakeType.getSelectedItem() + "\n\nFLAVOUR: \t" + comboFlavors.getSelectedItem()
		                             + "\n\nSIZE: \t" + getCakeSize() + "\n\nPRICE: \t" + getCakePrice()
		                             + "\n\nCANDLES: \t" + lblAddCandles.getText() + "x" + lblCandle1.getText() + "\t" + candlePrice 
		                             + "\n\nLAYERS: \t" + lblAddLayer.getText() + "x" + lblLayer1.getText() 
		                             + "\t" + layerPrice + "\n\n*****************************************"
		                             + "\n\nTOTAL PRICE: \t" + compute());
		
		Object cakeType, cakeFlovor, price, candlesNo, layersNo, orderD;
		
		cakeType = comboCakeType.getSelectedItem();
		cakeFlovor = comboFlavors.getSelectedItem();
		price = getCakePrice();
		candlesNo = lblCandle1.getText();
		layersNo = lblLayer1.getText();
		orderD = textAreaOrderDetails.getText();
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user_name="system";
		String pwd="sakshi";
		int ch=0;

		try {
			Class.forName(driver);
			
			Connection con= DriverManager.getConnection(url,user_name,pwd);
		    PreparedStatement ps = con.prepareStatement("INSERT INTO order_details(name,phno,address,cake_type,cake_flavor,candles,layers,tot_price) VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, (String) tbname.getText());
			ps.setString(2, (String) tbphno.getText());
			ps.setString(3, (String) tbaddr.getText());
			ps.setString(4, (String) comboCakeType.getSelectedItem());
			ps.setString(5, (String) comboFlavors.getSelectedItem());
			ps.setString(6, lblCandle1.getText());
			ps.setString(7, lblLayer1.getText());
			ps.setDouble(8, compute());
			int x = ps.executeUpdate();
			if(x > 0) {
				JOptionPane.showMessageDialog(null, "Order Details Saved.", null, JOptionPane.YES_OPTION);
				}
			else {
				JOptionPane.showMessageDialog(null, "Order Details Not Saved.", null, JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e1) {
			System.out.println(e1);
		}

	}
   
        public static void main(String args[])
           {
              dashboard tb=new dashboard();
              
            }

 }

