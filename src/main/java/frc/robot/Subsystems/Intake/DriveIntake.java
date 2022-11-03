// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Intake;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveIntake extends CommandBase {
  /** Creates a new DriveIntake. */
  //Declares member variables 
  IntakeSubsystem m_intake;
  DoubleSupplier m_speed;

  /**
   * @param intake the IntakeSubsystem
   * @param speed the speed the intake will be set to
   */
  public DriveIntake(IntakeSubsystem intake, DoubleSupplier speed) {
    //sets local variables to member variables
    m_speed = speed; 
    m_intake = intake;
    //gives this command control over the intake
    addRequirements(m_intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Drives the intake at the speed passed into the command
    //the values passed into this command are DoubleSuppliers use .getAsDouble() to convert
    m_intake.driveIntake(m_speed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //sets the intake speed to 0 when command ends
    m_intake.driveIntake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
