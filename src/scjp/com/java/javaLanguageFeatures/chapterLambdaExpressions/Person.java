package scjp.com.java.javaLanguageFeatures.chapterLambdaExpressions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static scjp.com.java.javaLanguageFeatures.chapterLambdaExpressions.Gender.FEMALE;
import static scjp.com.java.javaLanguageFeatures.chapterLambdaExpressions.Gender.MALE;

public class Person {
  private String firstName;
  private String lastName;
  private LocalDate dob;
  private Gender gender;
  private double sal;

  public Person(String firstName, String lastName, LocalDate dob, Gender gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.gender = gender;
  }

  public Person(String firstName, String lastName, LocalDate dob, Gender gender, double sal) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.gender = gender;
    this.sal = sal;
  }

  public Person() {
  }

  public double getSal() { return this.sal; }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public boolean isFemale() {
    return this.gender == FEMALE;
  }

  @Override
  public String toString() {
    if (firstName == null && lastName == null && gender == null && dob == null) {
      return "EMPTY_PERSON";
    }
    return firstName + " " + lastName + ", " + gender + ", " + dob + ", " + sal;
  }

  public static List<Person> getPersons() {
    List<Person> list = new ArrayList<>();
    list.add(new Person("Ram", "Lala", LocalDate.of(1980, 1, 20), MALE, 5000.00));
    list.add(new Person("Sita", "Maiya", LocalDate.of(1983, 9, 18), FEMALE, 6500.00));
    list.add(new Person("Ravan", "King", LocalDate.of(1981, 1, 18), MALE, 8920.50));
    list.add(new Person("Laxman", "Dasarath", LocalDate.of(1985, 5, 22), MALE, 5600.00));
    list.add(new Person("Kaikeyee", "Mata", LocalDate.of(1969, 12, 31), FEMALE, 14500.00));
    return list;
  }
}
