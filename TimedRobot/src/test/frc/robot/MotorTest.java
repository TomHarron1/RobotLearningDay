package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.VictorSP;

import static org.junit.Assert.assertEquals;

import org.junit.*;
//import org.junit.Assert;
//import org.mockito.junit.*;

//import static org.mockito.Mokito.*;
//import static org.mockito.Mokito.mock;
import static org.mockito.Mockito.*;

public class MotorTest {
    public MotorTest() {

    }

    @Test
    public void testName() {
        // mock up a motor object
        VictorSP motorMock = mock(VictorSP.class);

        // call the constructor, passing in the mocked motor
        Motor motor = new Motor(motorMock);

        // set the name on the motor object
        motor.setMotorPosition(4.5);

        // if we ever call 'getMotorPosition()', then return 4.5
        when(motor.getMotorPosition()).thenReturn(4.5);

        // retrieve the name from the motor object, confirm it is what we set
        assertEquals(4.5, motor.getMotorPosition(), 0);

        long x = 6;
        assertEquals(x, 6L);
    }
}
