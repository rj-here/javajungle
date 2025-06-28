package projects2025;
import java.util.*;
/*
  I've taken the details from these pages:
  Men:
  https://en.wikipedia.org/wiki/Men%27s_T20_World_Cup
  https://en.wikipedia.org/wiki/2007_World_Twenty20
  https://en.wikipedia.org/wiki/2009_World_Twenty20
  https://en.wikipedia.org/wiki/2010_World_Twenty20
  https://en.wikipedia.org/wiki/2012_World_Twenty20
  https://en.wikipedia.org/wiki/2014_World_Twenty20
  https://en.wikipedia.org/wiki/2016_World_Twenty20
  https://en.wikipedia.org/wiki/2021_Men%27s_T20_World_Cup
  https://en.wikipedia.org/wiki/2022_Men%27s_T20_World_Cup
  https://en.wikipedia.org/wiki/2024_Men%27s_T20_World_Cup
  Women:
  https://en.wikipedia.org/wiki/Women%27s_T20_World_Cup
  https://en.wikipedia.org/wiki/2009_Women%27s_World_Twenty20
  https://en.wikipedia.org/wiki/2010_Women%27s_World_Twenty20
  https://en.wikipedia.org/wiki/2012_Women%27s_World_Twenty20
  https://en.wikipedia.org/wiki/2014_Women%27s_World_Twenty20
  https://en.wikipedia.org/wiki/2016_Women%27s_World_Twenty20
  https://en.wikipedia.org/wiki/2018_Women%27s_World_Twenty20
  https://en.wikipedia.org/wiki/2020_Women%27s_T20_World_Cup
  https://en.wikipedia.org/wiki/2023_Women%27s_T20_World_Cup
  https://en.wikipedia.org/wiki/2024_Women%27s_T20_World_Cup
 */

public class T20WCQuiz {

	public static void main(String[] args) {
		System.out.println("Welcome!");
		//The HashMaps of many answers, attached to certain years.
		HashMap<Integer, String> menHosts = new HashMap<Integer, String>();
		menHosts = loadMenHosts(menHosts);
		HashMap<Integer, String> womenHosts = new HashMap<Integer, String>();
		womenHosts = loadWomenHosts(womenHosts);
		HashMap<Integer, String> menWinners = new HashMap<Integer, String>();
		menWinners = loadMenWinners(menWinners);
		HashMap<Integer, String> womenWinners = new HashMap<Integer, String>();
		womenWinners = loadWomenWinners(womenWinners);
		HashMap<Integer, String> menPOTT = new HashMap<Integer, String>();
		menPOTT = loadMenPOTT(menPOTT);
		HashMap<Integer, String> womenPOTT = new HashMap<Integer, String>();
		womenPOTT = loadWomenPOTT(womenPOTT);
		HashMap<Integer, String> menPOTF = new HashMap<Integer, String>();
		menPOTF = loadMenPOTT(menPOTF);
		HashMap<Integer, String> womenPOTF = new HashMap<Integer, String>();
		womenPOTF = loadWomenPOTT(womenPOTF);
		//Other variables defined
		int men = menHosts.size();
		int women = womenHosts.size();
		
		int gender = randomz(2);
		int menRandom = randomz(men);
		int womenRandom = randomz(women);
		int questionCategory = randomz(4);
		if (gender == 0) {
			quiz(menRandom, questionCategory, menHosts, menWinners, menPOTT, menPOTF, "Men");
		}
		else {
			quiz(womenRandom, questionCategory, womenHosts, womenWinners, womenPOTT, womenPOTF, "Women");
		}
		
		
	}
	public static int randomz(int num) {
		int random = (int) (Math.random()*num);
		return random;
	}
	
	public static HashMap<Integer, String> loadMenHosts(HashMap<Integer, String> menHosts) {
		menHosts.put(2007, "South Africa");
		menHosts.put(2009, "England");
		menHosts.put(2010, "West Indies");
		menHosts.put(2012, "Sri Lanka");
		menHosts.put(2014, "Bangladesh");
		menHosts.put(2016, "India");
		menHosts.put(2021, "UAE & Oman");
		menHosts.put(2022, "Australia");
		menHosts.put(2024, "West Indies & USA");
		return menHosts;
	}
	
	public static HashMap<Integer, String> loadWomenHosts(HashMap<Integer, String> womenHosts) {
		womenHosts.put(2009, "England");
		womenHosts.put(2010, "West Indies");
		womenHosts.put(2012, "Sri Lanka");
		womenHosts.put(2014, "Bangladesh");
		womenHosts.put(2016, "India");
		womenHosts.put(2018, "West Indies");
		womenHosts.put(2020, "Australia");
		womenHosts.put(2023, "South Africa");
		womenHosts.put(2024, "UAE");
		return womenHosts;
	}
	
	public static HashMap<Integer, String> loadMenWinners(HashMap<Integer, String> menWinners) {
		menWinners.put(2007, "India");
		menWinners.put(2009, "Pakistan");
		menWinners.put(2010, "England");
		menWinners.put(2012, "West Indies");
		menWinners.put(2014, "Sri Lanka");
		menWinners.put(2016, "West Indies");
		menWinners.put(2021, "Australia");
		menWinners.put(2022, "England");
		menWinners.put(2024, "India");
		return menWinners;
	}

	public static HashMap<Integer, String> loadWomenWinners(HashMap<Integer, String> womenWinners) {
		womenWinners.put(2009, "England");
		womenWinners.put(2010, "Australia");
		womenWinners.put(2012, "Australia");
		womenWinners.put(2014, "Australia");
		womenWinners.put(2016, "West Indies");
		womenWinners.put(2018, "Australia");
		womenWinners.put(2020, "Australia");
		womenWinners.put(2023, "Australia");
		womenWinners.put(2024, "New Zealand");
		return womenWinners;
	}
	
	public static HashMap<Integer, String> loadMenPOTT(HashMap<Integer, String> menPOTT) {
		menPOTT.put(2007, "Shahid Afridi");
		menPOTT.put(2009, "Tillakaratne Dilshan");
		menPOTT.put(2010, "Kevin Pietersen");
		menPOTT.put(2012, "Shane Watson");
		menPOTT.put(2014, "Virat Kohli");
		menPOTT.put(2016, "Virat Kohli");
		menPOTT.put(2021, "David Warner");
		menPOTT.put(2022, "Sam Curran");
		menPOTT.put(2024, "Jasprit Bumrah");
		return menPOTT;
	}
	
	public static HashMap<Integer, String> loadWomenPOTT(HashMap<Integer, String> womenPOTT) {
		womenPOTT.put(2009, "Claire Taylor");
		womenPOTT.put(2010, "Nicola Browne");
		womenPOTT.put(2012, "Charlotte Edwards");
		womenPOTT.put(2014, "Anya Shrubsole");
		womenPOTT.put(2016, "Stafanie Taylor");
		womenPOTT.put(2018, "Alyssa Healy");
		womenPOTT.put(2020, "Beth Mooney");
		womenPOTT.put(2023, "Ashleigh Gardner");
		womenPOTT.put(2024, "Amelia Kerr");
		return womenPOTT;
	}
	
	public static HashMap<Integer, String> loadMenPOTF(HashMap<Integer, String> menPOTF) {
		menPOTF.put(2007, "Irfan Pathan");
		menPOTF.put(2009, "Shahid Afridi");
		menPOTF.put(2010, "Craig Kieswetter");
		menPOTF.put(2012, "Marlon Samuels");
		menPOTF.put(2014, "Kumar Sangakkara");
		menPOTF.put(2016, "Marlon Samuels");
		menPOTF.put(2021, "Mitchell Marsh");
		menPOTF.put(2022, "Sam Curran");
		menPOTF.put(2024, "Virat Kohli");
		return menPOTF;
	}
	
	public static HashMap<Integer, String> loadWomenPOTF(HashMap<Integer, String> womenPOTF) {
		womenPOTF.put(2009, "Katherine Sciver-Brunt");
		womenPOTF.put(2010, "Ellyse Perry");
		womenPOTF.put(2012, "Jess Cameron");
		womenPOTF.put(2014, "Sarah Coyte");
		womenPOTF.put(2016, "Hayley Matthews");
		womenPOTF.put(2018, "Ashleign Gardner");
		womenPOTF.put(2020, "Alyssa Healy");
		womenPOTF.put(2023, "Beth Mooney");
		womenPOTF.put(2024, "Amelia Kerr");
		return womenPOTF;
	}
	
	public static void quiz(int randomE, int randomQ, HashMap<Integer, String> hosts, HashMap<Integer, String> winners, HashMap<Integer, String> pOTT, HashMap<Integer, String> pOTF, String gender) {
		Scanner input = new Scanner (System.in);
		if (randomQ==0) {
			System.out.println("Who was the host of the " + gender + "'s T20 World Cup in " + randomE);
			String host = input.next();
			if (host.equals(hosts.get(randomE))) {
				System.out.println("Great job!");
			}
			else {
				System.out.println("Uh oh...it actually was: " + hosts.get(randomE));
			}
		}
		else if (randomQ==1) {
			System.out.println("Who was the winner of the " + gender + "'s T20 World Cup in " + randomE);
			String winner = input.next();
			if (winner.equals(winners.get(randomE))) {
				System.out.println("Great job!");
			}
			else {
				System.out.println("Uh oh...it actually was: " + winners.get(randomE));
			}
		}
		else if (randomQ==2) {
			System.out.println("Who was the player of the tournament of the " + gender + "'s T20 World Cup in " + randomE);
			String playerOfTheTournament = input.next();
			if (playerOfTheTournament.equals(pOTT.get(randomE))) {
				System.out.println("Great job!");
			}
			else {
				System.out.println("Uh oh...it actually was: " + pOTT.get(randomE));
			}
		}
		else if (randomQ==3) {
			System.out.println("Who was the player of the final of the " + gender + "'s T20 World Cup in " + randomE);
			String playerOfTheFinal = input.next();
			if (playerOfTheFinal.equals(pOTF.get(randomE))) {
				System.out.println("Great job!");
			}
			else {
				System.out.println("Uh oh...it actually was: " + pOTF.get(randomE));
			}
		}
		
	}
	
	

}
