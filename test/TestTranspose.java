import Enums.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;


public class TestTranspose {

  @Test
  public void testTransposeScale() {
    Scale cmaj = new Scale(NoteName.C, ScaleIntervals.MAJ);
    assertTrue(cmaj.getRoot().equals(NoteName.C));
    cmaj.transpose(Interval.MAJ3);
    assertTrue(cmaj.getRoot().equals(NoteName.E));
    cmaj.transpose(Interval.PERF5);
    assertTrue(cmaj.getRoot().equals(NoteName.B));
  }

  @Test
  public void testTransposeChord() {
    Chord c = new Chord(NoteName.C, Triad.MAJ, Extension.NONE);
    assertTrue(c.getRoot().equals(NoteName.C));
    c.transpose(Interval.MAJ3);
    assertTrue(c.getRoot().equals(NoteName.E));
    c.transpose(Interval.PERF5);
    assertTrue(c.getRoot().equals(NoteName.B));
  }

  @Test
  public void testTransposeSong() {
    Chord ii = new Chord(NoteName.D, Triad.MIN, Extension.NONE);
    Chord v = new Chord(NoteName.G, Triad.MAJ, Extension.NONE);
    Chord i = new Chord(NoteName.C, Triad.MAJ, Extension.NONE);
    Song song = new Song(Arrays.asList(ii, v, i));

    song.transpose(Interval.MAJ3);
    List<Chord> E = song.getChords();
    assertTrue(E.get(0).getRoot().equals(NoteName.FS));
    assertTrue(E.get(1).getRoot().equals(NoteName.B));
    assertTrue(E.get(2).getRoot().equals(NoteName.E));

    song.transpose(Interval.PERF5);
    List<Chord> B = song.getChords();
    assertTrue(E.get(0).getRoot().equals(NoteName.CS));
    assertTrue(E.get(1).getRoot().equals(NoteName.FS));
    assertTrue(E.get(2).getRoot().equals(NoteName.B));
  }
}
