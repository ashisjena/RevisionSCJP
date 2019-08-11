package scjp.com.java.javaLanguageFeatures.chapterCollection;

import scjp.com.java.javaLanguageFeatures.chapterLambdaExpressions.Person;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetEx {
  public static void main(String[] args) {
    SortedSet<Person> personsSortedByName = new TreeSet<>(Comparator.comparing(Person::getFirstName));
    personsSortedByName.addAll(Person.getPersons());

    personsSortedByName.forEach(System.out::println);
  }
}
