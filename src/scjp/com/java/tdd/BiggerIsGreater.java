package scjp.com.java.tdd;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class BiggerIsGreater {

  final static String NO_ANSWER = "no answer";

  @Test
  public void getNextLargestWordTest() {
    assertEquals(NO_ANSWER, getNextLargestWord("a"));
    assertEquals(NO_ANSWER, getNextLargestWord("aa"));
    assertEquals("ba", getNextLargestWord("ab"));
    assertEquals("acb", getNextLargestWord("abc"));
    assertEquals("bac", getNextLargestWord("acb"));
    assertEquals("cab", getNextLargestWord("bca"));
    assertEquals(NO_ANSWER, getNextLargestWord("cba"));
    assertEquals("cba", getNextLargestWord("cab"));
    assertEquals("cba", getNextLargestWord("cab"));
    assertEquals("acbd", getNextLargestWord("abdc"));
    assertEquals("adbc", getNextLargestWord("acdb"));
    assertEquals("xildrrpach", getNextLargestWord("xildrrhpca"));
    for (int i = 0; i < inputs.size(); i++) {
      assertEquals(outputs.get(i), getNextLargestWord(inputs.get(i)));
    }
  }

  private String getNextLargestWord(String word) {
    List<Character> chars = word.chars().mapToObj(ch -> (char) ch).collect(Collectors.toList());

    int start = Integer.MIN_VALUE, end = 0;
    for (int j = chars.size() - 1; j > 0 && j > start; j--) {
      for (int i = j - 1; i >= 0 && i > start; i--) {
        if (chars.get(j) > chars.get(i)) {
          start = i;
          end = j;
        }
      }
    }

    if (end != 0) {
      List<Character> first = chars.subList(0, start);
      List<Character> middle = chars.subList(start, end);
      List<Character> last = chars.subList(end + 1, chars.size());

      return Stream.of(first.stream(), Stream.of(chars.get(end)), Stream.of(last, middle).flatMap(List::stream).sorted()).
          flatMap(it -> it.map(String::valueOf)).
          collect(Collectors.joining());
    }

    return NO_ANSWER;
  }

  private List<String> outputs = Stream.of(
      "imllmmcslslkyoegyoam",
      "fvincndjrurhf",
      "rtglgzzqxnuflitnlyti",
      "mhtvaqofxtyzr",
      "zalqxykemvzzgkaa",
      "wjjulziszbqqdcpdnhod",
      "japjbvjlxzkgietmk",
      "jqczvgqywydkunmwj",
      "ehdegnmorgafrjxvsck",
      "tydwixlwghlomq",
      "wddnwjneaxbwhwarm",
      "pnimbesirfbixlv",
      "mijamkzpiiniveki",
      "qxtwpdpwexuje",
      "qtcshorwykc",
      "xoojiggdcyjrurp",
      "vcjmvngcdyabcmzj",
      "xildrrpach",
      "rrcntnbqchsfhvjhi",
      "kmotatmrabtcoum",
      "bnfcejmyotwv",
      "dnppdkpywiaxddoxq",
      "tmowsxkrodmkrak",
      "jfkaehlegowfggh",
      "ttylsiegnttymxty",
      "kyetllczuyibdkwyiqhr",
      "xdhqbvlbtmmtshejff",
      "kpdpzzohihzwgdgbfz",
      "kuywptftpaaa",
      "qfqpegznnyludvr",
      "ufwogufbzaboaepsliqk",
      "jfejqapjvbdcxtkyr",
      "sypjbvatgiodddxy",
      "wdpfyqjcpnc",
      "baabpjckkyturd",
      "uvwurzjyzbhcqmryprqa",
      "kvtwtmqygksbmi",
      "ivsjycnooeodwtp",
      "zqyxjnnitzawipsmq",
      "blmrzavodtfzyezp",
      "bmqlhqndavc",
      "phvauobwkrcfwdedcs",
      "vpygyqubqywkndhwpz",
      "yikanhdrwjx",
      "vnpblfxmvwkflqokbr",
      "pserilwzxwyorldsxlks",
      "qymbqaehnyzhfqpqrlpp",
      "fcakwzuqlzglnidbkmq",
      "jkscckttaeifiksgkxmx",
      "dkbllravwnhhfjjrec",
      "imzsyrykfvtj",
      "tvogoocldlukwfcajvxi",
      "cvnagtypozljprajglv",
      "hwcmacxvsmu",
      "rhrzcpprqcfc",
      "clppxvwtaktchqrfdi",
      "qwusnlldnolqh",
      "yitverajov",
      "arciyxaxtvmfgqwbu",
      "pzbxvxdjuuvvu",
      "nxfowilpdxwltp",
      "swzsaynxbytyttqq",
      "qyrogefletey",
      "iotjgthvslvmjpcchufh",
      "knfpyjtzqf",
      "tmtbfayantwkm",
      "asxwzygnngw",
      "rmwiwrurutb",
      "bhmpfwhgqfcqfldlsh",
      "yhbidtewppg",
      "jwwbeuiklpodziiv",
      "anjhprmkwieb",
      "lpwhqaebrm",
      "dunecynelymcpyonqj",
      "hblfldireuivzekegti",
      "uryygzpwifrriecgvw",
      "kzuhaysegaxtwqtxv",
      "kvarmrbpoxxujhvgwp",
      "hanhaggqzdpunkugzmqh",
      "gnwqwsylqeurq",
      "qzkjbnyvclrkmtcd",
      "argsnaqbqvu",
      "obbnlkoaklxc",
      "ojiilqieycsasvqosyuc",
      "qhlgiwsmtxbffjtsx",
      "vvrvnmndeopgy",
      "ibeqzyeuvzbf",
      "sajpyegttujyxx",
      "zmdjphzogfldlkgbchtn",
      "tbanvjmwixrx",
      "gmdhdlmopzyvddeyajjq",
      "yxvmvedubzdcp",
      "soygdzhbckkfu",
      "gkbekyrhwcc",
      "wevzqpnqwtpuf",
      "rbobquotbysufwqjoe",
      "bpgqfwoyntuhkwov",
      "schtabphairewhfpm",
      "rlmrahlisggguykue",
      "fjtfrmlqvseqk"
  ).collect(Collectors.toList());

  private List<String> inputs = Stream.of(
      "imllmmcslslkyoegymoa",
      "fvincndjrurfh",
      "rtglgzzqxnuflitnlyit",
      "mhtvaqofxtyrz",
      "zalqxykemvzzgaka",
      "wjjulziszbqqdcpdnhdo",
      "japjbvjlxzkgietkm",
      "jqczvgqywydkunmjw",
      "ehdegnmorgafrjxvksc",
      "tydwixlwghlmqo",
      "wddnwjneaxbwhwamr",
      "pnimbesirfbivxl",
      "mijamkzpiiniveik",
      "qxtwpdpwexuej",
      "qtcshorwyck",
      "xoojiggdcyjrupr",
      "vcjmvngcdyabcmjz",
      "xildrrhpca",
      "rrcntnbqchsfhvijh",
      "kmotatmrabtcomu",
      "bnfcejmyotvw",
      "dnppdkpywiaxddoqx",
      "tmowsxkrodmkkra",
      "jfkaehlegohwggf",
      "ttylsiegnttymtyx",
      "kyetllczuyibdkwyihrq",
      "xdhqbvlbtmmtshefjf",
      "kpdpzzohihzwgdfzgb",
      "kuywptftapaa",
      "qfqpegznnyludrv",
      "ufwogufbzaboaepslikq",
      "jfejqapjvbdcxtkry",
      "sypjbvatgidyxodd",
      "wdpfyqjcpcn",
      "baabpjckkytudr",
      "uvwurzjyzbhcqmrypraq",
      "kvtwtmqygksbim",
      "ivsjycnooeodwpt",
      "zqyxjnnitzawipqsm",
      "blmrzavodtfzyepz",
      "bmqlhqndacv",
      "phvauobwkrcfwdecsd",
      "vpygyqubqywkndhpzw",
      "yikanhdrjxw",
      "vnpblfxmvwkflqobrk",
      "pserilwzxwyorldsxksl",
      "qymbqaehnyzhfqpqprpl",
      "fcakwzuqlzglnibqmkd",
      "jkscckttaeifiksgkmxx",
      "dkbllravwnhhfjjrce",
      "imzsyrykfvjt",
      "tvogoocldlukwfcajvix",
      "cvnagtypozljpragvlj",
      "hwcmacxvmus",
      "rhrzcpprqccf",
      "clppxvwtaktchqrdif",
      "qwusnlldnolhq",
      "yitveovrja",
      "arciyxaxtvmfgquwb",
      "pzbxvxdjuuvuv",
      "nxfowilpdxwlpt",
      "swzsaynxbytytqtq",
      "qyrogefleeyt",
      "iotjgthvslvmjpcchhuf",
      "knfpyjtzfq",
      "tmtbfayantmwk",
      "asxwzygngwn",
      "rmwiwrurubt",
      "bhmpfwhgqfcqfldlhs",
      "yhbidtewpgp",
      "jwwbeuiklpodvzii",
      "anjhprmkwibe",
      "lpwhqaebmr",
      "dunecynelymcpyonjq",
      "hblfldireuivzekegit",
      "uryygzpwifrricwvge",
      "kzuhaysegaxtwqtvx",
      "kvarmrbpoxxujhvgpw",
      "hanhaggqzdpunkugzmhq",
      "gnwqwsylqeuqr",
      "qzkjbnyvclrkmdtc",
      "argsnaqbquv",
      "obbnlkoaklcx",
      "ojiilqieycsasvqosycu",
      "qhlgiwsmtxbffjsxt",
      "vvrvnmndeogyp",
      "ibeqzyeuvfzb",
      "sajpyegttujxyx",
      "zmdjphzogfldlkgbchnt",
      "tbanvjmwirxx",
      "gmdhdlmopzyvddeqyjja",
      "yxvmvedubzcpd",
      "soygdzhbckfuk",
      "gkbekyrhcwc",
      "wevzqpnqwtpfu",
      "rbobquotbysufwqjeo",
      "bpgqfwoyntuhkvwo",
      "schtabphairewhfmp",
      "rlmrahlisggguykeu",
      "fjtfrmlqvsekq"
  ).collect(Collectors.toList());
}
