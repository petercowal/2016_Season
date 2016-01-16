package org.usfirst.frc.team2374.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ButtonControl {
	Joystick controller;
	Shooter shooter;
	ChainLift chainLift;
	Drivetrain drivetrain;
	Intake intake;
	double speed;
	public ButtonControl(Shooter s, ChainLift c, Drivetrain d, Intake i){
		shooter = s;
		chainLift = c;
		drivetrain = d;
		intake = i;
		controller = new Joystick(0);
		shooter.update(speed, controller.getRawButton(5), controller.getRawButton(6));
	}
}