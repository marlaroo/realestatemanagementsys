package Owner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import property_type.typeDAO;
import property_type.typeUI;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class updateanddeleteUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfownername;
	private JTextField tfownernrc;
	private JTextField tfownerphone;
	private JTextField tfowneremail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateanddeleteUI frame = new updateanddeleteUI(null);
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
	public updateanddeleteUI(owner owner) {
		setTitle("OWNER INFORMATION");
		setIconImage(Toolkit.getDefaultToolkit().getImage(updateanddeleteUI.class.getResource("/img/owner_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopproperty = new JDesktopPane();
		desktopproperty.setBackground(new Color(205, 133, 63));
		desktopproperty.setBounds(0, 0, 488, 742);
		contentPane.add(desktopproperty);
		
		JLabel lblproperty = new JLabel("OWNER INFORMATION");
		lblproperty.setForeground(new Color(0, 0, 0));
		lblproperty.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblproperty.setBounds(34, 22, 239, 28);
		desktopproperty.add(lblproperty);
		
		JLabel lblOwnername = new JLabel("NAME");
		lblOwnername.setForeground(new Color(0, 0, 0));
		lblOwnername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblOwnername.setBounds(30, 97, 93, 28);
		desktopproperty.add(lblOwnername);
		
		tfownername = new JTextField(owner.getOwnername());
		tfownername.setForeground(new Color(205, 133, 63));
		tfownername.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfownername.setColumns(10);
		tfownername.setBackground(new Color(0, 0, 0));
		tfownername.setBounds(155, 93, 223, 38);
		desktopproperty.add(tfownername);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(0, 0, 0));
		lblAddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblAddress.setBounds(30, 419, 108, 28);
		desktopproperty.add(lblAddress);
		
		JTextArea textowneraddress = new JTextArea(owner.getAddress());
		textowneraddress.setForeground(new Color(205, 133, 63));
		textowneraddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		textowneraddress.setBackground(new Color(0, 0, 0));
		textowneraddress.setBounds(155, 419, 223, 129);
		desktopproperty.add(textowneraddress);
		
		JLabel lblNRC = new JLabel("NRC");
		lblNRC.setForeground(new Color(0, 0, 0));
		lblNRC.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNRC.setBounds(30, 171, 93, 28);
		desktopproperty.add(lblNRC);
		
		tfownernrc = new JTextField(owner.getOwner_nrc());
		tfownernrc.setForeground(new Color(205, 133, 63));
		tfownernrc.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfownernrc.setColumns(10);
		tfownernrc.setBackground(new Color(0, 0, 0));
		tfownernrc.setBounds(155, 167, 223, 38);
		desktopproperty.add(tfownernrc);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setForeground(new Color(0, 0, 0));
		lblPhone.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblPhone.setBounds(30, 241, 93, 28);
		desktopproperty.add(lblPhone);
		
		tfownerphone = new JTextField(owner.getPhone());
		tfownerphone.setForeground(new Color(205, 133, 63));
		tfownerphone.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfownerphone.setColumns(10);
		tfownerphone.setBackground(new Color(0, 0, 0));
		tfownerphone.setBounds(155, 237, 223, 38);
		desktopproperty.add(tfownerphone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblEmail.setBounds(30, 323, 93, 28);
		desktopproperty.add(lblEmail);
		
		tfowneremail = new JTextField(owner.getEmail());
		tfowneremail.setForeground(new Color(205, 133, 63));
		tfowneremail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfowneremail.setColumns(10);
		tfowneremail.setBackground(new Color(0, 0, 0));
		tfowneremail.setBounds(155, 319, 223, 38);
		desktopproperty.add(tfowneremail);
		
		JButton btnownerUpdate = new JButton("UPDATE");
		btnownerUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tfownername.getText().trim();
				String nrc=tfownernrc.getText().trim();
				String phone=tfownerphone.getText().trim();
				String email=tfowneremail.getText().trim();
				String address=textowneraddress.getText();
				owner.setOwnername(name);
				owner.setOwner_nrc(nrc);
				owner.setPhone(phone);
				owner.setEmail(email);
				owner.setAddress(address);
				int yn=JOptionPane.showConfirmDialog(null,"Do you really want to update owner information permaniely");
				if(yn==JOptionPane.YES_OPTION) {
					OwnerDAO ownerdao=new OwnerDAO();
					try {
						String msg=ownerdao.updateowner(owner);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setVisible(false);
				new OwnerUI().setVisible(true);
			}
		});
		btnownerUpdate.setForeground(new Color(0, 0, 0));
		btnownerUpdate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnownerUpdate.setFocusPainted(false);
		btnownerUpdate.setBackground(new Color(210, 180, 140));
		btnownerUpdate.setBounds(10, 628, 106, 43);
		desktopproperty.add(btnownerUpdate);
		
		JButton btnownerDelete = new JButton("DELETE");
		btnownerDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int yn=JOptionPane.showConfirmDialog(null,"Do you really want to delete this Owner's Information permanently");
				if(yn==JOptionPane.YES_OPTION) {
					OwnerDAO ownerdao= new OwnerDAO();
					try {
						String msg=ownerdao.deleteowner(owner.getOwnerid());
						JOptionPane.showMessageDialog(null,msg,"Finished Operation",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setVisible(false);
				new OwnerUI().setVisible(true);
			}
		});
		btnownerDelete.setForeground(new Color(0, 0, 0));
		btnownerDelete.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnownerDelete.setFocusPainted(false);
		btnownerDelete.setBorderPainted(false);
		btnownerDelete.setBackground(new Color(210, 180, 140));
		btnownerDelete.setBounds(179, 628, 106, 43);
		desktopproperty.add(btnownerDelete);
		
		JButton btnownercancle = new JButton("CANCLE");
		btnownercancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new OwnerUI().setVisible(true);
			}
		});
		btnownercancle.setForeground(new Color(0, 0, 0));
		btnownercancle.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnownercancle.setFocusPainted(false);
		btnownercancle.setBorderPainted(false);
		btnownercancle.setBackground(new Color(210, 180, 140));
		btnownercancle.setBounds(365, 628, 106, 43);
		desktopproperty.add(btnownercancle);
	}
}
