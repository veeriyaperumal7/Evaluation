package com.veeriyaperumal.assesment5.repository;

import java.util.ArrayList;

import com.veeriyaperumal.assesment5.dto.Position;

public class Repository {

	char rooms[][];
	private Position adventure;
	private Position gold;
	private Position monster;
	private Position triger;

	ArrayList<Position> pits = new ArrayList<>();

	public ArrayList<Position> getPits() {
		return pits;
	}

	private static Repository repository;

	private Repository() {

	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public void setRoom(int row, int column) {
		rooms = new char[row][column];
	}

	public Position getAdventure() {
		return adventure;
	}

	public void setAdventure(int row, int column) {
		this.adventure = new Position(row, column);
		rooms[row - 1][column - 1] = 'A';
	}

	public Position getGold() {
		return gold;
	}

	public void setGold(int row, int column) {
		this.gold = new Position(row, column);
		rooms[row - 1][column - 1] = 'G';
	}

	public void setMonster(int row, int column) {
		this.monster = new Position(row, column);
		rooms[row - 1][column - 1] = 'M';
	}

	public Position getMonster() {
		return monster;
	}

	public char[][] getRoom() {
		return rooms;
	}

	public void setTriger(int row, int column) {
		this.triger = new Position(row, column);
		rooms[row - 1][column - 1] = 'T';
	}

	public Position getTriger() {
		return triger;
	}

	public void setPit(int row, int column) {
		rooms[row - 1][column - 1] = 'P';
		pits.add(new Position(row, column));
	}

}
