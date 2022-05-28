package property_type;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Admin.Home;
import Admin.MainUI;
import Owner.OwnerUI;
import buy.buyUI;
import customer.ClientUI;
import property.PropertyUI;
import rent.RentUI;

import javax.swing.border.TitledBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;

public class typeUI extends JFrame {

	private JPanel contentPane;
	public static ArrayList<property_type> type= new ArrayList<property_type>();
	private JTable typetable;
	private typeDAO typedao;
	private TypeTableModel typeModel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					typeUI frame = new typeUI();
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
	public typeUI() {
		
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
		mnHome.setIcon(new ImageIcon(typeUI.class.getResource("/img/home-icon.png")));
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
		mnProperty.setIcon(new ImageIcon(typeUI.class.getResource("/img/property-icon.png")));
		mnProperty.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		mnProperty.setForeground(new Color(205, 133, 63));
		mnProperty.setBackground(new Color(210, 105, 30));
		menuBar.add(mnProperty);
		
		JMenu mnType = new JMenu("TYPE");
		mnType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				typeDAO typedao=new typeDAO();
				ArrayList<property_type> temp= new ArrayList<property_type>();
				try {
					temp=typedao.getAlltype();
					TypeTableModel typetablemodel=new TypeTableModel(temp);
					typetable.setModel(typetablemodel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnType.setIcon(new ImageIcon(typeUI.class.getResource("/img/Property-Type-icon.png")));
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
		mnOwner.setIcon(new ImageIcon(typeUI.class.getResource("/img/owner_icon.png")));
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
		mnClient.setIcon(new ImageIcon(typeUI.class.getResource("/img/client-icon.png")));
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
		mnRent.setIcon(new ImageIcon(typeUI.class.getResource("/img/rent_icon.png")));
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
		mnSell.setIcon(new ImageIcon(typeUI.class.getResource("/img/sell_icon.png")));
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
				
				
				
				JLabel lblName = new JLabel("NAME");
				lblName.setForeground(new Color(205, 133, 63));
				lblName.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
				lblName.setBounds(78, 127, 55, 28);
				desktopPane.add(lblName);
				
				JTextField tftypename = new JTextField();
				tftypename.setForeground(Color.BLACK);
				tftypename.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
				tftypename.setColumns(10);
				tftypename.setBackground(new Color(205, 133, 63));
				tftypename.setBounds(208, 127, 251, 38);
				desktopPane.add(tftypename);
				
				JLabel lblDescription = new JLabel("DESCRIPTION");
				lblDescription.setForeground(new Color(205, 133, 63));
				lblDescription.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
				lblDescription.setBounds(78, 260, 108, 28);
				desktopPane.add(lblDescription);
				
				JTextArea tatypedescription = new JTextArea();
				tatypedescription.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
				tatypedescription.setBackground(new Color(205, 133, 63));
				tatypedescription.setBounds(211, 262, 248, 188);
				desktopPane.add(tatypedescription);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(547, 0, 577, 518);
				paneltype.add(scrollPane);
				
				typetable = new JTable();
				typetable.setForeground(new Color(210, 180, 140));
				typetable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						tftypename.setText(typetable.getValueAt(typetable.getSelectedRow(), 1).toString());
						tatypedescription.setText(typetable.getValueAt(typetable.getSelectedRow(), 2).toString());
						//***
						
						
					}
				});
				typetable.setFont(new Font("Times New Roman", Font.PLAIN, 10));
				typetable.setBackground(Color.BLACK);
				typetable.setBounds(0, 0, 575, 1);
				scrollPane.setViewportView(typetable);
				
				JButton btnAdd = new JButton("ADD");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name=tftypename.getText().trim();
						String description=tatypedescription.getText().trim();
						property_type new_type=new property_type(name,description);
						typeDAO typedao= new typeDAO();
						try {
							JOptionPane.showConfirmDialog(null,"Do yor really save!");
							String ans=typedao.addtype(new_type);
							JOptionPane.showMessageDialog(null,ans,"finished process.",JOptionPane.INFORMATION_MESSAGE);
	
							} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						tftypename.setText(null);
						tatypedescription.setText(null);
					}
				});
				btnAdd.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
				btnAdd.setFocusPainted(false);
				btnAdd.setBorderPainted(false);
				btnAdd.setBackground(new Color(210, 180, 140));
				btnAdd.setBounds(27, 587, 106, 43);
				desktopPane.add(btnAdd);
				
				JButton btnEdit = new JButton("Edit");
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						typeDAO typedao=new typeDAO();
						property_type ty;
						try {
							setVisible(false);
							ty = typedao.getAlltype().get(typetable.getSelectedRow());
							
							new updateanddelete(ty).setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
				btnEdit.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
				btnEdit.setFocusPainted(false);
				btnEdit.setBorderPainted(false);
				btnEdit.setBackground(new Color(210, 180, 140));
				btnEdit.setBounds(208, 587, 106, 43);
				desktopPane.add(btnEdit);
				
				JButton btnRemove = new JButton("REMOVE");
				btnRemove.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						typeDAO typedao=new typeDAO();
						property_type ty;
						try {
							setVisible(false);
							ty = typedao.getAlltype().get(typetable.getSelectedRow());
							
							new updateanddelete(ty).setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

							
						}
					
				});
				btnRemove.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
				btnRemove.setFocusPainted(false);
				btnRemove.setBorderPainted(false);
				btnRemove.setBackground(new Color(210, 180, 140));
				btnRemove.setBounds(390, 587, 106, 43);
				desktopPane.add(btnRemove);
				
			
				
				JButton btnRefresh = new JButton("REFRESH");
				btnRefresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						typeDAO typedao=new typeDAO();
						ArrayList<property_type> temp= new ArrayList<property_type>();
						try {
							temp=typedao.getAlltype();
							TypeTableModel typetablemodel=new TypeTableModel(temp);
							typetable.setModel(typetablemodel);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						tftypename.setText(null);
						tatypedescription.setText(null);
						
					}
					});
				btnRefresh.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
				btnRefresh.setFocusPainted(false);
				btnRefresh.setBorderPainted(false);
				btnRefresh.setBackground(new Color(210, 180, 140));
				btnRefresh.setBounds(547, 587, 567, 43);
				paneltype.add(btnRefresh);
				
				JButton btnBack = new JButton("<<<");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						new PropertyUI().setVisible(true);
					}
				});
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
				
		
	}
}
