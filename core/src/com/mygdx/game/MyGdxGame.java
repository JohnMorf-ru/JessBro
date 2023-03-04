package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


@Getter
@Setter
public class MyGdxGame extends ApplicationAdapter {

    private BitmapFont font;

    private SpriteBatch batch;

    private Collection<GameObject> objects;

    private Hero hero;
    private boolean lose;

    @Override
    public void create() {
        font = new BitmapFont();
        batch = new SpriteBatch();
        objects = new ArrayList<>();
        hero = new Hero(this);
        objects.add(hero);
        objects.add(new Monster(this));
        objects.add(new Monster(this));
        objects.add(new Monster(this));
        objects.add(new Monster(this));
        objects.add(new Coin(this));
    }

    public void restartGame() {
        objects = new HashSet<>();
        hero = new Hero(this);
        objects.add(hero);
        objects.add(new Monster(this));



        objects.add(new Coin(this));
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.5f, 0.43f, 1, 0.5f);
        final float deltaTime = Gdx.graphics.getDeltaTime();
        update(deltaTime);
        batch.begin();
        for (GameObject object : objects) object.render(batch);
        font.draw(batch, "COINS = " + getHero().getCoins(), 30, 30);
        font.draw(batch, "HP = " + getHero().getHpValue(), 150, 30);
        if (lose) {
            font.draw(batch, "YOU LOSE", 600, 600);
        }
        batch.end();
    }

    public void update(float deltaTime) {
        for (GameObject gameObject : objects) gameObject.update(deltaTime);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void refreshCoin(Coin coin) {
        this.getHero().addCoins(coin);
        coin.refreshPosition();
    }

    public void endGame() {
        lose = true;
    }

    public static class GameValues {
        public static int gameObjects = 0;
    }
}
