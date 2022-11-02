// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanConstants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new Intake. */
  private final TalonSRX m_intakeMotor = new TalonSRX(CanConstants.intakeMotor);
  public IntakeSubsystem() {
    m_intakeMotor.configFactoryDefault();
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveIntake(double speed){
    m_intakeMotor.set(ControlMode.PercentOutput, speed);
  }
}
