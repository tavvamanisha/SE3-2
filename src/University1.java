import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class University1 extends JFrame {

	private JPanel contentPane;
	private University univ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					University1 frame = new University1(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private String universityName;
	private String universityAbb;
	private JTextField txtuniname;
	private JTextField txtuniabb;
	
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getUniversityAbb() {
		return universityAbb;
	}
	public void setUniversityAbb(String universityAbb) {
		this.universityAbb = universityAbb;
	}
	
	
	 
	/**
	 * Create the frame.
	 */
	public University1(University university, final String[] args){
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		univ = university;
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUniname = new JLabel("University Name");
		lblUniname.setBounds(52, 38, 424, 14);
		contentPane.add(lblUniname);
		
		JLabel lblNewLabel = new JLabel("Abbrevation");
		lblNewLabel.setBounds(52, 76, 92, 14);
		contentPane.add(lblNewLabel);
		
		txtuniname = new JTextField();
		txtuniname.setBounds(168, 35, 236, 20);
		contentPane.add(txtuniname);
		txtuniname.setColumns(10);
		
		txtuniabb = new JTextField();
		txtuniabb.setBounds(168, 73, 86, 20);
		contentPane.add(txtuniabb);
		txtuniabb.setColumns(10);
		
		txtuniname.setText(university.getUniversityName());
		txtuniabb.setText(university.getUniversityAbb());
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				universityName = txtuniname.getText().toString();
				universityAbb = txtuniabb.getText().toString();
				univ.setUniversityName(universityName);
				univ.setUniversityAbb(universityAbb);
				
				args[0]="0";
				new Home(args).setVisible(true);
				new Home(args).setUniv(univ);
				new Home(args);
				dispose();
				
			}
		});
		btnSubmit.setBounds(168, 122, 89, 23);
		contentPane.add(btnSubmit);		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				args[0]="0";
				new Home(args).setVisible(true);
				new Home(args);
				dispose();
				
			}
		});
		btnBack.setBounds(10, 4, 89, 23);
		contentPane.add(btnBack);


	

	}
}
