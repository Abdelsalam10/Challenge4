/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;


public class TankGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         JFrame jf=new JFrame();
        jf.setSize(900, 680);
        
        MovingBall mb=new MovingBall();

      // mb.Balls.add(new Ball());
        mb.Balls.add(new Ball(100,100,5,Color.ORANGE));
        mb.Balls.add(new Ball(160,160,10,Color.red));
        mb.Balls.add(new Ball(180,180,15,Color.CYAN));
        mb.Balls.add(new Ball(180,180,20,Color.BLACK));
        mb.Balls.add(new Ball(150,150,25,Color.MAGENTA));
        mb.Balls.add(new Ball(120,120,30,Color.BLUE));
        mb.Balls.add(new Ball(120,120,35,Color.GRAY));
        mb.Balls.add(new Ball(120,120,25,Color.yellow));


        jf.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        Thread t1=new Thread(mb);
        t1.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
    }
    
}
