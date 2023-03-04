package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public abstract class GameObject implements Updatable, Renderable {

    protected int id;

    protected float x;

    protected float y;

    protected Texture texture;

    public GameObject() {
        this.id = MyGdxGame.GameValues.gameObjects++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameObject that = (GameObject) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
