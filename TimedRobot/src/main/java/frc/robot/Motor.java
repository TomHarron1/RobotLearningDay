package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.VictorSP;


public class Motor {
    // NOT!! private VictorSP motor = new VictorSP();
    private VictorSP motor;

    // TEST Constructor (run tests when not connected to robot)
    //   - our tests will pass in a motor object
    public Motor(VictorSP passedMotor) {
        this.motor = passedMotor;
    }

    // ROBOT Constructor (called when running/connected on robot)
    public static Motor create() {
        VictorSP motor = new VictorSP(1);
        return(new Motor(motor));   
    }

    public void setMotorPosition(double position) {
        this.motor.setPosition(position);
    };

    public double getMotorPosition() {
        return(this.motor.getPosition());
    }
}
