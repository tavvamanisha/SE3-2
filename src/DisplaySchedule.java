import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JButton btnTestSchedule;
	private JButton btnSaveSchedule;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplaySchedule frame = new DisplaySchedule(null, null, null, null, null, null, null, null, null, null, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 * @param semester 
	 * @param maxOverage 
	 * @param facultyLoad 
	 * @param minFillPercent 
	 * @param degPlanArr 
	 * @param degArr 
	 * @param studArr 
	 * @param facArr 
	 * @param crsArr 
	 * @param args 
	 * @param numberOfStudents 
	 * @param bestGene 
	 */
	public DisplaySchedule(String[] args, Course[] crsArr, Faculty[] facArr, Student[] studArr, 
			Degree[] degArr, DegreePlan[] degPlanArr, String minFillPercent, 
			HashMap<String, Integer> facultyLoad, String maxOverage, String semester,
			Section[] secArray, HashMap<String, Integer> numberOfStudents, int[] bestGene) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnTestSchedule = new JButton("Test Schedule");
		btnTestSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TestSchedule(args, bestGene, secArray, studArr, degPlanArr, degArr, minFillPercent, maxOverage, 
						crsArr, facArr, facultyLoad, semester, numberOfStudents).setVisible(true);
				//new TestSchedule(args, bestGene, secArray, studArr, degPlanArr, degArr, minFillPercent, maxOverage, 
						//crsArr, facArr, facultyLoad, semester, numberOfStudents);
				dispose();
				
			}
		});
		
		btnSaveSchedule = new JButton("Save Schedule");
		btnSaveSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				args[0]="0";
				new Home(args).setVisible(true);
				new Home(args).setSectionArray(secArray);
				JFrame parent = new JFrame();
		        JOptionPane.showMessageDialog(parent,"Schedule saved succesfully.");
				new Home(args);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(220, Short.MAX_VALUE)
					.addComponent(btnTestSchedule)
					.addGap(40)
					.addComponent(btnSaveSchedule)
					.addGap(39)
					.addComponent(btnBack)
					.addGap(200))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnTestSchedule)
						.addComponent(btnSaveSchedule))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		
		
		
		
		table = new JTable();
		String[] header = new String[3];
		header[0] = "Course";
		header[1] = "Faculty";
		header[2] = "Days";
		//header[3] = "Students";
		
		String[][] obj = new String[secArray.length][3];
		for(int i=0;i<secArray.length;i++){
			obj[i][0] = (secArray[i].getCourse());
			obj[i][1] = (secArray[i].getFaculty());
			obj[i][2] = (secArray[i].getDays());
			//obj[i][3] = Integer.toString(numberOfStudents.get(secArray[i].getCourse()));
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
