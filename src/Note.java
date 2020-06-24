public class Note implements Comparable<Note> {

  private final NoteName name;
  private final int octave;

  public Note(NoteName name, int octave) {
    this.name = name;
    this.octave = octave;
  }

  public int getOctave() {
    return octave;
  }

  public NoteName getName() {
    return this.name;
  }

  //return pos if current is higher pitch
  //       0 if same
  //       neg if lower pitch
  @Override
  public int compareTo(Note otherNote) {
    if (octave != otherNote.octave) {
      return (octave - otherNote.octave);
    }
    return name.getValue() - otherNote.getName().getValue();
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Note) {
      Note otherNote = (Note) other;
      return (octave == otherNote.octave && name == otherNote.name);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return 1;
  }

  @Override
  public String toString() {
    return name.toString() + Integer.toString(octave);
  }
}
