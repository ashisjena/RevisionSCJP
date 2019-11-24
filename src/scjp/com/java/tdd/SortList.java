package scjp.com.java.tdd;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SortList {
  @NotNull
  private List<Integer> intList(Integer... ints) {
    return Arrays.asList(ints);
  }

  private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
    assertThat(sort(unsorted), is(sorted));
  }

  @Test
  public void sortTest() {
    assertSorted(intList(), intList());
    assertSorted(intList(1), intList(1));
    assertSorted(intList(2, 1), intList(1, 2));
    assertSorted(intList(2, 3, 1), intList(1, 2, 3));
    assertSorted(intList(2, 1, 3), intList(1, 2, 3));
    assertSorted(intList(1, 3, 2), intList(1, 2, 3));
    assertSorted(intList(3, 2, 1), intList(1, 2, 3));
    assertSorted(intList(3, 2, 2, 1), intList(1, 2, 2, 3));
    assertSortBigList(1000000);
  }

  private void assertSortBigList(int n) {
    List<Integer> unsorted = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      unsorted.add((int) (Math.random() * 1000000.0));
    }
    List<Integer> sorted = sort(unsorted);
    for (int i = 0; i < n - 1; i++) {
      assertTrue(sorted.get(i) <= sorted.get(i + 1));
    }
  }

  public List<Integer> sort(List<Integer> list) {
    if (list.size() == 0) {
      return list;
    }

    int pivotIdx = (int) (Math.random() * list.size());
    Integer m = list.get(pivotIdx);

    List<Integer> l = new ArrayList<>();
    List<Integer> h = new ArrayList<>();
    fillHighAndLowLists(list, m, 0, pivotIdx, l, h);
    fillHighAndLowLists(list, m, pivotIdx + 1, list.size(), l, h);

    List<Integer> sorted = new ArrayList<>();
    sorted.addAll(sort(l));
    sorted.add(m);
    sorted.addAll(sort(h));
    return sorted;
  }

  private void fillHighAndLowLists(List<Integer> list, Integer m, int fromIndex, int toIndex, List<Integer> l, List<Integer> h) {
    for (int value : list.subList(fromIndex, toIndex)) {
      if (value > m) {
        h.add(value);
      } else {
        l.add(value);
      }
    }
  }

  /*public List<Integer> sort(List<Integer> list) {
    for (int size = list.size(); size > 0; size--)
      for (int index = 0; size > index + 1; index++) {
        if (isOutOfOrder(list, index)) {
          swap(list, index);
        }
      }
    return list;
  }

  private boolean isOutOfOrder(List<Integer> list, int index) {
    return list.get(index) > list.get(index + 1);
  }

  private void swap(List<Integer> list, int index) {
    int temp = list.get(index);
    list.set(index, list.get(index + 1));
    list.set(index + 1, temp);
  }*/
}
