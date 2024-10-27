package org.firstinspires.ftc.teamcode.teleop;


import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.Constants;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp(name = "outtake test")
public class outtaketest extends LinearOpMode {
    DcMotor lf = null;
    DcMotor lb = null;
    DcMotor rb = null;
    DcMotor rf = null;
    Servo claw = null;
    Servo clawWrist = null;
    Servo outtakeArmL = null;
    Servo outtakeArmR=null;
    Servo clawTurret = null;
    Servo intakeDrop1 = null;
    Servo intakeDrop2 = null;
    CRServo rightIntake;
    CRServo leftIntake;
    Servo linkage1 = null;
    Servo linkage2=null;
    Gamepad g1 = gamepad1;
    Gamepad g2 = gamepad2;
     DcMotor ls = null;
     DcMotor rs = null;
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
        linkage1 = Constants.linkage1;
        linkage2 = Constants.linkage2;
        outtakeArmL=Constants.outtakeArmL;
       /* lf = Constants.lf;
        lb = Constants.lb;
        rb = Constants.rb;
        rf = Constants.rf;*/

        //rightIntake = Constants.rightIntake;
        //leftIntake = Constants.leftIntake;
        ls =Constants.ls;
        rs=Constants.rs;
        outtakeArmR = Constants.outtakeArmR;
        clawWrist = Constants.clawWrist;
        claw = Constants.claw;
        clawTurret = Constants.clawArm;
        clawpositionclosed= Constants.clawClosedPosition;
        clawpositionopen=Constants.clawOpenPosition;
        rightIntake = Constants.rightIntake;
        leftIntake = Constants.leftIntake;
        rightIntake.setDirection(CRServo.Direction.REVERSE);
        ls.setDirection(DcMotor.Direction.REVERSE);
        intakeDrop1.setPosition(0.9);
        intakeDrop2.setPosition(0.9);
        linkage1.setPosition(0.15);
        linkage2.setPosition(0.15);

        waitForStart();
        while(opModeIsActive()){
            double y = -g1.left_stick_y;
            double x = g1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = g1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            /*double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            lf.setPower(frontLeftPower);
            lb.setPower(backLeftPower);
            rf.setPower(frontRightPower);
            rb.setPower(backRightPower);*/
            if(g2.triangle) {
                //arm towards intake
                claw.setPosition(clawpositionclosed);
                sleep(300);


                outtakeArmR.setPosition(0.27);

                clawWrist.setPosition(0.22);
                clawTurret.setPosition(0.5);
                //claw.setPosition(0);

            }
            if(g2.triangle) {
                //arm towards intake
                claw.setPosition(clawpositionopen);
                sleep(300);


                outtakeArmR.setPosition(0.27);

                clawWrist.setPosition(0.22);
                clawTurret.setPosition(0.5);
                //claw.setPosition(0);

            }
            if(g2.circle) {
                //arm towards extake
                claw.setPosition(clawpositionclosed);
                sleep(1000);
                outtakeArmR.setPosition(0.4);
                sleep(1000);
                clawWrist.setPosition(0.5);
                clawTurret.setPosition(0);
            }
            if(g1.cross){
                intakeDrop1.setPosition(0.9);
                intakeDrop2.setPosition(0.9);
            }
            if(g1.square){
                intakeDrop1.setPosition(0);
                intakeDrop2.setPosition(0);

            }
            if(g2.circle) {
                //arm towards extake
                claw.setPosition(clawpositionopen);
                sleep(1000);
                outtakeArmR.setPosition(0.4);
                sleep(1000);
                clawWrist.setPosition(0.5);
                clawTurret.setPosition(0);
            }
            if(g1.dpad_left){
                linkage1.setPosition(0.15);
                linkage2.setPosition(0.15);
            }
            if(g1.dpad_right){
                linkage1.setPosition(0);
                linkage2.setPosition(0);
            }
            telemetry.addData("Lift left Encoder Value: ",ls.getCurrentPosition());
            telemetry.addData("Lift right Encoder Value: ", rs.getCurrentPosition());
            telemetry.addData("LinkageL Position: ", linkage1.getPosition());
            telemetry.addData("LinkageR Position: ", linkage2.getPosition());
            telemetry.addData("Intake Drop Left Position", intakeDrop1.getPosition());
            telemetry.addData("Intake Drop Right Position", intakeDrop2.getPosition());
            telemetry.update();

            rightIntake.setPower(g1.right_trigger);
            rightIntake.setDirection(CRServo.Direction.REVERSE);
            leftIntake.setPower(g1.right_trigger);
            ls.setPower(-g2.left_stick_y);
            rs.setPower(-g2.left_stick_y);
            if(g2.dpad_up){
                Constants.slideMovement(Constants.slideTopBasketPos,1);
                while(ls.isBusy() && rs.isBusy()) {
                    idle();
                }

            }


        }


    }


}