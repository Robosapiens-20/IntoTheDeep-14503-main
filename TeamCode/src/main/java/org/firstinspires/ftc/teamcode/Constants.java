package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.hardware.CRServo;

import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.robotcore.hardware.DigitalChannel;

import com.qualcomm.robotcore.hardware.ColorSensor;

public class Constants{

    public static DcMotor intake;

    public static DcMotor lf;

    public static DcMotor lb;

    public static DcMotor rf;

    public static DcMotor rb;

    public static DcMotor ls;

    public static DcMotor rs;

    public static DcMotor winch;

    public static Servo claw;

    public static Servo clawWrist;

    public static Servo linkage1;

    public static Servo linkage2;

    public static Servo intakeDrop1;

    public static Servo intakeDrop2;

    public static Servo intakeWrist;

    public static Servo outtakeArmL;

    public static Servo outtakeArmR;

    public static Servo clawArm;

    public static Limelight3A limelight;

    public static void initHardware(HardwareMap hardwareMap){
        lf = hardwareMap.dcMotor.get("lf");

        lb = hardwareMap.dcMotor.get("lb");

        rf = hardwareMap.dcMotor.get("rf");

        rb = hardwareMap.dcMotor.get("rb");

        intake = hardwareMap.dcMotor.get("intake");

        ls = hardwareMap.dcMotor.get("ls");

        rs = hardwareMap.dcMotor.get("rs");

        winch = hardwareMap.dcMotor.get("winch");

        linkage1 = hardwareMap.servo.get("linkage1");

        linkage2 = hardwareMap.servo.get("linkage2");

        claw = hardwareMap.servo.get("claw");

        clawWrist = hardwareMap.servo.get("clawWrist");

        clawArm = hardwareMap.servo.get("clawArm");

        intakeWrist = hardwareMap.servo.get("intakeWrist");

        intakeDrop1 = hardwareMap.servo.get("intakeDrop1");

        intakeDrop2 = hardwareMap.servo.get("intakeDrop2");

        outtakeArmL = hardwareMap.servo.get("outtakeArmL");

        outtakeArmR = hardwareMap.servo.get("outtakeArmR");

        limelight = hardwareMap.get(Limelight3A.class, "limelight");
    }

}

