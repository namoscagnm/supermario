package com.namosca.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.namosca.game.MarioBros;
import com.namosca.game.Scenes.Hud;


public class Coin extends InteractiveTileObject{
	private static TiledMapTileSet tileSet;
	private final int BLANK_COIN=28;
	
	
	public Coin(World world, TiledMap map, Rectangle bounds) {
		super(world, map, bounds);
		tileSet  = map.getTileSets().getTileSet("tileset_gutter");
		fixture.setUserData(this);
		setCategoryFilter(MarioBros.COIN_BIT);
	}

	@Override
	public void onHeadHit() {
		Gdx.app.log("Coin", "collision");
		if(getCell().getTile().getId()==BLANK_COIN) {
			MarioBros.manager.get("resources/audio/sounds/bump.wav",Sound.class).play();
		}else {
			MarioBros.manager.get("resources/audio/sounds/coin.wav",Sound.class).play();
		}
		getCell().setTile(tileSet.getTile(BLANK_COIN));
		Hud.addScore(100);
		
	}

}
