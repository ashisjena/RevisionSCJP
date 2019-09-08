package scjp.com.java.algorithm.aapractice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BridgeCount {
  public static void main(String[] args) throws IOException, InterruptedException {

    System.out.println(bridge_count(new String[] {"1#2", "2#4", "3#1", "4#5", "5#3", "6#6"}, 6));
  }

  public static int bridge_count(String[] input1, int input2) {

    List<CityPair> list = new ArrayList<>();
    for (String val : input1) {
      if (val.matches("[//d#//d]"))
        throw new RuntimeException("Wrong Pattern");

      String arr[] = val.split("#");

      list.add(new CityPair(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
    }

    Collections.sort(list, new City1Comparator());
    int noOfUnCrossedBridgeTtoB = 0;
    int prevOppCityTtoB = Integer.MIN_VALUE;

    for (CityPair city : list) {
      if (city.city2 > prevOppCityTtoB) {
        noOfUnCrossedBridgeTtoB++;
        prevOppCityTtoB = city.city2;
      }
    }

    Collections.sort(list, new City2Comparator());
    int noOfUnCrossedBridgeBtoT = 0;
    int prevOppCityBtoT = Integer.MIN_VALUE;

    for (CityPair city : list) {
      if (city.city1 > prevOppCityBtoT) {
        noOfUnCrossedBridgeBtoT++;
        prevOppCityBtoT = city.city1;
      }
    }

    return noOfUnCrossedBridgeTtoB > noOfUnCrossedBridgeBtoT ? noOfUnCrossedBridgeTtoB : noOfUnCrossedBridgeBtoT;
  }

  static class City1Comparator implements Comparator<CityPair> {
    @Override
    public int compare(CityPair o1, CityPair o2) {
      return o1.city1.compareTo(o2.city1);
    }
  }

  static class City2Comparator implements Comparator<CityPair> {
    @Override
    public int compare(CityPair o1, CityPair o2) {
      return o1.city2.compareTo(o2.city2);
    }
  }

  static class CityPair {
    private Integer city1;
    private Integer city2;

    public CityPair(int city1, int city2) {
      this.city1 = city1;
      this.city2 = city2;
    }
    
    @Override
    public String toString()
    {
      return this.city1 + "," + this.city2;
    }
  }
}
