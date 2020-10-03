package Enums;

public enum Extension {
  NONE("", null),
  MIN7("7", Interval.MIN7),
  MAJ7("maj7", Interval.MAJ7);

  private String rep;
  private Interval interval;

  Extension(String rep, Interval interval) {
    this.rep = rep;
    this.interval = interval;
  }

  public Interval getInterval() {
    return interval;
  }

  @Override
  public String toString() {
    return rep;
  }
}
