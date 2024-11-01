package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.Constants;

@TeleOp
public class ClipCodeSnippet extends LinearOpMode {
    private DcMotor ls;
    private DcMotor rs;
    private Servo claw;
    private Servo clawWrist;
    private Servo clawTurret;
    private Servo outtakeArmR;
    @Override
    public void runOpMode(){
        ls=Constants.ls;
        rs=Constants.rs;
        outtakeArmR = Constants.outtakeArmR;
        clawWrist = Constants.clawWrist;
        claw = Constants.claw;
        clawTurret = Constants.clawArm;
        claw.setPosition(Constants.clawOpenPosition);
        sleep(300);
        clawTurret.setPosition(0.65);
        clawWrist.setPosition(0.67);
        outtakeArmR.setPosition(0.15);
        sleep(300);
        outtakeArmR.setPosition(0.08);
        sleep(1000);
        claw.setPosition(Constants.clawClosedPosition);
        sleep(1000);
        outtakeArmR.setPosition(0.3);
        sleep(1000);
        clawWrist.setPosition(0.45);
        clawTurret.setPosition(0.1);
        slideMovement(Constants.slideTopBasketPos,1);
        clawWrist.setPosition(0.41);
        claw.setPosition(Constants.clawOpenPosition);
        clawWrist.setPosition(0.45);
        sleep(300);
        clawTurret.setPosition(0.65);
        clawWrist.setPosition(0.67);

        outtakeArmR.setPosition(0.15);


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
