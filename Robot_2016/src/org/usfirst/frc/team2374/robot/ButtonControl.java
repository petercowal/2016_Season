package org.usfirst.frc.team2374.robot;

public class ButtonControl {
	
	Shooter shooter;
	ChainLift chainLift;
	Drivetrain drivetrain;
	Intake intake;
	
	public ButtonControl(Shooter s, ChainLift c, Drivetrain d, Intake i){
		shooter = s;
		chainLift = c;
		drivetrain = d;
		intake = i;
	}
}