package com.xzq.design.creater.prototype;

public class EnemyPlane implements Cloneable {

    private int x;
    private int y;
    private Bullet bullet;

    public EnemyPlane(int x) {
        this.x = x;
    }

    public EnemyPlane(int x, Bullet bullet) {
        this.x = x;
        this.bullet = bullet;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 简单熟悉
        //return (EnemyPlane) super.clone();
        EnemyPlane clone = (EnemyPlane) super.clone();
        clone.setBullet((Bullet) this.bullet.clone());
        return clone;
    }
}
