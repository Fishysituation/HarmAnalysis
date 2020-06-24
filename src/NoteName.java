public enum NoteName {
  A(0, "A"),
  AS(1, "A#"),
  B(2, "B"),
  C(3, "C"),
  CS(4, "C#"),
  D(5, "D"),
  DS(6, "D#"),
  E(7, "E"),
  F(8, "F"),
  FS(9, "F#"),
  G(10, "G"),
  GS(11, "G#");

  private int value;
  private String rep;

  NoteName (int value, String rep) {
    this.value = value;
    this.rep = rep;
  }

  public String getRep() {
    return this.rep;
  }

  public int getValue() {
    return this.value;
  }
}
