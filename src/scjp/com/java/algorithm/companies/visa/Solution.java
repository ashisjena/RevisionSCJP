package scjp.com.java.algorithm.companies.visa;

import java.util.*;

interface MyList{
  void convert(String[] a);
  void replace(int idx);
  ArrayList<String> compact();
}

/*
Write the implementation of the InvalidStringException and the ArrayToList classes
Model strings for cut and paste:
I have added the string: {string} at the index: {index}
I have replaced the string: {string} with a null string
*/

class InvalidStringException extends Throwable {
  private static final long serialVersionUID = 1L;
  public InvalidStringException() {
    super();
  }

  public InvalidStringException(final String msg) {
    super(msg);
  }

  public InvalidStringException(final String msg, final Throwable th) {
    super(msg, th);
  }
}

class ArrayToList implements MyList {

  private final ArrayList<String> arrayToList;

  public ArrayToList() {
    this.arrayToList = new ArrayList<>();
  }

  @Override
  public void convert(String[] arr) {
    for(String str : arr) {
      this.arrayToList.add(str);
      System.out.println(String.format("I have added the string: %s at the index: %d", str, this.arrayToList.size()-1));
    }
  }

  @Override
  public void replace(int indx) {
    final String result = this.arrayToList.get(indx);
    this.arrayToList.set(indx, null);
    System.out.println(String.format("I have replaced the string: %s with a null string", result));
    System.out.println(this.arrayToList);
  }

  @Override
  public ArrayList<String> compact() {
    // return this.arrayToList.stream().filter(ele -> ele != null).collect(Collectors.toList());
    final ArrayList<String> result = new ArrayList<>();
    for(String ele : this.arrayToList) {
      if(ele != null) {
        result.add(ele);
      }
    }
    System.out.println(result);
    return result;
  }
}

public class Solution{

  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    Random rand = new Random(0);

    int n = Integer.parseInt(sc.nextLine());
    String[] a = new String[n];

    for(int i = 0; i < n; i++)
      a[i] = sc.nextLine();

    MyList obj = new ArrayToList();

    obj.convert(a);
    int x = rand.nextInt(n);
    for(int i = 0; i < x; i++)
      obj.replace(rand.nextInt(n));


    ArrayList<String> s = obj.compact();



    for (int i = 0; i < s.size(); i++){
      if(s.get(i).charAt(0) >= 97 && s.get(i).charAt(0) <= 122){
        try{
          throw new InvalidStringException("This is an invalid string");
        }
        catch(InvalidStringException e){System.out.println(e.getMessage());}
      }
    }


  }
}