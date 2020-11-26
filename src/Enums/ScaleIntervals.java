package Enums;

import java.util.*;

public enum ScaleIntervals {
  MAJ("maj", new ArrayList<Interval>(Arrays.asList(Interval.SAME, Interval.MAJ2, Interval.MAJ3, Interval.PERF4, Interval.PERF5, Interval.MAJ6, Interval.MAJ7)));

  private String name;
  private List<Interval> degrees;

  ScaleIntervals(String name, List<Interval> degrees) {
    this.name = name;
    this.degrees = degrees;
  }

  public List<Interval> getDegrees() {
    return degrees;
  }

  public String getName() {
    return name;
  }
}
