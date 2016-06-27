import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
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
	private String Username;
	private String Password;
	private String Role;
	static int length;
	
	private JButton btnLogin;
	static Login[] user;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					BufferedReader br = new BufferedReader(new FileReader("username.csv"));
		            
			           String line;
			           int maxLength=0;
			            while ((line = br.readLine()) != null) 
			            {
			                maxLength++;
			            }
			            
			            BufferedReader br1= new BufferedReader( new FileReader("username.csv"));
			            String csvFile = "username.csv";
			            length = maxLength;
			            int lineNumber=0;
			            user = new Login[maxLength];
			           
			            
			            for(int i =0; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
			            
			            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
			            	
			            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
			                Login log = new Login(); // Defining a new Login object inside the for loop. 
			                
			                log.setUsername(cols[0]);
			                log.setPassword(cols[1]);
			                log.setRole(cols[2]);
			                
			                user[i] = log; 
			                
			            }
			            
			            for (int j=0;j<maxLength;j++){
			            	System.out.println(user[j].getUsername() + " " + 
				            user[j].getPassword()+" "+ user[j].getRole());
			            	
			            }
			        
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public String getUsername() {
		return Username;
	}



	public void setUsername(String username) {
		Username = username;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}



	public String getRole() {
		return Role;
	}



	public void setRole(String role) {
		Role = role;
	}



	/**
	 * Create the frame.
	 */
	public Login() {
		
		
		setTitle("Login");
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
		
		
		txtpass = new JPasswordField();
		txtpass.setBounds(183, 108, 122, 20);
		contentPane.add(txtpass);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
		
	
			public void actionPerformed(ActionEvent arg0) {
				
				String textuser = txtuser.getText();
				String textpass = txtpass.getText().toString();					
				String foundRole = null;
				
				for(int i=0;i<length;i++){					
					
					if(textuser.equalsIgnoreCase(user[i].getUsername())){
						if(textpass.equalsIgnoreCase(user[i].getPassword())){
							foundRole = user[i].getRole();
						}
					}
				}
				if(foundRole!= null){			
					if(foundRole.equalsIgnoreCase("A"))
					{
						String[] str = new String[2];
						str[0] = "1";
						str[1] = "A";
						new Home(str).setVisible(true);
						new Home(str);
						setVisible(false);
						
					}
					else if(foundRole.equalsIgnoreCase("D")){
						
						String[] str = new String[2];
						str[0] = "1";
						str[1] = "D";
						new Home(str).setVisible(true);
						new Home(str);
						setVisible(false);
					}
				}else{
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Username or Password incorrect");
				}
			}
		});
		btnLogin.setToolTipText("");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBounds(157, 175, 88, 22);
		contentPane.add(btnLogin);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDelete.setBounds(255, 175, 81, 22);
		contentPane.add(btnDelete);
		setVisible(false);		
	}
}
