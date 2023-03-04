package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hero extends GameObject {

    private MyGdxGame game;

    private int hpValue;

    private int coins;

    private float speed;

    private Texture hp;

    public Hero(MyGdxGame game) {
        super();
        this.game = game;
        x = 200.0f;
        y = 300.0f;
        coins = 0;
        hpValue = 100;
        texture = new Texture("Knight.png");
        hp = new Texture("Bar.png");
        speed = 200.0f;
    }

    @Override
    public void update(float deltaTime) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += speed * deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= speed * deltaTime;;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += speed * deltaTime;;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= speed * deltaTime;;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y);
        batch.setColor(1, 0, 0, 1);
        batch.draw(hp, x, y + 100);
        batch.setColor(1, 1, 1, 1);
    }

    public void addCoins(Coin coin) {
        coins += coin.getValue();
    }

    public void makeDamage(int damage) {
        this.hpValue -= damage;
        System.out.println(hpValue);
        if (hpValue < 0) {
            game.endGame();
        }
    }
}
