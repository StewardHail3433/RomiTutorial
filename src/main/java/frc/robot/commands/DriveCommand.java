package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class DriveCommand extends CommandBase {
    /**
     * Creates a DriveCommand instance
     *
     * @param drive Drivetrain subsystem instance
     * @param xSpeed The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
     * @param zRotation The robot's rotation rate around the Z axis [-1.0..1.0]. Counterclockwise is
     *     positive.
     */
    public DriveCommand(RomiDrivetrain drive, DoubleSupplier xSpeed, DoubleSupplier zRotation) {}
    
    
    @Override
    public void initialize() {}
    
    
    @Override
    public void execute() {}
    
    
    @Override
    public void end(boolean interrupted) {}
    
    
    //@Override
    //public boolean isFinished() {}
}
