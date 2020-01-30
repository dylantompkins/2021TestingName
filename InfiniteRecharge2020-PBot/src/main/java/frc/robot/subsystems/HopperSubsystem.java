package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


/**
 * The elevator subsystem
 */
public class HopperSubsystem extends SubsystemBase {

    private final CANSparkMax m_hopperMotor;
    private final WPI_TalonSRX m_stopperMotor;

    public HopperSubsystem() {
        m_hopperMotor = new CANSparkMax(Constants.kHopperChannel, MotorType.kBrushless);
        m_stopperMotor = new WPI_TalonSRX(Constants.kStopperChannel);
    }
    public void hopperOn() {
        m_hopperMotor.set(Constants.kHopperForwardSpeed);
    }

    public void hopperReverse() {
        m_hopperMotor.set(Constants.kHopperReverseSpeed);
    }

    public void hopperStop() {
        m_hopperMotor.set(0);
    }

    public void stopperOn() {
        m_stopperMotor.set(Constants.kStopperForwardSpeed);
    }

    public void stopperOff() {
        m_stopperMotor.set(0);
    }

    public void stopperReverse() {
        m_stopperMotor.set(Constants.kStopperReverseSpeed);
    }
}