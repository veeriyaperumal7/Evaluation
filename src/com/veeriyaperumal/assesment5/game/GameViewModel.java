package com.veeriyaperumal.assesment5.game;

import java.util.ArrayList;

import com.veeriyaperumal.assesment5.dto.Position;
import com.veeriyaperumal.assesment5.repository.Repository;

public class GameViewModel {

	private GameView gameView;
	private ArrayList<ArrayList<Position>> adventurePath = new ArrayList<>();
	private ArrayList<ArrayList<Position>> monsterPath = new ArrayList<>();
	int adventureMove, monsterMove;

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
		rowsToMove = Math
				.abs(Repository.getInstance().getAdventure().getRow() - Repository.getInstance().getGold().getRow());
		columnsToMove = Math.abs(
				Repository.getInstance().getAdventure().getColumn() - Repository.getInstance().getGold().getColumn());
		adventureMove = rowsToMove + columnsToMove;

		rowsToMove = Math
				.abs(Repository.getInstance().getMonster().getRow() - Repository.getInstance().getGold().getRow());
		columnsToMove = Math.abs(
				Repository.getInstance().getMonster().getColumn() - Repository.getInstance().getGold().getColumn());
		monsterMove = rowsToMove + columnsToMove;
		if (adventureMove <= monsterMove) {
			return adventureMove;
		} else {
			return -1;
		}
	}

	public ArrayList<Position> getPath() {
		ArrayList<Position> adventure = new ArrayList();
		ArrayList<Position> monster = new ArrayList();

		generateMonster(Repository.getInstance().getMonster().getRow() - 1,
				Repository.getInstance().getMonster().getColumn() - 1, monster, Repository.getInstance().getRoom(), 0,
				monsterMove);

		generateAdventure(Repository.getInstance().getAdventure().getRow() - 1,
				Repository.getInstance().getAdventure().getColumn() - 1, adventure, Repository.getInstance().getRoom(), 0,
				adventureMove);
		
		return validpath();
	}

	private ArrayList<Position> validpath() {
		boolean flag = false;
		ArrayList<Position> adventure = new ArrayList();
		ArrayList<Position> monster = new ArrayList();
		for (int i = 0; i < monsterPath.size(); i++) {
			monster = monsterPath.get(i);
			for (int j = 0; j < adventurePath.size(); j++) {
				adventure = adventurePath.get(j);

				for (int k = 0; k < adventure.size(); k++) {
					if (flag == true) {
						break;
					}
					for (int l = 0; l < monster.size(); l++) {
						if (adventure.get(i).getRow() == monster.get(i).getRow()
								&& adventure.get(i).getColumn() == monster.get(i).getColumn()) {
							flag = true;
							break;
						}
					}
				}

			}
			if (!flag) {
				return adventure;
			}
		}
		return null;
	}

	private void generateMonster(int row, int column, ArrayList<Position> monster, char[][] room,
			int currentMonsterMove, int minumumMonsterMove) {

		if (row == Repository.getInstance().getGold().getRow() - 1
				&& column == Repository.getInstance().getGold().getColumn() - 1
				&& currentMonsterMove <= minumumMonsterMove) {
			monster.add(new Position(row, column));
			monsterPath.add(new ArrayList(monster));
			return;
		}
		if (row < 0 || column < 0 || row >= room.length || column >= room[0].length
				|| currentMonsterMove > monsterMove) {
			return;
		}

		monster.add(new Position(row, column));
		generateMonster(row + 1, column, monster, room, currentMonsterMove + 1, minumumMonsterMove);
		monster.remove(monster.size() - 1);

		monster.add(new Position(row, column));
		generateMonster(row - 1, column, monster, room, currentMonsterMove + 1, minumumMonsterMove);
		monster.remove(monster.size() - 1);

		monster.add(new Position(row, column));
		generateMonster(row, column + 1, monster, room, currentMonsterMove + 1, minumumMonsterMove);
		monster.remove(monster.size() - 1);

		monster.add(new Position(row, column));
		generateMonster(row, column - 1, monster, room, currentMonsterMove + 1, minumumMonsterMove);
		monster.remove(monster.size() - 1);

	}

	private void generateAdventure(int row, int column, ArrayList<Position> adventure, char[][] room,
			int currentAdventureMove, int minumumAdventureMove) {

		if (row == Repository.getInstance().getGold().getRow() - 1
				&& column == Repository.getInstance().getGold().getColumn() - 1
				&& currentAdventureMove <= minumumAdventureMove) {
			adventure.add(new Position(row, column));
			adventurePath.add(new ArrayList(adventure));
			return;
		}
		if (row < 0 || column < 0 || row >= room.length || column >= room[0].length
				|| currentAdventureMove > monsterMove) {
			return;
		}

		adventure.add(new Position(row, column));
		generateAdventure(row + 1, column, adventure, room, currentAdventureMove + 1, minumumAdventureMove);
		adventure.remove(adventure.size() - 1);

		adventure.add(new Position(row, column));
		generateAdventure(row - 1, column, adventure, room, currentAdventureMove + 1, minumumAdventureMove);
		adventure.remove(adventure.size() - 1);

		adventure.add(new Position(row, column));
		generateAdventure(row, column + 1, adventure, room, currentAdventureMove + 1, minumumAdventureMove);
		adventure.remove(adventure.size() - 1);

		adventure.add(new Position(row, column));
		generateAdventure(row, column - 1, adventure, room, currentAdventureMove + 1, minumumAdventureMove);
		adventure.remove(adventure.size() - 1);

	}

}
