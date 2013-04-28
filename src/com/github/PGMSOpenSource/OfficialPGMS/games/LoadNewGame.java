package com.github.PGMSOpenSource.OfficialPGMS.games;

public class LoadNewGame 
{
	String map;
	int teamsize;
	String teamcolours;
	int timeToNextMap;
	
	public LoadNewGame(String m, int size, String color, int time)
	{
		//TODO: Add schedulers and add more logic to this.
		//Schedule... then
		new StartGame();
	}
}
