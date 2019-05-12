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

  public Person(String firstName, String lastName, LocalDate dob, Gender gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.gender = gender;
  }

  public Person() {
  }

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

  @Override
  public String toString() {
    return firstName + " " + lastName + ", " + gender + ", " + dob;
  }

  public static List<Person> getPersons() {
    List<Person> list = new ArrayList<>();
    list.add(new Person("Ram", "Lala", LocalDate.of(1980, 1, 20), MALE));
    list.add(new Person("Sita", "Maiya", LocalDate.of(1983, 9, 18), FEMALE));
    return list;
  }
}
