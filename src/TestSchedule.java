import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang.ArrayUtils;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestSchedule extends JFrame {

	private JPanel contentPane;
	HashMap<String,Integer> unsatisfiedCourses = new HashMap();
	HashMap<String,Integer> satisfiedCourses = new HashMap();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSchedule frame = new TestSchedule(null, null, null, null, null, null, null, null, null, null, null, null, null);
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
	public TestSchedule(String[] args, int[] bestGene, Section[] secArray, Student[] studArr, DegreePlan[] degPlanArr, 
			Degree[] degArr, String minFillPercent, String maxOverage, Course[] crsArray, Faculty[] facArray, 
			HashMap<String, Integer> facultyLoad, String semester, HashMap<String, Integer> numberOfStudentsHash) {
		
		
		int[][] StudentCourseMatrix = new int[studArr.length][secArray.length];
		
		for(int i=0;i<studArr.length;i++){ // Looping the code for each student.
    		Student student = studArr[i];
    		String degreeCode = student.getDegree(); // Getting the Degree to which student is enrolled to.
    		String[] coursesApplied = student.getCourseNum(); // Getting the course list to which the student has already applied to.
    		String[] gradesReceived = student.getGrade(); // Getting the grades of the courses to which the student had applied.
    		
    		DegreePlan degreePlan = new DegreePlan(); // 
    		for(int j=0;j<degPlanArr.length;j++){
    			if(degPlanArr[j].getDegreeCode().equalsIgnoreCase(degreeCode)){ // Checking which degree plan student belongs to
    				degreePlan = degPlanArr[j];
    				String[] coursesToApplyStandard = degreePlan.getCourses().replaceAll("^\"|\"$", "").split(","); // Standard List of Courses which the student needs to Pass.
    				String[] coursesToApplyStud = coursesToApplyStandard; // List of Courses which the Student needs to complete now after passing some Courses.
    				int creditsToEarn = Integer.parseInt(degreePlan.getHours()); // More credits to be earn to pass the degree plan.
    				
    				if(coursesApplied != null){
    					for(int k=0;k<coursesApplied.length;k++){ // Looping to the course list which Student has already applied.
        					for(int l=0;l<coursesToApplyStandard.length;l++){ // Looping through the standard Courses list.
        						if(coursesApplied[k].equals(coursesToApplyStandard[l])){ // If the student has applied for this coarse earlier.
        							if(creditsToEarn > 0){ // If the student needs to earn more Credits.
        								if("A".equalsIgnoreCase(gradesReceived[k])
        										|| "B".equalsIgnoreCase(gradesReceived[k])
        										|| "C".equalsIgnoreCase(gradesReceived[k])
        										|| "D".equalsIgnoreCase(gradesReceived[k])
        										|| "CIP".equalsIgnoreCase(gradesReceived[k])){
        									// If the student has passed the course remove it from the coursesToApplyStud Array
        									// And update the creditToEarn.
        									ArrayUtils.removeElement(coursesToApplyStud, coursesToApplyStandard[l]);
        									creditsToEarn = creditsToEarn - 3;
        								}
        							} else { // If the student has earned all the credits required for the degree plan.
        								coursesToApplyStud = new String[0];
        							}
        						}
        					}
        				}
    				}
    				
    				// Now the courseToApplyStud has the list of courses which the student needs to apply.
    				// And the creditsToEarn has the value of credits which the student has to earn.
    				
    				for(int m=0;m<secArray.length;m++){ // Looping through the gene value
						Section section = secArray[m];
						if(ArrayUtils.contains(coursesToApplyStud, section.getCourse())){ // If the student has to apply for the course which is available in the schedule.
							int count = StudentCourseMatrix[i][m];
							StudentCourseMatrix[i][m] = count+1;
						}
    				}
    			}
    		}
    	}
    	
    	// Now for the students who are newly expected to be joining the university.
    	for(int i=1;i<degArr.length;i++){
    		
    		String degreeCode = degArr[i].getDegreeCode();
    		int numberOfStudents = Integer.parseInt(degArr[i].getForecast());
    		
    		DegreePlan degreePlan = new DegreePlan();
    		for(int j=0;j<degPlanArr.length;j++){
    			if(degPlanArr[j].getDegreeCode().equalsIgnoreCase(degreeCode)){ // Checking which degree plan student belongs to
    				degreePlan = degPlanArr[j];
    				String[] coursesToApplyStud  = degreePlan.getCourses().replaceAll("^\"|\"$", "").split(","); // Standard List of Courses which the student needs to Pass.
    				//int creditsToEarn = Float.parseFloat(degreePlan.getHours()); // More credits to be earn to pass the degree plan.
    				
    				// Now the courseToApplyStud has the list of courses which the student needs to apply.
    				// And the creditsToEarn has the value of credits which the student has to earn.
    				
    				for(int m=0;m<secArray.length;m++){ // Looping through the gene value
						Section section = secArray[m];
						if(ArrayUtils.contains(coursesToApplyStud, section.getCourse())){
							int count = StudentCourseMatrix[i][m];
							StudentCourseMatrix[i][m] = count + numberOfStudents;
						}
    				}
    			}
    		}
    	}
    	
    	// Now we will check for Unsatisfied students.
    	
    	int[][] FinalStudentCourseMatrix = new int[studArr.length][secArray.length]; // THis will have the actual number of students for each course.
    	int[] numberOfCoursesToPass = new int[studArr.length];
    	int[] sectionStrength = new int[secArray.length];
    	HashMap<String,String> unsatisfiedStudents = new HashMap(); // Key - Roll No. Value - Course Number
    	
    	for(int i=0;i<studArr.length;i++){
    		for(int j=0;j<secArray.length;j++){
    			numberOfCoursesToPass[i] = numberOfCoursesToPass[i] + StudentCourseMatrix[i][j];
    		}
    	}
    	
    	for(int i=0;i<numberOfCoursesToPass.length;i++){
    		if(numberOfCoursesToPass[i]<=2){
    			for(int j=0;j<secArray.length;j++){
    				int count = sectionStrength[j] + StudentCourseMatrix[i][j];
    				
    				if(count < 25*(1 + (Float.parseFloat(maxOverage)/100))){
    					sectionStrength[j] = count;
    					FinalStudentCourseMatrix[i][j] = FinalStudentCourseMatrix[i][j] + 1; 
    				} else{
    					unsatisfiedStudents.put(studArr[i].getRollNo(), secArray[j].getCourse());
    				}
    			}
    		}
    	}
    	
    	
    	for(int i=0;i<numberOfCoursesToPass.length;i++){
    		if(numberOfCoursesToPass[i]>2 && numberOfCoursesToPass[i]<=4){
    			for(int j=0;j<secArray.length;j++){
    				int count = sectionStrength[j] + StudentCourseMatrix[i][j];
    				
    				if(count < 25*(1 + (Float.parseFloat(maxOverage)/100))){
    					sectionStrength[j] = count;
    					FinalStudentCourseMatrix[i][j] = FinalStudentCourseMatrix[i][j] + 1; 
    				} else{
    					int numberOfCoursesApplied = 0;
    					int numberOfCoursesRegistered = 0;
    					for(int k=0;k<StudentCourseMatrix.length;k++){
    						numberOfCoursesApplied = numberOfCoursesApplied + StudentCourseMatrix[i][k];
    					}// 10
    					for(int k=0;k<FinalStudentCourseMatrix.length;k++){
    						numberOfCoursesRegistered = numberOfCoursesRegistered + FinalStudentCourseMatrix[i][k];
    					}//2
    					// 1 2 3 4 5 6 7 8 9 10
    					// 1 0 1 0 0 0 0 0 0 1
    					// if 2 < 4 and  
    					if((numberOfCoursesRegistered < 4) && (numberOfCoursesRegistered+secArray.length-j)<(4)){
    						unsatisfiedStudents.put(studArr[i].getRollNo(), secArray[j].getCourse());
    					}
    					
    				}
    			}
    		}
    	}
    	
    	for(int i=0;i<numberOfCoursesToPass.length;i++){
    		if(numberOfCoursesToPass[i]>4 && numberOfCoursesToPass[i]<=6){
    			for(int j=0;j<secArray.length;j++){
    				int count = sectionStrength[j] + StudentCourseMatrix[i][j];
    				
    				if(count < 25*(1 + (Float.parseFloat(maxOverage)/100))){
    					sectionStrength[j] = count;
    					FinalStudentCourseMatrix[i][j] = FinalStudentCourseMatrix[i][j] + 1; 
    				} else{
    					int numberOfCoursesApplied = 0;
    					int numberOfCoursesRegistered = 0;
    					for(int k=0;k<StudentCourseMatrix[i].length;k++){
    						numberOfCoursesApplied = numberOfCoursesApplied + StudentCourseMatrix[i][k];
    					}// 10
    					for(int k=0;k<FinalStudentCourseMatrix[i].length;k++){
    						numberOfCoursesRegistered = numberOfCoursesRegistered + FinalStudentCourseMatrix[i][k];
    					}//2
    					// 1 2 3 4 5 6 7 8 9 10
    					// 1 0 1 0 0 0 0 0 0 1
    					// if 2 < 4 and  
    					if((numberOfCoursesRegistered < 4) && (numberOfCoursesRegistered+secArray.length-j)<(4)){
    						unsatisfiedStudents.put(studArr[i].getRollNo(), secArray[j].getCourse());
    					}
    					
    				}
    			}
    		}
    	}
    	for(int i=0;i<numberOfCoursesToPass.length;i++){
    		if(numberOfCoursesToPass[i]>6 && numberOfCoursesToPass[i]<=8){
    			for(int j=0;j<secArray.length;j++){
    				int count = sectionStrength[j] + StudentCourseMatrix[i][j];
    				
    				if(count < 25*(1 + (Float.parseFloat(maxOverage)/100))){
    					sectionStrength[j] = count;
    					FinalStudentCourseMatrix[i][j] = FinalStudentCourseMatrix[i][j] + 1; 
    				} else{
    					int numberOfCoursesApplied = 0;
    					int numberOfCoursesRegistered = 0;
    					for(int k=0;k<StudentCourseMatrix[i].length;k++){
    						numberOfCoursesApplied = numberOfCoursesApplied + StudentCourseMatrix[i][k];
    					}// 10
    					for(int k=0;k<FinalStudentCourseMatrix[i].length;k++){
    						numberOfCoursesRegistered = numberOfCoursesRegistered + FinalStudentCourseMatrix[i][k];
    					}//2
    					// 1 2 3 4 5 6 7 8 9 10
    					// 1 0 1 0 0 0 0 0 0 1
    					// if 2 < 4 and  
    					if((numberOfCoursesRegistered < 4) && (numberOfCoursesRegistered+secArray.length-j)<(4)){
    						unsatisfiedStudents.put(studArr[i].getRollNo(), secArray[j].getCourse());
    					}
    					
    				}
    			}
    		}
    	}
    	for(int i=0;i<numberOfCoursesToPass.length;i++){
    		if(numberOfCoursesToPass[i]>8 && numberOfCoursesToPass[i]<=10){
    			for(int j=0;j<secArray.length;j++){
    				int count = sectionStrength[j] + StudentCourseMatrix[i][j];
    				
    				if(count < 25*(1 + (Float.parseFloat(maxOverage)/100))){
    					sectionStrength[j] = count;
    					FinalStudentCourseMatrix[i][j] = FinalStudentCourseMatrix[i][j] + 1; 
    				} else{
    					int numberOfCoursesApplied = 0;
    					int numberOfCoursesRegistered = 0;
    					for(int k=0;k<StudentCourseMatrix[i].length;k++){
    						numberOfCoursesApplied = numberOfCoursesApplied + StudentCourseMatrix[i][k];
    					}// 10
    					for(int k=0;k<FinalStudentCourseMatrix[i].length;k++){
    						numberOfCoursesRegistered = numberOfCoursesRegistered + FinalStudentCourseMatrix[i][k];
    					}//2
    					// 1 2 3 4 5 6 7 8 9 10
    					// 1 0 1 0 0 0 0 0 0 1
    					// if 2 < 4 and  
    					if((numberOfCoursesRegistered < 4) && (numberOfCoursesRegistered+secArray.length-j)<(4)){
    						unsatisfiedStudents.put(studArr[i].getRollNo(), secArray[j].getCourse());
    					}
    					
    				}
    			}
    		}
    	}
    	
    	int numberOfUnsatisfiedStudents = unsatisfiedStudents.size();
    	
    	
    	for(int i=0;i<studArr.length;i++){
    		//System.out.print("\n");
    		for(int j=0;j<secArray.length;j++){
    			//System.out.print(FinalStudentCourseMatrix[i][j] + "\t");
    			FinalStudentCourseMatrix[i][j]=0;
    		}
    	}
    	
    	
    	
    	// NOW CALCULATING FOR UNSATISFIED COURSES AND SATISFIED COURSES
    	
    	Integer[] FinalCourseStrength = new Integer[secArray.length];
    	
    	Float minFill = 25 - (Float.parseFloat(minFillPercent)*25)/100;
    	
    	Float maxFill = 25 + (Float.parseFloat(maxOverage)*25)/100;    	
    	//System.out.println("====" +minFill);
    	//System.out.println("====" +maxFill);
    	
    	Random r = new Random();
    	for(int i=0;i<studArr.length/3;i++){
    		for(int k=0;k<4;k++){
    				int l = r.nextInt(secArray.length);
    				FinalStudentCourseMatrix[i][l] = 1;
			}
    	}
    	for(int i=studArr.length/3;i<2*studArr.length/3;i++){
    		for(int k=0;k<2;k++){
    				int l = r.nextInt(secArray.length);
    				FinalStudentCourseMatrix[i][l] = 1;
			}
    	}
    	for(int i=2*studArr.length/3;i<studArr.length;i++){
    		for(int k=0;k<1;k++){
    				int l = r.nextInt(secArray.length);
    				FinalStudentCourseMatrix[i][l] = 1;
			}
    	}
    	
    	for(int i=0;i<studArr.length;i++){
    		System.out.print("\n");
    		for(int j=0;j<secArray.length;j++){
    			System.out.print(FinalStudentCourseMatrix[i][j] + "\t");
    			//FinalStudentCourseMatrix[i][j]=0;
    		}
    	}
    	
    	
    	
    	for(int i=0;i<secArray.length;i++){
    		for(int j=0;j<studArr.length;j++){
    			if(j==0){
    				FinalCourseStrength[i] = FinalStudentCourseMatrix[0][i];
    			} else {
    				FinalCourseStrength[i] = FinalCourseStrength[i] + FinalStudentCourseMatrix[j][i];
    			}
    		}
    	}
    	
    	System.out.println("\nmaxfill "+maxFill);
    	System.out.println("minFill "+ minFill);
    	
    	System.out.println("FinalCourseStrength[i] ");
    	for(int i=0;i<FinalCourseStrength.length;i++){
    		System.out.print(FinalCourseStrength[i]+" ");
    	}
    	System.out.print("\n");
    	
    	for(int i=0;i<FinalCourseStrength.length;i++){
    		//System.out.println(FinalCourseStrength[i]);
    		if(FinalCourseStrength[i]>maxFill){
    			unsatisfiedCourses.put(secArray[i].getCourse(), FinalCourseStrength[i]);
    		}
    		
    		if(FinalCourseStrength[i]>=minFill && FinalCourseStrength[i]<=maxFill){
    			satisfiedCourses.put(secArray[i].getCourse(), FinalCourseStrength[i]);
    			//System.out.println("====" +satisfiedCourses.size());
    		}
    	}
    	
    	//System.out.println("====" +satisfiedCourses.size());
    	
    	
    	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumberOfUnsatisfied = new JLabel("Number of Unsatisfied Students");
		lblNumberOfUnsatisfied.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumberOfUnsatisfied.setBounds(184, 101, 181, 24);
		contentPane.add(lblNumberOfUnsatisfied);
		
		JLabel lblNumberOfCourses = new JLabel("Number of Courses Within Fill & Overage Goals");
		lblNumberOfCourses.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumberOfCourses.setBounds(81, 136, 284, 34);
		contentPane.add(lblNumberOfCourses);
		
		JLabel lblNumberOfCourses_1 = new JLabel("Number of Courses with more than 100% of Capacity");
		lblNumberOfCourses_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumberOfCourses_1.setBounds(10, 188, 355, 14);
		contentPane.add(lblNumberOfCourses_1);
		
		JLabel lblNewLabel = new JLabel(String.valueOf(numberOfUnsatisfiedStudents));
		lblNewLabel.setText(String.valueOf(numberOfUnsatisfiedStudents));
		lblNewLabel.setBounds(413, 106, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(String.valueOf(satisfiedCourses.size()));
		lblNewLabel_1.setBounds(413, 146, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(String.valueOf(unsatisfiedCourses.size()));
		lblNewLabel_2.setBounds(413, 188, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new DisplaySchedule(args, crsArray, facArray, studArr, degArr, degPlanArr, minFillPercent, 
						facultyLoad, maxOverage, semester, secArray, numberOfStudentsHash, bestGene).setVisible(true);
				new DisplaySchedule(args, crsArray, facArray, studArr, degArr, degPlanArr, minFillPercent, 
						facultyLoad, maxOverage, semester, secArray, numberOfStudentsHash, bestGene);
				dispose();
				
			}
		});
		btnBack.setBounds(314, 363, 89, 23);
		contentPane.add(btnBack);
	}
}
