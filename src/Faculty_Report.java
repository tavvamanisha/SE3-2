import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Faculty_Report extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Faculty_Report frame = new Faculty_Report(null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param sectionArray 
	 * @param facultyArray 
	 */
	public Faculty_Report(final String[] args, Section[] sectionArray, Faculty[] facultyArray) {
		
		for(int i=0;i<facultyArray.length;i++){
			for (int j=0;j<sectionArray.length;j++){
				if(facultyArray[i].getLastname().equalsIgnoreCase(sectionArray[j].getFaculty())){
					if(facultyArray[i].getCourses()!=null){
						String crs = facultyArray[i].getCourses();
						facultyArray[i].setCourses(crs+","+sectionArray[j].getCourse());
						
						int load = facultyArray[i].getLoad();
						facultyArray[i].setLoad(load+3);
						
					} else {
						facultyArray[i].setCourses(sectionArray[j].getCourse());
						facultyArray[i].setLoad(3);
					}
				}
			}
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				args[0]="0";
				new Home(args).setVisible(true);
				//new Home(args).setFacultyArray(facultyArray);
				new Home(args);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 683, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(646)
							.addComponent(btnBack)))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(21))
		);
		
		table = new JTable();
		
		String[] header = new String[4];
		
		header[0] = "Faculty Last Name";
		header[1] = "Courses";
		header[2] = "Load";
		header[3] = "Semester";
		
		String[][] obj = new String[facultyArray.length-1][4];
		for(int i=0;i<facultyArray.length-1;i++){
			obj[i][0] = (facultyArray[i+1].getLastname());
			obj[i][1] = (facultyArray[i+1].getCourses());
			obj[i][2] = String.valueOf((facultyArray[i+1].getLoad()));
			obj[i][3] = sectionArray[0].getSemester();
		}
		
		table.setModel(new DefaultTableModel(obj,header));

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setRowSelectionAllowed(true);
			table.setForeground(Color.BLACK);
			table.setFillsViewportHeight(true);
			table.setBackground(SystemColor.control);
			table.setName("table");
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.getGridColor();
			table.getTableHeader().getBackground().getBlue();
			table.setAutoCreateRowSorter(true);
			
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

}
