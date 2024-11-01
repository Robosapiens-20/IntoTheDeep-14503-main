package org.firstinspires.ftc.teamcode.auton;

import androidx.annotation.NonNull;

// RR-specific imports
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;

// Non-RR imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.Constants;
@Config
@Autonomous(name = "BucketAutonBlue", group = "Autonomous")
public class TemplateRR1 extends LinearOpMode {
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
    public static DcMotor ls = null;
    public static DcMotor rs = null;

    @Override
    public void runOpMode() throws InterruptedException {

        Constants.initHardware(hardwareMap);
        ls =Constants.ls;
        rs=Constants.rs;
        MecanumDrive drive = new MecanumDrive(hardwareMap, Constants.startPosBucketBlue);
        TrajectoryActionBuilder tab1 = drive.actionBuilder(Constants.startPosBucketBlue)
                .setTangent(-10)
                .splineToSplineHeading(Constants.firstClip, Math.PI / 2);


        TrajectoryActionBuilder tab2 = drive.actionBuilder(drive.pose)
                .lineToY(Constants.clipPositon);


        TrajectoryActionBuilder tab3 = drive.actionBuilder(drive.pose)
                .setTangent(0)
                .splineToSplineHeading(Constants.firstSamplePickup,0);
        TrajectoryActionBuilder tab4 = drive.actionBuilder(drive.pose)
                .setTangent(0)
                .splineToSplineHeading(Constants.toBucket, 0);
        TrajectoryActionBuilder tab5 = drive.actionBuilder(drive.pose)
                .turnTo(Constants.secondSamplePickup);
        TrajectoryActionBuilder tab6= drive.actionBuilder(drive.pose)
                .turnTo(Constants.turnTowardsScoring);
        TrajectoryActionBuilder tab7 = drive.actionBuilder(drive.pose)
                .turnTo(Constants.thirdSamplePickup);



        Action trajectory1= tab1.build();
        Action trajectory2 = tab2.build();
        Action trajectory3 = tab3.build();
        Action trajectory4 = tab4.build();
        Action trajectory5 = tab5.build();
        Action trajectory6=tab6.build();
        Action trajectory7 = tab7.build();

        Actions.runBlocking(
                new SequentialAction(
                        trajectory1,
                        Constants.clips(),
                        trajectory2,
                        Constants.firstScore(),
                        trajectory3,
                        Constants.intake(),
                        Constants.intakeIn(),
                        Constants.transfer(),
                        trajectory4,
                        Constants.deposit(),
                        trajectory5,
                        Constants.intake(),
                        Constants.intakeIn(),
                        Constants.transfer(),
                        trajectory6,
                        Constants.deposit(),
                        trajectory7,
                        Constants.intake(),
                        Constants.intakeIn(),
                        Constants.transfer(),
                        trajectory6,
                        Constants.deposit()

                )
        );

    }



}
