package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
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
public class ElevatorSubsystem extends SubsystemBase {

    private DigitalInput m_elevatorTopSwitch;
    private Spark m_elevatorMotor;

    final int m_ELEVATOR_UP_SPEED = 1;

    //returned into commands from methods to enable isFinished() 
    //functionality
    boolean m_isFinished = false;

    //returned into methods to enable isfinshed() functionality
    boolean m_finished = false;

    public ElevatorSubsystem(){
        m_elevatorMotor = new Spark(Constants.kElevatorChannel);
        m_elevatorTopSwitch = new DigitalInput(Constants.kElevatorTopSwitchPort);
    }
    //move elevator to the top
    public boolean elevatorTop() { //make this while held so loop doesn't continue
        if (m_elevatorTopSwitch.get() == true){ //if the top switch is not pressed
            m_elevatorMotor.set(m_ELEVATOR_UP_SPEED); //spin motor to move elevator up HOW FAST AND WHAT DIRECTION
        }
        m_isFinished = elevatorLimit();
        return m_isFinished;
    }

    public boolean elevatorLimit(){
        while(m_elevatorMotor.get() != 0) { //while the motor is in motion
            // if the either switch is pushed in
            if (m_elevatorTopSwitch.get() == false /* || elevatorBottomSwitch.get() == false */) { 
                m_elevatorMotor.set(0); //stop the motor
                m_finished = true;
            }
        }
        if (m_elevatorMotor.get() == 0){ //fixes a bug where if the elevator is already at the limit and this method is called, it returns false, even though the command should not continue
            m_finished = true;
        }
        return m_finished;
    }
}