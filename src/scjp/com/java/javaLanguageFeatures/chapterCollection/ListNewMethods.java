package scjp.com.java.javaLanguageFeatures.chapterCollection;

import java.util.*;

public class ListNewMethods {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Ram");
    list.add("Sita");
    list.add("Shyam");
    list.add("Hari");

//    list.sort(Comparator.comparing(str -> str));
    list.sort(Comparator.comparing(String::length).thenComparing(String::toString));

    System.out.println(list);

    int index = Collections.binarySearch(list, "Hari");
    System.out.println(index);

    Collections.reverse(list);
    System.out.println(list);

    Collections.shuffle(list);
    System.out.println(list);

    Collections.swap(list, 1, 3);
    System.out.println(list);

    Collections.rotate(list, 2);
    System.out.println(list);

    List<Integer> intList = Arrays.asList(1, 2, 4, 5, 6);
    intList.replaceAll(ele -> ele * 2);
    System.out.println(intList);
  }
}
