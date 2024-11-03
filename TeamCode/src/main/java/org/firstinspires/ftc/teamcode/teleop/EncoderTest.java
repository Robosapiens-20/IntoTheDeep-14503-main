package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Constants;
@TeleOp
public class EncoderTest extends LinearOpMode {
    DcMotor lf =null;
    DcMotor rf =null;
    DcMotor rb =null;
    DcMotor lb =null;

    @Override
    public void runOpMode() throws InterruptedException {
        Constants.initHardware(hardwareMap);
        lf=Constants.lf;
        rf=Constants.rf;
        rb=Constants.rb;
        lb=Constants.lb;
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitForStart();
        while(opModeIsActive()){
            telemetry.addData("Par0: ",lb.getCurrentPosition());
            telemetry.addData("Par1: ", rf.getCurrentPosition());
            telemetry.addData("Perp: ", rb.getCurrentPosition());
            telemetry.update();
        }
    }
}
