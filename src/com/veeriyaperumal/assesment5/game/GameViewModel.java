package com.veeriyaperumal.assesment5.game;

import java.util.*;

import com.veeriyaperumal.assesment5.dto.Position;
import com.veeriyaperumal.assesment5.repository.Repository;

public class GameViewModel {

	private GameView gameView;
	private ArrayList<ArrayList<Position>> adventurePath = new ArrayList<>();
	private ArrayList<ArrayList<Position>> monsterPath = new ArrayList<>();
	int adventureMove, monsterMove, trigerMove;

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

	public void setMonsterPosition(int row, int column) {
		Repository.getInstance().setMonster(row, column);

	}

	public int getPathCount() {
		int rowsToMove, columnsToMove;
		ArrayList<Position> adventure = new ArrayList<>();
		generateAdventure(Repository.getInstance().getAdventure().getRow() - 1,
				Repository.getInstance().getAdventure().getColumn() - 1, adventure, Repository.getInstance().getRoom());
		return removePitPath();
	}

	public int removePitPath() {
		ArrayList<Position> pits = Repository.getInstance().getPits();
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < adventurePath.size(); i++) {
			min=Math.min(min, adventurePath.get(i).size());
		}

		return (min == Integer.MAX_VALUE) ? -1 : min - 1;
	}

	private void generateAdventure(int row, int column, ArrayList<Position> adventure, char[][] room) {

		if (row == Repository.getInstance().getGold().getRow() - 1
				&& column == Repository.getInstance().getGold().getColumn() - 1) {
			adventure.add(new Position(row, column));
			adventurePath.add(new ArrayList(adventure));
			return;
		}
		if (row < 0 || column < 0 || row >= room.length || column >= room[0].length || room[row][column] == 'P') {
			return;
		}

		adventure.add(new Position(row, column));
		if (row < Repository.getInstance().getGold().getRow() - 1)
			generateAdventure(row + 1, column, adventure, room);

		if (column < Repository.getInstance().getGold().getColumn() - 1)
			generateAdventure(row, column + 1, adventure, room);

		if (row > Repository.getInstance().getGold().getRow() - 1)
			generateAdventure(row - 1, column, adventure, room);

		if (column > Repository.getInstance().getGold().getColumn() - 1)
			generateAdventure(row, column - 1, adventure, room);

		adventure.remove(adventure.size() - 1);

	}

	public void setPitPosition(int row, int column) {
		Repository.getInstance().setPit(row, column);

	}

	public void setTrigerPosition(int row, int column) {
		Repository.getInstance().setTriger(row, column);

	}

}