package org.usfirst.frc.team2374.robot;

import edu.wpi.first.wpilibj.Talon;

public class Intake {
	int intakePort;
	Talon talon;
	
	public Intake(int port){
		talon = new Talon(port);
	}
	public void update(double speed){
	}
}
