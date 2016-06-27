import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Course extends JFrame {

	private JPanel contentPane;
	private JTextField txtcoursenum;
	private JTextField txtdescrip;
	private JTextField txtcoursename;
	private JTextField txtPrecourse;
	private JTextField txtcredit;
	private JTextField txtcapacity;
	String coursenum;
	String coursename;
	String capacity;
	String credithr;
	String fall;
	String summer;
	String spring;
	String descrip;
	String precourse;
	String[] faculty;
	Course[] courses;
	int numberOfStudent=0;
	
	static Course[] courseArray;
	String courseType;
	String hours;
	String formpage;
	int Len;
	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(final Course[] courseArray1) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		
					Course frame = new Course();
					frame.setVisible(true);
					courseArray = courseArray1;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void importCourse(String file){
		
		BufferedReader br,br1; // BufferedReader is used to read a file.
		
		String csvFile = file; // Whatever the file was imported, it will be saved in this variable, csvFile.
		System.out.println(file);
		int maxLength=0;
		String line;
      
		try{
            br = new BufferedReader(new FileReader(csvFile));
            // Reading the file once to get total number of courses.
           
            while ((line = br.readLine()) != null) 
            {
                maxLength++;
            }
        Len  = maxLength;     // Total number of courses are saved in the int maxLength.
        
            br1= new BufferedReader( new FileReader(csvFile));
            // Reading the file again to store Course values in Course Object array.
            
            int lineNumber=0;
            courses = new Course[maxLength];
            // This is the course Object Array defined as variable courses.
            // This will have the Array of Course Objects.
            // Each Object will contain the properties of 1 row of the Course CSV file.
            
            for(int i =0; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
            
            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
                Course crs = new Course(); // Defining a new Course object inside the for loop. 
                
                crs.setCoursenum(cols[0]); // Setting 1st element of the CSV file in CourseNum.
                crs.setCoursename(cols[1]); // Similarly for all the parameters which are in the CSV file.
                crs.setDescrip(cols[2]);
                crs.setCredithr(cols[3]);
                crs.setCapacity(cols[4]);
                crs.setFall(cols[5]);
                crs.setSpring(cols[6]);
                crs.setSummer(cols[7]);
                crs.setPrecourse(cols[8]);
                String[] faculty = cols[9].replaceAll("^\"|\"$", "").split(","); 
                crs.setFaculty(faculty);
                
                courses[i] = crs; // Putting this newly defined Course Object crs in the Courses Object Array.
                
            }
            
            // Now to verify if the import was successfully saved in the course array.
            
            for (int j=1;j<maxLength;j++){
            	System.out.println(courses[j].getCoursenum() + " " + 
	            courses[j].getCoursename() + " " +
	            courses[j].getDescrip() + " " +
	            courses[j].getCredithr() + " " +
	            courses[j].getCapacity() + " " +
	            courses[j].getFall() + " " +
	            courses[j].getSpring() + " " +
	            courses[j].getSummer() + " " +
	            courses[j].getPrecourse() + " " +
	            courses[j].getFaculty());
            }
        
		}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	public int getNumberOfStudent() {
		return numberOfStudent;
	}

	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}

	public String[] getFaculty() {
		return faculty;
	}



	public void setFaculty(String[] faculty) {
		this.faculty = faculty;
	}



	public String getCoursenum() {
		return coursenum;
	}


	public void setCoursenum(String coursenum) {
		this.coursenum = coursenum;
	}
	
	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getCoursename() {
		return coursename;
	}


	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCapacity() {
		return capacity;
	}


	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}


	public String getCredithr() {
		return credithr;
	}


	public void setCredithr(String credithr) {
		this.credithr = credithr;
	}


	public String getFall() {
		return fall;
	}


	public void setFall(String fall) {
		this.fall = fall;
	}


	public String getSummer() {
		return summer;
	}


	public void setSummer(String summer) {
		this.summer = summer;
	}


	public String getSpring() {
		return spring;
	}


	public void setSpring(String spring) {
		this.spring = spring;
	}


	public String getDescrip() {
		return descrip;
	}


	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}


	public String getPrecourse() {
		return precourse;
	}


	public void setPrecourse(String precourse) {
		this.precourse = precourse;
	}


	/**
	 * Create the frame.
	 */
	public Course() {
		setTitle("Course");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseNumber = new JLabel("Course Number");
		lblCourseNumber.setBounds(35, 11, 98, 14);
		contentPane.add(lblCourseNumber);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(35, 45, 78, 14);
		contentPane.add(lblCourseName);
		
		JLabel lblCreditHours = new JLabel("Credit Hours");
		lblCreditHours.setBounds(35, 111, 86, 14);
		contentPane.add(lblCreditHours);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(344, 11, 78, 14);
		contentPane.add(lblDescription);
		
		JLabel lblPrerequisiteCourse = new JLabel("Prerequisite Course");
		lblPrerequisiteCourse.setBounds(35, 80, 117, 14);
		contentPane.add(lblPrerequisiteCourse);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(344, 98, 58, 14);
		contentPane.add(lblSemester);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(35, 148, 78, 14);
		contentPane.add(lblCapacity);
		
		txtcoursenum = new JTextField();
		txtcoursenum.setBounds(179, 11, 117, 20);
		contentPane.add(txtcoursenum);
		txtcoursenum.setColumns(10);
		
		
		
		txtdescrip = new JTextField();
		txtdescrip.setBounds(416, 11, 154, 63);
		contentPane.add(txtdescrip);
		txtdescrip.setColumns(10);
		
		txtcoursename = new JTextField();
		txtcoursename.setBounds(179, 42, 117, 20);
		contentPane.add(txtcoursename);
		txtcoursename.setColumns(10);
		
		txtPrecourse = new JTextField();
		txtPrecourse.setBounds(177, 77, 119, 20);
		contentPane.add(txtPrecourse);
		txtPrecourse.setColumns(10);
		
		txtcredit = new JTextField();
		txtcredit.setBounds(178, 108, 118, 20);
		contentPane.add(txtcredit);
		txtcredit.setColumns(10);
		
		txtcapacity = new JTextField();
		txtcapacity.setBounds(179, 145, 117, 20);
		contentPane.add(txtcapacity);
		txtcapacity.setColumns(10);
		
		final JCheckBox chckbxspring = new JCheckBox("Spring");
		chckbxspring.setBounds(406, 94, 97, 23);
		contentPane.add(chckbxspring);
		
		final JCheckBox chckbxfall = new JCheckBox("Fall");
		chckbxfall.setBounds(406, 120, 97, 23);
		contentPane.add(chckbxfall);
		
		final JCheckBox chckbxsummer = new JCheckBox("Summer");
		chckbxsummer.setBounds(406, 147, 97, 23);
		contentPane.add(chckbxsummer);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String courseNum = txtcoursenum.getText();
				String courseName = txtcoursename.getText();
				String capacity = txtcapacity.getText();
				String credit = txtcredit.getText();
				String description = txtdescrip.getText();
				String preRequisits = txtPrecourse.getText();
				boolean chkFall = chckbxfall.isSelected();
				boolean chkSpring = chckbxspring.isSelected();
				boolean chkSummer = chckbxsummer.isSelected();
				
				Course crs = new Course();
				crs.setCoursename(courseName);
				crs.setCoursenum(courseNum);
				crs.setCapacity(capacity);
				crs.setCredithr(credit);
				crs.setDescrip(description);
				crs.setPrecourse(preRequisits);
				if(chkFall)crs.setFall("Y"); else crs.setFall("N");
				if(chkSpring)crs.setSpring("Y"); else crs.setSpring("N");
				if(chkSummer)crs.setSummer("Y"); else crs.setSummer("N");
				
				int i = courseArray.length;
				Course[] tempCourses = courseArray;
				courseArray = new Course[i+1];
				
				for(int j=0;j<tempCourses.length;j++){
					courseArray[j] = tempCourses[j];
				}
				courseArray[i] = crs;
				
				for (int j=0;j<courseArray.length;j++){
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
				
				JFrame parent = new JFrame();
		        JOptionPane.showMessageDialog(parent,"Course Added successfully.");
		        
		        Admin admin = new Admin();
		        admin.setCourseArray(courseArray);
		        String[] str = new String[1];
		        str[0] = "0";
		        admin.main(str);
				
			}
		});
		btnAdd.setBounds(35, 212, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 
				String number = txtcoursenum.getText();
				int count=0;
				
				for(int m=0;m<courseArray.length;m++)
				{					
					if(number.equalsIgnoreCase(courseArray[m].getCoursenum())){
						txtcoursename.setText(courseArray[m].getCoursename());
						txtcapacity.setText(courseArray[m].getCapacity());
						txtcredit.setText(courseArray[m].getCredithr());
						txtdescrip.setText(courseArray[m].getDescrip());
						txtPrecourse.setText(courseArray[m].getPrecourse());
						chckbxfall.setSelected(("Y").equalsIgnoreCase(courseArray[m].getFall()));
						chckbxspring.setSelected("Y".equalsIgnoreCase(courseArray[m].getSpring()));
						chckbxsummer.setSelected(("Y").equalsIgnoreCase(courseArray[m].getSummer()));
						count++;
					}
				}	
				if(count == 0){
					txtcoursename.setText(null);
					txtcapacity.setText(null);
					txtcredit.setText(null);
					txtdescrip.setText(null);
					txtPrecourse.setText(null);
					chckbxfall.setSelected(false);
					chckbxspring.setSelected(false);
					chckbxsummer.setSelected(false);
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Course Not found.");
				}
			}
		});
		btnSearch.setBounds(157, 212, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = txtcoursenum.getText();
				int m;
				for(m=0;m<courseArray.length;m++)
				{					
					if(number.equalsIgnoreCase(courseArray[m].getCoursenum())){
						/*txtcoursename.setText(courseArray[m].getCoursename());
						txtcapacity.setText(courseArray[m].getCapacity());
						txtcredit.setText(courseArray[m].getCredithr());
						txtdescrip.setText(courseArray[m].getDescrip());
						txtPrecourse.setText(courseArray[m].getPrecourse());
						chckbxfall.setSelected(("Y").equalsIgnoreCase(courseArray[m].getFall()));
						chckbxspring.setSelected("Y".equalsIgnoreCase(courseArray[m].getSpring()));
						chckbxsummer.setSelected(("Y").equalsIgnoreCase(courseArray[m].getSummer()));*/
						break;
					}
				}
				
				for(int n=m;n<courseArray.length-1;n++){
					courseArray[n] = courseArray[n+1];
				}
				
				Course[] tempCourse = new Course[courseArray.length - 1];
			    for(int o=0;o<tempCourse.length;o++){
			    	tempCourse[o]=courseArray[o];
			    }
				courseArray = tempCourse;
				
				txtcoursename.setText(null);
				txtcapacity.setText(null);
				txtcredit.setText(null);
				txtdescrip.setText(null);
				txtPrecourse.setText(null);
				chckbxfall.setSelected(false);
				chckbxspring.setSelected(false);
				chckbxsummer.setSelected(false);
				
				JFrame parent = new JFrame();
		        JOptionPane.showMessageDialog(parent,"Course deleted successfully.");
				
				for (int j=0;j<courseArray.length;j++){
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
				
				Admin admin = new Admin();
		        admin.setCourseArray(courseArray);
		        String[] str = new String[1];
		        str[0] = "0";
		        admin.main(str);
				
				
			    
			}
		});
		btnDelete.setBounds(393, 212, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnupdate = new JButton("UPDATE");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = txtcoursenum.getText();
				String name = txtcoursename.getText();
				String capacity = txtcapacity.getText();
				String hours = txtcredit.getText();
				String descrip = txtdescrip.getText();
				String precourse = txtPrecourse.getText();
				boolean fall = chckbxfall.isSelected();
				boolean spring = chckbxspring.isSelected();
				boolean summer = chckbxsummer.isSelected();
				int count = 0;
				System.out.println("-----------------------------------------------"+fall);
				for(int m=0;m<courseArray.length;m++)
				{					
					if(number.equalsIgnoreCase(courseArray[m].getCoursenum())){
						courseArray[m].setCoursename(name);
						courseArray[m].setCapacity(capacity);
						courseArray[m].setCredithr(hours);
						courseArray[m].setDescrip(descrip);
						courseArray[m].setPrecourse(precourse);
						String fall1;
						if(fall) fall1 = "Y";
						else fall1 = "N";
						courseArray[m].setFall(fall1);
						String summer1;
						if(summer) summer1 = "Y";
						else summer1 = "N";
						courseArray[m].setSummer(summer1);
						String spring1;
						if(spring) spring1 = "Y";
						else spring1 = "N";
						courseArray[m].setSpring(spring1);
						
						count++;
					} 
					
				}
				if (count == 0){
					JFrame parent = new JFrame();
			        JOptionPane.showMessageDialog(parent,"Course not found.");
				}
				
				for (int j=0;j<courseArray.length;j++){
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
				
				JFrame parent = new JFrame();
		        JOptionPane.showMessageDialog(parent,"Course Updated successfully.");
		        
		        Admin admin = new Admin();
		        admin.setCourseArray(courseArray);
		        String[] str = new String[1];
		        str[0] = "0";
		        admin.main(str);
				
			}
		});
		btnupdate.setBounds(273, 212, 89, 23);
		contentPane.add(btnupdate);
	}
}
