import java.lang.Math;
import javax.swing.JOptionPane;

/**
 * Car
 */

public class Car {
	
	private String description = "Sweet Ride";
	private int xCoordinate = 0;
	private int yCoordinate = 0;
	private GasTank tank;
	private Engine engine;
	
	//Constructors initializes private variables (engine,mpg, and speed)
	public Car(String description, int maximumFuel, Engine engine) {
	
		if (description.length() == 0) {
			this.description = "Generic car";
		} else {
			this.description = description;
		}


		this.tank = new GasTank(maximumFuel);
		

	
		if (engine == null) {
			this.engine = new Engine("",0,0);
		} else {
			this.engine = engine;
		}
		
		
	}
	
	
	//Method: Output description
	public String getDescription() {
		return String.format("%s (engine: %s), fuel: %.2f/%d, location: (%d,%d)"
			,this.description , this.engine.getDescription(), this.tank.getLevel(), this.tank.getCapacity(), this.xCoordinate, this.yCoordinate);   
	}
	
	
	//Method: Output xCoordinate
	public int getX() {
		return this.xCoordinate;
	}
	
	//Method: Output yCoordinate
	public int getY() {
		return this.yCoordinate;
	}
	
	//Method: Output tank.getLevel()
	public double getFuelLevel() {
		return this.tank.getLevel();
	}
	
	
	//Method: Output engine.getMpa()
	public int getMPG() {
		return this.engine.getMpg();
	}
	
	
	//Method: Output engine.getMpa()
	public void fillUp() {
		this.tank.setLevel(this.tank.getCapacity());
	}
	
	//Method: Output engine.getMaxSpeed()
	public int getMaxSpeed() {
		return this.engine.getMaxSpeed();
	}
	
	
	//Method: Drive the Car
	public double drive(int distance, double xRatio, double yRatio) {
		
		
		double milesDriven = 0;
		double gasNeeded = 0;
		double miles = distance;
		double mpg = this.engine.getMpg();

		gasNeeded = (miles/mpg);

		if(gasNeeded <= this.tank.getLevel()){
			milesDriven = distance;
			this.tank.setLevel(this.tank.getLevel() - gasNeeded);
		}else{

			milesDriven = this.tank.getLevel() * this.engine.getMpg();
			this.tank.setLevel(0);
			System.out.printf("Ran out of gas after driving %.2f miles.\n", milesDriven);
			
		}

		//Calculating Corrdnates
		double a = 0;
		double b = 0;
		
		a = (xRatio/(Math.sqrt(Math.pow(xRatio,2)+Math.pow(yRatio,2))))*milesDriven;
		b = (yRatio/(Math.sqrt(Math.pow(xRatio,2)+Math.pow(yRatio,2))))*milesDriven;

		this.xCoordinate = this.xCoordinate + (int) a; 
		this.yCoordinate = this.yCoordinate + (int) b;

		return milesDriven;

		

		

	}
}