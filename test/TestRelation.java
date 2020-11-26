import Enums.*;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class TestRelation {

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

  Relation seventh = new Relation(cscale, bhdim);
  Relation sixth = new Relation(cscale, amin);
  Relation fifth = new Relation(cscale, gmaj);
  Relation fourth = new Relation(cscale, fmaj);
  Relation third = new Relation(cscale, emin);
  Relation second = new Relation(cscale,dmin);
  Relation root = new Relation(cscale, cmaj);

  @Test
  public void testGetRelation() {
    assertEquals(bhdim.getRelation(cscale).get(), seventh);
    assertEquals(amin.getRelation(cscale).get(), sixth);
    assertEquals(cmaj.getRelation(cscale).get(), root);
    assertEquals(dmin.getRelation(cscale).get(), second);
    assertEquals(emin.getRelation(cscale).get(), third);
    assertEquals(fmaj.getRelation(cscale).get(), fourth);
    assertEquals(gmaj.getRelation(cscale).get(), fifth);
    assertEquals(csmin.getRelation(cscale), Optional.empty());
    assertEquals(fsmin.getRelation(cscale), Optional.empty());
  }

  @Test
  public void testGetInterval() {
    assertEquals(Interval.MAJ7, seventh.getInterval());
    assertEquals(Interval.MAJ6, sixth.getInterval());
    assertEquals(Interval.PERF5, fifth.getInterval());
    assertEquals(Interval.PERF4, fourth.getInterval());
    assertEquals(Interval.MAJ3, third.getInterval());
    assertEquals(Interval.MAJ2, second.getInterval());
    assertEquals(Interval.SAME, root.getInterval());
  }


  @Test
  public void testGetScore() {
    assertEquals(1, seventh.getScore());
    assertEquals(2, sixth.getScore());
    assertEquals(4, fifth.getScore());
    assertEquals(3, fourth.getScore());
    assertEquals(1, third.getScore());
    assertEquals(2, second.getScore());
    assertEquals(5, root.getScore());
  }
}
