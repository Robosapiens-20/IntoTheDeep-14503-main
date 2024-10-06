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

    public static Servo extendo;

    public static Servo claw;

    public static Servo clawWrist;

    public static Servo unnamed1;

    public static Servo unnamed2;
    public static void initHardware(HardwareMap hardwareMap){
        lf = hardwareMap.dcMotor.get("lf");

        lb = hardwareMap.dcMotor.get("lb");

        rf = hardwareMap.dcMotor.get("rf");

        rb = hardwareMap.dcMotor.get("rb");

        intake = hardwareMap.dcMotor.get("intake");

        ls = hardwareMap.dcMotor.get("ls");

        rs = hardwareMap.dcMotor.get("rs");



    }

}

