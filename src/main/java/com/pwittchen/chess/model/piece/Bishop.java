package com.pwittchen.chess.model.piece;

import com.pwittchen.chess.model.Piece;
import com.pwittchen.chess.model.Player;
import com.pwittchen.chess.model.Square;
import java.util.Map;
import java.util.Optional;

public class Bishop extends Piece {

  public Bishop(final Player player) {
    super(player);
  }

  @Override
  public boolean canMove(Square from, Square to, Map<Square, Optional<Piece>> board) {
    boolean isGoingDiagonally = Math.abs(to.x() - from.x()) == Math.abs(from.y() - to.y());
    return isGoingDiagonally && !isMoveBlocked(from, to, board);
  }

  private boolean isMoveBlocked(Square from, Square to, Map<Square, Optional<Piece>> board) {
    int directionX = from.x() < to.x() ? 1 : -1;
    int directionY = from.y() < to.y() ? 1 : -1;
    for (int i = 1; i < Math.max(Math.abs(from.x() - to.x()), Math.abs(from.y() - to.y())); i++) {
      int x = from.x() + i * directionX;
      int y = from.y() + i * directionY;
      if (board.get(new Square(x, y)).isPresent()) {
        return true;
      }
    }
    return false;
  }
}
