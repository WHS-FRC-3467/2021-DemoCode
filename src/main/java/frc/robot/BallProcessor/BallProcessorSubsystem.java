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

  private final TalonSRX m_vHopper1 = new TalonSRX(CanConstants.vHopperMotor);
  private final TalonSRX m_vHopper2 = new TalonSRX(CanConstants.vHopperMotor2);
  private final TalonSRX m_gateMotor = new TalonSRX(CanConstants.shooterGateMotor);
  private final TalonFX m_towerMotor = new TalonFX(CanConstants.ballTowerMotor);

  public BallProcessorSubsystem() {
    m_vHopper1.configFactoryDefault();
    m_vHopper2.configFactoryDefault();
    m_gateMotor.configFactoryDefault();
    m_towerMotor.configFactoryDefault();

    m_vHopper2.setInverted(true);
    m_gateMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
public void driveVhopper(double speed){
  m_vHopper1.set(ControlMode.PercentOutput, speed * 0.8);
  m_vHopper2.set(ControlMode.PercentOutput, speed * 0.3);

  }

public void drivegatemotor(double speed){
  m_gateMotor.set(ControlMode.PercentOutput, speed);
}
public void driveballTowerMotor(double speed){
  m_towerMotor.set(ControlMode.PercentOutput, speed);
}
}