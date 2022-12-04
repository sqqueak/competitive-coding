import java.util.Scanner;

public class VendingMachine {

    /**
    * TODO: Write a program that determines how many of each item you can buy given the following parameters:
    * 
    * @param numberOfItemsInMachine --> (integer) The number of items in the vending machine.
    * @param itemQuantities --> (integer array) The quantities of each item in the vending machine
    * @param itemPrices --> (double array) The price of each item in the vending machine
    * @param cash --> (double) The amount of money you have to spend
    *
    * @return new integer array --> an integer array containing the number of each item you can buy.
    */
    public static int[] vendingOptions(int numberOfItemsInMachine, int[] itemQuantities, double[] itemPrices, double cash) {

        int[] itemsBought = new int[numberOfItemsInMachine];

        for(int i = 0; i < numberOfItemsInMachine; i++) {
            double numOfItemsD = cash / itemPrices[i];
            int numOfItems = (int) numOfItemsD;

            if(numOfItems > itemQuantities[i]) {
                itemsBought[i] = itemQuantities[i];
            } else {
                itemsBought[i] = numOfItems;
            }
        }

        return itemsBought;
    }

    /*
    * It is unnecessary to edit the "main" method of each problem's provided code
    * skeleton. The main method is written for you in order to help you conform to
    * input and output formatting requirements.
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int tests = Integer.parseInt(in.nextLine()); tests > 0; tests--) {
            String numOfItems = in.nextLine();
            String[] prices = in.nextLine().split(" ");
            String[] quantities = in.nextLine().split(" ");
            String allowance = in.nextLine();

            int itemCount = Integer.parseInt(numOfItems);
            double[] itemPrices = new double[itemCount];
            int[] itemQuantities = new int[itemCount];
            double cash = Double.parseDouble(allowance);

            for (int i = 0; i < itemCount; i++) {
                itemPrices[i] = Double.parseDouble(prices[i]);
                itemQuantities[i] = Integer.parseInt(quantities[i]);
            }

            int[] canBuy = vendingOptions(itemCount, itemQuantities, itemPrices, cash);

            for (int i = 0; i < itemCount; i++){
            	if (i != itemCount - 1){
                    System.out.print(canBuy[i] + " ");
                } else {
                    System.out.print(canBuy[i]);
                }
            }
            System.out.println("");
        }
        
        in.close();
	}

}