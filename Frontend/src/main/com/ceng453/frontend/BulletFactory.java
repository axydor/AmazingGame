package main.com.ceng453.frontend;

public class BulletFactory {
    public static Bullet create( int bulletType, int damage ){
        Bullet bullet = null;
        switch (bulletType) {
            case Bullet.UserBullet:
                bullet = new Bullet(ApplicationConstants.UserBulletImage, ApplicationConstants.UserBulletWidth, ApplicationConstants.UserBulletHeight);
                bullet.setVelocityY( ApplicationConstants.UserBulletVelocity );
                bullet.initialize( 1, damage);
                Sound.play(Sound.UserBulletSound);
                break;
            case Bullet.AlienBullet:
                bullet = new Bullet(ApplicationConstants.AlienBulletImage, ApplicationConstants.AlienBulletWidth*damage, ApplicationConstants.AlienBulletHeight*damage);
                bullet.setVelocityY( ApplicationConstants.AlienBulletVelocity );
                bullet.initialize( 1, damage );
                Sound.play(Sound.EasyEnemyBulletSound);
                break;
            case Bullet.HardAlienBullet:
                bullet = new HardBullet(ApplicationConstants.AlienBulletImage, ApplicationConstants.AlienBulletWidth*damage, ApplicationConstants.AlienBulletHeight*damage);
                bullet.setVelocityY( ApplicationConstants.AlienBulletVelocity*1.2 );
                bullet.initialize( 4, damage );
                Sound.play(Sound.HardEnemyBulletSound);
                break;

        }
        return bullet;
    }
}
