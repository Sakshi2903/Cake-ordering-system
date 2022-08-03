//HomePage
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.*; 

public class HomePage
{
     JLabel l1,l2,l3,l4,l5;
      
     public HomePage()
       {
          JFrame f1=new JFrame();
          f1.setSize(900,800);
          f1.setLayout(null);
          f1.setVisible(true);
          f1.setTitle("ManG's Cakes");
  
        
          f1.getContentPane().setBackground(Color.PINK);
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
          
          f1.add(l1);
          f1.add(l2);
          f1.add(l3);
          f1.add(l4);
          f1.add(l5);
          f1.add(jt);
          
         

        }
    public static void main(String args[])
       {
         HomePage a1=new HomePage();
        }
}