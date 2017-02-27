
public enum ElevatorDirection {
	UP("up"),
	DOWN("down"),
	STAND("stand");
	
	private String name;
	private ElevatorDirection(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
}
