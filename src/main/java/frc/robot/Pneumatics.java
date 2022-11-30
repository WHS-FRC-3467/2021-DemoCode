// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  /** Creates a new Pneumatics. */
  //pcm control module declaration
  PneumaticsControlModule m_pcm = new PneumaticsControlModule();
  //Compressor declaration with CTRE type
  Compressor m_compressor = new Compressor(PneumaticsModuleType.CTREPCM);
  public Pneumatics() {
    
  }

  @Override
  public void periodic() {
    m_compressor.enableDigital();
    // This method will be called once per scheduler run
  }
}
