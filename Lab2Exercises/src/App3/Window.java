package App3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Window extends JFrame implements Observer {

    ArrayList<JPanel> squares=new ArrayList<JPanel>();


    public Window() {
        setLayout(null);
        setSize(400,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(3);
        this.setVisible(true);
    }
    private void init(int n){
        for(int i=0 ;i<n; i++){
            JPanel square=new JPanel();

            square.setLocation( 50+i*80,0);
            square.setSize(40,40);
            square.setBackground(Color.RED);
            square.setVisible(true);

            this.squares.add(square);
            this.add(square);
            
        }
    }

    @Override
    public void update(Observable obs, Object arg) {
        squares.get(( (Square) obs).getId()).setLocation(( (Square) obs).getX(),( (Square) obs).getY());

        if( ((Square) obs).getY() > 420 ){
            JOptionPane.showMessageDialog(this,("Square#: "+((Square) obs).getId() + " was the first to reach y:" + ((Square) obs).getY()+" and stopped."),
            "End",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }
}