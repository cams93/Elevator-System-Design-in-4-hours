import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorController implements IElevatorController{
	
	private int numFloors;
	private int numElevators;
	private List<Elevator> elevators;
	private Queue<Request> requests;
	
	public ElevatorController(int elevators, int floors) {
		this.numElevators = elevators;
		this.numFloors = floors;
		this.elevators = new ArrayList<>();
		this.requests = new LinkedList<>();
		createElevators();
	}
	
	public void createElevators(){
		int id = 1;
		for(int i = 0; i < numElevators; i++){
			id += i;
			elevators.add(new Elevator(id));
		}
	}
	
	@Override
	public void requestElevator(int floor, ElevatorDirection direction) {
		requests.add(new Request(floor, direction));
		
	}
	@Override
	public void goTo(int id, int floor) {
		elevators.get(--id).newDestionation(floor);
	}
	@Override
	public void move() {
		
		
	}

	public List<Elevator> getElevators() {
		return elevators;
	}
	

}
