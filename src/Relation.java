import Enums.Interval;

// Instance relates a chord to a scale
public class Relation {

  //Arbitrary values representing "strength" of a chord on each scale degree
  //TODO: put somewhere else to make testing/other references easier
  private static final int[] SCORES = {5, 2, 1, 3, 4, 2, 1};

  //reference to parent scale
  private final Scale scale;
  //reference to child chord
  private final Chord chord;

  //TODO: extend to add secondary dom, parallel maj/min etc
  public Relation(Scale scale, Chord chord) {
    this.scale = scale;
    this.chord = chord;
  }

  public int getScore() {
    return SCORES[scale.getScale().getDegrees().indexOf(getInterval())];
  }

  public Interval getInterval() {
    return Analyze.getLogicalInterval(scale.root, chord.getRoot());
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Relation) {
      Relation otherRelation = (Relation) other;
      return scale.equals(otherRelation.scale) &&
             chord.equals(otherRelation.chord);
    }
    return true;
  }

  @Override
  public String toString() {
    return chord.toString() + ": " + getInterval().getRoman() + " in " + scale.toString();
  }
}
