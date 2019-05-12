package scjp.com.java.javaLanguageFeatures.chapterLambdaExpressions;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionUtilTest {

  private static int n = 100;
  public static void main(String[] args) {
    List<Person> list = Person.getPersons();

    System.out.println("Original list of persons");
    FunctionUtil.forEach(list, System.out::println);

    System.out.println("\nMales Only");
    List<Person> malesList = FunctionUtil.filter(list, p -> p.getGender() == Gender.MALE);
    FunctionUtil.forEach(malesList, p -> System.out.println(p));

    System.out.println("\nMap each person to his/her year of birth");
    List<Integer> dobYearList = FunctionUtil.map(list, p -> p.getDob().getYear());
    FunctionUtil.forEach(dobYearList, year -> System.out.println(year));

    System.out.println("\nAll Person after adding 1 year to DOB");
    FunctionUtil.forEach(list, p -> p.setDob(p.getDob().plusYears(1)));
    FunctionUtil.forEach(list, System.out::println);

    System.out.println("\nPrint FirstName of all the persons");
    List<String> firstNameList = FunctionUtil.map(list, Person::getFirstName);
    FunctionUtil.forEach(firstNameList, System.out::println);

    Person p1 = list.get(0);
    Supplier<String> s1 = p1::toString;
    System.out.println("this::toString : " + s1.get());
    // The below code will only be valid in the enclosing class. i.e in the Person class
//    Supplier<String> s2 = Person.super::toString;
//    System.out.println("Item.super::toString : " + s2.get());

    UnaryOperator<String> uo1 = String::new;
    System.out.println("String::new : " + uo1.apply("Ram"));

    IntFunction<int[]> arrayCreator = int[]::new;
    int[] arr = arrayCreator.apply(10);

    String[] namesArray = {"Ram", "Shayam", "Hari", "Sita"};
    Function<String[], List<String>> asList = Arrays::<String>asList;
    List<String> namesList = asList.apply(namesArray);

    final String str = "Ram";
//    Printer prn1 = str -> System.out.println(str); Variable is already defined
    Printer prn2 = msg -> System.out.println(str);

    String str2 = "Sita"; // Effectively final and not assigned a value later
    Printer prn3 = msg -> System.out.println(str2);

    String str3;
    str3 = "Hari"; // Effectively final
    Printer prn4 = msg -> System.out.println(str3);

    /*String str4 = "Gita";
    Printer prn5 = msg -> System.out.println(str4);
    str4 = "Hari";*/ // Reassigning makes it effectively non-final

    String str5 = "Mita";
    Printer printer = msg -> {
//      str5 = "Hi" + msg; // Compilation Error. Attempting to modify msg;
      System.out.println(str5);
    };

    // Instance and Class variable can be modified inside the lambda function.

    Comparator<Person> lastFirstDobComp = Comparator.comparing(Person::getLastName).thenComparing(Person::getLastName).thenComparing(Person::getDob);
    list.sort(lastFirstDobComp);

    UnaryOperator<Integer> uo2 = m -> m + n++; // n is here the static variable
    System.out.println(uo2.apply(10));
    System.out.println(n);

    PersonCreator<Person> pc1 = Person::new;
    System.out.println(pc1.createPerson("Ram", "Lalla", LocalDate.of(1980, 5, 25), Gender.MALE));
    DefaultPersonCreator<Person> dpc = Person::new;
    System.out.println(dpc.createPerson());
  }

  @FunctionalInterface
  interface Printer {
    void print(String msg);
  }

  @FunctionalInterface
  interface PersonCreator<T> {
    T createPerson(String firstName, String lastName, LocalDate dob, Gender gender);
  }

  @FunctionalInterface
  interface  DefaultPersonCreator<T> {
    T createPerson();
  }
}
