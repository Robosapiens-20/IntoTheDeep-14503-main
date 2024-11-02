package org.firstinspires.ftc.teamcode;

import android.view.ActionProvider;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.hardware.CRServo;

import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.robotcore.hardware.DigitalChannel;

import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.robotcore.external.Const;

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

    public static enum Intake{
        intakeRest,
        intakeOut
    }

    public static Intake intakeState = Intake.intakeRest;

    public static enum Outtake{
        outtakeRest,
        outtakeTransfer,
        outtakeOut,
        outtakeDeposit
    }
    public static Outtake outtakeState = Outtake.outtakeRest;


    public static void slideMovement(int position, double speed) {
        //Constants.slidePosCurrent += position;
        ls.setTargetPosition(position);
        rs.setTargetPosition(position);
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
    public static class intakeMove implements Action{
        //intake goes out, drops down, and turns intake on for 1 second
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            switch (intakeState){
                case intakeRest:
                    intakeDrop1.setPosition(intakeDropout);
                    intakeDrop2.setPosition(intakeDropout);
                    linkage1.setPosition(linkageOut);
                    linkage2.setPosition(linkageOut);
                    leftIntake.setPower(1);
                    rightIntake.setPower(1);
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    leftIntake.setPower(0);
                    rightIntake.setPower(0);
                    intakeState = Intake.intakeOut;
                case intakeOut:
                    //intake system goes back in
                    linkage1.setPosition(linkageIn);
                    linkage2.setPosition(linkageIn);
                    intakeDrop1.setPosition(intakeDropin);
                    intakeDrop2.setPosition(intakeDropin);
                default:
            }
            return false;
        }
    }
    public static Action intake(){
        return new intakeMove();
    }
    public static class clip implements Action{
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            outtakeArmR.setPosition(0.3);
            try {
                wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clawWrist.setPosition(0.45);
            clawArm.setPosition(0.1);
            return false;
        }
    }
    public static class scoreClip implements Action{

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            //slides go to clip bar
            slideMovement(Constants.slideTopClipPos,1);
            //slides go down after overshooting so clip goes down perfectly
            slideMovement(Constants.slideTopClipPos-150,1);
            //claw opens and outtake goes back towards the intake
            claw.setPosition(clawOpenPosition);
            clawArm.setPosition(0.65);
            clawWrist.setPosition(0.67);
            //slides go down
            slideMovement(0,1);
            //outtakeArm goes back
            outtakeArmR.setPosition(0.15);
            return false;
        }
    }
    public static class transfer implements Action{
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            claw.setPosition(clawOpenPosition);
            try {
                wait(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //moves arm towards the intake
            clawArm.setPosition(0.65);
            clawWrist.setPosition(0.67);
            outtakeArmR.setPosition(0.15);
            try {
                wait(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //drops system onto the block
            outtakeArmR.setPosition(0.08);
            try {
                wait(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //block gets gripped
            claw.setPosition(clawClosedPosition);
            try {
                wait(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //arm goes up to outtake position
            outtakeArmR.setPosition(0.3);
            try {
                wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //wrist and turret turn
            clawWrist.setPosition(0.45);
            clawArm.setPosition(0.1);
            return false;
        }
    }
    public static Action transfer(){
        return new transfer();
    }
    public static class deposit implements Action{
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            //slide goes up to the top basket position
            slideMovement(slideTopBasketPos,1);
            try {
                wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // wrist is set to flick block in
            clawWrist.setPosition(0.41);
            claw.setPosition(clawOpenPosition);
            clawWrist.setPosition(0.45);
            try {
                wait(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //outtake system goes back towards intake
            clawArm.setPosition(0.65);
            clawWrist.setPosition(0.67);
            outtakeArmR.setPosition(0.15);
            return false;
        }
    }
    public static Action deposit(){
        return new deposit();
    }
    public static Action firstScore(){
        return new scoreClip();
    }
    public static Action clips(){
        return new clip();
    }


}

