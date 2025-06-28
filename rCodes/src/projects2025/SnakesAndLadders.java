package projects2025;
import java.util.*;
/*
 Providing as reference:
 https://en.wikipedia.org/wiki/Snakes_and_ladders
 
 The variation here is based on how I've played...so 3 rolls of 6 is unlucky!
 */
public class SnakesAndLadders {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		//Welcoming players.
		System.out.println("Welcome! This is a game of snakes and ladders");
	
		System.out.println("Input the number of players");
		int playerCount = player();
		int [] playerPos = new int [playerCount]; 

		String [] playerNames = new String [playerCount]; //To store the names of each of the players
		for (int i = 0; i<playerCount; i++) {
			System.out.println("Input player " + (i+1) + "'s name: ");
			playerNames[i] = input.next(); //Store the player name.
			playerPos[i] = 1;
		}
		for (int i = 0; i<playerCount; i++) {
			System.out.println("Welcome " + playerNames[i]); 
		
		}

		int max = 1; //starting position is 1
		int i, dice, extra = 0, diceRolls = 1; //player count, for 6 & rolls, and # of dice rolls
		do {
			diceRolls = 0;
			System.out.println("Which player is rolling now? (Type their number)");
			i = input.nextInt() - 1;
			
			dice = diceRoll();
			System.out.println("ROLLED a " + dice);
			if (dice == 6) {
				while ((extra < 18)&&(diceRolls < 3)&&(extra%6==0)) {
				diceRolls++;
				extra += dice;
				if ((diceRolls < 3)&&(dice == 6)) {
				System.out.println("A 6 was rolled so, we're rolling again. (Roll " + diceRolls + ")");
				dice = diceRoll();
				}
				else {
				System.out.println("ROLLED: " + dice + ", ROLL #" + diceRolls);
				}
				
			}
			}
			diceRolls = 1;
			if ((extra > 6)&&(extra < 18)) {
				playerPos[i] = updatePos(playerPos[i], extra);
			}
			else {
				playerPos[i] = updatePos(playerPos[i], dice);
			}
			if (playerPos[i] > max) {
				max = playerPos[i];
			}
			
			printPlayerPos(playerNames, playerPos);
			extra = 0;
			
		}
		while (max!=100); 
		System.out.println("Game over!");
		
	}
	
	public static int diceRoll() {
		int diceRoll = (int) ((Math.random()*6)+1);
		return diceRoll;
	}
	
	public static int player() {
		Scanner input = new Scanner (System.in);
		int playerCount = input.nextInt(); 
		return playerCount;
	}
	
	public static int updatePos(int currentPos, int diceRolled) { //update position based on the rolling
		int position;
		if ((currentPos<100)&&(currentPos+diceRolled<=100)) {
			position = currentPos + diceRolled;
		}
		else position = currentPos;
		if (position==2) {
			System.out.print("Position was: " + position + " but now CLIMBS UP THE LADDER to: ");
			position = 23;
			System.out.println(position);
		}
		else if (position==8) {
			System.out.print("Position was: " + position + " but now CLIMBS UP THE LADDER to: ");
			position = 12;
			System.out.println(position);
		}
		else if (position==17) {
			System.out.print("Position was: " + position + " but now CLIMBS UP THE LADDER to: ");
			position = 93;
			System.out.println(position);
		}
		else if (position==29) {
			System.out.print("Position was: " + position + " but now CLIMBS UP THE LADDER to: ");
			position = 54;
			System.out.println(position);
		}
		else if (position==31) {
			System.out.print("Position was: " + position + " but now IS CAUGHT BY THE SNAKE TO FALL to: ");
			position = 14;
			System.out.println(position);
		}
		else if (position==32) {
			System.out.print("Position was: " + position + " but now CLIMBS UP THE LADDER to: ");
			position = 51;
			System.out.println(position);
		}
		else if (position==39) {
			System.out.print("Position was: " + position + " but now CLIMBS UP THE LADDER to: ");
			position = 80;
			System.out.println(position);
		}
		else if (position==41) {
			System.out.print("Position was: " + position + " but now IS CAUGHT BY THE SNAKE TO FALL to: ");
			position = 20;
			System.out.println(position);
		}
		else if (position==59) {
			System.out.print("Position was: " + position + " but now IS CAUGHT BY THE SNAKE TO FALL to: ");
			position = 37;
			System.out.println(position);
		}
		else if (position==62) {
			System.out.print("Position was: " + position + " but now CLIMBS UP THE LADDER to: ");
			position = 78;
			System.out.println(position);
		}
		else if (position==67) {
			System.out.print("Position was: " + position + " but now IS CAUGHT BY THE SNAKE TO FALL to: ");
			position = 50;
			System.out.println(position);
		}
		else if (position==70) {
			System.out.print("Position was: " + position + " but now CLIMBS UP THE LADDER to: ");
			position = 89;
			System.out.println(position);
		}
		else if (position==75) {
			System.out.print("Position was: " + position + " but now CLIMBS UP THE LADDER to: ");
			position = 96;
			System.out.println(position);
		}
		else if (position==83) {
			System.out.print("Position was: " + position + " but now IS CAUGHT BY THE SNAKE TO FALL to: ");
			System.out.println(position);
			position = 80;
		}
		else if (position==92) {
			System.out.print("Position was: " + position + " but now IS CAUGHT BY THE SNAKE TO FALL to: ");
			position = 76;
			System.out.println(position);
		}
		else if (position==99) {
			System.out.print("Position was: " + position + " but now IS CAUGHT BY THE SNAKE TO FALL to: ");
			position = 4;
			System.out.println(position);
		}
		return position;
	}
	
	public static void printPlayerPos(String[]player, int[] pos) { //showing the board
		for (int i = 0; i<player.length; i++) {
			System.out.println(player[i] + " is at: " + pos[i]);

		}
	}
	

}

