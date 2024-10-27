package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Constants;

@Autonomous(name = "FreakySlidesTesting")
public class SlidePositionTest extends LinearOpMode {
    static DcMotor ls = null;
    static DcMotor rs = null;

    @Override
    public void runOpMode() throws InterruptedException {
        Constants.initHardware(hardwareMap);
        ls = Constants.ls;
        rs = Constants.rs;
        ls.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rs.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ls.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        if (opModeIsActive()) {
            slideMovement(Constants.slideTopBasketPos, 0.8);
        }

    }
    public void slideMovement(int position, double speed) {
        ls.setTargetPosition(position);
        rs.setTargetPosition(position);
        rs.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ls.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ls.setPower(speed);
        rs.setPower(speed);
        while(ls.isBusy()&&rs.isBusy()&&opModeIsActive()){
            idle();
        }

    }

}
