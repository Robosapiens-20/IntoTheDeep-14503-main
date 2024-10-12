/*package org.firstinspires.ftc.teamcode.auton;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class RedBucket extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException{
        MecanumDrive drive;
        drive = new MecanumDrive(hardwareMap, new Pose2d(-35, -70, Math.toRadians(90)));

        TrajectoryActionBuilder tab1 = drive.actionBuilder(IntialPose)
                .setTangent(-10)
                .splineToSplineHeading(new Pose2d(0, -34, Math.toRadians(-90)), Math.PI / 2)
                .lineToY(-34)
                .setTangent(0)
                .splineToSplineHeading(new Pose2d(-49,-42,Math.toRadians(90)),0)
                .waitSeconds(1)
                //extend intake and intake first block 100%
                .splineToSplineHeading(new Pose2d(-56,-56,Math.toRadians(50)),Math.PI)
                //deposit first block
                .turnTo(Math.toRadians(95))
                .waitSeconds(1)
                //extend intake and intake second block fr
                .turnTo(Math.toRadians(49))
                //deposit second block
                .turnTo(Math.toRadians(120))
                .waitSeconds(1)
                //extend and intake the last block
                .turnTo(Math.toRadians(49))
                //deposit last block free ahh auto

        waitForStart();

        if (isStopRequested()) return;
        Action trajectoryActionChosen;
        trajectoryActionChosen = tab1.build();
        Actions.runBlocking(
                new SequentialAction(
                        trajectoryActionChosen,
                        )
        );
    }
}
*/
