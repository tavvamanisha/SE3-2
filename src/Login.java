import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1793482340514305910L;
	private JPanel contentPane;
	private JTextField txtuser;
	private JPasswordField txtpass;
	private JButton btnLogin;
	public String[] username;
	public String[] password;
	public String[] role;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginId = new JLabel("Username");
		lblLoginId.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLoginId.setLabelFor(lblLoginId);
		lblLoginId.setBounds(79, 71, 64, 14);
		contentPane.add(lblLoginId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPassword.setBounds(79, 105, 64, 14);
		contentPane.add(lblPassword);
		
		txtuser = new JTextField();
		txtuser.setBounds(183, 71, 122, 20);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		
		txtpass = new JPasswordField();
		txtpass.setBounds(183, 108, 122, 20);
		contentPane.add(txtpass);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
		
	
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setToolTipText("");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBounds(157, 175, 69, 22);
		contentPane.add(btnLogin);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDelete.setBounds(236, 175, 69, 22);
		contentPane.add(btnDelete);
	}
}
