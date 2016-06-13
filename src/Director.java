import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Director extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Director frame = new Director();
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
	public Director() {
		setTitle("Director Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Course");
		label.setBounds(25, 11, 46, 31);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ADD", "UPDATE", "DELETE"}));
		comboBox.setBounds(99, 16, 130, 20);
		contentPane.add(comboBox);
		
		JButton button = new JButton("Submit");
		button.setBounds(366, 11, 89, 23);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("Room");
		label_1.setBounds(25, 51, 46, 14);
		contentPane.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"ADD", "UPDATE", "DELETE"}));
		comboBox_1.setBounds(99, 47, 130, 20);
		contentPane.add(comboBox_1);
		
		JButton button_1 = new JButton("Submit");
		button_1.setBounds(366, 43, 89, 23);
		contentPane.add(button_1);
		
		JLabel label_2 = new JLabel("Degree");
		label_2.setBounds(25, 80, 46, 14);
		contentPane.add(label_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"ADD", "UPDATE", "DELETE"}));
		comboBox_2.setBounds(99, 77, 130, 20);
		contentPane.add(comboBox_2);
		
		JButton button_2 = new JButton("Submit");
		button_2.setBounds(366, 75, 89, 23);
		contentPane.add(button_2);
		
		JLabel label_3 = new JLabel("Faculty");
		label_3.setBounds(25, 109, 46, 14);
		contentPane.add(label_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"ADD", "UPDATE", "DELETE"}));
		comboBox_3.setBounds(99, 106, 130, 20);
		contentPane.add(comboBox_3);
		
		JButton button_3 = new JButton("Submit");
		button_3.setBounds(366, 104, 89, 23);
		contentPane.add(button_3);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setBounds(25, 140, 46, 14);
		contentPane.add(lblSection);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"ADD", "UPDATE", "DELETE"}));
		comboBox_4.setBounds(99, 137, 130, 20);
		contentPane.add(comboBox_4);
		
		JButton button_4 = new JButton("Submit");
		button_4.setBounds(366, 135, 89, 23);
		contentPane.add(button_4);
		
		JLabel lblSchedule = new JLabel("Schedule");
		lblSchedule.setBounds(25, 175, 74, 14);
		contentPane.add(lblSchedule);
		
		JButton button_5 = new JButton("Submit");
		button_5.setBounds(109, 171, 89, 23);
		contentPane.add(button_5);
		
		JLabel lblReport = new JLabel("Report");
		lblReport.setBounds(25, 208, 46, 14);
		contentPane.add(lblReport);
		
		JButton button_7 = new JButton("Submit");
		button_7.setBounds(109, 204, 89, 23);
		contentPane.add(button_7);
		
		JLabel lblImport = new JLabel("Import");
		lblImport.setBounds(272, 175, 46, 14);
		contentPane.add(lblImport);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(366, 169, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblForecast = new JLabel("Forecast");
		lblForecast.setBounds(272, 208, 69, 14);
		contentPane.add(lblForecast);
		
		JButton button_8 = new JButton("Submit");
		button_8.setBounds(366, 203, 89, 23);
		contentPane.add(button_8);
		
		JLabel lblAddUser = new JLabel("Add User");
		lblAddUser.setBounds(25, 240, 74, 14);
		contentPane.add(lblAddUser);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
		     new AddUser().setVisible(true);
			}
		});
		btnAdd.setBounds(109, 238, 89, 23);
		contentPane.add(btnAdd);
	}
}
