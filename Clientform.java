import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Clientform extends JFrame implements ActionListener{
    
    JButton submit;     //global variables
    JButton reset;
    JTextField tname;
    JTextField tmail;
    JTextField tfeedback;
    JFrame f;
    JRadioButton one;
    JRadioButton two;
    JRadioButton three;
    JRadioButton four;
    JRadioButton five;
    ButtonGroup rating;
    JPanel cp;
   
    public Clientform(){
	cp=new JPanel();
	cp.setSize(800,800);
        cp.setBackground(new java.awt.Color(0xA6E3E9));

        JLabel heading= new JLabel();
        heading.setText("FEEDBACK");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(200,0,440,45);
        cp.add(heading);


        JLabel lname= new JLabel();
        lname.setText("Name: ");
        lname.setFont(new Font("Calibri", Font.PLAIN, 18));
        lname.setBounds(50,60,80,28);
        cp.add(lname);

        tname = new JTextField();
        tname.setFont(new Font("Calibri", Font.PLAIN, 16));
        tname.setBounds(230, 60, 240, 28);
        cp.add(tname);

        JLabel lmail= new JLabel();
        lmail.setText("Email Address: ");
        lmail.setFont(new Font("Calibri", Font.PLAIN, 18));
        lmail.setBounds(50,110, 150, 28);
        cp.add(lmail);

        tmail = new JTextField();
        tmail.setFont(new Font("Calibri", Font.PLAIN, 16));
        tmail.setBounds(230, 105, 240, 28);
        cp.add(tmail);

        JLabel lrating= new JLabel();
        lrating.setText("Rating: ");
        lrating.setFont(new Font("Calibri", Font.PLAIN, 18));
        lrating.setBounds(50,160,100,28);
        cp.add(lrating);


        one=new JRadioButton("1");
        two=new JRadioButton("2");
        three=new JRadioButton("3");
        four=new JRadioButton("4");
        five=new JRadioButton("5");

        one.setBounds(230, 160, 40, 28);
        two.setBounds(280, 160, 40, 28);
        three.setBounds(330, 160, 40, 28);
        four.setBounds(380, 160, 40, 28);
        five.setBounds(430, 160, 40, 28);
        five.setSelected(true);

        this.add(one);
        this.add(two);
        this.add(three);
        this.add(four);
        this.add(five);

        rating= new ButtonGroup();  //A buttongroup ensures only one of the 5 radio buttons are selected at a time
        rating.add(one);
        rating.add(two);
        rating.add(three);
        rating.add(four);
        rating.add(five);

        JLabel lfeedback= new JLabel();
        lfeedback.setText("Feedback (optional): ");
        lfeedback.setFont(new Font("Calibri", Font.PLAIN, 18));
        lfeedback.setBounds(50,230,170,28);
        cp.add(lfeedback);

        tfeedback = new JTextField();
        tfeedback.setFont(new Font("Calibri", Font.PLAIN, 16));
        tfeedback.setBounds(230, 230, 240, 84);
        cp.add(tfeedback);

        submit= new JButton("Submit");
        submit.setFont(new Font("Calibri", Font.PLAIN, 18));
        submit.setBounds(165, 350, 100, 28);
        submit.addActionListener(this);
        cp.add(submit);

        reset= new JButton("Reset");
        reset.setFont(new Font("Calibri", Font.PLAIN, 18));
        reset.setBounds(275, 350, 100, 28);
        reset.addActionListener(this);
        cp.add(reset);

        this.setVisible(true);
    }

    //@Override
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
public static void main(String args[]) throws Exception{
        Clientform cf= new Clientform();
    }
}
