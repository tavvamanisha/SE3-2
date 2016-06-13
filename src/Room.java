import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Room extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Room frame = new Room();
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
	public Room() {
		setTitle("Room Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRoomNo = new JLabel("Room No.");
		lblRoomNo.setBounds(60, 40, 75, 14);
		contentPane.add(lblRoomNo);
		
		JLabel lblNewLabel = new JLabel("Buliding Name");
		lblNewLabel.setBounds(60, 70, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Capacity");
		lblNewLabel_1.setBounds(60, 100, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDegree = new JLabel("Degree");
		lblDegree.setBounds(60, 130, 46, 14);
		contentPane.add(lblDegree);
		
		textField = new JTextField();
		textField.setBounds(181, 37, 125, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 67, 125, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(181, 97, 125, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Degree"}));
		comboBox.setBounds(181, 127, 125, 20);
		contentPane.add(comboBox);
		
		JButton btnAddRoom = new JButton("Add Room");
		btnAddRoom.setBounds(138, 177, 113, 23);
		contentPane.add(btnAddRoom);
	}

}
