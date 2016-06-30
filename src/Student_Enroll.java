import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang.ArrayUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_Enroll extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Enroll frame = new Student_Enroll(null, null, null, null);
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
	public Student_Enroll(final String[] args, Student[] studArr, Section[] secArray, DegreePlan[] degPlanArr) {
		
		for(int i=0;i<studArr.length;i++){ // Looping the code for each student.
    		Student student = studArr[i];
    		String degreeCode = student.getDegree(); // Getting the Degree to which student is enrolled to.
    		String[] coursesApplied = student.getCourseNum(); // Getting the course list to which the student has already applied to.
    		String[] gradesReceived = student.getGrade(); // Getting the grades of the courses to which the student had applied.
    		
    		//String[] FinalCoursesApplied = new String[0];
    		int FinalCourseAppliedCount = 0;
    		DegreePlan degreePlan = new DegreePlan(); // 
    		for(int j=0;j<degPlanArr.length;j++){
    			if(degPlanArr[j].getDegreeCode().equalsIgnoreCase(degreeCode)){ // Checking which degree plan student belongs to
    				degreePlan = degPlanArr[j];
    				String[] coursesToApplyStandard = degreePlan.getCourses().replaceAll("^\"|\"$", "").split(","); // Standard List of Courses which the student needs to Pass.
    				String[] coursesToApplyStud = coursesToApplyStandard; // List of Courses which the Student needs to complete now after passing some Courses.
    				int creditsToEarn = Integer.parseInt(degreePlan.getHours()); // More credits to be earn to pass the degree plan.
    				String[] coursesPassed = new String[1];
    				
    				//System.out.println(coursesApplied.length);
    				//System.out.println(coursesToApplyStandard.length);
    				
    				
    				if(coursesApplied != null){
    					for(int k=0;k<coursesApplied.length;k++){ // Looping to the course list which Student has already applied.
    						if(i==1 && j==10)System.out.println("------------------------------------"+coursesApplied[k]);
        					for(int l=0;l<coursesToApplyStandard.length;l++){ // Looping through the standard Courses list.
        						//System.out.println(i+" " + j+ " " + k + " "+l);
        						//System.out.println("Courses Applied " + coursesApplied[k]);
        						//System.out.println("Courses To Apply Standard " + coursesToApplyStandard[l]);
        						if(coursesApplied[k].equals(coursesToApplyStandard[l])){ // If the student has applied for this coarse earlier.
        							if(creditsToEarn > 0){ // If the student needs to earn more Credits.
        								if("A".equalsIgnoreCase(gradesReceived[k])
        										|| "B".equalsIgnoreCase(gradesReceived[k])
        										|| "C".equalsIgnoreCase(gradesReceived[k])
        										|| "D".equalsIgnoreCase(gradesReceived[k])
        										|| "CIP".equalsIgnoreCase(gradesReceived[k])){
        									// If the student has passed the course remove it from the coursesToApplyStud Array
        									// And update the creditToEarn.
        									coursesToApplyStud = (String[])ArrayUtils.removeElement(coursesToApplyStud, coursesToApplyStandard[l]);
        									creditsToEarn = creditsToEarn - 3;
        									//FinalCoursesApplied = (String[])ArrayUtils.add(coursesPassed, coursesToApplyStandard[l]);
        									FinalCourseAppliedCount++;
        									//System.out.println("coursesToApplyStandard[l] "+coursesToApplyStandard[l]);
        								}
        							} else { // If the student has earned all the credits required for the degree plan.
        								coursesToApplyStud = new String[0];
        							}
        						}
        					}
        				}
    				}
    				String coursesToPass = "";
    				int count = 0;
    				for(int k=0;k<coursesToApplyStud.length;k++){
    					if(k!=0){
    						coursesToPass = coursesToPass + (",");
    					}
    					//coursesToPass.concat(coursesToApplyStud[k]);
    					coursesToPass = coursesToPass + coursesToApplyStud[k];
    					count++;
    				}
    				studArr[i].setCoursesToClear(count);
    				//System.out.println("CoursesToPass: "+coursesToPass);
    				/*System.out.println(i + " " + FinalCoursesApplied.length);
    				String coursesCleared = "";
    				for(int k=1;k<FinalCoursesApplied.length;k++){
    					if(k!=0){
    						
    						coursesCleared = coursesCleared + (",");
    					}
    				//coursesCleared.concat(FinalCoursesApplied[k]);
    				coursesCleared= coursesCleared + FinalCoursesApplied[k];
    				coursesCleared = coursesCleared.concat(FinalCoursesApplied[k].toString());
    				}*/
    				studArr[i].setCoursesCleared(FinalCourseAppliedCount);
    				studArr[i].setCoursesToClear(10-FinalCourseAppliedCount);
    				//System.out.println("CoursesCleared: "+coursesCleared);
    				
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
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
						.addComponent(btnBack, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnBack)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		table = new JTable();
		
		String[] header = new String[3];
		
		header[0] = "Student Roll No";
		header[1] = "Courses Completed";
		header[2] = "Courses To Complete";
		
		String[][] obj = new String[studArr.length-1][3];
		for(int i=0;i<studArr.length-1;i++){
			obj[i][0] = (studArr[i+1].getRollNo());
			obj[i][1] = String.valueOf((studArr[i+1].getCoursesCleared()));
			obj[i][2] = String.valueOf((studArr[i+1].getCoursesToClear()));
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
