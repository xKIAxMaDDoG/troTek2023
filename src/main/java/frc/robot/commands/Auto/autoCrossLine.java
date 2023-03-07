// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.driveTrain;
import frc.robot.commands.moveDriveTrain;

   public class autoCrossLine extends SequentialCommandGroup {
    // List commands here sequentially
    public autoCrossLine() { // List commands here sequentially
      addCommands(
        new moveDriveTrain().withTimeout(5)
        );
    }
}
  
