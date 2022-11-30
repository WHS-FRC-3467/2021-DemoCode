// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanConstants;
import frc.robot.Constants.PneumaticConstants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new Intake. */
  private final TalonSRX m_intakeMotor = new TalonSRX(CanConstants.intakeMotor);
  private final DoubleSolenoid m_intakeSlider = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, PneumaticConstants.kIntakePistonDeploy, PneumaticConstants.kIntakePistonRetract);
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

  public void deployShooterHood(){
    m_intakeSlider.set(Value.kForward);
  }

  
  public void retractShooterHood(){
    m_intakeSlider.set(Value.kReverse);
  }
}
