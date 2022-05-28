package rent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import property.PropertyUI;
import property.propertyDAO;

import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class rentupdateanddeleteUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfprice;
	private JTextField tfdeposite;
	private JTextField tffromdate;
	private JTextField tftodate;
	private JTextField tfownername;
	private JTextField tfcustomername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rentupdateanddeleteUI frame = new rentupdateanddeleteUI(null);
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
	public rentupdateanddeleteUI(rent Re) {
		setTitle("RENT INFORMATION");
		setBackground(new Color(210, 180, 140));
		setForeground(new Color(210, 180, 140));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktoprent = new JDesktopPane();
		desktoprent.setBackground(Color.BLACK);
		desktoprent.setBounds(0, 0, 437, 653);
		contentPane.add(desktoprent);
		
		JLabel lblNewLabel_1_1 = new JLabel("RENT INFORMATION");
		lblNewLabel_1_1.setForeground(new Color(205, 133, 63));
		lblNewLabel_1_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(35, 10, 258, 28);
		desktoprent.add(lblNewLabel_1_1);
		
		JButton btnAdd_1 = new JButton("UPDATE");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ownername=tfownername.getText().trim();
				String customername=tfcustomername.getText().trim();
				int price=Integer.parseInt(tfprice.getText().trim());
				int deposite=Integer.parseInt(tfdeposite.getText().trim());
				String fromdate=tffromdate.getText().trim();
				String todate=tftodate.getText().trim();

				Re.setOwner_name(ownername);
				Re.setCustomer_name(customername);
				Re.setPrice(price);
				Re.setDeposite(deposite);
				Re.setFrom_date(fromdate);
				Re.setTo_date(todate);
				
				
				
				int yn=JOptionPane.showConfirmDialog(null,"Do you really want to update Rent information permaniely");
				if(yn==JOptionPane.YES_OPTION) {
					
					try {
						rentDAO rentdao=new rentDAO();
						String msg=rentdao.updaterent(Re);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setVisible(false);
				new RentUI().setVisible(true);
			}
		});
		btnAdd_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnAdd_1.setFocusPainted(false);
		btnAdd_1.setBorderPainted(false);
		btnAdd_1.setBackground(new Color(210, 180, 140));
		btnAdd_1.setBounds(10, 563, 125, 43);
		desktoprent.add(btnAdd_1);
		
		JButton btnEdit_1 = new JButton("DELETE");
		btnEdit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int yn=JOptionPane.showConfirmDialog(null,"Do you really want to delete this Rent's Information permanently");
				if(yn==JOptionPane.YES_OPTION) {
					
					try {
						rentDAO rentdao= new rentDAO();
						String msg=rentdao.deleterent(Re.getRentid());
						JOptionPane.showMessageDialog(null,msg,"Finished Operation",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setVisible(false);
				new RentUI().setVisible(true);
			}
		});
		btnEdit_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnEdit_1.setFocusPainted(false);
		btnEdit_1.setBorderPainted(false);
		btnEdit_1.setBackground(new Color(210, 180, 140));
		btnEdit_1.setBounds(157, 563, 125, 43);
		desktoprent.add(btnEdit_1);
		
		JButton btnRemove_1 = new JButton("CANCEL");
		btnRemove_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new RentUI().setVisible(true);
			}
		});
		btnRemove_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnRemove_1.setFocusPainted(false);
		btnRemove_1.setBorderPainted(false);
		btnRemove_1.setBackground(new Color(210, 180, 140));
		btnRemove_1.setBounds(304, 563, 111, 43);
		desktoprent.add(btnRemove_1);
		
		JLabel lblrentPrice = new JLabel("PRICE");
		lblrentPrice.setForeground(new Color(205, 133, 63));
		lblrentPrice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentPrice.setBounds(10, 198, 111, 28);
		desktoprent.add(lblrentPrice);
		
		tfprice = new JTextField(String.valueOf(Re.getPrice()));
		tfprice.setForeground(Color.BLACK);
		tfprice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfprice.setColumns(10);
		tfprice.setBackground(new Color(205, 133, 63));
		tfprice.setBounds(176, 194, 239, 38);
		desktoprent.add(tfprice);
		
		JLabel lblrentdeposite = new JLabel("DEPOSITE");
		lblrentdeposite.setForeground(new Color(205, 133, 63));
		lblrentdeposite.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentdeposite.setBounds(10, 272, 111, 28);
		desktoprent.add(lblrentdeposite);
		
		tfdeposite = new JTextField(String.valueOf(Re.getDeposite()));
		tfdeposite.setForeground(Color.BLACK);
		tfdeposite.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfdeposite.setColumns(10);
		tfdeposite.setBackground(new Color(205, 133, 63));
		tfdeposite.setBounds(176, 268, 239, 38);
		desktoprent.add(tfdeposite);
		
		JLabel lblrentfromdate = new JLabel("FROM DATE");
		lblrentfromdate.setForeground(new Color(205, 133, 63));
		lblrentfromdate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentfromdate.setBounds(10, 344, 111, 28);
		desktoprent.add(lblrentfromdate);
		
		tffromdate = new JTextField(Re.getFrom_date());
		tffromdate.setForeground(Color.BLACK);
		tffromdate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tffromdate.setColumns(10);
		tffromdate.setBackground(new Color(205, 133, 63));
		tffromdate.setBounds(176, 340, 239, 38);
		desktoprent.add(tffromdate);
		
		JLabel lblrenttodate = new JLabel("TO DATE");
		lblrenttodate.setForeground(new Color(205, 133, 63));
		lblrenttodate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrenttodate.setBounds(10, 430, 111, 28);
		desktoprent.add(lblrenttodate);
		
		tftodate = new JTextField(Re.getTo_date());
		tftodate.setForeground(Color.BLACK);
		tftodate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tftodate.setColumns(10);
		tftodate.setBackground(new Color(205, 133, 63));
		tftodate.setBounds(176, 426, 239, 38);
		desktoprent.add(tftodate);
		
		JLabel lblpropertyownername = new JLabel("OWNER");
		lblpropertyownername.setForeground(new Color(205, 133, 63));
		lblpropertyownername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblpropertyownername.setBounds(10, 48, 140, 28);
		desktoprent.add(lblpropertyownername);
		
		tfownername = new JTextField(Re.getOwner_name());
		tfownername.setForeground(Color.BLACK);
		tfownername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfownername.setColumns(10);
		tfownername.setBackground(new Color(205, 133, 63));
		tfownername.setBounds(177, 48, 238, 38);
		desktoprent.add(tfownername);
		
		JLabel lblrentcustomerid = new JLabel("CUSTOMER");
		lblrentcustomerid.setForeground(new Color(205, 133, 63));
		lblrentcustomerid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblrentcustomerid.setBounds(10, 120, 140, 28);
		desktoprent.add(lblrentcustomerid);
		
		tfcustomername = new JTextField(Re.getCustomer_name());
		tfcustomername.setForeground(Color.BLACK);
		tfcustomername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfcustomername.setColumns(10);
		tfcustomername.setBackground(new Color(205, 133, 63));
		tfcustomername.setBounds(177, 116, 238, 38);
		desktoprent.add(tfcustomername);
	}
}
