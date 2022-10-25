// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class CanConstants{
        // drivebase
        public static final int left_drivebase_1 = 3;
        public static final int left_drivebase_2 = 4;
        public static final int right_drivebase_1 = 1;
        public static final int right_drivebase_2 = 2; 
        //Intake  
        public static final int intakeMotor = 6;
        //VHopper
        public static final int vHopperMotor = 15;
        public static final int vHopperMotor2 = 13;
        //Ball tower 
        public static final int ballTowerMotor = 9;
        //Shooter
        public static final int shooterMotor1 = 11;
        public static final int shooterMotor2 = 12;

        public static final int shooterGateMotor = 10;

        public static final int climberMotor = 20;

    }
}
