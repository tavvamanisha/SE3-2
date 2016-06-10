public class Rooms {

	private String building;
	private String roomNumber;
	private int capacity;

	public String getBuilding() {
		return this.building;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}

	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * 
	 * @param building
	 */
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * 
	 * @param roomNumber
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * 
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}