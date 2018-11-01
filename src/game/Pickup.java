package game;

import city.cs.engine.*;


/**
 * Collision listener that allows the robot to collect things.
 *
 * @author Sonia Mathews
 * @version 1
 * @since 1
 */
public class Pickup implements CollisionListener {

    private RobotPlayer robotPlayer;

    /**
     *
     * @param robotPlayer collects or collides with gem, Octopus, Jumper and
     * Boss
     */
    public Pickup(RobotPlayer robotPlayer) {
        this.robotPlayer = robotPlayer;

    }

    /**
     *
     * @param e handles collision event between different objects
     */
    @Override
    public void collide(CollisionEvent e) {

        if (e.getReportingBody() instanceof Gem && e.getOtherBody() == robotPlayer) {
            robotPlayer.incrementGemCount();
            e.getReportingBody().destroy(); // when player collides with gem 

        }
        if (e.getReportingBody() instanceof Octopus && e.getOtherBody() == robotPlayer) {

            robotPlayer.decrementLiveCount();
            Octopus.octopusSound.play(); //when player collides with octopus

        }

        if (e.getReportingBody() instanceof Boss && e.getOtherBody() == robotPlayer) {

            robotPlayer.decrementLiveCount(); //when player collides with boss

        }
        if (e.getReportingBody() instanceof Jumper && e.getOtherBody() == robotPlayer) {

            robotPlayer.decrementLiveCount(); //when player collides with Jumper 
        }

    }

}
