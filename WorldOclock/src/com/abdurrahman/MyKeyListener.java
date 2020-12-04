package com.abdurrahman;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class MyKeyListener implements KeyListener{
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_X) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
            System.out.println("Program durdurldu.");
            System.exit(0);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
