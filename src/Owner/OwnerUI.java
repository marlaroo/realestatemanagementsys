package Owner;

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

import javax.swing.AbstractButton;
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
import buy.buyUI;
import customer.ClientUI;
import property.*;

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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class OwnerUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfownername;
	private JTextField tfownernrc;
	private JTextField tfownerphone;
	private JTextField tfowneremail;
	private JTable ownertable;
	private JTextArea textowneraddress;

	private int[] property_id;
	private ArrayList<property> type = new ArrayList<property>();
	private propertyDAO propertydao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerUI frame = new OwnerUI();
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
	public OwnerUI() {
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

				OwnerDAO ownerdao=new OwnerDAO();
				ArrayList<owner> temp= new ArrayList<owner>();
				try {
					temp=ownerdao.getAllowner();
					OwnerTableModel ownertablemodel=new OwnerTableModel(temp);
					ownertable.setModel(ownertablemodel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		JPanel panelowner = new JPanel();
		panelowner.setLayout(null);
		panelowner.setBackground(new Color(205, 133, 63));
		panelowner.setBounds(0, 0, 1114, 700);
		contentPane.add(panelowner);
		
		JScrollPane scrollPaneProperty = new JScrollPane();
		scrollPaneProperty.setBounds(489, 0, 625, 572);
		panelowner.add(scrollPaneProperty);
		
		ownertable = new JTable();
		ownertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfownername.setText(ownertable.getValueAt(ownertable.getSelectedRow(), 1).toString());
				tfownernrc.setText(ownertable.getValueAt(ownertable.getSelectedRow(), 2).toString());
				tfowneremail.setText(ownertable.getValueAt(ownertable.getSelectedRow(), 3).toString());
				tfownerphone.setText(ownertable.getValueAt(ownertable.getSelectedRow(), 4).toString());
				textowneraddress.setText(ownertable.getValueAt(ownertable.getSelectedRow(),5).toString());
					
			}
		});
		ownertable.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		ownertable.setForeground(new Color(210, 180, 140));
		ownertable.setBackground(Color.BLACK);
		scrollPaneProperty.setViewportView(ownertable);
		
		JDesktopPane desktopproperty = new JDesktopPane();
		desktopproperty.setBackground(Color.BLACK);
		desktopproperty.setBounds(0, 0, 488, 616);
		panelowner.add(desktopproperty);
		
		JLabel lblproperty = new JLabel("OWNER INFORMATION");
		lblproperty.setForeground(new Color(205, 133, 63));
		lblproperty.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblproperty.setBounds(34, 22, 239, 28);
		desktopproperty.add(lblproperty);
		
		JLabel lblOwnername = new JLabel("NAME");
		lblOwnername.setForeground(new Color(205, 133, 63));
		lblOwnername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblOwnername.setBounds(30, 97, 93, 28);
		desktopproperty.add(lblOwnername);
		
		tfownername = new JTextField();
		tfownername.setForeground(Color.BLACK);
		tfownername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfownername.setColumns(10);
		tfownername.setBackground(new Color(205, 133, 63));
		tfownername.setBounds(155, 93, 223, 38);
		desktopproperty.add(tfownername);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(205, 133, 63));
		lblAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblAddress.setBounds(30, 431, 108, 28);
		desktopproperty.add(lblAddress);
		
		textowneraddress = new JTextArea();
		textowneraddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		textowneraddress.setBackground(new Color(205, 133, 63));
		textowneraddress.setBounds(155, 420, 223, 159);
		desktopproperty.add(textowneraddress);
		
		JLabel lblNRC = new JLabel("NRC");
		lblNRC.setForeground(new Color(205, 133, 63));
		lblNRC.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNRC.setBounds(34, 177, 93, 28);
		desktopproperty.add(lblNRC);
		
		tfownernrc = new JTextField();
		tfownernrc.setForeground(Color.BLACK);
		tfownernrc.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfownernrc.setColumns(10);
		tfownernrc.setBackground(new Color(205, 133, 63));
		tfownernrc.setBounds(155, 173, 223, 38);
		desktopproperty.add(tfownernrc);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setForeground(new Color(205, 133, 63));
		lblPhone.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPhone.setBounds(34, 336, 93, 28);
		desktopproperty.add(lblPhone);
		
		tfownerphone = new JTextField();
		tfownerphone.setForeground(Color.BLACK);
		tfownerphone.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfownerphone.setColumns(10);
		tfownerphone.setBackground(new Color(205, 133, 63));
		tfownerphone.setBounds(155, 332, 223, 38);
		desktopproperty.add(tfownerphone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(205, 133, 63));
		lblEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblEmail.setBounds(34, 262, 93, 28);
		desktopproperty.add(lblEmail);
		
		tfowneremail = new JTextField();
		tfowneremail.setForeground(Color.BLACK);
		tfowneremail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfowneremail.setColumns(10);
		tfowneremail.setBackground(new Color(205, 133, 63));
		tfowneremail.setBounds(155, 258, 223, 38);
		desktopproperty.add(tfowneremail);

		
		JButton btnPropertyRefresh = new JButton("REFRESH");
		btnPropertyRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OwnerDAO ownerdao=new OwnerDAO();
				ArrayList<owner> temp= new ArrayList<owner>();
				try {
					temp=ownerdao.getAllowner();
					OwnerTableModel ownertablemodel=new OwnerTableModel(temp);
					ownertable.setModel(ownertablemodel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tfownername.setText(null);
				tfownernrc.setText(null);
				tfownerphone.setText(null);
				tfowneremail.setText(null);
				textowneraddress.setText(null);
				
			}
		});
		btnPropertyRefresh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnPropertyRefresh.setFocusPainted(false);
		btnPropertyRefresh.setBorderPainted(false);
		btnPropertyRefresh.setBackground(new Color(210, 180, 140));
		btnPropertyRefresh.setBounds(489, 573, 625, 43);
		panelowner.add(btnPropertyRefresh);
		
		JButton btnADD = new JButton("ADD");
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tfownername.getText().trim();
				String nrc=tfownernrc.getText().trim();
				String email=tfowneremail.getText().trim();
				String phone=tfownerphone.getText().trim();
				String address=textowneraddress.getText().trim();
				
				owner new_owner=new owner(name,nrc,email,phone,address);
				OwnerDAO ownerdao= new OwnerDAO();
//				new_owner.setOwnername(name);
//				new_owner.setOwner_nrc(nrc);
//				new_owner.setEmail(email);
//				new_owner.setPhone(phone);
//				new_owner.setAddress(address);
//				
				try {
					JOptionPane.showConfirmDialog(null,"Do yor really save!");
					String ans=ownerdao.addowner(new_owner);
					JOptionPane.showMessageDialog(null,ans,"finished process.",JOptionPane.INFORMATION_MESSAGE);

					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tfownername.setText(null);
				tfownernrc.setText(null);
				tfowneremail.setText(null);
				tfownerphone.setText(null);
				textowneraddress.setText(null);
				
				}

			private String String(String trim) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnADD.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnADD.setFocusPainted(false);
		btnADD.setBackground(new Color(210, 180, 140));
		btnADD.setBounds(49, 635, 106, 43);
		panelowner.add(btnADD);
		
		JButton btnPropertyEdit = new JButton("Edit");
		btnPropertyEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OwnerDAO ownerdao=new OwnerDAO();
				owner owner;
				try {
					setVisible(false);
					owner = ownerdao.getAllowner().get(ownertable.getSelectedRow());
					
					new updateanddeleteUI(owner).setVisible(true);
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
		btnPropertyEdit.setBounds(218, 635, 106, 43);
		panelowner.add(btnPropertyEdit);
		
		JButton btnPropertyRemove = new JButton("REMOVE");
		btnPropertyRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OwnerDAO ownerdao=new OwnerDAO();
				owner owner;
				try {
					setVisible(false);
					owner = ownerdao.getAllowner().get(ownertable.getSelectedRow());
					
					new updateanddeleteUI(owner).setVisible(true);
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
		btnPropertyRemove.setBounds(404, 635, 106, 43);
		panelowner.add(btnPropertyRemove);
		
		JButton btnback = new JButton("PROPERTY");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PropertyUI().setVisible(true);
			
			}
		});
		btnback.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnback.setFocusPainted(false);
		btnback.setBorderPainted(false);
		btnback.setBackground(new Color(205, 133, 63));
		btnback.setBounds(583, 635, 174, 43);
		panelowner.add(btnback);
		
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
		btnXxx.setBounds(860, 635, 106, 43);
		panelowner.add(btnXxx);
	}
}
