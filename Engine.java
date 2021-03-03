/**
 * Engine
 */
public class Engine {
	
	//Instance variables
	private String engine = "V8";
	private int mpg = 0;
	private int maxSpeed = 0;
		
	
	//Constructors initializes private variables (engine,mpg, and speed)
	public Engine(String engine, int mpg, int maxSpeed) {
		
		///engine
		if (engine.length() == 0) {
			this.engine = "Generic engine";
		} else {
			this.engine = engine;
		}
		
		//mpg
		if (mpg < 0) {
			this.mpg = 0;
		} else {
			this.mpg = mpg;
		}
		
		//maxSpeed
		if (maxSpeed < 0) {
			this.maxSpeed = 0;
		} else {
			this.maxSpeed = maxSpeed;
		}
		

	}		

	
	//Method: Output description 
	public String getDescription() {
		return String.format("%s (MPG: %d, Max speed: %d)",engine ,mpg, maxSpeed);	
	}
	

	
	//Method: Output mpg 
	public int getMpg() {
		return mpg ;	
	}
	
	
	//Method: Output maxSpeed 
	public int getMaxSpeed() {
		return maxSpeed;	
	}
	

	
}