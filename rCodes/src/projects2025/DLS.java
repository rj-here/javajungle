package projects2025;
import java.util.*;
public class DLS {
/*
 * © 2025 Rishi
 * Last updated: 17th September, 2025
 * 
 * This method will be used to do calculations based on the Duckworth-Lewis-Stern system!
 * Sources:
 * https://www.omnicalculator.com/sports/duckworth-lewis
 * https://upload.wikimedia.org/wikipedia/commons/7/7f/%28Duckworth_Lewis%29_method_of_adjusting_target_scores.PNG
 * https://www.espncricinfo.com/ci/content/page/409991.html
 * 
 */
		
	public static void main(String[] args) {
	Scanner input = new Scanner (System.in);
	//This will be the main welcome page, from here, the user navigates to the said case they want to do.
	System.out.println("Greetings! Let's calculate DLS! For now, this is to just be for 50-over games (and the assumption is of maximum overs being 50). But first, which case is at hand here?");
	System.out.println("1. Team 1 has their innings interrupted.");
	System.out.println("2. Team 1 has their innings cut short.");
	System.out.println("3. Team 2 has their innings interrupted.");
	System.out.println("4. Team 2 has their innings cut short.");
	System.out.println("5. Team 2 has their innings delayed.");
	int caseNumber = input.nextInt();
	if (caseNumber == 1) {
		case1();
	}
	else if (caseNumber == 2) {
		case2();
	}
	else if (caseNumber == 3) {
		case3();
	}
	else if (caseNumber == 4) {
		case4();
	}
	else if (caseNumber == 5) {
		case5();
	}
	input.close();
	
	}
	public static double percentageDLS(int oversLeft, int wicketsLost) {
		/*This is is from: https://upload.wikimedia.org/wikipedia/commons/7/7f/%28Duckworth_Lewis%29_method_of_adjusting_target_scores.PNG
		 * This is loading the table, and getting the according percentage based on what 
		 */
		double[][] tableDLS = new double [50][10];
		//0 wickets lost
		tableDLS[49][0] = 100.0; //50 overs
		tableDLS[48][0] = 99.1; //49 overs
		tableDLS[47][0] = 98.1; //48 overs
		tableDLS[46][0] = 97.1; //47 overs
		tableDLS[45][0] = 96.1; //46 overs
		tableDLS[44][0] = 95.0; //45 overs
		tableDLS[43][0] = 93.9; //44 overs
		tableDLS[42][0] = 92.8; //43 overs
		tableDLS[41][0] = 91.7; //42 overs
		tableDLS[40][0] = 90.5; //41 overs
		tableDLS[39][0] = 89.3; //40 overs
		tableDLS[38][0] = 88.0; //39 overs
		tableDLS[37][0] = 86.7; //38 overs
		tableDLS[36][0] = 85.4; //37 overs
		tableDLS[35][0] = 84.1; //36 overs
		tableDLS[34][0] = 82.7; //35 overs
		tableDLS[33][0] = 81.3; //34 overs
		tableDLS[32][0] = 79.8; //33 overs
		tableDLS[31][0] = 78.3; //32 overs
		tableDLS[30][0] = 76.7; //31 overs
		tableDLS[29][0] = 75.1; //30 overs
		tableDLS[28][0] = 73.5; //29 overs
		tableDLS[27][0] = 71.8; //28 overs
		tableDLS[26][0] = 70.1; //27 overs
		tableDLS[25][0] = 68.3; //26 overs
		tableDLS[24][0] = 66.5; //25 overs
		tableDLS[23][0] = 64.6; //24 overs
		tableDLS[22][0] = 62.7; //23 overs
		tableDLS[21][0] = 60.7; //22 overs
		tableDLS[20][0] = 58.7; //21 overs
		tableDLS[19][0] = 56.6; //20 overs
		tableDLS[18][0] = 54.4; //19 overs
		tableDLS[17][0] = 52.2; //18 overs
		tableDLS[16][0] = 49.9; //17 overs
		tableDLS[15][0] = 47.6; //16 overs
		tableDLS[14][0] = 45.2; //15 overs
		tableDLS[13][0] = 42.7; //14 overs
		tableDLS[12][0] = 40.2; //13 overs
		tableDLS[11][0] = 37.6; //12 overs
		tableDLS[10][0] = 34.9; //11 overs
		tableDLS[9][0] = 32.1; //10 overs
		tableDLS[8][0] = 29.3; //9 overs
		tableDLS[7][0] = 26.4; //8 overs
		tableDLS[6][0] = 23.4; //7 overs
		tableDLS[5][0] = 20.3; //6 overs
		tableDLS[4][0] = 17.2; //5 overs
		tableDLS[3][0] = 13.9; //4 overs
		tableDLS[2][0] = 10.6; //3 overs
		tableDLS[1][0] = 7.2; //2 overs
		tableDLS[0][0] = 3.6; //1 over
		
		//1 wicket lost
		tableDLS[49][1] = 93.4; //50 overs
		tableDLS[48][1] = 92.6; //49 overs
		tableDLS[47][1] = 91.7; //48 overs
		tableDLS[46][1] = 90.9; //47 overs
		tableDLS[45][1] = 90.0; //46 overs
		tableDLS[44][1] = 89.1; //45 overs
		tableDLS[43][1] = 88.2; //44 overs
		tableDLS[42][1] = 87.3; //43 overs
		tableDLS[41][1] = 86.3; //42 overs
		tableDLS[40][1] = 85.3; //41 overs
		tableDLS[39][1] = 84.2; //40 overs
		tableDLS[38][1] = 83.1; //39 overs
		tableDLS[37][1] = 82.0; //38 overs
		tableDLS[36][1] = 80.9; //37 overs
		tableDLS[35][1] = 79.7; //36 overs
		tableDLS[34][1] = 78.5; //35 overs
		tableDLS[33][1] = 77.2; //34 overs
		tableDLS[32][1] = 75.9; //33 overs
		tableDLS[31][1] = 74.6; //32 overs
		tableDLS[30][1] = 73.2; //31 overs
		tableDLS[29][1] = 71.8; //30 overs
		tableDLS[28][1] = 70.3; //29 overs
		tableDLS[27][1] = 68.8; //28 overs
		tableDLS[26][1] = 67.2; //27 overs
		tableDLS[25][1] = 65.6; //26 overs
		tableDLS[24][1] = 63.9; //25 overs
		tableDLS[23][1] = 62.2; //24 overs
		tableDLS[22][1] = 60.4; //23 overs
		tableDLS[21][1] = 58.6; //22 overs
		tableDLS[20][1] = 56.7; //21 overs
		tableDLS[19][1] = 54.8; //20 overs
		tableDLS[18][1] = 52.8; //19 overs
		tableDLS[17][1] = 50.7; //18 overs
		tableDLS[16][1] = 48.5; //17 overs
		tableDLS[15][1] = 46.3; //16 overs
		tableDLS[14][1] = 44.1; //15 overs
		tableDLS[13][1] = 41.7; //14 overs
		tableDLS[12][1] = 39.3; //13 overs
		tableDLS[11][1] = 36.8; //12 overs
		tableDLS[10][1] = 34.2; //11 overs
		tableDLS[9][1] = 31.6; //10 overs
		tableDLS[8][1] = 28.9; //9 overs
		tableDLS[7][1] = 26.0; //8 overs
		tableDLS[6][1] = 23.1; //7 overs
		tableDLS[5][1] = 20.1; //6 overs
		tableDLS[4][1] = 17.0; //5 overs
		tableDLS[3][1] = 13.8; //4 overs
		tableDLS[2][1] = 10.5; //3 overs
		tableDLS[1][1] = 7.1; //2 overs
		tableDLS[0][1] = 3.6; //1 over
		
		//2 wickets lost
		tableDLS[49][2] = 85.1; //50 overs
		tableDLS[48][2] = 84.5; //49 overs
		tableDLS[47][2] = 83.8; //48 overs
		tableDLS[46][2] = 83.2; //47 overs
		tableDLS[45][2] = 82.5; //46 overs
		tableDLS[44][2] = 81.8; //45 overs
		tableDLS[43][2] = 81.0; //44 overs
		tableDLS[42][2] = 80.3; //43 overs
		tableDLS[41][2] = 79.5; //42 overs
		tableDLS[40][2] = 78.7; //41 overs
		tableDLS[39][2] = 77.8; //40 overs
		tableDLS[38][2] = 76.9; //39 overs
		tableDLS[37][2] = 76.0; //38 overs
		tableDLS[36][2] = 75.0; //37 overs
		tableDLS[35][2] = 74.1; //36 overs
		tableDLS[34][2] = 73.0; //35 overs
		tableDLS[33][2] = 72.0; //34 overs
		tableDLS[32][2] = 70.9; //33 overs
		tableDLS[31][2] = 69.7; //32 overs
		tableDLS[30][2] = 68.6; //31 overs
		tableDLS[29][2] = 67.3; //30 overs
		tableDLS[28][2] = 66.1; //29 overs
		tableDLS[27][2] = 64.8; //28 overs
		tableDLS[26][2] = 63.4; //27 overs
		tableDLS[25][2] = 62.0; //26 overs
		tableDLS[24][2] = 60.5; //25 overs
		tableDLS[23][2] = 59.0; //24 overs
		tableDLS[22][2] = 57.4; //23 overs
		tableDLS[21][2] = 55.8; //22 overs
		tableDLS[20][2] = 54.1; //21 overs
		tableDLS[19][2] = 52.4; //20 overs
		tableDLS[18][2] = 50.5; //19 overs
		tableDLS[17][2] = 48.6; //18 overs
		tableDLS[16][2] = 46.7; //17 overs
		tableDLS[15][2] = 44.7; //16 overs
		tableDLS[14][2] = 42.6; //15 overs
		tableDLS[13][2] = 40.4; //14 overs
		tableDLS[12][2] = 38.1; //13 overs
		tableDLS[11][2] = 35.8; //12 overs
		tableDLS[10][2] = 33.4; //11 overs
		tableDLS[9][2] = 30.8; //10 overs
		tableDLS[8][2] = 28.2; //9 overs
		tableDLS[7][2] = 25.5; //8 overs
		tableDLS[6][2] = 22.7; //7 overs
		tableDLS[5][2] = 19.8; //6 overs
		tableDLS[4][2] = 16.8; //5 overs
		tableDLS[3][2] = 13.7; //4 overs
		tableDLS[2][2] = 10.4; //3 overs
		tableDLS[1][2] = 7.1; //2 overs
		tableDLS[0][2] = 3.6; //1 over
		
		//3 wickets lost
		tableDLS[49][3] = 74.9; //50 overs
		tableDLS[48][3] = 74.4; //49 overs
		tableDLS[47][3] = 74.0; //48 overs
		tableDLS[46][3] = 73.5; //47 overs
		tableDLS[45][3] = 73.0; //46 overs
		tableDLS[44][3] = 72.5; //45 overs
		tableDLS[43][3] = 72.0; //44 overs
		tableDLS[42][3] = 71.4; //43 overs
		tableDLS[41][3] = 70.9; //42 overs
		tableDLS[40][3] = 70.3; //41 overs
		tableDLS[39][3] = 69.6; //40 overs
		tableDLS[38][3] = 69.0; //39 overs
		tableDLS[37][3] = 68.3; //38 overs
		tableDLS[36][3] = 67.6; //37 overs
		tableDLS[35][3] = 66.8; //36 overs
		tableDLS[34][3] = 66.0; //35 overs
		tableDLS[33][3] = 65.2; //34 overs
		tableDLS[32][3] = 64.4; //33 overs
		tableDLS[31][3] = 63.5; //32 overs
		tableDLS[30][3] = 62.5; //31 overs
		tableDLS[29][3] = 61.6; //30 overs
		tableDLS[28][3] = 60.5; //29 overs
		tableDLS[27][3] = 59.5; //28 overs
		tableDLS[26][3] = 58.4; //27 overs
		tableDLS[25][3] = 57.2; //26 overs
		tableDLS[24][3] = 56.0; //25 overs
		tableDLS[23][3] = 54.7; //24 overs
		tableDLS[22][3] = 53.4; //23 overs
		tableDLS[21][3] = 52.0; //22 overs
		tableDLS[20][3] = 50.6; //21 overs
		tableDLS[19][3] = 49.1; //20 overs
		tableDLS[18][3] = 47.5; //19 overs
		tableDLS[17][3] = 45.9; //18 overs
		tableDLS[16][3] = 44.1; //17 overs
		tableDLS[15][3] = 42.3; //16 overs
		tableDLS[14][3] = 40.5; //15 overs
		tableDLS[13][3] = 38.5; //14 overs
		tableDLS[12][3] = 36.5; //13 overs
		tableDLS[11][3] = 34.3; //12 overs
		tableDLS[10][3] = 32.1; //11 overs
		tableDLS[9][3] = 29.8; //10 overs
		tableDLS[8][3] = 27.4; //9 overs
		tableDLS[7][3] = 24.8; //8 overs
		tableDLS[6][3] = 22.2; //7 overs
		tableDLS[5][3] = 19.4; //6 overs
		tableDLS[4][3] = 16.5; //5 overs
		tableDLS[3][3] = 13.5; //4 overs
		tableDLS[2][3] = 10.3; //3 overs
		tableDLS[1][3] = 7.0; //2 overs
		tableDLS[0][3] = 3.6; //1 over
			
		
		//4 wickets lost
		tableDLS[49][4] = 62.7; //50 overs
		tableDLS[48][4] = 62.5; //49 overs
		tableDLS[47][4] = 62.2; //48 overs
		tableDLS[46][4] = 61.9; //47 overs
		tableDLS[45][4] = 61.6; //46 overs
		tableDLS[44][4] = 61.3; //45 overs
		tableDLS[43][4] = 61.0; //44 overs
		tableDLS[42][4] = 60.7; //43 overs
		tableDLS[41][4] = 60.3; //42 overs
		tableDLS[40][4] = 59.9; //41 overs
		tableDLS[39][4] = 59.5; //40 overs
		tableDLS[38][4] = 59.1; //39 overs
		tableDLS[37][4] = 58.7; //38 overs
		tableDLS[36][4] = 58.2; //37 overs
		tableDLS[35][4] = 57.7; //36 overs
		tableDLS[34][4] = 57.2; //35 overs
		tableDLS[33][4] = 56.6; //34 overs
		tableDLS[32][4] = 56.0; //33 overs
		tableDLS[31][4] = 55.4; //32 overs
		tableDLS[30][4] = 54.8; //31 overs
		tableDLS[29][4] = 54.1; //30 overs
		tableDLS[28][4] = 53.4; //29 overs
		tableDLS[27][4] = 52.6; //28 overs
		tableDLS[26][4] = 51.8; //27 overs
		tableDLS[25][4] = 50.9; //26 overs
		tableDLS[24][4] = 50.0; //25 overs
		tableDLS[23][4] = 49.0; //24 overs
		tableDLS[22][4] = 48.0; //23 overs
		tableDLS[21][4] = 47.0; //22 overs
		tableDLS[20][4] = 45.8; //21 overs
		tableDLS[19][4] = 44.6; //20 overs
		tableDLS[18][4] = 43.4; //19 overs
		tableDLS[17][4] = 42.0; //18 overs
		tableDLS[16][4] = 40.6; //17 overs
		tableDLS[15][4] = 39.1; //16 overs
		tableDLS[14][4] = 37.6; //15 overs
		tableDLS[13][4] = 35.9; //14 overs
		tableDLS[12][4] = 34.2; //13 overs
		tableDLS[11][4] = 32.3; //12 overs
		tableDLS[10][4] = 30.4; //11 overs
		tableDLS[9][4] = 28.3; //10 overs
		tableDLS[8][4] = 26.1; //9 overs
		tableDLS[7][4] = 23.8; //8 overs
		tableDLS[6][4] = 21.4; //7 overs
		tableDLS[5][4] = 18.8; //6 overs
		tableDLS[4][4] = 16.1; //5 overs
		tableDLS[3][4] = 13.2; //4 overs
		tableDLS[2][4] = 10.2; //3 overs
		tableDLS[1][4] = 7.0; //2 overs
		tableDLS[0][4] = 3.6; //1 over
		
		//5 wickets lost
		tableDLS[49][5] = 49.0; //50 overs
		tableDLS[48][5] = 48.9; //49 overs
		tableDLS[47][5] = 48.8; //48 overs
		tableDLS[46][5] = 48.6; //47 overs
		tableDLS[45][5] = 48.5; //46 overs
		tableDLS[44][5] = 48.4; //45 overs
		tableDLS[43][5] = 48.3; //44 overs
		tableDLS[42][5] = 48.1; //43 overs
		tableDLS[41][5] = 47.9; //42 overs
		tableDLS[40][5] = 47.8; //41 overs
		tableDLS[39][5] = 47.6; //40 overs
		tableDLS[38][5] = 47.4; //39 overs
		tableDLS[37][5] = 47.1; //38 overs
		tableDLS[36][5] = 46.9; //37 overs
		tableDLS[35][5] = 46.6; //36 overs
		tableDLS[34][5] = 46.4; //35 overs
		tableDLS[33][5] = 46.1; //34 overs
		tableDLS[32][5] = 45.8; //33 overs
		tableDLS[31][5] = 45.4; //32 overs
		tableDLS[30][5] = 45.1; //31 overs
		tableDLS[29][5] = 44.7; //30 overs
		tableDLS[28][5] = 44.2; //29 overs
		tableDLS[27][5] = 43.8; //28 overs
		tableDLS[26][5] = 43.3; //27 overs
		tableDLS[25][5] = 42.8; //26 overs
		tableDLS[24][5] = 42.2; //25 overs
		tableDLS[23][5] = 41.6; //24 overs
		tableDLS[22][5] = 40.9; //23 overs
		tableDLS[21][5] = 40.2; //22 overs
		tableDLS[20][5] = 39.4; //21 overs
		tableDLS[19][5] = 38.6; //20 overs
		tableDLS[18][5] = 37.7; //19 overs
		tableDLS[17][5] = 36.8; //18 overs
		tableDLS[16][5] = 35.8; //17 overs
		tableDLS[15][5] = 34.7; //16 overs
		tableDLS[14][5] = 33.5; //15 overs
		tableDLS[13][5] = 32.2; //14 overs
		tableDLS[12][5] = 30.8; //13 overs
		tableDLS[11][5] = 29.4; //12 overs
		tableDLS[10][5] = 27.8; //11 overs
		tableDLS[9][5] = 26.1; //10 overs
		tableDLS[8][5] = 24.2; //9 overs
		tableDLS[7][5] = 22.3; //8 overs
		tableDLS[6][5] = 20.1; //7 overs
		tableDLS[5][5] = 17.8; //6 overs
		tableDLS[4][5] = 15.4; //5 overs
		tableDLS[3][5] = 12.7; //4 overs
		tableDLS[2][5] = 9.9; //3 overs
		tableDLS[1][5] = 6.8; //2 overs
		tableDLS[0][5] = 3.5; //1 over
		
		//6 wickets lost
		tableDLS[49][6] = 34.9; //50 overs
		tableDLS[48][6] = 34.9; //49 overs
		tableDLS[47][6]= 34.9; //48 overs
		tableDLS[46][6] = 34.9; //47 overs
		tableDLS[45][6] = 34.8; //46 overs
		tableDLS[44][6] = 34.8; //45 overs
		tableDLS[43][6] = 34.8; //44 overs
		tableDLS[42][6] = 34.7; //43 overs
		tableDLS[41][6] = 34.7; //42 overs
		tableDLS[40][6] = 34.6; //41 overs
		tableDLS[39][6] = 34.6; //40 overs
		tableDLS[38][6] = 34.5; //39 overs
		tableDLS[37][6] = 34.5; //38 overs
		tableDLS[36][6] = 34.4; //37 overs
		tableDLS[35][6] = 34.3; //36 overs
		tableDLS[34][6] = 34.2; //35 overs
		tableDLS[33][6] = 34.1; //34 overs
		tableDLS[32][6] = 34.0; //33 overs
		tableDLS[31][6] = 33.9; //32 overs
		tableDLS[30][6] = 33.7; //31 overs
		tableDLS[29][6] = 33.6; //30 overs
		tableDLS[28][6] = 33.4; //29 overs
		tableDLS[27][6] = 33.2; //28 overs
		tableDLS[26][6] = 33.0; //27 overs
		tableDLS[25][6] = 32.8; //26 overs
		tableDLS[24][6] = 32.6; //25 overs
		tableDLS[23][6] = 32.3; //24 overs
		tableDLS[22][6] = 32.0; //23 overs
		tableDLS[21][6] = 31.6; //22 overs
		tableDLS[20][6] = 31.2; //21 overs
		tableDLS[19][6] = 30.8; //20 overs
		tableDLS[18][6] = 30.3; //19 overs
		tableDLS[17][6] = 29.8; //18 overs
		tableDLS[16][6] = 29.2; //17 overs
		tableDLS[15][6] = 28.5; //16 overs
		tableDLS[14][6] = 27.8; //15 overs
		tableDLS[13][6] = 27.0; //14 overs
		tableDLS[12][6] = 26.1; //13 overs
		tableDLS[11][6] = 25.1; //12 overs
		tableDLS[10][6] = 24.0; //11 overs
		tableDLS[9][6] = 22.8; //10 overs
		tableDLS[8][6] = 21.4; //9 overs
		tableDLS[7][5] = 19.9; //8 overs
		tableDLS[6][6] = 18.2; //7 overs
		tableDLS[5][6] = 16.4; //6 overs
		tableDLS[4][6] = 14.3; //5 overs
		tableDLS[3][6] = 12.0; //4 overs
		tableDLS[2][6] = 9.5; //3 overs
		tableDLS[1][6] = 6.6; //2 overs
		tableDLS[0][6] = 3.5; //1 over
		
		//7 wickets lost
		tableDLS[49][7] = 22.0; //50 overs
		tableDLS[48][7] = 22.0; //49 overs
		tableDLS[47][7] = 22.0; //48 overs
		tableDLS[46][7] = 22.0; //47 overs
		tableDLS[45][7] = 22.0; //46 overs
		tableDLS[44][7] = 22.0; //45 overs
		tableDLS[43][7] = 22.0; //44 overs
		tableDLS[42][7] = 22.0; //43 overs
		tableDLS[41][7] = 22.0; //42 overs
		tableDLS[40][7] = 22.0; //41 overs
		tableDLS[39][7] = 22.0; //40 overs
		tableDLS[38][7] = 22.0; // 39 overs
		tableDLS[37][7] = 21.9; //38 overs
		tableDLS[36][7] = 21.9; //37 overs
		tableDLS[35][7] = 21.9; //36 overs
		tableDLS[34][7] = 21.9; //35 overs
		tableDLS[33][7] = 21.9; //34 overs
		tableDLS[32][7] = 21.9; //33 overs
		tableDLS[31][7] = 21.9; //32 overs
		tableDLS[30][7] = 21.9; //31 overs
		tableDLS[29][7] = 21.8; //30 overs
		tableDLS[28][7] = 21.8; //29 overs
		tableDLS[27][7] = 21.8; //28 overs
		tableDLS[26][7] = 21.7; //27 overs
		tableDLS[25][7] = 21.7; //26 overs
		tableDLS[24][7] = 21.6; //25 overs
		tableDLS[23][7] = 21.6; //24 overs
		tableDLS[22][7] = 21.5; //23 overs
		tableDLS[21][7] = 21.4; //22 overs
		tableDLS[20][7] = 21.3; //21 overs
		tableDLS[19][7] = 21.2; //20 overs
		tableDLS[18][7] = 21.1; //19 overs
		tableDLS[17][7] = 20.9; //18 overs
		tableDLS[16][7] = 20.7; //17 overs
		tableDLS[15][7] = 20.5; //16 overs
		tableDLS[14][7] = 20.2; //15 overs
		tableDLS[13][7] = 19.9; //14 overs
		tableDLS[12][7] = 19.5; //13 overs
		tableDLS[11][7] = 19.0; //12 overs
		tableDLS[10][7] = 18.5; //11 overs
		tableDLS[9][7] = 17.9; //10 overs
		tableDLS[8][7] = 17.1; //9 overs
		tableDLS[7][7] = 16.2; //8 overs
		tableDLS[6][7] = 15.2; //7 overs
		tableDLS[5][7] = 13.9; //6 overs
		tableDLS[4][7] = 12.5; //5 overs
		tableDLS[3][7] = 10.7; //4 overs
		tableDLS[2][7] = 8.7; //3 overs
		tableDLS[1][7] = 6.2; //2 overs
		tableDLS[0][7] = 3.4; //1 over
		
		//8 wickets lost
		tableDLS[49][8] = 11.9; //50 overs
		tableDLS[48][8] = 11.9; //49 overs
		tableDLS[47][8] = 11.9; //48 overs
		tableDLS[46][8] = 11.9; //47 overs
		tableDLS[45][8] = 11.9; //46 overs
		tableDLS[44][8] = 11.9; //45 overs
		tableDLS[43][8] = 11.9; //44 overs
		tableDLS[42][8] = 11.9; //43 overs
		tableDLS[41][8] = 11.9; //42 overs
		tableDLS[40][8] = 11.9; //41 overs
		tableDLS[39][8] = 11.9; //40 overs
		tableDLS[38][8] = 11.9; //39 overs
		tableDLS[37][8] = 11.9; //38 overs
		tableDLS[36][8] = 11.9; //37 overs
		tableDLS[35][8] = 11.9; //36 overs
		tableDLS[34][8] = 11.9; //35 overs
		tableDLS[33][8] = 11.9; //34 overs
		tableDLS[32][8] = 11.9; //33 overs
		tableDLS[31][8] = 11.9; //32 overs
		tableDLS[30][8] = 11.9; //31 overs
		tableDLS[29][8] = 11.9; //30 overs
		tableDLS[28][8] = 11.9; //29 overs
		tableDLS[27][8] = 11.9; //28 overs
		tableDLS[26][8] = 11.9; //27 overs
		tableDLS[25][8] = 11.9; //26 overs
		tableDLS[24][8] = 11.9; //25 overs
		tableDLS[23][8] = 11.9; //24 overs
		tableDLS[22][8] = 11.9; //23 overs
		tableDLS[21][8] = 11.9; //22 overs
		tableDLS[20][8] = 11.9; //21 overs
		tableDLS[19][8] = 11.9; //20 overs
		tableDLS[18][8] = 11.9; //19 overs
		tableDLS[17][8] = 11.9; //18 overs
		tableDLS[16][8] = 11.9; //17 overs
		tableDLS[15][8] = 11.8; //16 overs
		tableDLS[14][8] = 11.8; //15 overs
		tableDLS[13][8] = 11.8; //14 overs
		tableDLS[12][8] = 11.7; //13 overs
		tableDLS[11][8] = 11.6; //12 overs
		tableDLS[10][8] = 11.5; //11 overs
		tableDLS[9][8] = 11.4; //10 overs
		tableDLS[8][8] = 11.2; //9 overs
		tableDLS[7][8] = 10.9; //8 overs
		tableDLS[6][8] = 10.5; //7 overs
		tableDLS[5][8] = 10.1; //6 overs
		tableDLS[4][8] = 9.4; //5 overs
		tableDLS[3][8] = 8.4; //4 overs
		tableDLS[2][8] = 7.2; //3 overs
		tableDLS[1][8] = 5.5; //2 overs
		tableDLS[0][8] = 3.2; //1 over
		
		//9 wickets lost
		tableDLS[49][9] = 4.7; //50 overs
		tableDLS[48][9] = 4.7; //49 overs
		tableDLS[47][9] = 4.7; //48 overs
		tableDLS[46][9] = 4.7; //47 overs
		tableDLS[45][9] = 4.7; //46 overs
		tableDLS[44][9] = 4.7; //45 overs
		tableDLS[43][9] = 4.7; //44 overs
		tableDLS[42][9] = 4.7; //43 overs
		tableDLS[41][9] = 4.7; //42 overs
		tableDLS[40][9] = 4.7; //41 overs
		tableDLS[39][9] = 4.7; //40 overs
		tableDLS[38][9] = 4.7; //39 overs
		tableDLS[37][9] = 4.7; //38 overs
		tableDLS[36][9] = 4.7; //37 overs
		tableDLS[35][9] = 4.7; //36 overs
		tableDLS[34][9] = 4.7; //35 overs
		tableDLS[33][9] = 4.7; //34 overs
		tableDLS[32][9] = 4.7; //33 overs
		tableDLS[31][9] = 4.7; //32 overs
		tableDLS[30][9] = 4.7; //31 overs
		tableDLS[29][9] = 4.7; //30 overs
		tableDLS[28][9] = 4.7; //29 overs
		tableDLS[27][9] = 4.7; //28 overs
		tableDLS[26][9] = 4.7; //27 overs
		tableDLS[25][9] = 4.7; //26 overs
		tableDLS[24][9] = 4.7; //25 overs
		tableDLS[23][9] = 4.7; //24 overs
		tableDLS[22][9] = 4.7; //23 overs
		tableDLS[21][9] = 4.7; //22 overs
		tableDLS[20][9] = 4.7; //21 overs
		tableDLS[19][9] = 4.7; //20 overs
		tableDLS[18][9] = 4.7; //19 overs
		tableDLS[17][9] = 4.7; //18 overs
		tableDLS[16][9] = 4.7; //17 overs
		tableDLS[15][9] = 4.7; //16 overs
		tableDLS[14][9] = 4.7; //15 overs
		tableDLS[13][9] = 4.7; //14 overs
		tableDLS[12][9] = 4.7; //13 overs
		tableDLS[11][9] = 4.7; //12 overs
		tableDLS[10][9] = 4.7; //11 overs
		tableDLS[9][9] = 4.7; //10 overs
		tableDLS[8][9] = 4.7; //9 overs
		tableDLS[7][9] = 4.7; //8 overs
		tableDLS[6][9] = 4.7; //7 overs
		tableDLS[5][9] = 4.6; //6 overs
		tableDLS[4][9] = 4.6; //5 overs
		tableDLS[3][9] = 4.5; //4 overs
		tableDLS[2][9] = 4.2; //3 overs
		tableDLS[1][9] = 3.7; //2 overs
		tableDLS[0][9] = 2.5; //1 over
		
		if ((oversLeft == 0) || (wicketsLost == 10)) {
			return 0.0;
		}
		else return tableDLS[oversLeft-1][wicketsLost];
	}
	public static void case1() {
		//Team 1 has an interruption in their innings
		System.out.println("Case 1 it is! There is a lot we got to do here");
		Scanner input = new Scanner (System.in);
		System.out.println("Firstly, the details!");
		System.out.println("Overs available to Team 1:");
		int oversAvail1 = input.nextInt(); //The overs available to Team 1 at the start of the play
		System.out.println("Overs remaining at the time of interruption for Team 1:");
		int oversRemainAt1 = input.nextInt(); //Overs remaining at the time of interruption for Team 1
		System.out.println("Wickets lost so far for Team 1:");
		int wktLost1 = input.nextInt(); //The number of wickets fallen for Team 1
		System.out.println("Overs remaining after interruption for Team 1:");
		int oversRemainAfter1 = input.nextInt(); //The overs remaining after the interruption for Team 1
		System.out.println("Runs scored by Team 1:");
		int runsScored = input.nextInt(); //The runs scored so far by Team 1
		System.out.println("Overs available to Team 2:");
		int oversAvail2 = input.nextInt(); //The overs available to Team 2
		
		double team1DLSBefore = percentageDLS(oversRemainAt1, wktLost1); //Getting the DLS percentage of Team 1 before interruption
		double team1DLSAfter = percentageDLS(oversRemainAfter1, wktLost1); //Getting the DLS percentage of Team 1 after interruption
		double team1DLS = percentageDLS(oversAvail1, 0) - (team1DLSBefore - team1DLSAfter); //Getting the DLS percentage of Team 1
		double team2DLS = percentageDLS(oversAvail2, 0); //Getting the DLS percentage of Team 2
		
		System.out.println("What is the average expected score?");
		int genScore = input.nextInt(); //The average expected score
		
		int parScoreForTeam2 = 0; //initializing the par score for Team 2
		if (team2DLS < team1DLS) { //team 2 resources less than team 1
			parScoreForTeam2 = (int) (Math.ceil(runsScored * (team2DLS/team1DLS)));
		}
		else if (team2DLS > team1DLS) { //team 2 resources more than team 1
			parScoreForTeam2 = (int) (Math.ceil(runsScored + (genScore * ((team2DLS - team1DLS)/100))));
		}
		else if (team2DLS == team1DLS) { //same
			parScoreForTeam2 = runsScored + 1;
		}
		System.out.println("The par score for Team 2 using DLS is: " + parScoreForTeam2); //Output
		input.close();
	}
	
	public static void case2() {
		//Team 1 has their innings cut short
		System.out.println("Case 2 it is! There is a lot we got to do here!");
		Scanner input = new Scanner (System.in);
		System.out.println("Firstly, the details!");
		System.out.println("Overs available to Team 1:");
		int oversAvail1 = input.nextInt(); //The overs available to Team 1
		System.out.println("Wickets lost so far for Team 1:");
		int wktLost = input.nextInt(); //The number of wickets fallen for Team 1
		System.out.println("Runs scored by Team 1:");
		int runsScored = input.nextInt(); //The runs scored by Team 1
		System.out.println("Overs available to Team 2:");
		int oversAvail2 = input.nextInt(); //The overs available to Team 2
		if (oversAvail2 < oversAvail1) {
			System.out.println("INVALID!");
		}
		System.out.println("What is the average expected score?");
		int genScore = input.nextInt(); //Average expected score

		
		//DLS calculations for each team.
		double team1DLS = percentageDLS(oversAvail1, wktLost); //Team 1 resources
		double team2DLS = percentageDLS(oversAvail2, 0); //Team 2 resources
				
		int parScoreForTeam2 = 0; //initializing the par score for Team 2
		if (team2DLS < team1DLS) { //team 2 resources less than team 1
			parScoreForTeam2 = (int) (Math.ceil(runsScored * (team2DLS/team1DLS)));
		}
		else if (team2DLS > team1DLS) { //team 2 resources more than team 1
			parScoreForTeam2 = (int) (Math.ceil(runsScored + (genScore * ((team2DLS - team1DLS)/100))));
		}
		else if (team2DLS == team1DLS) { //same
			parScoreForTeam2 = runsScored + 1;
		}
		System.out.println("The par score for Team 2 using DLS is: " + parScoreForTeam2); //Output
		input.close();
		
	
	}
	
	public static void case3() {
		//Team 2 has their innings interrupted
		System.out.println("Case 3 it is! Lots to do here.");
		Scanner input = new Scanner (System.in);
		System.out.println("Firstly, the details");
		System.out.println("Overs available to Team 1:"); 
		int oversAvail1 = input.nextInt(); //Overs available for Team 1
		System.out.println("Runs scored by Team 1:");
		int runsScored = input.nextInt(); //Runs scored by Team 1
		System.out.println("Overs available to Team 2:");
		int oversAvail2 = input.nextInt(); //Overs available for Team 2
		System.out.println("Overs remaining at interruption for Team 2:");
		int oversRemainAt2 = input.nextInt(); //Overs remaining at time of interruption for Team 2
		System.out.println("Wickets lost so far for Team 2:");
		int wktLost = input.nextInt(); //Wickets lost for Team 2
		System.out.println("Overs remaining after interruption for Team 2:");
		int oversRemainAfter2 = input.nextInt(); //Overs remaining after interruption for Team 2
		
		double atInterrupt = percentageDLS(oversRemainAt2, wktLost); //resources at interruption
		double afterInterrupt = percentageDLS(oversRemainAfter2, wktLost); //resources after interruption
		
		double team1DLS = percentageDLS(oversAvail1, 0); //resources of Team 1
		double team2DLS = percentageDLS(oversAvail2, 0) - (atInterrupt - afterInterrupt); //resources of Team 2
		
		int parScoreForTeam2 = 0; //initializing the par score for Team 2
		if (team2DLS < team1DLS) {
			parScoreForTeam2 = (int) (Math.ceil(runsScored * (team2DLS/team1DLS)));
		}
		else if (team2DLS > team1DLS) {
			parScoreForTeam2 = (int) (Math.ceil(runsScored * ((team2DLS - team1DLS)/100)));
		}
		else if (team2DLS == team1DLS) {
			parScoreForTeam2 = runsScored + 1;
		}
		System.out.println("The par score for Team 2 using DLS is: " + parScoreForTeam2); //Output
		input.close();
	}
	
	public static void case4() {
		//Team 2 has their innings cut short
		System.out.println("Case 4. Here we go!");
		Scanner input = new Scanner (System.in);
		System.out.println("First things first, details!");
		System.out.println("Overs available to Team 1:");
		int oversAvail1 = input.nextInt(); //Overs available for Team 1
		System.out.println("Runs scored by Team 1:");
		int runsScored = input.nextInt(); //Runs scored by Team 1
		System.out.println("Overs available (to start with) for Team 2:");
		int oversAvail2 = input.nextInt(); //Overs available for Team 2
		System.out.println("Wickets lost for Team 2:");
		int wktLost = input.nextInt(); //Wickets lost for Team 2 2
		System.out.println("Overs left for Team 2 at time of abandonment:"); //Overs that didn't get used
		int oversLeft2 = input.nextInt();
		double team1DLS = percentageDLS(oversAvail1, 0); //resources of Team 1
		double team2DLS = percentageDLS(oversAvail2, 0) - percentageDLS(oversLeft2, wktLost); //resources of Team 2
		
		int parScoreForTeam2 = 0; //initializing the par score for Team 2
		if (team2DLS < team1DLS) { //team 2 resources less than team 1
			parScoreForTeam2 = (int) (Math.ceil(runsScored * (team2DLS/team1DLS)));
		}
		else if (team2DLS > team1DLS) { //team 2 resources more than team  1
			parScoreForTeam2 = (int) (Math.ceil(runsScored * ((team2DLS - team1DLS)/100)));
		}
		else if (team2DLS == team1DLS) { //same
			parScoreForTeam2 = runsScored + 1;
		}
		System.out.println("The par score for Team 2 using DLS is: " + parScoreForTeam2); //Output
		input.close();
	}
	
	public static void case5() {
		//Team 2 has their innings delayed
		System.out.println("Case 5. Here we go!");
		Scanner input = new Scanner (System.in);
		System.out.println("Details first!");
		System.out.println("Overs available to Team 1:");
		int oversAvail1 = input.nextInt(); //overs available to Team 1
		System.out.println("Runs scored by Team 1:");
		int runsScored = input.nextInt(); //runs scored by Team 1
		System.out.println("Overs available to Team 2:");
		int oversAvail2 = input.nextInt(); //overs available to Team 2
		
		double team1DLS = percentageDLS(oversAvail1, 0); //resources of Team 1
		double team2DLS = percentageDLS(oversAvail2, 0); //resources of Team 2
		
		int parScoreForTeam2 = 0; //initializing the par score for Team 2
		if (team2DLS < team1DLS) { //team 2 has less resources than team 1
			parScoreForTeam2 = (int) (Math.ceil(runsScored * (team2DLS/team1DLS)));
		}
		else if (team2DLS > team1DLS) { //team 2 has more resources than team 1
			parScoreForTeam2 = (int) (Math.ceil(runsScored * ((team2DLS - team1DLS)/100)));
		}
		else if (team2DLS == team1DLS) { //same
			parScoreForTeam2 = runsScored + 1;
		}
		System.out.println("The par score for Team 2 using DLS is: " + parScoreForTeam2); //Output
		input.close();
	}
	
	

	
	
}
