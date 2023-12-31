package com.veeriyaperumal.assesment5.game;

import java.util.*;

import com.veeriyaperumal.assesment5.dto.Position;
import com.veeriyaperumal.assesment5.repository.Repository;

public class GameViewModel {

	private GameView gameView;
	private ArrayList<ArrayList<Position>> adventurePath = new ArrayList<>();
	private ArrayList<ArrayList<Position>> monsterPath = new ArrayList<>();
	private ArrayList<ArrayList<Position>> trigerPath = new ArrayList<>();
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

		return getPath();
   
	}

	private int getPath() {

		ArrayList<Position> adventure = new ArrayList();
		ArrayList<Position> monster = new ArrayList();
		int size;
		generateMonster(Repository.getInstance().getMonster().getRow() - 1,
				Repository.getInstance().getMonster().getColumn() - 1, monster, Repository.getInstance().getRoom(),
				monsterMove);

		generateAdventure(Repository.getInstance().getAdventure().getRow() - 1,
				Repository.getInstance().getAdventure().getColumn() - 1, adventure, Repository.getInstance().getRoom(),
				monsterMove);

		size = validpath();
		if (size > monsterMove) {

			size = getTriggerPath();
			if (size > 0) {
				return size;
			} else {
				return -1;
			}
		} else {
			return size;
		}

	}

	private int getTriggerPath() {
		int min = Integer.MAX_VALUE;
		ArrayList<Position> adventure = new ArrayList();
		trigerMove = findMinimumPathToReachTriger(Repository.getInstance().getAdventure().getRow() - 1,
				Repository.getInstance().getAdventure().getColumn() - 1, Repository.getInstance().getRoom());
		if (trigerMove < 0) {
			return -1;
		}

		min = Integer.MAX_VALUE;

		generateAdventure(Repository.getInstance().getTriger().getRow() - 1,
				Repository.getInstance().getTriger().getColumn() - 1, adventure, Repository.getInstance().getRoom(),
				monsterMove);
		if (adventurePath.size() < 1) {
			return -1;
		}
		for (int i = 0; i < adventurePath.size(); i++) {
			min = Math.min(min, adventurePath.get(i).size());
		}
		return trigerMove + min - 1;
	}
	
	public ArrayList<Position> findPath(int startRow,int startColumn,int targetRow,int targetColumn,char[][] room){
		int[] xAxis = {0,0,-1,1};
		int[] yAxis = {-1,1,0,0};
		boolean[][] visited = new boolean[room.length][room[0].length];
		Queue<Position> paths = new LinkedList<>();
		paths.add(new Position(startRow, startRow));
		while(!paths.isEmpty()) {
			Position current = paths.poll();		
			if(current.getRow()==targetRow && current.getColumn()==targetColumn) {
				return current.getPaths();
			}
			for(int i=0;i<xAxis.length;i++) {
				Position newPosition = new Position(current.getRow()+xAxis[i],current.getColumn()+yAxis[i]);
				if(isValidPosition(newPosition,room,visited)) {
					
				}
			}
		}
		return null;
	}
	
	private boolean isValidPosition(Position pos,char room[][],boolean visited[][]) {
		if(pos.getRow()>=0 && pos.getRow()<room.length && pos.getColumn()>=0 && pos.getColumn()<room[0].length && room[pos.getRow()][pos.getColumn()]!='P' && room[pos.getRow()][pos.getColumn()]!='M') {
			return true;
		}
		return false;
	}

	private int findMinimumPathToReachTriger(int row, int column, char[][] room) {
		int[] rowMoves = { 0, 0, -1, 1 };
		int[] colMoves = { -1, 1, 0, 0 };
	
		Queue<Position> paths = new LinkedList<>();
		paths.add(new Position(row, column, 0));
//		visited[row][column] = true;
		while (!paths.isEmpty()) {
			Position currentPosition = paths.poll();
			if (currentPosition.getRow() == Repository.getInstance().getTriger().getRow() - 1
					&& currentPosition.getColumn() == Repository.getInstance().getTriger().getColumn() - 1) {
				return currentPosition.getDistance();
			}
			for (int i = 0; i < rowMoves.length; i++) {
				int row1 = rowMoves[i] + currentPosition.getRow();
				int column1 = colMoves[i] + currentPosition.getColumn();
//				if (row1 >= 0 && column1 >= 0 && row1 < room.length && column1 < room[0].length
//						&& !visited[row1][column1] && room[row1][column1] != 'P') {
//					visited[row1][column1] = true;
//					paths.add(new Position(row1, column1, currentPosition.getDistance() + 1));
//				}
			}
		}

		return -1;
	}

	private int validpath() {
		int min = Integer.MAX_VALUE;
		boolean flag = false;
		ArrayList<Position> adventure = new ArrayList();
		ArrayList<Position> monster = new ArrayList();

		for (int i = 0; i < adventurePath.size(); i++) {
			adventure = adventurePath.get(i);
			flag = false;
			for (int k = 0; k < monsterPath.size(); k++) {
				if (flag) {
					break;
				}
				monster = monsterPath.get(k);
				for (int l = 1; l < adventure.size() && l < monster.size(); l++) {

					if (monster.get(l - 1).getRow() == adventure.get(l).getRow()
							&& monster.get(l - 1).getColumn() == adventure.get(l).getColumn()) {
						adventurePath.remove(i);
						flag = true;
						break;
					}
				}

			}

		}

		for (int i = 0; i < adventurePath.size(); i++) {
			min = Math.min(min, adventurePath.get(i).size());
		}

		return (min == Integer.MAX_VALUE) ? -1 : min - 1;
	}

	private void generateAdventure(int row, int column, ArrayList<Position> adventure, char[][] room,
			int minumumMonsterMove) {

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
			generateAdventure(row + 1, column, adventure, room, minumumMonsterMove);

		if (row > Repository.getInstance().getGold().getRow() - 1)
			generateAdventure(row - 1, column, adventure, room, minumumMonsterMove);

		if (column < Repository.getInstance().getGold().getColumn() - 1)
			generateAdventure(row, column + 1, adventure, room, minumumMonsterMove);

		if (column > Repository.getInstance().getGold().getColumn() - 1)
			generateAdventure(row, column - 1, adventure, room, minumumMonsterMove);

		adventure.remove(adventure.size() - 1);

	}

	private void generateMonster(int row, int column, ArrayList<Position> monster, char[][] room,
			int minumumMonsterMove) {

		if (row == Repository.getInstance().getGold().getRow() - 1
				&& column == Repository.getInstance().getGold().getColumn() - 1
				&& monster.size() - 1 <= minumumMonsterMove) {
			monster.add(new Position(row, column));
			monsterPath.add(new ArrayList(monster));
			return;
		}
		if (row < 0 || column < 0 || row >= room.length || column >= room[0].length
				|| monster.size() - 1 > minumumMonsterMove) {
			return;
		}

		monster.add(new Position(row, column));

		if (row < Repository.getInstance().getGold().getRow() - 1)
			generateMonster(row + 1, column, monster, room, minumumMonsterMove);

		if (row > Repository.getInstance().getGold().getRow() - 1)
			generateMonster(row - 1, column, monster, room, minumumMonsterMove);

		if (column < Repository.getInstance().getGold().getColumn() - 1)
			generateMonster(row, column + 1, monster, room, minumumMonsterMove);

		if (column > Repository.getInstance().getGold().getColumn() - 1)
			generateMonster(row, column - 1, monster, room, minumumMonsterMove);
		monster.remove(monster.size() - 1);

	}

	public void setPitPosition(int row, int column) {
		Repository.getInstance().setPit(row, column);

	}

	public void setTrigerPosition(int row, int column) {
		Repository.getInstance().setTriger(row, column);

	}
	
}
