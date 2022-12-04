import java.util.Scanner;

public class HanksHarvest {
	
	/**
     * TODO: Determine if this year's harvest was considered good based on given criteria:
     *
     * @param havest --> (String) A representation of this year's harvest where each character represents a crop.
     *
     * @return result --> (boolean) true if the harvest is considered good, false if the harvest is considered bad
     */
	public static boolean isGoodHarvest(String harvest) {
        double numberOfCorn = 0;
        double numberOfPotatoes = 0;
        double numberOfZucchini = 0;
        double numberOfRotten = 0;



        for (int i = 0; i < harvest.length(); i++) {
            if (harvest.charAt(i) == 'C') {
                numberOfCorn++;
            } else if (harvest.charAt(i) == 'P') {
                numberOfPotatoes++;
            } else if (harvest.charAt(i) == 'Z') {
                numberOfZucchini++;
            } else if (harvest.charAt(i) == 'R') {
                numberOfRotten++;
            }
        }        

        double totalCrops = numberOfCorn + numberOfPotatoes + numberOfZucchini + numberOfRotten;
        double notRotten = (totalCrops-numberOfRotten);

        if ((numberOfRotten / (totalCrops)) > 0.1) {
            // System.out.println("rotten");
            return false;
        }
    
        // Write your solution here
        if (numberOfCorn < 2.0) {
            // System.out.println("CORN");
            return false;
        }

        if (numberOfPotatoes < 4.0) {
            // System.out.println("Pottatoes");
            return false;
        }

        if (numberOfZucchini < 5.0) {
            // System.out.println("zucc");
            return false;
        }

        if (totalCrops < 15.0) {
            // System.out.println("sum");
            return false;
        }

		return true;
	}

	/*
	* It is unnecessary to edit the "main" method of each problem's provided code
	* skeleton. The main method is written for you in order to help you conform to
	* input and output formatting requirements.
	*/
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
        for (int tests = Integer.parseInt(in.nextLine()); tests > 0; tests--) {
            String harvest = in.nextLine();
            boolean isGoodHarvest = isGoodHarvest(harvest);
            if(isGoodHarvest){ 
                System.out.println("This year's harvest is good!");
            } else {
                System.out.println("This year's harvest is bad!");
            }
        }

        in.close();
	}
}