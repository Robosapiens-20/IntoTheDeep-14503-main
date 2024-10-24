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

@TeleOp(name = "YAY-TELEOP!!!!!")
public class TeleOpMain extends LinearOpMode {
    DcMotor lf = null;
    DcMotor lb = null;
    DcMotor rb = null;
    DcMotor rf = null;
    DcMotor ls = null;
    DcMotor rs = null;
    DcMotor intake = null;
    DcMotor winch = null;
    Servo claw = null;
    Servo clawWrist = null;
    Servo linkage1 = null;
    Servo linkage2 = null;
    Servo intakeDrop1 = null;
    Servo intakeDrop2 = null;
    Servo outtakeArmL = null;
    Servo outtakeArmR = null;

    Gamepad g1 = gamepad1;
    Gamepad g2 = gamepad2;
    Limelight3A limelight;

    @Override
    public void runOpMode() throws InterruptedException {
        g1 = gamepad1;
        g2 = gamepad2;

        g1.type = Gamepad.Type.SONY_PS4;
        g2.type = Gamepad.Type.SONY_PS4;
        Constants.initHardware(hardwareMap);
        limelight = Constants.limelight;
        winch = Constants.winch;
        lf = Constants.lf;
        lb = Constants.lb;
        rb = Constants.rb;
        rf = Constants.rf;
        linkage1 = Constants.linkage1;
        linkage2 = Constants.linkage2;
        intakeDrop1 = Constants.intakeDrop1;
        intakeDrop2 = Constants.intakeDrop2;
        outtakeArmL = Constants.outtakeArmL;
        outtakeArmR = Constants.outtakeArmR;
        clawWrist = Constants.clawWrist;
        intake = Constants.intake;
        rs = Constants.rs;
        ls = Constants.ls;
        claw = Constants.claw;

        waitForStart();
        while (opModeIsActive()) {
            double y = -g1.left_stick_y;
            double x = g1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = g1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            lf.setPower(frontLeftPower);
            lb.setPower(backLeftPower);
            rf.setPower(frontRightPower);
            rb.setPower(backRightPower);
            intake.setPower(g1.right_trigger);
            intake.setPower(-g1.left_trigger);
            ls.setPower(-g2.left_stick_y);
            rs.setPower(g2.left_stick_y);
            int i = 0;
            if (g2.circle)
                clawWrist.setPosition(1);
            if (g2.square)
                clawWrist.setPosition(0);
            if (g2.cross && i == 1) {
                outtakeArmL.setPosition(1);
                outtakeArmR.setPosition(1);
                i = 0;
            }
            if (g2.cross && i == 0) {
                outtakeArmL.setPosition(0);
                outtakeArmR.setPosition(0);
                i = 1;
            }
            if (g1.dpad_up) {
                linkage2.setPosition(1);
                linkage1.setPosition(1);
            }
            if (g1.dpad_down) {
                linkage1.setPosition(0);
                linkage2.setPosition(0);
            }
            if (g1.triangle) {
                intakeDrop1.setPosition(1);
                intakeDrop2.setPosition(1);
            }
            if (g1.cross) {
                intakeDrop1.setPosition(0);
                intakeDrop2.setPosition(0);
            }
            if (g2.left_bumper) {
                claw.setPosition(0);
            }
            if (g2.right_bumper)
                claw.setPosition(1);

        }

    }
}