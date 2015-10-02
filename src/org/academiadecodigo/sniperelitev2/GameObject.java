package org.academiadecodigo.sniperelitev2;

/**
 * Created by cadet on 28/09/15.
 */
abstract public class GameObject {

    int w = (int) (((Math.random()*360)+20)/5);
    int h = (int) (((Math.random()*360)+20)/5);

    int x = w*5;
    int y = h*5;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
