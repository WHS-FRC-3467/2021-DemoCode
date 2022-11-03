// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  //Creates objects for the drive Base talons
  private final WPI_TalonFX m_rightDriveMotor1 = new WPI_TalonFX(CanConstants.right_drivebase_1);
  private final WPI_TalonFX m_rightDriveMotor2 = new WPI_TalonFX(CanConstants.right_drivebase_2);
  private final WPI_TalonFX m_leftDriveMotor1 = new WPI_TalonFX(CanConstants.left_drivebase_1);
  private final WPI_TalonFX m_leftDriveMotor2 = new WPI_TalonFX(CanConstants.left_drivebase_2);

  //Creates member object for the DifferentialDrive
  final DifferentialDrive m_drive;

  public DriveSubsystem() {
    //Resets all hard code in the talons
    m_rightDriveMotor1.configFactoryDefault();
    m_leftDriveMotor1.configFactoryDefault();
    m_rightDriveMotor2.configFactoryDefault();
    m_leftDriveMotor2.configFactoryDefault();

    //Inverts the left side of the drivebase
    m_leftDriveMotor1.setInverted(true);
    m_leftDriveMotor2.setInverted(true);

    //The second motor will follow the first motor
    m_rightDriveMotor2.follow(m_rightDriveMotor1);
    m_leftDriveMotor2.follow(m_leftDriveMotor1);

    //Sets member DifferentailDrive object to a new DifferentialDrive object passing the master left and right talons as the parameters
    m_drive = new DifferentialDrive(m_leftDriveMotor1, m_rightDriveMotor1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * 
   * @param forward The forward/backward speed of the drivebase. -1.0 to +1.0
   * @param steer The steering speed of the drive base.  -1.0 to +1.0
   */
  public void drive(double forward, double steer){
    //Passes the forward/backward speed and the steering speed into the arcadeDrive function of the WPILib Differential Drive 
    m_drive.arcadeDrive(forward, steer);
  }
}
