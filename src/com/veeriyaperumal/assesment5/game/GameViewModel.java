package com.veeriyaperumal.assesment5.game;

import com.veeriyaperumal.assesment5.repository.Repository;

public class GameViewModel {

	GameView gameView;

	public GameViewModel(GameView gameView) {
		this.gameView = gameView;
	}

	public void setRoom(int row, int column) {
		Repository.getInstance().setRoom(row, column);
	}

	public void setAdventurePosition(int row, int column) {
		Repository.getInstance().setAdventure(row, column);
	}

	public void setGoldPosition(int row, int column) {
		Repository.getInstance().setGold(row, column);
	}

	public int getPathCount() {
		int rowsToMove = Math
				.abs(Repository.getInstance().getAdventure().getRow() - Repository.getInstance().getGold().getRow());
		int columnsToMove = Math.abs(
				Repository.getInstance().getAdventure().getColumn() - Repository.getInstance().getGold().getColumn());
		return rowsToMove + columnsToMove;
	}

}
