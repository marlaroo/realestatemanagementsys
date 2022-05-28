package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JPasswordField psw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setBackground(new Color(205, 133, 63));
		setForeground(Color.ORANGE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/img/finallogoend.jpg")));
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
		panel.setBackground(new Color(205, 133, 63));
		panel.setBounds(655, 0, 473, 768);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 0, 457, 768);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(205, 133, 63));
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/img/finallogoend.jpg")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(205, 133, 63));
		panel_1.setForeground(new Color(224, 255, 255));
		panel_1.setBounds(0, 0, 657, 731);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("REAL ESTATE MANAGEMENT SYSTEM");
		lblNewLabel_1.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(151, 46, 359, 63);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Showcard Gothic", Font.BOLD, 30));
		lblNewLabel_2.setBounds(253, 119, 117, 63);
		panel_1.add(lblNewLabel_2);
		
		JLabel username = new JLabel("USERNAME");
		username.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		username.setBackground(new Color(205, 133, 63));
		username.setIcon(new ImageIcon(login.class.getResource("/img/gold user 1.jpg")));
		username.setBounds(125, 295, 117, 35);
		panel_1.add(username);
		
		JLabel login = new JLabel("PASSWORD");
		login.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		login.setIcon(new ImageIcon(login.class.getResource("/img/goldlogin 1.jpg")));
		login.setBackground(new Color(205, 133, 63));
		login.setBounds(125, 374, 124, 35);
		panel_1.add(login);
		
		JTextPane usertext = new JTextPane();
		usertext.setFont(new Font("Source Code Pro", Font.BOLD, 17));
		usertext.setBounds(252, 295, 258, 35);
		panel_1.add(usertext);
		psw = new JPasswordField();
		psw.setEchoChar('*');
		psw.setFont(new Font("SimSun", Font.PLAIN, 18));
		psw.setBounds(253, 374, 257, 35);
		panel_1.add(psw);
		
		JButton btnlogin = new JButton("");
		btnlogin.setBorderPainted(false);
		btnlogin.setContentAreaFilled(false);
		btnlogin.setForeground(new Color(205, 133, 63));
		btnlogin.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 23));
		btnlogin.setHorizontalAlignment(SwingConstants.TRAILING);
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=usertext.getText();
				String Password=psw.getText();
				if(Username.equals("marlar")&& Password.equals("812812mm")) {
				setVisible(false);
				Home h=new Home();
				h.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"USER NAME OR PASSWORD MISMATCH");
					usertext.setText("");
					psw.setText("");
				}
			}
		});
		btnlogin.setIcon(new ImageIcon(login.class.getResource("/img/login-removebg-preview.png")));
		btnlogin.setBackground(new Color(205, 133, 63));
		btnlogin.setBounds(372, 511, 252, 114);
		panel_1.add(btnlogin);
		
		JButton btnclose = new JButton("");
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnclose.setIcon(new ImageIcon(login.class.getResource("/img/closeforlogin.png")));
		btnclose.setHorizontalAlignment(SwingConstants.TRAILING);
		btnclose.setForeground(new Color(205, 133, 63));
		btnclose.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 23));
		btnclose.setContentAreaFilled(false);
		btnclose.setBorderPainted(false);
		btnclose.setBackground(new Color(205, 133, 63));
		btnclose.setBounds(72, 511, 187, 114);
		panel_1.add(btnclose);
		
	
	}
}
