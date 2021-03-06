package com.namosca.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.namosca.game.MarioBros;
import com.namosca.game.Scenes.Hud;

public class Brick extends InteractiveTileObject{
	public Brick(World world, TiledMap map, Rectangle bounds) {
		super(world, map, bounds);
		fixture.setUserData(this);
		setCategoryFilter(MarioBros.BRICK_BIT);
	}

	@Override
	public void onHeadHit() {
		Gdx.app.log("Brick", "collision");
		setCategoryFilter(MarioBros.DESTROYED_BIT);
		getCell().setTile(null);
		Hud.addScore(200);
		MarioBros.manager.get("resources/audio/sounds/breakblock.wav",Sound.class).play();
		
	}

}
