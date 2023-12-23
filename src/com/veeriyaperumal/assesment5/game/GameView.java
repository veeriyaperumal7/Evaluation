package com.veeriyaperumal.assesment5.game;

import com.veeriyaperumal.assesment5.repository.Repository;
import java.util.Scanner;

public class GameView {
	private static Scanner read = new Scanner(System.in);
	GameViewModel gameViewModel;

	public GameView() {
		this.gameViewModel = new GameViewModel(this);
	}

	public void start() {
		getRoomInput();
		getPositionOfAdventure();
		getPositionOfGold();
		System.out.println("This minimum count to reach : " +  gameViewModel.getPathCount());
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

}
