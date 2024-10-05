package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "IntakeTest")
public class TeleOpMain extends LinearOpMode {
    private DcMotor intake;

    @Override
    public void runOpMode() throws InterruptedException {
        intake = hardwareMap.dcMotor.get("intake");

        waitForStart();
        while(opModeIsActive()){
            intake.setPower(gamepad1.right_stick_y);
        }
    }
}
