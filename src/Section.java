import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Section extends JFrame {

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
					Section frame = new Section();
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
	public Section() {
		setTitle("Section");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setBounds(127, 40, 46, 14);
		contentPane.add(lblSection);
		
		textField = new JTextField();
		textField.setBounds(194, 37, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCouse = new JLabel("Couse");
		lblCouse.setBounds(127, 70, 46, 14);
		contentPane.add(lblCouse);
		
		JLabel lblNewLabel = new JLabel("Faculty");
		lblNewLabel.setBounds(127, 100, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Course", "", ""}));
		comboBox.setBounds(194, 67, 122, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Item"}));
		comboBox_1.setBounds(194, 97, 122, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Semester");
		lblNewLabel_1.setBounds(127, 130, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 127, 122, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("ADD");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBounds(98, 171, 65, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(194, 171, 74, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(295, 171, 89, 23);
		contentPane.add(btnDelete);
	}
}
