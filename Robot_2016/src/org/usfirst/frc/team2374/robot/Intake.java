package org.usfirst.frc.team2374.robot;

import edu.wpi.first.wpilibj.Talon;

public class Intake {
	int intakePort;
	Talon intakeTalon;
	
	public Intake(int port){
		intakeTalon = new Talon(port);
	}
	public void update(double speed){
		intakeTalon.set(speed);
	}
}
