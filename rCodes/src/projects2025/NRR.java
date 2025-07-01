package projects2025;
import java.util.*;
/*
 * Where I actually had first cracked how to calculate net run rate!
 * Source: https://www.espncricinfo.com/ci/content/page/429305.html
 */
public class NRR {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		//For
		System.out.println("Input the runs scored for.");
		int runsScoredFor = input.nextInt();
		System.out.println("Input the overs for. If it is something like 47.2, then put 47, the next prompt handles partial overs.");
		int oversFor = input.nextInt();
		System.out.println("Input how many deliveries in a partial over for."); //for 47.2 over-like cases!
		int extras = input.nextInt();
		//Against
		System.out.println("Input the runs scored against.");
		int runsScoredAgainst = input.nextInt();
		System.out.println("Input the overs against (to be calculated on basis of full allotments so not taking partials).");
		int oversAgainst = input.nextInt();
		
		double oversForTotal = (oversFor*6 + extras)/6;
		double forRR = runsScoredFor/oversForTotal;
		System.out.println("The run rate for: " + forRR);
		double againstRR = 1.0 * runsScoredAgainst/oversAgainst;
		System.out.println("The run rate against: " + againstRR);
		double netRunRate = (forRR - againstRR);
		System.out.println(netRunRate);
		input.close();
		}

}