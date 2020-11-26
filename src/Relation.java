import Enums.Interval;

// Instance relates a chord to a scale
public class Relation {

  //reference to parent scale
  private final Scale scale;
  //reference to child chord
  private final Chord chord;
  private final Interval roman;

  //TODO: extend to add secondary dom, parallel maj/min etc

  public Relation(Interval roman, Scale scale, Chord chord) {
    this.roman = roman;
    this.scale = scale;
    this.chord = chord;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Relation) {
      Relation otherRealtion = (Relation) other;
      return scale.equals(otherRealtion.scale) &&
             chord.equals(otherRealtion.chord) &&
             roman.equals(otherRealtion.roman);
    }
    return true;
  }

  @Override
  public String toString() {
    return chord.toString() + ": " + roman.getRoman() + " in " + scale.toString();
  }
}
