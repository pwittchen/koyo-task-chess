package com.pwittchen.chess.model;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public abstract class Piece {

  private final Player player;

  public abstract boolean canMove(Square from, Square to, Map<Square, Optional<Piece>> board);

  public Piece(final Player player) {
    this.player = player;
  }

  public Player player() {
    return player;
  }

  @Override public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Piece piece = (Piece) o;
    return player.equals(piece.player);
  }

  @Override public int hashCode() {
    return Objects.hash(player);
  }
}
