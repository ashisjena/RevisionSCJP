package scjp.com.java.algorithm.companies.DeemSoftware;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CandiateCode {
  public static void main(String args[]) throws Exception {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String scores = reader.readLine();

    List<Integer> houseScoreList = new ArrayList<>();
    for (String score : scores.split(" ")) {
      houseScoreList.add(Integer.parseInt(score));
    }

    int josephHouseNo = Integer.parseInt(reader.readLine());

    List<Integer> newScores = new ArrayList<>();

    for (int i = 0; i < houseScoreList.size(); i++) {
      int prevHouseScore = getPreviousHouseScore(i, houseScoreList);
      int nexHouseScore = getNextHouseScore(i, houseScoreList);
      newScores.add(prevHouseScore + houseScoreList.get(i) + nexHouseScore);
    }

    if(houseScoreList.get(josephHouseNo - 1) == 3) {
      System.out.println(1);
    } else if(houseScoreList.get(josephHouseNo - 1) == 0) {
      System.out.println(0);
    } else {
      System.out.println(-1);
    }

  }

  private static int getNextHouseScore(int i, List<Integer> houseScoreList) {
    if (i < houseScoreList.size() - 1) {
      return houseScoreList.get(i + 1);
    } else {
      return 0;
    }
  }

  private static int getPreviousHouseScore(int i, List<Integer> houseScoreList) {
    if (i > 0) {
      return houseScoreList.get(i - 1);
    } else {
      return 0;
    }
  }
}
