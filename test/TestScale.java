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
    assertEquals(scale.toString(), "CMAJ");
  }

  @Test
  public void testScaleContains() {
    Scale scale = new Scale(NoteName.C, ScaleIntervals.MAJ);
    assertTrue(scale.scaleContains(NoteName.D));
    assertTrue(scale.scaleContains(NoteName.B));
    assertTrue(scale.scaleContains(NoteName.C));
    assertFalse(scale.scaleContains(NoteName.CS));
  }
}
