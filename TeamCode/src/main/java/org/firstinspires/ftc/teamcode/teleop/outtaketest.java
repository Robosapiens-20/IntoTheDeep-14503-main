package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.Constants;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp(name = "outtake test")
public class outtaketest extends LinearOpMode {

    Servo claw = null;
    Servo clawWrist = null;
    Servo outtakeArmL= null;
    Servo outtakeArmR=null;

    Gamepad g1 = gamepad1;
    Gamepad g2 = gamepad2;
    @Override
    public void runOpMode() throws InterruptedException {
        g1 = gamepad1;
        g2 = gamepad2;

        g1.type = Gamepad.Type.SONY_PS4;
        g2.type = Gamepad.Type.SONY_PS4;
        Constants.initHardware(hardwareMap);

        outtakeArmL = Constants.outtakeArmL;
        outtakeArmR = Constants.outtakeArmR;
        clawWrist = Constants.clawWrist;
        claw = Constants.claw;

        waitForStart();
        while(opModeIsActive()){

            if(g1.circle) {
                outtakeArmR.setPosition(0.4);
                claw.setPosition(0);
                clawWrist.setPosition(0.5);
            }
            if(g1.triangle) {
                outtakeArmR.setPosition(0.1);
                claw.setPosition(0.7);
                clawWrist.setPosition(0);
            }
        }
    }
}