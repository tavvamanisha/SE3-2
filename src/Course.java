import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

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
	List<String> faculty;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course frame = new Course();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public List<String> getFaculty() {
		return faculty;
	}



	public void setFaculty(List<String> faculty) {
		this.faculty = faculty;
	}



	public String getCoursenum() {
		return coursenum;
	}


	public void setCoursenum(String coursenum) {
		this.coursenum = coursenum;
	}


	public String getCoursename() {
		return coursename;
	}


	public void setCoursename(String coursename) {
		this.coursename = coursename;
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
		
		JCheckBox chckbxspring = new JCheckBox("Spring");
		chckbxspring.setBounds(406, 94, 97, 23);
		contentPane.add(chckbxspring);
		
		JCheckBox chckbxfall = new JCheckBox("Fall");
		chckbxfall.setBounds(406, 120, 97, 23);
		contentPane.add(chckbxfall);
		
		JCheckBox chckbxsummer = new JCheckBox("Summer");
		chckbxsummer.setBounds(406, 147, 97, 23);
		contentPane.add(chckbxsummer);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(35, 212, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(185, 212, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(322, 212, 89, 23);
		contentPane.add(btnDelete);
	}
}
