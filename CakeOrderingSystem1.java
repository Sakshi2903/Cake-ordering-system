import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;

public class CakeOrderingSystem1 extends JFrame {

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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				try {
					CakeOrderingSystem1 frame = new CakeOrderingSystem1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	
	
	//METHODS
	
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

	
	
	public CakeOrderingSystem1() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				comboCakeType.addItem("Birthday Cake");
				comboCakeType.addItem("Wedding Cake");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 688);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblname = new JLabel("Enter your Name:");
		lblname.setBounds(10, 21, 169, 20);
		contentPane.add(lblname);
		tbname=new JTextField();
		tbname.setBounds(20, 40, 193, 22);
		contentPane.add(tbname);

		lblphno= new JLabel("Enter your Phone No.:");
		lblphno.setBounds(10, 71, 169, 20);
		contentPane.add(lblphno);
		tbphno=new JTextField();
		tbphno.setBounds(20, 90, 193, 22);
		contentPane.add(tbphno);

		lbladdr= new JLabel("Enter your Address:");
		lbladdr.setBounds(10, 121, 169, 20);
		contentPane.add(lbladdr);
		tbaddr=new JTextArea(10,2);
		tbaddr.setBounds(20, 140, 193, 52);
		contentPane.add(tbaddr);

		lblTypeCake = new JLabel("Type of Cake:");
		lblTypeCake.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTypeCake.setBounds(10, 200, 169, 20);
		contentPane.add(lblTypeCake);
		
		comboCakeType = new JComboBox();
		comboCakeType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comboCakeType.removeAllItems();
				if(comboCakeType.getSelectedIndex() == 0) {
					
					lblRegularPrice.setText("500.00");
					lblRegularPrice.setBounds(180, 320, 77, 23);
					lblLargePrice.setText("850.00");
					lblLargePrice.setBounds(180, 340, 77, 23);
				}
				else if(comboCakeType.getSelectedIndex() == 1){
				
					lblRegularPrice.setText("1200.00");
					lblLargePrice.setText("1500.00");
				}
			}
		});
		comboCakeType.setBounds(20, 220, 193, 22);
		contentPane.add(comboCakeType);
		
		lblFlavors = new JLabel("Flavors:");
		lblFlavors.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFlavors.setBounds(10, 245, 169, 20);
		contentPane.add(lblFlavors);
		comboFlavors = new JComboBox();
		comboFlavors.setBounds(20, 263, 193, 22);
		comboFlavors.addItem("Chocolate");
		comboFlavors.addItem("Mocha");
		contentPane.add(comboFlavors);
		
		lblSizePrice = new JLabel("Size & Price:");
		lblSizePrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSizePrice.setBounds(10, 290, 169, 20);
		contentPane.add(lblSizePrice);
		
		rdoRegular = new JRadioButton("Regular");
		buttonGroup.add(rdoRegular);
		rdoRegular.setBackground(Color.LIGHT_GRAY);
		rdoRegular.setBounds(20, 320, 77, 23);
		contentPane.add(rdoRegular);
		
		rdoLarge = new JRadioButton("Large");
		buttonGroup.add(rdoLarge);
		rdoLarge.setBackground(Color.LIGHT_GRAY);
		rdoLarge.setBounds(20, 340, 77, 23);
		contentPane.add(rdoLarge);
		
		lblAddCandles = new JLabel("Add Candles:");
		lblAddCandles.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddCandles.setBounds(10, 370, 169, 20);
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
		btnCandleMinus.setBounds(20, 400, 44, 38);
		contentPane.add(btnCandleMinus);
		
		lblCandle1 = new JLabel("1");
		lblCandle1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCandle1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandle1.setBounds(88, 390, 49, 48);
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
		btnCandlePlus.setBounds(159, 400, 48, 38);
		contentPane.add(btnCandlePlus);
		
		lblAddLayer = new JLabel("Add Layer:");
		lblAddLayer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddLayer.setBounds(10, 445, 169, 20);
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
		btnLayerMinus.setBounds(20, 470, 44, 38);
		contentPane.add(btnLayerMinus);
		
		lblLayer1 = new JLabel("1");
		lblLayer1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLayer1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLayer1.setBounds(88, 460, 49, 48);
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
		btnLayerPlus.setBounds(159, 470, 48, 38);
		contentPane.add(btnLayerPlus);
		
		btnBillOut = new JButton("Bill Out");
		btnBillOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderDetails();
			}
		});
		btnBillOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBillOut.setBounds(42, 530, 111, 23);
		contentPane.add(btnBillOut);
		
		lblOrderDetails = new JLabel("Order Details:");
		lblOrderDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOrderDetails.setBounds(241, 24, 169, 20);
		contentPane.add(lblOrderDetails);
		
		textAreaOrderDetails = new JTextArea();
		textAreaOrderDetails.setBounds(241, 51, 280, 389);
		contentPane.add(textAreaOrderDetails);
		
		lblRegularPrice = new JLabel("");
		contentPane.add(lblRegularPrice);
		
		lblLargePrice = new JLabel("");
		contentPane.add(lblLargePrice);
	}
}
