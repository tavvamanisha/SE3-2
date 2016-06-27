import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplaySchedule extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplaySchedule frame = new DisplaySchedule(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 * @param numberOfStudents 
	 */
	public DisplaySchedule(Section[] sectionArray, HashMap<String, Integer> numberOfStudents) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
							.addContainerGap())
						/*.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								//.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createSequentialGroup()
									//.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									//.addComponent(textSectionOverage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(38)))
							.addPreferredGap(ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
							//.addComponent(textSemester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(75)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									//.addComponent(lblNewLabel_2)
									.addGap(18)
									//.addComponent(textSectionFill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								//.addComponent(btnNewButton))
							.addGap(37))*/))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					//.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							/*.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2)
						.addComponent(textSectionFill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textSemester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textSectionOverage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(38)*/
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(203, Short.MAX_VALUE))
		);
		
		table = new JTable();
		String[] header = new String[3];
		header[0] = "Course";
		header[1] = "Faculty";
		header[2] = "Days";
		//header[3] = "Students";
		
		String[][] obj = new String[sectionArray.length-1][3];
		for(int i=0;i<sectionArray.length-1;i++){
			obj[i][0] = (sectionArray[i].getCourse());
			obj[i][1] = (sectionArray[i].getFaculty());
			obj[i][2] = (sectionArray[i].getDays());
			//obj[i][3] = Integer.toString(numberOfStudents.get(sectionArray[i].getCourse()));
		}
		
		table.setModel(new DefaultTableModel(obj,header));
		
		scrollPane.setForeground(Color.GRAY);
		scrollPane.setBackground(Color.GRAY);
		scrollPane.setAutoscrolls(true);
		scrollPane.setToolTipText("");
		scrollPane.setRowHeaderView(table);
		contentPane.setLayout(gl_contentPane);
		scrollPane.setViewportView(table);;
	}
}
