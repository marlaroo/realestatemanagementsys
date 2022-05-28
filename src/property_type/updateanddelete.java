package property_type;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class updateanddelete extends JFrame {

	private JPanel contentPane;
	private JTextField tftypename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateanddelete frame = new updateanddelete(null);
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
	public updateanddelete(property_type type) {
		setTitle("TYPE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 133, 63));
		panel.setBounds(0, 0, 447, 637);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblproperytypetitle = new JLabel("PROPERTY TYPE");
		lblproperytypetitle.setForeground(new Color(0, 0, 0));
		lblproperytypetitle.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		lblproperytypetitle.setBounds(10, 28, 209, 28);
		panel.add(lblproperytypetitle);
		
		JLabel lbltype = new JLabel("NAME");
		lbltype.setForeground(new Color(0, 0, 0));
		lbltype.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lbltype.setBounds(34, 123, 94, 28);
		panel.add(lbltype);
		
		tftypename = new JTextField(type.getName());
		tftypename.setForeground(new Color(205, 133, 63));
		tftypename.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tftypename.setColumns(10);
		tftypename.setBackground(new Color(0, 0, 0));
		tftypename.setBounds(158, 119, 251, 38);
		panel.add(tftypename);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setForeground(new Color(0, 0, 0));
		lblDescription.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblDescription.setBounds(34, 239, 108, 28);
		panel.add(lblDescription);
		
		JTextArea tatypedescription = new JTextArea(type.getDescription());
		tatypedescription.setForeground(new Color(205, 133, 63));
		tatypedescription.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		tatypedescription.setBackground(new Color(0, 0, 0));
		tatypedescription.setBounds(158, 241, 248, 188);
		panel.add(tatypedescription);
		
		JButton btnCancle = new JButton("CALCLE");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new typeUI().setVisible(true);
			}
		});
		btnCancle.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnCancle.setFocusPainted(false);
		btnCancle.setBorderPainted(false);
		btnCancle.setBackground(new Color(210, 180, 140));
		btnCancle.setBounds(316, 584, 106, 43);
		panel.add(btnCancle);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int yn=JOptionPane.showConfirmDialog(null,"Do you really want to delete this Type's Information permanently");
				if(yn==JOptionPane.YES_OPTION) {
					typeDAO typedao= new typeDAO();
					try {
						String msg=typedao.deletetype(type.getTypeid());
						JOptionPane.showMessageDialog(null,msg,"Finished Operation",JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setVisible(false);
				new typeUI().setVisible(true);
			}
			
		});
		btnDelete.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnDelete.setFocusPainted(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(210, 180, 140));
		btnDelete.setBounds(23, 522, 399, 43);
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tftypename.getText().trim();
				String description=tatypedescription.getText();
				type.setName(name);
				type.setDescription(description);
				int yn=JOptionPane.showConfirmDialog(null,"Do you really want to update type information permaniely");
				if(yn==JOptionPane.YES_OPTION) {
					typeDAO typedao=new typeDAO();
					try {
						String msg=typedao.updatetype(type);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setVisible(false);
				new typeUI().setVisible(true);
				

			}
		});
		btnUpdate.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(new Color(210, 180, 140));
		btnUpdate.setBounds(23, 457, 399, 43);
		panel.add(btnUpdate);
	}
}
