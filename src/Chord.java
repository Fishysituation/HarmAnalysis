import Enums.Extension;
import Enums.NoteName;
import Enums.Triad;

// instance is a labelling of a chord
public class Chord {
  private final NoteName root;
  private final Triad triad;
  private final Extension extension;

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
