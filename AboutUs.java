//About us and Contact us
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.*; 

public class AboutUs
{
     JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
      
     public AboutUs() 
       {
          JFrame f1=new JFrame();
          f1.setSize(900,900);
          f1.setLayout(null);
          f1.setVisible(true);
          f1.setTitle("ManG's Cakes");
          f1.getContentPane().setBackground(Color.PINK);
          
         l1=new JLabel("Hi good to see you here!");
        String text="<html>Welcome to Our Mini Bakery! We offer Here various types of cakes with good quality!<br>Our speciality is offering Pure Homemade veg cakes with Complete Hygine.We can<br>Offer Customized Cake As Per Your Occasion.From our humble beginnings<br> in 2020, when the first manGs cakes store opened itsdoors at the Kothrud,<br>  we've grown to become a Pan-Pune chain of cakes, cupcakes across kothrud,bavdhan,baner and balewadi.Our mission is to spread happiness by serving <br>smiles on a plate, and this journey continues as we open manGs cakes across the country.<br></html>";
         l2=new JLabel(text);

         l3=new JLabel("Our values:-");

         String text1="<html>-Authetic Recipes baked with love <br>-honestly priced<br>-Committed Quality and Hygine<br></html>";
         l4=new JLabel(text1);

         l5=new JLabel("Our Baker:-");
         l6=new JLabel("Manjiri Marne");
         String text2="<html>Manjiri Is a cake artist from Pune.She runs home based baking business called manGs cakes since 2020.Her creations are unique, artistic and customized to reflect the client's profession/ interests/ hobbies or anything else that the client wants. Baking is now her Part-time profession with education.<br></html>";
         l7=new JLabel(text2); 

         l8=new JLabel("Contact Us:-");
         String text3="<html>You can contact us via following details if you have any queries <br>Mobile no:-8080352937 <br>Mail-mangscakes@email.com</html>";
         l9=new JLabel(text3);
               Font fo1=new Font("Times New Roman",Font.BOLD,35);
               l1.setForeground(Color.RED);
               l1.setFont(fo1); 
             
               Font fo2=new Font("Times New Roman",Font.BOLD,18);
               l2.setForeground(Color.BLACK);
               l2.setFont(fo2);

               Font fo3=new Font("Times New Roman",Font.BOLD,30);
               l3.setForeground(Color.RED);
               l3.setFont(fo3);
            
               Font fo4=new Font("Times New Roman",Font.BOLD,18);
               l4.setForeground(Color.BLACK);
               l4.setFont(fo4);

              Font fo5=new Font("Times New Roman",Font.BOLD,30);
               l5.setForeground(Color.RED);
               l5.setFont(fo5);
            
               Font fo6=new Font("Times New Roman",Font.BOLD,25);
               l6.setForeground(Color.BLACK);
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
  	   
          l1.setBounds(210,50,600,40);
          l2.setBounds(100,100,700,300);
          l3.setBounds(300,400,700,40);
          l4.setBounds(100,450,700,100);
          l5.setBounds(300,550,700,40);
          l6.setBounds(300,600,700,40);
          l7.setBounds(100,650,700,100);
          l8.setBounds(300,750,700,40);
          l9.setBounds(100,800,700,100);
          f1.add(l1);
          f1.add(l2);
          f1.add(l3);
          f1.add(l4);
          f1.add(l5);
          f1.add(l6);
          f1.add(l7);
           f1.add(l8);
          f1.add(l9);

        }
    public static void main(String args[])
       {
         AboutUs a1=new AboutUs();
        }
}