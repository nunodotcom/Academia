package org.academiadecodigo.sniperelitev2;

import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by cadet on 28/09/15.
 */
public class Game implements KeyboardHandler{

    GameObject randomObject;
    GameObject[] gameObject = new GameObject[15];
    SniperRifle sniperRifle =  new SniperRifle();
    Keyboard k = new Keyboard(this);
    Text gameName = new Text(190, 40, "Sniper Elite");
    Picture pic = new Picture(85, 90, "http://orig02.deviantart.net/a89a/f/2012/157/b/c/sniper_elite_v2_icon_by_kikofakiko-d4y1m89.png");
    Field field = new Field();

    public void start() throws InterruptedException {

        openTitle();

        sniperRifle.drawSniper();

        drawObjects();

        sniperInteract();
    }

    public void openTitle() throws InterruptedException{

        field.drawField();

        gameName.setColor(Color.BLACK);
        gameName.grow(50, 25);
        gameName.draw();

        pic.draw();

        Thread.sleep(1000);

        gameName.delete();
        pic.delete();

    }

    public GameObject createObject() {

        double r = Math.random();

        if (r < 0.5) {
            randomObject = new Enemy();
        } else {
            randomObject = new Tree();
        }
        return randomObject;
    }

    public void drawObjects() {

        for (int y = 0; y < gameObject.length; y++) {
            gameObject[y] = createObject();
        }

        for (int i = 0; i < gameObject.length; i++) {
            if (gameObject[i] instanceof Enemy) {

                Enemy enemy = (Enemy) gameObject[i];

                enemy.drawSoldier();
            }

            if (gameObject[i] instanceof Tree) {

                Tree tree = (Tree) gameObject[i];

                tree.drawTree();
            }
        }
    }

    public void sniperInteract() {

        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent shoot = new KeyboardEvent();
        KeyboardEvent reload = new KeyboardEvent();

        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        shoot.setKey(KeyboardEvent.KEY_SPACE);
        shoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        reload.setKey(KeyboardEvent.KEY_R);
        reload.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(left);
        k.addEventListener(right);
        k.addEventListener(up);
        k.addEventListener(down);
        k.addEventListener(shoot);
        k.addEventListener(reload);
    }

    public void shootObject() throws InterruptedException {

        if (sniperRifle.getBullets() > 0) {
            System.out.println("Ammo: " + sniperRifle.getBullets());
            System.out.println("Shot fired!");
            sniperRifle.setBullets(sniperRifle.getBullets()-1);

             for (int i = 0; i < gameObject.length; i++) {

                 if (gameObject[i] instanceof Enemy) {

                     Enemy enemy = (Enemy) gameObject[i];

                     if (!enemy.isDead) {

                         if (sniperRifle.getX() == enemy.getX() || sniperRifle.getX() == (enemy.getX() + enemy.getHeight()) ||
                                 sniperRifle.getY() == enemy.getY() || sniperRifle.getY() == (enemy.getY() + enemy.getWidth())) {

                             sniperRifle.shootEnemie(enemy);

                             break;
                         }
                     }
                 }

                 if (gameObject[i] instanceof Tree) {

                     Tree tree = (Tree) gameObject[i];

                     if(sniperRifle.getX() == tree.getX() || sniperRifle.getX() == (tree.getX()+tree.getHeight()) ||
                        sniperRifle.getY() == tree.getY()|| sniperRifle.getY() == (tree.getY()+tree.getWidth())) {

                         sniperRifle.shootTree(tree);

                         break;
                     }
                 }
             }
        }
        else {
            System.out.println("No ammo, reload!!!");
        }
        System.out.println("============================");
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();

        switch(key){

            case KeyboardEvent.KEY_A:
                sniperRifle.move(-5, 0);
                break;

            case KeyboardEvent.KEY_D:
                sniperRifle.move(5, 0);
                break;

            case KeyboardEvent.KEY_W:
                sniperRifle.move(0, -5);
                break;

            case KeyboardEvent.KEY_S:
                sniperRifle.move(0, 5);
                break;

            case KeyboardEvent.KEY_SPACE:
                try {
                    shootObject();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            case KeyboardEvent.KEY_R:
                sniperRifle.setBullets(10);
                System.out.println("Sniper reloaded!");
                break;

            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}





