//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P01 - Piggy Bank!
// Course: CS300, Summer 2020
//
// Author: Keith Lienert
// Email: kleinert@wisc.edu
// Lecturer's Name: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////

public class PiggyBankTester {

  /**
   * Checks whether PiggyBank.getCoinName() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testGetCoinName() {
    // change some coin values and names
    PiggyBank.COINS_NAMES[1] = "NICKEL";
    PiggyBank.COINS_NAMES[3] = "QUARTER";
    PiggyBank.COINS_VALUES[1] = 5;
    PiggyBank.COINS_VALUES[3] = 25;


    // PiggyBank.COINS_NAMES[1] = "Two Cents";
    // PiggyBank.COINS_NAMES[3] = "Fifty Cents";
    // PiggyBank.COINS_VALUES[1] = 2;
    // PiggyBank.COINS_VALUES[3] = 50;

    // consider all coin values as input arguments
    for (int i = 0; i < PiggyBank.COINS_VALUES.length; i++) {
      if (!PiggyBank.getCoinName(PiggyBank.COINS_VALUES[i]).equals(PiggyBank.COINS_NAMES[i])) {
        return false;
      }
      // consider input argument which does not correspond to a coin value
      if (!PiggyBank.getCoinName(7).equals(PiggyBank.NO_SUCH_COIN)) {
        return false;
      }
      if (!PiggyBank.getCoinName(-10).equals(PiggyBank.NO_SUCH_COIN)) {
        return false;
      }
    }
    return true;

  }

  /**
   * Checks whether PiggyBank.getBalance() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBalance() {
    // scenario 1 - empty piggy bank
    int[] coins = new int[10]; // array storing the coins held in a piggy bank
    int size = 0; // number of coins held in coins array

    if (PiggyBank.getBalance(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an empty piggy bank.");
      return false;
    }

    // scenario 2 - non empty piggy bank
    coins = new int[] {10, 1, 5, 25, 1, 0, 0};
    size = 5;
    if (PiggyBank.getBalance(coins, size) != 42) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "two pennies, a nickel, a dime, and a quarter.");
      return false;
    }

    // scenario 3 - another non-empty piggy bank
    coins = new int[] {10, 1, 5, 25, 1, 0};
    size = 3;
    if (PiggyBank.getBalance(coins, size) != 16) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "a penny, a nickel, and a dime, only.");
      return false;
    }
    return true;
  }

  public static boolean testGetSpecificCoinCount() {
    int coinValue;
    int[] coins = new int[100]; // array storing the coins held in a piggy bank
    int size = 10; // number of coins held in coins array

    // scenario 1 - Dimes
    coinValue = 10; // Dime
    coins = new int[] {1, 1, 1, 5, 10, 5, 10, 10, 25, 25}; // 3 dimes

    if (PiggyBank.getSpecificCoinCount(coinValue, coins, size) != 3) {
      System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCount did not "
          + "return the expected output when passed with three (3) dimes.");

      return false;
    }

    // scenario 2 - Pennies
    coinValue = 1; // Penny
    coins = new int[] {1, 5, 1, 5, 1, 5, 1, 10, 1, 25}; // 5 pennies

    if (PiggyBank.getSpecificCoinCount(coinValue, coins, size) != 5) {
      System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCount did not "
          + "return the expected output when passed with five (5) pennies.");

      return false;
    }

    // scenario 3 - Quarters
    coinValue = PiggyBank.COINS_VALUES[3]; // Quarter
    coins = new int[] {1, 2, 3, 4, 5, 25, 17, 8, 25, 1}; // 2 quarters

    if (PiggyBank.getSpecificCoinCount(coinValue, coins, size) != 2) {
      System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCount did not "
          + "return the expected output when passed with two (2) quarters.");
      return false;
    }


    return true;
  }

  public static boolean testAddCoin() {
    int coin; // this represents the coins to be added
    int size; // this represents the size of the array
    int[] coins = new int[5];



    // scenario 1 - adding 25 cents
    coin = 25; // Quarter
    size = 0;

    if (size >= coins.length) {
      System.out.println("Problem detected. Method PiggyBank.addCoin did not "
          + "return the 'bank is full' statement for having a size larger than the array length.");
      return false;
    } else if (PiggyBank.addCoin(coin, coins, size) != size + 1) {
      System.out.println("Problem detected. Method PiggyBank.addCoin did not "
          + "return the expected output when passed = coins array length is 1.");
      return false;

    }

    // scenario 2 - adding 10 cents
    coin = 10; // Dime
    size = 4;

    if (size >= coins.length) {
      System.out.println("Problem detected. Method PiggyBank.addCoin did not "
          + "return the 'bank is full' statement for having a size larger than the array length.");
      return false;
    } else if (PiggyBank.addCoin(coin, coins, size) != size + 1) {
      System.out.println("Problem detected. Method PiggyBank.addCoin did not "
          + "return the expected output when passed = coins array length is 5.");
      return false;
    }


    // scenario 3 - adding 1 cent
    coin = 1; // Penny
    size = 3;

    if (size >= coins.length) {
      System.out.println("Problem detected. Method PiggyBank.addCoin did not "
          + "return the 'bank is full' statement for having a size larger than the array length.");
      return false;
    } else if (PiggyBank.addCoin(coin, coins, size) != size + 1) {
      System.out.println("Problem detected. Method PiggyBank.addCoin did not "
          + "return the expected output when passed = coins array length is 4.");
      return false;
    }

    return true;
  }

//  public static boolean testRemoveCoin() {
//    // removeCoin(int[] coins, int size)
//    int[] coins = new int[] {1, 1, 5, 5, 10, 10, 25, 25};
//    int size = 8;
//
//    System.out.println("Balance before: " + PiggyBank.getBalance(coins, size));
//    
//    // scenario #1 - Remove coin
//    if (PiggyBank.removeCoin(coins, size) != 7) {
//      System.out.println("Problem detected. Method PiggyBank.removeCoin did not return the "
//          + "correct size (7).");
//      return false;
//
//    }
//
//    // print array
//    for (int i = 0; i < coins.length; i++) {
//      System.out.print("[" + coins[i] + "] ");
//    }
//
//    System.out.println();
//    System.out.println("Balance after: " + PiggyBank.getBalance(coins, size));
//    
//
//    return true;
//  }


  public static boolean testEmptyPiggyBank() {
    int[] coins = new int[20]; // array storing the coins
    int size; // number of coins in the array

    // scenario 1 - empty bank
    coins = new int[0]; // empty array
    size = 0; // empty array

    if (PiggyBank.emptyPiggyBank(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.emtpyPiggyBank() did not "
          + "return the expected output when passed.");
      return false;
    }

    // scenario 2 - full bank
    coins = new int[] {1, 5, 5, 10, 25};
    size = 5;

    if (PiggyBank.emptyPiggyBank(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.emptyPiggyBank() did not "
          + "return the expected output when passed.");
      return false;
    }

    // scenario 3 - half full (or half empty)

    coins = new int[] {5, 5, 5, 5, 5, 25};
    size = 6;

    if (PiggyBank.emptyPiggyBank(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.emptyPiggyBank() did not "
          + "return the expected output when passed.");
      return false;
    }

    return true;
  }

  /**
   * Calls the test methods implemented in this class and displays their output
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {

    System.out.println("testGetCoinName(): " + testGetCoinName());
    System.out.println("testGetBalance(): " + testGetBalance());
    System.out.println("testGetSpecificCoinCount(): " + testGetSpecificCoinCount());
    System.out.println("testAddCoin(): " + testAddCoin());
    System.out.println("testEmptyPiggyBank(): " + testEmptyPiggyBank());
//    System.out.println("testRemoveCoin(): " + testRemoveCoin());

  }
}
