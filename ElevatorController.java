import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.print.attribute.standard.Destination;

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
	
	private void createElevators(){
		for(int i = 0; i < numElevators; i++){
			elevators.add(new Elevator(i));
		}
	}
	
	@Override
	public void requestElevator(int floor, ElevatorDirection direction) {
		requests.add(new Request(floor, direction));
		sendElevator();
		
	}
	
	@Override
	public void goTo(int id, int floor, ElevatorDirection direction) {
		elevators.get(id).newDestionation(floor);
		elevators.get(id).setDirection(direction);
		//elevators.get(id).move();
	}
	
	@Override
	public void sendElevator() {
		int floor = requests.peek().getFloor();
		ElevatorDirection direction = requests.peek().getDirection();
		for(Elevator e : elevators){
			if(e.getDirection().equals(ElevatorDirection.STAND)){
				goTo(e.getElevatorID(), floor, direction);
				requests.poll();
			}
			else if(direction.equals(ElevatorDirection.UP) && e.getCurrentFloor() < floor){
				goTo(e.getElevatorID(), floor, direction);
				requests.poll();
			}
			else if(direction.equals(ElevatorDirection.DOWN) && e.getCurrentFloor() > floor){
				goTo(e.getElevatorID(), floor, direction);
				requests.poll();
			}
			if(requests.isEmpty()){
				break;
			}
		}
	}

	public List<Elevator> getElevators() {
		return elevators;
	}
	
}
