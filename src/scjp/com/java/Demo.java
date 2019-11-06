package scjp.com.java;

public class Demo {
  public static void main(String[] args) {
    System.out.println(5^1);
    System.out.println("../ab/..".matches("[..[/]?]+"));
    System.out.print("Created a parking lot with 6 slots\n"+
            "Allocated slot number: 1\n"+
            "Allocated slot number: 2\n"+
            "Allocated slot number: 3\n"+
            "Allocated slot number: 4\n"+
            "Allocated slot number: 5\n"+
            "Allocated slot number: 6\n"+
            "Slot number 4 is free\n"+
            "Slot No.    Registration No    Colour\n1           KA-01-HH-1234      White\n2           KA-01-HH-9999      White\n3           KA-01-BB-0001      Black\n5           KA-01-HH-2701      Blue\n6           KA-01-HH-3141      Black\n"+
            "Allocated slot number: 4\n"+
            "Sorry, parking lot is full\n"+
            "KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333\n"+
            "1, 2, 4\n"+
            "6\n"+
            "Not found\n");
  }
}
