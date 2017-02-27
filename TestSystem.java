import java.util.List;

public class TestSystem {
	
	private static List<Elevator> elevators;

	public static void main(String[] args) {
		ElevatorController controller = new ElevatorController(3, 10);
		controller.requestElevator(3, ElevatorDirection.UP);
		//controller.requestElevator(5, ElevatorDirection.UP);
		//controller.requestElevator(7, ElevatorDirection.DOWN);
		elevators = controller.getElevators();
		
		startThreads();

	}
	
	public static void startThreads(){
		for(Elevator e: elevators){
			e.start();
		}
	}
}
