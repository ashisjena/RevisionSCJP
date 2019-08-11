package scjp.com.java.javaLanguageFeatures.chapterCollection;

import scjp.com.java.javaLanguageFeatures.chapterLambdaExpressions.Person;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {
  public static void main(String[] args) {
    Queue<Person> pq = new PriorityQueue<>(Comparator.comparing(Person::getFirstName).thenComparing(Person::getDob));
    pq.addAll(Person.getPersons());

    while(pq.peek() != null) {
      System.out.println("Head Element: " + pq.peek());
      pq.remove(); // pq.poll();
      System.out.println("Removed one element from Queue");
      System.out.println("Priority Queue: " + pq);
    }
  }
}
