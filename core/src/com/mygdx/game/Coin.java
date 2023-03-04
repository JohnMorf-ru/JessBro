package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Setter
@Getter
public class Coin extends GameObject {

    private MyGdxGame game;

    private int value;

    public Coin(MyGdxGame game) {
        super();
        value = 10;
        Random random = new Random();
        x = 40f + (500f - 0f) * random.nextFloat();
        y = 40f + (500f - 0f) * random.nextFloat();
        texture = new Texture("goldCoin1.png");
        this.game = game;
    }

    @Override
    public void update(float deltaTime) {
        if ((Math.abs(game.getHero().getX() - x) < 10) && (Math.abs(game.getHero().getY() - y) < 10)) {
            System.out.println("getCoin");
            game.refreshCoin(this);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
            batch.draw(texture, x, y);
    }

    public void refreshPosition() {
        value = 10;
        Random random = new Random();
        x = 40f + (500f - 0f) * random.nextFloat();
        System.out.println(x);
        y = 40f + (500f - 0f) * random.nextFloat();
        System.out.println(y);
    }
}
