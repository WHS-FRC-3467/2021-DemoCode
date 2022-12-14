// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Drive;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

    m_rightDriveMotor1.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    m_leftDriveMotor1.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    m_rightDriveMotor2.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    m_leftDriveMotor2.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

    m_rightDriveMotor1.configIntegratedSensorInitializationStrategy(SensorInitializationStrategy.BootToZero);
    m_leftDriveMotor1.configIntegratedSensorInitializationStrategy(SensorInitializationStrategy.BootToZero);
    m_rightDriveMotor2.configIntegratedSensorInitializationStrategy(SensorInitializationStrategy.BootToZero);
    m_leftDriveMotor2.configIntegratedSensorInitializationStrategy(SensorInitializationStrategy.BootToZero);

    m_drive = new DifferentialDrive(m_leftDriveMotor1, m_rightDriveMotor1);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Drive Encoders", getDriveEncoderCount());
    // This method will be called once per scheduler run
  }

  public void drive(double fwd, double rot){
    m_drive.arcadeDrive(fwd, rot);
  }

  public double getDriveEncoderCount(){
    return (m_leftDriveMotor1.getSelectedSensorPosition() + m_rightDriveMotor1.getSelectedSensorPosition())/2;
  }
  //90,000 encoder for yellow box

}
