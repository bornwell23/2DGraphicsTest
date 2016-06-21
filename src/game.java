import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class game extends JPanel {
    static int dimX = 1000;
    static int dimY = 1000;
    static java.util.List<ball> ballList = new ArrayList<>();
    static Random random = new Random();
    static player playerBall = new player();
    static int [] playerDirection = new int[4];
    static public JLabel score;
    static public int totalBalls = 50;
    static public boolean done = false;
    static JFrame frame;
    static Box box;
    static game Game;
    static JLabel winText;

    public static void main(String[] args) {
        frame = new JFrame("Bouncy");
        Game = new game();
        frame.add(Game);
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        dimX = (int)screenDim.getWidth();
        dimY = (int)screenDim.getHeight();
        score = new JLabel("Score: " + playerBall.score);
        score.setFont(new Font("Arial", Font.BOLD, 24));
        score.setForeground(Color.WHITE);
        JLabel info = new JLabel("Press escape to quit. Remove all balls as fast as possible!");
        info.setFont(new Font("Arial", Font.BOLD, 24));
        info.setForeground(Color.WHITE);
        box = Box.createVerticalBox();
        Game.add(box);
        score.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        box.add(score);
        info.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        box.add(info);
        box.add(Box.createRigidArea(new Dimension(5,100)));
        winText = new JLabel("You won in: " + " seconds!");
        winText.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        winText.setForeground(Color.BLACK);
        winText.setFont(new Font("Arial", Font.BOLD, 48));
        box.add(winText);
        Game.setBackground(Color.black);
        frame.setVisible(true);

        KeyListener kl = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(1);
                }
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    playerDirection[0] = 1;
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    playerDirection[1] = 2;
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    playerDirection[2] = 3;
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    playerDirection[3] = 4;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    playerDirection[0] = 0;
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    playerDirection[1] = 0;
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    playerDirection[2] = 0;
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    playerDirection[3] = 0;
                }
            }
        };
        frame.addKeyListener(kl);

        for(int i=0;i<totalBalls;++i)
            ballList.add(new ball(1+random.nextInt(dimX-60), 1+random.nextInt(dimY-60), 1+random.nextDouble()*10, 1+random.nextDouble()*10));

        run();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for(ball temp : ballList) {
            g2d.setColor(temp.color);
            g2d.fillOval(temp.x, temp.y, 30, 30);
        }
        g2d.setColor(playerBall.color);
        g2d.fillOval(playerBall.x, playerBall.y, 60, 60);
    }

    public static void run(){
        System.out.println("Running");
        long startTime = System.currentTimeMillis();
        while(!done) {
            for(ball temp : ballList) {
                temp.moveBall();
            }
            for(int dir : playerDirection){
                playerBall.move(dir);
            }
            Game.repaint();
            try {
                Thread.sleep(10);
            }
            catch (Exception e){
                e.printStackTrace();
                break;
            }
        }
        long endTime = System.currentTimeMillis();

        winText.setText("You won in " + (endTime - startTime)/1000 + " seconds!");
        winText.setForeground(Color.WHITE);
    }
}
