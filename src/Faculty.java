import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import com.sun.xml.internal.fastinfoset.util.StringArray;

public class Faculty {

	private String name;
	private String title;
	private int maxLoad;
	private StringArray courseNumber;
	private IntegerArray daysAvailable;

	public String getName() {
		return this.name;
	}

	public String getTitle() {
		return this.title;
	}

	public int getMaxLoad() {
		return this.maxLoad;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		// TODO - implement Faculty.setName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		// TODO - implement Faculty.setTitle
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param maxLoad
	 */
	public void setMaxLoad(Integer maxLoad) {
		// TODO - implement Faculty.setMaxLoad
		throw new UnsupportedOperationException();
	}

	public StringArray getCourses() {
		// TODO - implement Faculty.getCourses
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param courses
	 */
	public void setCourses(StringArray courses) {
		// TODO - implement Faculty.setCourses
		throw new UnsupportedOperationException();
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

	public IntegerArray getDaysAvailable() {
		return this.daysAvailable;
	}

	/**
	 * 
	 * @param daysAvailable
	 */
	public void setDaysAvailable(IntegerArray daysAvailable) {
		this.daysAvailable = daysAvailable;
	}

}