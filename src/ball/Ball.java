package ball;
 
import comp.Board;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

public abstract class Ball extends Thread {

    private int xPos;
    private int yPos;
    private final int width;
    private final int height;
    private Speed speed;
    private final Color color;
    private boolean exit;
    private final Color marginColor = Color.BLACK;

    public enum Speed {

        //Enumeration for the different possible speeds of the ball.
        Slow(45),
        Normal(15),
        Quick(5);

        public int speed;

        Speed(int speed) {
            this.speed = speed;
        }

        public int getSpeed() {
            return this.speed;
        }
    }

    public Ball(int xPos, int yPos, int width, int height, Speed speed, Color color) {
        super();
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.color = color;
        this.exit = false;
    }

    @Override
    public abstract void run();

    public abstract void moveBall(Speed speed);

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //Movidas muy guapas bro 
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setColor(marginColor);
        g2d.draw(new Ellipse2D.Double(xPos, yPos, width, height));
        g2d.setColor(randomColors());
        g2d.drawLine(xPos + this.width / 2, yPos + this.height / 2, 0, 0);
        g2d.drawLine(xPos + this.width / 2, yPos + this.height / 2, Board.getInstance().getWidth(), 0);
        g2d.fillOval(xPos, yPos, width, height);
        Board.getInstance().repaint();
    }

    public Color randomColors() {
        return Color.getHSBColor((float) Math.random(), 1, 1);
    }

    public Color randomColor() {
        Color colorAux;
        int rnd = (int) Math.floor(Math.random() * (0 - 11 + 1) + 11);
        System.out.println(rnd);
        switch (rnd) {
            case 1:
                colorAux = Color.BLACK;
                break;
            case 2:
                colorAux = Color.BLUE;
                break;
            case 3:
                colorAux = Color.CYAN;
                break;
            case 4:
                colorAux = Color.ORANGE;
                break;
            case 5:
                colorAux = Color.MAGENTA;
                break;
            case 6:
                colorAux = Color.GREEN;
                break;
            case 7:
                colorAux = Color.MAGENTA;
                break;
            case 8:
                colorAux = Color.YELLOW;
                break;
            case 9:
                colorAux = Color.PINK;
                break;
            case 10:
                colorAux = Color.RED;
                break;
            case 11:
                colorAux = Color.LIGHT_GRAY;
                break;
            default:
                colorAux = Color.white;
                break;
        }
        return colorAux;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public Speed getSpeed() {
        return this.speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public void kill() {
        this.exit = true;
    }

    public boolean dead() {
        return this.exit;
    }

}
