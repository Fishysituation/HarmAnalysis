import static org.junit.Assert.*;

import Enums.Extension;
import Enums.Interval;
import Enums.NoteName;
import Enums.Triad;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestVoicing {
  @Test
  public void TestSimpleLabelRootful() throws Exception {
    Note note1 = new Note(NoteName.C, 4);
    Note note2 = new Note(NoteName.E, 4);
    Note note3 = new Note(NoteName.DS, 4);
    Note note4 = new Note(NoteName.G, 4);
    Note note5 = new Note(NoteName.AS, 4);
    Note note6 = new Note(NoteName.B, 4);

    Set<Note> majorTri = new HashSet<Note>();
    majorTri.add(note1);
    majorTri.add(note2);
    majorTri.add(note4);
    Voicing maj = new Voicing(majorTri);
    Chord majLabel = maj.labelRootful();
    assertEquals(NoteName.C, majLabel.getRoot());
    assertEquals(Triad.MAJ, majLabel.getTriad());
    assertEquals(Extension.NONE, majLabel.getExtension());

    Set<Note> major7 = new HashSet<>(majorTri);
    major7.add(note5);
    Voicing maj7 = new Voicing(major7);
    Chord maj7Label = maj7.labelRootful();
    assertEquals(NoteName.C, maj7Label.getRoot());
    assertEquals(Triad.MAJ, maj7Label.getTriad());
    assertEquals(Extension.MIN7, maj7Label.getExtension());
  }
}
