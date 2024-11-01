package org.firstinspires.ftc.teamcode.teleop;

//
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
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
   // Servo outtakeArmL = null;
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
       // outtakeArmL=Constants.outtakeArmL;
        lf = Constants.lf;
        lb = Constants.lb;
        rb = Constants.rb;
        rf = Constants.rf;
        lf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.REVERSE);

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
        intakeDrop1.setPosition(Constants.intakeDropin);
        intakeDrop2.setPosition(Constants.intakeDropin);
        linkage1.setPosition(Constants.linkageIn);
        linkage2.setPosition(Constants.linkageIn);
        boolean clawOpened = false;

        waitForStart();
        while(opModeIsActive()){
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
            if(g2.triangle) {
                //arm towards intake
                claw.setPosition(clawpositionopen);
                sleep(300);
                clawTurret.setPosition(0.65);
                clawWrist.setPosition(0.67);
               outtakeArmR.setPosition(0.15);
                //claw.setPosition(0);
            }
            if(g2.circle) {
                //arm towards extake
                outtakeArmR.setPosition(0.08);
                sleep(1000);
                claw.setPosition(clawpositionclosed);
                sleep(1000);
                outtakeArmR.setPosition(0.3);
                sleep(1000);
                clawWrist.setPosition(0.45);
                clawTurret.setPosition(0.1);
            }
            if(g2.dpad_down){
                clawWrist.setPosition(0.41);
                claw.setPosition(clawpositionopen);
                clawWrist.setPosition(0.45);
                sleep(300);
                clawTurret.setPosition(0.65);
                clawWrist.setPosition(0.67);
                outtakeArmR.setPosition(0.15);
            }
            if(g1.cross){
                intakeDrop1.setPosition(Constants.intakeDropout);
                intakeDrop2.setPosition(Constants.intakeDropout);
            }
            if(g1.square){
                intakeDrop1.setPosition(Constants.intakeDropin);
                intakeDrop2.setPosition(Constants.intakeDropin);
            }
            if(g1.dpad_left){
                linkage1.setPosition(Constants.linkageIn);
                linkage2.setPosition(Constants.linkageIn);
            }
            if(g1.dpad_right){
                linkage1.setPosition(Constants.linkageOut);
                linkage2.setPosition(Constants.linkageOut);
            }
            if(g2.left_bumper){
                outtakeArmR.setPosition(0.45);
                sleep(1000);
                clawWrist.setPosition(0.1);
                clawTurret.setPosition(0);
            }
            if(g2.right_bumper){
                claw.setPosition(clawpositionopen);
                outtakeArmR.setPosition(0.76);
                sleep(1000);
                clawTurret.setPosition(0.25);
                sleep(300);
                clawWrist.setPosition(0.1);
            }
            if(claw.getPosition() == clawpositionclosed){
                clawOpened = false;
            } else if(claw.getPosition() == clawpositionopen){
                clawOpened = true;
            }

            if(g2.cross && clawOpened){
                claw.setPosition(clawpositionclosed);
                sleep(200);
            } else if(g2.cross && clawOpened==false){
                claw.setPosition(clawpositionopen);
                sleep(200);
            }
            telemetry.addData("Lift left Encoder Value: ",ls.getCurrentPosition());
            telemetry.addData("Lift right Encoder Value: ", rs.getCurrentPosition());
            telemetry.addData("LinkageL Position: ", linkage1.getPosition());
            telemetry.addData("LinkageR Position: ", linkage2.getPosition());
            telemetry.addData("Intake Drop Left Position", intakeDrop1.getPosition());
            telemetry.addData("Intake Drop Right Position", intakeDrop2.getPosition());
            telemetry.addData("Claw Wrist Position: ", clawWrist.getPosition());
            telemetry.update();
           // if(g2.left_trigger>0.01||g2.right_trigger>0.01){
              //  clawWrist.setPosition(clawWrist.getPosition()+g2.left_trigger-g2.right_trigger);
            //}
            rightIntake.setPower(g1.right_trigger-g1.left_trigger);
            rightIntake.setDirection(CRServo.Direction.REVERSE);
            leftIntake.setPower(g1.right_trigger-g1.left_trigger);
            ls.setPower(-g2.left_stick_y);
            rs.setPower(-g2.left_stick_y);
            if(g2.dpad_up){
                slideMovement(Constants.slideTopBasketPos,1);
            }
            if(g2.dpad_left){
                slideMovement(Constants.slideTopClipPos,1);
            }
            if(g2.dpad_right){
                slideMovement(Constants.slideBottomBasketPos,1);
            }

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