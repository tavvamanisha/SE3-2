import java.util.Date;

import com.sun.xml.internal.fastinfoset.util.StringArray;

public class Student {

	private int id = 0;
	private int degreeCode = 0;
	private String track;
	private Date graduationDate;
	private StringArray courseNumber;
	private StringArray grade;
	private StringArray term;

	public String getId() {
		// TODO - implement Student.getId
		throw new UnsupportedOperationException();
	}

	public int getDegreeCode() {
		return this.degreeCode;
	}

	public String getTrack() {
		return this.track;
	}

	public Date getGraduationDate() {
		return this.graduationDate;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		// TODO - implement Student.setId
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param degreeCode
	 */
	public void setDegreeCode(int degreeCode) {
		this.degreeCode = degreeCode;
	}

	/**
	 * 
	 * @param track
	 */
	public String setTrack(String track) {
		// TODO - implement Student.setTrack
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param graduationDate
	 */
	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getCourseNumber() {
		// TODO - implement Student.getCourseNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param courseNumber
	 */
	public void setCourseNumber(String courseNumber) {
		// TODO - implement Student.setCourseNumber
		throw new UnsupportedOperationException();
	}

	public String getGrade() {
		// TODO - implement Student.getGrade
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param grade
	 */
	public void setGrade(String grade) {
		// TODO - implement Student.setGrade
		throw new UnsupportedOperationException();
	}

	public StringArray getTerm() {
		return this.term;
	}

	/**
	 * 
	 * @param term
	 */
	public void setTerm(StringArray term) {
		this.term = term;
	}

	public void getAttribute() {
		// TODO - implement Student.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement Student.setAttribute
		throw new UnsupportedOperationException();
	}

}