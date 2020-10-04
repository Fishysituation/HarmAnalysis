import Enums.Extension;
import Enums.Interval;
import Enums.NoteName;
import Enums.Triad;

import java.util.HashSet;
import java.util.Set;

// instance is a labelling of a chord
public class Chord {
  private final NoteName root;
  private final Triad triad;
  private final Extension extension;

  // TODO - change extension to set of extensions
  public Chord(NoteName root, Triad triad, Extension extension) {
    this.root = root;
    this.triad = triad;
    this.extension = extension;
  }

  public NoteName getRoot() {
    return this.root;
  }

  public Triad getTriad() {
    return this.triad;
  }

  public Extension getExtension() {
    return this.extension;
  }

  public Set<NoteName> getNotes() {
    Set<Interval> intervals = triad.getIntervals();
    intervals.add(extension.getInterval());
    Set<NoteName> notes = new HashSet<NoteName>();
    notes.add(root);
    intervals.forEach(i -> notes.add(root.addInterval(i)));
    return notes;
  }

  public boolean hasChordTone(NoteName name) {
    return getNotes().contains(name);
  }

  // TODO - implement to be equal if has same function
  @Override
  public boolean equals(Object other) {
    return super.equals(other);
  }

  @Override
  public String toString() {
    return root.toString() + triad.toString() + extension.toString();
  }
}
