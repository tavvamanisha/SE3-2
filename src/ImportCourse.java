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

public class ImportCourse extends JFrame {

	private JPanel contentPane;
	private JTextField txtFilePath;
	String file;
	
	static Student[] studentArray;
	
	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportCourse frame = new ImportCourse(null, args);
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
	public ImportCourse(Student[] stud, final String[] args) {
		
		studentArray = stud; 
		setTitle("Import Students Courses");
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
	
		
		JButton btnImport = new JButton("Import Student Courses");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// from here the action starts.
				BufferedReader br,br1; // BufferedReader is used to read a file.
				
				String csvFile = file; // Whatever the file was imported, it will be saved in this variable, csvFile.
				int maxLength=0;
				String line;
		      
				try{
					
					if(file == null){
						JFrame parent = new JFrame();
				        JOptionPane.showMessageDialog(parent,"Please select a file to Upload.");
					} else {
						br = new BufferedReader(new FileReader(csvFile));
			            // Reading the file once to get total number of courses.
			           
			            while ((line = br.readLine()) != null) 
			            {
			                maxLength++;
			            }
			            
			            br1= new BufferedReader( new FileReader(csvFile));
			            // Reading the file again to store Course values in Course Object array.
			            
			            //studentArray = new Student[maxLength];
			            // This is the course Object Array defined as variable courses.
			            // This will have the Array of Course Objects.
			            // Each Object will contain the properties of 1 row of the Course CSV file.
			            
			            for(int i =0; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
			            
			            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
			            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
			                Student stud = new Student(); // Defining a new Course object inside the for loop. 
			                
			                for(int j=0;j<studentArray.length;j++){
			                	if(studentArray[j].getRollNo().equalsIgnoreCase(cols[0])){
			                		String[] num = studentArray[j].getCourseNum();
			                		String[] name = studentArray[j].getCourseName();
			                		String[] crsSem = studentArray[j].getCourseSemester();
			                		String[] grade = studentArray[j].getGrade();
			                		
			                		if(num == null){
			                			num = new String[1]; 
			                			name = new String[1];
			                			crsSem = new String[1];
			                			grade = new String[1];
			                			
			                			num[0] = cols[1];
	                					name[0] = cols[2];
	                					crsSem[0] = cols[3];
	                					grade[0] = cols[4];
	                					
	                					studentArray[j].setCourseNum(num);
	                					studentArray[j].setCourseName(name);
	                					studentArray[j].setCourseSemester(crsSem);
	                					studentArray[j].setGrade(grade);
			                		}else{
			                			String[] num1 = new String[num.length+1];
			                			String[] name1 = new String[name.length + 1];
			                			String[] crsSem1 = new String[crsSem.length + 1];
			                			String[] grade1 = new String[grade.length + 1];
			                			
			                			for(int k=0;k<num.length;k++){
			                				num1[k]=num[k];
			                				name1[k]=name[k];
			                				crsSem1[k]=crsSem[k];
			                				grade1[k]=grade[k];
			                			}
			                			num1[num.length]=cols[1];
			                			name1[num.length]=cols[2];
			                			crsSem1[num.length]=cols[3];
			                			grade1[num.length]=cols[4];
			                			
			                			studentArray[j].setCourseNum(num1);
	                					studentArray[j].setCourseName(name1);
	                					studentArray[j].setCourseSemester(crsSem1);
	                					studentArray[j].setGrade(grade1);
	                					
			                		}
			                		
			                		
			                	}
			                }
			                
			            }
			            
			            // Now to verify if the import was successfully saved in the course array.
			            
			            for (int j=1;j<studentArray.length;j++){
			            	System.out.println(studentArray[j].getRollNo() + " " + 
				            studentArray[j].getDegree() + " " +
				            studentArray[j].getSemester() + " "+
				            studentArray[j].getCourseNum() + " "+
				            studentArray[j].getCourseName() + " "+
				            studentArray[j].getCourseSemester() + " "+
				            studentArray[j].getGrade());
			            }
			            
			            
			            JFrame parent = new JFrame();
				        JOptionPane.showMessageDialog(parent,"Student Course File imported succesfully.");
						
				        args[0]="0";
						new Home(args).setVisible(true);
						new Home(args).setStudentArray(studentArray);
						setVisible(false);
						dispose();
					}
		            
				}
		        catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
		    }   
			
		});
		btnImport.setBounds(192, 123, 170, 23);
		contentPane.add(btnImport);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				args[0]="0";
				new Home(args).setVisible(true);
				//new Home(args).setCourseArray(courseArray);
				new Home(args);
				dispose();
			}
		});
		btnBack.setBounds(66, 123, 89, 23);
		contentPane.add(btnBack);
	
		
	}

}
