/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MovingBall extends JPanel implements Runnable{

   public ArrayList<Ball>Balls=new ArrayList<Ball>();
   public Tank Tank1=new Tank("C:\\Users\\lenovo\\Desktop\\tank2.png");
   public Tank Tank2=new Tank("C:\\Users\\lenovo\\Desktop\\tank2.png");
    Object Ball;
    private JLabel label1= new JLabel("Tank1");
    private JLabel label2= new JLabel("Tank2");
    private JLabel Score1 = new JLabel(""+Tank1.score);
    private JLabel Score2 = new JLabel(""+Tank2.score);

    public MovingBall()
    {
        
        setSize(600,600);
        Tank1.pos.x=220;
        Tank1.pos.y=340;
        Tank2.pos.x=400;
        Tank2.pos.y=340;
        Score1.setText(""+Tank1.score);
        Score2.setText(""+Tank2.score);
        add(label1);
        add(Score1);
        add(label2);
        add(Score2);
        this.addKeyListener(new keylist());
        

    }
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
           
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                Tank1.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                Tank1.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                Tank1.fireBullet();
            }
            
            
             if (e.getKeyCode()==KeyEvent.VK_D)
            {
                
                Tank2.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_S)
            {
                
                Tank2.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_W)
            {
                
                Tank2.fireBullet();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
        
        try
        {
       BufferedImage Background = ImageIO.read(new File("C:\\Users\\lenovo\\Desktop\\BackgroundGame.png"));
        BufferedImage imgtank = ImageIO.read(new File(Tank1.ImagePath));
        BufferedImage imgtank2 = ImageIO.read(new File(Tank2.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(Tank1.Rocket.imgPath));
        BufferedImage imgrocket2 = ImageIO.read(new File(Tank2.Rocket.imgPath));

        g.drawImage(Background, 0, 0,null);
        g.drawImage(imgtank, Tank1.pos.x, Tank1.pos.y,null);
        g.drawImage(imgrocket, Tank1.Rocket.pos.x, Tank1.Rocket.pos.y,null);
        g.drawImage(imgtank2, Tank2.pos.x, Tank2.pos.y,null);
        g.drawImage(imgrocket2, Tank2.Rocket.pos.x, Tank2.Rocket.pos.y,null);
                


        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Ball OneBall: Balls)
        
        {
            g.setColor(OneBall.CurrentColor);
            g.fillOval(OneBall.x,OneBall.y, 50, 50);
            if (Tank1.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                Balls.remove(OneBall);
                Tank1.score++;
                   Score1.setText(""+Tank1.score);
                  System.out.println("tank1"+" "+Tank1.score);
            break;
                
        }
            
            
            if (Tank2.Rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                System.out.println("Hit Occurs" + OneBall.CurrentColor.toString());
                Balls.remove(OneBall);
                Tank2.score++;
                 Score2.setText(""+Tank2.score);
                System.out.println("tank2"+" "+Tank2.score);

              break;
                
            }
           
          
        }
        
    }
    @Override
    public void run() {
    try
    {
    while(true)
    {
        for (Ball OneBall: Balls)
        {
            OneBall.move(this.getWidth());
            
        }    
        
        //y+=10;
        Thread.sleep(50);
        repaint();
         if (Balls.isEmpty())
            {
                if(Tank1.score>Tank2.score)
                {
                   JOptionPane.showMessageDialog(null, "Tank 1 is the winner");
                   return;
                   
                }
                else if (Tank1.score<Tank2.score)
                {
                  JOptionPane.showMessageDialog(null, "Tank 2 is the winner");
                  return;

                }
                else if (Tank1.score==Tank2.score)
                {
                  JOptionPane.showMessageDialog(null, "Draw");
                  return;

                }
                
            }
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
