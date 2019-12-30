package com.pwittchen.chess.model.piece;

import com.pwittchen.chess.model.Color;
import com.pwittchen.chess.model.Piece;
import com.pwittchen.chess.model.Player;
import com.pwittchen.chess.model.Square;
import java.util.Map;
import java.util.Optional;

public class Pawn extends Piece {

  public Pawn(final Player player) {
    super(player);
  }

  @Override
  public boolean canMove(Square from, Square to, Map<Square, Optional<Piece>> board) {
    boolean isWhite = player().equals(new Player(Color.WHITE));
    boolean isGoingForward = from.x() == to.x() && from.y() + (isWhite ? 1 : -1) == to.y();
    boolean toSquareIsEmpty = board.get(to).isEmpty();
    boolean isGoingDiagRight = from.x() + 1 == to.x() && from.y() + (isWhite ? 1 : -1) == to.y();
    boolean isGoingDiagLeft = from.x() - 1 == to.x() && from.y() + (isWhite ? 1 : -1) == to.y();
    boolean isGoingDiagonally = isGoingDiagLeft || isGoingDiagRight;
    boolean toHasEnemy = !board.get(to).map(Piece::player).orElseGet(this::player).equals(player());
    return (isGoingForward && toSquareIsEmpty) || (isGoingDiagonally && toHasEnemy);
  }
}
