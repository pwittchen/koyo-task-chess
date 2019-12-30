package com.pwittchen.chess.model;

import java.util.Objects;

public class Square {

  private final int x;
  private final int y;

  public Square(final int x, final int y) {
    boolean validPosition = x > 0 && x < 9 && y > 0 && y < 9;
    if (!validPosition) {
      throw new IllegalArgumentException(String.format("position [%d,%d] is out of range", x, y));
    }
    this.x = x;
    this.y = y;
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  @Override public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Square square = (Square) o;
    return x == square.x &&
        y == square.y;
  }

  @Override public int hashCode() {
    return Objects.hash(x, y);
  }
}
