package org.usfirst.frc.team2374.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;

public class Shooter {
	Talon wheel;
	Encoder wheelEncoder; 

	public Shooter(int wheelPort, int encoderPort1, int encoderPort2) { //Remember to add up-down functionality with the wheel!
		wheel = new Talon(wheelPort);
		wheelEncoder = new Encoder(encoderPort1, encoderPort2, true,
				EncodingType.k4X); 	// Please look into how encoders really work
									// in the context of the wheel
									// and which ports they should use with respect to the wheel;
									// also look into the constructor for the encoder and encoding
									// types and all that jazz

	}

	public void update(double wheelSpeed, boolean wheelButtonPressed) {
		if (wheelButtonPressed) {
			wheel.set(wheelSpeed);
		}
	}
	
	public double getRate(){
		return wheelEncoder.getRate();
	}
}
