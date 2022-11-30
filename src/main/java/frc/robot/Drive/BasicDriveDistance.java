// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class BasicDriveDistance extends CommandBase {
  /** Creates a new BasicDriveDistance. */
  DriveSubsystem m_drive;
  double m_distance;
  
  public BasicDriveDistance(DriveSubsystem drive, double distance) {
    m_drive = drive;
    m_distance = distance;
    addRequirements(m_drive);
    //Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if(m_drive.getDriveEncoderCount() < m_distance){
      m_drive.drive(0.5, 0);
    }
    else{
      m_drive.drive(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted){
    m_drive.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_drive.getDriveEncoderCount()< m_distance){
      return false;
    }
    else{
      return true;
    }

  }
}
