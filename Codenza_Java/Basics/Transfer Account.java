Transfer Account
  
 

package com.ack.learning.examples.account;

public class TransferAccount {
  private static int count;

  public TransferAccount() {
    ++TransferAccount.count;
  }

  public static int getObjectCount() {
    return TransferAccount.count;
  }

  public static void main( String[] args ) {
    TransferAccount ta = new TransferAccount();
    TransferAccount da = new TransferAccount();

    System.out.println( TransferAccount.getObjectCount() );
  }
}
