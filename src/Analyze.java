public final class Analyze {

  public static int TEMPERAMENT = 12;

  //ignores pitch, only looks at relation between note names (order n1, n2 matters)
  public static Interval getInterval(NoteName note1, NoteName note2) {
    return Interval.getFromSize((note1.getValue() - note2.getValue() + TEMPERAMENT) % TEMPERAMENT);
  }

  //get the smaller equivalent of the interval
  public static Interval getSmallerInterval(Interval interval) {
    if (interval.getSize() <= TEMPERAMENT/2) {
      return interval;
    }
    return Interval.getFromSize(interval.getSize() - 2 * (interval.getSize() - TEMPERAMENT/2));
  }
}
