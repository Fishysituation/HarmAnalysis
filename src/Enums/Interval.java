package Enums;

public enum Interval {
  SAME(0, "-"),
  MIN2(1, "m2"),
  MAJ2(2, "2"),
  MIN3(3, "m3"),
  MAJ3(4, "3"),
  PERF4(5, "4"),
  AUG4(6, "#4"),
  PERF5(7, "5"),
  MIN6(8, "m6"),
  MAJ6(9, "6"),
  MIN7(10, "m7"),
  MAJ7(11, "7");

  private int size;
  private String name;

  Interval(int size, String name) {
    this.size = size;
    this.name = name;
  }

  public static Interval getFromSize(int size) {
    return Interval.values()[size];
  }

  public int getSize() {
    return size;
  }

  public String getName() {
    return name;
  }
}
