package org.firstinspires.ftc.teamcode;

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

    public static DcMotor hang;

    public static DcMotor ls;

    public static DcMotor rs;

    public static DcMotor winch;

    public static Servo claw;

    public static CRServo clawWrist;

    public static Servo linkage1;

    public static Servo linkage2;

    public static Servo intakeWrist1;

    public static Servo intakeWrist2;

    public static Servo outtakeArmL;

    public static Servo outtakeArmR;

    public static Servo clawArm;

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

        clawWrist = hardwareMap.crservo.get("clawWrist");

        clawArm = hardwareMap.servo.get("clawArm");

        intakeWrist1 = hardwareMap.servo.get("intakeWrist1");

        intakeWrist2 = hardwareMap.servo.get("intakeWrist2");

        outtakeArmL = hardwareMap.servo.get("outtakeArmL");

        outtakeArmR = hardwareMap.servo.get("outtakeArmR");
    }

}

