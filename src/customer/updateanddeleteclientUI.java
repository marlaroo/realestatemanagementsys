package customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Owner.OwnerDAO;
import Owner.OwnerUI;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class updateanddeleteclientUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfclientname;
	private JTextField tfclientnrc;
	private JTextField tfclientphone;
	private JTextField tfclientemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateanddeleteclientUI frame = new updateanddeleteclientUI(null);
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
	public updateanddeleteclientUI(customer client) {
		setTitle("CLIENT INFORMATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 787);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 133, 63));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopproperty = new JDesktopPane();
		desktopproperty.setBackground(Color.BLACK);
		desktopproperty.setBounds(0, 0, 444, 750);
		contentPane.add(desktopproperty);
		
		JLabel lblclient = new JLabel("CLIENT INFORMATION");
		lblclient.setForeground(new Color(205, 133, 63));
		lblclient.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblclient.setBounds(62, 21, 239, 28);
		desktopproperty.add(lblclient);
		
		JLabel lblclientname = new JLabel("NAME");
		lblclientname.setForeground(new Color(205, 133, 63));
		lblclientname.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblclientname.setBounds(30, 97, 93, 28);
		desktopproperty.add(lblclientname);
		
		tfclientname = new JTextField(client.getCustomername());
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
		
		JTextArea taclientaddress = new JTextArea(client.getAddress());
		taclientaddress.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		taclientaddress.setBackground(new Color(205, 133, 63));
		taclientaddress.setBounds(155, 409, 223, 129);
		desktopproperty.add(taclientaddress);
		
		JLabel lblClientNRC = new JLabel("NRC");
		lblClientNRC.setForeground(new Color(205, 133, 63));
		lblClientNRC.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblClientNRC.setBounds(30, 171, 93, 28);
		desktopproperty.add(lblClientNRC);
		
		tfclientnrc = new JTextField(client.getCustomer_nrc());
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
		
		tfclientphone = new JTextField(client.getPhone());
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
		
		tfclientemail = new JTextField(client.getEmail());
		tfclientemail.setForeground(Color.BLACK);
		tfclientemail.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tfclientemail.setColumns(10);
		tfclientemail.setBackground(new Color(205, 133, 63));
		tfclientemail.setBounds(155, 319, 223, 38);
		desktopproperty.add(tfclientemail);
		
		JButton btnclientupdate = new JButton("UPDATE");
		btnclientupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tfclientname.getText().trim();
				String nrc=tfclientnrc.getText().trim();
				String phone=tfclientphone.getText().trim();
				String email=tfclientemail.getText().trim();
				String address=taclientaddress.getText();
				
				client.setCustomername(name);
				client.setCustomer_nrc(nrc);
				client.setPhone(phone);
				client.setEmail(email);
				client.setAddress(address);
				
				int yn=JOptionPane.showConfirmDialog(null,"Do you really want to update Client information permaniely");
				if(yn==JOptionPane.YES_OPTION) {
					customerDAO clientdao=new customerDAO();
					try {
						String msg=clientdao.updatecustomer(client);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setVisible(false);
				new ClientUI().setVisible(true);
				
			}
		});
		btnclientupdate.setBounds(30, 601, 148, 43);
		desktopproperty.add(btnclientupdate);
		btnclientupdate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnclientupdate.setFocusPainted(false);
		btnclientupdate.setBorderPainted(false);
		btnclientupdate.setBackground(new Color(210, 180, 140));
		
		JButton btnclientdelete = new JButton("DELETE");
		btnclientdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int yn=JOptionPane.showConfirmDialog(null,"Do you really want to delete this Owner's Information permanently");
				if(yn==JOptionPane.YES_OPTION) {
					customerDAO clientdao= new customerDAO();
					try {
						String msg=clientdao.deletecustomer(client.getCustomerid());
						JOptionPane.showMessageDialog(null,msg,"Finished Operation",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
				}
				setVisible(false);
				new ClientUI().setVisible(true);
				}
			}
		});
		btnclientdelete.setBounds(262, 601, 148, 43);
		desktopproperty.add(btnclientdelete);
		btnclientdelete.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnclientdelete.setFocusPainted(false);
		btnclientdelete.setBackground(new Color(210, 180, 140));
		
		JButton btnclientcalcel = new JButton("CANCLE");
		btnclientcalcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientUI().setVisible(true);
			}
		});
		btnclientcalcel.setBounds(10, 681, 430, 43);
		desktopproperty.add(btnclientcalcel);
		btnclientcalcel.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnclientcalcel.setFocusPainted(false);
		btnclientcalcel.setBorderPainted(false);
		btnclientcalcel.setBackground(new Color(210, 180, 140));
	}

}
