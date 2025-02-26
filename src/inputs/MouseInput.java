package inputs;

import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel;
    public MouseInput(GamePanel gamePanel){
        this.gamePanel = gamePanel;

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("Mouse Dragged");
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("Mouse Moved");
        gamePanel.setRectPos(e.getX(),e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       // System.out.println("Mouse Clicked");

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
