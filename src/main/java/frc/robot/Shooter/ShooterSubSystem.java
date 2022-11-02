// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanConstants;

public class ShooterSubSystem extends SubsystemBase {
  /** Creates a new ShooterSubSystem. */


  private final TalonFX m_shooterMotor1 = new TalonFX(CanConstants.shooterMotor1);
  private final TalonFX m_shooterMotor2 = new TalonFX(CanConstants.shooterMotor2);
  public ShooterSubSystem() {
    m_shooterMotor1.configFactoryDefault();
    m_shooterMotor2.configFactoryDefault();
    m_shooterMotor2.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void driveShooter(double speed){
    m_shooterMotor1.set(ControlMode.PercentOutput, speed);
    m_shooterMotor2.set(ControlMode.PercentOutput, speed);
  
    }
}