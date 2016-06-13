import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setTitle("Adminstrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(26, 11, 46, 31);
		contentPane.add(lblCourse);
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setBounds(26, 51, 46, 14);
		contentPane.add(lblRoom);
		
		JLabel lblDegree = new JLabel("Degree");
		lblDegree.setBounds(26, 84, 46, 14);
		contentPane.add(lblDegree);
		
		JLabel lblNewLabel = new JLabel("Faculty");
		lblNewLabel.setBounds(26, 113, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblReport = new JLabel("Report");
		lblReport.setBounds(26, 142, 46, 14);
		contentPane.add(lblReport);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ADD ", "UPDATE ", "DELETE"}));
		comboBox.setBounds(82, 48, 130, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"ADD ", "UPDATE ", "DELETE"}));
		comboBox_1.setBounds(82, 16, 130, 20);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"ADD ", "UPDATE ", "DELETE"}));
		comboBox_2.setBounds(82, 81, 130, 20);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"ADD ", "UPDATE ", "DELETE"}));
		comboBox_3.setBounds(82, 110, 130, 20);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Schedule Report", "Faculty Report", "Course Report"}));
		comboBox_5.setBounds(82, 139, 130, 20);
		contentPane.add(comboBox_5);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(247, 47, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(247, 15, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Submit");
		button_1.setBounds(247, 138, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Submit");
		button_2.setBounds(247, 80, 89, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Submit");
		button_3.setBounds(247, 109, 89, 23);
		contentPane.add(button_3);
	}
}
