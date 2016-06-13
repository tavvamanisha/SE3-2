

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
	private JTextField textField_1;
	private JLabel lblDepartment;
	private JTextField textField_2;
	private JLabel lblTrack;
	private JTextField textField_3;
	private JLabel lblHoursRequired;
	private JTextField textField_4;
	private JLabel lblElective;
	private JLabel lblMandatory;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_4;
	private JCheckBox checkBox_5;
	private JLabel lblCourse;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;

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
		setBounds(100, 100, 450, 330);
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
		
		JLabel lblDegreeName_1 = new JLabel("Degree Name");
		lblDegreeName_1.setBounds(217, 11, 79, 14);
		contentPane.add(lblDegreeName_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(303, 8, 121, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(21, 92, 79, 14);
		contentPane.add(lblDepartment);
		
		textField_2 = new JTextField();
		textField_2.setBounds(103, 89, 212, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblTrack = new JLabel("Track");
		lblTrack.setBounds(21, 50, 46, 14);
		contentPane.add(lblTrack);
		
		textField_3 = new JTextField();
		textField_3.setBounds(103, 47, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblHoursRequired = new JLabel("Hours Required");
		lblHoursRequired.setBounds(217, 50, 79, 14);
		contentPane.add(lblHoursRequired);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(303, 47, 121, 20);
		contentPane.add(textField_4);
		
		lblElective = new JLabel("Elective");
		lblElective.setBounds(21, 127, 46, 14);
		contentPane.add(lblElective);
		
		lblMandatory = new JLabel("Mandatory");
		lblMandatory.setBounds(89, 127, 61, 14);
		contentPane.add(lblMandatory);
		
		checkBox = new JCheckBox("");
		checkBox.setBounds(31, 148, 21, 23);
		contentPane.add(checkBox);
		
		checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(99, 148, 21, 23);
		contentPane.add(checkBox_1);
		
		checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(31, 180, 21, 23);
		contentPane.add(checkBox_2);
		
		checkBox_3 = new JCheckBox("");
		checkBox_3.setBounds(99, 180, 21, 23);
		contentPane.add(checkBox_3);
		
		checkBox_4 = new JCheckBox("");
		checkBox_4.setBounds(31, 214, 21, 23);
		contentPane.add(checkBox_4);
		
		checkBox_5 = new JCheckBox("");
		checkBox_5.setBounds(99, 214, 21, 23);
		contentPane.add(checkBox_5);
		
		lblCourse = new JLabel("Course");
		lblCourse.setBounds(170, 127, 46, 14);
		contentPane.add(lblCourse);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Course 1", "Course 2", "Course 3"}));
		comboBox.setBounds(170, 151, 100, 20);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(170, 183, 100, 20);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(170, 214, 100, 20);
		contentPane.add(comboBox_2);
		
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
