Person
  
 

package com.ack.webservices.soap.examples.lifestory;

public class Person {
  private String name;
  private String origin;
  private int[] unitsConsumedLastWeek;
  private int targetAge;
  private int age;

  public Person() {
  }

  public String getName() {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public void setAge( int age ) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public void setOrigin( String origin ) {
    this.origin = origin;
  }

  public String getOrigin() {
    return origin;
  }

  public void setUnitsConsumedLastWeek( int[] unitsConsumedLastWeek ) {
    this.unitsConsumedLastWeek = unitsConsumedLastWeek;
  }

  public int[] getUnitsConsumedLastWeek() {
    return unitsConsumedLastWeek;
  }

  public void setTargetAge( int targetAge ) {
    this.targetAge = targetAge;
  }

  public int getTargetAge() {
    return targetAge;
  }
}
