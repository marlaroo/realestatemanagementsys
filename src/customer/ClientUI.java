package customer;

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
import Owner.OwnerDAO;
import Owner.OwnerUI;
import Owner.owner;
import Owner.updateanddeleteUI;
import buy.buyUI;
import property.PropertyUI;
import property_type.typeUI;
import rent.RentUI;

import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfclientname;
	private JTextField tfclientnrc;
	private JTextField tfclientphone;
	private JTextField tfclientemail;
	private JTable clienttable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientUI frame = new ClientUI();
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
	public ClientUI() {
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
				customerDAO customerdao=new customerDAO();
				ArrayList<customer> temp= new ArrayList<customer>();
				try {
					temp=customerdao.getAllcustomer();
					CustomerTableModel customertablemodel=new CustomerTableModel(temp);
					clienttable.setModel(customertablemodel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		JPanel panelclient = new JPanel();
		panelclient.setLayout(null);
		panelclient.setBackground(new Color(205, 133, 63));
		panelclient.setBounds(0, 0, 1114, 710);
		contentPane.add(panelclient);
		
		JDesktopPane desktopproperty = new JDesktopPane();
		desktopproperty.setBackground(Color.BLACK);
		desktopproperty.setBounds(0, 0, 495, 591);
		panelclient.add(desktopproperty);
		
		JLabel lblclient = new JLabel("CLIENT INFORMATION");
		lblclient.setForeground(new Color(205, 133, 63));
		lblclient.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblclient.setBounds(60, 22, 239, 28);
		desktopproperty.add(lblclient);
		
		JLabel lblclientname = new JLabel("NAME");
		lblclientname.setForeground(new Color(205, 133, 63));
		lblclientname.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblclientname.setBounds(30, 97, 93, 28);
		desktopproperty.add(lblclientname);
		
		tfclientname = new JTextField();
		tfclientname.setForeground(Color.BLACK);
		tfclientname.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfclientname.setColumns(10);
		tfclientname.setBackground(new Color(205, 133, 63));
		tfclientname.setBounds(155, 93, 223, 38);
		desktopproperty.add(tfclientname);
		
		JLabel lblClientAddress = new JLabel("ADDRESS");
		lblClientAddress.setForeground(new Color(205, 133, 63));
		lblClientAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblClientAddress.setBounds(30, 419, 108, 28);
		desktopproperty.add(lblClientAddress);
		
		JTextArea taclientaddress = new JTextArea();
		taclientaddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		taclientaddress.setBackground(new Color(205, 133, 63));
		taclientaddress.setBounds(155, 409, 223, 129);
		desktopproperty.add(taclientaddress);
		
		JLabel lblClientNRC = new JLabel("NRC");
		lblClientNRC.setForeground(new Color(205, 133, 63));
		lblClientNRC.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblClientNRC.setBounds(30, 171, 93, 28);
		desktopproperty.add(lblClientNRC);
		
		tfclientnrc = new JTextField();
		tfclientnrc.setForeground(Color.BLACK);
		tfclientnrc.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfclientnrc.setColumns(10);
		tfclientnrc.setBackground(new Color(205, 133, 63));
		tfclientnrc.setBounds(155, 167, 223, 38);
		desktopproperty.add(tfclientnrc);
		
		JLabel lblclientPhone = new JLabel("PHONE");
		lblclientPhone.setForeground(new Color(205, 133, 63));
		lblclientPhone.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblclientPhone.setBounds(30, 241, 93, 28);
		desktopproperty.add(lblclientPhone);
		
		tfclientphone = new JTextField();
		tfclientphone.setForeground(Color.BLACK);
		tfclientphone.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfclientphone.setColumns(10);
		tfclientphone.setBackground(new Color(205, 133, 63));
		tfclientphone.setBounds(155, 237, 223, 38);
		desktopproperty.add(tfclientphone);
		
		JLabel lblClientEmail = new JLabel("EMAIL");
		lblClientEmail.setForeground(new Color(205, 133, 63));
		lblClientEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblClientEmail.setBounds(30, 323, 93, 28);
		desktopproperty.add(lblClientEmail);
		
		tfclientemail = new JTextField();
		tfclientemail.setForeground(Color.BLACK);
		tfclientemail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfclientemail.setColumns(10);
		tfclientemail.setBackground(new Color(205, 133, 63));
		tfclientemail.setBounds(155, 319, 223, 38);
		desktopproperty.add(tfclientemail);
		
		JButton btnClientRefresh = new JButton("REFRESH");
		btnClientRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerDAO customerdao=new customerDAO();
				ArrayList<customer> temp= new ArrayList<customer>();
				try {
					temp=customerdao.getAllcustomer();
					CustomerTableModel customertablemodel=new CustomerTableModel(temp);
					clienttable.setModel(customertablemodel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tfclientname.setText(null);
				tfclientnrc.setText(null);
				tfclientphone.setText(null);
				tfclientemail.setText(null);
				taclientaddress.setText(null);
				
			}
		});
		btnClientRefresh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnClientRefresh.setFocusPainted(false);
		btnClientRefresh.setBorderPainted(false);
		btnClientRefresh.setBackground(new Color(210, 180, 140));
		btnClientRefresh.setBounds(494, 541, 620, 50);
		panelclient.add(btnClientRefresh);
		
		JButton btnADD = new JButton("ADD");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tfclientname.getText().trim();
				String nrc=tfclientnrc.getText().trim();
				String phone=tfclientphone.getText().trim();
				String email=tfclientemail.getText().trim();
				String address=taclientaddress.getText().trim();
				customer client=new customer(name,nrc,phone,email,address);
				customerDAO clientdao= new customerDAO();
				try {
					JOptionPane.showConfirmDialog(null,"Do yor really save!");
					String ans=clientdao.addcustomer(client);
					JOptionPane.showMessageDialog(null,ans,"finished process.",JOptionPane.INFORMATION_MESSAGE);

					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tfclientname.setText(null);
				tfclientnrc.setText(null);
				tfclientphone.setText(null);
				tfclientemail.setText(null);
				taclientaddress.setText(null);
				
			}
		});
		btnADD.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnADD.setFocusPainted(false);
		btnADD.setBackground(new Color(210, 180, 140));
		btnADD.setBounds(29, 630, 106, 43);
		panelclient.add(btnADD);
		
		JButton btnPropertyEdit = new JButton("Edit");
		btnPropertyEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerDAO clientdao=new customerDAO();
				customer client;
				try {
					setVisible(false);
					client = clientdao.getAllcustomer().get(clienttable.getSelectedRow());
					
					new updateanddeleteclientUI(client).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPropertyEdit.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnPropertyEdit.setFocusPainted(false);
		btnPropertyEdit.setBorderPainted(false);
		btnPropertyEdit.setBackground(new Color(210, 180, 140));
		btnPropertyEdit.setBounds(207, 630, 106, 43);
		panelclient.add(btnPropertyEdit);
		
		JButton btnPropertyRemove = new JButton("REMOVE");
		btnPropertyRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerDAO clientdao=new customerDAO();
				customer client;
				try {
					setVisible(false);
					client = clientdao.getAllcustomer().get(clienttable.getSelectedRow());
					
					new updateanddeleteclientUI(client).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPropertyRemove.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnPropertyRemove.setFocusPainted(false);
		btnPropertyRemove.setBorderPainted(false);
		btnPropertyRemove.setBackground(new Color(210, 180, 140));
		btnPropertyRemove.setBounds(389, 630, 106, 43);
		panelclient.add(btnPropertyRemove);
		
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
		btnback.setBounds(575, 630, 106, 43);
		panelclient.add(btnback);
		
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
		btnXxx.setBounds(892, 630, 106, 43);
		panelclient.add(btnXxx);
		
		JScrollPane scrollPaneClient = new JScrollPane();
		scrollPaneClient.setBounds(494, 0, 620, 551);
		panelclient.add(scrollPaneClient);
		
		clienttable = new JTable();
		clienttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfclientname.setText(clienttable.getValueAt(clienttable.getSelectedRow(), 1).toString());
				tfclientnrc.setText(clienttable.getValueAt(clienttable.getSelectedRow(), 2).toString());
				tfclientphone.setText(clienttable.getValueAt(clienttable.getSelectedRow(), 3).toString());
				tfclientemail.setText(clienttable.getValueAt(clienttable.getSelectedRow(), 4).toString());
				taclientaddress.setText(clienttable.getValueAt(clienttable.getSelectedRow(),5).toString());
				
			}
		});
		clienttable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		clienttable.setForeground(new Color(210, 180, 140));
		clienttable.setBackground(new Color(0, 0, 0));
		scrollPaneClient.setViewportView(clienttable);
	}

}
