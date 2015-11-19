package comp;

import ball.Ball;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import main.Shots;

public class Board extends JPanel {

    //Singleton pattern thingy
    private static Board board = null;
    private final ArrayList<Ball> balls;
    private static final Color backgroundColor = Color.WHITE;

    //Singleton 
    private Board() {
        super();
        balls = new ArrayList();
        setBackground(backgroundColor);
    }

    //Singleton pattern one more time baby
    public static Board getInstance() {
        if (board == null) {
            board = new Board();
        }
        return board;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            if (Shots.debug) {
                g.drawString("Amount of balls: " + amountOfBallsToString(), 10, this.getHeight() - 15);
                g.drawString("Board dimensions: " + this.getHeight() + "x" + this.getWidth(), 10, this.getHeight() - 35);
            }
            balls.stream().map((ball) -> {
                if ((ball.getxPos() >= getWidth() + ball.getWidth()) || (ball.getyPos() >= getHeight() + getHeight())) {
                    ball.kill();
                    balls.remove(ball);
                }
                return ball;
            }).map((ball) -> {
                ball.paint(g);
                return ball;
            }).forEach((_item) -> {
                repaint();
            });
        } catch (Exception e) {
        }
    }

    public String amountOfBallsToString() {
        return Integer.toString(balls.size());
    }

    public void addBall(Ball ball) {
        if (ball != null) {
            balls.add(ball);
        }
    }

    public void removeBall(Ball ball) {
        if (ball != null) {
            balls.remove(ball);
        }
    }

}
