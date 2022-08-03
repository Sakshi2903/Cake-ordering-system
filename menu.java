import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.sql.*;

public class menu implements ActionListener
{

	JFrame f;
	menu()
	{
		f = new JFrame("Menu");
		f.setVisible(true);
		f.setSize(700,700);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.PINK);

		Font ft=new Font("Times New Roman",Font.BOLD,32);
		JLabel jb=new JLabel("ManG's Cakes");
		jb.setFont(ft);
		jb.setSize(100,100);
		jb.setBounds(240,10,200,200);

		JButton log=new JButton("Login");
		log.setBounds(100,250,200,200);
		log.setBackground(Color.CYAN);
		log.setFont(ft);
		JButton reg=new JButton("Register");
		reg.setBounds(360,250,200,200);
		reg.setBackground(Color.CYAN);
		reg.setFont(ft);

		f.add(jb);
		f.add(log);
		log.addActionListener(this);
		f.add(reg);
		reg.addActionListener(this);
	}
	public static void main(String args[])
	{
		new menu();
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand()=="Login")
		{
			login g=new login();
			f.setVisible(false);
		}
		else if(ae.getActionCommand()=="Register")
		{
			register r=new register();
			f.setVisible(false);
		}
	}
}