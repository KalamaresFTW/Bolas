package ball;

import comp.Board;
import java.awt.Color;
import java.util.Random;

public class LinearBall extends Ball {

    public LinearBall(int xPos, int yPos, int width, int height, Speed speed, Color color) {
        super(xPos, yPos, width, height, speed, color);
    }

    @Override
    public void moveBall(Speed speed) {
        setxPos(getxPos() + 1);
        try {
            Thread.sleep(speed.getSpeed());
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public void run() {
        while (!dead()) {
            moveBall(getSpeed());
            Board.getInstance().repaint();
        }
    }

}
