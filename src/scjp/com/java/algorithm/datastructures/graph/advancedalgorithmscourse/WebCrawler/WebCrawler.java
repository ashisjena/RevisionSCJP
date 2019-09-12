package scjp.com.java.algorithm.datastructures.graph.advancedalgorithmscourse.WebCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    private Queue<String> queue;
    private List<String> discoveredWebsitesList;

    public WebCrawler() {
        this.queue = new LinkedList<>();
        this.discoveredWebsitesList = new ArrayList<>();
    }

    public void discoveredWeb(String root) {
        this.queue.offer(root);
        this.discoveredWebsitesList.add(root);

        while (!this.queue.isEmpty()) {
            String v = this.queue.poll();
            String rawHtml = readURL(v);

            String regexp = "http[s]+://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(rawHtml);

            while (matcher.find()) {
                String actualUrl = matcher.group();

                if (!discoveredWebsitesList.contains(actualUrl)) {
                    discoveredWebsitesList.add(actualUrl);
                    System.out.println("Website has been found with URL: " + actualUrl);
                    queue.add(actualUrl);
                }
            }
        }
    }

    private String readURL(String v) {
        String rawHTML = "";

        try {
            URL url = new URL(v);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                rawHTML += inputLine;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rawHTML;
    }

}
