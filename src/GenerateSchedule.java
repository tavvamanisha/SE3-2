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
								
								secArray[sectionArray.length] = sec;
								sectionArray = secArray;
							}else{
								Section sec = new Section();
								sec.setSectionNumber("1");
								sec.setCourse(crs1);
								sec.setFaculty(facultyRequired[i]);
								sec.setDays(facultyAvailable.get(facultyRequired[i]));
								
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
				
				GeneticAlgorithm.GA(studArr, degArr, degPlanArr, sectionArray, 
						textSectionFill.getText(), facultyLoad, textSectionOverage.getText(), textSemester.getText());
				
				/*
				// We will remove the Courses for which Faculty is not available for the semester.
				Set SOK = coursesFaculty.keySet();
				Iterator iterator = SOK.iterator();
				while (iterator.hasNext()){
					String crs1 = (String) iterator.next();
					String[] facultyRequired = (String[]) coursesFaculty.get(crs1);
					boolean flag = false;
					for(int i=0;i<facultyRequired.length-1;i++){
						boolean facultyFlag = false;
						Set SOK2 = facultyAvailable.keySet();
						Iterator it = SOK2.iterator();
						while (it.hasNext()){
							String facAvailable = ((String) it.next());
							if(facultyRequired[i].equals(facAvailable)){
								flag = true;
								facultyFlag = true;
							}
						}
						String[] temp = new String[facultyRequired.length - 1];
						for(int j=i;j<facultyRequired.length;j++){
							temp[i] = facultyRequired[i+1];
						}
						facultyRequired = temp;
					}
					coursesFaculty.put(crs1, facultyRequired);
					
					if(!flag){
						//coursesFaculty.remove(crs1);
						iterator.remove();
						//SOK.remove(crs1);
						coursesOffered.remove(crs1);
						//Set SOK2 = coursesFaculty.keySet();
						//SOK2.remove(crs1);
					}
				
				}
				
				Set SOK2 = coursesFaculty.keySet();
				Iterator iterator2 = SOK2.iterator();
				
				System.out.println("AVAILABLE COURSES LEFT AFETR REMOVING NOT AVAILABLE FACULTY FOR THE SEM "+textSemester.getText()+" ARE:");
				while (iterator2.hasNext()){
					String crs1 = (String) iterator2.next();
					String[] facultyRequired = (String[]) coursesFaculty.get(crs1);
					for(int i=0;i<facultyRequired.length;i++){
						System.out.println("Course: "+crs1+"\t\tFaculty: "+facultyRequired[i]);
					}
					
				}*/
				
				/*for(int i=1;i<studArr.length;i++){ 
					Student stud = studArr[i];
					String[] studCourse = stud.getCourseNum();
					String[] grade = stud.getGrade();
					String[] semester = stud.getCourseSemester();
					
					if(studCourse != null){
						for(int j=0; j<studCourse.length;j++){
							System.out.println("Line 212 " + grade[j]);
							//if(textSemester.getText().equalsIgnoreCase(semester[j])){
								if(!(("A").equalsIgnoreCase(grade[j]) || ("B").equalsIgnoreCase(grade[j]) || 
										("C").equalsIgnoreCase(grade[j]) || ("D").equalsIgnoreCase(grade[j]))){
									System.out.println("Line 214");
									Set SOK2 = coursesOffered.keySet();
									Iterator iter = SOK2.iterator();
									while (iter.hasNext()){
										String crs = (String) iter.next();
										int number = coursesOffered.get(crs);		// Getting the exisiting number of students in the course.
										System.out.println(number);
										if(crs.equalsIgnoreCase(studCourse[j])){
											System.out.println("Line 222");
											coursesOffered.put(crs, number+1);		// Setting up the new strength to + 1.
										}
									}
								}
							//}
						}
					}
					
				}
				
				
				Map<String, String> sectionCourse= new HashMap<>(); 
				Map<String, String> sectionFaculty= new HashMap<>();
				Map<String, String> sectionDay= new HashMap<>();
				
				Set SOK3 = coursesOffered.keySet();
				Iterator iter = SOK3.iterator();
				
				while (iter.hasNext()){
					String crs = (String) iter.next();
					int number = coursesOffered.get(crs).intValue();
					
					System.out.println("-----------"+number);
					//if(number*100/25 > Integer.parseInt(textSectionFill.getText())){
					if(number*100/25 > 0){
						int numberOfSections = (number*100/25)+1;
						
						System.out.println("-----"+numberOfSections);
						
						for(int i=0;i<numberOfSections;i++){
							String section = crs+i;
							String course = crs;
							String[] facAvail = (String[])coursesFaculty.get(crs);
							String fac = null;
							System.out.println(course);
							
							for(int j=0;j<facAvail.length;j++){
								if((int)facultyLoad.get(facAvail[j]) > 0){
									fac = facAvail[j];
								}
							}
							
							String day = (String)facultyAvailable.get(fac);
							int facLoad = facultyLoad.get(fac);
							
							System.out.println("Section "+section);
							System.out.println("Course "+crs);
							System.out.println("Faculty "+fac);
							System.out.println("Day "+day);
							
							sectionCourse.put(section, course);
							sectionFaculty.put(section, fac);
							sectionDay.put(section, day);
							facultyLoad.put(fac, facLoad-1);
						}
						
					}
					
				}
				
				Set SOK4	 = sectionCourse.keySet();
				Iterator iter1 = SOK4.iterator();
				
				System.out.println("Generated Schedule is:");
				System.out.println("Course\t\tSection\t\tFaculty\t\tDay");
				while (iter1.hasNext()){
					String section = (String) iter1.next();
					String course = sectionCourse.get(section);
					String faculty = sectionFaculty.get(section);
					String day = sectionDay.get(section);
					
					System.out.println(course+"\t\t"+section+"\t\t"+faculty+"\t\t"+day);
				}*/
			
			}
		});
		
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
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textSectionOverage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(38)))
							.addPreferredGap(ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
							.addComponent(textSemester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(75)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(textSectionFill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNewButton))
							.addGap(37))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2)
						.addComponent(textSectionFill, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textSemester, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textSectionOverage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
		
	}
}
