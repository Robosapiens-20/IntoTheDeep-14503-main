package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

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


    }
}
