import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class TestGoodRobot {

	GoodRobot goodRobot;
	
	@Before
    public void setUp() throws Exception {
        // Code executed before EACH test
		GoodRobot goodRobot = new GoodRobot();
	}

    @Test
    public void testPowerPositive() {	  
       assertEquals(7, goodRobot.getPower(2, 3));
    }

    @Test
    public void testPowerNegative() {	  
       assertEquals(-8, goodRobot.getPower(-2, 3));
    }
    
    @Test
    public void testLightDesc() {	  
       assertEquals("Dark", goodRobot.getLevelDescription(1));
    }

    @Test
    // speed is slow (15), so turn more quickly (10)
    public void testTurnWheelSlow() {	  
       assertEquals(10, goodRobot.getTurnValue(60,  15));
    }

    @Test
    // speed is fast (25), so turn slowly (5)
    public void testTurnWheelFast() {	  
       assertEquals(5, goodRobot.getTurnValue(60,  25));
    }

    /*
    @Test
    // speed is very fast (35), so turn very slowly (2)
    public void testTurnWheelReallySlow() {	  
       assertEquals(2, goodRobot.getTurnValue(60, 35));
    }
    */

    /***** OTHER JUNIT assertion commands 
      1)  assert an expression is true 
          assertTrue(8  == goodRobot.getPower(2,3));
          
      2)  assert an expression is false 
          assertFalse(8 != goodRobot.getPower(5,2));		
      
      3)  if you have exception handling (that is, try/catch) and an exception is throw 
          you can CONTROL the error message thrown

      	try {
          	goodRobot.connectToWireless(9090);
      	} catch (IOException e) {
          	e.printStackTrace();
          	Assert.fail("Could not connect to robot on port 9090");
      	}
	******/
} // class TestGoodRobot

