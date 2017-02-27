
public class Request {
	private int floor;
	private ElevatorDirection direction;
	
	public Request(int floor, ElevatorDirection direction){
		this.floor = floor;
		this.direction = direction;
	}

	public int getFloor() {
		return floor;
	}

	public ElevatorDirection getDirection() {
		return direction;
	}

}
