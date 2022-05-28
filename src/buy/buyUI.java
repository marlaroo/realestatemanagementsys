package buy;

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
import customer.ClientUI;
import property.PropertyUI;
import property_type.typeUI;
import rent.RentInClientTableModel;
import rent.RentInPropertyTableModel;
import rent.RentTableModel;
import rent.RentUI;
import rent.rent;
import rent.rentDAO;
import rent.rentupdateanddeleteUI;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class buyUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfsalepropertyname;
	private JTextField tfsalecustomername;
	private JTextField tfsaleprice;
	private JTextField tfsaledate;
	private JTable salelisttable;
	private JTable saleclientlisttable;
	private JTable salepropertylisttable;
	private JTextField tfsaleownername;
	private JTextField tfsaleaddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buyUI frame = new buyUI();
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
	public buyUI() {
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
		
		JPanel panelsale = new JPanel();
		panelsale.setLayout(null);
		panelsale.setBackground(new Color(205, 133, 63));
		panelsale.setBounds(0, 0, 1466, 712);
		contentPane.add(panelsale);
		
		JScrollPane scrollPanesaleclientlist = new JScrollPane();
		scrollPanesaleclientlist.setBounds(670, 67, 202, 515);
		panelsale.add(scrollPanesaleclientlist);
		
		saleclientlisttable = new JTable();
		saleclientlisttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfsalecustomername.setText(saleclientlisttable.getValueAt(saleclientlisttable.getSelectedRow(),1).toString());
			}
		});
		saleclientlisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		saleclientlisttable.setForeground(new Color(210, 180, 140));
		saleclientlisttable.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		saleclientlisttable.setBackground(Color.BLACK);
		scrollPanesaleclientlist.setViewportView(saleclientlisttable);
		
		JScrollPane scrollPanesalepropertylist = new JScrollPane();
		scrollPanesalepropertylist.setBounds(882, 67, 227, 514);
		panelsale.add(scrollPanesalepropertylist);
		
		salepropertylisttable = new JTable();
		salepropertylisttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfsaleownername.setText(salepropertylisttable.getValueAt(salepropertylisttable.getSelectedRow(),2).toString());
				tfsalepropertyname.setText(salepropertylisttable.getValueAt(salepropertylisttable.getSelectedRow(),1).toString());
				tfsaleprice.setText(salepropertylisttable.getValueAt(salepropertylisttable.getSelectedRow(), 4).toString());
				tfsaleaddress.setText(salepropertylisttable.getValueAt(salepropertylisttable.getSelectedRow(), 5).toString());
			}
		});
		salepropertylisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		salepropertylisttable.setForeground(new Color(210, 180, 140));
		salepropertylisttable.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		salepropertylisttable.setBackground(Color.BLACK);
		scrollPanesalepropertylist.setViewportView(salepropertylisttable);
		
		JDesktopPane desktopsale = new JDesktopPane();
		desktopsale.setBackground(Color.BLACK);
		desktopsale.setBounds(0, 0, 320, 702);
		panelsale.add(desktopsale);
		
		JLabel lblsalepropertyname = new JLabel("PROPERTY");
		lblsalepropertyname.setForeground(new Color(205, 133, 63));
		lblsalepropertyname.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsalepropertyname.setBounds(10, 115, 111, 28);
		desktopsale.add(lblsalepropertyname);
		
		tfsalepropertyname = new JTextField();
		tfsalepropertyname.setForeground(Color.BLACK);
		tfsalepropertyname.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsalepropertyname.setColumns(10);
		tfsalepropertyname.setBackground(new Color(205, 133, 63));
		tfsalepropertyname.setBounds(142, 111, 168, 38);
		desktopsale.add(tfsalepropertyname);
		
		JLabel lblsalecustomername = new JLabel("CUSTOMERID");
		lblsalecustomername.setForeground(new Color(205, 133, 63));
		lblsalecustomername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsalecustomername.setBounds(10, 187, 111, 28);
		desktopsale.add(lblsalecustomername);
		
		tfsalecustomername = new JTextField();
		tfsalecustomername.setForeground(Color.BLACK);
		tfsalecustomername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsalecustomername.setColumns(10);
		tfsalecustomername.setBackground(new Color(205, 133, 63));
		tfsalecustomername.setBounds(142, 183, 168, 38);
		desktopsale.add(tfsalecustomername);
		
		JButton btnsaleadd = new JButton("ADD");
		btnsaleadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ownername=tfsaleownername.getText().trim(); 			
				String customername=tfsalecustomername.getText().trim();
				int price=Integer.parseInt(tfsaleprice.getText().trim());
				String date=tfsaledate.getText().trim();
				String property=tfsalepropertyname.getText().trim();
				String address=tfsaleaddress.getText().trim();
				//String date=java.time.LocalDate.now().toString();

				buy bu=new buy(0,ownername,customername,price,date,property,address);
				
				try {
					buyDAO buydao= new buyDAO();
					int y=JOptionPane.showConfirmDialog(null,"Do yor really save!");
					if(y==JOptionPane.YES_OPTION) {
						String ans=buydao.addbuy(bu);
						JOptionPane.showMessageDialog(null,ans,"finished process",JOptionPane.INFORMATION_MESSAGE);
					}
					

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				tfsaleprice.setText(null);
				tfsaledate.setText(null);
				tfsalepropertyname.setText(null);
				tfsalecustomername.setText(null);
			}
		});
		btnsaleadd.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsaleadd.setFocusPainted(false);
		btnsaleadd.setBorderPainted(false);
		btnsaleadd.setBackground(new Color(210, 180, 140));
		btnsaleadd.setBounds(21, 465, 273, 43);
		desktopsale.add(btnsaleadd);
		
		JButton btnsaleedit = new JButton("Edit");
		btnsaleedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buyDAO buydao=new buyDAO();
					setVisible(false);
									
					buy bui= buydao.getAllbuy().get(salelisttable.getSelectedRow());
					new buyupdateanddeleteUI(bui).setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnsaleedit.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsaleedit.setFocusPainted(false);
		btnsaleedit.setBorderPainted(false);
		btnsaleedit.setBackground(new Color(210, 180, 140));
		btnsaleedit.setBounds(21, 544, 273, 43);
		desktopsale.add(btnsaleedit);
		
		JButton btnsaleremove = new JButton("REMOVE");
		btnsaleremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buyDAO buydao=new buyDAO();
					setVisible(false);
									
					buy bui= buydao.getAllbuy().get(salelisttable.getSelectedRow());
					new buyupdateanddeleteUI(bui).setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnsaleremove.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsaleremove.setFocusPainted(false);
		btnsaleremove.setBorderPainted(false);
		btnsaleremove.setBackground(new Color(210, 180, 140));
		btnsaleremove.setBounds(21, 627, 273, 43);
		desktopsale.add(btnsaleremove);
		
		JLabel lblsalePrice = new JLabel("PRICE");
		lblsalePrice.setForeground(new Color(205, 133, 63));
		lblsalePrice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsalePrice.setBounds(10, 260, 111, 28);
		desktopsale.add(lblsalePrice);
		
		tfsaleprice = new JTextField();
		tfsaleprice.setForeground(Color.BLACK);
		tfsaleprice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsaleprice.setColumns(10);
		tfsaleprice.setBackground(new Color(205, 133, 63));
		tfsaleprice.setBounds(142, 256, 168, 38);
		desktopsale.add(tfsaleprice);
		
		JLabel lblsaledate = new JLabel("DATE");
		lblsaledate.setForeground(new Color(205, 133, 63));
		lblsaledate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsaledate.setBounds(10, 339, 111, 28);
		desktopsale.add(lblsaledate);
		
		tfsaledate = new JTextField();
		tfsaledate.setForeground(Color.BLACK);
		tfsaledate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsaledate.setColumns(10);
		tfsaledate.setBackground(new Color(205, 133, 63));
		tfsaledate.setBounds(142, 335, 168, 38);
		desktopsale.add(tfsaledate);
		
		JLabel saleinformationtitle = new JLabel("SALE INFORMATION");
		saleinformationtitle.setForeground(new Color(205, 133, 63));
		saleinformationtitle.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		saleinformationtitle.setBounds(62, 10, 258, 28);
		desktopsale.add(saleinformationtitle);
		
		JLabel lblsaleownername = new JLabel("OWNER");
		lblsaleownername.setForeground(new Color(205, 133, 63));
		lblsaleownername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsaleownername.setBounds(10, 57, 111, 28);
		desktopsale.add(lblsaleownername);
		
		tfsaleownername = new JTextField();
		tfsaleownername.setForeground(Color.BLACK);
		tfsaleownername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsaleownername.setColumns(10);
		tfsaleownername.setBackground(new Color(205, 133, 63));
		tfsaleownername.setBounds(142, 48, 168, 38);
		desktopsale.add(tfsaleownername);
		
		JLabel lblsaleaddress = new JLabel("ADDRESS");
		lblsaleaddress.setForeground(new Color(205, 133, 63));
		lblsaleaddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsaleaddress.setBounds(10, 400, 111, 28);
		desktopsale.add(lblsaleaddress);
		
		tfsaleaddress = new JTextField();
		tfsaleaddress.setForeground(Color.BLACK);
		tfsaleaddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsaleaddress.setColumns(10);
		tfsaleaddress.setBackground(new Color(205, 133, 63));
		tfsaleaddress.setBounds(142, 400, 168, 38);
		desktopsale.add(tfsaleaddress);
		
		JScrollPane scrollPanelsale = new JScrollPane();
		scrollPanelsale.setBounds(326, 67, 334, 515);
		panelsale.add(scrollPanelsale);
		
		salelisttable = new JTable();
		salelisttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfsaleownername.setText(salelisttable.getValueAt(salelisttable.getSelectedRow(), 1).toString());
				tfsalecustomername.setText(salelisttable.getValueAt(salelisttable.getSelectedRow(), 2).toString());
				tfsaleprice.setText(salelisttable.getValueAt(salelisttable.getSelectedRow(), 3).toString());
				tfsaledate.setText(salelisttable.getValueAt(salelisttable.getSelectedRow(), 4).toString());
				tfsalepropertyname.setText(salelisttable.getValueAt(salelisttable.getSelectedRow(), 5).toString());
				tfsaleaddress.setText(salelisttable.getValueAt(salelisttable.getSelectedRow(), 6).toString());
				
				
				
			}
		});
		salelisttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		salelisttable.setForeground(new Color(210, 180, 140));
		salelisttable.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		salelisttable.setBackground(new Color(0, 0, 0));
		scrollPanelsale.setViewportView(salelisttable);
		
		JLabel lblSaleList = new JLabel("SALE LIST");
		lblSaleList.setForeground(Color.BLACK);
		lblSaleList.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblSaleList.setBounds(426, 19, 170, 38);
		panelsale.add(lblSaleList);
		
		JLabel lblsaleClientListtitle = new JLabel("CLIENT LIST");
		lblsaleClientListtitle.setForeground(Color.BLACK);
		lblsaleClientListtitle.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblsaleClientListtitle.setBounds(702, 19, 170, 38);
		panelsale.add(lblsaleClientListtitle);
		
		JLabel lblsalePropertyList = new JLabel("PROPERTY LIST");
		lblsalePropertyList.setForeground(Color.BLACK);
		lblsalePropertyList.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblsalePropertyList.setBounds(921, 19, 170, 38);
		panelsale.add(lblsalePropertyList);
		
		JButton btnsalelistreflesh = new JButton("REFLESH");
		btnsalelistreflesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buyDAO buydao=new buyDAO();
					ArrayList<buy> temp= new ArrayList<buy>();
					temp=buydao.getAllbuy();
					BuyTableModel buytablemodel=new BuyTableModel(temp);
					salelisttable.setModel(buytablemodel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				tfsaleprice.setText(null);
				tfsaledate.setText(null);
				tfsalepropertyname.setText(null);
				tfsalecustomername.setText(null);
				tfsaleownername.setText(null);
				tfsaleaddress.setText(null);
			
			}
		});
		btnsalelistreflesh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsalelistreflesh.setFocusPainted(false);
		btnsalelistreflesh.setBorderPainted(false);
		btnsalelistreflesh.setBackground(new Color(210, 180, 140));
		btnsalelistreflesh.setBounds(325, 592, 335, 43);
		panelsale.add(btnsalelistreflesh);
		
		JButton btnsaleclientlistreflesh = new JButton("REFLESH");
		btnsaleclientlistreflesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					buyDAO buydao=new buyDAO();
					ArrayList<buy> temp= new ArrayList<buy>();
					temp=buydao.getallcustomerlist();
					buyInClientTableModel customertablemodel=new buyInClientTableModel(temp);
					saleclientlisttable.setModel(customertablemodel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				tfsalecustomername.setText(null);
			
			}
		});
		btnsaleclientlistreflesh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnsaleclientlistreflesh.setFocusPainted(false);
		btnsaleclientlistreflesh.setBorderPainted(false);
		btnsaleclientlistreflesh.setBackground(new Color(210, 180, 140));
		btnsaleclientlistreflesh.setBounds(674, 592, 198, 43);
		panelsale.add(btnsaleclientlistreflesh);
		
		JButton btnsalepropertylistreflesh = new JButton("REFLESH");
		btnsalepropertylistreflesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buyDAO buydao=new buyDAO();
					ArrayList<buy> temp= new ArrayList<buy>();
					temp=buydao.getallpropertylist();
					buyInPropertyTableModel propertytablemodel=new buyInPropertyTableModel(temp);
					salepropertylisttable.setModel(propertytablemodel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tfsaleprice.setText(null);
				tfsalepropertyname.setText(null);
				tfsaleownername.setText(null);
				tfsaleaddress.setText(null);
			}
		});
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
