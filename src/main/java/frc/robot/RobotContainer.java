// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.RomiDrivetrain;
import frc.robot.subsystems.ServoSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final RomiDrivetrain m_romiDrivetrain = new RomtiDrivetrain();
  private final ServoSubsystem m_servoSubsystem = new ServoSubsystem(0);

  private final XboxController m_controller = new XboxController(0);
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_romiDrivetrain);
  private final DriveCommand m_driveCommand = new DriveCommand(m_romiDrivetrain, () -> -m_controller.getLeftY(), () -> m_controller.getLeftX());
  private final ServoControl m_servoControl = new ServoControl(m_servoSubsystem, () -> -m_controller.getLeftY());
  
  private final Servo m_servo = new Servo(0);
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_romiDrivetrain.setDefaultCommand(m_driveCommand);
    

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
