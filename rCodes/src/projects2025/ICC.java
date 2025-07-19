package projects2025;
import java.util.*;
public class ICC {
/*
 * © 2025 Rishi
 * Last updated: 13th July, 2025
 An all-tournament database, of major details. Will use ESPNCricinfo & Wikipedia to double check things.
 This will feature tournaments which have taken place already, hence I do not have for example the 2025 Women's Cricket World Cup, to be held in India & Sri Lanka later this year. Though, I will update at the time of the tournament!
 */
	public static void main(String[] args) {
		System.out.println("Welcome. You want major details of all ICC events? Well, this is the destination!");
		Scanner input = new Scanner (System.in);
		System.out.println("First, let's get this straight, which tournament do you want the details about? The answers (must) be one of the 4: WTC, T20WC, CWC, CT");
		String tournament = input.next();
		if(tournament.equalsIgnoreCase("WTC")) {
			worldTestChampionship();	
		}
		else if (tournament.equalsIgnoreCase("T20WC")) {
			worldCupT20();
		}
		else if (tournament.equalsIgnoreCase("CWC")) {
			cricketWorldCup();
		}
		else if (tournament.equalsIgnoreCase("CT")) {
			championsTrophy();
		}
		input.close();
	}
	
	public static void worldTestChampionship() {
		/*
		 All details are here:
		 https://en.wikipedia.org/wiki/ICC_World_Test_Championship
		 */
		int[] finals = {2021, 2023, 2025}; //The years a WTC final has taken place
		String[] winners = {"New Zealand", "Australia", "South Africa"}; //The winning teams
		String[] pOTF = {"Kyle Jamieson", "Travis Head", "Aiden Markram"}; //The player of the match for the final
		String[] runnersUp = {"India", "India", "Australia"}; //The runners up for the editions
		String[] hostVenue = {"Rose Bowl, Southampton", "The Oval, London", "Lord's, London"}; //The ground hosting the final
		int index = -1; //declaring the index variable
		System.out.println("Which edition would you like to know about? And what exactly? You can choose from 2021, 2023, 2025 editions, for winners (W), player of the final (POTF), the runners up (RU), and host venue (HV).");
		Scanner input = new Scanner(System.in);
		do {
		System.out.println("Which edition?");
		int edition = input.nextInt();
		index = editionIndex(finals, edition);
		if (index == -1) {
			System.out.println("Try again!");
		}
		}
		while (index == -1);
		System.out.println("What detail?");
		String detail = input.next();
		if (detail.equalsIgnoreCase("W")) {//for winner
			System.out.println("The winner of the " + finals[index] + " final is: " + winners[index]);
		}
		else if (detail.equalsIgnoreCase("POTF")) {//for player of the final
			System.out.println("The player of the " + finals[index] + " final is: " + pOTF[index]);
		}
		else if (detail.equalsIgnoreCase("RU")) {//for runners-up
			System.out.println("The runners-up of the " + finals[index] + " final is: " + runnersUp[index]);
		}
		else if (detail.equalsIgnoreCase("HV")) {//host venue
			System.out.println("The host venue of the " + finals[index] + " final is: " + hostVenue[index]);
		}
		input.close();		
		
	}
	
	public static void worldCupT20() {
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
		  https://www.espncricinfo.com/series/icc-women-s-t20-world-cup-2024-25-1432420/new-zealand-women-vs-south-africa-women-final-1432444/full-scorecard
		 */
		int[] menEditions = {2007, 2009, 2010, 2012, 2014, 2016, 2021, 2022, 2024}; //The years a men's edition has taken place
		int[] womenEditions = {2009, 2010, 2012, 2014, 2016, 2018, 2020, 2023, 2024}; //The years a women's edition has taken place
		String[] menWinners = {"India", "Pakistan", "England", "West Indies", "Sri Lanka", "West Indies", "Australia", "England", "India"}; //The winning teams of the men's editions
		String[] womenWinners = {"England", "Australia", "Australia", "Australia", "West Indies", "Australia", "Australia", "Australia", "New Zealand"}; //The winning teams of the women's editions
		String[] menRunnersUp = {"Pakistan", "Sri Lanka", "Australia", "Sri Lanka", "India", "England", "New Zealand", "Pakistan", "South Africa"}; //The runners up of the men's editions
		String[] womenRunnersUp = {"New Zealand", "New Zealand", "England", "England", "Australia", "England", "India", "South Africa", "South Africa"}; //The runners up of the women's editions
		String[] menHosts = {"South Africa", "England", "West Indies", "Sri Lanka", "Bangladesh", "India", "United Arab Emirates & Oman", "Australia", "West Indies & United States of America"}; //The hosts of the men's editions
		String[] womenHosts = {"England", "West Indies", "Sri Lanka", "Bangladesh", "India", "West Indies", "Australia", "South Africa", "United Arab Emirates"}; //The hosts of the women's editions
		String[] menPOTT = {"Shahid Afridi", "Tillakaratne Dilshan", "Kevin Pietersen", "Shane Watson", "Virat Kohli", "Virat Kohli", "David Warner", "Sam Curran", "Jasprit Bumrah"}; //The player of the tournament for the men's editions
		String[] womenPOTT = {"Claire Taylor", "Nicola Browne", "Charlotte Edwards", "Anya Shrubsole", "Stafanie Taylor", "Alyssa Healy", "Beth Mooney", "Ashleigh Gardner", "Amelia Kerr"}; //The player of the tournament for the women's editions
		String[] menPOTF = {"Irfan Pathan", "Shahid Afridi", "Craig Kieswetter", "Marlon Samuels", "Kumar Sangakarra", "Marlon Samuels", "Mitchell Marsh", "Sam Curran", "Virat Kohli"}; //The player of the match in the final for the men's editions
		String[] womenPOTF = {"Katherine Brunt", "Ellyse Perry", "Jess Cameron", "Sarah Coyte", "Hayley Matthews", "Ashleigh Gardner", "Alyssa Healy", "Beth Mooney", "Amelia Kerr"}; //The player of the match for the women's editions
		int index = -1; //declaring the index variable
		System.out.println("Which edition would you like to know about? And what exactly? You can choose from the many men's and women's editions, for winners (W), player of the final (POTF), player of the tournament (POTT),\nthe runners up (RU), and hosts (H).");
		Scanner input = new Scanner(System.in);
		System.out.println("Which version? Men or women?");
		String gender = input.next(); //get the gender
		do {
		System.out.println("Which edition?");
		int edition = input.nextInt();
		if (gender.equalsIgnoreCase("MEN")) {
			index = editionIndex(menEditions, edition);
		}//for men
		else if (gender.equalsIgnoreCase("WOMEN")) {
			index = editionIndex(womenEditions, edition);
		}//for women
		if (index == -1) {
			System.out.println("Try again!");
		}
		}
		while (index == -1);
		System.out.println("What detail?");
		String detail = input.next();
		if (detail.equalsIgnoreCase("W")) {//for winner
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The winner of the " + menEditions[index] + " men's edition is: " + menWinners[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The winner of the " + womenEditions[index] + " women's edition is: " + womenWinners[index]);
			}
		}
		else if (detail.equalsIgnoreCase("POTF")) {//for player of the final
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The player of the final for the " + menEditions[index] + " men's edition is: " + menPOTF[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The player of the final for the " + womenEditions[index] + " women's edition is: " + womenPOTF[index]);
			}
		}
		else if (detail.equalsIgnoreCase("POTT")) {//for player of the tournament
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The player of the final for the " + menEditions[index] + " men's edition is: " + menPOTT[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The player of the final for the " + womenEditions[index] + " women's edition is: " + womenPOTT[index]);
			}
		}
		else if (detail.equalsIgnoreCase("RU")) {//for runners-up
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The runners-up of the " + menEditions[index] + " men's edition is: " + menRunnersUp[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The runners-up of the " + womenEditions[index] + " women's edition is: " + womenRunnersUp[index]);
			}
		}
		else if (detail.equalsIgnoreCase("H")) {//host venue
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The host of the " + menEditions[index] + " men's edition is: " + menHosts[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The host of the " + womenEditions[index] + " women's edition is: " + womenHosts[index]);
			}
		}
	}
	
	public static void cricketWorldCup() {
		/*
		 	I've taken details from these pages:
		 	Men:
		 	https://en.wikipedia.org/wiki/Cricket_World_Cup
		 	https://en.wikipedia.org/wiki/1975_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/prudential-world-cup-1975-60793/australia-vs-west-indies-final-65049/full-scorecard
		 	https://en.wikipedia.org/wiki/1979_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/prudential-world-cup-1979-60806/england-vs-west-indies-final-65063/full-scorecard
		 	https://en.wikipedia.org/wiki/1983_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/prudential-world-cup-1983-60832/india-vs-west-indies-final-65090/full-scorecard
		 	https://en.wikipedia.org/wiki/1987_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/reliance-world-cup-1987-88-60876/australia-vs-england-final-65117/full-scorecard
		 	https://en.wikipedia.org/wiki/1992_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/benson-hedges-world-cup-1991-92-60924/england-vs-pakistan-final-65156/full-scorecard
		 	https://en.wikipedia.org/wiki/1996_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/wills-world-cup-1995-96-60981/australia-vs-sri-lanka-final-65192/full-scorecard
		 	https://en.wikipedia.org/wiki/1999_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/icc-world-cup-1999-61046/australia-vs-pakistan-final-65234/full-scorecard
		 	https://en.wikipedia.org/wiki/2003_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/icc-world-cup-2002-03-61124/australia-vs-india-final-65286/ball-by-ball-commentary
		 	https://en.wikipedia.org/wiki/2007_Cricket_World_Cup
		 	https://en.wikipedia.org/wiki/2011_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/icc-cricket-world-cup-2010-11-381449/india-vs-sri-lanka-final-433606/ball-by-ball-commentary
		 	https://en.wikipedia.org/wiki/2015_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/icc-cricket-world-cup-2014-15-509587/australia-vs-new-zealand-final-656495/ball-by-ball-commentary
		 	https://en.wikipedia.org/wiki/2019_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/icc-cricket-world-cup-2019-1144415/england-vs-new-zealand-final-1144530/ball-by-ball-commentary
		 	https://en.wikipedia.org/wiki/2023_Cricket_World_Cup
		 	
		 	Women:
		 	https://en.wikipedia.org/wiki/Women%27s_Cricket_World_Cup
		 	https://en.wikipedia.org/wiki/1973_Women%27s_Cricket_World_Cup
		 	https://en.wikipedia.org/wiki/1978_Women%27s_Cricket_World_Cup
		 	https://en.wikipedia.org/wiki/1982_Women%27s_Cricket_World_Cup
		 	https://en.wikipedia.org/wiki/1982_Women%27s_Cricket_World_Cup_final
		 	https://www.espncricinfo.com/series/hansells-vita-fresh-women-s-world-cup-1981-82-61183/australia-women-vs-england-women-final-66971/live-cricket-score
		 	https://en.wikipedia.org/wiki/1988_Women%27s_Cricket_World_Cup
		 	https://en.wikipedia.org/wiki/1988_Women%27s_Cricket_World_Cup_final
		 	https://en.wikipedia.org/wiki/1993_Women%27s_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/women-s-world-cup-1993-61205/england-women-vs-new-zealand-women-final-66893/live-cricket-score
		 	https://en.wikipedia.org/wiki/1997_Women%27s_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/hero-honda-women-s-world-cup-1997-98-61222/australia-women-vs-new-zealand-women-final-66905/full-scorecard
		 	https://en.wikipedia.org/wiki/2000_Women%27s_Cricket_World_Cup
		 	https://en.wikipedia.org/wiki/2000_Women%27s_Cricket_World_Cup_final
		 	https://en.wikipedia.org/wiki/2005_Women%27s_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/women-s-world-cup-2004-05-61271/australia-women-vs-india-women-final-67317/live-cricket-score
		 	https://en.wikipedia.org/wiki/2009_Women%27s_Cricket_World_Cup
		 	https://en.wikipedia.org/wiki/2009_Women%27s_Cricket_World_Cup_final
		 	https://www.espncricinfo.com/series/icc-women-s-world-cup-2008-09-351827/england-women-vs-new-zealand-women-final-357980/live-cricket-score
		 	https://en.wikipedia.org/wiki/2013_Women%27s_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/icc-women-s-world-cup-2012-13-587632/australia-women-vs-west-indies-women-final-594915/live-cricket-score
		 	https://en.wikipedia.org/wiki/2017_Women%27s_Cricket_World_Cup
		 	https://www.espncricinfo.com/series/icc-wwc-2017-1085935/england-women-vs-india-women-final-1085975/live-cricket-score
		 	https://en.wikipedia.org/wiki/2022_Women%27s_Cricket_World_Cup
		 * 
		 */
		int[] menEditions = {1975, 1979, 1983, 1987, 1992, 1996, 1999, 2003, 2007, 2011, 2015, 2019, 2023}; //The years a men's edition has taken place
		int[] womenEditions = {1973, 1978, 1982, 1988, 1993, 1997, 2000, 2005, 2009, 2013, 2017, 2022}; //The years a women's edition has taken place
		String[] menWinners = {"West Indies", "West Indies", "India", "Australia", "Pakistan", "Sri Lanka", "Australia", "Australia", "Australia", "India", "Australia", "England", "Australia"}; //The winners of the men's editions
		String[] womenWinners = {"England", "Australia", "Australia", "England", "Australia", "New Zealand", "Australia", "England", "Australia", "England", "Australia"}; //The winners of the women's editions
		String[] menRunnersUp = {"Australia", "England", "West Indies", "England", "England", "Australia", "Pakistan", "India", "Sri Lanka", "Sri Lanka", "New Zealand", "New Zealand", "India"}; //The runners up of the men's editions
		String[] womenRunnersUp = {"Australia", "England", "England", "England", "New Zealand", "New Zealand", "Australia", "India", "New Zealand", "West Indies", "India", "England", "TBD"}; //The runners up of the women's editions
		String[] menHosts = {"England", "England", "England & Wales", "India & Pakistan", "Australia & New Zealand", "India, Pakistan & Sri Lanka", "England, Wales, Scotland, Ireland & Netherlands", "South Africa, Zimbabwe & Kenya", "West Indies", "India, Sri Lanka & Bangladesh", "Australia & New Zealand", "England & Wales", "India"}; //The hosts of the men's editions
		String[] womenHosts = {"England", "India", "New Zealand", "Australia", "England", "India", "New Zealand", "India", "New Zealand", "South Africa", "Australia", "India", "England", "New Zealand"}; //The hosts of the women's editions
		//For the coming categories...N/A means I couldn't find the player of the tournament/final for those editions
		String[] menPOTT = {"N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "Sachin Tendulkar", "Glenn McGrath", "Yuvraj Singh", "Mitchell Starc", "Kane Williamson", "Virat Kohli"}; //The player of the tournament for the men's editions
		String[] womenPOTT = {"N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "Karen Rolton", "Claire Taylor", "Suzie Bates", "Tammy Beaumont", "Alyssa Healy"}; //The player of the tournament for the women's editions
		String[] menPOTF = {"Clive Lloyd", "Viv Richards", "Mohinder Amarnath", "David Boon", "Wasim Akram", "Aravinda de Silva", "Shane Warne", "Ricky Ponting", "Adam Gilchrist", "MS Dhoni", "James Faulkner", "Ben Stokes", "Travis Head"}; //The player of the match in the final for the men's editions
		String[] womenPOTF = {"N/A", "N/A", "N/A", "N/A", "Jo Chamberlain", "Debbie Hockley", "Belinda Clark", "Karen Rolton", "Nicky Shaw", "Jess Cameron", "Anya Shrubsole", "Alyssa Healy"}; ///The player of the match in the final for the women's editions
		int index = -1; //declaring the index variable
		System.out.println("Which edition would you like to know about? And what exactly? You can choose from the many men's and women's editions, for winners (W), player of the final (POTF), player of the tournament (POTT),\nthe runners up (RU), and hosts (H).");
		Scanner input = new Scanner(System.in);
		System.out.println("Which version? Men or women?");
		String gender = input.next(); //get the gender
		do {
		System.out.println("Which edition?");
		int edition = input.nextInt();
		if (gender.equalsIgnoreCase("MEN")) {
			index = editionIndex(menEditions, edition);
		}//for men
		else if (gender.equalsIgnoreCase("WOMEN")) {
			index = editionIndex(womenEditions, edition);
		}//for women
		if (index == -1) {
			System.out.println("Try again!");
		}
		}
		while (index == -1);
		System.out.println("What detail?");
		String detail = input.next();
		if (detail.equalsIgnoreCase("W")) {//for winner
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The winner of the " + menEditions[index] + " men's edition is: " + menWinners[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The winner of the " + womenEditions[index] + " women's edition is " + womenWinners[index]);
			}
		}
		else if (detail.equalsIgnoreCase("POTF")) {//for player of the final
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The player of the final for the " + menEditions[index] + " men's edition is: " + menPOTF[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The player of the final for the " + womenEditions[index] + " women's edition is: " + womenPOTF[index]);
			}
		}
		else if (detail.equalsIgnoreCase("POTT")) {//for player of the tournament
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The player of the final for the " + menEditions[index] + " men's edition is: " + menPOTT[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The player of the final for the " + womenEditions[index] + " women's edition is: " + womenPOTT[index]);
			}
		}
		else if (detail.equalsIgnoreCase("RU")) {//for runners-up
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The runners-up of the " + menEditions[index] + " men's edition is: " + menRunnersUp[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The runners-up of the " + womenEditions[index] + " women's edition is: " + womenRunnersUp[index]);
			}
		}
		else if (detail.equalsIgnoreCase("H")) {//host venue
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The host of the " + menEditions[index] + " men's edition is: " + menHosts[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The host of the " + womenEditions[index] + " women's edition is: " + womenHosts[index]);
			}
		}
	}
	
	public static void championsTrophy() {
		/*
		 I've taken the details from these pages:
		 Men:
		 https://en.wikipedia.org/wiki/ICC_Champions_Trophy
		 https://www.espncricinfo.com/series/wills-international-cup-1998-99-61033/south-africa-vs-west-indies-final-66169/live-cricket-score
		 https://www.espncricinfo.com/series/icc-knockout-2000-01-61073/india-vs-new-zealand-final-66179/live-cricket-score
		 https://en.wikipedia.org/wiki/2000_ICC_KnockOut_Trophy
		 https://en.wikipedia.org/wiki/2000_ICC_KnockOut_Trophy_final
		 https://en.wikipedia.org/wiki/2002_ICC_Champions_Trophy
		 https://www.espncricinfo.com/series/icc-champions-trophy-2002-03-61114/sri-lanka-vs-india-final-66194/live-cricket-score
		 https://www.espncricinfo.com/series/icc-champions-trophy-2004-61157/england-vs-west-indies-final-66210/live-cricket-score
		 https://www.espncricinfo.com/series/icc-champions-trophy-2009-10-374074/australia-vs-new-zealand-final-415287/live-cricket-score
		 https://www.espncricinfo.com/series/icc-champions-trophy-2013-566910/england-vs-india-final-566948/live-cricket-score
		 https://www.espncricinfo.com/series/icc-champions-trophy-2017-1022345/india-vs-pakistan-final-1022375/full-scorecard
		 https://www.espncricinfo.com/series/icc-champions-trophy-2024-25-1459031/india-vs-new-zealand-final-1466428/full-scorecard
		 Women:
		 https://en.wikipedia.org/wiki/ICC_Women%27s_Champions_Trophy
		 */
		int[] menEditions = {1998, 2000, 2002, 2004, 2006, 2009, 2013, 2017, 2025}; //The years a men's edition has taken place
		int[] womenEditions = {}; //The years a women's  edition has taken place...the first will be in 2027
		String[] menWinners = {"South Africa", "New Zealand", "India & Sri Lanka", "West Indies", "Australia", "Australia", "India", "Pakistan", "India"}; //The winners of the men's editions
		String[] womenWinners = {}; //The winners of the women's editions
		String[] menRunnersUp = {"West Indies", "India", "N/A", "England", "West Indies", "New Zealand", "England", "India", "New Zealand"}; //The runners up of the men's editions
		String[] womenRunnersUp = {}; //The runners up of the women's editions
		String[] menHosts = {"Bangladesh", "Kenya", "Sri Lanka", "England", "India", "South Africa", "England & Wales", "Pakistan & United Arab Emirates"}; //The hosts of the men's editions
		String[] womenHosts = {}; //The hosts of the women's editions...the 2027 edition will be hosted by Sri Lanka
		String[] menPOTT = {"Jacques Kallis", "N/A", "Not awarded", "Ramnaresh Sarwan", "Chris Gayle", "Ricky Ponting", "Shikhar Dhawan", "Hasan Ali", "Rachin Ravindra"}; //The player of the tournament for the men's editions...N/A for [1] is because I cannot seem to find it
		String[] womenPOTT = {}; //The player of the tournament of the women's editions
		String[] menPOTF = {"Jacques Kallis", "Chris Cairns", "N/A", "Ian Bradshaw", "Shane Watson", "Shane Watson", "Ravindra Jadeja", "Fakhar Zaman", "Rohit Sharma"}; //The player of the match in the final for the men's editions
		String[] womenPOTF = {}; //The player of the match in the final for the women's editions
		int index = -1; //declaring the index variable
		System.out.println("Which edition would you like to know about? And what exactly? You can choose from the many men's and women's editions, for winners (W), player of the final (POTF), player of the tournament (POTT),\nthe runners up (RU), and hosts (H).");
		Scanner input = new Scanner(System.in);
		System.out.println("Which version? Men or women?");
		String gender = input.next(); //get the gender
		do {
		System.out.println("Which edition?");
		int edition = input.nextInt();
		if (gender.equalsIgnoreCase("MEN")) {
			index = editionIndex(menEditions, edition);
		}//for men
		else if (gender.equalsIgnoreCase("WOMEN")) {
			index = editionIndex(womenEditions, edition);
		}//for women
		if (index == -1) {
			System.out.println("Try again!");
		}
		}
		while (index == -1);
		System.out.println("What detail?");
		String detail = input.next();
		if (detail.equalsIgnoreCase("W")) {//for winner
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The winner of the " + menEditions[index] + " men's edition is: " + menWinners[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The winner of the " + womenEditions[index] + " women's edition is: " + womenWinners[index]);
			}
		}
		else if (detail.equalsIgnoreCase("POTF")) {//for player of the final
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The player of the final for the " + menEditions[index] + " men's edition is: " + menPOTF[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The player of the final for the " + womenEditions[index] + " women's edition is: " + womenPOTF[index]);
			}
		}
		else if (detail.equalsIgnoreCase("POTT")) {//for player of the tournament
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The player of the final for the " + menEditions[index] + " men's edition is: " + menPOTT[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The player of the final for the " + womenEditions[index] + " women's edition is: " + womenPOTT[index]);
			}
		}
		else if (detail.equalsIgnoreCase("RU")) {//for runners-up
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The runners-up of the " + menEditions[index] + " men's edition is: " + menRunnersUp[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The runners-up of the " + womenEditions[index] + " women's edition is: " + womenRunnersUp[index]);
			}
		}
		else if (detail.equalsIgnoreCase("H")) {//host venue
			if (gender.equalsIgnoreCase("MEN")) {//if men
				System.out.println("The host of the " + menEditions[index] + " men's edition is: " + menHosts[index]);
			}
			else if (gender.equalsIgnoreCase("WOMEN")) {//if women
				System.out.println("The host of the " + womenEditions[index] + " women's edition is: " + womenHosts[index]);
			}
		}
	}
	
	public static int editionIndex(int[] editions, int want) {
		int index = -1;
		for (int i = 0; i < editions.length; i++) {
			if (editions[i] == want) {
				index = i;
			}
		}
		return index;
	}
}


