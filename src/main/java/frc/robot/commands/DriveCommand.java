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
    private final RomiDrivetrain drivetrain;
    private final DoubleSupplier xSpeedSupplier;
    private final DoubleSupplier zRotationSupplier;

    public DriveCommand(RomiDrivetrain drive, DoubleSupplier xSpeed, DoubleSupplier zRotation) {
        drivetrain = drive;
        xSpeedSupplier = xSpeed;
        zRotationSupplier = zRotation;
        addRequirements(drive);  // Make sure the command requires the drivetrain subsystem.
    }
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double xSpeed = xSpeedSupplier.getAsDouble() * 0.4;
        double zRotation = zRotationSupplier.getAsDouble() * 0.4;
        //Drivetrain control logic
        drivetrain.arcadeDrive(xSpeed, -zRotation);
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
