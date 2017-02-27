import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements IElevator, Runnable{
	
	private Queue<Integer> requests;
	private int currentFloor;
	private int elevatorID;
	private ElevatorDirection direction;
	private Thread t;
	
	public Elevator(int id) {
		this.elevatorID = id;
		this.currentFloor = 1;
		this.direction = ElevatorDirection.STAND;
		this.requests = new LinkedList<>();
		printStatus();
	}
	
	public void start () {
		if (t == null) {
			t = new Thread (this);
			t.start ();
		}
	}
	
	@Override
	public void run() {
		try {
			int destination;
			while(!requests.isEmpty()) {
				destination = requests.peek();
				while(destination != this.currentFloor){
					if(this.currentFloor > destination){
						down();
					}else if(this.currentFloor < destination){
						up();
					}
					Thread.sleep(400);
				}
				arriveDestination();
				if(requests.isEmpty() && currentFloor != 1){
					newDestionation(1);
					this.setDirection(ElevatorDirection.DOWN);
					System.out.println("Returning to floor 1");
					printStatus();
				}else if(requests.isEmpty() && currentFloor == 1){
					this.setDirection(ElevatorDirection.STAND);
					System.out.println("Elevator in lobby");
					printStatus();
				}
			}
		}catch (InterruptedException e) {
			System.out.println("Thread interrumped");
		}
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
		
		System.out.println("Arrive Floor: " + this.currentFloor);
		
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
				" Floor: " + this.currentFloor + " Direction: " + this.getDirection().getName());
	}

	public Queue<Integer> getRequests() {
		return requests;
	}

}
