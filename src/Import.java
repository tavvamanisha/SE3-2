import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class Import extends JFrame {

	private JPanel contentPane;
	private JTextField txtFilePath;
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
					Import frame = new Import();
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
	public Import() {
		setTitle("Import File");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFilePath = new JTextField();
		txtFilePath.setBounds(48, 27, 320, 23);
		contentPane.add(txtFilePath);
		txtFilePath.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("Browse the folder to process");
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			   			    chooser.setAcceptAllFileFilterUsed(false);
			   

			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			       // System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
			        //System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
			        file = chooser.getSelectedFile().getPath();
        
			            String fileExtenstion = file.substring(file.lastIndexOf(".") + 1,file.length());
			            if("csv".equals(fileExtenstion)){
			            String csvFile = file;	
			            txtFilePath.setText(file);
			            } else {
					       // System.out.println("No Selection ");
			            	JFrame parent = new JFrame();
					        JOptionPane.showMessageDialog(parent,"File not supported");
					    }
			             		        		      
			    }
			}
		});
		btnBrowse.setBounds(415, 27, 89, 23);
		contentPane.add(btnBrowse);
	
		
		JButton btnImport = new JButton("Import Course");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// from here the action starts.
				Course crs = new Course();
				crs.importCourse(file);
		    }   
			
				
		});
		btnImport.setBounds(98, 71, 115, 23);
		contentPane.add(btnImport);
		
		JButton btnImport_1 = new JButton("Import Faculty");
		btnImport_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Faculty fac = new Faculty();
			fac.importFaculty(file);
				
			}
		});
		btnImport_1.setBounds(237, 71, 115, 23);
		contentPane.add(btnImport_1);
		
		JButton btnNewButton = new JButton("Import Degree");
		btnNewButton.setBounds(237, 118, 115, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Import Student");
		btnNewButton_1.setBounds(98, 118, 115, 23);
		contentPane.add(btnNewButton_1);
	}

}
