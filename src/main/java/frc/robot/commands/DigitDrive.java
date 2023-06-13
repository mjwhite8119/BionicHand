// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;

public class DigitDrive extends CommandBase {
  private final Drivetrain m_drivetrain;
  private final Supplier<Double> m_pinkSupplier;
  private final Supplier<Double> m_ringSupplier;
  private final Supplier<Double> m_middleSupplier;
  private final Supplier<Double> m_indexSupplier;

  /**
   * Creates a new ArcadeDrive. This command will drive your robot according to the speed supplier
   * lambdas. This command does not terminate.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   * @param xaxisSpeedSupplier Lambda supplier of forward/backward speed
   * @param zaxisRotateSupplier Lambda supplier of rotational speed
   */
  public DigitDrive(
      Drivetrain drivetrain,
      Supplier<Double> pinkSupplier,
      Supplier<Double> ringSupplier,
      Supplier<Double> middleSupplier,
      Supplier<Double> indexSupplier
      ) {
    m_drivetrain = drivetrain;
    m_pinkSupplier = pinkSupplier;
    m_ringSupplier = ringSupplier;
    m_middleSupplier = middleSupplier;
    m_indexSupplier = indexSupplier;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.runPinkMotor(MathUtil.applyDeadband(m_pinkSupplier.get(), 0.3));
    m_drivetrain.runRingMotor(MathUtil.applyDeadband(m_ringSupplier.get(), 0.3));
    m_drivetrain.runMiddleMotor(MathUtil.applyDeadband(m_middleSupplier.get(), 0.3));
    m_drivetrain.runIndexMotor(MathUtil.applyDeadband(m_indexSupplier.get(), 0.3));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

