package scjp.com.java.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class ConsoleReader implements AutoCloseable {
  private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private StringTokenizer st;

  public String readLine() {
    try {
      return this.br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public int readInt() {
    return Integer.parseInt(next());
  }

  public long readLong() {
    return Long.parseLong(next());
  }

  public double readDouble() {
    return Double.parseDouble(next());
  }

  public String readLetter() {
    return next();
  }

  private String next() {
    while (st == null || !st.hasMoreElements()) {
      st = new StringTokenizer(readLine());
    }
    return st.nextToken();
  }

  private Stream<String> getLineStream() {
    Stream<String> stream = Arrays.stream(readLine().split("\\s+"));
    return stream;
  }

  public int[] readLineIntArr() {
    return getLineStream().mapToInt(Integer::parseInt).toArray();
  }

  public long[] readLineLongArr() {
    return getLineStream().mapToLong(Long::parseLong).toArray();
  }

  public double[] readLineDoubleArr() {
    return getLineStream().mapToDouble(Double::parseDouble).toArray();
  }

  @Override
  public void close() throws IOException {
    this.br.close();
  }
}