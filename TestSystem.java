import java.util.List;
import java.util.Queue;

public class TestSystem {

	public static void main(String[] args) {
		ElevatorController controller = new ElevatorController(5, 10);
		controller.requestElevator(3, ElevatorDirection.UP);
		controller.requestElevator(5, ElevatorDirection.UP);
		startThreads(controller.getElevators());

	}
	
	public static void startThreads(List<Elevator> list){
		for(Elevator e: list){
			e.start();
		}
		
	}

}
