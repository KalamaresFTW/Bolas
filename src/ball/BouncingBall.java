package ball;

import comp.Board;
import java.awt.Color;

public class BouncingBall extends Ball {

    int avance = 1;

    public BouncingBall(int xPos, int yPos, int width, int height, Speed speed, Color color) {
        super(xPos, yPos, width, height, speed, color);
    }

    @Override
    public void moveBall(Speed speed) {
        setxPos(getxPos() + avance);
        if (getxPos() >= Board.getInstance().getWidth() - getWidth()) {
            avance *= -1;
        } else {
            if (getxPos() == 0) {
                avance *= -1;
            }
        }
        try {
            Thread.sleep(speed.getSpeed());
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public void run() {
        while (true) {
            moveBall(getSpeed());
            Board.getInstance().repaint();
        }
    }

}
