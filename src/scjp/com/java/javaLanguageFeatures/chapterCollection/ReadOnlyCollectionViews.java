package scjp.com.java.javaLanguageFeatures.chapterCollection;

import java.util.*;

public class ReadOnlyCollectionViews  {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    List<String> unmodifiableListView = Collections.unmodifiableList(list);
//    <T> List<T> unmodifiableList(List<? extends T> list)
//    <K,V> Map<K,V> unmodifiableMap(Map<? extends K,? extends V> m)
//    <K,V> NavigableMap<K,V> unmodifiableNavigableMap(NavigableMap<K,? extends V> m)
//    <T> Set<T> unmodifiableSet(Set<? extends T> s)
//    <T> NavigableSet<T> unmodifiableNavigableSet(NavigableSet<T> s)
//    <T> SortedSet<T> unmodifiableSortedSet(SortedSet<T> s)
//    <K,V> SortedMap<K,V> unmodifiableSortedMap(SortedMap<K,? extends V> m)

    Set<String> singletonSet = Collections.singleton("Lonely"); // Only if you want to add one element and pass it to a method, because it accepts only Set or list.
    List<String> singletonList = Collections.singletonList("Ram");
    Map<String, String> singletonMap = Collections.singletonMap("Ram", "Chandra");
  }
}
