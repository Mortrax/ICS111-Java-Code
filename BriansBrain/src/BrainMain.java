/* 
 * Copyright (C) 2017 Billy Troy Wooton - All Rights Reserved
 * A modest implementation of Brian's Brain Cellular Automaton
 * Hand coded by Billy Troy Wooton on 12 March, 2017
 * ------------------------------------------------------------
 * This program uses a two dimensional array of EZRectangles that
 * can be shown/hidden/color swapped to mimic the life/death/decay of a cell
 * per the rules of Brian's Brain
 * 
 * A two dimensional state array that holds 0s, 1s, and 2s maps to the
 * array of cells and holds the value representing the state of
 * its corresponding cell; e.g. if cells[j][i].isShowing(), and
 * cells[j][i].getColor() == Color.BLACK, then currentState[j][i] == 1
 * 
 * The grid can begin randomized, thanks to a randomly seeded state array
 * Thereafter the user by pressing the 'n' key can cause the system to
 * proceed to the next generation. This behavior continues forever as
 * long as the system is changing between generations.
 * 
 * The user also has the option to set cells manually prior to
 * initiating the iteration phase of the program
 * 
 * The program takes awhile to initialize as the array needs to be filled
 * with EZRectangles and they need to be drawn to the screen before they
 * can be modified and used
 * 
 * Hope that you enjoy the program and feel free to use it as a demo for future
 * classes/semesters if you would like :)
 */

import java.awt.Color;
import java.util.Random;

public class BrainMain {
	// counts the number of living neighbors that a cell has so that a decision can be made as to
	// the fate of the cell in question (the cell being the cell contained in the stateArray at
	// the currentJ and currentI indices) Uses the Moore concept of neighbors
	static int sumHelper(int[] ns, int s) {
		for (int i = 0; i < ns.length; i++) {
			if (ns[i] == 1) {
				s += 1;
			}
				
		}
		return s;
	}
	static int sumNeighbors(int[][] stateArray, int currentJ, int currentI) {
		int[] neighbors;
		int sum = 0;
		
		if (currentJ == 0) {
			if (currentI == 0) {
				neighbors = new int[] {stateArray[currentJ + 1][currentI], stateArray[currentJ][currentI + 1],
					stateArray[currentJ + 1][currentI + 1]};
				sum = sumHelper(neighbors, 0);
				return sum;
			}
			else if (currentI == DIMENSION - 1) {
				neighbors = new int[] {stateArray[currentJ][currentI - 1], stateArray[currentJ + 1][currentI],
						stateArray[currentJ + 1][currentI - 1]};
				sum = sumHelper(neighbors, 0);
				return sum;
			}
			else {
				neighbors = new int[] {stateArray[currentJ][currentI - 1], stateArray[currentJ][currentI + 1],
						stateArray[currentJ + 1][currentI + 1], stateArray[currentJ + 1][currentI],
						stateArray[currentJ + 1][currentI - 1]};
				sum = sumHelper(neighbors, 0);
				return sum;
			}
		}
		else if (currentJ == DIMENSION - 1) {
			if (currentI == 0) {
				neighbors = new int[] {stateArray[currentJ][currentI + 1], stateArray[currentJ - 1][currentI],
						stateArray[currentJ - 1][currentI + 1]};
				sum = sumHelper(neighbors, 0);
				return sum;
			}
			else if (currentI == DIMENSION - 1) {
				neighbors = new int[] {stateArray[currentJ][currentI - 1], stateArray[currentJ - 1][currentI],
						stateArray[currentJ - 1][currentI - 1]};
				sum = sumHelper(neighbors, 0);
				return sum;
				
			}
			else {
				neighbors = new int[] {stateArray[currentJ][currentI + 1], stateArray[currentJ][currentI - 1],
						stateArray[currentJ - 1][currentI], stateArray[currentJ - 1][currentI - 1],
						stateArray[currentJ - 1][currentI + 1]};
				sum = sumHelper(neighbors, 0);
				return sum;
			}
		}
		else if (currentI == 0) {
			neighbors = new int[] {stateArray[currentJ + 1][currentI], stateArray[currentJ - 1][currentI],
					stateArray[currentJ][currentI + 1], stateArray[currentJ - 1][currentI + 1],
					stateArray[currentJ + 1][currentI + 1]};
			sum = sumHelper(neighbors, 0);
			return sum;
		}
		else if (currentI == DIMENSION - 1) {
			neighbors = new int[] {stateArray[currentJ + 1][currentI], stateArray[currentJ - 1][currentI],
					stateArray[currentJ][currentI - 1], stateArray[currentJ + 1][currentI - 1],
					stateArray[currentJ - 1][currentI - 1]};
			sum = sumHelper(neighbors, 0);
			return sum;
		}
		
		else {
			neighbors = new int[] {stateArray[currentJ + 1][currentI], stateArray[currentJ - 1][currentI],
					stateArray[currentJ][currentI + 1], stateArray[currentJ][currentI - 1],
					stateArray[currentJ + 1][currentI + 1], stateArray[currentJ - 1][currentI + 1],
					stateArray[currentJ - 1][currentI - 1], stateArray[currentJ + 1][currentI - 1]};
			sum = sumHelper(neighbors, 0);
			return sum;
		}
	}
	// function that maps the 1s and 0s in our state array to the
	// visual representation of cells in our cell array
	static void mapStatesToCells() {
		for (int j = 0; j < DIMENSION; j++) {
			for (int i = 0; i < DIMENSION; i++) {
				if (currentState[j][i] == 1) {
					cells[j][i].show();
					cells[j][i].setColor(Color.BLACK);
				}
				else if (currentState[j][i] == 2) {
					cells[j][i].show();
					cells[j][i].setColor(Color.BLUE);
				}
				else if (currentState[j][i] == 0) {
					cells[j][i].hide();
				}
			}
		}
	}
	
	// function to draw our grid and cells on the screen
	static void setUpGrid() {
		// starting x and y for our cells
		int x = SCREEN_WIDTH/(DIMENSION*2);
		int y = SCREEN_HEIGHT/(DIMENSION*2);
		// width and height for our cells
		int w = SCREEN_WIDTH/DIMENSION;
		int h = SCREEN_HEIGHT/DIMENSION;
		
		// draw a grid of vertical and horizontal lines to the screen for
		// visualization purposes
		for (int xcoord = w; xcoord < SCREEN_WIDTH; xcoord += w) {
			EZ.addLine(xcoord, 0, xcoord, SCREEN_HEIGHT, Color.GRAY);
		}
		
		for (int ycoord = h; ycoord < SCREEN_HEIGHT; ycoord += h) {
			EZ.addLine(0, ycoord, SCREEN_WIDTH, ycoord, Color.GRAY);
		}
		
		// add the rectangles (cells) to our grid and hide them by default
		for (int j = 0; j < DIMENSION; j++) {
			for (int i = 0; i < DIMENSION; i++) {
				cells[j][i] = EZ.addRectangle(x, y, w, h, Color.BLACK, true);
				cells[j][i].pushToBack();
				cells[j][i].hide();
				x += w;
			}
			x = SCREEN_WIDTH/(DIMENSION*2);
			y += h;
		}
		
		// initialize the state grid to have only zeroes
		for (int j = 0; j < DIMENSION; j++) {
			for (int i = 0; i < DIMENSION; i++) {
				currentState[j][i] = 0;
			}
		}
	}
	
	// function that allows the user to set the starting grid state
	static void userPlaceCells() {
		boolean placingCells = true;
		Color currentColor = Color.BLACK;
		
		while (placingCells) {
			EZ.refreshScreen();
			if (EZInteraction.wasKeyPressed('n')) {
				placingCells = false;
			}
			if (EZInteraction.wasKeyPressed('s')) {
				currentColor = currentColor == Color.BLACK ? Color.BLUE : Color.BLACK;
			}
			if (EZInteraction.wasMouseLeftButtonPressed() || EZInteraction.isMouseLeftButtonDown()) {
				for (int j = 0; j < DIMENSION; j++) {
					for (int i = 0; i < DIMENSION; i++) {
						if (cells[j][i].isPointInElement(EZInteraction.getXMouse(), EZInteraction.getYMouse())) {
							if (currentState[j][i] == 0) {
								cells[j][i].show();
							}
							if (currentColor == Color.BLACK) {
								currentState[j][i] = 1;
							}
							else {
								currentState[j][i] = 2;
							}
							cells[j][i].setColor(currentColor);
						}
					}
				}
			}
			if (EZInteraction.wasMouseRightButtonPressed() || EZInteraction.isMouseRightButtonDown()) {
				for (int j = 0; j < DIMENSION; j++) {
					for (int i = 0; i < DIMENSION; i++) {
						if (cells[j][i].isPointInElement(EZInteraction.getXMouse(), EZInteraction.getYMouse())) {
							if (currentState[j][i] == 1 || currentState[j][i] == 2) {
								currentState[j][i] = 0;
								cells[j][i].hide();
							}
							
						}
					}
				}
			}
		}
	}
	
	// function that allows for the random placement of starting cells
	static void randomPlaceCells() {
		// randomly seed the state grid with 0s, 1s, and 2s
		for (int j = 0; j < DIMENSION; j++) {
			for (int i = 0; i < DIMENSION; i++) {
				currentState[j][i] = rg.nextInt(3);
			}
		}
		// map the current state grid to the rectangle (cell) grid
		mapStatesToCells();
	}
	
	
	static void clearAllCells() {
		for (int j = 0; j < DIMENSION; j++) {
			for (int i = 0; i < DIMENSION; i++) {
				currentState[j][i] = 0;
			}
		}
		mapStatesToCells();
	}
	
	// random number generator allows for a randomized starting pattern for the grid
	static Random rg = new Random();
	
	// dimensions of our grid and specified size of each cell
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int DIMENSION = 50;
	
	// 2-Dimensional arrays to hold the cells
	static EZRectangle[][] cells = new EZRectangle[DIMENSION][DIMENSION];
	
	// 2-Dimensional binary array that holds the state of each cell
	// 1 means showing (alive); 0 means hidden (dead)
	static int[][] currentState = new int[DIMENSION][DIMENSION];

	public static void main(String[] args) {
		// initialize the screen
		EZ.initialize(SCREEN_WIDTH, SCREEN_HEIGHT);
		
		setUpGrid();
		
		//userPlaceCells();
		
	    randomPlaceCells();
		
		// loop only while the state of the universe is changing between iterations
		while (true) {
			// move to the next state whenever the user presses the 'n' key
			if (EZInteraction.wasKeyPressed("n")) {
				int[][] nextState = new int[DIMENSION][DIMENSION];
				for (int j = 0; j < DIMENSION; j++) {
					for (int i = 0; i < DIMENSION; i++) {
						if (currentState[j][i] == 1) {
							nextState[j][i] = 2;
						}
						else if (currentState[j][i] == 2) {
							nextState[j][i] = 0;	
						}
						else {
							if (sumNeighbors(currentState,j,i) == 2) {
								nextState[j][i] = 1;
							}
							else {
								nextState[j][i] = 0;
							}
						}
					}
				}
				currentState = nextState;
				mapStatesToCells();
				
			}
			if (EZInteraction.wasKeyPressed('p')) {
				userPlaceCells();
			}
			if (EZInteraction.wasKeyPressed('q')) {
				EZ.removeAllEZElements();
				break;
			}
			
			if (EZInteraction.wasKeyPressed('c')) {
				clearAllCells();
			}
 			EZ.refreshScreen();
		}
	
		
		
		EZ.refreshScreen();
		EZ.closeWindowWithIndex(0);
		
	}
}
