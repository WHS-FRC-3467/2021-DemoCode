// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Drive;

import java.util.function.DoubleSupplier;


import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  DoubleSupplier m_fwd, m_rot;
  DriveSubsystem m_drive;
  public ArcadeDrive(DriveSubsystem drive, DoubleSupplier fwd, DoubleSupplier rot) {
    m_drive = drive;
    m_fwd = fwd;
    m_rot = rot;
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.drive(m_fwd.getAsDouble(), m_rot.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.drive(0.0, 0.0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
