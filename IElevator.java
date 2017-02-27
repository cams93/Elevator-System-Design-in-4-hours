
public interface IElevator {
	
	public void up();
	public void down();
	public void newDestionation(int floor);
	public ElevatorDirection getDirection();
	public void setDirection(ElevatorDirection direction);

}
