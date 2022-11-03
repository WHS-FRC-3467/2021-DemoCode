// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanConstants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new Intake. */
  //Creates the talon motor object motor for the intake
  private final TalonSRX m_intakeMotor = new TalonSRX(CanConstants.intakeMotor);

  public IntakeSubsystem() {
    //removes any hardcoded settings from the talon
    m_intakeMotor.configFactoryDefault();
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * @param speed The speed the intake will be set to -1.0 to +1.0
   */
  public void driveIntake(double speed){
      //Sets the intake motor to the speed passed in Percent output mode
    m_intakeMotor.set(ControlMode.PercentOutput, speed);
  }
}
