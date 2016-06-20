import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class DisplayUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;
	private JTextField txtpass;
	private JButton btnLogin;
	private JLabel lblRole;
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnDirector;
	private ButtonGroup group;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayUser frame = new DisplayUser(null);
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
	public DisplayUser(final String[] args) {
		setTitle("Add New User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 480);
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
		
		
		txtpass = new JTextField();
		txtpass.setBounds(183, 108, 122, 20);
		contentPane.add(txtpass);
		
		btnLogin = new JButton("Add User");
		btnLogin.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				
				String textuser = txtuser.getText();
				String textpass = txtpass.getText().toString();					
				String foundRole = null;
				
				for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
		            AbstractButton button = buttons.nextElement();

		            if (button.isSelected()) {
		                foundRole = button.getText();
		            }
		        }
				try {
					String entry = "\r\n"+textuser+","+textpass;
					if("Admin".equalsIgnoreCase(foundRole)){
						entry = entry+",A";
					}else if("Director".equalsIgnoreCase(foundRole)){
						entry = entry+",D";
					}else{
						JFrame parent1 = new JFrame();
				        JOptionPane.showMessageDialog(parent1,"Role not selected. Please try again.");
				        
				        new Home(args).setVisible(true);
						new Home(args);
						setVisible(false);
					}
					
				    Files.write(Paths.get("username.csv"), entry.getBytes(), StandardOpenOption.APPEND);
				    
				}catch (IOException e) {
				    e.printStackTrace();
				}
				
				JFrame parent = new JFrame();
		        JOptionPane.showMessageDialog(parent,"User added Successfuly.");
		        
		        new Home(args).setVisible(true);
				new Home(args);
				setVisible(false);
					
			}
		});
		btnLogin.setToolTipText("");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBounds(157, 175, 88, 22);
		contentPane.add(btnLogin);
		
		lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblRole.setBounds(79, 138, 64, 26);
		contentPane.add(lblRole);
		
		rdbtnAdmin = new JRadioButton("Admin");
		rdbtnDirector = new JRadioButton("Director");
		rdbtnAdmin.setBounds(183, 135, 100, 33);
		contentPane.add(rdbtnAdmin);
		
		rdbtnDirector.setBounds(285, 135, 109, 33);
		contentPane.add(rdbtnDirector);
		setVisible(false);
		
		group = new ButtonGroup();
		group.add(rdbtnAdmin);
		group.add(rdbtnDirector);
		
	}
}
