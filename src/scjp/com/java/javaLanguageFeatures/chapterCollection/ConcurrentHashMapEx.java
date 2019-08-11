package scjp.com.java.javaLanguageFeatures.chapterCollection;

import scjp.com.java.javaLanguageFeatures.chapterLambdaExpressions.Gender;
import scjp.com.java.javaLanguageFeatures.chapterLambdaExpressions.Person;

import java.time.LocalDate;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapEx {
  private static Person DEFAULT_PERSON = new Person();
  public static void main(String[] args) {
    ConcurrentMap<String, Person> cMap = new ConcurrentHashMap<>();
    cMap.put("Ram", new Person("Ram", "Madhav", LocalDate.of(1985, 1, 1), Gender.MALE));
    cMap.putIfAbsent("Sita", new Person("Sita", "Das", LocalDate.of(1989, 05, 07), Gender.FEMALE));

    // computeIfAbsent, computeIfPresent
    cMap.compute("Ram", (str, person) -> {
      person.setLastName("Lalla");
      return person;
    });

    System.out.println(cMap.getOrDefault("Hari", DEFAULT_PERSON));
    System.out.println(cMap);
  }
}
