package org.academiadecodigo.sniperelitev2;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

/**
 * Created by cadet on 28/09/15.
 */
public class SniperRifle{

    int bullets=10;
    int damage;
    int x = 10;
    int y = 10;
    Field field = new Field();

    Ellipse sniper = new Ellipse(x, y, 10, 10);

    public void drawSniper() {
        sniper.setColor(Color.ORANGE);
        sniper.fill();
    }

    public void shootEnemie(Enemy enemy) {

        double random = Math.random();

        if (random < 0.5) {
            damage = 50;
            System.out.println("Target Hit!");
        } else if (random < 0.75) {
            damage = 100;
            System.out.println("Headshot!");
        } else {
            damage = 0;
            System.out.println("Target missed");
        }
        enemy.hit(damage);
    }

    public void shootTree(Tree tree) {

        System.out.println("You shooted a tree!");
    }

    public void move(int x, int y) {

        if ((this.x + x) < field.getX() || (this.x + x) > field.getW() || (this.y + y) < field.getY() || (this.y + y) > field.getH()){
            System.out.println("You can't leave the field");
        }
        else {
            this.x += x;
            this.y += y;
            sniper.translate(x, y);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }
}
