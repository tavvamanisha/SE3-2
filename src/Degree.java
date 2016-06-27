

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Degree extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblDepartment;
	private JTextField textField_2;
	private JLabel lblHoursRequired;
	private JTextField textField_4;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	
	private String degreeCode;
	private String gradSchool;
	private String degreeName;
	private String forecast;
	
	
		public String getDegreeCode() {
		return degreeCode;
	}

	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}

	public String getGradSchool() {
		return gradSchool;
	}

	public void setGradSchool(String gradSchool) {
		this.gradSchool = gradSchool;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	
	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Degree frame = new Degree();
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
	public Degree() {
		setTitle("Degree Plan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDegreeName = new JLabel("Degree Code");
		lblDegreeName.setBounds(21, 11, 79, 14);
		contentPane.add(lblDegreeName);
		
		textField = new JTextField();
		textField.setBounds(103, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblDepartment = new JLabel("Description");
		lblDepartment.setBounds(228, 14, 79, 14);
		contentPane.add(lblDepartment);
		
		textField_2 = new JTextField();
		textField_2.setBounds(310, 11, 149, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblHoursRequired = new JLabel("Hours Required");
		lblHoursRequired.setBounds(217, 50, 79, 14);
		contentPane.add(lblHoursRequired);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(310, 47, 149, 20);
		contentPane.add(textField_4);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBounds(42, 257, 89, 23);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(170, 257, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(292, 257, 89, 23);
		contentPane.add(btnDelete);
	}

}
