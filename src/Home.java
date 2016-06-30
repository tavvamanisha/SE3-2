import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorChooserUI;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Home extends JFrame {

	private JPanel contentPane;
	static University univ;
	static GradSchools[] gradSchools;
	static Faculty[] facultyArray;
	static Degree[] degreeArray;
	static Course[] courseArray;
	//static Semester[] semArray;
	static Student[] studentArray;
	static DegreePlan[] degreePlanArray;
	static Section[] sectionArray;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Home frame = new Home(args);
					//System.out.print("sdcjkbsdacbasduhcksdnclasdcmasdnflcasefndfnkfknkdncj");
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	

	public static Section[] getSectionArray() {
		return sectionArray;
	}




	public static void setSectionArray(Section[] sectionArray) {
		Home.sectionArray = sectionArray;
	}




	public static Student[] getStudentArray() {
		return studentArray;
	}



	public static void setStudentArray(Student[] studentArray) {
		Home.studentArray = studentArray;
	}



	public static University getUniv() {
		return univ;
	}



	public static void setUniv(University univ) {
		Home.univ = univ;
	}



	public static GradSchools[] getGradSchools() {
		return gradSchools;
	}



	public static void setGradSchools(GradSchools[] gradSchools) {
		Home.gradSchools = gradSchools;
	}



	public static Faculty[] getFacultyArray() {
		return facultyArray;
	}



	public static void setFacultyArray(Faculty[] facultyArray) {
		Home.facultyArray = facultyArray;
	}



	public static Degree[] getDegreeArray() {
		return degreeArray;
	}



	public static void setDegreeArray(Degree[] degreeArray) {
		Home.degreeArray = degreeArray;
	}
	
	



	public static DegreePlan[] getDegreePlanArray() {
		return degreePlanArray;
	}



	public static void setDegreePlanArray(DegreePlan[] degreePlanArray) {
		Home.degreePlanArray = degreePlanArray;
	}



	public static Course[] getCourseArray() {
		return courseArray;
	}



	public static void setCourseArray(Course[] courseArray) {
		Home.courseArray = courseArray;
	}


	/*
	public static Semester[] getSemArray() {
		return semArray;
	}



	public static void setSemArray(Semester[] semArray) {
		Home.semArray = semArray;
	}*/
	
	
	/*protected static void importSemesterArray(String semesterFile) {
		
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
	}*/

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
	                course.setFaculty(cols[9].replaceAll("^\"|\"$", "").split(","));
	                
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
			
			/*BufferedReader br,br1; // BufferedReader is used to read a file.
			
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
	        
			}*/
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
	            degreePlanArray = new DegreePlan[maxLength];
	            // This is the University Object Array defined as variable University.
	            // This will have the Array of University Objects.
	            // Each Object will contain the properties of 1 row of the University CSV file.
	            
	            for(int i =0; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
	            
	            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
	            	
	            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
	                DegreePlan degreePlan = new DegreePlan(); // Defining a new University object inside the for loop. 
	                
	                degreePlan.setDegreeCode(cols[0]);
	                degreePlan.setDescription(cols[1]);
	                degreePlan.setHours(cols[2]);
	                degreePlan.setType(cols[3]);
	                degreePlan.setCourses(cols[4]);
	                
	                degreePlanArray[i] = degreePlan; // Putting this newly defined University Object university in the University Object Array.
	                
	            }
	            
	            // Now to verify if the import was successfully saved in the course array.
	            
	            for (int j=1;j<maxLength;j++){
	            	System.out.println(
	            			degreePlanArray[j].getDegreeCode()+
	            			degreePlanArray[j].getDescription()+
	            			degreePlanArray[j].getHours()+
	            			degreePlanArray[j].getDescription()+
	            			degreePlanArray[j].getCourses());
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
		            univ.getUniversityName());
	            }
	        
			}
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}

		protected static void importUniversity(String fileUniversity) {
			
			BufferedReader br1; // BufferedReader is used to read a file.
			
			String csvFile = fileUniversity; // Whatever the file was imported, it will be saved in this variable, csvFile.
			try{
	            br1= new BufferedReader( new FileReader(csvFile));
	            // Reading the file again to store University values in University Object array.
	            
	            csvFile = br1.readLine(); // Reading 1 row of the CSV file.
	            csvFile = br1.readLine(); // Reading 1 row of the CSV file.
	            	
            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
                System.out.println(cols[0]);
                University university = new University();
                university.setUniversityName(cols[0]);
                university.setUniversityAbb(cols[1]);
                
                univ = university;
                
                // Now to verify if the import was successfully saved in the course array.
	            
	            System.out.println(univ.getUniversityName() + " " + 
		            univ.getUniversityAbb());

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
	@SuppressWarnings("deprecation")
	public Home(final String[] args) {
		if(args[0] == "1"){
			importUniversity("TestDataUniversityName.csv");
			//importGradSchools("TestDataGradSchools.csv");
			importFaculty("TestDataFaculty.csv");
			importDegrees("TestDataDegrees.csv");			// Forecast
			importDegreePlan("TestDataDegreePlanReq.csv");	// Degree
			importCourse("TestDataCourses.csv");
			//importSemesterArray("TestDataSemesters.csv");
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 480);
		
		JMenuBar mainmenubar = new JMenuBar();
		mainmenubar.setToolTipText("");
		setJMenuBar(mainmenubar);

		
		JMenu mmMaintainence = new JMenu("Maintainence");
		mainmenubar.add(mmMaintainence);
		
		JMenuItem mmtmUniv = new JMenuItem("University");
		mmtmUniv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new University1(univ,args).setVisible(true);
				setVisible(false);
				//University1 frame = new University1();
			}
		});
		mmMaintainence.add(mmtmUniv);
		
		JMenuItem mntmDegree = new JMenuItem("Degree");
		mntmDegree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisplayDegree(degreePlanArray,args).setVisible(true);
				new DisplayDegree(degreePlanArray,args);
				setVisible(false);
				dispose();
			}
		});
		mmMaintainence.add(mntmDegree);
		
		
		JMenuItem mntmCourses = new JMenuItem("Courses");
		mntmCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisplayCourses(courseArray,args).setVisible(true);
				new DisplayCourses(courseArray,args);
				setVisible(false);
				dispose();
			}
		});
		mmMaintainence.add(mntmCourses);
		
		JMenuItem mntmForecast = new JMenuItem("Forecast");
		if(args[1].equalsIgnoreCase("A")){
			mntmForecast.setEnabled(false);
		}else if(args[1].equalsIgnoreCase("D")){
			mntmForecast.setEnabled(true);
		}
		mntmForecast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisplayForecast(degreeArray,args).setVisible(true);
				new DisplayForecast(degreeArray,args);
				setVisible(false);
				dispose();
			}
		});
		mmMaintainence.add(mntmForecast);
		
		JMenuItem mntmFaculty = new JMenuItem("Faculty");
		mntmFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisplayFaculty(facultyArray,args).setVisible(true);
				new DisplayFaculty(facultyArray,args);
				setVisible(false);
				dispose();
			}
		});
		
		mmMaintainence.add(mntmFaculty);
		
		JMenu mnImport = new JMenu("Import");
		mainmenubar.add(mnImport);
		
		JMenuItem mntmStudent = new JMenuItem("Student");
		mntmStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Import(args).setVisible(true);
				new Import(args);
				setVisible(false);
				dispose();
			}
		});
		mnImport.add(mntmStudent);
		
		JMenuItem mntmCourse = new JMenuItem("Course");
		mntmCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(studentArray == null){
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Please import Student List first.");
				} else{
					new ImportCourse(studentArray, args).setVisible(true);
					new ImportCourse(studentArray, args);
					setVisible(false);
					dispose();
				}
				
			}
		});
		mnImport.add(mntmCourse);
		
		JMenu mnReport = new JMenu("Report");
		mainmenubar.add(mnReport);
		
		JMenu mnSchedule_Report = new JMenu("Schedule Report");
		mnReport.add(mnSchedule_Report);
		
		JMenuItem mntmSection_Report = new JMenuItem("Section Report");
		mntmSection_Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(studentArray == null){
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Please Generate the Schedule first.");
				} else{
					new Section_Report(args, sectionArray).setVisible(true);
					new Section_Report(args, sectionArray);
					dispose();
				}
				
			}
		});
		mnSchedule_Report.add(mntmSection_Report);
		
		JMenuItem mntmFaculty_Report = new JMenuItem("Faculty Report");
		mntmFaculty_Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(studentArray == null){
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Please Generate the Schedule first.");
				} else{
					new Faculty_Report(args, sectionArray, facultyArray).setVisible(true);
					new Faculty_Report(args, sectionArray, facultyArray);
					dispose();
				}
				
			}
		});
		mnSchedule_Report.add(mntmFaculty_Report);
		
		JMenu mnStudentReport = new JMenu("Student Report");
		mnReport.add(mnStudentReport);
		
		JMenuItem mntmDegreeReport = new JMenuItem("Degree Report");
		
		mntmDegreeReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(studentArray == null){
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Please import Student List first.");
				} else{
					new Degree_Report(args,studentArray, degreeArray).setVisible(true);
					new Degree_Report(args,studentArray, degreeArray);
					dispose();
				}

			}
		});
		
		mnStudentReport.add(mntmDegreeReport);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Student Report");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(studentArray == null){
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Please Generate the Schedule first.");
				} else{
					new Student_Enroll(args, studentArray, sectionArray, degreePlanArray).setVisible(true);
					new Student_Enroll(args, studentArray, sectionArray, degreePlanArray);
					dispose();
				}


				
			}
		});
		mnStudentReport.add(mntmNewMenuItem);
		if(args[1].equalsIgnoreCase("A")){
			mntmNewMenuItem.setEnabled(false);
		}else if(args[1].equalsIgnoreCase("D")){
			mntmNewMenuItem.setEnabled(true);
		}
		
		
		JMenu mnNewMenu = new JMenu("Schedule");
		mainmenubar.add(mnNewMenu);
		
		JMenuItem mntmGenerateSchedule = new JMenuItem("Generate Schedule ");
		mntmGenerateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GenerateSchedule(args,studentArray, degreeArray, degreePlanArray, courseArray, facultyArray).setVisible(true);
				new GenerateSchedule(args,studentArray, degreeArray, degreePlanArray, courseArray, facultyArray);
				setVisible(false);
				dispose();
			}
		});
		mnNewMenu.add(mntmGenerateSchedule);
		
		JMenu mnSystem = new JMenu("System");
		mainmenubar.add(mnSystem);
		
		JMenuItem mntmAddUser = new JMenuItem("Add User");
		mntmAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DisplayUser(args).setVisible(true);
				new DisplayUser(args);
				setVisible(false);
				dispose();
			}
		});
		mnSystem.add(mntmAddUser);
		if(args[1].equalsIgnoreCase("A")){
			mntmAddUser.setEnabled(false);
		}else if(args[1].equalsIgnoreCase("D")){
			mntmAddUser.setEnabled(true);
		}
		
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Groups");
		mntmNewMenuItem_1.setEnabled(false);
		mnSystem.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.disable();
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnSystem.add(mntmLogout);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblUnivName = new JLabel(univ.getUniversityName());
		lblUnivName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUnivName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUnivName, BorderLayout.CENTER);
		
	}

}
