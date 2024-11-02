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

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-35, -70, Math.toRadians(-90)))
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
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}