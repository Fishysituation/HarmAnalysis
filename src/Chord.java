import Enums.Extension;
import Enums.Interval;
import Enums.NoteName;
import Enums.Triad;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

// instance is a labelling of a chord
public class Chord extends Structure {

  private final Triad triad;
  private final Extension extension;

  // TODO - change extension to set of extensions
  public Chord(NoteName root, Triad triad, Extension extension) {
    this.root = root;
    this.triad = triad;
    this.extension = extension;
  }

  public Triad getTriad() {
    return this.triad;
  }

  public Extension getExtension() {
    return this.extension;
  }

  public Set<NoteName> getNotes() {
    Set<Interval> intervals = new HashSet<>();
    intervals.addAll(triad.getIntervals());
    intervals.add(extension.getInterval());
    Set<NoteName> notes = new HashSet<NoteName>();
    notes.add(root);
    intervals.forEach(i -> notes.add(root.addInterval(i)));
    return notes;
  }

  //return true iff all chord notes are in the scale
  public boolean chordIsStrictlyIn(Scale scale) {
    for (NoteName note : getNotes()) {
      if (!scale.contains(note)) {
        System.out.println(note.toString());
        return false;
      }
    }
    return true;
  }

  public Optional<Relation> getRelation(Scale scale) {
    if (chordIsStrictlyIn(scale)) {
      return Optional.of(new Relation(Interval.MAJ3, scale, this));
    }
    return Optional.empty();
  }

  // TODO - implement to be equal if has same function? e.g. bII7 equals V7
  @Override
  public boolean equals(Object other) {
    return super.equals(other);
  }

  @Override
  public String toString() {
    return root.toString() + triad.toString() + extension.toString();
  }
}
