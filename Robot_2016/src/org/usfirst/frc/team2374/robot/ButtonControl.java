package org.usfirst.frc.team2374.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ButtonControl {
	Joystick controller; //Controller to manage all of the systems
	/*
	 * Below, all of the systems are implemented.
	 */
	Shooter shooter;
	ChainLift chainLift;
	Drivetrain drivetrain;
	Intake intake;
	double shooterSpeed;
	public ButtonControl(Shooter s, ChainLift c, Drivetrain d, Intake i){
		shooter = s;
		chainLift = c;
		drivetrain = d;
		intake = i;
		controller = new Joystick(0);
		shooter.update(shooterSpeed, controller.getRawButton(5), controller.getRawButton(6));
		boolean backSolPressed=controller.getRawAxis(2)!=0;
		boolean frontSolPressed=controller.getRawAxis(3)!=0;
		drivetrain.update(controller.getRawAxis(1), controller.getRawAxis(5), frontSolPressed, backSolPressed);
	}
	
	public void update(){
		
	}
}