/*package org.firstinspires.ftc.teamcode.auton;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import androidx.annotation.NonNull;
// RR-specific imports
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
// Non-RR imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.RobotCore;
@Autonomous
public class AutoBlueBucket extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive;
        drive = new MecanumDrive(hardwareMap,new Pose2d(35,70,Math.toRadians(90)));
// actionBuilder builds from the drive steps passed to it
        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                .setTangent(-10)
                .splineToSplineHeading(new Pose2d(0, 40, Math.toRadians(90)), Math.PI / 2)
                .lineToY(34)
                .setTangent(0)
                .splineToSplineHeading(new Pose2d(48,42,Math.toRadians(-90)),0)
                .waitSeconds(1)
                //extend intake and intake first block 100%
                .splineToSplineHeading(new Pose2d(56,56,Math.toRadians(-135)), 0)
                //deposit first block
                .turnTo(Math.toRadians(-87))
                .waitSeconds(1)
                .turnTo(Math.toRadians(-135))
                //get the second block easy points
                .waitSeconds(1)
                .turnTo(Math.toRadians(295))
                .waitSeconds(1)
                .turnTo(Math.toRadians(-135));

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