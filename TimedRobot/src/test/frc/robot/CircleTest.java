package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.VictorSP;

import static org.junit.Assert.assertEquals;

import org.junit.*;
//import org.junit.Assert;
//import org.mockito.junit.*;


public class CircleTest {

    @Test
    public void testRadius1() {
        Circle circleBig = new Circle(10);
        
        double theArea = circleBig.getArea();
        assertEquals(98, circleBig.getArea(), 2);
    }

    @Test
    public void testRadius2() {
        Circle circle2 = new Circle(5);
        
        assertEquals(5, circle2.getRadius(), 0);
        
        circle2.setRadius(6.1);

        assertEquals(6.1, circle2.getRadius(), 0);

    }

}

