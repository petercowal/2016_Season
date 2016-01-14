package org.usfirst.frc.team2374.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Drivetrain {
	Talon l1, l2, r1, r2;// talons, pretty normal
	Encoder encoder;
	DoubleSolenoid solenoidBack, solenoidFront; // two solenoids, in the future
												// specify or modify these names
												// based on the placement on the
												// robot, for specification's
												// sake
	int state;
	int counter;

	double targetHeading, targetDistance; // used for automatic movement

	public Drivetrain() {
		l1 = new Talon(0);// ports, to be changed later
		l2 = new Talon(1);
		r1 = new Talon(2);
		r2 = new Talon(3);
		encoder = new Encoder(8, 9); // Change ports later if necessary
		targetHeading = 0;
		solenoidBack = new DoubleSolenoid(4, 5); // CHANGE PORTS LATER
		solenoidFront = new DoubleSolenoid(6, 7); // CHANGE THE PORTS PLEASE
	}

	boolean backSolCanPress = true;
	boolean frontSolCanPress = true;

	public void update(double leftSpeed, double rightSpeed,
			boolean backSolButtonPressed, boolean frontSolButtonPressed) { // perhaps revise the names in the future for the sake of succinctness

		l1.set(leftSpeed);
		l2.set(leftSpeed);
		r1.set(rightSpeed);
		r2.set(rightSpeed);
		if (backSolButtonPressed) { // REVISE THIS METHOD PLEASE
			if (backSolCanPress) {
				if (solenoidBack.get() == DoubleSolenoid.Value.kOff) {
					solenoidBack.set(DoubleSolenoid.Value.kForward);
				} else if (solenoidBack.get() == DoubleSolenoid.Value.kForward) {
					solenoidBack.set(DoubleSolenoid.Value.kReverse);
				} else if (solenoidBack.get() == DoubleSolenoid.Value.kReverse) {
					solenoidBack.set(DoubleSolenoid.Value.kForward);
				}
				backSolCanPress = false;
			} else {
				backSolCanPress = true;
			}
		}
		if (frontSolButtonPressed) {
			if (solenoidFront.get() == DoubleSolenoid.Value.kOff) {
				solenoidFront.set(DoubleSolenoid.Value.kForward);
			}
			if (solenoidFront.get() == DoubleSolenoid.Value.kForward) {
				solenoidFront.set(DoubleSolenoid.Value.kReverse);
			}
			if (solenoidFront.get() == DoubleSolenoid.Value.kReverse) {
				solenoidFront.set(DoubleSolenoid.Value.kForward);
			}
			frontSolCanPress = false;
		} else {
			frontSolCanPress = true;
		}
	}
}
