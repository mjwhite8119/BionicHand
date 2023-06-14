// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BionicHand extends SubsystemBase {
  private static final double kCountsPerRevolution = 1440.0;
  private static final double kWheelDiameterInch = 2.75591; // 70 mm

  // The Romi has the left and right motors set to
  // PWM channels 0 and 1 respectively
  private final Spark m_pinkMotor = new Spark(0);
  private final Spark m_ringMotor = new Spark(1);
  private final Spark m_middleMotor = new Spark(2);
  private final Spark m_indexMotor = new Spark(3);

  // The Romi has onboard encoders that are hardcoded
  // to use DIO pins 4/5 and 6/7 for the left and right
  private final Encoder m_pinkEncoder = new Encoder(4, 5);
  private final Encoder m_ringEncoder = new Encoder(6, 7);

  /** Creates a new Drivetrain. */
  public BionicHand() {

    // Use inches as unit for encoder distances
    m_pinkEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    m_ringEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    resetEncoders();
  }

  public void runPinkMotor(double speed) {
    m_pinkMotor.set(speed);
  }

  public void runRingMotor(double speed) {
    m_ringMotor.set(speed);
  }

  public void runMiddleMotor(double speed) {
    m_middleMotor.set(speed);
  }

  public void runIndexMotor(double speed) {
    m_indexMotor.set(speed);
  }

  public void resetEncoders() {
    m_pinkEncoder.reset();
    m_ringEncoder.reset();
  }

  public int getLeftEncoderCount() {
    return m_pinkEncoder.get();
  }

  public int getRightEncoderCount() {
    return m_ringEncoder.get();
  }

  public double getLeftDistanceInch() {
    return m_pinkEncoder.getDistance();
  }

  public double getRightDistanceInch() {
    return m_ringEncoder.getDistance();
  }

  public double getAverageDistanceInch() {
    return (getLeftDistanceInch() + getRightDistanceInch()) / 2.0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
