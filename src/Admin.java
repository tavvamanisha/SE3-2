import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Admin extends JFrame {

	private JPanel contentPane;
	String file;
	static University[] univ;
	static GradSchools[] gradSchools;
	static Faculty[] facultyArray;
	static Degree[] degreeArray;
	static Course[] courseArray;
	static Semester[] semArray;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Admin frame = new Admin();
					frame.setVisible(true);
					
					importUniversity("TestDataUniversityName.csv");
					importGradSchools("TestDataGradSchools.csv");
					importFaculty("TestDataFaculty.csv");
					importDegrees("TestDataDegrees.csv");
					importDegreePlan("TestDataDegreePlanReq.csv");
					importCourse("TestDataCourses.csv");
					importSemesterArray("TestDataSemesters.csv");
			
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		protected static void importSemesterArray(String semesterFile) {
		
		BufferedReader br,br1; // BufferedReader is used to read a file.
		
		String csvFile = semesterFile; // Whatever the file was imported, it will be saved in this variable, csvFile.
		//System.out.println(fileUniversity);TestDataUniversityName
		int maxLength=0;
		String line;
      
		try{
            br = new BufferedReader(new FileReader(csvFile));
            // Reading the file once to get total number of Universities.
           
            while ((line = br.readLine()) != null) 
            {
                maxLength++;
            }
            // Total number of Universities are saved in the int maxLength.
        
            br1= new BufferedReader( new FileReader(csvFile));
            // Reading the file again to store University values in University Object array.
            
            int lineNumber=0;
            semArray = new Semester[maxLength];
            // This is the University Object Array defined as variable University.
            // This will have the Array of University Objects.
            // Each Object will contain the properties of 1 row of the University CSV file.
            
            for(int i =0; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
            
            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
            	
            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
                Semester sem = new Semester(); // Defining a new University object inside the for loop. 
                
                sem.setSemName(cols[0]);
                sem.setStartDate(cols[1]);
                sem.setEndDate(cols[2]);
                
                semArray[i] = sem; // Putting this newly defined University Object university in the University Object Array.
                
            }
            
            // Now to verify if the import was successfully saved in the course array.
            
            for (int j=1;j<maxLength;j++){
            	System.out.println(semArray[j].getSemName() + " " + 
            			semArray[j].getStartDate() + " " + 
                    	semArray[j].getEndDate());
            }
        
		}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

		protected static void importCourse(String courseFile) {
			
			BufferedReader br,br1; // BufferedReader is used to read a file.
			
			String csvFile = courseFile; // Whatever the file was imported, it will be saved in this variable, csvFile.
			//System.out.println(fileUniversity);
			int maxLength=0;
			String line;
	      
			try{
	            br = new BufferedReader(new FileReader(csvFile));
	            // Reading the file once to get total number of Universities.
	           
	            while ((line = br.readLine()) != null) 
	            {
	                maxLength++;
	            }
	            // Total number of Universities are saved in the int maxLength.
	        
	            br1= new BufferedReader( new FileReader(csvFile));
	            // Reading the file again to store University values in University Object array.
	            
	            int lineNumber=0;
	            courseArray = new Course[maxLength];
	            // This is the University Object Array defined as variable University.
	            // This will have the Array of University Objects.
	            // Each Object will contain the properties of 1 row of the University CSV file.
	            
	            for(int i =0; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
	            
	            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
	            	
	            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
	                Course course = new Course(); // Defining a new University object inside the for loop. 
	                
	                course.setCoursenum(cols[0]);
	                course.setCoursename(cols[1]);
	                course.setDescrip(cols[2]);
	                course.setCredithr(cols[3]);
	                course.setCapacity(cols[4]);
	                course.setFall(cols[5]);
	                course.setSpring(cols[6]);
	                course.setSummer(cols[7]);
	                course.setPrecourse(cols[8]);
	                course.setFaculty(cols[9].split(","));
	                
	                courseArray[i] = course; // Putting this newly defined University Object university in the University Object Array.
	                
	            }
	            
	            // Now to verify if the import was successfully saved in the course array.
	            
	            for (int j=1;j<maxLength;j++){
	            	System.out.println(courseArray[j].getCoursenum() + " " + 
	            			courseArray[j].getCoursename() + " " + 
	                    	courseArray[j].getDescrip() + " " + 
	                        courseArray[j].getCredithr() + " " + 
	                        courseArray[j].getCapacity() + " " + 
	                        courseArray[j].getFall() + " " + 
	                        courseArray[j].getSpring() + " " + 
	                        courseArray[j].getSummer() + " " + 
	                        courseArray[j].getPrecourse() + " " + 
	                        courseArray[j].getFaculty());
	            }
	        
			}
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}

		protected static void importDegreePlan(String degreePlanFile) {
			
			BufferedReader br,br1; // BufferedReader is used to read a file.
			
			String csvFile = degreePlanFile; // Whatever the file was imported, it will be saved in this variable, csvFile.
			//System.out.println(fileUniversity);
			int maxLength=0;
			String line;
	      
			try{
	            br = new BufferedReader(new FileReader(csvFile));
	            // Reading the file once to get total number of Universities.
	           
	            while ((line = br.readLine()) != null) 
	            {
	                maxLength++;
	            }
	            // Total number of Universities are saved in the int maxLength.
	        
	            br1= new BufferedReader( new FileReader(csvFile));
	            // Reading the file again to store University values in University Object array.
	            
	            int lineNumber=0;
	            // degreeArray = new Degree[maxLength];
	            // This is the University Object Array defined as variable University.
	            // This will have the Array of University Objects.
	            // Each Object will contain the properties of 1 row of the University CSV file.
	            
	            for(int i =0; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
	            
	            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
	            	
	            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
	            	String[] courses = cols[4].split(",");
	            	
	            	for(int j=0; j<courses.length; j++){
	            		for(int k=0;k<degreeArray.length;k++){
	            			if(cols[0].equalsIgnoreCase(degreeArray[k].getDegreeCode())){
	            				Course crs = new Course();
	            				
	            				crs.setCoursenum(courses[j]);
	            				crs.setDescrip(cols[1]);
	            				crs.setHours(cols[2]);
	            				crs.setCourseType(cols[3]);
	            				
	            				Course[] crsArray = degreeArray[k].getCourseArray();
	            				Course[] tempCrsArray;
	            				if(crsArray != null){
	            					tempCrsArray = new Course[crsArray.length + 1];
	                				
	                				for(int l=0;l<crsArray.length;l++){
	                					tempCrsArray[l]=crsArray[l];
	                				}
	                				tempCrsArray[crsArray.length] = crs;
	            				} else{
	            					tempCrsArray = new Course[1];
	            					tempCrsArray[0] = crs;
	            				}
	            				
	            				degreeArray[k].setCourseArray(tempCrsArray);
	            				
	            			}
	            		}
	            		
	            	}
	            	
	            }
	            
	            // Now to verify if the import was successfully saved in the course array.
	            
	            for (int j=1;j<degreeArray.length;j++){
	            	Course[] crsArray = degreeArray[j].getCourseArray();
	            	System.out.println(degreeArray[j].getDegreeCode());
	            	for(int k=0;k<crsArray.length;k++){
	            		System.out.println(degreeArray[j].getDegreeCode() + " " +
	            				crsArray[k].getDescrip() + " " +
	            				crsArray[k].getHours() + " " +
	            				crsArray[k].getCourseType() + " " +
	            				crsArray[k].getCoursenum());
	            	}
	            	
	            }
	        
			}
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}

		protected static void importDegrees(String degreeFile) {
			
			BufferedReader br,br1; // BufferedReader is used to read a file.
			
			String csvFile = degreeFile; // Whatever the file was imported, it will be saved in this variable, csvFile.
			//System.out.println(fileUniversity);
			int maxLength=0;
			String line;
	      
			try{
	            br = new BufferedReader(new FileReader(csvFile));
	            // Reading the file once to get total number of Universities.
	           
	            while ((line = br.readLine()) != null) 
	            {
	                maxLength++;
	            }
	            // Total number of Universities are saved in the int maxLength.
	        
	            br1= new BufferedReader( new FileReader(csvFile));
	            // Reading the file again to store University values in University Object array.
	            
	            int lineNumber=0;
	            degreeArray = new Degree[maxLength];
	            // This is the University Object Array defined as variable University.
	            // This will have the Array of University Objects.
	            // Each Object will contain the properties of 1 row of the University CSV file.
	            
	            for(int i =0; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
	            
	            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
	            	
	            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
	                Degree degree = new Degree(); // Defining a new University object inside the for loop. 
	                
	                degree.setDegreeCode(cols[0]);
	                degree.setGradSchool(cols[1]);
	                degree.setDegreeName(cols[2]);
	                degree.setForecast(cols[3]);
	                
	                degreeArray[i] = degree; // Putting this newly defined University Object university in the University Object Array.
	                
	            }
	            
	            // Now to verify if the import was successfully saved in the course array.
	            
	            for (int j=1;j<maxLength;j++){
	            	System.out.println(degreeArray[j].getDegreeCode() + " " + 
	            			degreeArray[j].getGradSchool() + " " + 
	                    	degreeArray[j].getDegreeName() + " " + 
	                        degreeArray[j].getForecast());
	            }
	        
			}
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		}

		protected static void importFaculty(String facultyFile) {
			
			BufferedReader br,br1; // BufferedReader is used to read a file.
			
			String csvFile = facultyFile; // Whatever the file was imported, it will be saved in this variable, csvFile.
			//System.out.println(fileUniversity);
			int maxLength=0;
			String line;
	      
			try{
	            br = new BufferedReader(new FileReader(csvFile));
	            // Reading the file once to get total number of Universities.
	           
	            while ((line = br.readLine()) != null) 
	            {
	                maxLength++;
	            }
	            // Total number of Universities are saved in the int maxLength.
	        
	            br1= new BufferedReader( new FileReader(csvFile));
	            // Reading the file again to store University values in University Object array.
	            
	            int lineNumber=0;
	            facultyArray = new Faculty[maxLength];
	            // This is the University Object Array defined as variable University.
	            // This will have the Array of University Objects.
	            // Each Object will contain the properties of 1 row of the University CSV file.
	            
	            for(int i =0; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
	            
	            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
	            	
	            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
	                Faculty faculty = new Faculty(); // Defining a new University object inside the for loop. 
	                
	                faculty.setLastname(cols[0]);
	                faculty.setFirstname(cols[1]);
	                faculty.setGradschool(cols[2]);
	                faculty.setDegree(cols[3]);
	                faculty.setTitle(cols[4]);
	                faculty.setDay(cols[5]);
	                faculty.setMaxfall(cols[6]);
	                faculty.setMaxspring(cols[7]);
	                faculty.setMaxsummer(cols[8]);
	                
	                facultyArray[i] = faculty; // Putting this newly defined University Object university in the University Object Array.
	                
	            }
	            
	            // Now to verify if the import was successfully saved in the course array.
	            
	            for (int j=1;j<maxLength;j++){
	            	System.out.println(facultyArray[j].getLastname() + " " + 
	            			facultyArray[j].getFirstname() + " " + 
	                    	facultyArray[j].getGradschool() + " " + 
	                        facultyArray[j].getDegree() + " " + 
	                        facultyArray[j].getTitle() + " " + 
	                        facultyArray[j].getDay() + " " + 
	                        facultyArray[j].getMaxfall() + " " + 
	                        facultyArray[j].getMaxspring() + " " + 
	                        facultyArray[j].getMaxsummer());
	            }
	        
			}
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}

		protected static void importGradSchools(String fileGradSchools) {
			BufferedReader br,br1; // BufferedReader is used to read a file.
			
			String csvFile = fileGradSchools; // Whatever the file was imported, it will be saved in this variable, csvFile.
			//System.out.println(fileUniversity);
			int maxLength=0;
			String line;
	      
			try{
	            br = new BufferedReader(new FileReader(csvFile));
	            // Reading the file once to get total number of Universities.
	           
	            while ((line = br.readLine()) != null) 
	            {
	                maxLength++;
	            }
	            // Total number of Universities are saved in the int maxLength.
	        
	            br1= new BufferedReader( new FileReader(csvFile));
	            // Reading the file again to store University values in University Object array.
	            
	            int lineNumber=0;
	            gradSchools = new GradSchools[maxLength];
	            // This is the University Object Array defined as variable University.
	            // This will have the Array of University Objects.
	            // Each Object will contain the properties of 1 row of the University CSV file.
	            
	            for(int i =0; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
	            
	            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
	            	
	            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
	                GradSchools school = new GradSchools(); // Defining a new University object inside the for loop. 
	                
	                school.setSchoolAbbr(cols[0]);
	                school.setSchoolName(cols[1]);
	                
	                gradSchools[i] = school; // Putting this newly defined University Object university in the University Object Array.
	                
	            }
	            
	            // Now to verify if the import was successfully saved in the course array.
	            
	            for (int j=1;j<maxLength;j++){
	            	System.out.println(gradSchools[j].getSchoolAbbr() + " " + 
		            univ[j].getUniversityName());
	            }
	        
			}
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}

		protected static void importUniversity(String fileUniversity) {
			
			BufferedReader br,br1; // BufferedReader is used to read a file.
			
			String csvFile = fileUniversity; // Whatever the file was imported, it will be saved in this variable, csvFile.
			//System.out.println(fileUniversity);
			int maxLength=0;
			String line;
	      
			try{
	            br = new BufferedReader(new FileReader(csvFile));
	            // Reading the file once to get total number of Universities.
	           
	            while ((line = br.readLine()) != null) 
	            {
	                maxLength++;
	            }
	            // Total number of Universities are saved in the int maxLength.
	        
	            br1= new BufferedReader( new FileReader(csvFile));
	            // Reading the file again to store University values in University Object array.
	            
	            int lineNumber=0;
	            univ = new University[maxLength];
	            // This is the University Object Array defined as variable University.
	            // This will have the Array of University Objects.
	            // Each Object will contain the properties of 1 row of the University CSV file.
	            
	            for(int i =0; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
	            
	            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
	            	
	            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
	                University university = new University(); // Defining a new University object inside the for loop. 
	                
	                university.setUniversityName(cols[0]);
	                university.setUniversityAbb(cols[1]);
	                
	                univ[i] = university; // Putting this newly defined University Object university in the University Object Array.
	                
	            }
	            
	            // Now to verify if the import was successfully saved in the course array.
	            
	            for (int j=1;j<maxLength;j++){
	            	System.out.println(univ[j].getUniversityName() + " " + 
		            univ[j].getUniversityAbb());
	            }
	        
			}
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
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
		
		JComboBox cmbRoom = new JComboBox();
		cmbRoom.setSelectedIndex(-1);
		cmbRoom.addItem("ADD");
		cmbRoom.addItem("UPDATE");
		cmbRoom.addItem("DELETE");
		//cmbRoom.setModel(new DefaultComboBoxModel(new String[] {"ADD ", "UPDATE ", "DELETE"}));
		cmbRoom.setBounds(82, 48, 130, 20);
		contentPane.add(cmbRoom);
		
		final JComboBox cmbCourse = new JComboBox();
		//cmbCourse.setModel(new DefaultComboBoxModel(new String[] {"ADD ", "UPDATE ", "DELETE"}));
		cmbCourse.setSelectedIndex(-1);
		cmbCourse.addItem("ADD");
		cmbCourse.addItem("UPDATE");
		cmbCourse.addItem("DELETE");
		
		cmbCourse.setBounds(82, 16, 130, 20);
		contentPane.add(cmbCourse);
		
		JComboBox cmbDegree = new JComboBox();
		//cmbDegree.setModel(new DefaultComboBoxModel(new String[] {"ADD ", "UPDATE ", "DELETE"}));
		cmbDegree.setSelectedIndex(-1);
		cmbDegree.addItem("ADD");
		cmbDegree.addItem("UPDATE");
		cmbDegree.addItem("DELETE");
		cmbDegree.setBounds(82, 81, 130, 20);
		contentPane.add(cmbDegree);
		
		JComboBox cmbFaculty = new JComboBox();
		//cmbFaculty.setModel(new DefaultComboBoxModel(new String[] {"ADD ", "UPDATE ", "DELETE"}));
		cmbFaculty.setSelectedIndex(-1);
		cmbFaculty.addItem("ADD");
		cmbFaculty.addItem("UPDATE");
		cmbFaculty.addItem("DELETE");
		cmbFaculty.setBounds(82, 110, 130, 20);
		contentPane.add(cmbFaculty);
		
		JComboBox cmbReport = new JComboBox();
		//cmbReport.setModel(new DefaultComboBoxModel(new String[] {"Schedule Report", "Faculty Report", "Course Report"}));
		cmbReport.addItem("Schedule Report");
		cmbReport.addItem("Faculty Report");
		cmbReport.addItem("Course Report");
		cmbReport.setBounds(82, 139, 130, 20);
		contentPane.add(cmbReport);
		
		JButton Submitroom = new JButton("Submit");
		Submitroom.setBounds(247, 47, 89, 23);
		contentPane.add(Submitroom);
		
		JButton SubmitCourse = new JButton("Submit");
		SubmitCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			{
				
				if (cmbCourse.getSelectedItem().toString().equalsIgnoreCase("add"))
				{	
						//new Course().setVisible(true);
						new Course().main(courseArray);
						
				}
				if (cmbCourse.getSelectedItem().toString().equalsIgnoreCase("update"))
				{	
						//new Course().setVisible(true);
					new Course().main(courseArray);
				}
				if (cmbCourse.getSelectedItem().toString().equalsIgnoreCase("delete"))
				{	
						//new Course().setVisible(true);
					new Course().main(courseArray);
						
				}
				
			}
			}
		});
		SubmitCourse.setBounds(247, 15, 89, 23);
		contentPane.add(SubmitCourse);
		
		JButton button_1 = new JButton("Submit");
		button_1.setBounds(247, 138, 89, 23);
		contentPane.add(button_1);
		
		JButton submitdegree = new JButton("Submit");
		submitdegree.setBounds(247, 80, 89, 23);
		contentPane.add(submitdegree);
		
		JButton button_3 = new JButton("Submit");
		button_3.setBounds(247, 109, 89, 23);
		contentPane.add(button_3);
	}
}
