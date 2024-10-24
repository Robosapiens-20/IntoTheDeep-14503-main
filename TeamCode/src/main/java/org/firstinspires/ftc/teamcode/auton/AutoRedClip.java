/*package org.firstinspires.ftc.teamcode.auton;


import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class AutoRedClip extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive;
        drive = new MecanumDrive(hardwareMap,new Pose2d(35,70,Math.toRadians(90)));
// actionBuilder builds from the drive steps passed to it
        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                .setTangent(-10)
                .splineToSplineHeading(new Pose2d(0, -38, Math.toRadians(-90)), Math.PI / 2)
                .lineToY(-29);
                .lineToY(-38)
                .setTangent(0)
                .splineToSplineHeading(new Pose2d(51,-52,Math.toRadians(90)),0)

                .setTangent(-60)
                .splineToSplineHeading(new Pose2d(49,-36,Math.toRadians(90)),0)
                .setTangent(-10)
                .splineToSplineHeading(new Pose2d(56,-56,Math.toRadians(-90)),Math.PI)
                .setTangent(-60)
                .splineToSplineHeading(new Pose2d(58,-36,Math.toRadians(90)),0)
                .setTangent(-10)
                .splineToSplineHeading(new Pose2d(56,-56,Math.toRadians(-90)),Math.PI)
                .setTangent(-60)
                .splineToSplineHeading(new Pose2d(70,-36,Math.toRadians(90)),0)
                .setTangent(-10)
                .splineToSplineHeading(new Pose2d(56,-56,Math.toRadians(-90)),Math.PI)
                .lineToX(-66)


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