// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Drive;

import java.util.function.DoubleSupplier;


import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */

  //Declare member varables
  DoubleSupplier m_fwd, m_rot;
  DriveSubsystem m_drive;

  /**
   * Constructor for ArcadeDrive
   * @param drive The DriveSubsystem
   * @param fwd The forward and backward speed of the drive base
   * @param rot The steering speed of the drivebase
   */
  public ArcadeDrive(DriveSubsystem drive, DoubleSupplier fwd, DoubleSupplier rot) {
    //Sets member variables to local variables. 
    m_drive = drive;
    m_fwd = fwd;
    m_rot = rot;
    //Gives command full control over drive base.
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Passes the drivebase speeds from the controller into the drive method in DriveSubsystem
    //the values passed into this command are DoubleSuppliers use .getAsDouble() to convert
    m_drive.drive(m_fwd.getAsDouble(), m_rot.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Sets drivebase to 0 when the command ends
    m_drive.drive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
