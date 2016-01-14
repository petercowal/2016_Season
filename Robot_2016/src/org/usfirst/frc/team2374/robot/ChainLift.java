package org.usfirst.frc.team2374.robot;

import edu.wpi.first.wpilibj.Talon;

public class ChainLift {
	Talon mainMotor;
	
	public ChainLift(int motorPort){
		mainMotor = new Talon(motorPort);
	}
	
	public void update(){
		/*
		 * Implement a method that takes an input of a raw axis and adjusts the motor speed accordingly
		 */
	}

}
