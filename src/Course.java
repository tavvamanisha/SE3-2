import com.sun.xml.internal.fastinfoset.util.StringArray;

public class Course {

	private String number;
	private String name;
	private String description;
	private int creditHours;
	private int capacity;
	private StringArray preRequisiteCourses;
	private String semester;

	public String getNumber() {
		return this.number;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public int getCreditHours() {
		return this.creditHours;
	}

	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * 
	 * @param number
	 */
	public void setNumber(String number) {
		// TODO - implement Course.setNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		// TODO - implement Course.setName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		// TODO - implement Course.setDescription
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param creditHours
	 */
	public void setCreditHours(Integer creditHours) {
		// TODO - implement Course.setCreditHours
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param capacity
	 */
	public void setCapacity(Integer capacity) {
		// TODO - implement Course.setCapacity
		throw new UnsupportedOperationException();
	}

	public StringArray getPreRequisiteCourses() {
		return this.preRequisiteCourses;
	}

	/**
	 * 
	 * @param preRequisiteCourses
	 */
	public void setPreRequisiteCourses(StringArray preRequisiteCourses) {
		this.preRequisiteCourses = preRequisiteCourses;
	}

	public String getSemester() {
		return this.semester;
	}

	/**
	 * 
	 * @param semester
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

}