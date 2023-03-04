package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Monster extends GameObject {

    private int gameObjects;

    private float speed;

    private MyGdxGame game;

    private float activityRadius;

    private float attackRadius;

    private int attackPeriodPerMillis;

    private int damage;

    private long previousAttackTimeMillis = 0;


    public Monster(MyGdxGame game) {
        super();
        System.out.println("new omnster");
        Random random = new Random();
        x = 400f + (1000f - 0f) * random.nextFloat();
        y = 20f + (700f - 0f) * random.nextFloat();
        this.texture = new Texture("Skeleton.png");
        this.speed = 100.0f;
        this.game = game;
        this.activityRadius = 300.0f;
        this.damage = 10;
        this.attackRadius = 30.0f;
        this.attackPeriodPerMillis = 1000;
    }

    @Override
    public void update(float deltaTime) {
        float dst = (float) Math.sqrt((game.getHero().getX() - this.x) * (game.getHero().getX() - this.x) + (game.getHero().getY() - this.y) * (game.getHero().getY() - this.y));
        if (dst <= activityRadius) {
            if (x < game.getHero().getX()) {
                x += speed * deltaTime;
            }
            if (x > game.getHero().getX()) {
                x -= speed * deltaTime;
            }
            if (y > game.getHero().getY()) {
                y -= speed * deltaTime;
            }
            if (y < game.getHero().getY()) {
                y += speed * deltaTime;
            }
        } else {
            x += speed * deltaTime;
            if (x > 1280.0f) {
                x = 0.0f;
            }
        }

        if (Math.abs(game.getHero().getX() - this.x) < attackRadius && Math.abs(game.getHero().getY() - this.y) < attackRadius) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - previousAttackTimeMillis > attackPeriodPerMillis) {
                game.getHero().makeDamage(damage);
                previousAttackTimeMillis = currentTimeMillis;
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

}