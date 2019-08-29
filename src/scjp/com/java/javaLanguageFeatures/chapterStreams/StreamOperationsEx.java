package scjp.com.java.javaLanguageFeatures.chapterStreams;

import scjp.com.java.javaLanguageFeatures.chapterLambdaExpressions.Gender;
import scjp.com.java.javaLanguageFeatures.chapterLambdaExpressions.Person;

import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsEx {
  public static void main(String[] args) {
    int sum = Stream.of(1, 2, 3, 5, 7, 8)
                    .peek(e -> System.out.println("Initial: " + e))
                    .filter(n -> n % 2 == 1)
                    .peek(e -> System.out.println("Filtered " + e))
                    .map(n -> n + 1)
                    .peek(e -> System.out.println("Mapped " + e))
                    .reduce(0, Integer::sum);
    System.out.println(sum);

    Person.getPersons()
          .stream()
          .filter(Person::isFemale)
          .forEach(System.out::println);

    Person.getPersons()
          .stream()
          .map(Person::getFirstName)
          .forEach(System.out::println);

    Stream.of(1, 2, 3)
          .map(n -> Stream.of(n, n * n))
          .forEach(System.out::println);

    Stream.of(1, 2, 3)
          .map(n -> Stream.of(n, n * n))
          .forEach(e -> e.forEach(System.out::println));
    System.out.println("========");
    /*Stream.of(1, 2, 3)
          .map(n -> Stream.of(n, n * n))
          .flatMap(n -> n)
          .forEach(System.out::println);*/
    Stream.of(1, 2, 3)
          .flatMap(n -> Stream.of(n, n * n))
          .forEach(System.out::println);

    // Count number Es in the strings
    long count = Stream.of("Ken", "Jeff", "Ellen")
                       .map(name -> name.chars())
                       .flatMap(intStream -> intStream.mapToObj(n -> (char) n))
                       .filter(ch -> ch == 'e' || ch == 'E')
                       .count();
    System.out.println("Es count: " + count);

    double allCTC = Person.getPersons()
                          .stream()
                          .reduce(0.0, (partialSum, person) -> partialSum + person.getSal(), Double::sum);
    // <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
    // The combiner will only be used when the reduce operation is performed in parallel.
    System.out.println(allCTC);

    allCTC = Person.getPersons()
                   .stream()
                   .reduce(0.0, (partialSum, person) -> partialSum + person.getSal(), (a, b) -> {
                     // This combiner will only be called when reduce performed in parallel stream.
                     System.out.println("Combiner Called: a = " + a + " b = " + b);
                     return a + b;
                   });
    System.out.println(allCTC);

    allCTC = Person.getPersons()
                   .parallelStream()
                   .reduce(0.0, (partialSum, person) -> {
                     double accumulated = partialSum + person.getSal();
                     System.out.println(Thread.currentThread()
                                              .getName() +
                         " - Accumulator: partialSum = " + partialSum + ", person = " + person +
                         ", accumulated = " + accumulated);
                     return accumulated;
                   }, (a, b) -> {
                     double combined = a + b;
                     System.out.println(Thread.currentThread()
                                              .getName() +
                         " - Combiner: a = " + a + ", b = " + b +
                         ", combined = " + combined);
                     return combined;
                   });
    System.out.println(allCTC);

    Optional<Integer> max = Stream.of(1, 2, 3, 5)
                                  .reduce(Integer::max);
    System.out.println(max.orElse(0));
    max = Stream.<Integer>empty().reduce(Integer::max);
    System.out.println(max.orElse(0));

    Person.getPersons()
          .stream()
          .mapToDouble(Person::getSal)
          .sum();
    Optional<Person> person = Person.getPersons()
                                    .stream()
                                    .max(Comparator.comparingDouble(Person::getSal));
    System.out.println("Highest earner: " + person.orElse(new Person()));

    Person.getPersons()
          .stream()
          .count();

    // <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
    List<String> names = Person.getPersons()
                               .stream()
                               .map(Person::getFirstName)
                               .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    //.collect(() -> new ArrayList<String>(), (list, name) -> list.add(name), (list, list2) -> list.addAll((list2)));
    System.out.println(names);

    // <R,A> R collect(Collector<? super T,A,R> collector)
    names = Person.getPersons()
                  .stream()
                  .map(Person::getFirstName)
                  .collect(Collectors.toList());

    long pCount = Person.getPersons()
                        .stream()
                        .collect(Collectors.counting());

    List<String> sortedNames = Person.getPersons()
                                     .stream()
                                     .map(Person::getFirstName)
                                     .sorted()
                                     .collect(Collectors.toList());
    System.out.println(sortedNames);

    DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
    stats.accept(100.00);
    stats.accept(200.00);
    stats.accept(300.00);
    System.out.println(stats.getCount());
    System.out.println(stats.getSum());
    System.out.println(stats.getMin());
    System.out.println(stats.getAverage());
    System.out.println(stats.getMax());

    DoubleSummaryStatistics d = Person.getPersons()
                                      .stream()
                                      .map(Person::getSal)
                                      .collect(DoubleSummaryStatistics::new, DoubleSummaryStatistics::accept, DoubleSummaryStatistics::combine);
    DoubleSummaryStatistics d1 = Person.getPersons()
                                       .stream()
                                       .collect(Collectors.summarizingDouble(Person::getSal));
    // Same as above

    Map<Gender, String> genderNameMap = Person.getPersons()
                                              .stream()
                                              .collect(Collectors.toMap(Person::getGender, Person::getFirstName, (oldValue, newValue) -> String.join(",", oldValue, newValue)));
    // toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper, BinaryOperator<U> mergeFunction)
    System.out.println(genderNameMap);
    Map<Gender, Person> highestEarnerByGender = Person.getPersons()
                                                      .stream()
                                                      .collect(Collectors.toMap(Person::getGender, Function.identity(), (prevPerson, newPerson) -> newPerson.getSal() > prevPerson.getSal() ? newPerson : prevPerson));
    System.out.println(highestEarnerByGender);

    String delimitedNames = Person.getPersons()
                                  .stream()
                                  .map(Person::getFirstName)
                                  .collect(Collectors.joining(","));

    Map<Gender, List<Person>> personByGender = Person.getPersons()
                                                     .stream()
                                                     .collect(Collectors.groupingBy(Person::getGender));
    // groupingBy(Function<? super T,? extends K> classifier)
    Map<Gender, Long> countByGender = Person.getPersons()
                                            .stream()
                                            .collect(Collectors.groupingBy(Person::getGender,
                                                Collectors.counting()));
    // groupingBy(Function<? super T,? extends K> classifier,  Collector<? super T,A,D> downstream)

    Person.getPersons()
          .stream()
          .collect(Collectors.groupingBy(Person::getGender,
              Collectors.mapping(Person::getFirstName, Collectors.joining(", "))));
    // mapping(Function<? super T,? extends U> mapper, Collector<? super U,A,R> downstream)

    Map<Gender, List<String>> namesByGender = Person.getPersons()
                                                    .stream()
                                                    .collect(Collectors.groupingBy(Person::getGender,
                                                        Collectors.mapping(Person::getFirstName, Collectors.toList())));

    Map<Gender, Map<Month, List<String>>> personsByGenderAndDobMonth =
        Person.getPersons()
              .stream()
              .collect(Collectors.groupingBy(Person::getGender,
                  Collectors.groupingBy(p -> p.getDob()
                                              .getMonth(),
                      Collectors.mapping(Person::getFirstName, Collectors.toList()))));
    System.out.println(personsByGenderAndDobMonth);

    Map<Gender, DoubleSummaryStatistics> incomeStatsByGender =
        Person.getPersons()
              .stream()
              .collect(Collectors.groupingBy(Person::getGender, Collectors.summarizingDouble(Person::getSal)));
    System.out.println(incomeStatsByGender);

//    partitioningBy(Predicate<? super T> predicate)
//    partitioningBy(Predicate<? super T> predicate, Collector<? super T,A,D> downstream)
    Map<Boolean, List<String>> partitionedByFemaleGender =
        Person.getPersons()
              .stream()
              .collect(Collectors.partitioningBy(Person::isFemale,
                  Collectors.mapping(Person::getFirstName, Collectors.toList())));
    System.out.println(partitionedByFemaleGender);

    // <T,A,R,RR> Collector<T,A,RR> collectingAndThen(Collector<T,A,R> downstream, Function<R,RR> finisher)
    // An unmodifiable view of collected data.
    List<String> personNames = Person.getPersons()
                                     .stream()
                                     .map(Person::getFirstName)
                                     .collect(Collectors.collectingAndThen(
                                         Collectors.toList(),
                                         result -> Collections.unmodifiableList(result)));
    System.out.println(personNames);

    Map<Month, String> dobCalendar = Person.getPersons()
                                           .stream()
                                           .collect(
                                               Collectors.collectingAndThen(
                                                   Collectors.groupingBy(p -> p.getDob().getMonth(),
                                                       Collectors.mapping(Person::getFirstName,
                                                           Collectors.joining(","))),
                                                           result -> {
                                                           // Finisher
                                                              // Fill the missing months
                                                             for (Month m : Month.values()) {
                                                               result.putIfAbsent(m, "None");
                                                             }
                                                             return Collections.unmodifiableMap(new TreeMap<>(result));
                                                           }));

    System.out.println(dobCalendar);

//    boolean allMatch(Predicate<? super T> predicate)
//    boolean anyMatch(Predicate<? super T> predicate)
//    boolean noneMatch(Predicate<? super T> predicate)
//    Optional<T> findAny()
//    Optional<T> findFirst()
    boolean anyoneBornIn1980 = Person.getPersons().stream().anyMatch(p -> p.getDob().getYear() == 1980);
    Optional<Person> anyPersonBornIn1980 = Person.getPersons().stream().filter(p -> p.getDob().getYear() == 1980).findAny();
  }
}
