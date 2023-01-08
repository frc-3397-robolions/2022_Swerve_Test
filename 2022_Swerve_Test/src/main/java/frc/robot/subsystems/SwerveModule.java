// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveModule extends SubsystemBase {
  private CANSparkMax angleMotor;
  private CANSparkMax speedMotor;
  private SparkMaxPIDController pidController;
  private RelativeEncoder encoder;
  private double MAX_VOLTS = Constants.SWERVE_MAX_VOLTS;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
  /** Creates a new SwerveModule. */
  public SwerveModule(int angleMotorPort, int speedMotorPort) {
    this.angleMotor = new CANSparkMax(angleMotorPort, MotorType.kBrushless);
    angleMotor.restoreFactoryDefaults();
    this.speedMotor = new CANSparkMax(speedMotorPort, MotorType.kBrushless);
    speedMotor.restoreFactoryDefaults();
    this.pidController = angleMotor.getPIDController();
    this.encoder = angleMotor.getEncoder();

    kP = 1; 
    kI = 0;
    kD = 0; 
    kIz = 0; 
    kFF = 0; 
    kMaxOutput = 1; 
    kMinOutput = -1;

    pidController.setFeedbackDevice(encoder);
    pidController.setP(kP);
    pidController.setI(kI);
    pidController.setD(kD);
    pidController.setIZone(kIz);
    pidController.setFF(kFF);
    pidController.setOutputRange(kMinOutput, kMaxOutput);
  }
  public void drive (double speed, double angle) {
    speedMotor.setVoltage(speed);
    pidController.setReference(angle, CANSparkMax.ControlType.kPosition);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double p=SmartDashboard.getNumber("kP", 0);
    SmartDashboard.putNumber("kP", kP);
    if(p!=kP)
    kP=p;
  }
}
