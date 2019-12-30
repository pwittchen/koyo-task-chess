package com.pwittchen.chess.model.piece;

import com.pwittchen.chess.model.Piece;
import com.pwittchen.chess.model.Player;
import com.pwittchen.chess.model.Square;
import java.util.Map;
import java.util.Optional;

public class Rook extends Piece {

  public Rook(final Player player) {
    super(player);
  }

  @Override
  public boolean canMove(Square from, Square to, Map<Square, Optional<Piece>> board) {
    throw new UnsupportedOperationException("move validation is not implemented for this piece");
  }
}
