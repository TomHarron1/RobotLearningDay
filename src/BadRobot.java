import java.util.Random;
//import java.xbox;
//import java.ramsey.lightSensor;

public class BadRobot {
	private static Random randomNumberGenerator;
	private static XBoxController xbox;
	private static LightSensor lightSensor;
	private static WheelController robotWheels;

	public static void initRobot() {
		randomNumberGenerator = new Random();
		xbox = new XBoxController();
		lightSensor = new LightSensor();
		robotWheels = new WheelController();
	}

	public static void main(String[] args) {
	
		initRobot();
		
		int sensorReading;
		int xboxButton;
		
		boolean robotActive = true;
		while (robotActive) {
		
			sensorReading = lightSensor.getLightLevel();
			xboxButton = xbox.getButton();

			if (xboxButton == 1) {
				System.out.println("xbox=1");
				turnRobot(60, 15);
				
				if (sensorReading == 1) {
					System.out.println("  Level=1");
				}
				
				if (sensorReading == 2 || sensorReading == 3) {
					System.out.println("  Level=2 or 3");
					
					int answer;
					int counter = 1;
					while (counter <= 3) {
						answer = getPower(2, counter);
						System.out.println("    Power is: " + answer);
						counter++;
					}
				}
			}

			if (xboxButton == 2) {
				System.out.println("xbox=2");
				turnRobot(70, 25);
			
				if (sensorReading == 3) {
					System.out.println("  Level=3");
				}
				
				if (sensorReading == 2) {
					System.out.println("  Level=2");
				}
			}
			
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e){
			}
		}  
		
	} // main
	
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
		return;
	}
	
	static int getPower(int number, int exponent) {
		int answer = 1;
		int loop = 1;
		while (loop <= exponent) {
			answer = answer * number;
			loop++;
		}
		return(answer);
	}
	
	static String getLevelDescription(int lightLevel) {
		if (lightLevel == 1) {
			return("Dark");
		}
		else if (lightLevel == 2) {
			return("Dim");
			
		}
		else if (lightLevel == 2) {
			return("Glowing");
			
		}
		else {
			return("Bright");
		}
	}
	
	static private class XBoxController {
		// return a random number 1 to 2
		private int getButton() { 
			return(randomNumberGenerator.nextInt(2) + 1);  
		}
	}
	static private class LightSensor {
		// return a random number 1 to 3
		private int getLightLevel() { 
			return(randomNumberGenerator.nextInt(3) + 1);  
		}
	}
	static private class WheelController {
		private void turnWheel(double amount) { 
			// turn the wheels
			return;
		}
	}
}

