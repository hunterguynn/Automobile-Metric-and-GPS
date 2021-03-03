/**
 * GasTank
 */
public class GasTank 
{

	//Instance variables
	private int maximum = 0;
	private double current = 0;
	
	
	
	//Constructors initializes maximum with parameter int maximum
	public GasTank(int maximum) {
		this.current = 0;
		if (maximum > 0){
			this.maximum = maximum;
		}
		else{
			this.maximum = 0;
		}
	}		
	
	//Method: Set the private int level
	public void setLevel(double level){

		if(level < 0) {
			this.current = 0;
			
		} else if (level > this.maximum) {
			this.current = this.maximum;
			
		} else {
			this.current = level;
		}
		
	}	
	
	
	//Method: Output the private int maximum
	public int getCapacity(){
		return this.maximum;
	}
	
	
	//Method: Output the private double current
	public double getLevel() {
		return this.current;	
	}
	
	


}






