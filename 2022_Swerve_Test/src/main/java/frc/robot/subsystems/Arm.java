// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Arm extends SubsystemBase {
  private PWMVictorSPX motor1, motor2;
  private PIDController pid;
  /** Creates a new Arm. */
  public Arm() {
    motor1 = new PWMVictorSPX(Constants.ARM_MOTOR_1_ID);
    motor2 = new PWMVictorSPX(Constants.ARM_MOTOR_2_ID);
  }
  public void setMotors(double percentpower){
    motor1.set(percentpower);
    motor2.set(percentpower);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
