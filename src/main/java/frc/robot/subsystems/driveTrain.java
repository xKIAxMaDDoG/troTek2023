// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveTrain extends SubsystemBase {

  private final Spark leftFront;
  private final Spark leftRear;
  private final Spark rightFront;
  private final Spark rightRear;

  private final MotorControllerGroup leftMotors;
  private final MotorControllerGroup rightMotors;

  private final DifferentialDrive m_diffDrive;

  public driveTrain() {

    leftFront = new Spark(2);
    leftRear = new Spark(3);
    rightFront = new Spark(1);
    rightRear = new Spark(0);
    
    leftMotors = new MotorControllerGroup(leftFront, leftRear);
    rightMotors = new MotorControllerGroup(rightFront, rightRear);

    m_diffDrive = new DifferentialDrive(leftMotors, rightMotors);    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void curvatureDrive(double speed, double rotation, boolean quickturn){
    m_diffDrive.curvatureDrive(speed, rotation, quickturn);
  }

  public void driveTrainStop() {
    m_diffDrive.tankDrive(0, 0);
  }
}

