// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanConstants;
import frc.robot.Constants.PneumaticConstants;

public class ShooterSubSystem extends SubsystemBase {
  /** Creates a new ShooterSubSystem. */

  //Creates objects for the shooter talons
  private final TalonFX m_shooterMotor1 = new TalonFX(CanConstants.shooterMotor1);
  private final TalonFX m_shooterMotor2 = new TalonFX(CanConstants.shooterMotor2);
  private final DoubleSolenoid m_shootHood = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, PneumaticConstants.kHoodDeploy, PneumaticConstants.kHoodRetract);

  public ShooterSubSystem() {
    //Removes any hardcoded settings on the talons 
    m_shooterMotor1.configFactoryDefault();
    m_shooterMotor2.configFactoryDefault();

    //Inverts the second shooter motor
    m_shooterMotor2.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  /**
   *  
   * @param speed the speed in percent output the shooter will be set to -1.0 to +1.0
   */
  public void driveShooter(double speed){
    //Sets both shooter motors to the speed passed in Percent output mode
    m_shooterMotor1.set(ControlMode.PercentOutput, speed);
    m_shooterMotor2.set(ControlMode.PercentOutput, speed);
  
  }

  public void deployShooterHood(){
    m_shootHood.set(Value.kForward);
  }

  
  public void retractShooterHood(){
    m_shootHood.set(Value.kReverse);
  }
}
