package org.usfirst.frc.team2374.robot;

import edu.wpi.first.wpilibj.Talon;

public class ChainLift {
	Talon mainMotor;
	
	public ChainLift(int motorPort){
		mainMotor = new Talon(motorPort); //This is a motor
	}
	
	public void update(double rawAxis){
		/*
		 * Implement a method that takes an input of a raw axis as a parameter
		 * and adjusts the motor speed accordingly
		 */
		mainMotor.set(rawAxis);
	}

}
