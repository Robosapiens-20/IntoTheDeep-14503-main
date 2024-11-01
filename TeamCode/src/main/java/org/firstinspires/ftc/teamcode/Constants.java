package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
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
    public static double clawOpenPosition = 0.89;
    public static double clawClosedPosition = 0.73;
    public static int slideTopBasketPos = 2116;
    public static CRServo rightIntake = null;
    public static int slideTopClipPos = 1754;
    public static int slideBottomBasketPos = 1024;
    public static CRServo leftIntake = null;
    public static int slidePosCurrent = 0;
    public static double intakeDropin = 0;
    public static double intakeDropout = 0.93;
    public static double linkageIn = 0.15;
    public static double linkageOut = 0;
    public static Pose2d startPosBucketBlue = new Pose2d(35, 70, Math.toRadians(-90));
    public static Pose2d firstClip = new Pose2d(0, 40, Math.toRadians(90));
    public static int clipPositon = 34;
    public static Pose2d firstSamplePickup = new Pose2d(48,42,Math.toRadians(-90));
    public static Pose2d toBucket = new Pose2d(56,56,Math.toRadians(-135));
    public static double turnTowardsScoring = Math.toRadians(-135);
    public static double secondSamplePickup = Math.toRadians(-87);
    public static double thirdSamplePickup = Math.toRadians(295);
    public static void slideMovement(int position, double speed){
        Constants.slidePosCurrent+=position;
        ls.setTargetPosition(Constants.slidePosCurrent);
        rs.setTargetPosition(Constants.slidePosCurrent);
        rs.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ls.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ls.setPower(speed);
        rs.setPower(speed);


    }

    public static void initHardware(HardwareMap hardwareMap){
        lf = hardwareMap.dcMotor.get("lf");

        lb = hardwareMap.dcMotor.get("lb");

        rf = hardwareMap.dcMotor.get("rf");

        rb = hardwareMap.dcMotor.get("rb");

        ls = hardwareMap.dcMotor.get("ls");
        ls.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ls.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ls.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rs = hardwareMap.dcMotor.get("rs");
        rs.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rs.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rs.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

       // winch = hardwareMap.dcMotor.get("winch");

        linkage1 = hardwareMap.servo.get("linkage1");

        linkage2 = hardwareMap.servo.get("linkage2");

        rightIntake = hardwareMap.crservo.get("rightIntake");
        leftIntake = hardwareMap.crservo.get("leftIntake");

        claw = hardwareMap.servo.get("claw");

        clawWrist = hardwareMap.servo.get("clawWrist");

        clawArm = hardwareMap.servo.get("clawArm");

     intakeDrop1 = hardwareMap.servo.get("intakeDrop1");

     intakeDrop2 = hardwareMap.servo.get("intakeDrop2");

       // outtakeArmL = hardwareMap.servo.get("outtakeArmL");

        outtakeArmR = hardwareMap.servo.get("outtakeArmR");
       // ls.setDirection(DcMotorSimple.Direction.REVERSE);

      //limelight = hardwareMap.get(Limelight3A.class, "limelight");
    }

}

