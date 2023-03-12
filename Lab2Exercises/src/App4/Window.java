package App4;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Observer {

    ArrayList<JPanel> squares=new ArrayList<JPanel>();
    JLabel score;
    JLabel lives;
    JPanel player;
    JPanel goal;

    int playerY=370;
    int playerSpeed = 4;
    public Window() {
        setLayout(null);
        setSize(450,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(4);
        this.setVisible(true);
    }
    private void init(int n){

        for(int i=0 ;i<n; i++){  //setSquares
            JPanel square=new JPanel();
            square.setLocation(55+i*80,0);
            square.setSize(45,45);
            square.setBackground(Color.RED);
            square.setVisible(true);
            this.add(square);
            this.squares.add(square);
        }

        
        lives=new JLabel(); //lives text
        lives.setText("Lives: "+ 3);
        lives.setBounds(360,10,60,60);
        lives.setVisible(true);
        this.add(lives);

        score=new JLabel(); //score text
        score.setText("Score: "+ 0);
        score.setBounds(360,25,60,60);
        score.setVisible(true);
        this.add(score);

        player = new JPanel(); //player shape
        player.setLocation(5,playerY);
        player.setSize(30,30);
        player.setBackground(Color.BLUE);
        player.add(new JLabel("P"));
        player.setVisible(true);
        this.add(player);

        
        goal = new JPanel(); //goal 
        goal.setLocation(370,playerY);
        goal.setSize(50,40);
        goal.setBackground(Color.GREEN);
        goal.add(new JLabel("GOAL"));
        goal.setVisible(true);
        this.add(goal);

        this.addKeyListener(new CustomeKeyListener());
    }

     public boolean collision(JPanel player, JPanel square){
        int firstX=player.getX(), firstY=player.getY(), firstWidth =  player.getWidth(), firstHeight=player.getHeight(); 
        int secondX =square.getX(),  secondY =square.getY(),  secondWidth= square.getWidth(), secondHeight=square.getHeight();
        if(firstX>=secondX && firstX<=secondX+secondWidth && firstY>=secondY && firstY<=secondY+secondHeight)
            return true;
         else if(firstX+firstWidth>=secondX && firstX+firstWidth<=secondX+secondWidth && firstY>=secondY && firstY<=secondY+secondHeight)
            return true;
        else if(firstX>=secondX && firstX<=secondX+secondWidth && firstY+firstHeight>=secondY && firstY+firstHeight<=secondY+secondHeight)
            return true;
         else if(firstX+firstWidth>=secondX && firstX+firstWidth<=secondX+secondWidth && firstY+firstHeight>=secondY && firstY+firstHeight<=secondY+secondHeight)
            return true;
        return false;
    }

    @Override
    public void update(Observable obs, Object arg) {
        squares.get(( (Square) obs).getId()).setLocation(( (Square) obs).getX(),( (Square) obs).getY());

        for(int i=0;i<squares.size();i++){
            JPanel square = squares.get(i); 
             if(collision(player,square)) {
                player.setLocation(5, playerY);
                int oldLives = Integer.parseInt(lives.getText().split(" ")[1]);
                lives.setText("Lives: " + (oldLives - 1));
                JOptionPane.showMessageDialog(this, "You got hit! "+lives.getText(),
                    "Hit",
                    JOptionPane.INFORMATION_MESSAGE);
                    
                if(oldLives==1) {  //Game End
                    JOptionPane.showMessageDialog(this, "All lives lost. Final "+score.getText(),
                    "End",
                    JOptionPane.INFORMATION_MESSAGE);
                    ( (Square) obs).stop();
                    this.remove(player);
                }
            }
        }
    }


    class CustomeKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                player.setLocation(player.getX()+playerSpeed, player.getY());
                if(player.getX() >= 450){
                    player.setLocation(5,playerY);
                    String oldScore = score.getText().split(" ")[1];
                    score.setText("Score: "+ (Integer.parseInt(oldScore)+4));
                }
            }

            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                player.setLocation(player.getX()-playerSpeed, player.getY());
                if(player.getX() <=5){
                    player.setLocation(5,playerY);
                }
            }
        }
     
    }
      
   
}