// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.SwerveDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.SwerveModule;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Constants c;

  private SwerveModule backRight;      
  private SwerveModule backLeft;       
  private SwerveModule frontRight;
  private SwerveModule frontLeft;      

  private DriveTrain swerveDrive;                                          
  


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    c = new Constants();
    backRight = new SwerveModule (c.BACK_RIGHT_ANGLE_PORT, c.BACK_RIGHT_SPEED_PORT, c.BACK_RIGHT_ENCODER_PORT);
    backLeft = new SwerveModule (c.BACK_LEFT_ANGLE_PORT, c.BACK_LEFT_SPEED_PORT, c.BACK_LEFT_ENCODER_PORT);
    frontRight = new SwerveModule (c.FRONT_RIGHT_ANGLE_PORT, c.FRONT_RIGHT_SPEED_PORT, c.FRONT_RIGHT_ENCODER_PORT);
    frontLeft = new SwerveModule (c.FRONT_LEFT_ANGLE_PORT, c.FRONT_LEFT_SPEED_PORT, c.FRONT_LEFT_ENCODER_PORT);
    swerveDrive = new DriveTrain (backRight, backLeft, frontRight, frontLeft); 
    swerveDrive.setDefaultCommand(new SwerveDrive(swerveDrive));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    XboxController xbC= new XboxController(Constants.XB_CONTROLLER_PORT);
    public double asdad(Hand hand){
      return xbC.getX(hand);
    }
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}