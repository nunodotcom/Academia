package org.academiadecodigo.sniperelitev2;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by cadet on 30/09/15.
 */
public class Field {

    int x = 10;
    int y = 10;
    int w = 400;
    int h = 400;

    Rectangle field = new Rectangle(x, y, w, h);

    public void drawField(){

        field.setColor(Color.BLACK);
        field.draw();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
