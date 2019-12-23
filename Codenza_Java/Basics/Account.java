Account

package com.ack.learning.examples.account;

public class Account {
  public Account() {
    System.out.println( "created an account object" );
  }

  public Account( String name ) {
    System.out.println( "created account -> " + name );
  }

  public Account( String name, double amount ) {
    System.out.println( "account " + name + " with " + amount );
  }

  public static void main( String[] args ) {
    Account lloyds = new Account();
    Account tsg = new Account( "barry" );
    Account hsbc = new Account( "jerry", 25d );
  }
}
