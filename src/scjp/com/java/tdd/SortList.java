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
    assertSorted(intList(1, 3, 2), intList(1, 2, 3));
    assertSorted(intList(3, 2, 1), intList(1, 2, 3));
    assertSortBigList(5000);
  }

  private void assertSortBigList(int n) {
    List<Integer> unsorted = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      unsorted.add((int) (Math.random() * 10000.0));
    }
    List<Integer> sorted = sort(unsorted);
    for (int i = 0; i < n - 1; i++) {
      assertTrue(sorted.get(i) <= sorted.get(i + 1));
    }
  }

  public List<Integer> sort(List<Integer> list) {
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
  }
}
