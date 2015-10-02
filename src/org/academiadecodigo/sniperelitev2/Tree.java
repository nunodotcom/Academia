package org.academiadecodigo.sniperelitev2;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by cadet on 28/09/15.
 */
public class Tree extends GameObject {

    Rectangle tree = new Rectangle(x, y, 5, 20);

    public void drawTree(){

        tree.setColor(Color.GREEN);
        tree.fill();
    }

    public double getWidth(){

        return tree.getWidth();
    }

    public double getHeight(){

        return tree.getHeight();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public int getX() {
        return super.getX();
    }

}
