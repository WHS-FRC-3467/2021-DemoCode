// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Control.XBoxControllerButton;
import frc.robot.Control.XBoxControllerEE;
import frc.robot.Subsystems.BallProcessor.BallProcessorSubsystem;
import frc.robot.Subsystems.BallProcessor.DriveBallProcessor;
import frc.robot.Subsystems.Drive.ArcadeDrive;
import frc.robot.Subsystems.Drive.BasicDriveDistance;
import frc.robot.Subsystems.Drive.DriveSubsystem;
import frc.robot.Subsystems.Intake.DriveIntake;
import frc.robot.Subsystems.Intake.IntakeSubsystem;
import frc.robot.Subsystems.Shooter.DriveShooter;
import frc.robot.Subsystems.Shooter.ShooterSubSystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  //Initialize subsystems
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  private final BallProcessorSubsystem m_ballProcessorSubsystem = new BallProcessorSubsystem();
  private final ShooterSubSystem m_shooter = new ShooterSubSystem();

  //Creates variables for the Xbox controller objects
  private final XBoxControllerEE m_driverController = new XBoxControllerEE(0);
  private final XBoxControllerEE m_operatorController = new XBoxControllerEE(1);

  private final BasicDriveDistance m_autoCommand = new BasicDriveDistance(m_drive, 90000);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //Default commands- The command that will always run whenever the robot is enabled in teleoperated
    
    //Drive subsystem - drives robot in arcade drive fwd/bwd LeftY on driver controller and steer on RightX
    m_drive.setDefaultCommand(new ArcadeDrive(m_drive, 
                                              () -> m_driverController.getLeftY(), 
                                              () -> -m_driverController.getRightX()));

    //Intake subsystem - drives the intake using left trigger axis on opperator controller
    m_intake.setDefaultCommand(new DriveIntake(m_intake, 
                                              () -> m_driverController.getLeftTriggerAxis()));

    //Ball Processor subsystem - drives the gate and tower motors using LeftY on opperator drives vHopper using right trigger on opperator controller
    m_ballProcessorSubsystem.setDefaultCommand(new DriveBallProcessor(m_ballProcessorSubsystem, 
                                                                      () -> m_operatorController.getRightTriggerAxis(), 
                                                                      () -> m_operatorController.getLeftY(), 
                                                                      () -> -m_operatorController.getLeftY()));
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
    //While the A button on the opperator controller is held the shooter will be driven at 70% speed
    new XBoxControllerButton(m_operatorController, XBoxControllerEE.Button.kA)
      .whileHeld(new DriveShooter(m_shooter, 0.7));
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
