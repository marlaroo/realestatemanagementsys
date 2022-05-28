package rent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Admin.Home;
import Admin.MainUI;
import Owner.OwnerUI;
import buy.buyUI;
import customer.ClientUI;
import customer.CustomerTableModel;
import customer.customer;
import property.PropertyTableModel;
import property.PropertyUI;
import property.property;
import property.propertyDAO;
import property.propertyupdateanddeleteUI;
import property_type.typeUI;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RentUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfownername;
	private JTextField tfcustomername;
	private JTextField tfprice;
	private JTextField tfdeposite;
	private JTextField tffromdate;
	private JTextField tftodate;
	private JTable rentlisttable;
	private JTable rentclientlisttable;
	private JTable rentpropertylisttable;
	private JTextField tfpropertyname;
	private JTextField tfaddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentUI frame = new RentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RentUI() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setMargin(new Insets(500, 200, 100, 50));
		menuBar.setForeground(new Color(210, 105, 30));
		menuBar.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		menuBar.setBackground(new Color(0, 0, 0));
		setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("HOME");
		mnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Home().setVisible(true);
				new PropertyUI().setVisible(false);
				
				
			
			}
		});
		mnHome.setIcon(new ImageIcon(MainUI.class.getResource("/img/home-icon.png")));
		mnHome.setHorizontalAlignment(SwingConstants.CENTER);
		mnHome.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		mnHome.setForeground(new Color(205, 133, 63));
		mnHome.setBackground(new Color(205, 133, 63));
		menuBar.add(mnHome);
		
		JMenu mnProperty = new JMenu("PROPERTY");
		mnProperty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new PropertyUI().setVisible(true);
				
			}
		});
		mnProperty.setIcon(new ImageIcon(MainUI.class.getResource("/img/property-icon.png")));
		mnProperty.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		mnProperty.setForeground(new Color(205, 133, 63));
		mnProperty.setBackground(new Color(210, 105, 30));
		menuBar.add(mnProperty);
		
		JMenu mnType = new JMenu("TYPE");
		mnType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new typeUI().setVisible(true);
			}
		});
		
		mnType.setIcon(new ImageIcon(MainUI.class.getResource("/img/Property-Type-icon.png")));
		mnType.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		mnType.setForeground(new Color(205, 133, 63));
		mnType.setBackground(new Color(210, 105, 30));
		menuBar.add(mnType);
		
		JMenu mnOwner = new JMenu("OWNER");
		mnOwner.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new OwnerUI().setVisible(true);
			}
		});
		mnOwner.setIcon(new ImageIcon(MainUI.class.getResource("/img/owner_icon.png")));
		mnOwner.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		mnOwner.setForeground(new Color(205, 133, 63));
		mnOwner.setBackground(new Color(210, 105, 30));
		menuBar.add(mnOwner);
		
		JMenu mnClient = new JMenu("CLIENT");
		mnClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new ClientUI().setVisible(true);
			}
		});
		mnClient.setIcon(new ImageIcon(MainUI.class.getResource("/img/client-icon.png")));
		mnClient.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		mnClient.setForeground(new Color(205, 133, 63));
		mnClient.setBackground(new Color(210, 105, 30));
		menuBar.add(mnClient);
		
		JMenu mnRent = new JMenu("RENT");
		mnRent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new RentUI().setVisible(true);
			}
		});
		mnRent.setIcon(new ImageIcon(MainUI.class.getResource("/img/rent_icon.png")));
		mnRent.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		mnRent.setForeground(new Color(205, 133, 63));
		mnRent.setBackground(new Color(210, 105, 30));
		menuBar.add(mnRent);
		
		JMenu mnSell = new JMenu("SALE");
		mnSell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new buyUI().setVisible(true);
			}
		});
		mnSell.setIcon(new ImageIcon(MainUI.class.getResource("/img/sell_icon.png")));
		mnSell.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		mnSell.setForeground(new Color(205, 133, 63));
		mnSell.setBackground(new Color(210, 105, 30));
		menuBar.add(mnSell);
		//**content pane***//
		setBackground(new Color(205, 133, 63));
		setForeground(Color.ORANGE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainUI.class.getResource("/img/finallogoend.jpg")));
		setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		setTitle("REAL ESTATE MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 133, 63));
		contentPane.setForeground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelrent = new JPanel();
		panelrent.setLayout(null);
		panelrent.setBackground(new Color(205, 133, 63));
		panelrent.setBounds(0, 0, 1114, 700);
		contentPane.add(panelrent);
		
		JDesktopPane desktoprent = new JDesktopPane();
		desktoprent.setBackground(Color.BLACK);
		desktoprent.setBounds(0, 0, 315, 700);
		panelrent.add(desktoprent);
		
		JLabel lblpropertyownername = new JLabel("OWNER");
		lblpropertyownername.setForeground(new Color(205, 133, 63));
		lblpropertyownername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblpropertyownername.setBounds(10, 55, 140, 28);
		desktoprent.add(lblpropertyownername);
		
		tfownername = new JTextField();
		tfownername.setForeground(Color.BLACK);
		tfownername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfownername.setColumns(10);
		tfownername.setBackground(new Color(205, 133, 63));
		tfownername.setBounds(142, 48, 146, 38);
		desktoprent.add(tfownername);
		
		JLabel lblNewLabel_1_1 = new JLabel("RENT INFORMATION");
		lblNewLabel_1_1.setForeground(new Color(205, 133, 63));
		lblNewLabel_1_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(35, 10, 258, 28);
		desktoprent.add(lblNewLabel_1_1);
		
		JLabel lblrentcustomerid = new JLabel("CUSTOMER");
		lblrentcustomerid.setForeground(new Color(205, 133, 63));
		lblrentcustomerid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentcustomerid.setBounds(10, 109, 140, 28);
		desktoprent.add(lblrentcustomerid);
		
		tfcustomername = new JTextField();
		tfcustomername.setForeground(Color.BLACK);
		tfcustomername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfcustomername.setColumns(10);
		tfcustomername.setBackground(new Color(205, 133, 63));
		tfcustomername.setBounds(142, 105, 146, 38);
		desktoprent.add(tfcustomername);
		
		JButton btnAdd_1 = new JButton("ADD");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ownername=tfownername.getText().trim();
				String customername=tfcustomername.getText().trim();
				int price=Integer.parseInt(tfprice.getText().trim());
				int deposite=Integer.parseInt(tfdeposite.getText().trim());
				String fromdate=tffromdate.getText().trim();
				String todate=tftodate.getText().trim();
				//int propertyname=Integer.parseInt(tfpropertyname.getText().trim());
				String propertyname=tfpropertyname.getText().trim();

				String address=tfaddress.getText().trim();
				
				//String date=java.time.LocalDate.now().toString();
				

				//rent re=new rent(0,ownername,customername,price,deposite,fromdate,todate,propertyname,address);
				rent re=new rent(0,ownername,customername,price,deposite,fromdate,todate,propertyname,address);
//				re.setPrice(price);
//				re.setDeposite(deposite);
//				re.setFrom_date(fromdate);
//				re.setTo_date(todate);
//				re.setProperty_id(propertyid);
//				re.setCustomer_id(customerid);
				
				try {
					rentDAO rentdao= new rentDAO();
					int y=JOptionPane.showConfirmDialog(null,"Do yor really save!");
					if(y==JOptionPane.YES_OPTION) {
						String ans=rentdao.addrent(re);
						JOptionPane.showMessageDialog(null,ans,"finished process",JOptionPane.INFORMATION_MESSAGE);
					}
					

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				tfprice.setText(null);
				tfdeposite.setText(null);
				tffromdate.setText(null);
				tftodate.setText(null);
				tfownername.setText(null);
				tfcustomername.setText(null);
				tfpropertyname.setText(null);
				tfaddress.setText(null);
			}
		});
		btnAdd_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnAdd_1.setFocusPainted(false);
		btnAdd_1.setBorderPainted(false);
		btnAdd_1.setBackground(new Color(210, 180, 140));
		btnAdd_1.setBounds(15, 513, 273, 43);
		desktoprent.add(btnAdd_1);
		
		JButton btnEdit_1 = new JButton("Edit");
		btnEdit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rentDAO rentdao=new rentDAO();
					setVisible(false);
									
					rent re= rentdao.getAllrent().get(rentlisttable.getSelectedRow());
					new rentupdateanddeleteUI(re).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEdit_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnEdit_1.setFocusPainted(false);
		btnEdit_1.setBorderPainted(false);
		btnEdit_1.setBackground(new Color(210, 180, 140));
		btnEdit_1.setBounds(15, 584, 273, 43);
		desktoprent.add(btnEdit_1);
		
		JButton btnRemove_1 = new JButton("REMOVE");
		btnRemove_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					rentDAO rentdao=new rentDAO();
					setVisible(false);
									
					rent re= rentdao.getAllrent().get(rentlisttable.getSelectedRow());
					new rentupdateanddeleteUI(re).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRemove_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnRemove_1.setFocusPainted(false);
		btnRemove_1.setBorderPainted(false);
		btnRemove_1.setBackground(new Color(210, 180, 140));
		btnRemove_1.setBounds(15, 647, 273, 43);
		desktoprent.add(btnRemove_1);
		
		JLabel lblrentPrice = new JLabel("PRICE");
		lblrentPrice.setForeground(new Color(205, 133, 63));
		lblrentPrice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentPrice.setBounds(21, 167, 111, 28);
		desktoprent.add(lblrentPrice);
		
		tfprice = new JTextField();
		tfprice.setForeground(Color.BLACK);
		tfprice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfprice.setColumns(10);
		tfprice.setBackground(new Color(205, 133, 63));
		tfprice.setBounds(142, 163, 146, 38);
		desktoprent.add(tfprice);
		
		JLabel lblrentdeposite = new JLabel("DEPOSITE");
		lblrentdeposite.setForeground(new Color(205, 133, 63));
		lblrentdeposite.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentdeposite.setBounds(21, 227, 111, 28);
		desktoprent.add(lblrentdeposite);
		
		tfdeposite = new JTextField();
		tfdeposite.setForeground(Color.BLACK);
		tfdeposite.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfdeposite.setColumns(10);
		tfdeposite.setBackground(new Color(205, 133, 63));
		tfdeposite.setBounds(142, 223, 146, 38);
		desktoprent.add(tfdeposite);
		
		JLabel lblrentfromdate = new JLabel("FROM DATE");
		lblrentfromdate.setForeground(new Color(205, 133, 63));
		lblrentfromdate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentfromdate.setBounds(21, 292, 111, 28);
		desktoprent.add(lblrentfromdate);
		
		tffromdate = new JTextField();
		tffromdate.setForeground(Color.BLACK);
		tffromdate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tffromdate.setColumns(10);
		tffromdate.setBackground(new Color(205, 133, 63));
		tffromdate.setBounds(142, 288, 146, 38);
		desktoprent.add(tffromdate);
		
		JLabel lblrenttodate = new JLabel("TO DATE");
		lblrenttodate.setForeground(new Color(205, 133, 63));
		lblrenttodate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrenttodate.setBounds(21, 348, 111, 28);
		desktoprent.add(lblrenttodate);
		
		tftodate = new JTextField();
		tftodate.setForeground(Color.BLACK);
		tftodate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tftodate.setColumns(10);
		tftodate.setBackground(new Color(205, 133, 63));
		tftodate.setBounds(142, 344, 146, 38);
		desktoprent.add(tftodate);
		
		JLabel lblproperty = new JLabel("PROPERTY");
		lblproperty.setForeground(new Color(205, 133, 63));
		lblproperty.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblproperty.setBounds(20, 408, 111, 28);
		desktoprent.add(lblproperty);
		
		tfpropertyname = new JTextField();
		tfpropertyname.setForeground(Color.BLACK);
		tfpropertyname.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfpropertyname.setColumns(10);
		tfpropertyname.setBackground(new Color(205, 133, 63));
		tfpropertyname.setBounds(142, 404, 146, 38);
		desktoprent.add(tfpropertyname);
		
		JLabel lblAddress_1 = new JLabel("ADDRESS");
		lblAddress_1.setForeground(new Color(205, 133, 63));
		lblAddress_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblAddress_1.setBounds(21, 469, 111, 28);
		desktoprent.add(lblAddress_1);
		
		tfaddress = new JTextField();
		tfaddress.setForeground(Color.BLACK);
		tfaddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfaddress.setColumns(10);
		tfaddress.setBackground(new Color(205, 133, 63));
		tfaddress.setBounds(142, 465, 146, 38);
		desktoprent.add(tfaddress);
		
		JScrollPane scrollPanerent = new JScrollPane();
		scrollPanerent.setBounds(313, 52, 335, 515);
		panelrent.add(scrollPanerent);
		
		rentlisttable = new JTable();
		rentlisttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfownername.setText(rentlisttable.getValueAt(rentlisttable.getSelectedRow(), 1).toString());
				tfcustomername.setText(rentlisttable.getValueAt(rentlisttable.getSelectedRow(), 2).toString());
				tfprice.setText(rentlisttable.getValueAt(rentlisttable.getSelectedRow(),3).toString());
				tfdeposite.setText(rentlisttable.getValueAt(rentlisttable.getSelectedRow(),4).toString());
				tffromdate.setText(rentlisttable.getValueAt(rentlisttable.getSelectedRow(), 5).toString());
				tftodate.setText(rentlisttable.getValueAt(rentlisttable.getSelectedRow(), 6).toString());
				tfpropertyname.setText(rentlisttable.getValueAt(rentlisttable.getSelectedRow(), 7).toString());
				tfaddress.setText(rentlisttable.getValueAt(rentlisttable.getSelectedRow(), 8).toString());
				
			}
		});
		rentlisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		rentlisttable.setForeground(new Color(210, 180, 140));
		rentlisttable.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		rentlisttable.setBackground(new Color(0, 0, 0));
		scrollPanerent.setViewportView(rentlisttable);
		
		JScrollPane scrollPaneclientlist = new JScrollPane();
		scrollPaneclientlist.setBounds(658, 52, 198, 515);
		panelrent.add(scrollPaneclientlist);
		
		rentclientlisttable = new JTable();
		rentclientlisttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfcustomername.setText(rentclientlisttable.getValueAt(rentclientlisttable.getSelectedRow(),1).toString());
			}
		});
		rentclientlisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		rentclientlisttable.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		rentclientlisttable.setForeground(new Color(210, 180, 140));
		rentclientlisttable.setBackground(new Color(0, 0, 0));
		scrollPaneclientlist.setViewportView(rentclientlisttable);
		
		JScrollPane scrollPanepropertylist = new JScrollPane();
		scrollPanepropertylist.setBounds(866, 53, 238, 514);
		panelrent.add(scrollPanepropertylist);
		
		rentpropertylisttable = new JTable();
		rentpropertylisttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfownername.setText(rentpropertylisttable.getValueAt(rentpropertylisttable.getSelectedRow(),1).toString());
				tfpropertyname.setText(rentpropertylisttable.getValueAt(rentpropertylisttable.getSelectedRow(), 3).toString());
				tfprice.setText(rentpropertylisttable.getValueAt(rentpropertylisttable.getSelectedRow(), 4).toString());
				tfaddress.setText(rentpropertylisttable.getValueAt(rentpropertylisttable.getSelectedRow(), 5).toString());
				
			}
		});
		rentpropertylisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		rentpropertylisttable.setForeground(new Color(210, 180, 140));
		rentpropertylisttable.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		rentpropertylisttable.setBackground(new Color(0, 0, 0));
		scrollPanepropertylist.setViewportView(rentpropertylisttable);
		
		JLabel lblrentlisttitle = new JLabel("RENT LIST");
		lblrentlisttitle.setForeground(Color.BLACK);
		lblrentlisttitle.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblrentlisttitle.setBounds(405, 10, 170, 38);
		panelrent.add(lblrentlisttitle);
		
		JLabel lblClientListtitle = new JLabel("CLIENT LIST");
		lblClientListtitle.setForeground(Color.BLACK);
		lblClientListtitle.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblClientListtitle.setBounds(686, 10, 170, 38);
		panelrent.add(lblClientListtitle);
		
		JLabel lblPropertyList = new JLabel("PROPERTY LIST");
		lblPropertyList.setForeground(Color.BLACK);
		lblPropertyList.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblPropertyList.setBounds(911, 10, 170, 38);
		panelrent.add(lblPropertyList);
		
		JButton btnrentlistreflesh = new JButton("REFLESH");
		btnrentlistreflesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rentDAO rentdao=new rentDAO();
					ArrayList<rent> temp= new ArrayList<rent>();
					temp=rentdao.getAllrent();
					RentTableModel renttablemodel=new RentTableModel(temp);
					rentlisttable.setModel(renttablemodel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				tfprice.setText(null);
				tfdeposite.setText(null);
				tffromdate.setText(null);
				tftodate.setText(null);
				tfownername.setText(null);
				tfcustomername.setText(null);
				tfpropertyname.setText(null);
				tfaddress.setText(null);
			}
		});
		btnrentlistreflesh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnrentlistreflesh.setFocusPainted(false);
		btnrentlistreflesh.setBorderPainted(false);
		btnrentlistreflesh.setBackground(new Color(210, 180, 140));
		btnrentlistreflesh.setBounds(313, 586, 335, 43);
		panelrent.add(btnrentlistreflesh);
		
		JButton btnclientlistreflesh = new JButton("REFLESH");
		btnclientlistreflesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					rentDAO rentdao=new rentDAO();
					ArrayList<rent> temp= new ArrayList<rent>();
					temp=rentdao.getallcustomerlist();
					RentInClientTableModel customertablemodel=new RentInClientTableModel(temp);
					rentclientlisttable.setModel(customertablemodel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				tfcustomername.setText(null);
			}
		});
		btnclientlistreflesh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnclientlistreflesh.setFocusPainted(false);
		btnclientlistreflesh.setBorderPainted(false);
		btnclientlistreflesh.setBackground(new Color(210, 180, 140));
		btnclientlistreflesh.setBounds(658, 586, 198, 43);
		panelrent.add(btnclientlistreflesh);
		
		JButton btnpropertylistreflesh = new JButton("REFLESH");
		btnpropertylistreflesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rentDAO rentdao=new rentDAO();
					ArrayList<rent> temp= new ArrayList<rent>();
					temp=rentdao.getallpropertylist();
					RentInPropertyTableModel propertytablemodel=new RentInPropertyTableModel(temp);
					rentpropertylisttable.setModel(propertytablemodel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tfprice.setText(null);
				tfownername.setText(null);
				tfaddress.setText(null);
				tfpropertyname.setText(null);
			
			}
		});
		btnpropertylistreflesh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnpropertylistreflesh.setFocusPainted(false);
		btnpropertylistreflesh.setBorderPainted(false);
		btnpropertylistreflesh.setBackground(new Color(210, 180, 140));
		btnpropertylistreflesh.setBounds(866, 586, 238, 43);
		panelrent.add(btnpropertylistreflesh);
		
		JButton btnrentaddclient = new JButton("ADD CLIENT");
		btnrentaddclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientUI().setVisible(true);
			}
		});
		btnrentaddclient.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnrentaddclient.setFocusPainted(false);
		btnrentaddclient.setBorderPainted(false);
		btnrentaddclient.setBackground(new Color(210, 180, 140));
		btnrentaddclient.setBounds(658, 647, 199, 43);
		panelrent.add(btnrentaddclient);
		
		JButton btnrentAddProperty = new JButton("ADD PROPERTY");
		btnrentAddProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PropertyUI().setVisible(true);
			}
		});
		btnrentAddProperty.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnrentAddProperty.setFocusPainted(false);
		btnrentAddProperty.setBorderPainted(false);
		btnrentAddProperty.setBackground(new Color(210, 180, 140));
		btnrentAddProperty.setBounds(866, 647, 238, 43);
		panelrent.add(btnrentAddProperty);
	}
}
