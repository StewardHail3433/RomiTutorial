package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ServoSubsystem extends SubsystemBase {
    private final Servo m_servo;
    private NetworkTableEntry posEntry;
    /**
     * Creates a servo subsystem
     *
     * @param channel PWM channel ID for the servo
     */
    public ServoSubsystem(int channel) {
        m_servo = new Servo(channel);
        //create table to see the value of pos in the sim
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("MySubsystems");
        posEntry = table.getEntry("servo_position"); 
    }


    /**
     * Sets the servo to the requested position
     *
     * @param angle desired angle in percentage of total range. [0..1.0]. 0 is full counterclockwise.
     *     1.0 is full clockwise.
     */
    public void set(double pos) {
        if (pos >= 0.0 && pos <= 1.0) {
            m_servo.set(pos);
            //sets the value of pos on the sim
            posEntry.setDouble(pos);
        } else {

        }
    }
}
