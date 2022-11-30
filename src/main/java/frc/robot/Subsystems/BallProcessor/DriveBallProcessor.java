// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.BallProcessor;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveBallProcessor extends CommandBase {
  
  //Creates member variables
  BallProcessorSubsystem m_ballProcessor;
  DoubleSupplier m_speedVhopper, m_speedGateMotor, m_speedTowerMotor;

  /** Creates a new DriveBallProcessor Constructor */
  /**
   * @param ballProcessor The ball processor subsystem
   * @param speedVHopper The double supplier that 
   * @param speedGateMotor
   * @param speedTowerMotor
   */
  public DriveBallProcessor(BallProcessorSubsystem ballProcessor, DoubleSupplier speedVHopper, DoubleSupplier speedGateMotor, DoubleSupplier speedTowerMotor) {
    //set member variables to local variables
    m_speedVhopper = speedVHopper;
    m_speedGateMotor = speedGateMotor; 
    m_speedTowerMotor = speedTowerMotor;
    m_ballProcessor = ballProcessor;
    addRequirements(m_ballProcessor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Sets the motors in the ball processor to their corresponding speeds from the constructor.
    //Passed in speeds are in DoubleSupplier .getAsDouble() is needed to convert to double
    m_ballProcessor.driveVhopper(m_speedVhopper.getAsDouble());
    m_ballProcessor.drivegatemotor(m_speedGateMotor.getAsDouble());
    m_ballProcessor.driveballTowerMotor(m_speedTowerMotor.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //sets motors to zero when the command isn't being called.
    m_ballProcessor.driveVhopper(0);
    m_ballProcessor.drivegatemotor(0);
    m_ballProcessor.driveballTowerMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
