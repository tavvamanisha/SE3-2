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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Import frame = new Import();
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
		            // Total number of courses are saved in the int maxLength.
		        
		            br1= new BufferedReader( new FileReader(csvFile));
		            // Reading the file again to store Course values in Course Object array.
		            
		            int lineNumber=0;
		            Course[] courses = new Course[maxLength];
		            // This is the course Object Array defined as variable courses.
		            // This will have the Array of Course Objects.
		            // Each Object will contain the properties of 1 row of the Course CSV file.
		            
		            for(int i =1; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
		            
		            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
		            	String[] cols = csvFile.split(","); // Slpitting 1 row with the parameter comma (,)
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
		                List<String> faculty = Arrays.asList(cols[9]); 
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
			
				
		});
		btnImport.setBounds(98, 71, 115, 23);
		contentPane.add(btnImport);
		
		JButton btnImport_1 = new JButton("Import Faculty");
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
