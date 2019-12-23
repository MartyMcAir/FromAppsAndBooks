Deposit Account

package com.ack.learning.examples.account;

public class DepositAccount {
  private double amount;
  private String name;

  public DepositAccount() {
  }

  public DepositAccount( String theName, double theAmount ) {
    name = theName;
    amount = theAmount;
  }

  public double getAmount() {
    return amount;
  }

  public String getName() {
    return name;
  }

  public static void main( String[] args ) {
    DepositAccount hsbc = new DepositAccount( "barry", 345.45 );
    DepositAccount halifax = new DepositAccount( "hector", 45.76 );

    System.out.println( hsbc.getName() );
    System.out.println( halifax.getName() );
  }
}
