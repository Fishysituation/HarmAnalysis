import Enums.NoteName;
import Enums.ScaleIntervals;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestScale {

  @Test
  public void testToString() {
    Scale scale = new Scale(NoteName.C, ScaleIntervals.MAJ);
    assertEquals(scale.toString(), "Cmaj");
  }

  @Test
  public void testScaleContains() {
    Scale scale = new Scale(NoteName.C, ScaleIntervals.MAJ);
    assertTrue(scale.contains(NoteName.D));
    assertTrue(scale.contains(NoteName.B));
    assertTrue(scale.contains(NoteName.C));
    assertFalse(scale.contains(NoteName.CS));
  }
}
