package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import property_type.typeUI;
import rent.RentUI;

import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;

import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Owner.OwnerUI;
import buy.buyUI;
import customer.ClientUI;
import property.PropertyUI;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class MainUI extends JFrame {
	private JPanel contentPane;
	private JPasswordField psw;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTable typetable;
	private JTextField tfArea;
	private JTextField tfpropertyid;
	private JTextField tfPrice;
	private JTextField tfAddress;
	private final ButtonGroup status = new ButtonGroup();
	private JTextField tfOwnerid;
	private JTable propertytable;
	private JTextField tfownername;
	private JTable ownertable;
	private JTextField tfNRC;
	private JTextField tfPhone;
	private JTextField tfEmail;
	private JTextField tfclientname;
	private JTextField tfClientNRC;
	private JTextField tfClientPhone;
	private JTextField tfClientEmail;
	private JTable table;
	private JTextField tfrentpropertyid;
	private JTextField tfrentcustomerid;
	private JTextField tfrentprice;
	private JTextField tfrentdeposite;
	private JTextField textField_2;
	private JTextField tfrenttodate;
	private JTable rentlisttable;
	private JTable rentclientlisttable;
	private JTable rentpropertylisttable;
	private JTable salelisttable;
	private JTable saleclientlisttable;
	private JTable salepropertylisttable;
	private JTextField tfsalepropertyid;
	private JTextField tfsalecustomerid;
	private JTextField tfsaleprice;
	private JTextField tfsaledate;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
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
	public MainUI() {
		
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
//______________________________________________________________________________________________________
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
		
//____________________________________________________________________
		//**************panel Home **************		
		JPanel panelHome = new JPanel();
		panelHome.setLayout(null);
		panelHome.setBackground(new Color(205, 133, 63));
		panelHome.setBounds(0, 0, 1114, 700);
		contentPane.add(panelHome);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(MainUI.class.getResource("/img/home_icon.png")));
		lblNewLabel_1_1.setBounds(0, 229, 1114, 484);
		panelHome.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MainUI.class.getResource("/img/home_icon1-removebg-preview.png")));
		lblNewLabel_3.setBounds(596, 0, 208, 97);
		panelHome.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("REAL ESTATE MANAGEMENT SYSTEM");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		lblNewLabel_1_1_1.setBounds(37, 51, 673, 50);
		panelHome.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("CLOSE");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(205, 133, 63));
		btnNewButton.setBounds(1016, 0, 98, 38);
		panelHome.add(btnNewButton);
//		
		

//____________________________________________________________________
				//**************panel property type**************
		JPanel paneltype = new JPanel();
		paneltype.setLayout(null);
		paneltype.setBackground(new Color(205, 133, 63));
		paneltype.setBounds(0, 0, 1114, 700);
		contentPane.add(paneltype);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.BLACK);
		desktopPane.setBounds(0, 0, 549, 700);
		paneltype.add(desktopPane);
		
		JLabel lblNewLabel_1 = new JLabel("PROPERTY TYPE");
		lblNewLabel_1.setForeground(new Color(205, 133, 63));
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(22, 25, 209, 28);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(205, 133, 63));
		lblId.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblId.setBounds(78, 108, 55, 28);
		desktopPane.add(lblId);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBackground(new Color(205, 133, 63));
		textField.setBounds(208, 108, 194, 38);
		desktopPane.add(textField);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(205, 133, 63));
		lblName.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblName.setBounds(78, 200, 55, 28);
		desktopPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(205, 133, 63));
		textField_1.setBounds(208, 193, 194, 38);
		desktopPane.add(textField_1);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setForeground(new Color(205, 133, 63));
		lblDescription.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblDescription.setBounds(78, 294, 108, 28);
		desktopPane.add(lblDescription);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		textArea.setBackground(new Color(205, 133, 63));
		textArea.setBounds(211, 294, 191, 188);
		desktopPane.add(textArea);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnAdd.setFocusPainted(false);
		btnAdd.setBorderPainted(false);
		btnAdd.setBackground(new Color(210, 180, 140));
		btnAdd.setBounds(27, 587, 106, 43);
		desktopPane.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnEdit.setFocusPainted(false);
		btnEdit.setBorderPainted(false);
		btnEdit.setBackground(new Color(210, 180, 140));
		btnEdit.setBounds(208, 587, 106, 43);
		desktopPane.add(btnEdit);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnRemove.setFocusPainted(false);
		btnRemove.setBorderPainted(false);
		btnRemove.setBackground(new Color(210, 180, 140));
		btnRemove.setBounds(390, 587, 106, 43);
		desktopPane.add(btnRemove);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(547, 0, 577, 518);
		paneltype.add(scrollPane);
		
		typetable = new JTable();
		typetable.setBackground(new Color(205, 133, 63));
		typetable.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		scrollPane.setViewportView(typetable);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnRefresh.setFocusPainted(false);
		btnRefresh.setBorderPainted(false);
		btnRefresh.setBackground(new Color(210, 180, 140));
		btnRefresh.setBounds(547, 587, 567, 43);
		paneltype.add(btnRefresh);
		
		JButton btnBack = new JButton("<<<");
		btnBack.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(205, 133, 63));
		btnBack.setBounds(605, 640, 106, 43);
		paneltype.add(btnBack);
		
		JButton btnClose = new JButton("XXX");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		btnClose.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnClose.setFocusPainted(false);
		btnClose.setBorderPainted(false);
		btnClose.setBackground(new Color(205, 133, 63));
		btnClose.setBounds(963, 640, 106, 43);
		paneltype.add(btnClose);
		
		
//____________________________________________________________________
		//**************panel property**************
		
		JPanel panelproperty = new JPanel();
		panelproperty.setBackground(new Color(205, 133, 63));
		panelproperty.setBounds(0, 0, 1114, 710);
		contentPane.add(panelproperty);
		panelproperty.setLayout(null);
		
		JDesktopPane desktopproperty = new JDesktopPane();
		desktopproperty.setBackground(new Color(0, 0, 0));
		desktopproperty.setBounds(0, 0, 428, 616);
		panelproperty.add(desktopproperty);
		
		JLabel lblproperty = new JLabel("PROPERTY ");
		lblproperty.setForeground(new Color(205, 133, 63));
		lblproperty.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblproperty.setBounds(10, 10, 209, 28);
		desktopproperty.add(lblproperty);
		
		JLabel lblPropertyid = new JLabel("ID");
		lblPropertyid.setForeground(new Color(205, 133, 63));
		lblPropertyid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPropertyid.setBounds(30, 52, 93, 28);
		desktopproperty.add(lblPropertyid);
		
		tfArea = new JTextField();
		tfArea.setForeground(Color.BLACK);
		tfArea.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfArea.setColumns(10);
		tfArea.setBackground(new Color(205, 133, 63));
		tfArea.setBounds(184, 204, 194, 38);
		desktopproperty.add(tfArea);
		
		JLabel lblArea = new JLabel("AREA");
		lblArea.setForeground(new Color(205, 133, 63));
		lblArea.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblArea.setBounds(30, 208, 93, 28);
		desktopproperty.add(lblArea);
		
		tfpropertyid = new JTextField();
		tfpropertyid.setForeground(Color.BLACK);
		tfpropertyid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfpropertyid.setColumns(10);
		tfpropertyid.setBackground(new Color(205, 133, 63));
		tfpropertyid.setBounds(184, 48, 194, 38);
		desktopproperty.add(tfpropertyid);
		
		JLabel lblPropertyDescription = new JLabel("DESCRIPTION");
		lblPropertyDescription.setForeground(new Color(205, 133, 63));
		lblPropertyDescription.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPropertyDescription.setBounds(30, 462, 108, 28);
		desktopproperty.add(lblPropertyDescription);
		
		JTextArea taDescription = new JTextArea();
		taDescription.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		taDescription.setBackground(new Color(205, 133, 63));
		taDescription.setBounds(187, 464, 191, 129);
		desktopproperty.add(taDescription);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(new Color(205, 133, 63));
		lblPrice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPrice.setBounds(30, 263, 93, 28);
		desktopproperty.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setForeground(Color.BLACK);
		tfPrice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfPrice.setColumns(10);
		tfPrice.setBackground(new Color(205, 133, 63));
		tfPrice.setBounds(184, 259, 194, 38);
		desktopproperty.add(tfPrice);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(205, 133, 63));
		lblAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblAddress.setBounds(30, 327, 108, 28);
		desktopproperty.add(lblAddress);
		
		tfAddress = new JTextField();
		tfAddress.setForeground(Color.BLACK);
		tfAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfAddress.setColumns(10);
		tfAddress.setBackground(new Color(205, 133, 63));
		tfAddress.setBounds(187, 323, 194, 38);
		desktopproperty.add(tfAddress);
		
		JRadioButton rdbtnSale = new JRadioButton("for sale");
		status.add(rdbtnSale);
		rdbtnSale.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		rdbtnSale.setForeground(new Color(205, 133, 63));
		rdbtnSale.setBackground(new Color(0, 0, 0));
		rdbtnSale.setBounds(187, 400, 103, 27);
		desktopproperty.add(rdbtnSale);
		
		JRadioButton rdbtnForRent = new JRadioButton("for rent");
		status.add(rdbtnForRent);
		rdbtnForRent.setForeground(new Color(205, 133, 63));
		rdbtnForRent.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		rdbtnForRent.setBackground(Color.BLACK);
		rdbtnForRent.setBounds(292, 400, 90, 27);
		desktopproperty.add(rdbtnForRent);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setForeground(new Color(205, 133, 63));
		lblStatus.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblStatus.setBounds(30, 399, 108, 28);
		desktopproperty.add(lblStatus);
		
		JLabel lblOwnerid = new JLabel("OWNERID");
		lblOwnerid.setForeground(new Color(205, 133, 63));
		lblOwnerid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblOwnerid.setBounds(30, 105, 108, 28);
		desktopproperty.add(lblOwnerid);
		
		tfOwnerid = new JTextField();
		tfOwnerid.setForeground(Color.BLACK);
		tfOwnerid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfOwnerid.setColumns(10);
		tfOwnerid.setBackground(new Color(205, 133, 63));
		tfOwnerid.setBounds(184, 101, 194, 38);
		desktopproperty.add(tfOwnerid);
		
		JLabel lblPropertyType = new JLabel("PROPERTY TYPE");
		lblPropertyType.setForeground(new Color(205, 133, 63));
		lblPropertyType.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPropertyType.setBounds(30, 152, 120, 28);
		desktopproperty.add(lblPropertyType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(205, 133, 63));
		comboBox.setBounds(184, 149, 194, 38);
		desktopproperty.add(comboBox);
		
		JButton btnPropertyRefresh = new JButton("REFRESH");
		btnPropertyRefresh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnPropertyRefresh.setFocusPainted(false);
		btnPropertyRefresh.setBorderPainted(false);
		btnPropertyRefresh.setBackground(new Color(210, 180, 140));
		btnPropertyRefresh.setBounds(429, 573, 685, 43);
		panelproperty.add(btnPropertyRefresh);
		
		JButton btnPropertyBack = new JButton("<<<");
		btnPropertyBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new OwnerUI().setVisible(true);
			}
		});
		btnPropertyBack.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnPropertyBack.setFocusPainted(false);
		btnPropertyBack.setBorderPainted(false);
		btnPropertyBack.setBackground(new Color(205, 133, 63));
		btnPropertyBack.setBounds(535, 626, 106, 43);
		panelproperty.add(btnPropertyBack);
		
		JButton btnPropertyAdd = new JButton("ADD");
		btnPropertyBack.setBounds(20, 632, 106, 43);
		panelproperty.add(btnPropertyBack);
		btnPropertyBack.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnPropertyBack.setFocusPainted(false);
		btnPropertyBack.setBorderPainted(false);
		btnPropertyBack.setBackground(new Color(210, 180, 140));
		
		JButton btnPropertyEdit = new JButton("Edit");
		btnPropertyEdit.setBounds(157, 632, 106, 43);
		panelproperty.add(btnPropertyEdit);
		btnPropertyEdit.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnPropertyEdit.setFocusPainted(false);
		btnPropertyEdit.setBorderPainted(false);
		btnPropertyEdit.setBackground(new Color(210, 180, 140));
		
		JButton btnPropertyRemove = new JButton("REMOVE");
		btnPropertyRemove.setBounds(315, 632, 106, 43);
		panelproperty.add(btnPropertyRemove);
		btnPropertyRemove.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnPropertyRemove.setFocusPainted(false);
		btnPropertyRemove.setBorderPainted(false);
		btnPropertyRemove.setBackground(new Color(210, 180, 140));
		
		JButton btnXxx = new JButton("XXX");
		btnXxx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		btnXxx.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnXxx.setFocusPainted(false);
		btnXxx.setBorderPainted(false);
		btnXxx.setBackground(new Color(205, 133, 63));
		btnXxx.setBounds(888, 626, 106, 43);
		panelproperty.add(btnXxx);
		
		JScrollPane scrollPaneProperty = new JScrollPane();
		scrollPaneProperty.setBounds(429, 0, 685, 572);
		panelproperty.add(scrollPaneProperty);
		
		propertytable = new JTable();
		propertytable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		propertytable.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		propertytable.setForeground(new Color(210, 180, 140));
		propertytable.setBackground(new Color(0, 0, 0));
		scrollPaneProperty.setViewportView(propertytable);

//____________________________________________________________________
		//**************panel owner**************
		
		JPanel panelowner = new JPanel();
		panelowner.setBackground(new Color(205, 133, 63));
		panelowner.setBounds(0, 0, 1114, 700);
		contentPane.add(panelowner);
		panelowner.setLayout(null);
		
		JDesktopPane desktopowner = new JDesktopPane();
		desktopowner.setBackground(Color.BLACK);
		desktopowner.setBounds(10, 0, 421, 616);
		panelowner.add(desktopowner);
		
		JLabel lblowner = new JLabel("OWNER INFORMATION");
		lblowner.setForeground(new Color(205, 133, 63));
		lblowner.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblowner.setBounds(34, 22, 239, 28);
		desktopowner.add(lblowner);
		
		JLabel lblOwnername = new JLabel("NAME");
		lblOwnername.setForeground(new Color(205, 133, 63));
		lblOwnername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblOwnername.setBounds(30, 97, 93, 28);
		desktopowner.add(lblOwnername);
		
		tfownername = new JTextField();
		tfownername.setForeground(Color.BLACK);
		tfownername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfownername.setColumns(10);
		tfownername.setBackground(new Color(205, 133, 63));
		tfownername.setBounds(155, 93, 223, 38);
		desktopowner.add(tfownername);
		
		JLabel lblOwnerAddress = new JLabel("ADDRESS");
		lblOwnerAddress.setForeground(new Color(205, 133, 63));
		lblOwnerAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblOwnerAddress.setBounds(30, 419, 108, 28);
		desktopowner.add(lblOwnerAddress);
		
		JTextArea taownerAddress = new JTextArea();
		taownerAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		taownerAddress.setBackground(new Color(205, 133, 63));
		taownerAddress.setBounds(155, 409, 223, 129);
		desktopowner.add(taownerAddress);
		
		JLabel lblNRC = new JLabel("NRC");
		lblNRC.setForeground(new Color(205, 133, 63));
		lblNRC.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNRC.setBounds(30, 171, 93, 28);
		desktopowner.add(lblNRC);
		
		tfNRC = new JTextField();
		tfNRC.setForeground(Color.BLACK);
		tfNRC.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfNRC.setColumns(10);
		tfNRC.setBackground(new Color(205, 133, 63));
		tfNRC.setBounds(155, 167, 223, 38);
		desktopowner.add(tfNRC);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setForeground(new Color(205, 133, 63));
		lblPhone.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPhone.setBounds(30, 241, 93, 28);
		desktopowner.add(lblPhone);
		
		tfPhone = new JTextField();
		tfPhone.setForeground(Color.BLACK);
		tfPhone.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfPhone.setColumns(10);
		tfPhone.setBackground(new Color(205, 133, 63));
		tfPhone.setBounds(155, 237, 223, 38);
		desktopowner.add(tfPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(205, 133, 63));
		lblEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblEmail.setBounds(30, 323, 93, 28);
		desktopowner.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setForeground(Color.BLACK);
		tfEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfEmail.setColumns(10);
		tfEmail.setBackground(new Color(205, 133, 63));
		tfEmail.setBounds(155, 319, 223, 38);
		desktopowner.add(tfEmail);
		
		JButton btnOwnerRefresh = new JButton("REFRESH");
		btnOwnerRefresh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnOwnerRefresh.setFocusPainted(false);
		btnOwnerRefresh.setBorderPainted(false);
		btnOwnerRefresh.setBackground(new Color(210, 180, 140));
		btnOwnerRefresh.setBounds(429, 573, 685, 43);
		panelowner.add(btnOwnerRefresh);
		
		JButton btnADD = new JButton("ADD");
		btnADD.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnADD.setFocusPainted(false);
		btnADD.setBackground(new Color(210, 180, 140));
		btnADD.setBounds(49, 635, 106, 43);
		panelowner.add(btnADD);
		
		JButton btnOwnerEdit = new JButton("Edit");
		btnOwnerEdit.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnOwnerEdit.setFocusPainted(false);
		btnOwnerEdit.setBorderPainted(false);
		btnOwnerEdit.setBackground(new Color(210, 180, 140));
		btnOwnerEdit.setBounds(218, 635, 106, 43);
		panelowner.add(btnOwnerEdit);
		
		JButton btnOwnerRemove = new JButton("REMOVE");
		btnOwnerRemove.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnOwnerRemove.setFocusPainted(false);
		btnOwnerRemove.setBorderPainted(false);
		btnOwnerRemove.setBackground(new Color(210, 180, 140));
		btnOwnerRemove.setBounds(404, 635, 106, 43);
		panelowner.add(btnOwnerRemove);
		
		JButton btnback = new JButton("<<<");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new typeUI().setVisible(true);
			}
		});
		btnback.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnback.setFocusPainted(false);
		btnback.setBorderPainted(false);
		btnback.setBackground(new Color(205, 133, 63));
		btnback.setBounds(605, 635, 106, 43);
		panelowner.add(btnback);
		
		JButton btnOwnerClose = new JButton("XXX");
		btnOwnerClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home().setVisible(true);
				
			}
		});
		btnOwnerClose.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnOwnerClose.setFocusPainted(false);
		btnOwnerClose.setBorderPainted(false);
		btnOwnerClose.setBackground(new Color(205, 133, 63));
		btnOwnerClose.setBounds(860, 635, 106, 43);
		panelowner.add(btnOwnerClose);
		
		JScrollPane scrollPaneOwner = new JScrollPane();
		scrollPaneOwner.setBounds(429, 0, 685, 572);
		panelowner.add(scrollPaneOwner);
		
		ownertable = new JTable();
		ownertable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		ownertable.setBackground(new Color(0, 0, 0));
		ownertable.setForeground(new Color(210, 180, 140));
		scrollPaneOwner.setViewportView(ownertable);
//____________________________________________________________________
			//**************panel client**************		
		JPanel panelclient = new JPanel();
		panelclient.setBackground(new Color(205, 133, 63));
		panelclient.setBounds(0, 0, 1114, 710);
		contentPane.add(panelclient);
		panelclient.setLayout(null);
		
		JDesktopPane desktopclient = new JDesktopPane();
		desktopclient.setBackground(Color.BLACK);
		desktopclient.setBounds(0, 0, 495, 591);
		panelclient.add(desktopclient);
		
		JLabel lblclient = new JLabel("CLIENT INFORMATION");
		lblclient.setForeground(new Color(205, 133, 63));
		lblclient.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblclient.setBounds(60, 22, 239, 28);
		desktopclient.add(lblclient);
		
		JLabel lblclientname = new JLabel("NAME");
		lblclientname.setForeground(new Color(205, 133, 63));
		lblclientname.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblclientname.setBounds(30, 97, 93, 28);
		desktopclient.add(lblclientname);
		
		tfclientname = new JTextField();
		tfclientname.setForeground(Color.BLACK);
		tfclientname.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfclientname.setColumns(10);
		tfclientname.setBackground(new Color(205, 133, 63));
		tfclientname.setBounds(155, 93, 223, 38);
		desktopclient.add(tfclientname);
		
		JLabel lblClientAddress = new JLabel("ADDRESS");
		lblClientAddress.setForeground(new Color(205, 133, 63));
		lblClientAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblClientAddress.setBounds(30, 419, 108, 28);
		desktopclient.add(lblClientAddress);
		
		JTextArea taClientDescription = new JTextArea();
		taClientDescription.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		taClientDescription.setBackground(new Color(205, 133, 63));
		taClientDescription.setBounds(155, 409, 223, 129);
		desktopclient.add(taClientDescription);
		
		JLabel lblClientNRC = new JLabel("NRC");
		lblClientNRC.setForeground(new Color(205, 133, 63));
		lblClientNRC.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblClientNRC.setBounds(30, 171, 93, 28);
		desktopclient.add(lblClientNRC);
		
		tfClientNRC = new JTextField();
		tfClientNRC.setForeground(Color.BLACK);
		tfClientNRC.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfClientNRC.setColumns(10);
		tfClientNRC.setBackground(new Color(205, 133, 63));
		tfClientNRC.setBounds(155, 167, 223, 38);
		desktopclient.add(tfClientNRC);
		
		JLabel lblclientPhone = new JLabel("PHONE");
		lblclientPhone.setForeground(new Color(205, 133, 63));
		lblclientPhone.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblclientPhone.setBounds(30, 241, 93, 28);
		desktopclient.add(lblclientPhone);
		
		tfClientPhone = new JTextField();
		tfClientPhone.setForeground(Color.BLACK);
		tfClientPhone.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfClientPhone.setColumns(10);
		tfClientPhone.setBackground(new Color(205, 133, 63));
		tfClientPhone.setBounds(155, 237, 223, 38);
		desktopclient.add(tfClientPhone);
		
		JLabel lblClientEmail = new JLabel("EMAIL");
		lblClientEmail.setForeground(new Color(205, 133, 63));
		lblClientEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblClientEmail.setBounds(30, 323, 93, 28);
		desktopclient.add(lblClientEmail);
		
		tfClientEmail = new JTextField();
		tfClientEmail.setForeground(Color.BLACK);
		tfClientEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfClientEmail.setColumns(10);
		tfClientEmail.setBackground(new Color(205, 133, 63));
		tfClientEmail.setBounds(155, 319, 223, 38);
		desktopclient.add(tfClientEmail);
		
		JButton btnClientRefresh = new JButton("REFRESH");
		btnClientRefresh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnClientRefresh.setFocusPainted(false);
		btnClientRefresh.setBorderPainted(false);
		btnClientRefresh.setBackground(new Color(210, 180, 140));
		btnClientRefresh.setBounds(494, 541, 620, 50);
		desktopclient.add(btnClientRefresh);
		
		JButton btnClientADD = new JButton("ADD");
		btnClientADD.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnClientADD.setFocusPainted(false);
		btnClientADD.setBackground(new Color(210, 180, 140));
		btnClientADD.setBounds(29, 630, 106, 43);
		panelclient.add(btnClientADD);
		
		JButton btnClientEdit = new JButton("Edit");
		btnClientEdit.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnClientEdit.setFocusPainted(false);
		btnClientEdit.setBorderPainted(false);
		btnClientEdit.setBackground(new Color(210, 180, 140));
		btnClientEdit.setBounds(207, 630, 106, 43);
		panelclient.add(btnClientEdit);
		
		JButton btnClientremove = new JButton("REMOVE");
		btnClientremove.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnClientremove.setFocusPainted(false);
		btnClientremove.setBorderPainted(false);
		btnClientremove.setBackground(new Color(210, 180, 140));
		btnClientremove.setBounds(389, 630, 106, 43);
		panelclient.add(btnClientremove);
		
		JButton btnClientback = new JButton("<<<");
		btnClientback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new OwnerUI().setVisible(true);
			}
		});
		btnClientback.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnClientback.setFocusPainted(false);
		btnClientback.setBorderPainted(false);
		btnClientback.setBackground(new Color(205, 133, 63));
		btnClientback.setBounds(575, 630, 106, 43);
		panelclient.add(btnClientback);
		
		JButton btnClientClose= new JButton("XXX");
		btnClientClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home().setVisible(true);
			}
		});
		btnClientClose.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnClientClose.setFocusPainted(false);
		btnClientClose.setBorderPainted(false);
		btnClientClose.setBackground(new Color(205, 133, 63));
		btnClientClose.setBounds(892, 630, 106, 43);
		panelclient.add(btnClientClose);
		
		JScrollPane scrollPaneClient= new JScrollPane();
		scrollPaneClient.setBounds(494, 0, 620, 551);
		panelclient.add(scrollPaneClient);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBackground(new Color(0, 0, 0));
		table.setForeground(new Color(210, 180, 140));
		scrollPaneOwner.setViewportView(table);
//____________________________________________________________________
			//**************panel rent**************		
		JPanel panelrent = new JPanel();
		panelrent.setBackground(new Color(205, 133, 63));
		panelrent.setBounds(0, 0, 1114, 700);
		contentPane.add(panelrent);
		panelrent.setLayout(null);
		
		JDesktopPane desktoprent = new JDesktopPane();
		desktoprent.setBackground(new Color(0, 0, 0));
		desktoprent.setBounds(0, 0, 315, 700);
		panelrent.add(desktoprent);
		
		JLabel lblrentpropertyid = new JLabel("PROPERTYID");
		lblrentpropertyid.setForeground(new Color(205, 133, 63));
		lblrentpropertyid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentpropertyid.setBounds(10, 55, 111, 28);
		desktoprent.add(lblrentpropertyid);
		
		tfrentpropertyid = new JTextField();
		tfrentpropertyid.setForeground(Color.BLACK);
		tfrentpropertyid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfrentpropertyid.setColumns(10);
		tfrentpropertyid.setBackground(new Color(205, 133, 63));
		tfrentpropertyid.setBounds(142, 48, 146, 38);
		desktoprent.add(tfrentpropertyid);
		
		JLabel lblrentinformation = new JLabel("RENT INFORMATION");
		lblrentinformation.setBounds(35, 10, 258, 28);
		desktoprent.add(lblrentinformation);
		lblrentinformation.setForeground(new Color(205, 133, 63));
		lblrentinformation.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		
		JLabel lblrentcustomerid = new JLabel("CUSTOMERID");
		lblrentcustomerid.setForeground(new Color(205, 133, 63));
		lblrentcustomerid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentcustomerid.setBounds(10, 109, 111, 28);
		desktoprent.add(lblrentcustomerid);
		
		tfrentcustomerid = new JTextField();
		tfrentcustomerid.setForeground(Color.BLACK);
		tfrentcustomerid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfrentcustomerid.setColumns(10);
		tfrentcustomerid.setBackground(new Color(205, 133, 63));
		tfrentcustomerid.setBounds(142, 105, 146, 38);
		desktoprent.add(tfrentcustomerid);
		
		JButton btnAdd_1 = new JButton("ADD");
		btnAdd_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnAdd_1.setFocusPainted(false);
		btnAdd_1.setBorderPainted(false);
		btnAdd_1.setBackground(new Color(210, 180, 140));
		btnAdd_1.setBounds(21, 424, 273, 43);
		desktoprent.add(btnAdd_1);
		
		JButton btnEdit_1 = new JButton("Edit");
		btnEdit_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnEdit_1.setFocusPainted(false);
		btnEdit_1.setBorderPainted(false);
		btnEdit_1.setBackground(new Color(210, 180, 140));
		btnEdit_1.setBounds(21, 582, 273, 43);
		desktoprent.add(btnEdit_1);
		
		JButton btnRemove_1 = new JButton("REMOVE");
		btnRemove_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnRemove_1.setFocusPainted(false);
		btnRemove_1.setBorderPainted(false);
		btnRemove_1.setBackground(new Color(210, 180, 140));
		btnRemove_1.setBounds(21, 504, 273, 43);
		desktoprent.add(btnRemove_1);
		
		JLabel lblrentPrice = new JLabel("PRICE");
		lblrentPrice.setForeground(new Color(205, 133, 63));
		lblrentPrice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentPrice.setBounds(21, 167, 111, 28);
		desktoprent.add(lblrentPrice);
		
		tfrentprice = new JTextField();
		tfrentprice.setForeground(Color.BLACK);
		tfrentprice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfrentprice.setColumns(10);
		tfrentprice.setBackground(new Color(205, 133, 63));
		tfrentprice.setBounds(142, 163, 146, 38);
		desktoprent.add(tfrentprice);
		
		JLabel lblrentdeposite = new JLabel("DEPOSITE");
		lblrentdeposite.setForeground(new Color(205, 133, 63));
		lblrentdeposite.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentdeposite.setBounds(21, 227, 111, 28);
		desktoprent.add(lblrentdeposite);
		
		tfrentdeposite = new JTextField();
		tfrentdeposite.setForeground(Color.BLACK);
		tfrentdeposite.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfrentdeposite.setColumns(10);
		tfrentdeposite.setBackground(new Color(205, 133, 63));
		tfrentdeposite.setBounds(142, 223, 146, 38);
		desktoprent.add(tfrentdeposite);
		
		JLabel lblrentfromdate = new JLabel("FROM DATE");
		lblrentfromdate.setForeground(new Color(205, 133, 63));
		lblrentfromdate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentfromdate.setBounds(21, 292, 111, 28);
		desktoprent.add(lblrentfromdate);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(205, 133, 63));
		textField_2.setBounds(142, 288, 146, 38);
		desktoprent.add(textField_2);
		
		JLabel lblrenttodate = new JLabel("TO DATE");
		lblrenttodate.setForeground(new Color(205, 133, 63));
		lblrenttodate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrenttodate.setBounds(21, 348, 111, 28);
		desktoprent.add(lblrenttodate);
		
		tfrenttodate = new JTextField();
		tfrenttodate.setForeground(Color.BLACK);
		tfrenttodate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfrenttodate.setColumns(10);
		tfrenttodate.setBackground(new Color(205, 133, 63));
		tfrenttodate.setBounds(142, 344, 146, 38);
		desktoprent.add(tfrenttodate);
		
		JScrollPane scrollPanerent = new JScrollPane();
		scrollPanerent.setBounds(313, 52, 335, 515);
		panelrent.add(scrollPanerent);
		
		rentlisttable = new JTable();
		rentlisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		rentlisttable.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		rentlisttable.setForeground(new Color(210, 180, 140));
		rentlisttable.setBackground(new Color(0, 0, 0));
		scrollPanerent.setViewportView(rentlisttable);
		
		JScrollPane scrollPaneclientlist = new JScrollPane();
		scrollPaneclientlist.setBounds(658, 52, 198, 515);
		panelrent.add(scrollPaneclientlist);
		
		rentclientlisttable = new JTable();
		rentclientlisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		rentclientlisttable.setForeground(new Color(210, 180, 140));
		rentclientlisttable.setFont(new Font("Source Code Pro Black", Font.PLAIN, 15));
		rentclientlisttable.setBackground(new Color(0, 0, 0));
		scrollPaneclientlist.setViewportView(rentclientlisttable);
		
		JScrollPane scrollPanepropertylist = new JScrollPane();
		scrollPanepropertylist.setBounds(866, 53, 249, 514);
		panelrent.add(scrollPanepropertylist);
		
		rentpropertylisttable = new JTable();
		rentpropertylisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		rentpropertylisttable.setForeground(new Color(210, 180, 140));
		rentpropertylisttable.setFont(new Font("Source Code Pro Black", Font.PLAIN, 15));
		rentpropertylisttable.setBackground(new Color(0, 0, 0));
		scrollPanepropertylist.setViewportView(rentpropertylisttable);
		
		JLabel lblrentlisttitle = new JLabel("RENT LIST");
		lblrentlisttitle.setForeground(new Color(0, 0, 0));
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
		btnrentlistreflesh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnrentlistreflesh.setFocusPainted(false);
		btnrentlistreflesh.setBorderPainted(false);
		btnrentlistreflesh.setBackground(new Color(210, 180, 140));
		btnrentlistreflesh.setBounds(313, 586, 335, 43);
		panelrent.add(btnrentlistreflesh);
		
		JButton btnclientlistreflesh = new JButton("REFLESH");
		btnclientlistreflesh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnclientlistreflesh.setFocusPainted(false);
		btnclientlistreflesh.setBorderPainted(false);
		btnclientlistreflesh.setBackground(new Color(210, 180, 140));
		btnclientlistreflesh.setBounds(658, 586, 198, 43);
		panelrent.add(btnclientlistreflesh);
		
		JButton btnpropertylistreflesh = new JButton("REFLESH");
		btnpropertylistreflesh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnpropertylistreflesh.setFocusPainted(false);
		btnpropertylistreflesh.setBorderPainted(false);
		btnpropertylistreflesh.setBackground(new Color(210, 180, 140));
		btnpropertylistreflesh.setBounds(866, 586, 249, 43);
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
		btnrentAddProperty.setBounds(866, 647, 249, 43);
		panelrent.add(btnrentAddProperty);
//____________________________________________________________________
				//**************panel sale**************		
		JPanel panelsale = new JPanel();
		panelsale.setBackground(new Color(205, 133, 63));
		panelsale.setBounds(0, 0, 1466, 712);
		contentPane.add(panelsale);
		panelsale.setLayout(null);
		
		JScrollPane scrollPanesaleclientlist = new JScrollPane();
		scrollPanesaleclientlist.setBounds(670, 67, 202, 515);
		panelsale.add(scrollPanesaleclientlist);
		
		saleclientlisttable = new JTable();
		saleclientlisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		saleclientlisttable.setForeground(new Color(210, 180, 140));
		saleclientlisttable.setFont(new Font("Source Code Pro Black", Font.PLAIN, 15));
		saleclientlisttable.setBackground(Color.BLACK);
		scrollPanesaleclientlist.setViewportView(saleclientlisttable);
		
		JScrollPane scrollPanesalepropertylist = new JScrollPane();
		scrollPanesalepropertylist.setBounds(882, 67, 227, 514);
		panelsale.add(scrollPanesalepropertylist);
		
		salepropertylisttable = new JTable();
		salepropertylisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		salepropertylisttable.setForeground(new Color(210, 180, 140));
		salepropertylisttable.setFont(new Font("Source Code Pro Black", Font.PLAIN, 15));
		salepropertylisttable.setBackground(Color.BLACK);
		scrollPanesalepropertylist.setViewportView(salepropertylisttable);
		
		JDesktopPane desktopsale = new JDesktopPane();
		desktopsale.setBackground(Color.BLACK);
		desktopsale.setBounds(0, 0, 320, 702);
		panelsale.add(desktopsale);
		
		JLabel lblsalepropertyid = new JLabel("PROPERTYID");
		lblsalepropertyid.setForeground(new Color(205, 133, 63));
		lblsalepropertyid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsalepropertyid.setBounds(10, 55, 111, 28);
		desktopsale.add(lblsalepropertyid);
		
		tfsalepropertyid = new JTextField();
		tfsalepropertyid.setForeground(Color.BLACK);
		tfsalepropertyid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsalepropertyid.setColumns(10);
		tfsalepropertyid.setBackground(new Color(205, 133, 63));
		tfsalepropertyid.setBounds(142, 48, 146, 38);
		desktopsale.add(tfsalepropertyid);
		
		JLabel lblsalecustomerid = new JLabel("CUSTOMERID");
		lblsalecustomerid.setForeground(new Color(205, 133, 63));
		lblsalecustomerid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsalecustomerid.setBounds(10, 135, 111, 28);
		desktopsale.add(lblsalecustomerid);
		
		tfsalecustomerid = new JTextField();
		tfsalecustomerid.setForeground(Color.BLACK);
		tfsalecustomerid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsalecustomerid.setColumns(10);
		tfsalecustomerid.setBackground(new Color(205, 133, 63));
		tfsalecustomerid.setBounds(142, 131, 146, 38);
		desktopsale.add(tfsalecustomerid);
		
		JButton btnsaleadd = new JButton("ADD");
		btnsaleadd.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsaleadd.setFocusPainted(false);
		btnsaleadd.setBorderPainted(false);
		btnsaleadd.setBackground(new Color(210, 180, 140));
		btnsaleadd.setBounds(21, 424, 273, 43);
		desktopsale.add(btnsaleadd);
		
		JButton btnsaleedit = new JButton("Edit");
		btnsaleedit.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsaleedit.setFocusPainted(false);
		btnsaleedit.setBorderPainted(false);
		btnsaleedit.setBackground(new Color(210, 180, 140));
		btnsaleedit.setBounds(21, 582, 273, 43);
		desktopsale.add(btnsaleedit);
		
		JButton btnsaleremove = new JButton("REMOVE");
		btnsaleremove.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsaleremove.setFocusPainted(false);
		btnsaleremove.setBorderPainted(false);
		btnsaleremove.setBackground(new Color(210, 180, 140));
		btnsaleremove.setBounds(21, 504, 273, 43);
		desktopsale.add(btnsaleremove);
		
		JLabel lblsalePrice = new JLabel("PRICE");
		lblsalePrice.setForeground(new Color(205, 133, 63));
		lblsalePrice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsalePrice.setBounds(10, 219, 111, 28);
		desktopsale.add(lblsalePrice);
		
		tfsaleprice = new JTextField();
		tfsaleprice.setForeground(Color.BLACK);
		tfsaleprice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsaleprice.setColumns(10);
		tfsaleprice.setBackground(new Color(205, 133, 63));
		tfsaleprice.setBounds(142, 215, 146, 38);
		desktopsale.add(tfsaleprice);
		
		JLabel lblsaledate = new JLabel("DATE");
		lblsaledate.setForeground(new Color(205, 133, 63));
		lblsaledate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsaledate.setBounds(10, 312, 111, 28);
		desktopsale.add(lblsaledate);
		
		tfsaledate = new JTextField();
		tfsaledate.setForeground(Color.BLACK);
		tfsaledate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsaledate.setColumns(10);
		tfsaledate.setBackground(new Color(205, 133, 63));
		tfsaledate.setBounds(142, 308, 146, 38);
		desktopsale.add(tfsaledate);
		
		JLabel saleinformationtitle = new JLabel("SALE INFORMATION");
		saleinformationtitle.setBounds(62, 10, 258, 28);
		desktopsale.add(saleinformationtitle);
		saleinformationtitle.setForeground(new Color(205, 133, 63));
		saleinformationtitle.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		
		JScrollPane scrollPanelsale = new JScrollPane();
		scrollPanelsale.setBounds(326, 67, 334, 515);
		panelsale.add(scrollPanelsale);
		
		salelisttable = new JTable();
		salelisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		salelisttable.setForeground(new Color(210, 180, 140));
		salelisttable.setFont(new Font("Source Code Pro Black", Font.PLAIN, 15));
		salelisttable.setBackground(new Color(0, 0, 0));
		scrollPanelsale.setViewportView(salelisttable);
		
		JLabel lblSaleList = new JLabel("SALE LIST");
		lblSaleList.setForeground(Color.BLACK);
		lblSaleList.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblSaleList.setBounds(419, 19, 170, 38);
		panelsale.add(lblSaleList);
		
		JLabel lblsaleClientListtitle = new JLabel("CLIENT LIST");
		lblsaleClientListtitle.setForeground(Color.BLACK);
		lblsaleClientListtitle.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblsaleClientListtitle.setBounds(702, 19, 170, 38);
		panelsale.add(lblsaleClientListtitle);
		
		JLabel lblsalePropertyList = new JLabel("PROPERTY LIST");
		lblsalePropertyList.setForeground(Color.BLACK);
		lblsalePropertyList.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblsalePropertyList.setBounds(907, 19, 170, 38);
		panelsale.add(lblsalePropertyList);
		
		JButton btnsalelistreflesh = new JButton("REFLESH");
		btnsalelistreflesh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsalelistreflesh.setFocusPainted(false);
		btnsalelistreflesh.setBorderPainted(false);
		btnsalelistreflesh.setBackground(new Color(210, 180, 140));
		btnsalelistreflesh.setBounds(325, 592, 335, 43);
		panelsale.add(btnsalelistreflesh);
		
		JButton btnsaleclientlistreflesh = new JButton("REFLESH");
		btnsaleclientlistreflesh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsaleclientlistreflesh.setFocusPainted(false);
		btnsaleclientlistreflesh.setBorderPainted(false);
		btnsaleclientlistreflesh.setBackground(new Color(210, 180, 140));
		btnsaleclientlistreflesh.setBounds(674, 592, 198, 43);
		panelsale.add(btnsaleclientlistreflesh);
		
		JButton btnsalepropertylistreflesh = new JButton("REFLESH");
		btnsalepropertylistreflesh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsalepropertylistreflesh.setFocusPainted(false);
		btnsalepropertylistreflesh.setBorderPainted(false);
		btnsalepropertylistreflesh.setBackground(new Color(210, 180, 140));
		btnsalepropertylistreflesh.setBounds(882, 591, 224, 43);
		panelsale.add(btnsalepropertylistreflesh);
		
		JButton btnsaleaddclient = new JButton("ADD CLIENT");
		btnsaleaddclient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientUI().setVisible(true);
			}
		});
		btnsaleaddclient.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsaleaddclient.setFocusPainted(false);
		btnsaleaddclient.setBorderPainted(false);
		btnsaleaddclient.setBackground(new Color(210, 180, 140));
		btnsaleaddclient.setBounds(673, 646, 199, 43);
		panelsale.add(btnsaleaddclient);
		
		JButton btnsaleAddProperty = new JButton("ADD PROPERTY");
		btnsaleAddProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PropertyUI().setVisible(true);
			}
		});
		btnsaleAddProperty.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsaleAddProperty.setFocusPainted(false);
		btnsaleAddProperty.setBorderPainted(false);
		btnsaleAddProperty.setBackground(new Color(210, 180, 140));
		btnsaleAddProperty.setBounds(882, 644, 224, 43);
		panelsale.add(btnsaleAddProperty);
		
		
		
		
	}
}
