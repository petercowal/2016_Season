package org.usfirst.frc.team2374.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;

public class Shooter {
	Talon wheel;
	Encoder wheelEncoder;

	public Shooter(int wheelPort, int encoderPort1, int encoderPort2) { // Remember
																		// to
																		// add
																		// up-down
																		// functionality
																		// with
																		// the
																		// wheel!
		wheel = new Talon(wheelPort);
		wheelEncoder = new Encoder(encoderPort1, encoderPort2, true,
				EncodingType.k4X); // Please look into how encoders really work
									// in the context of the wheel
									// and which ports they should use with
									// respect to the wheel;
									// also look into the constructor for the
									// encoder and encoding
									// types and all that jazz

	}

	boolean wheelForwardEngaged = false;
	boolean wheelReverseEngaged = false;

	public void update(double wheelSpeed, boolean forwardWheelButtonPressed,
			boolean reverseWheelButtonPressed) { // Comment through this method
													// for review and/or clarity
		if (forwardWheelButtonPressed) {
			wheelForwardEngaged = !wheelForwardEngaged;
		}
		if (wheelForwardEngaged) {
			wheel.set(wheelSpeed);
		}
		if (!wheelForwardEngaged) {
			wheel.set(0);
		}
		if (reverseWheelButtonPressed) {
			wheelReverseEngaged = !wheelReverseEngaged;
		}
		if (wheelReverseEngaged) {
			wheel.set(-wheelSpeed);
		}
		if (!wheelReverseEngaged) {
			wheel.set(0);
		}
		if (wheelForwardEngaged && wheelReverseEngaged) {
			wheel.set(-wheelSpeed);
			wheelForwardEngaged = false;
		}
	}

	public double getRate() {
		return wheelEncoder.getRate();
	}

	double prevError;

	public double Integrate(double voltage) {
		double integral = 0;

		return integral;
	}

	double motorVoltage = 0;
	double integral;

	public void PID(double target) {
		double error = getRate() - target;
		double P = 0.005;
		double I = 0.00005;
		double D = -0.005;
		if (Math.abs(error) >= 0) { // WE DEFINITELY NEED TO CHANGE THAT
			motorVoltage += (error * P) + (error - prevError) * D
					+ (integral * I);
			if (motorVoltage > 1) {
				motorVoltage = 1;
			} else if (motorVoltage < -1) {
				motorVoltage = -1;
			}
			wheel.set(motorVoltage);
			integral += error;
			prevError = error;
		}
	}
	
	public void resetPid(){
		prevError = 0;
		integral = 0;
		motorVoltage = 0;
	}
}