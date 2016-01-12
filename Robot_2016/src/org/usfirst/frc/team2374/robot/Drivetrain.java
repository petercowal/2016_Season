package org.usfirst.frc.team2374.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;

public class Drivetrain {
	Talon l1, l2, r1, r2;//talons, pretty normal
	Encoder encoder;
	int state;
	int counter;
	
	double targetHeading, targetDistance; //used for automatic movement
	
	public Drivetrain(){
		l1=new Talon(0);//ports, to be changed later
		l2=new Talon(1);
		r1=new Talon(2);
		r2=new Talon(3);	
		encoder=new Encoder(2,3);	
		targetHeading=0;
	}
}
