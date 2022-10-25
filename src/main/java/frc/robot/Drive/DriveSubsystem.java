// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private final WPI_TalonFX m_rightDriveMotor1 = new WPI_TalonFX(CanConstants.right_drivebase_1);
  private final WPI_TalonFX m_rightDriveMotor2 = new WPI_TalonFX(CanConstants.right_drivebase_2);
  private final WPI_TalonFX m_leftDriveMotor1 = new WPI_TalonFX(CanConstants.left_drivebase_1);
  private final WPI_TalonFX m_leftDriveMotor2 = new WPI_TalonFX(CanConstants.left_drivebase_2);

  final DifferentialDrive m_drive;

  public DriveSubsystem() {
    m_rightDriveMotor1.configFactoryDefault();
    m_leftDriveMotor1.configFactoryDefault();
    m_rightDriveMotor2.configFactoryDefault();
    m_leftDriveMotor2.configFactoryDefault();

    m_leftDriveMotor1.setInverted(true);
    m_leftDriveMotor2.setInverted(true);

    m_rightDriveMotor2.follow(m_rightDriveMotor1);
    m_leftDriveMotor2.follow(m_leftDriveMotor1);


    m_drive = new DifferentialDrive(m_leftDriveMotor1, m_rightDriveMotor1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double fwd, double rot){
   m_drive.arcadeDrive(fwd, rot);
  }
}