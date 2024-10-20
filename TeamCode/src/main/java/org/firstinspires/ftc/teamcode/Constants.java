package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.hardware.CRServo;

import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.robotcore.hardware.DigitalChannel;

import com.qualcomm.robotcore.hardware.ColorSensor;

public class Constants{

    public static DcMotor intake = null;

    public static DcMotor lf = null;

    public static DcMotor lb = null;

    public static DcMotor rf = null;

    public static DcMotor rb = null;

    public static DcMotor ls = null;

    public static DcMotor rs = null;

    public static DcMotor winch = null;

    public static Servo claw = null;

    public static Servo clawWrist = null;

    public static Servo linkage1 = null;

    public static Servo linkage2 = null;

    public static Servo intakeDrop1 = null;

    public static Servo intakeDrop2 = null;

    public static Servo outtakeArmL = null;

    public static Servo outtakeArmR = null;

    public static Servo clawArm = null;

    public static Limelight3A limelight = null;

    public static CRServo rightIntake = null;

    public static CRServo leftIntake = null;

    public static void initHardware(HardwareMap hardwareMap){
        /*lf = hardwareMap.dcMotor.get("lf");

        lb = hardwareMap.dcMotor.get("lb");

        rf = hardwareMap.dcMotor.get("rf");

        rb = hardwareMap.dcMotor.get("rb");

        intake = hardwareMap.dcMotor.get("intake");

        ls = hardwareMap.dcMotor.get("ls");

        rs = hardwareMap.dcMotor.get("rs");

        winch = hardwareMap.dcMotor.get("winch");

        linkage1 = hardwareMap.servo.get("linkage1");

        linkage2 = hardwareMap.servo.get("linkage2");*/

        rightIntake = hardwareMap.crservo.get("rightIntake");
        leftIntake = hardwareMap.crservo.get("leftIntake");

        claw = hardwareMap.servo.get("claw");

        clawWrist = hardwareMap.servo.get("clawWrist");

        clawArm = hardwareMap.servo.get("clawArm");

     intakeDrop1 = hardwareMap.servo.get("intakeDrop1");

     intakeDrop2 = hardwareMap.servo.get("intakeDrop2");

        outtakeArmL = hardwareMap.servo.get("outtakeArmL");

        outtakeArmR = hardwareMap.servo.get("outtakeArmR");

     // limelight = hardwareMap.get(Limelight3A.class, "limelight");
    }

}

