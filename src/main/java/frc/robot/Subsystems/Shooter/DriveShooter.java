// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveShooter extends CommandBase {
  /** Creates a new ShooterCommand. */
  //Declares member variables 
  double m_speed;
  ShooterSubSystem m_Shooter;
  /**
   * 
   * @param Shooter the ShooterSubsystem
   * @param speed the Speed in percent output the shooter will be set to
   */
  public DriveShooter(ShooterSubSystem Shooter, double speed) {
    //sets member variables to local variables
    m_speed = speed; 
    m_Shooter = Shooter;
    //Gives this command control over the shooter
    addRequirements(m_Shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Sets the shooter motor to the speed passed into 
    m_Shooter.driveShooter(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Sets the shooter to 0 when the command ends
    m_Shooter.driveShooter(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
