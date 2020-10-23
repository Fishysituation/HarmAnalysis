import Enums.Interval;

import java.util.List;

public class Song implements Transposable {

  private final List<Chord> chords;

  public Song(List<Chord> chords) {
    this.chords = chords;
  }

  public List<Chord> getChords() {
    return chords;
  }

  @Override
  public void transpose(Interval transposeUp) {
    for (Chord chord : chords) {
      chord.transpose(transposeUp);
    }
  }
}
