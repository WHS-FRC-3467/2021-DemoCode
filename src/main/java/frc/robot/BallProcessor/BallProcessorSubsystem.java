// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.BallProcessor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanConstants;

public class BallProcessorSubsystem extends SubsystemBase {
  /** Creates a new BallProcessorSubsystem. */

  private final TalonSRX m_Vhopper1 = new TalonSRX(CanConstants.vHopperMotor);
  private final TalonSRX m_Vhopper2 = new TalonSRX(CanConstants.vHopperMotor2);
  private final TalonSRX m_Gatemotor = new TalonSRX(CanConstants.shooterGateMotor);
  private final TalonFX m_towerMotor = new TalonFX(CanConstants.ballTowerMotor);
  public BallProcessorSubsystem() {
    m_Vhopper1.configFactoryDefault();
    m_Vhopper2.configFactoryDefault();
    m_Gatemotor.configFactoryDefault();
    m_towerMotor.configFactoryDefault();

    m_Vhopper2.setInverted(true);
    m_Gatemotor.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
public void driveVhopper(double speed){
  m_Vhopper1.set(ControlMode.PercentOutput, speed * 0.8);
  m_Vhopper2.set(ControlMode.PercentOutput, speed * 0.3);

  }

public void drivegatemotor(double speed){
  m_Gatemotor.set(ControlMode.PercentOutput, speed);
}
public void driveballTowerMotor(double speed){
  m_towerMotor.set(ControlMode.PercentOutput, speed);
}
}