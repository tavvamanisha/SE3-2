import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class Faculty extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Faculty frame = new Faculty();
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
	public Faculty() {
		setTitle("Faculty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnMr = new JRadioButton("MR.");
		rdbtnMr.setBounds(32, 18, 109, 23);
		contentPane.add(rdbtnMr);
		
		JRadioButton rdbtnMrs = new JRadioButton("MRS.");
		rdbtnMrs.setBounds(156, 18, 109, 23);
		contentPane.add(rdbtnMrs);
		
		JLabel lblFacultyName = new JLabel("Faculty Name");
		lblFacultyName.setBounds(32, 53, 85, 14);
		contentPane.add(lblFacultyName);
		
		JLabel lblNewLabel = new JLabel("Course");
		lblNewLabel.setBounds(32, 90, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(113, 50, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 87, 286, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMaxLoad = new JLabel("Max Load");
		lblMaxLoad.setBounds(277, 53, 46, 14);
		contentPane.add(lblMaxLoad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox.setBounds(333, 50, 66, 20);
		contentPane.add(comboBox);
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setBounds(32, 127, 46, 14);
		contentPane.add(lblDays);
		
		JCheckBox chckbxMonady = new JCheckBox("Mon");
		chckbxMonady.setBounds(113, 123, 46, 23);
		contentPane.add(chckbxMonady);
		
		JCheckBox chckbxTue = new JCheckBox("Tue");
		chckbxTue.setBounds(161, 123, 46, 23);
		contentPane.add(chckbxTue);
		
		JCheckBox chckbxWed = new JCheckBox("Wed");
		chckbxWed.setBounds(210, 123, 55, 23);
		contentPane.add(chckbxWed);
		
		JCheckBox chckbxThur = new JCheckBox("Thur");
		chckbxThur.setBounds(264, 123, 59, 23);
		contentPane.add(chckbxThur);
		
		JCheckBox chckbxFri = new JCheckBox("Fri");
		chckbxFri.setBounds(325, 123, 46, 23);
		contentPane.add(chckbxFri);
		
		JButton button = new JButton("ADD");
		button.setBounds(56, 176, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("UPDATE");
		button_1.setBounds(172, 176, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("DELETE");
		button_2.setBounds(282, 176, 89, 23);
		contentPane.add(button_2);
	}
}
