/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;
import java.awt.Point;
/**
 *
 * @author lenovo
 */
public class Tank {
    public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket=new Bullet();
    public int speed;
    public int score=0;
    
    public Tank (String ImagePath)
    {
       
        speed=5;
        this.ImagePath=ImagePath;
        Rocket.imgPath="C:\\Users\\lenovo\\Desktop\\business.png";
    }

    void mover() {
        this.pos.x+=speed;
    }
      void movel() {
        this.pos.x-=speed;
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x;
        Rocket.pos.y=this.pos.y;
        Thread t1=new Thread (Rocket);
        t1.start();
    }
}

