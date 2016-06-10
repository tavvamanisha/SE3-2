public class Section {

	private int sectionNumber = 0;
	private int courseNumber = 0;
	private String facultyName;
	private String semester;
	private String roomNumber;
	private int attribute;

	public String getSectionNumber() {
		// TODO - implement Section.getSectionNumber
		throw new UnsupportedOperationException();
	}

	public String getCourseNumber() {
		// TODO - implement Section.getCourseNumber
		throw new UnsupportedOperationException();
	}

	public String getFaccultyName() {
		// TODO - implement Section.getFaccultyName
		throw new UnsupportedOperationException();
	}

	public String getSemester() {
		return this.semester;
	}

	/**
	 * 
	 * @param sectionNumber
	 */
	public void setSectionNumber(String sectionNumber) {
		// TODO - implement Section.setSectionNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param courseNumber
	 */
	public void setCourseNumber(String courseNumber) {
		// TODO - implement Section.setCourseNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param facutyName
	 */
	public void setFacultyName(String facutyName) {
		this.facultyName = facutyName;
	}

	/**
	 * 
	 * @param semester
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}

	/**
	 * 
	 * @param roomNumber
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void getAttribute() {
		// TODO - implement Section.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		this.attribute = attribute;
	}

}