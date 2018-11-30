import java.util.Random;
// import java.xbox;
// import java.ramsey.lightSensor;

public class GoodRobot {

	// constants for XBOX controller buttons
	final static int XBOX_BTN_RIGHT_SHOULDER = 1;
	final static int XBOX_BTN_LEFT_SHOULDER  = 2;

	// constants for ACME light sensor levels
	final static int LIGHT_DARK   = 1;
	final static int LIGHT_DIM    = 2;
	final static int LIGHT_BRIGHT = 3;

	// define subsystems of robot
	private static Random randomNumberGenerator;
	private static XBoxController xbox;
	private static LightSensor lightSensor;
	private static WheelController robotWheels;

	// instantiate a Random number generator object, and all robot systems
	public static void initRobot() {
		randomNumberGenerator = new Random();
		xbox = new XBoxController();
		lightSensor = new LightSensor();
		robotWheels = new WheelController();
	}
	
	public static void main(String[] args) {
		// initialize random generator, Xbox controller and light sensor
		initRobot();
		
		System.out.println("I hope my robot works!");
		
		int sensorReading;
		int xboxButton;
		
		// robot loop will run forever (robotActive will always be true)
		boolean robotActive = true;
		while (robotActive) {
		
			// get light leverl reading from Ramsey light sensor
			sensorReading = lightSensor.getLightLevel();
			
			// check if user clicked XBOX button
			xboxButton = xbox.getButton();
			
			// check if user hit the right shoulder button
			if (xboxButton == XBOX_BTN_RIGHT_SHOULDER) {
				System.out.println("xbox=RIGHT shoulder");

				// turnRobot(60, 15);

				// get the turn value (with given angle and speed)
				int turnValue = getTurnValue(60, 15);	
				// turn the robot wheels specified turn value
				robotWheels.turnWheels(turnValue);
				
				if (sensorReading == LIGHT_DARK) {
					System.out.println("  Level=Dark");
				}
				
				// if light is dim or glowing, do something cool
				if (sensorReading == LIGHT_DIM || sensorReading == LIGHT_BRIGHT) {
					System.out.println("  Level=Dim or Glowing");
					
					int answer;
					int counter = 1;
					while (counter <= 3) {
						answer = getPower(2, counter);
						System.out.println("    Power is: " + answer);
						counter++;
					}
				}
			}

			// check if user hit the left shoulder button
			if (xboxButton == XBOX_BTN_LEFT_SHOULDER) {
				System.out.println("xbox=LEFT shoulder");

				// get the turn value (with given angle and speed)
				int turnValue = getTurnValue(70, 25);	
				// turn the robot wheels specified turn value
				robotWheels.turnWheels(turnValue);

				// turnRobot(70, 25);
				
				if (sensorReading == LIGHT_BRIGHT) {
					System.out.println("  Level=GLowing");
				}
				
				if (sensorReading == LIGHT_DIM) {
					System.out.println("  Level=Dim");
				}
			}

			try {
				Thread.sleep(3000);
			}
			catch (InterruptedException e){
			}
			System.out.println("- - - - - - ");

		}  
		
	} // main
	
	// given an angle, and speed
	// return a turnValue for robot wheels
	static int getTurnValue(double angle, double speed) {
		int turnValue = 0;

		System.out.format("Get turn value for angle: %5.2f, speed: %5.1f\n", angle, speed);
		// at lower speed, turn 10
		if (angle > 45 && (speed > 10 & speed < 20)) {
			turnValue = 10;
		}
		// at higher speed, turn only 5
		if (angle > 45 && speed >= 20) {
			turnValue = 5;
		}
		return(turnValue);
	}
/*
	static void turnRobot(double angle, double speed) {
		System.out.format("Turning robot with angle: %5.2f, speed: %5.1f\n", angle, speed);
		if (angle > 45 && (speed > 10 & speed < 20)) {
			System.out.println("   Turning wheel 10");
			robotWheels.turnWheel(10);
		}
		if (angle > 45 && speed >= 20) {
			System.out.println("   Turning wheel 20");
			robotWheels.turnWheel(5);
		}
	}
*/	
	// given a number and exponent, return the number raised to that exponent
	// example:  given 3 and 4
	// return:   81   	(which is, 3 * 3 * 3 * 3) 
	static int getPower(int number, int exponent) {
		int answer = 1;
		int loop = 1;
		// repeatedly multiply 'exponent' times
		while (loop <= exponent) {
			answer = answer * number;
			loop++;
		}
		
		/* another implementation
		   int answer = 1;
		   for (int loop = 1; loop < exponent; loop++) {
		       answer = answer * number;
		   }   
		*/
		
		return(answer);
	}
	
	
	// given a light level, return the associated description
	static String getLevelDescription(int lightLevel) {
		if (lightLevel == LIGHT_DARK) {
			return("Dark");
		}
		else if (lightLevel == LIGHT_DIM) {
			return("Dim");
		}
		else {
			return("Bright");
		}
	}

	// this class represents an XBOX controller
	static private class XBoxController {
		// return a random number 1 to 2
		private int getButton() { 
			return(randomNumberGenerator.nextInt(2) + 1);  
		}
		private String getButtonDesc(int buttonId) {
			if (buttonId == XBOX_BTN_RIGHT_SHOULDER) {
				return("XBox-Right Shoulder");
			}
			else if (buttonId == XBOX_BTN_LEFT_SHOULDER) {
				return("XBox-Left Shoulder");
			}
			else {
				return("BAD BUTTON!");
			}
		}
	}

	// this class represents an ACME light sensor
	static private class LightSensor {
		// return a random number 1 to 3
		private int getLightLevel() { 
			return(randomNumberGenerator.nextInt(3) + 1);  
		}
	}
	static private class WheelController {
		private void turnWheels(int amount) { 
			// turn the wheels
			System.out.println("  ** Turning wheels: " + amount);
			return;
		}
	}

} // class GoodRobot
