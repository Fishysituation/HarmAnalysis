package Enums;

public enum Extension {
  NONE(""),
  MIN7("7"),
  MAJ7("maj7");

  private String rep;

  Extension(String rep) {
    this.rep = rep;
  }

  @Override
  public String toString() {
    return rep;
  }
}
