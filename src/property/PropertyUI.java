package property;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Owner.OwnerDAO;
import Owner.OwnerTableModel;
import Owner.OwnerUI;
import Owner.owner;
import Owner.updateanddeleteUI;
import buy.buyUI;
import customer.ClientUI;
import customer.CustomerTableModel;
import customer.customer;
import customer.customerDAO;
import property_type.TypeTableModel;
import property_type.property_type;
import property_type.typeDAO;
import property_type.typeUI;
import property_type.updateanddelete;
import rent.RentUI;

import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;

public class PropertyUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable propertytable;
	JTextField tfpropertyid,tfownerid,tfarea,tfprice,tfaddress;
	JRadioButton rdbtnSale;
	JRadioButton rdbtnForRent;
	JTextArea tadescription;
	JComboBox typecombo;
	
	
	private final ButtonGroup status = new ButtonGroup();
	private JTable clienttable;
	private typeDAO propertytypedao=new typeDAO();
	private OwnerDAO ownerdao=new OwnerDAO();
	
	private String[] type_id;
	private ArrayList<property_type> type = new ArrayList<property_type>();
	private String[] owner_name;
	private ArrayList<owner> ownername= new ArrayList<owner>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropertyUI frame = new PropertyUI();
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
	public PropertyUI() {
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
				new typeUI().setVisible(false);
				
				
			
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
				tfpropertyid.setText(propertytable.getValueAt(propertytable.getSelectedRow(), 0).toString());
				tfownerid.setText(propertytable.getValueAt(propertytable.getSelectedRow(), 1).toString());				
//				String value=typecombo.getSelectedItem().toString();
//				typecombo.setSelectedItem(propertytable.getValueAt(propertytable.getSelectedRow(), 3).toString());
				
				tfarea.setText(propertytable.getValueAt(propertytable.getSelectedRow(), 3).toString());
				tfprice.setText(propertytable.getValueAt(propertytable.getSelectedRow(), 4).toString());
				tfaddress.setText(propertytable.getValueAt(propertytable.getSelectedRow(), 5).toString());
				String status=propertytable.getValueAt(propertytable.getSelectedRow(), 7).toString();
				if(status=="for sale")
					rdbtnSale.setSelected(true);
				else rdbtnForRent.setSelected(true);
				tadescription.setText(propertytable.getValueAt(propertytable.getSelectedRow(), 8).toString());
				
				
				
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
		
		JTextField tfarea = new JTextField();
		tfarea.setForeground(Color.BLACK);
		tfarea.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfarea.setColumns(10);
		tfarea.setBackground(new Color(205, 133, 63));
		tfarea.setBounds(187, 179, 220, 38);
		desktopproperty.add(tfarea);
		
		JLabel lblArea = new JLabel("AREA");
		lblArea.setForeground(new Color(205, 133, 63));
		lblArea.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblArea.setBounds(30, 183, 93, 28);
		desktopproperty.add(lblArea);
		
		JLabel lblPropertyDescription = new JLabel("DESCRIPTION");
		lblPropertyDescription.setForeground(new Color(205, 133, 63));
		lblPropertyDescription.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPropertyDescription.setBounds(15, 474, 108, 28);
		desktopproperty.add(lblPropertyDescription);
		
		JTextArea tadescription = new JTextArea();
		tadescription.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tadescription.setBackground(new Color(205, 133, 63));
		tadescription.setBounds(171, 464, 247, 129);
		desktopproperty.add(tadescription);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(new Color(205, 133, 63));
		lblPrice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPrice.setBounds(30, 258, 93, 28);
		desktopproperty.add(lblPrice);
		
		JTextField tfprice = new JTextField();
		tfprice.setForeground(Color.BLACK);
		tfprice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfprice.setColumns(10);
		tfprice.setBackground(new Color(205, 133, 63));
		tfprice.setBounds(187, 254, 220, 38);
		desktopproperty.add(tfprice);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(205, 133, 63));
		lblAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblAddress.setBounds(30, 323, 108, 28);
		desktopproperty.add(lblAddress);
		
		JTextField tfaddress = new JTextField();
		tfaddress.setForeground(Color.BLACK);
		tfaddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfaddress.setColumns(10);
		tfaddress.setBackground(new Color(205, 133, 63));
		tfaddress.setBounds(187, 319, 220, 38);
		desktopproperty.add(tfaddress);
		
		JRadioButton rdbtnSale = new JRadioButton("For Sale");
		status.add(rdbtnSale);
		rdbtnSale.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		rdbtnSale.setForeground(new Color(205, 133, 63));
		rdbtnSale.setBackground(new Color(0, 0, 0));
		rdbtnSale.setBounds(187, 393, 103, 27);
		desktopproperty.add(rdbtnSale);
		
		JRadioButton rdbtnForRent = new JRadioButton("For Rent");
		status.add(rdbtnForRent);
		rdbtnForRent.setForeground(new Color(205, 133, 63));
		rdbtnForRent.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		rdbtnForRent.setBackground(Color.BLACK);
		rdbtnForRent.setBounds(291, 393, 90, 27);
		desktopproperty.add(rdbtnForRent);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setForeground(new Color(205, 133, 63));
		lblStatus.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblStatus.setBounds(30, 392, 108, 28);
		desktopproperty.add(lblStatus);
		
		JLabel lblPropertyType = new JLabel("PROPERTY TYPE");
		lblPropertyType.setForeground(new Color(205, 133, 63));
		lblPropertyType.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPropertyType.setBounds(32, 48, 120, 28);
		desktopproperty.add(lblPropertyType);
		
		//loading db result to cbo for type
		int record=0;
		try {
			type=propertytypedao.getAlltype();
			record=type.size();
			type_id=new String[record+1];
			type_id[0]="All";
			for(int i=0;i<record;i++) {
				type_id[i+1]=type.get(i).getName();
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JComboBox typecombo = new JComboBox(type_id);
		typecombo.setBackground(new Color(205, 133, 63));
		typecombo.setBounds(184, 48, 223, 38);
		desktopproperty.add(typecombo);
		
		JLabel lblOwner = new JLabel("OWNER");
		lblOwner.setForeground(new Color(205, 133, 63));
		lblOwner.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblOwner.setBounds(30, 114, 120, 28);
		desktopproperty.add(lblOwner);
		
		//loading db result to cbo for type
				record=0;
				try {
					ownername=ownerdao.getAllowner();
					record=ownername.size();
					owner_name=new String[record+1];
					owner_name[0]="All";
					for(int i=0;i<record;i++) {
						owner_name[i+1]=ownername.get(i).getOwnername();
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		
		JComboBox ownercombo = new JComboBox(owner_name);
		ownercombo.setBackground(new Color(205, 133, 63));
		ownercombo.setBounds(187, 111, 220, 38);
		desktopproperty.add(ownercombo);

		JScrollPane scrollPaneProperty = new JScrollPane();
		scrollPaneProperty.setBounds(429, 0, 685, 572);
		panelproperty.add(scrollPaneProperty);
		
		propertytable = new JTable();
		propertytable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//tfownerid.setText(propertytable.getValueAt(propertytable.getSelectedRow(), 1).toString());				
//				String value=typecombo.getSelectedItem().toString();
				typecombo.setSelectedItem(propertytable.getValueAt(propertytable.getSelectedRow(), 3).toString());
				//tfownerid.setText(propertytable.getValueAt(propertytable.getSelectedRow(), 2).toString());
				tfarea.setText(propertytable.getValueAt(propertytable.getSelectedRow(), 2).toString());
				tfprice.setText(propertytable.getValueAt(propertytable.getSelectedRow(), 3).toString());
				tfaddress.setText(propertytable.getValueAt(propertytable.getSelectedRow(), 4).toString());
				String status=propertytable.getValueAt(propertytable.getSelectedRow(), 6).toString();
				if(status.equals("For sale")) {
					rdbtnSale.setSelected(true);
				}
				else rdbtnForRent.setSelected(true);
				tadescription.setText(propertytable.getValueAt(propertytable.getSelectedRow(), 7).toString());
				
			}
		});
		propertytable.setForeground(new Color(210, 180, 140));
		propertytable.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		propertytable.setBackground(Color.BLACK);
		scrollPaneProperty.setViewportView(propertytable);
		
		
		JButton btnPropertyRefresh = new JButton("REFRESH");
		btnPropertyRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					propertyDAO propertydao=new propertyDAO();
					ArrayList<property> temp= new ArrayList<property>();
					temp=propertydao.getAllProperty();
					PropertyTableModel propertytablemodel=new PropertyTableModel(temp);
					propertytable.setModel(propertytablemodel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				typecombo.setSelectedItem(null);
				ownercombo.setSelectedItem(null);
				tfarea.setText(null);
				tfprice.setText(null);
				tfaddress.setText(null);
				tadescription.setText(null);
				status.clearSelection();
				
				
			}
		});
		btnPropertyRefresh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnPropertyRefresh.setFocusPainted(false);
		btnPropertyRefresh.setBorderPainted(false);
		btnPropertyRefresh.setBackground(new Color(210, 180, 140));
		btnPropertyRefresh.setBounds(429, 573, 685, 43);
		panelproperty.add(btnPropertyRefresh);
		
		JButton btnADD = new JButton("ADD");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String propertytype=typecombo.getSelectedItem().toString();
				String area=tfarea.getText().trim();
				int price=Integer.parseInt(tfprice.getText().trim());
				String address=tfaddress.getText().trim();
				String date=java.time.LocalDate.now().toString();
				String st=null;
				if(rdbtnSale.isSelected()) {
					 st = "For sale";
				}
				if(rdbtnForRent.isSelected()) {
					 st = "For rent";
				}
				String description=tadescription.getText().trim();
				String ownername=ownercombo.getSelectedItem().toString();
				property property=new property(0,propertytype,area,price,address,date,st,description,ownername);
				
				try {
					propertyDAO propertydao= new propertyDAO();
					int y=JOptionPane.showConfirmDialog(null,"Do yor really save!");
					if(y==JOptionPane.YES_OPTION) {
						String ans=propertydao.addproperty(property);
						JOptionPane.showMessageDialog(null,ans,"finished process",JOptionPane.INFORMATION_MESSAGE);
					}
					

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				typecombo.setSelectedItem(null);
				tfarea.setText(null);
				tfprice.setText(null);
				tfaddress.setText(null);
				tadescription.setText(null);
				ownercombo.setSelectedItem(null);
				status.clearSelection();
				
				//btngroupGender.clearSelection();
				
				
				
				
				
						
			}
		});
		btnADD.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnADD.setFocusPainted(false);
		btnADD.setBorderPainted(false);
		btnADD.setBackground(new Color(205, 133, 63));
		btnADD.setBounds(554, 626, 106, 43);
		panelproperty.add(btnADD);
		
		JButton btnPropertyAdd = new JButton("ADD");
		btnADD.setBounds(20, 632, 106, 43);
		panelproperty.add(btnADD);
		btnADD.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnADD.setFocusPainted(false);
		btnADD.setBorderPainted(false);
		btnADD.setBackground(new Color(210, 180, 140));
		
		JButton btnPropertyEdit = new JButton("Edit");
		btnPropertyEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					propertyDAO propertydao=new propertyDAO();
					setVisible(false);
									
					property pt= propertydao.getAllProperty().get(propertytable.getSelectedRow());
					new propertyupdateanddeleteUI(pt).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPropertyEdit.setBounds(173, 632, 106, 43);
		panelproperty.add(btnPropertyEdit);
		btnPropertyEdit.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnPropertyEdit.setFocusPainted(false);
		btnPropertyEdit.setBorderPainted(false);
		btnPropertyEdit.setBackground(new Color(210, 180, 140));
		
		JButton btnPropertyRemove = new JButton("REMOVE");
		btnPropertyRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					propertyDAO propertydao=new propertyDAO();
					setVisible(false);
									
					property pt= propertydao.getAllProperty().get(propertytable.getSelectedRow());
					new propertyupdateanddeleteUI(pt).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
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
		
		JButton btnback = new JButton("<<<");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new OwnerUI().setVisible(true);
			}
		});
		btnback.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnback.setFocusPainted(false);
		btnback.setBorderPainted(false);
		btnback.setBackground(new Color(205, 133, 63));
		btnback.setBounds(512, 626, 106, 43);
		panelproperty.add(btnback);
		
		
	}
}
