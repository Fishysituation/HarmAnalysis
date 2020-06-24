import static org.junit.Assert.*;

import org.junit.Test;

public class TestInterval {
  @Test
  public void testGetInterval() throws Exception {
    assertEquals(Interval.MIN6, Analyze.getInterval(NoteName.A, NoteName.CS));
    assertEquals(Interval.MAJ3, Analyze.getInterval(NoteName.CS, NoteName.A));
    assertEquals(Interval.PERF4, Analyze.getInterval(NoteName.A, NoteName.E));
    assertEquals(Interval.PERF5, Analyze.getInterval(NoteName.E, NoteName.A));
  }

  @Test
  public void testGetSmallerInterval() throws Exception {
    assertEquals(Interval.MAJ3, Analyze.getSmallerInterval(Analyze.getInterval(NoteName.A, NoteName.CS)));
    assertEquals(Interval.MAJ3, Analyze.getSmallerInterval(Analyze.getInterval(NoteName.CS, NoteName.A)));

    assertEquals(Interval.AUG4, Analyze.getSmallerInterval(Analyze.getInterval(NoteName.A, NoteName.DS)));
    assertEquals(Interval.AUG4, Analyze.getSmallerInterval(Analyze.getInterval(NoteName.DS, NoteName.A)));
  }
}