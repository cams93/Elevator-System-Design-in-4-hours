import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements IElevator{
	
	private Queue<Integer> requests;
	private int currentFloor;
	private int elevatorID;
	private ElevatorDirection direction;
	
	public Elevator(int id) {
		this.elevatorID = id;
		this.currentFloor = 1;
		this.direction = ElevatorDirection.STAND;
		this.requests = new LinkedList<>();
		printStatus();
	}

	@Override
	public void up() {
		currentFloor++;
		printStatus();
	}

	@Override
	public void down() {
		currentFloor--;
		printStatus();
	}
	
	public void arriveDestination(){
		requests.remove();
	}
	
	public int nextDestination(){
		return requests.peek();
	}

	@Override
	public void newDestionation(int floor) {
		requests.add(floor);
	}

	@Override
	public ElevatorDirection getDirection() {
		return direction;
	}

	@Override
	public void setDirection(ElevatorDirection direction) {
		this.direction = direction;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getElevatorID() {
		return elevatorID;
	}
	
	public void printStatus(){
		System.out.println("Elevator: " + this.elevatorID + 
				" Floor: " + this.currentFloor + "Direction: " + this.getDirection().getName());
	}

}
