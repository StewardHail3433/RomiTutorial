package frc.robot.commands;

import java.lang.Math;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class Rotate extends CommandBase{
    
  /**
  * @param drive Drivetrain subsystem instance
  * @param degrees The number of degrees to rotate [-359..359]. Positive value is clockwise when
  *     viewing the robot from the top
  */

  private final RomiDrivetrain drivetrain;
  private final double RotateDegrees;
  private double StartingYaw;
  private NetworkTableEntry degreesEntry;

  public Rotate(RomiDrivetrain drive, double degrees) {
    drivetrain = drive;
    RotateDegrees = degrees;
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("RotateCommand");
    degreesEntry = table.getEntry("degrees"); 
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    StartingYaw = drivetrain.getYaw();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    drivetrain.arcadeDrive(0, (RotateDegrees/359));
    degreesEntry.setDouble(RotateDegrees);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /*if (StartingYaw + Math.abs(RotateDegrees) > drivetrain.getYaw() - 5 &&
        StartingYaw + Math.abs(RotateDegrees) < drivetrain.getYaw() + 5) {
        return true;
    } else { */
        return true;
    //}
  }
}
