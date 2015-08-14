package org.usfirst.frc4904.cmdbased.subsystems.motor;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class EncodedMotor extends PIDSubsystem implements SpeedController {
	protected final SpeedController motor;
	protected final Encoder encoder;
	
	public EncodedMotor(String name, double P, double I, double D, SpeedController motor, Encoder encoder) {
		super(name, P, I, D);
		this.motor = motor;
		this.encoder = encoder;
		setOutputRange(-1, 1);
		getPIDController().setContinuous(false);
	}
	
	protected void initDefaultCommand() {}
	
	protected double returnPIDInput() {
		return encoder.getRate();
	}
	
	protected void usePIDOutput(double speed) {
		motor.set(speed);
	}
	
	public void set(double speed) {
		setSetpoint(speed);
	}
	
	public void pidWrite(double speed) {
		set(speed);
	}
	
	public double get() {
		return motor.get();
	}
	
	public void set(double speed, byte arg1) {
		set(speed);
	}
}