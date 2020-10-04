package Enums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum ScaleIntervals {
  MAJ(new HashSet<Interval>(Arrays.asList(Interval.SAME, Interval.MAJ2, Interval.MAJ3, Interval.PERF4, Interval.PERF5, Interval.MAJ6, Interval.MAJ7)));

  private Set<Interval> degrees;

  ScaleIntervals(Set<Interval> degrees) {
    this.degrees = degrees;
  }

  public Set<Interval> getDegrees() {
    return degrees;
  }
}
