import Enums.NoteName;
import Enums.ScaleIntervals;

import java.util.HashSet;
import java.util.Set;

public class Scale {

  private NoteName root;
  private ScaleIntervals scale;

  public Scale (NoteName root, ScaleIntervals scale) {
    this.root = root;
    this.scale = scale;
  }

  public NoteName getRoot() {
    return root;
  }

  public ScaleIntervals getScale() {
    return scale;
  }

  public Set<NoteName> getNotes() {
    Set<NoteName> notes = new HashSet<>();
    scale.getDegrees()
            .forEach(i -> notes.add(root.addInterval(i)));
    return notes;
  }

  public boolean scaleContains(NoteName name) {
    return getNotes().contains(name);
  }

  @Override
  public String toString() {
    return root.toString() + scale.toString();
  }
}
