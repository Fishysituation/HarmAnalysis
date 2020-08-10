import static org.junit.Assert.*;

import Enums.Extension;
import Enums.NoteName;
import Enums.Triad;
import org.junit.Test;


public class TestChord {
  @Test
  public void testToString() throws Exception {
    Chord majTri = new Chord(NoteName.C, Triad.MAJ, Extension.NONE);
    Chord minTri = new Chord(NoteName.C, Triad.MIN, Extension.NONE);
    Chord dom7 = new Chord(NoteName.C, Triad.MAJ, Extension.MIN7);
    Chord min7 = new Chord(NoteName.C, Triad.MIN, Extension.MIN7);
    Chord minmaj7 = new Chord(NoteName.C, Triad.MIN, Extension.MAJ7);

    assertTrue(majTri.toString().equals("C"));
    assertTrue(minTri.toString().equals("C-"));
    assertTrue(dom7.toString().equals("C7"));
    assertTrue(min7.toString().equals("C-7"));
    assertTrue(minmaj7.toString().equals("C-maj7"));
  }
}
