package main;

public class Game  implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread thread;
    private final int FPS = 180;
    public Game(){
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        double timePerFrame= 1000000000.0/FPS;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        int frames =0;
        long lastCheck = System.currentTimeMillis();
        while (true){
            now = System.nanoTime();
            if (now - lastFrame > timePerFrame){
                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }

            if (System.currentTimeMillis() - lastCheck > 1000){
                System.out.println("FPS: " + frames);
                frames = 0;
                lastCheck = System.currentTimeMillis();
            }
        }
    }
}
