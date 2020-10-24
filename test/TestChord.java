import static org.junit.Assert.*;

import Enums.Extension;
import Enums.NoteName;
import Enums.ScaleIntervals;
import Enums.Triad;
import org.junit.Test;

import java.util.Set;


public class TestChord {
  @Test
  public void testToString() throws Exception {
    Chord majTri = new Chord(NoteName.C, Triad.MAJ, Extension.NONE);
    Chord minTri = new Chord(NoteName.C, Triad.MIN, Extension.NONE);
    Chord dom7 = new Chord(NoteName.C, Triad.MAJ, Extension.MIN7);
    Chord min7 = new Chord(NoteName.C, Triad.MIN, Extension.MIN7);
    Chord minmaj7 = new Chord(NoteName.C, Triad.MIN, Extension.MAJ7);
    Chord halfDim = new Chord(NoteName.C, Triad.DIM, Extension.MIN7);

    assertTrue(majTri.toString().equals("C"));
    assertTrue(minTri.toString().equals("C-"));
    assertTrue(dom7.toString().equals("C7"));
    assertTrue(min7.toString().equals("C-7"));
    assertTrue(minmaj7.toString().equals("C-maj7"));
    assertTrue(halfDim.toString().equals("Co7"));
  }

  @Test
  public void testGetNotes() throws Exception {
    Chord dom7 = new Chord(NoteName.C, Triad.MAJ, Extension.MIN7);
    Chord min7 = new Chord(NoteName.C, Triad.MIN, Extension.MIN7);
    Chord minmaj7 = new Chord(NoteName.C, Triad.MIN, Extension.MAJ7);
    Chord halfDim = new Chord(NoteName.C, Triad.DIM, Extension.MIN7);

    Set<NoteName> set7 = dom7.getNotes();
    Set<NoteName> setM7 = min7.getNotes();
    Set<NoteName> setMm7 = minmaj7.getNotes();
    Set<NoteName> seto7 = halfDim.getNotes();

    assertTrue(set7.contains(NoteName.C));
    assertTrue(set7.contains(NoteName.E));
    assertTrue(set7.contains(NoteName.G));
    assertTrue(set7.contains(NoteName.AS));

    assertTrue(setM7.contains(NoteName.C));
    assertTrue(setM7.contains(NoteName.DS));
    assertTrue(setM7.contains(NoteName.G));
    assertTrue(setM7.contains(NoteName.AS));

    assertTrue(setMm7.contains(NoteName.C));
    assertTrue(setMm7.contains(NoteName.DS));
    assertTrue(setMm7.contains(NoteName.G));
    assertTrue(setMm7.contains(NoteName.B));

    assertTrue(seto7.contains(NoteName.C));
    assertTrue(seto7.contains(NoteName.DS));
    assertTrue(seto7.contains(NoteName.FS));
    assertTrue(seto7.contains(NoteName.AS));
  }

  @Test
  public void testChordContains() throws Exception {
    Chord minmaj7 = new Chord(NoteName.C, Triad.MIN, Extension.MAJ7);
    assertTrue(minmaj7.contains(NoteName.C));
    assertTrue(minmaj7.contains(NoteName.DS));
    assertTrue(minmaj7.contains(NoteName.G));
    assertTrue(minmaj7.contains(NoteName.B));
    assertFalse(minmaj7.contains(NoteName.CS));
    assertFalse(minmaj7.contains(NoteName.GS));
  }

  @Test
  public void testChordisStrictlyIn() {
    Chord cmaj = new Chord(NoteName.C, Triad.MAJ, Extension.MAJ7);
    Chord dmin = new Chord(NoteName.D, Triad.MIN, Extension.MIN7);
    Chord emin = new Chord(NoteName.E, Triad.MIN, Extension.MIN7);
    Chord fmaj = new Chord(NoteName.F, Triad.MAJ, Extension.MAJ7);
    Chord gmaj = new Chord(NoteName.G, Triad.MAJ, Extension.MIN7);
    Chord amin = new Chord(NoteName.A, Triad.MIN, Extension.MIN7);
    Chord bhdim = new Chord(NoteName.B, Triad.DIM, Extension.MIN7);
    Chord csmin = new Chord(NoteName.CS, Triad.MIN, Extension.MIN7);
    Chord fsmin = new Chord(NoteName.FS, Triad.MIN, Extension.MIN7);

    Scale cscale = new Scale(NoteName.C, ScaleIntervals.MAJ);

    assertTrue(cmaj.chordIsStrictlyIn(cscale));
    assertTrue(dmin.chordIsStrictlyIn(cscale));
    assertTrue(emin.chordIsStrictlyIn(cscale));
    assertTrue(fmaj.chordIsStrictlyIn(cscale));

    assertTrue(gmaj.chordIsStrictlyIn(cscale));

    assertTrue(amin.chordIsStrictlyIn(cscale));
    assertTrue(bhdim.chordIsStrictlyIn(cscale));
    assertFalse(csmin.chordIsStrictlyIn(cscale));
    assertFalse(fsmin.chordIsStrictlyIn(cscale));
  }
}
