import java.awt.BorderLayout;
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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenerateSchedule extends JFrame {

	private JPanel contentPane;
	private JTextField textSemester;
	private JTextField textSectionOverage;
	private JTextField textSectionFill;
	private static JTable table;
	Section[] sectionArray;
	
	Student[] studArr; 
	Degree[] degArr; 
	DegreePlan[] degPlanArr; 
	Course[] crsArr;
	Faculty[] facArr;
	static Section[] secArray;
	private JTextField iterations;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateSchedule frame = new GenerateSchedule(null,null,null,null,null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public static JTable getTable() {
		return table;
	}



	public static void setTable(JTable table) {
		GenerateSchedule.table = table;
	}



	public Section[] getSecArray() {
		return secArray;
	}

	public void setSecArray(Section[] secArray) {
		this.secArray = secArray;
	}



	/**
	 * Create the frame.
	 */
	public GenerateSchedule(String[] args, Student[] studArr1, Degree[] degArr1, DegreePlan[] degPlanArr1, 
			Course[] crsArr1, Faculty[] facArr1) {
		
		studArr =  studArr1;
		degArr  = degArr1;
		degPlanArr  = degPlanArr1;
		crsArr = crsArr1;
		facArr = facArr1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Semester");
		
		JLabel lblNewLabel_1 = new JLabel("Section Overage");
		
		JLabel lblNewLabel_2 = new JLabel("Section Fill");
		
		textSemester = new JTextField();
		textSemester.setColumns(10);
		
		textSectionOverage = new JTextField();
		textSectionOverage.setColumns(10);
		
		textSectionFill = new JTextField();
		textSectionFill.setColumns(10);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sem = textSemester.getText().substring(textSemester.getText().length()-2);
				
				HashMap<String, Integer> coursesOffered= new HashMap<>(); // creating a HashMap and putting courses offered in the imput semester.
				HashMap<String, String[]> coursesFaculty= new HashMap<>(); // creating a HashMap and putting courses offered in the imput semester.
				HashMap<String, String> facultyAvailable= new HashMap<>(); // creating a HashMap and putting courses offered in the imput semester.
				HashMap<String, Integer> facultyLoad= new HashMap<>(); // creating a HashMap and putting courses offered in the imput semester.
				
				
				//coursesOffered - Key - CourseCode, Value - Number of Students.
				//coursesFaculty - Key - CourseCode, Value - FacultyArray.
				//facultyAvailable - Key - facultyLastName, Value - Days on which he is available (MTW)
				//facultyLoad - Key - facultyLastName, Value - Number of courses faculty can take.
				
				if("FA".equalsIgnoreCase(sem)){
					
					for(int i=1;i<crsArr.length;i++){
						if("Y".equalsIgnoreCase(crsArr[i].getFall())){
							coursesOffered.put(crsArr[i].getCoursenum(), 0);
							coursesFaculty.put(crsArr[i].getCoursenum(), crsArr[i].getFaculty());
						}
					}
					System.out.println(crsArr.length);
					for(int j=1; j<facArr.length; j++){
						if(!"0".equalsIgnoreCase(facArr[j].getMaxfall())){
							facultyAvailable.put(facArr[j].getLastname(), facArr[j].getDay());
							facultyLoad.put(facArr[j].getLastname(), Integer.parseInt(facArr[j].getMaxfall()));
						}
					}
				} else if ("SU".equalsIgnoreCase(sem)){
					for(int i=1;i<crsArr.length;i++){
						if("Y".equalsIgnoreCase(crsArr[i].getSummer())){
							coursesOffered.put(crsArr[i].getCoursenum(), 0);
							coursesFaculty.put(crsArr[i].getCoursenum(), crsArr[i].getFaculty());
						}
					}
					for(int j=1; j<facArr.length; j++){
						if(!"0".equalsIgnoreCase(facArr[j].getMaxsummer())){
							facultyAvailable.put(facArr[j].getLastname(), facArr[j].getDay());
							facultyLoad.put(facArr[j].getLastname(), Integer.parseInt(facArr[j].getMaxsummer()));
						}
					}
				} else if ("SP".equalsIgnoreCase(sem)){
					for(int i=1;i<crsArr.length;i++){
						if("Y".equalsIgnoreCase(crsArr[i].getSpring())){
							coursesOffered.put(crsArr[i].getCoursenum(), 0);
							coursesFaculty.put(crsArr[i].getCoursenum(), crsArr[i].getFaculty());
						}
					}
					for(int j=1; j<facArr.length; j++){
						if(!"0".equalsIgnoreCase(facArr[j].getMaxspring())){
							facultyAvailable.put(facArr[j].getLastname(), facArr[j].getDay());
							facultyLoad.put(facArr[j].getLastname(), Integer.parseInt(facArr[j].getMaxspring()));
						}
					}
				}
				
				Set SOK3 = coursesFaculty.keySet();
				Iterator iterator3 = SOK3.iterator();
				HashMap<String, Integer> courseCountFaculty = new HashMap();
				System.out.println("AVAILABLE COURSES FOR THE SEM "+textSemester.getText()+" ARE:courseFaculty");
				while (iterator3.hasNext()){
					String crs1 = (String) iterator3.next();
					String[] facultyRequired = (String[]) coursesFaculty.get(crs1);
					for(int i=0;i<facultyRequired.length;i++){
						System.out.println("Course: "+crs1+"\tFaculty: "+facultyRequired[i]+"\t\tMaxLoad: "+facultyLoad.get(facultyRequired[i]));
						int value = 0;
						if(courseCountFaculty.get(crs1)!=null){
							value = courseCountFaculty.get(crs1);;
						}
						courseCountFaculty.put(crs1, value+1);
						
						if(facultyLoad.get(facultyRequired[i])!=null){
							if(sectionArray!=null){
								Section[] secArray = new Section[sectionArray.length+1];
								for(int j=0;j<sectionArray.length;j++){
									secArray[j]=sectionArray[j];
								}
								Section sec = new Section();
								sec.setSectionNumber(Integer.toString(secArray.length));
								sec.setCourse(crs1);
								sec.setFaculty(facultyRequired[i]);
								sec.setDays(facultyAvailable.get(facultyRequired[i]));
								sec.setSemester(textSemester.getText());
								
								secArray[sectionArray.length] = sec;
								sectionArray = secArray;
							}else{
								Section sec = new Section();
								sec.setSectionNumber("1");
								sec.setCourse(crs1);
								sec.setFaculty(facultyRequired[i]);
								sec.setDays(facultyAvailable.get(facultyRequired[i]));
								sec.setSemester(textSemester.getText());
								
								sectionArray = new Section[1];
								sectionArray[0] = sec;
							}
						}						
					}
				}
				
				
				System.out.println("AVAILABLE COURSES WITH AVAILABLE FACULTY FOR THE SEM "+
									textSemester.getText()+" ARE:sectionArray");
				for(int j=0;j<sectionArray.length;j++){
					System.out.println("Section: "+sectionArray[j].getSectionNumber()+
							"\tCourse: "+sectionArray[j].getCourse()+
							"\tFaculty: "+sectionArray[j].getFaculty()+
							"\t\tDays: "+sectionArray[j].getDays());
				}
				
				
				// Now sectionArray has been formed which has all the possible courses along with the faculty
				// which the University can offer in the semester selected.
				
				/*
				System.out.println("AVAILABLE FACULTY COUNT FOR THE SEM "+textSemester.getText()+" ARE:courseCountFaculty");
				Set SOK4 = courseCountFaculty.keySet();
				Iterator iterator4 = SOK4.iterator();
				while(iterator4.hasNext()){
					String course = (String) iterator4.next();
					int count = (int) courseCountFaculty.get(course);
					System.out.println("Course: "+course+"\t\tCount: "+count);
				}*/
				
				GeneticAlgorithm.GA(args, crsArr, facArr, studArr, degArr, degPlanArr, sectionArray, 
						textSectionFill.getText(), facultyLoad, textSectionOverage.getText(), textSemester.getText(), iterations.getText());
				//dispose();
				
			
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				args[0]="0";
				new Home(args).setVisible(true);
				new Home(args);
				dispose();
			}
		});
		
		JLabel lblIterations = new JLabel("Iterations");
		
		iterations = new JTextField();
		iterations.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textSemester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textSectionOverage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(33)
									.addComponent(lblNewLabel_2)
									.addGap(38)
									.addComponent(textSectionFill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(79)
									.addComponent(btnNewButton)))
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblIterations)
									.addGap(18)
									.addComponent(iterations, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnBack))
							.addGap(233))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textSemester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(textSectionFill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIterations)
						.addComponent(iterations, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textSectionOverage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack)
						.addComponent(btnNewButton))
					.addGap(38)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(203, Short.MAX_VALUE))
		);
		
		/*table = new JTable();
		String[] header = new String[3];
		header[0] = "Course";
		header[1] = "Faculty";
		header[2] = "Days";
		
		String[][] obj = new String[sectionArray.length-1][3];
		for(int i=0;i<sectionArray.length-1;i++){
			obj[i][0] = (sectionArray[i].getCourse());
			obj[i][1] = (sectionArray[i+1].getFaculty());
			obj[i][2] = (sectionArray[i+1].getDays());
		}
		
		table.setModel(new DefaultTableModel(obj,header));*/
		
		
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Section", "Course", "Semester", "Faculty", "Start Time", "End Time"
			}
		));*/
		scrollPane.setRowHeaderView(table);
		contentPane.setLayout(gl_contentPane);
		
		dispose();
	}
}
