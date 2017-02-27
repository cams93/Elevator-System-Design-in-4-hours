
public interface IElevatorController {
	
	public void requestElevator(int floor, ElevatorDirection direction);
	public void goTo(int id, int floor, ElevatorDirection direction);
	public void sendElevator();
	

}
