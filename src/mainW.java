import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainW {
    private JRadioButton easyRadioButton;
    private JRadioButton hardRadioButton;
    private JButton startButton;
    private JPanel mainPanel;
    public static JFrame frame = new JFrame("Let's Bounce");

    public mainW() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                game.main(null);
            }
        });
    }



    static public void main(String [] args){
        frame.setContentPane(new mainW().mainPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
