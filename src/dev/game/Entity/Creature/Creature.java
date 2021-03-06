package dev.game.Entity.Creature;

/**
 * @author EFGK
 */
import dev.game.Entity.Entity;
import dev.game.Handler;
import dev.game.state.State;
import dev.game.tiles.Tile;

public abstract class Creature extends Entity {

    protected int health;
    protected float speedx, speedy;
    protected float xMove, yMove;

    public static final int DEFAULT_HEALTH = 10;
    public static float DEFAULT_SPEEDX = 3.0f;
    public static float DEFAULT_SPEEDY = -48.0f;
    public static final int DEFAULT_WIDTH = 16;
    public static final int DEFAULT_HEIGHT = 16;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speedx = DEFAULT_SPEEDX;
        speedy = DEFAULT_SPEEDY;
        xMove = 0;
        yMove = 0;
    }

    public void CPC() {

    }

    public void move() {
        if (!CECollitions(xMove, 0f)) {
            moveX();
        }
        if (!CECollitions(0f, yMove)) {
            moveY();
        }
    }

    public void moveX() {
        if (xMove > 0) {//rigth
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.Twidth;

            if (!CWTile(tx, (int) (y + bounds.y) / Tile.Theight) && !CWTile(tx, (int) (y + bounds.y + bounds.height) / Tile.Theight)) {

                x += xMove;

            } else {

                x = tx * Tile.Twidth - bounds.x - bounds.width - 1;

            }
        } else if (xMove < 0) {//left
            int tx = (int) (x + xMove + bounds.x) / Tile.Twidth;

            if (!CWTile(tx, (int) (y + bounds.y) / Tile.Theight) && !CWTile(tx, (int) (y + bounds.y + bounds.height) / Tile.Theight)) {

                x += xMove;
                

            } else {

                x = tx * Tile.Twidth + Tile.Twidth - bounds.x;

            }
        }

    }

    public void moveY() {
        if (yMove < 0) {//up
            int ty = (int) (y + yMove + bounds.y) / Tile.Theight;
            if (!CWTile((int) (x + bounds.x) / Tile.Twidth, ty) && !CWTile((int) (x + bounds.x + bounds.width) / Tile.Twidth, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.Theight + Tile.Theight - bounds.y;

            }
        } else if (yMove > 0) {//down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.Theight;
            if (!CWTile((int) (x + bounds.x) / Tile.Twidth, ty) && !CWTile((int) (x + bounds.x + bounds.width) / Tile.Twidth, ty)) {
                y += yMove;
            } else {

                y = ty * Tile.Theight - bounds.y - bounds.height - 1;

            }
        }
    }

    protected boolean CWTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }

    protected boolean CheckTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isCheckPoint();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeedx() {
        return speedx;
    }

    public void setSpeedx(float speed) {
        this.speedx = speed;
    }

    public float getSpeedy() {
        return speedy;
    }

    public void setSpeedy(float speed) {
        this.speedy = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

}
