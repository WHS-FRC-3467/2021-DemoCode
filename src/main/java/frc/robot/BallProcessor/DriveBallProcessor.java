// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.BallProcessor;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveBallProcessor extends CommandBase {
  BallProcessorSubsystem m_BallProcessor;
  DoubleSupplier m_speedVhopper, m_speedGatemotor, m_speedtowerMotor;
  /** Creates a new DriveBallProcessor. */
  public DriveBallProcessor(BallProcessorSubsystem BallProcessor, DoubleSupplier speedVhopper, DoubleSupplier speedGatemotor, DoubleSupplier speedtowerMotor) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_speedVhopper = speedVhopper;
    m_speedGatemotor = speedGatemotor; 
    m_speedtowerMotor = speedtowerMotor;
    m_BallProcessor = BallProcessor;
    addRequirements(m_BallProcessor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_BallProcessor.driveVhopper(m_speedVhopper.getAsDouble());
    m_BallProcessor.drivegatemotor(m_speedGatemotor.getAsDouble());
    m_BallProcessor.driveballTowerMotor(m_speedtowerMotor.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_BallProcessor.driveVhopper(0);
    m_BallProcessor.drivegatemotor(0);
    m_BallProcessor.driveballTowerMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
