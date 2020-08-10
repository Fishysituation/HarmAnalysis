package Enums;

public enum NoteName {
  C(0, "C"),
  CS(1, "C#"),
  D(2, "D"),
  DS(3, "D#"),
  E(4, "E"),
  F(5, "F"),
  FS(6, "F#"),
  G(7, "G"),
  GS(8, "G#"),
  A(9, "A"),
  AS(10, "A#"),
  B(11, "B");

  private int value;
  private String rep;

  NoteName(int value, String rep) {
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
