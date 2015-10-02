package org.academiadecodigo.sniperelitev2;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

/**
 * Created by cadet on 28/09/15.
 */
public class Enemy extends GameObject {

    int health = 100;
    boolean isDead;
    Ellipse soldier = new Ellipse(x, y, 10, 10);

    public void drawSoldier(){
        soldier.setColor(Color.BLUE);
        soldier.fill();
    }

    public void drawDeadEnemy(){
        soldier.setColor(Color.RED);
        soldier.fill();
    }

    public void hit(int damage){

        health=health-damage;

        if(health>0){
            System.out.println("Enemy Health: " + health);
        }
        else{
            drawDeadEnemy();
            isDead=true;
            System.out.println("Enemy is dead!");
        }
    }

    public double getWidth(){
        return soldier.getWidth();
    }

    public double getHeight(){
        return soldier.getHeight();
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
