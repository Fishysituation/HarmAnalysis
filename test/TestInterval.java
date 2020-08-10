import static org.junit.Assert.*;

import Enums.Interval;
import Enums.NoteName;
import org.junit.Test;

public class TestInterval {
  @Test
  public void testGetLogicalInterval() throws Exception {
    assertEquals(Interval.MIN6, Analyze.getLogicalInterval(NoteName.A, NoteName.CS));
    assertEquals(Interval.MAJ3, Analyze.getLogicalInterval(NoteName.CS, NoteName.A));
    assertEquals(Interval.PERF4, Analyze.getLogicalInterval(NoteName.A, NoteName.E));
    assertEquals(Interval.PERF5, Analyze.getLogicalInterval(NoteName.E, NoteName.A));
  }

  @Test
  public void testGetSmallerInterval() throws Exception {
    assertEquals(Interval.MAJ3, Analyze.getSmallerInterval(Analyze.getLogicalInterval(NoteName.A, NoteName.CS)));
    assertEquals(Interval.MAJ3, Analyze.getSmallerInterval(Analyze.getLogicalInterval(NoteName.CS, NoteName.A)));

    assertEquals(Interval.AUG4, Analyze.getSmallerInterval(Analyze.getLogicalInterval(NoteName.A, NoteName.DS)));
    assertEquals(Interval.AUG4, Analyze.getSmallerInterval(Analyze.getLogicalInterval(NoteName.DS, NoteName.A)));
  }

  @Test
  public void testGetActualInterval() throws Exception {
    Note note1 = new Note(NoteName.FS, 4);
    Note note2 = new Note(NoteName.A, 5);
    Note note3 = new Note(NoteName.E, 5);
    Note note4 = new Note(NoteName.CS, 6);

    assertEquals(Interval.MIN3, Analyze.getActualInterval(note1, note2));
    assertEquals(Interval.MIN3, Analyze.getActualInterval(note2, note1));

    assertEquals(Interval.PERF4, Analyze.getActualInterval(note3, note2));
    assertEquals(Interval.PERF4, Analyze.getActualInterval(note2, note3));

    assertEquals(Interval.MAJ3, Analyze.getActualInterval(note4, note2));
  }
}