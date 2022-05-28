package property;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Owner.OwnerDAO;
import Owner.OwnerUI;
import Owner.owner;
import property_type.property_type;
import property_type.typeDAO;

import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class propertyupdateanddeleteUI extends JFrame {

	private JPanel contentPane;
	private final JDesktopPane desktopproperty = new JDesktopPane();
	private JTextField tfowner;
	private JTextField tfprice;
	private JTextField tfaddress;
	private JTextField tfupdatedate;
	private String[] type_name;
	private ArrayList<property_type> type = new ArrayList<property_type>();
	typeDAO typedao=new typeDAO();
	private String[] owner_name;
	private ArrayList<owner> ownername = new ArrayList<owner>();
	OwnerDAO ownerdao=new OwnerDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					propertyupdateanddeleteUI frame = new propertyupdateanddeleteUI(null);
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
	public propertyupdateanddeleteUI(property pt) {
		setTitle("PROPERTY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 789);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 180, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		desktopproperty.setBounds(0, 0, 469, 742);
		contentPane.add(desktopproperty);
		desktopproperty.setBackground(Color.BLACK);
		
		JLabel lblproperty = new JLabel("PROPERTY ");
		lblproperty.setForeground(new Color(205, 133, 63));
		lblproperty.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblproperty.setBounds(10, 10, 209, 28);
		desktopproperty.add(lblproperty);
		
//		loading data to combobox
		int record=0;
		try {
			type=typedao.getAlltype();
			record=type.size();
			type_name=new String[record+1];
			type_name[0]="All";
			for(int i=0;i<record;i++) {
				type_name[i+1]=type.get(i).getName();
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
//		loading data to ownercombobox
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
		
		JLabel lblArea = new JLabel("AREA");
		lblArea.setForeground(new Color(205, 133, 63));
		lblArea.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblArea.setBounds(30, 78, 93, 28);
		desktopproperty.add(lblArea);
		
		tfowner = new JTextField(String.valueOf(pt.getArea()));
		tfowner.setForeground(Color.BLACK);
		tfowner.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfowner.setColumns(10);
		tfowner.setBackground(new Color(205, 133, 63));
		tfowner.setBounds(184, 74, 257, 38);
		desktopproperty.add(tfowner);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(new Color(205, 133, 63));
		lblPrice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPrice.setBounds(30, 161, 93, 28);
		desktopproperty.add(lblPrice);
		
		tfprice = new JTextField(String.valueOf(pt.getPrice()));
		tfprice.setForeground(Color.BLACK);
		tfprice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfprice.setColumns(10);
		tfprice.setBackground(new Color(205, 133, 63));
		tfprice.setBounds(184, 157, 257, 38);
		desktopproperty.add(tfprice);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(205, 133, 63));
		lblAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblAddress.setBounds(30, 240, 108, 28);
		desktopproperty.add(lblAddress);
		
		tfaddress = new JTextField(pt.getAddress());
		tfaddress.setForeground(Color.BLACK);
		tfaddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfaddress.setColumns(10);
		tfaddress.setBackground(new Color(205, 133, 63));
		tfaddress.setBounds(184, 236, 257, 38);
		desktopproperty.add(tfaddress);
		
		JRadioButton rdbtnSale = new JRadioButton("for sale");
		rdbtnSale.setForeground(new Color(205, 133, 63));
		rdbtnSale.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		rdbtnSale.setBackground(Color.BLACK);
		rdbtnSale.setBounds(198, 417, 103, 27);
		desktopproperty.add(rdbtnSale);
		
		JRadioButton rdbtnForRent = new JRadioButton("for rent");
		rdbtnForRent.setForeground(new Color(205, 133, 63));
		rdbtnForRent.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		rdbtnForRent.setBackground(Color.BLACK);
		rdbtnForRent.setBounds(353, 417, 90, 27);
		desktopproperty.add(rdbtnForRent);
		
		JLabel lblStatus = new JLabel("STATUS");
		lblStatus.setForeground(new Color(205, 133, 63));
		lblStatus.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblStatus.setBounds(30, 416, 108, 28);
		desktopproperty.add(lblStatus);
		
		if(pt.getStatus().equals("For sale"))
			rdbtnSale.setSelected(true);
		else rdbtnForRent.setSelected(true);
		
		JLabel lblPropertyDescription = new JLabel("DESCRIPTION");
		lblPropertyDescription.setForeground(new Color(205, 133, 63));
		lblPropertyDescription.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPropertyDescription.setBounds(30, 498, 108, 28);
		desktopproperty.add(lblPropertyDescription);
		
		JTextArea tadescription = new JTextArea(pt.getDescription());
		tadescription.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tadescription.setBackground(new Color(205, 133, 63));
		tadescription.setBounds(184, 482, 275, 143);
		desktopproperty.add(tadescription);
		
	
		
		JButton btnupdate = new JButton("UPDATE");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String area=tfowner.getText().trim();
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
				pt.setArea(area);
				pt.setPrice(price);
				pt.setAddress(address);
				pt.setUpdate(date);
				pt.setStatus(st);
				pt.setDescription(description);
				
				
				int yn=JOptionPane.showConfirmDialog(null,"Do you really want to update Property information permaniely");
				if(yn==JOptionPane.YES_OPTION) {
					
					try {
						propertyDAO propertydao=new propertyDAO();
						String msg=propertydao.updateproperty(pt);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setVisible(false);
				new PropertyUI().setVisible(true);
			}
		});
		btnupdate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnupdate.setFocusPainted(false);
		btnupdate.setBorderPainted(false);
		btnupdate.setBackground(new Color(210, 180, 140));
		btnupdate.setBounds(21, 667, 106, 43);
		desktopproperty.add(btnupdate);
		
		JButton btndelete = new JButton("DELETE");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int yn=JOptionPane.showConfirmDialog(null,"Do you really want to delete this Property's Information permanently");
				if(yn==JOptionPane.YES_OPTION) {
					
					try {
						propertyDAO propertydao= new propertyDAO();
						String msg=propertydao.deleteproperty(pt.getPropertyid());
						JOptionPane.showMessageDialog(null,msg,"Finished Operation",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setVisible(false);
				new PropertyUI().setVisible(true);
			}
		});
		btndelete.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btndelete.setFocusPainted(false);
		btndelete.setBorderPainted(false);
		btndelete.setBackground(new Color(210, 180, 140));
		btndelete.setBounds(180, 667, 106, 43);
		desktopproperty.add(btndelete);
		
		JButton btnCancle = new JButton("CANCLE");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PropertyUI().setVisible(true);
			}
		});
		btnCancle.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnCancle.setFocusPainted(false);
		btnCancle.setBorderPainted(false);
		btnCancle.setBackground(new Color(210, 180, 140));
		btnCancle.setBounds(353, 667, 106, 43);
		desktopproperty.add(btnCancle);
		
		JLabel lbldate = new JLabel("UPDATE DATE");
		lbldate.setForeground(new Color(205, 133, 63));
		lbldate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lbldate.setBounds(30, 325, 108, 28);
		desktopproperty.add(lbldate);
		
		tfupdatedate = new JTextField(pt.getUpdate());
		tfupdatedate.setForeground(Color.BLACK);
		tfupdatedate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfupdatedate.setColumns(10);
		tfupdatedate.setBackground(new Color(205, 133, 63));
		tfupdatedate.setBounds(184, 321, 257, 38);
		desktopproperty.add(tfupdatedate);
		

		
	
	}
}
