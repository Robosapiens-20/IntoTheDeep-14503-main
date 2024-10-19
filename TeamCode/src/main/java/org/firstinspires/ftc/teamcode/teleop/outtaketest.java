package org.firstinspires.ftc.teamcode.teleop;


import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.Constants;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp(name = "outtake test")
public class outtaketest extends LinearOpMode {

    Servo claw = null;
    Servo clawWrist = null;
    Servo outtakeArmR=null;
    Servo clawTurret = null;
    Servo intakeDrop1 = null;
    Servo intakeDrop2 = null;
    Gamepad g1 = gamepad1;
    Gamepad g2 = gamepad2;
    double clawpositionclosed = 0.16;
    double clawpositionopen = 0.3;
    @Override
    public void runOpMode() throws InterruptedException {
        g1 = gamepad1;
        g2 = gamepad2;

        g1.type = Gamepad.Type.SONY_PS4;
        g2.type = Gamepad.Type.SONY_PS4;
        Constants.initHardware(hardwareMap);
        intakeDrop1=Constants.intakeDrop1;
        intakeDrop2=Constants.intakeDrop2;


        outtakeArmR = Constants.outtakeArmR;
        clawWrist = Constants.clawWrist;
        claw = Constants.claw;
        clawTurret = Constants.clawArm;

        waitForStart();
        while(opModeIsActive()){
            //if(g1.square) {
                //outtakeArmR.setPosition(0.4);
                //claw.setPosition(0.4);
                //clawWrist.setPosition(0.5);
                //clawTurret.setPosition(0.5);
            //}
            if(g2.triangle) {
                //arm towards intake
                claw.setPosition(0);
                sleep(300);


                outtakeArmR.setPosition(0.07);

                clawWrist.setPosition(0.07);
                clawTurret.setPosition(0.55);
                //claw.setPosition(0);

            }
            if(g2.cross){
                intakeDrop1.setPosition(0.1);
                intakeDrop2.setPosition(-0.1);
            }
            if(g2.square){
                intakeDrop1.setPosition(-0.1);
                intakeDrop2.setPosition(0.1);
            }
            if(g2.circle) {
                //arm towards extake
                claw.setPosition(0.96);
                sleep(1000);
                outtakeArmR.setPosition(0.4);

                clawWrist.setPosition(0.5);
                clawTurret.setPosition(0);
            }
        }
    }
}