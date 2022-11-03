// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.BallProcessor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanConstants;

/** Creates a new BallProcessorSubsystem. */
public class BallProcessorSubsystem extends SubsystemBase {
  //Creates objects for talons in the ball processor
  private final TalonSRX m_vHopper1 = new TalonSRX(CanConstants.vHopperMotor);
  private final TalonSRX m_vHopper2 = new TalonSRX(CanConstants.vHopperMotor2);
  private final TalonSRX m_gateMotor = new TalonSRX(CanConstants.shooterGateMotor);
  private final TalonFX m_towerMotor = new TalonFX(CanConstants.ballTowerMotor);

  public BallProcessorSubsystem() {
    //Removes hardcoded parameters on the talons 
    m_vHopper1.configFactoryDefault();
    m_vHopper2.configFactoryDefault();
    m_gateMotor.configFactoryDefault();
    m_towerMotor.configFactoryDefault();

    //Inverts the second vHoppper motor and the shooter gate motor
    m_vHopper2.setInverted(true);
    m_gateMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * @param speed The speed of both Vhopper motors -1.0 to +1.0
   */
  public void driveVhopper(double speed){
    //Sets the both vHopper motors to the speed passed in Percent output mode
    //Multiplied by constants to increase ability for the VHopper to effectively serialze the balls.
    m_vHopper1.set(ControlMode.PercentOutput, speed * 0.8);
    m_vHopper2.set(ControlMode.PercentOutput, speed * 0.3);
  }

  /**
   * @param speed The speed of the gate motors -1.0 to +1.0
   */
  public void drivegatemotor(double speed){
    //Sets the gate motor to the speed passed in Percent output mode
    m_gateMotor.set(ControlMode.PercentOutput, speed);
  }

  /**
   * @param speed The speed of both ball tower motors -1.0 to +1.0
   */
  public void driveballTowerMotor(double speed){
    //Sets the tower motor to the speed passed in Percent output mode
    m_towerMotor.set(ControlMode.PercentOutput, speed);
  }
}