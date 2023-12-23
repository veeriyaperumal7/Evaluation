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
		getPositionOfMonster();
		// getPositionOfTriger();
		getPositionOfPit();
		getPositionOfGold();
		pathCount = gameViewModel.getPathCount();
		if (pathCount != -1) {
			System.out.print("The minimum path is : " + pathCount);

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

	private void getPositionOfTriger() {
		int row, column;
		System.out.print("Enter the position of triger row : ");
		row = read.nextInt();
		System.out.print("Enter the position of triger column : ");
		column = read.nextInt();
		gameViewModel.setTrigerPosition(row, column);
	}

	private void getPositionOfPit() {

		int row, column, n;
		System.out.print("Enter the how many pits : ");
		n = read.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print("Enter the position of pit row : ");
			row = read.nextInt();
			System.out.print("Enter the position of pit column : ");
			column = read.nextInt();
			gameViewModel.setPitPosition(row, column);
		}

	}

}
