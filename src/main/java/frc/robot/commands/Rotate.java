package frc.robot.commands;

import java.lang.Math;

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
  private double zRotation;
  private double StartingYaw;

  public Rotate(RomiDrivetrain drive, double degrees) {
    drivetrain = drive;
    RotateDegrees = degrees;
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
    zRotation = 0;
    if (RotateDegrees > 5) {
      zRotation = -2.5;
    } else if (RotateDegrees < -5) {
      zRotation = 2.5;
    }
    drivetrain.arcadeDrive(0, zRotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
        return StartingYaw + Math.abs(RotateDegrees) > drivetrain.getYaw() - 5 && StartingYaw + Math.abs(RotateDegrees) < drivetrain.getYaw() + 5;
  }
}
