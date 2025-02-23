package main;
import inputs.KeyBoardInputs;
import inputs.MouseInput;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import utilz.Constants;

import static utilz.Constants.PlayerConstans.GetSpriteAmount;
import static utilz.Constants.PlayerConstans.*;

public class GamePanel extends JPanel {
    private MouseInput mouseInput;
    private int xDelta = 0, yDelta = 0;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick=0, aniIndex=0, aniSpeed = 10;
    private int playerAction = IDLE;

    public GamePanel(){

        mouseInput = new MouseInput(this);
        importImage();
        loadAnimation();
        setPanelSize();
        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }

    private void loadAnimation() {

       animations = new BufferedImage[7][17];
        for (int j=0; j<animations.length;j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] =  img.getSubimage(i * 160, j*128, 160, 128);
            }
        }
    }

    private void importImage() {
        File file = new File("res/Necromancer_creativekind-Sheet.png");
        try {
            img = ImageIO.read(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void setMoving(int direction){

    }

    private void updateAnimation(){
        aniTick++;//Giai thich: moi lan repaint thi anitick se tang len 1, khi anitick > anispeed thi anindex se tang len 1
        if (aniTick > aniSpeed){
            aniIndex++;
            aniTick = 0;
        }
        if (aniIndex >= GetSpriteAmount(playerAction)){
            aniIndex = 0;
        }
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        updateAnimation();
        g.drawImage(animations[playerAction][aniIndex],xDelta,yDelta,160*2,128*2,null);
    }


}
