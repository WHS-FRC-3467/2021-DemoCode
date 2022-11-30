// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.BallProcessor.BallProcessorSubsystem;
import frc.robot.BallProcessor.DriveBallProcessor;
import frc.robot.Control.XBoxControllerButton;
import frc.robot.Control.XBoxControllerEE;
import frc.robot.Drive.ArcadeDrive;
import frc.robot.Drive.BasicDriveDistance;
import frc.robot.Drive.DriveSubsystem;
import frc.robot.Intake.DriveIntake;
import frc.robot.Intake.IntakeSubsystem;
import frc.robot.Shooter.ShooterComand;
import frc.robot.Shooter.ShooterSubSystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final DriveSubsystem m_drive = new DriveSubsystem();

  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  private final BallProcessorSubsystem m_BallProcessorSubsystem = new BallProcessorSubsystem();
  private final ShooterSubSystem m_shooter = new ShooterSubSystem();

  private final XBoxControllerEE m_controller = new XBoxControllerEE(0);
  private final XBoxControllerEE m_controller2 = new XBoxControllerEE(1);

  private final BasicDriveDistance m_autoCommand = new BasicDriveDistance(m_drive, 90000);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    m_drive.setDefaultCommand(new ArcadeDrive(m_drive, 
                                              () -> m_controller.getLeftY(), 
                                              () -> -m_controller.getRightX()));
    m_intake.setDefaultCommand(new DriveIntake(m_intake, 
                                              () -> m_controller.getLeftTriggerAxis()));
    m_BallProcessorSubsystem.setDefaultCommand(new DriveBallProcessor(m_BallProcessorSubsystem, 
                                                                      () -> m_controller2.getRightTriggerAxis(), 
                                                                      () -> m_controller2.getLeftY(), 
                                                                      () -> -m_controller2.getLeftY()));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
    */
  private void configureButtonBindings() {
    new XBoxControllerButton(m_controller2, XBoxControllerEE.Button.kA)
      .whileHeld(new ShooterComand(m_shooter, 0.7));
  }

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
