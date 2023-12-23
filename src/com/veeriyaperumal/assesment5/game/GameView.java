package com.veeriyaperumal.assesment5.game;

import com.veeriyaperumal.assesment5.dto.Position;
import java.util.ArrayList;

import java.util.Scanner;

public class GameView {
	private static Scanner read = new Scanner(System.in);
	GameViewModel gameViewModel;

	public GameView() {
		this.gameViewModel = new GameViewModel(this);
	}

	public void start() {
		int pathCount;
		getRoomInput();
		getPositionOfAdventure();
		getPositionOfGold();
		getPositionOfMonster();
		pathCount = gameViewModel.getPathCount();
		if (pathCount != -1) {
			ArrayList<Position> path = gameViewModel.getPath();
			for (int i = 1; i < path.size(); i += 2) {
				System.out.print("[" + (path.get(i).getRow() + 1) + "," + (path.get(i).getColumn() + 1) + "]->");
			}
			System.out.print("Gold");

		} else {
			System.out.println("There is no way to adventure reach the gold");
		}

	}

	private void getRoomInput() {
		int row, column;
		System.out.print("Enter the dungeon row : ");
		row = read.nextInt();
		System.out.print("Enter the dungeon column : ");
		column = read.nextInt();
		gameViewModel.setRoom(row, column);
	}

	private void getPositionOfAdventure() {
		int row, column;
		System.out.print("Enter the position of adventure row : ");
		row = read.nextInt();
		System.out.print("Enter the position of adventure column : ");
		column = read.nextInt();
		gameViewModel.setAdventurePosition(row, column);
	}

	private void getPositionOfGold() {
		int row, column;
		System.out.print("Enter the position of gold row : ");
		row = read.nextInt();
		System.out.print("Enter the position of gold column : ");
		column = read.nextInt();
		gameViewModel.setGoldPosition(row, column);
	}

	private void getPositionOfMonster() {
		int row, column;
		System.out.print("Enter the position of monster row : ");
		row = read.nextInt();
		System.out.print("Enter the position of monster column : ");
		column = read.nextInt();
		gameViewModel.setMonsterPosition(row, column);
	}

}
