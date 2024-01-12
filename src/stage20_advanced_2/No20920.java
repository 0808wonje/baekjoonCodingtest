package stage20_advanced_2;

import java.io.*;
import java.util.*;

public class No20920 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);
    Set<String> set = new HashSet<>();
    List<Word> wordList = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      if (word.length() < m) {
        continue;
      }
      if (set.contains(word)) {
        map.replace(word, map.get(word) + 1);
        continue;
      }
      set.add(word);
      map.put(word, 1);
    }

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      wordList.add(new Word(entry.getKey(), entry.getValue()));
    }
    wordList.sort(wordComparator);
    StringBuilder sb = new StringBuilder();
    for (Word word : wordList) {
      sb.append(word.getName()).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static class Word {
    private String name;
    private int repeat;

    public Word(String name, int repeat) {
      this.name = name;
      this.repeat = repeat;
    }

    public String getName() {
      return name;
    }

    public int getRepeat() {
      return repeat;
    }

  }

  static Comparator<Word> wordComparator = (o1, o2) -> {
    if (o1.getRepeat() == o2.getRepeat()) {
      if (o1.getName().length() == o2.getName().length()) { // 글자수 까지 같으면
        return o1.getName().compareTo(o2.getName()); // 사전순 오름차
      }
      return o2.getName().length() - o1.getName().length(); // 반복횟수가 같으면 글자 길이로 내림차
    }
    return o2.getRepeat() -o1.getRepeat(); // 반복횟수로 내림차
  };
}
