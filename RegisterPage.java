package loginPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField city;
	private JTextField mail;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 446);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Here");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 32, 589, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(39, 105, 124, 20);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(173, 105, 314, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("City");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(39, 148, 124, 20);
		contentPane.add(lblNewLabel_2);
		
		city = new JTextField();
		city.setBounds(173, 148, 314, 20);
		contentPane.add(city);
		city.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(40, 192, 123, 20);
		contentPane.add(lblNewLabel_3);
		
		mail = new JTextField();
		mail.setBounds(173, 192, 314, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JLabel variablex = new JLabel("Password");
		variablex.setHorizontalAlignment(SwingConstants.RIGHT);
		variablex.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		variablex.setBounds(39, 231, 123, 20);
		contentPane.add(variablex);
		
		pass = new JTextField();
		pass.setBounds(173, 231, 314, 20);
		contentPane.add(pass);
		pass.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login_form","root","");
					
					String s = "insert into register(name , city, email, password) Values(?,?,?,?)";
					
					PreparedStatement ps = conn.prepareStatement(s);
					
					String n = name.getText();
					String c = city.getText();
					String m = mail.getText();
					String p = pass.getText();
					
					ps.setString(1, n);
					ps.setString(2, c);
					ps.setString(3, m);
					ps.setString(4, p);
					
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Registered Successfully");
					conn.close();
				}
				catch(Exception x) {
					x.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(239, 287, 134, 33);
		contentPane.add(btnNewButton);
	}

}
