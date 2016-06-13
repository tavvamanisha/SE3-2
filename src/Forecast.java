import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Forecast extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forecast frame = new Forecast();
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
	public Forecast() {
		setTitle("Update Forecast");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDegree = new JLabel("Degree");
		lblDegree.setForeground(new Color(0, 0, 0));
		lblDegree.setBounds(56, 52, 46, 14);
		contentPane.add(lblDegree);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setName("");
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Degree1", "Degree2"}));
		comboBox.setBounds(133, 49, 134, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Students");
		lblNewLabel.setBounds(56, 99, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(133, 96, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Update Forecast");
		btnNewButton.setBounds(116, 157, 133, 23);
		contentPane.add(btnNewButton);
	}

}
