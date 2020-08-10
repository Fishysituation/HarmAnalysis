import static org.junit.Assert.*;

import Enums.NoteName;
import org.junit.Test;

public class TestNote {
  @Test
  public void testCompare() {
    Note n1 = new Note(NoteName.A, 4);
    Note n2 = new Note(NoteName.A, 4);
    Note n3 = new Note(NoteName.A, 5);
    Note n4 = new Note(NoteName.B, 4);
    Note n5 = new Note(NoteName.B, 5);

    assertEquals(0, n1.compareTo(n2));
    assertTrue(n1.compareTo(n3) < 0);
    assertTrue(n3.compareTo(n1) > 0);
    assertTrue(n1.compareTo(n4) < 0);
    assertTrue(n4.compareTo(n1) > 0);
    assertTrue(n1.compareTo(n5) < 0);
    assertTrue(n5.compareTo(n1) > 0);
  }

  @Test
  public void testEquals() {
    Note n1 = new Note(NoteName.A, 4);
    Note n2 = new Note(NoteName.A, 4);
    Note n3 = new Note(NoteName.A, 5);
    Note n4 = new Note(NoteName.B, 4);
    Note n5 = new Note(NoteName.B, 5);

    assertEquals(n1, n2);
    assertNotEquals(n1, n3);
    assertNotEquals(n1, n4);
    assertNotEquals(n1, n5);
  }
}
