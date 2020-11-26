import Enums.Interval;
import Enums.NoteName;

public final class Analyze {

  public static int TEMPERAMENT = 12;

  // ignores pitch, returns the interval of note1 up to note2
  public static Interval getLogicalInterval(NoteName note1, NoteName note2) {
    return Interval.getFromSize(((note2.getValue() + TEMPERAMENT ) - note1.getValue()) % TEMPERAMENT);
  }

  // get the actual interval "mod 12"
  public static Interval getActualInterval(Note note1, Note note2) {
    // if second note has higher pitch
    if (note2.compareTo(note1) > 0) {
      return getActualInterval(note2, note1);
    }
    return Interval.getFromSize(
        (note1.getName().getValue() - note2.getName().getValue() + TEMPERAMENT) % TEMPERAMENT);
  }

  // get the smaller equivalent of the interval
  public static Interval getSmallerInterval(Interval interval) {
    if (interval.getSize() <= TEMPERAMENT / 2) {
      return interval;
    }
    return Interval.getFromSize(interval.getSize() - 2 * (interval.getSize() - TEMPERAMENT / 2));
  }
}
