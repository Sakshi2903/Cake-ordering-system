import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class register extends JFrame implements ActionListener {

	// Components of the Form
	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tname;
	private JLabel mno;
	private JTextField tmno;
	private JLabel username;
	private JTextField uname;
	private JLabel password;
	private JPasswordField pass;
	private JCheckBox term;
	private JButton sub;
	private JButton reset;
	private JButton reg;
	private JTextArea tout;
	private JLabel res;
	private JTextArea resadd;

	public register()
	{
		setTitle("Registration Form");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);

		title = new JLabel("Registration Form");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		add(title);

		name = new JLabel("Name");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		name.setSize(100, 20);
		name.setLocation(100, 100);
		add(name);

		tname = new JTextField();
		tname.setFont(new Font("Arial", Font.PLAIN, 15));
		tname.setSize(190, 20);
		tname.setLocation(200, 100);
		add(tname);

		mno = new JLabel("Mobile");
		mno.setFont(new Font("Arial", Font.PLAIN, 20));
		mno.setSize(100, 20);
		mno.setLocation(100, 150);
		add(mno);

		tmno = new JTextField();
		tmno.setFont(new Font("Arial", Font.PLAIN, 15));
		tmno.setSize(150, 20);
		tmno.setLocation(200, 150);
		add(tmno);

		username = new JLabel("Username");
		username.setFont(new Font("Arial", Font.PLAIN, 20));
		username.setSize(100, 20);
		username.setLocation(100, 200);
		add(username);

		uname = new JTextField();
		uname.setFont(new Font("Arial", Font.PLAIN, 15));
		uname.setSize(100,20);
		uname.setLocation(200, 200);
		add(uname);

		password = new JLabel("Password");
		password.setFont(new Font("Arial", Font.PLAIN, 20));
		password.setSize(100, 20);
		password.setLocation(100, 250);
		add(password);

		pass = new JPasswordField();
		pass.setFont(new Font("Arial", Font.PLAIN, 20));
		pass.setSize(100, 20);
		pass.setLocation(200, 250);
		add(pass);

		term = new JCheckBox("Accept Terms And Conditions.");
        		term.setFont(new Font("Arial", Font.PLAIN, 15));
        		term.setSize(250, 20);
        		term.setLocation(150, 300);
       		add(term);

		sub = new JButton("Confirm details");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setSize(150, 20);
		sub.setLocation(100, 350);
		sub.addActionListener(this);
		add(sub);

		reset = new JButton("Reset");
		reset.setFont(new Font("Arial", Font.PLAIN, 15));
		reset.setSize(100, 20);
		reset.setLocation(300, 350);
		reset.addActionListener(this);
		add(reset);

		tout = new JTextArea();
		tout.setFont(new Font("Arial", Font.PLAIN, 15));
		tout.setSize(300, 200);
		tout.setLocation(500, 100);
		tout.setLineWrap(true);
		tout.setEditable(false);
		add(tout);

		reg = new JButton("Register");
		reg.setFont(new Font("Arial", Font.PLAIN, 15));
		reg.setSize(100, 20);
		reg.setLocation(600, 310);
		reg.addActionListener(this);
		add(reg);

		res = new JLabel("");
		res.setFont(new Font("Arial", Font.PLAIN, 20));
		res.setSize(500, 25);
		res.setLocation(100, 400);
		add(res);

		resadd = new JTextArea();
		resadd.setFont(new Font("Arial", Font.PLAIN, 15));
		resadd.setSize(200, 75);
		resadd.setLocation(580, 175);
		resadd.setLineWrap(true);
		add(resadd);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == sub) {
			if (term.isSelected()) {
				String data1;
				String data= "Name : "+ tname.getText() + "\n"+ "Mobile : "+ tmno.getText() + "\n";
				data1="Username: "+uname.getText()+"\n"+"Password: "+pass.getText();
				tout.setText(data + data1);
				tout.setEditable(false);
			}
			else {
				tout.setText("");
				resadd.setText("");
				res.setText("Please accept the terms & conditions..");
			}
		}

		else if (e.getSource() == reset) {
			String def = "";
			tname.setText("");
			tmno.setText("");
			uname.setText("");
			pass.setText("");
		}

		else if(e.getSource()==reg){
			//fetching all values
			String p1,p2,p3,p4;
			p1=tname.getText();
			p2=tmno.getText();
			p3=uname.getText();
			p4=pass.getText();
	
			//connecting to databse
			String driver="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String username="system";
			String pass="sakshi";
			int ch=0;
		
			try {
				Class.forName(driver);
			
				Connection con=DriverManager.getConnection(url,username,pass);
				String sql="insert into details values(?,?,?,?)";
				PreparedStatement stat = (PreparedStatement) con.prepareStatement(sql);
				stat.setString(1,p1);
				stat.setString(2,p2);
				stat.setString(3,p3);
				stat.setString(4,p4);

				int r=stat.executeUpdate();
				if(r>0)
				{
					login i=new login();
				}
				else
				{
					res.setText("Registration failed!");
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		new register();
	}
}

