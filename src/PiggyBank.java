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

import java.util.Arrays;
import java.util.Random;

public class PiggyBank {

  public final static int[] COINS_VALUES = {1, 5, 10, 25}; // coins values in cents
  // coins names
  public final static String[] COINS_NAMES = {"PENNY", "NICKEL", "DIME", "QUARTER"};
  public final static String NO_SUCH_COIN = "N/A"; // N/A string
  private final static Random RAND_GEN = new Random(100); // generator of random integers

  /**
   * Returns the name of a specified coin value
   * 
   * @param coin represents a coin value in cents
   * @return the String name of a specified coin value if it is valid and N/A if the coin value is
   *         not valid
   */

  public static String getCoinName(int coin) {
    String str = "";

    switch (coin) {
      case 1:
        str = COINS_NAMES[0]; // PENNY
        break;
      case 5:
        str = COINS_NAMES[1]; // NICKEL
        break;
      case 10:
        str = COINS_NAMES[2]; // DIME
        break;
      case 25:
        str = COINS_NAMES[3]; // QUARTER
        break;
      default:
        str = NO_SUCH_COIN; // "N/A"
    }

    return str;
  }

  /**
   * Returns the balance of a piggy bank in cents
   * 
   * @param coins an oversize array which contains all the coins held in a piggy bank
   * @param size  the total number of coins stored in coins array
   * @return the total value of the coins held in a piggy bank in cents
   */
  public static int getBalance(int[] coins, int size) {
    int total = 0;

    for (int i = 0; i < size; i++) {
      total = total + coins[i];
    }

    return total;

  }

  /**
   * Returns the total number of coins of a specific coin value held in a piggy bank
   * 
   * @param coinValue the value of a specific coin
   * @param coins     an oversize array which contains all the coins held in a piggy bank
   * @param size      the total number of coins stored in coins array
   * @return the number of coins of value coinValue stored in the array coins
   */
  public static int getSpecificCoinCount(int coinValue, int[] coins, int size) {
    int count = 0;
    int i;

    if (coinValue == COINS_VALUES[3]) { // Quarter
      for (i = 0; i < size; i++) {
        if (coins[i] == coinValue) {
          count++;
        }
      }
    }

    else if (coinValue == COINS_VALUES[2]) { // Dime
      for (i = 0; i < size; i++) {
        if (coinValue == coins[i]) {
          count++;
        }
      }
    }

    else if (coinValue == COINS_VALUES[1]) { // Nickel
      for (i = 0; i < size; i++) {
        if (coinValue == coins[i]) {
          count++;
        }
      }
    }

    else if (coinValue == COINS_VALUES[0]) { // Penny
      for (i = 0; i < size; i++) {
        if (coinValue == coins[i]) {
          count++;
        }
      }
    }

    return count;
  }

  /**
   * Displays information about the content of a piggy bank
   * 
   * @param coins an oversize array storing the coins held in a piggy bank
   * @param size  number of coin held array coins
   */

  public static void printPiggyBank(int[] coins, int size) {
    System.out.println("QUARTERS: " + getSpecificCoinCount(25, coins, size));
    System.out.println("DIMES: " + getSpecificCoinCount(10, coins, size));
    System.out.println("NICKELS: " + getSpecificCoinCount(5, coins, size));
    System.out.println("PENNIES: " + getSpecificCoinCount(1, coins, size));
    System.out.println("Balance: " + getBalance(coins, size) * 0.01);
  }

  /**
   * Adds a given coin to a piggy bank. This operation can terminate successfully or unsuccessfully.
   * For either cases, this method displays a descriptive message for either cases.
   * 
   * @param coin  the coin value in cents to be added to the array coins
   * @param coins an oversize array storing the coins held in a piggy bank
   * @param size  the total number of coins contained in the array coins before this addCoin method
   *              is called.
   * @return the new size of the coins array after trying to add coin.
   */
  public static int addCoin(int coin, int[] coins, int size) {

    if (getCoinName(coin) == NO_SUCH_COIN) {
      System.out.println(coin + " cents is not a valid US currency coin.");
      return size;
    }

    if (size >= coins.length) {
      System.out.println("Tried to add a " + PiggyBank.getCoinName(coin) + ", but could not "
          + "because the piggy bank is full.");
    }

    else {

      coins[size] = coin; //
      size = size + 1; // updates the size
    }

    return size;

  }


  /**
   * Removes an arbitrary coin from a piggy bank. This method may terminate successfully or
   * unsuccessfully. In either cases, a descriptive message is displayed.
   *
   * @param coins an oversize array which contains the coins held in a piggy bank
   * @param size  the number of coins held in the coins array before this method is called
   * @return the size of coins array after this method returns successfully
   *
   */
  public static int removeCoin(int[] coins, int size) {
    int nums = 0; // returns the new size
    int index = 0; 
    int temp = 0;
    int remove = 0;
    Random rand = new Random();

    // set random index of array
    index = rand.nextInt(size);

    // if empty:
    if (getBalance(coins, size) < 1) {
      System.out.println("Tried to remove a coin, but could not because the piggy bank is empty.");
    } else {
      temp = index; // temporary hold for the random index number
      remove = coins[temp];
      coins[temp] = 0;
    }

    nums = size - 1;

    System.out.println("Removed a " + getCoinName(remove) + ".");

    return nums;

  }


  /**
   * Removes all the coins in a piggy bank. It also displays the total value of the removed coins
   *
   * @param coins an oversize array storing the coins held in a piggy bank application
   * @param size  number of coins held in coins array before this method is called
   * @return the new size of the piggy bank after removing all its coins.
   */
  public static int emptyPiggyBank(int[] coins, int size) {
    int nums = 0;
    int total;
    int[] empty = new int[0];

    // if bank is empty:
    if (coins.length < 1) {
      System.out.println("Zero coin removed. The piggy bank is already empty.");
    }

    // if bank is NOT empty:
    else if (coins.length > 0) {
      total = getBalance(coins, size);
      coins = Arrays.copyOf(empty, 0); // coins is now empty
      System.out.println("All done. " + total + " cents removed.");
    }

    nums = coins.length;

    // System.out.println(nums);

    return nums;

  }

}
