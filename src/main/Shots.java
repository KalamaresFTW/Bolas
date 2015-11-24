package main;

import comp.Board;
import ball.Ball;
import ball.BouncingBall;
import ball.LinearBall;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Shots extends JFrame {

    //Constants
    private static final String lblSlow = "Slow shot";
    private static final String lblShot = "Shot";
    private static final String lblQuick = "Quick shot";
    private static final String lblQuickBouncing = "Madness";
    private static final String title = "Shots";
    private static final int winWidth = 800;
    private static final int winHeight = 500;
    public static final boolean debug = false;
    private static JButton btnSlow;
    private static JButton btnShot;
    private static JButton btnQuick;
    private static JButton btnQuickBouncing;
    private static Board board;
    private static JPanel btnPanel;

    private Shots() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(new Rectangle(new Dimension(winWidth, winHeight)));
        setResizable(true);
        setLayout(new BorderLayout(5, 5));
        setTitle(title);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        //Ge get an instance of a Board (Singletone )
        board = Board.getInstance();

        btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

        btnSlow = new JButton(lblSlow);

        btnShot = new JButton(lblShot);

        btnQuick = new JButton(lblQuick);

        btnQuickBouncing = new JButton(lblQuickBouncing);

        btnSlow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (debug) {
                    System.out.println("Slow shot");
                }
                Ball slow = new LinearBall(0, new Random().nextInt(getHeight()) - 75, 75, 75, Ball.Speed.Slow, randomColors());
                board.addBall(slow);
                slow.start();
            }
        });

        btnShot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (debug) {
                    System.out.println("Shot");
                }
                Ball shot = new LinearBall(0, new Random().nextInt(getHeight()) - 50, 50, 50, Ball.Speed.Normal, randomColors());
                board.addBall(shot);
                shot.start();
            }
        });

        btnQuick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (debug) {
                    System.out.println("Quick shot");
                }
                Ball quick = new LinearBall(0, new Random().nextInt(getHeight() - 25), 25, 25, Ball.Speed.Quick, randomColors());
                board.addBall(quick);
                quick.start();
            }
        });

        btnQuickBouncing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (debug) {
                    System.out.println("Madness");
                }
                for (int i = 0; i < 100; i++) {
                    Ball quick = new BouncingBall(0, new Random().nextInt(getHeight() - 25), 25, 25, Ball.Speed.Quick, randomColor());
                    board.addBall(quick);
                    quick.start();
                }
            }
        });

        btnPanel.add(btnSlow);
        btnPanel.add(btnShot);
        btnPanel.add(btnQuick);
        btnPanel.add(btnQuickBouncing);
        add(board, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }

    public Color randomColors() {
        return Color.getHSBColor((float) Math.random(), 1, 1);
    }

    //Returns a y-axis coordinate that must be inside of the board
    public int randomyPos(int ballHeight) {
        return (int) (Math.random() * (getHeight() + 1) - ballHeight);
    }

    public Color randomColor() {
        Color color = null;
        int rnd = (int) (Math.random() * (0 - 16) + 16);
        System.out.println(rnd);
        switch (rnd) {
            case 1:
                color = Color.BLACK;
                break;
            case 2:
                color = Color.BLUE;
            case 3:
                color = Color.CYAN;
                break;
            case 4:
                color = Color.DARK_GRAY;
                break;
            case 5:
                color = Color.GRAY;
                break;
            case 6:
                color = Color.GREEN;
                break;
            case 7:
                color = Color.LIGHT_GRAY;
                break;
            case 8:
                color = Color.MAGENTA;
                break;
            case 9:
                color = Color.ORANGE;
                break;
            case 10:
                color = Color.PINK;
                break;
            case 11:
                color = Color.RED;
                break;
            case 12:
                color = Color.WHITE;
                break;
            case 13:
                color = Color.YELLOW;
                break;
            case 14:
                color = Color.black;
                break;
            default:
                color = Color.white;
                break;
        }
        return color;
    }

    public static void main(String[] args) {
        try {
            Shots juego = new Shots();
        } catch (Exception e) {
        }

    }
}
