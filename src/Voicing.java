import Enums.Extension;
import Enums.Interval;
import Enums.NoteName;
import Enums.Triad;

import java.util.*;
import java.util.stream.Collectors;

public class Voicing {

  private final List<Note> voices;

  public Voicing(Collection<Note> voices) {
    this.voices = new ArrayList<Note>(voices);
    Collections.sort(this.voices);
  }

  // label chord if analysing as a rootless
  public Chord labelRootful() {
    // root note will be lowest note in chord voicing
    NoteName root = voices.get(0).getName();
    List<Interval> intervals =
        voices.stream()
            .map(n -> Analyze.getActualInterval(voices.get(0), n))
            .collect(Collectors.toList());
    // ignore other extensions for now
    Triad triad = null;
    if (intervals.contains(Interval.MAJ3)) {
      triad = Triad.MAJ;
    } else if (intervals.contains(Interval.MIN3)) {
      triad = Triad.MIN;
    }

    Extension extension;
    if (intervals.contains(Interval.MAJ7)) {
      extension = Extension.MAJ7;
    } else if (intervals.contains(Interval.MIN7)) {
      extension = Extension.MIN7;
    } else {
      extension = Extension.NONE;
    }
    return new Chord(root, triad, extension);
  }

  // return set of chord labels if interpreting as a rootless voicing
  public Set<Chord> labelRootless() {
    return new HashSet<>();
  }
}
