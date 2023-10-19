package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ServoSubsystem;

public class ServoControl extends CommandBase {
    /**
     * Creates a servo control command
     *
     * @param servoSubsystem ServoSubsustem instance
     * @param position The servo's position [-1.0..1.0]. -1.0 corresponds to max counterclockwise
     *     position.
     */
    private final ServoSubsystem m_servoSubsystem;
    private final DoubleSupplier m_pos;

    public ServoControl(ServoSubsystem servoSubsystem, DoubleSupplier position) {
        m_servoSubsystem = servoSubsystem;
        m_pos = position;
        addRequirements(servoSubsystem);
    }

    @Override
    public void initialize() {}
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double position = m_pos.getAsDouble();
        m_servoSubsystem.set(position);
    }
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
    
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }



}
