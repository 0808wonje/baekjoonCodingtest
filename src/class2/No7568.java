package class2;

import java.io.*;
import java.util.Comparator;

public class No7568 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    Student[] arr = new Student[n];
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      arr[i] = new Student(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (j == i) {
          continue;
        }
        if (comparator.compare(arr[i], arr[j]) == 1) {
          arr[i].setRank(arr[i].getRank() + 1);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (Student student : arr) {
      sb.append(student.getRank()).append(" ");
    }
    bw.write(sb.toString());
    bw.flush();
  }

  static class Student {
    private int weight;
    private int height;
    private int rank = 1;

    public Student(int weight, int height) {
      this.weight = weight;
      this.height = height;
    }

    public int getWeight() {
      return weight;
    }

    public int getHeight() {
      return height;
    }

    public int getRank() {
      return rank;
    }

    public void setRank(int rank) {
      this.rank = rank;
    }
  }

  static Comparator<Student> comparator = (student1, student2) -> {
    if (student1.getWeight() > student2.getWeight() && student1.getHeight() > student2.getHeight()) {
      return -1;
    } else if (student1.getWeight() < student2.getWeight() && student1.getHeight() < student2.getHeight()) {
      return 1;
    } else if (student1.getWeight() > student2.getWeight() && student1.getHeight() == student2.getHeight()) {
      return 0;
    } else if (student1.getWeight() < student2.getWeight() && student1.getHeight() == student2.getHeight()) {
      return 0;
    } else if (student1.getWeight() == student2.getWeight() && student1.getHeight() > student2.getHeight()) {
      return 0;
    } else if (student1.getWeight() == student2.getWeight() && student1.getHeight() < student2.getHeight()) {
      return 0;
    } else if (student1.getWeight() == student2.getWeight() && student1.getHeight() == student2.getHeight()) {
      return 0;
    } else if (student1.getWeight() < student2.getWeight() && student1.getHeight() > student2.getHeight()) {
      return 0;
    } else if (student1.getWeight() > student2.getWeight() && student1.getHeight() < student2.getHeight()) {
      return 0;
    }
    return 0;
  };
}
