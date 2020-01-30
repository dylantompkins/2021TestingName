/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  CANSparkMax m_shooterMotor;
  
    /**
   * Creates a new ExampleSubsystem.
   */
  public ShooterSubsystem() {
    m_shooterMotor = new CANSparkMax(Constants.kShooterMotorPort, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void on() {
    //Turns on the shooter motor
    m_shooterMotor.set(Constants.kShooterMotorSpeed);

  }

  public void off() {
    //Turns off the shooter motor
    m_shooterMotor.set(0);
    
  }

}