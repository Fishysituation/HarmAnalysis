package Enums;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Triad {
  MAJ("", new HashSet<Interval>(Arrays.asList(Interval.MAJ3, Interval.PERF5))),
  MIN("-", new HashSet<Interval>(Arrays.asList(Interval.MIN3, Interval.PERF5))),
  DIM("o", new HashSet<Interval>(Arrays.asList(Interval.MIN3, Interval.AUG4)));

  private String rep;
  private Set<Interval> intervals;

  Triad(String rep, Set<Interval> intervals) {
    this.rep = rep;
    this.intervals = intervals;
  }

  public Set<Interval> getIntervals() {
    return intervals;
  }

  @Override
  public String toString() {
    return rep;
  }
}
