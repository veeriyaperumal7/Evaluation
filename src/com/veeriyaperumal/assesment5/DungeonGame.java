package com.veeriyaperumal.assesment5;

import java.util.Scanner;

import com.veeriyaperumal.assesment5.game.GameView;

public class DungeonGame {

	private static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		GameView gameView = new GameView();
		gameView.start();
	}

}
