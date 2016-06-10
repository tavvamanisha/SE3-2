import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import com.sun.xml.internal.fastinfoset.util.StringArray;

public class Degree {

	private String name;
	private String department;
	private String track;
	private int code;
	private StringArray courseNumber;
	private IntegerArray hours;
	private boolean required;

	public String getName() {
		return this.name;
	}

	public String getDepartment() {
		return this.department;
	}

	public String getTrack() {
		return this.track;
	}

	public String getCode() {
		// TODO - implement Degree.getCode
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 
	 * @param track
	 */
	public void setTrack(String track) {
		this.track = track;
	}

	/**
	 * 
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	public StringArray getCourseNumber() {
		return this.courseNumber;
	}

	/**
	 * 
	 * @param courseNumber
	 */
	public void setCourseNumber(StringArray courseNumber) {
		this.courseNumber = courseNumber;
	}

	public IntegerArray getHours() {
		return this.hours;
	}

	/**
	 * 
	 * @param hours
	 */
	public void setHours(IntegerArray hours) {
		this.hours = hours;
	}

	public boolean getRequired() {
		return this.required;
	}

	/**
	 * 
	 * @param required
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}

	public void getAttribute() {
		// TODO - implement Degree.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement Degree.setAttribute
		throw new UnsupportedOperationException();
	}

}