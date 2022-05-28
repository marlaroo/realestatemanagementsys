package buy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rent.RentUI;
import rent.rentDAO;

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

public class buyupdateanddeleteUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfsalepropertyname;
	private JTextField tfsalecustomername;
	private JTextField tfsaleprice;
	private JTextField tfsaledate;
	private JTextField tfsaleownername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buyupdateanddeleteUI frame = new buyupdateanddeleteUI(null);
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
	public buyupdateanddeleteUI(buy b1) {
		setTitle("BUY INFORMATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 715);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 133, 63));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopsale = new JDesktopPane();
		desktopsale.setBackground(Color.BLACK);
		desktopsale.setBounds(0, 0, 439, 678);
		contentPane.add(desktopsale);
		
		JLabel saleinformationtitle = new JLabel("SALE INFORMATION");
		saleinformationtitle.setForeground(new Color(205, 133, 63));
		saleinformationtitle.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		saleinformationtitle.setBounds(10, 17, 258, 28);
		desktopsale.add(saleinformationtitle);
		
		JLabel lblsalepropertyname = new JLabel("PROPERTY");
		lblsalepropertyname.setForeground(new Color(205, 133, 63));
		lblsalepropertyname.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsalepropertyname.setBounds(39, 134, 111, 28);
		desktopsale.add(lblsalepropertyname);
		
		tfsalepropertyname = new JTextField(b1.getProperty_name());
		tfsalepropertyname.setForeground(Color.BLACK);
		tfsalepropertyname.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsalepropertyname.setColumns(10);
		tfsalepropertyname.setBackground(new Color(205, 133, 63));
		tfsalepropertyname.setBounds(192, 130, 218, 38);
		desktopsale.add(tfsalepropertyname);
		
		JLabel lblsalecustomername = new JLabel("CUSTOMER");
		lblsalecustomername.setForeground(new Color(205, 133, 63));
		lblsalecustomername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsalecustomername.setBounds(39, 225, 111, 28);
		desktopsale.add(lblsalecustomername);
		
		tfsalecustomername = new JTextField(b1.getCustomer_name());
		tfsalecustomername.setForeground(Color.BLACK);
		tfsalecustomername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsalecustomername.setColumns(10);
		tfsalecustomername.setBackground(new Color(205, 133, 63));
		tfsalecustomername.setBounds(192, 221, 224, 38);
		desktopsale.add(tfsalecustomername);
		
		JLabel lblsalePrice = new JLabel("PRICE");
		lblsalePrice.setForeground(new Color(205, 133, 63));
		lblsalePrice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsalePrice.setBounds(39, 305, 111, 28);
		desktopsale.add(lblsalePrice);
		
		tfsaleprice = new JTextField(String.valueOf(b1.getPrice()));
		tfsaleprice.setForeground(Color.BLACK);
		tfsaleprice.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsaleprice.setColumns(10);
		tfsaleprice.setBackground(new Color(205, 133, 63));
		tfsaleprice.setBounds(192, 301, 224, 38);
		desktopsale.add(tfsaleprice);
		
		JLabel lblsaledate = new JLabel("DATE");
		lblsaledate.setForeground(new Color(205, 133, 63));
		lblsaledate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsaledate.setBounds(39, 384, 111, 28);
		desktopsale.add(lblsaledate);
		
		tfsaledate = new JTextField(b1.getDate());
		tfsaledate.setForeground(Color.BLACK);
		tfsaledate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsaledate.setColumns(10);
		tfsaledate.setBackground(new Color(205, 133, 63));
		tfsaledate.setBounds(186, 380, 224, 38);
		desktopsale.add(tfsaledate);
		
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int price=Integer.parseInt(tfsaleprice.getText().trim());
				String saledate=tfsaledate.getText().trim();

				b1.setPrice(price);
				b1.setDate(saledate);
			
				
				int yn=JOptionPane.showConfirmDialog(null,"Do you really want to update Buy information permaniely");
				if(yn==JOptionPane.YES_OPTION) {
					
					try {
						buyDAO buydao=new buyDAO();
						String msg=buydao.updatebuy(b1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
	
				setVisible(false);
				new buyUI().setVisible(true);
			}
		});
		btnUpdate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(new Color(210, 180, 140));
		btnUpdate.setBounds(21, 477, 129, 43);
		desktopsale.add(btnUpdate);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnCancel.setFocusPainted(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setBackground(new Color(210, 180, 140));
		btnCancel.setBounds(0, 582, 439, 43);
		desktopsale.add(btnCancel);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int yn=JOptionPane.showConfirmDialog(null,"Do you really want to delete this Buy's Information permanently");
				if(yn==JOptionPane.YES_OPTION) {
					
					try {
						buyDAO buydao= new buyDAO();
						String msg=buydao.deletebuy(b1.getBuyid());
						JOptionPane.showMessageDialog(null,msg,"Finished Operation",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setVisible(false);
				new buyUI().setVisible(true);
			}
		});
		btnDelete.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnDelete.setFocusPainted(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(210, 180, 140));
		btnDelete.setBounds(273, 477, 137, 43);
		desktopsale.add(btnDelete);
		
		JLabel lblsaleownername = new JLabel("OWNER");
		lblsaleownername.setForeground(new Color(205, 133, 63));
		lblsaleownername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblsaleownername.setBounds(39, 68, 111, 28);
		desktopsale.add(lblsaleownername);
		
		tfsaleownername = new JTextField(b1.getOwner_name());
		tfsaleownername.setForeground(Color.BLACK);
		tfsaleownername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfsaleownername.setColumns(10);
		tfsaleownername.setBackground(new Color(205, 133, 63));
		tfsaleownername.setBounds(192, 55, 221, 38);
		desktopsale.add(tfsaleownername);
		
		
		
	}
}
