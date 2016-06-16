

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.naming.ldap.Rdn;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUser extends JFrame {

	private JPanel contentPane;
	private JLabel lblConfirmPassword;
	private JLabel lblUsername;
	private JTextField textuser;
	private JPasswordField textpass;
	private JPasswordField textconpass;
	private JButton btnSave;
	private JButton btnCancel;
	public String username;
	public String password;
	public String role;
	public String confpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
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
	public AddUser() {
		
		setTitle("Add User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(36, 58, 83, 14);
		contentPane.add(lblPassword);
		
		lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(36, 93, 117, 14);
		contentPane.add(lblConfirmPassword);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(36, 26, 69, 14);
		contentPane.add(lblUsername);
		
		textuser = new JTextField();
		textuser.setBounds(204, 26, 148, 20);
		contentPane.add(textuser);
		textuser.setColumns(10);
		
		textpass = new JPasswordField();
		textpass.setBounds(204, 58, 148, 20);
		contentPane.add(textpass);
		
		textconpass = new JPasswordField();
		textconpass.setBounds(204, 93, 148, 20);
		contentPane.add(textconpass);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(36, 128, 83, 14);
		contentPane.add(lblRole);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBounds(296, 124, 109, 23);
		contentPane.add(rdbtnAdmin);
		
		final JRadioButton rdbtnDirector = new JRadioButton("Director");
		rdbtnDirector.setBounds(182, 124, 109, 23);
		contentPane.add(rdbtnDirector);
		
		btnSave = new JButton("Save");
		
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
					username= textuser.getText();
					System.out.println(username);
					password= textpass.getPassword().toString();
					System.out.println(password);
					confpassword=textconpass.getPassword().toString();
					System.out.println(confpassword);
					 if(rdbtnDirector.isSelected())
				        {
				            role = "D";
				            
				        }else{
				        	role="A";
				        }	
					 System.out.println(role);
					 
		}
	}
		
		);
		
		btnSave.setBounds(100, 176, 89, 23);
		contentPane.add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(245, 176, 89, 23);
		contentPane.add(btnCancel);
		
		
		
		
	
}
}
