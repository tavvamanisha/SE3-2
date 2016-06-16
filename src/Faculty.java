import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Faculty extends JFrame {

	private JPanel contentPane;
	private JTextField txtfirst;
	Faculty[] faculty1;
	private JTextField txttitle;
	private JTextField txtlast;
	Course objcourses;
	private JTextField txtDegree;
	private JTextField txtGrad;
	private JTextField txtFall;
	private JTextField txtSumm;
	private JTextField txtSpr;
	String firstname;
	String lastname;
	String title;
	String gradschool;
	String maxfall;
	String maxsummer;
	String maxspring;
	String day;
	String degree;
	
	private JTextField txtday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Faculty frame = new Faculty();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGradschool() {
		return gradschool;
	}
	public void setGradschool(String gradschool) {
		this.gradschool = gradschool;
	}
	public String getMaxfall() {
		return maxfall;
	}
	public void setMaxfall(String maxfall) {
		this.maxfall = maxfall;
	}
	public String getMaxsummer() {
		return maxsummer;
	}
	public void setMaxsummer(String maxsummer) {
		this.maxsummer = maxsummer;
	}
	public String getMaxspring() {
		return maxspring;
	}
	public void setMaxspring(String maxspring) {
		this.maxspring = maxspring;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
public void importFaculty(String file){
		
		BufferedReader br,br1; // BufferedReader is used to read a file.
		
		String csvFile = file; // Whatever the file was imported, it will be saved in this variable, csvFile.
		System.out.println(file);
		int maxLength=0;
		String line;
      
		try{
            br = new BufferedReader(new FileReader(csvFile));
            // Reading the file once to get total number of faculty.
           
            while ((line = br.readLine()) != null) 
            {
                maxLength++;
            }
            // Total number of faculty are saved in the maxLength.
        
            br1= new BufferedReader( new FileReader(csvFile));
            // Reading the file again to store faculty in Faculty Object array.
             
            int lineNumber=0;
           
            faculty1 = new Faculty[maxLength];
            // This is the Faculty Object Array defined as variable faculty1.
            // This will have the Array of Faculty Objects.
            // Each Object will contain the properties of 1 row of the Faculty CSV file.
            
            for(int i =0; i<maxLength; i++){ // Iterating through all the rows of the CSV file.
            
            	csvFile = br1.readLine(); // Reading 1 row of the CSV file.
            	String[] cols = csvFile.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Slpitting 1 row with the parameter comma (,)
                Faculty fac = new Faculty(); // Defining a new Faculty object inside the for loop. 
                
                fac.setLastname(cols[0]); // Setting 1st element of the CSV file in lastname.
                fac.setFirstname(cols[1]); // Similarly for all the parameters which are in the CSV file.
                fac.setGradschool(cols[2]);
                fac.setDegree(cols[3]);
                fac.setTitle(cols[4]);
                fac.setDay(cols[5]);
                fac.setMaxfall(cols[6]);
                fac.setMaxspring(cols[7]);
                fac.setMaxsummer(cols[8]);
               
                
                
                faculty1[i] = fac; // Putting this newly defined Faculty Object faculty1 in the Faculty Object Array.
                
            }
            
            // Now to verify if the import was successfully saved in the faculty array.
            
            for (int j=1;j<maxLength;j++){
            	System.out.println(faculty1[j].getLastname() + " " + 
	            faculty1[j].getFirstname() + " " +
	            faculty1[j].getGradschool() + " " +
	            faculty1[j].getDegree() + " " +
	            faculty1[j].getTitle() + " " +
	            faculty1[j].getDay()+ " " +
	            faculty1[j].getMaxfall() + " " +
	            faculty1[j].getMaxspring()+ " " +
	            faculty1[j].getMaxsummer() );
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
	public Faculty() {
		setTitle("Faculty");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFacultyName = new JLabel("FirstName");
		lblFacultyName.setBounds(32, 53, 113, 14);
		contentPane.add(lblFacultyName);
		
		txtfirst = new JTextField();
		txtfirst.setBounds(116, 50, 124, 20);
		contentPane.add(txtfirst);
		txtfirst.setColumns(10);
		
		
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setBounds(264, 53, 46, 14);
		contentPane.add(lblDays);
		
		JButton button = new JButton("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//importFaculty("F:/Freelancer/SE1/TestData/TestDataFaculty.csv");
				
				String  firstname = txtfirst.getText();
				String lastname = txtlast.getText();
				String title = txttitle.getText();
				String day = txtday.getText();
				String degree = txtDegree.getText();
				String fall = txtFall.getText();
				String spring = txtSpr.getText();
				String summer = txtSumm.getText();
				String gradschool = txtGrad.getText();
				
				Faculty fac1 = new Faculty();
				fac1.setFirstname(firstname);
				fac1.setLastname(lastname);
				fac1.setTitle(title);
				fac1.setDay(day);
				fac1.setDegree(degree);
				fac1.setGradschool(gradschool);
				fac1.setMaxfall(fall);
				fac1.setMaxsummer(summer);
				fac1.setMaxspring(spring);
				
				int i = faculty1.length;
				Faculty[] tempfaculty= faculty1;
				faculty1 = new Faculty[i+1];
				
				for(int j=0;j<i;j++){
					faculty1[j] = tempfaculty[j];
				}
				faculty1[i] = fac1;
				
				for (int j=0;j<i+1;j++){
	            	System.out.println(faculty1[j].getLastname() + " " + 
		            faculty1[j].getFirstname() + " " +
		            faculty1[j].getGradschool() + " " +
		            faculty1[j].getDegree() + " " +
		            faculty1[j].getTitle() + " " +
		            faculty1[j].getDay()+ " " +
		            faculty1[j].getMaxfall() + " " +
		            faculty1[j].getMaxspring()+ " " +
		            faculty1[j].getMaxsummer());
				}
				
				
			}
		});

		button.setBounds(81, 200, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("UPDATE");
		button_1.setBounds(204, 200, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("DELETE");
		button_2.setBounds(314, 200, 89, 23);
		contentPane.add(button_2);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(32, 22, 46, 14);
		contentPane.add(lblTitle);
		
		txttitle = new JTextField();
		txttitle.setColumns(10);
		txttitle.setBounds(116, 19, 124, 20);
		contentPane.add(txttitle);
		
		JLabel lblLastname = new JLabel("LastName");
		lblLastname.setBounds(264, 22, 113, 14);
		contentPane.add(lblLastname);
		
		txtlast = new JTextField();
		txtlast.setColumns(10);
		txtlast.setBounds(383, 19, 123, 20);
		contentPane.add(txtlast);
		
		JLabel lblNewLabel_1 = new JLabel("GradSchool");
		lblNewLabel_1.setBounds(32, 87, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		txtDegree = new JTextField();
		txtDegree.setColumns(10);
		txtDegree.setBounds(382, 84, 124, 20);
		contentPane.add(txtDegree);
		
		JLabel lblDegree = new JLabel("Degree");
		lblDegree.setBounds(264, 87, 97, 14);
		contentPane.add(lblDegree);
		
		txtGrad = new JTextField();
		txtGrad.setColumns(10);
		txtGrad.setBounds(116, 84, 124, 20);
		contentPane.add(txtGrad);
		
		JLabel lblFallmaxload = new JLabel("FallMax_Load");
		lblFallmaxload.setBounds(32, 118, 97, 14);
		contentPane.add(lblFallmaxload);
		
		txtFall = new JTextField();
		txtFall.setColumns(10);
		txtFall.setBounds(116, 115, 124, 20);
		contentPane.add(txtFall);
		
		JLabel lblSummermaxload = new JLabel("SummMax_Load");
		lblSummermaxload.setBounds(264, 118, 113, 14);
		contentPane.add(lblSummermaxload);
		
		txtSumm = new JTextField();
		txtSumm.setColumns(10);
		txtSumm.setBounds(383, 115, 123, 20);
		contentPane.add(txtSumm);
		
		JLabel lblSprmaxload = new JLabel("SprMax_Load");
		lblSprmaxload.setBounds(32, 150, 97, 14);
		contentPane.add(lblSprmaxload);
		
		txtSpr = new JTextField();
		txtSpr.setColumns(10);
		txtSpr.setBounds(116, 146, 124, 20);
		contentPane.add(txtSpr);
		
		txtday = new JTextField();
		txtday.setBounds(383, 50, 123, 20);
		contentPane.add(txtday);
		txtday.setColumns(10);
	}
}
