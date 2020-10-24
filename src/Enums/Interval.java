package Enums;

public enum Interval {
  SAME(0, "-", "I"),
  MIN2(1, "m2", "bII"),
  MAJ2(2, "2", "II"),
  MIN3(3, "m3", "bIII"),
  MAJ3(4, "3", "III"),
  PERF4(5, "4", "IV"),
  AUG4(6, "#4", "bV"),
  PERF5(7, "5", "V"),
  MIN6(8, "m6", "bVI"),
  MAJ6(9, "6", "VI"),
  MIN7(10, "m7", "bVII"),
  MAJ7(11, "7", "VII");

  private int size;
  private String name;
  private String roman;

  Interval(int size, String name, String roman) {
    this.size = size;
    this.name = name;
    this.roman = roman;
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

  public String getRoman() {
    return roman;
  }
}
