package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Constants;

@TeleOp(name = "IntakeTest")
public class TeleOpMain extends LinearOpMode {
    DcMotor lf = null;

    DcMotor lb = null;

    DcMotor rb = null;

    DcMotor rf = null;

    DcMotor ls =null;

    DcMotor rs = null;

    DcMotor intake = null;
    @Override
    public void runOpMode() throws InterruptedException {

        Constants.initHardware(hardwareMap);
        lf = Constants.lf;
        lb = Constants.lb;
        rb = Constants.rb;
        rf= Constants.rf;
        intake = Constants.intake;
        rs = Constants.rs;
        ls = Constants.ls;
        waitForStart();
        while(opModeIsActive()){
            double y = gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

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
            intake.setPower(gamepad2.right_stick_x);
            ls.setPower(-gamepad2.left_stick_y);
            rs.setPower(gamepad2.left_stick_y);


        }
    }
}
