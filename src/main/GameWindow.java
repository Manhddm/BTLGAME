package main;

import javax.swing.*;

public class GameWindow {
    public JFrame jfarme  ;
    private GamePanel gamePanel;
    public GameWindow(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        jfarme = new JFrame();

        jfarme.setResizable(false);
        jfarme.setVisible(true);
        jfarme.add(gamePanel);
        jfarme.setLocationRelativeTo(null);

        jfarme.pack();
        jfarme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
