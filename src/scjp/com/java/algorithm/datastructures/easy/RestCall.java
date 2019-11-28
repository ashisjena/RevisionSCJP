package scjp.com.java.algorithm.datastructures.easy;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class RestCall {
  static String[] getMovieTitles(String substr) throws IOException {
    int pageNo = 1;
    int totalPages;

    List<String> titles = new ArrayList<>();
    do {
      HttpURLConnection conn = null;
      try {
        URL url = new URL(String.format("https://jsonmock.hackerrank.com/api/movies/search/?Title=%s&page=%d", substr, pageNo));
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
          break;
        }
        String result = new BufferedReader(new InputStreamReader((conn.getInputStream()))).lines().reduce("", (acc, line) -> acc + line);
        JsonObject jsonObj = JsonParser.parseString(result).getAsJsonObject();
        totalPages = jsonObj.get("total_pages").getAsInt();
        jsonObj.get("data").getAsJsonArray().forEach(jsonElement -> titles.add(jsonElement.getAsJsonObject().get("Title").getAsString()));

        pageNo++;
      } finally {
        if (conn != null) {
          conn.disconnect();
        }
      }
    } while (pageNo <= totalPages);

    Collections.sort(titles);
    String[] result = new String[titles.size()];
    return titles.toArray(result);
  }

  @Test
  public void getMovieTitlesTest() throws IOException {
    assertArrayEquals(new String[]{
                    "Amazing Spiderman Syndrome",
                    "Fighting, Flying and Driving: The Stunts of Spiderman 3",
                    "Hollywood's Master Storytellers: Spiderman Live",
                    "Italian Spiderman",
                    "Spiderman",
                    "Spiderman",
                    "Spiderman 5",
                    "Spiderman and Grandma",
                    "Spiderman in Cannes",
                    "Superman, Spiderman or Batman",
                    "The Amazing Spiderman T4 Premiere Special",
                    "The Death of Spiderman",
                    "They Call Me Spiderman"},
            getMovieTitles("spiderman"));
  }
}
