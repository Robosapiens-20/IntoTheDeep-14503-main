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

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(35, -70, Math.toRadians(90)))
                .setTangent(-10)
                .splineToSplineHeading(new Pose2d(0, -38, Math.toRadians(-90)), Math.PI / 2)
                .lineToY(-29)
                .lineToY(-38)
                .setTangent(0)
                .splineToSplineHeading(new Pose2d(-51,-52,Math.toRadians(90)),0)

                        .setTangent(-30)
                        .splineToSplineHeading(new Pose2d(-49,-32,Math.toRadians(90)),-4)
                .setTangent(-10)
                .splineToSplineHeading(new Pose2d(-56,-56,Math.toRadians(50)),Math.PI)
                .setTangent(-30)
                .splineToSplineHeading(new Pose2d(-58,-36,Math.toRadians(90)),4)
                .setTangent(-10)
                .splineToSplineHeading(new Pose2d(-56,-56,Math.toRadians(50)),Math.PI)
                .setTangent(30)
                .splineToSplineHeading(new Pose2d(-70,-36,Math.toRadians(90)),0)
                .setTangent(-10)
                .splineToSplineHeading(new Pose2d(-56,-56,Math.toRadians(50)),-Math.PI)
                .lineToX(-66)
                .build());
        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}