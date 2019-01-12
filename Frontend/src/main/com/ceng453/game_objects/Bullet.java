package main.com.ceng453.game_objects;

import javafx.scene.image.Image;
import main.com.ceng453.frontend.main.ApplicationConstants;


/*
 * Bullet class, extending GameObject
 */
public class Bullet extends GameObject {

    public static final int UserBullet = 0;
    public static final int AlienBullet = 1;
    public static final int HardAlienBullet = 2;


    public Bullet(Image sprite, int width, int height) {
        super(sprite, width, height);
        setVelocityX(0);
    }

    // Just change positions using x = v * t
    // If we quit the screen, remove the bullet
    public GameObject update(double elapsedTime, long currentCycleNumber) {
        setPositionY( getPositionY() + getVelocityY()*elapsedTime );
        setPositionX( getPositionX() + getVelocityX()*elapsedTime );
        if( getPositionY()+getHeight() < 0 || getPositionY() > ApplicationConstants.ScreenHeight )
            setCleared();
        return null;
    }
}