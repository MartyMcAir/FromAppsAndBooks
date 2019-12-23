Account this

package com.ack.learning.examples.account;

public class AccountThis {
  public AccountThis() {
    System.out.println( "created an account object" );
  }

  public AccountThis( String name ) {
    this();
    System.out.println( "created account with name " + name );
  }

  public AccountThis( String name, double amount ) {
    this( name );
    System.out.println( "create account with amount " + amount );
  }

  public static void main( String[] args ) {
    AccountThis hsbc = new AccountThis( "jerry", 25d );
  }
}
