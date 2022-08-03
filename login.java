import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
class login implements ActionListener {

	JFrame f=new JFrame("Login");
	JLabel userLabel=new JLabel("USERNAME");
    	JLabel passwordLabel=new JLabel("PASSWORD");
    	JTextField userTextField=new JTextField();
    	JPasswordField passwordField=new JPasswordField();
    	JButton loginButton=new JButton("LOGIN");
    	JButton resetButton=new JButton("RESET");
    	JCheckBox showPassword=new JCheckBox("Show Password");
	JLabel fail = new JLabel();
 
	login()
    	{
		f.setLayout(null);
		f.setVisible(true);
		f.setBounds(10,10,370,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		f.setResizable(false);

		//Setting location and Size of each components using setBounds() method.
       		userLabel.setBounds(50,150,100,30);
       		passwordLabel.setBounds(50,220,100,30);
       		userTextField.setBounds(150,150,150,30);
       		passwordField.setBounds(150,220,150,30);
       		showPassword.setBounds(150,250,150,30);
       		loginButton.setBounds(50,300,100,30);
       		resetButton.setBounds(200,300,100,30);
		fail.setBounds(140,350,100,30);

		//Adding each components to the Container
       		f.add(userLabel);
       		f.add(passwordLabel);
       		f.add(userTextField);
       		f.add(passwordField);
       		f.add(showPassword);
       		f.add(loginButton);
       		f.add(resetButton);
		f.add(fail);

		//adding Action listener to components
       		loginButton.addActionListener(this);
       		resetButton.addActionListener(this);
       		showPassword.addActionListener(this);
 
    	}

	public static void main(String[] args)
	{
		new login();
    	}
 
    	public void actionPerformed(ActionEvent e) {
		//Coding Part of LOGIN button
       		if (e.getSource() == loginButton) 
		{
            		String userText;
            		String pwdText;
           		userText = (userTextField.getText()).toString();
			pwdText=String.valueOf(passwordField.getPassword());

			//connecting to databse
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String pass="sakshi";
			int ch=0;
		
			try {
				Class.forName(driver);
			
				Connection con=DriverManager.getConnection(url,username,pass);
				String sql="Select username, password from details where username='"+userText+"' and password='"+pwdText+"'";
				PreparedStatement stat = (PreparedStatement) con.prepareStatement(sql);

				ResultSet result=stat.executeQuery();
				if (result.next()) {
                       			dashboard d = new dashboard();
					f.setVisible(false);
                    		} else {
                        			fail.setText("Login failed!");
                    		}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
        		}
        
		//Coding Part of RESET button
        		if (e.getSource() == resetButton) 
		{
            		userTextField.setText("");
            		passwordField.setText("");
        		}
       
		//Coding Part of showPassword JCheckBox
        		if (e.getSource() == showPassword) 
		{
            		if (showPassword.isSelected()) {
                			passwordField.setEchoChar((char) 0);
            		} 
			else {
                			passwordField.setEchoChar('*');
            		}
 		}
   	}
}