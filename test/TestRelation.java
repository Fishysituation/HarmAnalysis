import Enums.*;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestRelation {


  @Test
  public void testGetRelation() {
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

    assertEquals(bhdim.getRelation(cscale).get(), new Relation(Interval.MAJ7, cscale, bhdim));
    assertEquals(amin.getRelation(cscale).get(), new Relation(Interval.MAJ6, cscale, amin));
    assertEquals(cmaj.getRelation(cscale).get(), new Relation(Interval.SAME, cscale, cmaj));
    assertEquals(dmin.getRelation(cscale).get(), new Relation(Interval.MAJ2, cscale, dmin));
    assertEquals(emin.getRelation(cscale).get(), new Relation(Interval.MAJ3, cscale, emin));
    assertEquals(fmaj.getRelation(cscale).get(), new Relation(Interval.PERF4, cscale, fmaj));
    assertEquals(gmaj.getRelation(cscale).get(), new Relation(Interval.PERF5, cscale, gmaj));
    assertEquals(csmin.getRelation(cscale), Optional.empty());
    assertEquals(fsmin.getRelation(cscale), Optional.empty());


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
