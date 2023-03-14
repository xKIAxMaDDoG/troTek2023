// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ExampleCommand;
import frc.robot.commands.driveWithController;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Auto.*;
import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.AHRS.SerialDataType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.cameraserver.CameraServer;

public class RobotContainer {
  
  /*Subsystems*/
  public final static ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public final static driveTrain m_driveTrain = new driveTrain();
  public final static intake m_intake = new intake();
  public final static arm m_arm = new arm();

  /*Commands*/
  public final static autoDoNothing m_autoDoNothing = new autoDoNothing(m_driveTrain);
  public final static autoCrossLine m_autoCrossLine = new autoCrossLine();
  public final static autoBalanceOnPlatform m_autoBalanceOnPlatform = new autoBalanceOnPlatform();
  public final static autoScoreAndBalance m_autoScoreAndBalance = new autoScoreAndBalance();

  /*Auto Balance*/
  public final static autoBalance m_autoBalance = new autoBalance();

  /*Controllers*/
  public static final XboxController m_driverController = new XboxController(0);

  /*Buttons*/
  public final static JoystickButton exampleCommand = new JoystickButton(m_driverController, XboxController.Button.kY.value);

  /*Gyro*/
  public static final AHRS m_ahrs = new AHRS(SPI.Port.kMXP);
  
  /*A chooser for autonomous commands*/
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    /*Default Commands*/
    m_driveTrain.setDefaultCommand(
      new driveWithController(m_driveTrain));

    // Configure the trigger bindings
    configureBindings();

    // Add commands to the autonomous command chooser
    m_chooser.setDefaultOption("Do Nothing", m_autoDoNothing);
    m_chooser.addOption("Cross Line", m_autoCrossLine);
    m_chooser.addOption("Auto Balance", m_autoBalanceOnPlatform);
    m_chooser.addOption("Score And Balance", m_autoScoreAndBalance);

    // Put the chooser on the dashboard
    SmartDashboard.putData(m_chooser);
  }

  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand());

        //intake.onTrue(new InstantCommand(() -> m_Intake.runIntakeSpeed(-1)));
        //intake.onFalse(new InstantCommand(() -> m_Intake.runIntakeSpeed(0)));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    //m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return m_chooser.getSelected();
  }
  
  
}