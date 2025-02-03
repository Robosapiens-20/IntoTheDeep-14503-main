package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(4, -62.5, Math.toRadians(90)))
                        .setTangent(Math.toRadians(90))
                        .splineToLinearHeading(new Pose2d(4,-32.5, Math.toRadians(90)), Math.toRadians(90))//First deposit
                        .setTangent(Math.toRadians(-90))
                        .splineToLinearHeading(new Pose2d(35,-39, Math.toRadians(65)), Math.toRadians(360))//Positioning spline
                        //extend linkage
                        .turnTo(Math.toRadians(330))
                        //first push
                        .setTangent(Math.toRadians(0))
                        .splineToLinearHeading(new Pose2d(43,-39, Math.toRadians(65)), Math.toRadians(0))
                        .turnTo(Math.toRadians(330))
                        //second push
                        .setTangent(Math.toRadians(0))
                        .splineToLinearHeading(new Pose2d(53,-39, Math.toRadians(65)), Math.toRadians(0))
                        .turnTo(Math.toRadians(330))
                        //third push
                        .setTangent(Math.toRadians(180))
                        //retract linkage
                        .splineToLinearHeading(new Pose2d(45,-52,Math.toRadians(90)), Math.toRadians(-90))
                        //second block pick
                        .setTangent(Math.toRadians(180))
                        .splineToLinearHeading(new Pose2d(1,-32.5,Math.toRadians(90)), Math.toRadians(90))
                        .setTangent(Math.toRadians(-90))
                        .splineToLinearHeading(new Pose2d(45,-52,Math.toRadians(90)), Math.toRadians(-90))
                        .setTangent(Math.toRadians(180))
                        .splineToLinearHeading(new Pose2d(-2,-32.5, Math.toRadians(90)), Math.toRadians(90))
                        .setTangent(Math.toRadians(-90))
                        .splineToLinearHeading(new Pose2d(45,-52,Math.toRadians(90)), Math.toRadians(-90))
                        .setTangent(Math.toRadians(180))
                        .splineToLinearHeading(new Pose2d(-5,-32.5,Math.toRadians(90)), Math.toRadians(90))
                        .setTangent(Math.toRadians(-90))
                        .splineToLinearHeading(new Pose2d(45,-52,Math.toRadians(90)), Math.toRadians(-90))
                        .setTangent(Math.toRadians(180))
                        .splineToLinearHeading(new Pose2d(6,-32.5, Math.toRadians(90)), Math.toRadians(90))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}