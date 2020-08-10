package Enums;

public enum Triad {
  MAJ(""),
  MIN("-");

  private String rep;

  Triad(String rep) {
    this.rep = rep;
  }

  @Override
  public String toString() {
    return rep;
  }
}
