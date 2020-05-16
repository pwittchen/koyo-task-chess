package com.pwittchen.chess.model;

import com.pwittchen.chess.model.piece.Bishop;
import com.pwittchen.chess.model.piece.King;
import com.pwittchen.chess.model.piece.Knight;
import com.pwittchen.chess.model.piece.Pawn;
import com.pwittchen.chess.model.piece.Queen;
import com.pwittchen.chess.model.piece.Rook;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Board {
  private final Map<Square, Optional<Piece>> board;

  public Board(final Player whitePlayer, final Player blackPlayer) {
    this.board = new HashMap<>();
    initializePiecesForPlayer(whitePlayer, 1);
    initializePiecesForPlayer(blackPlayer, 8);
    initializeEmptySquares();
  }

  private void initializePiecesForPlayer(final Player player, final int startingY) {
    board.put(new Square(1, startingY), Optional.of(new Rook(player)));
    board.put(new Square(2, startingY), Optional.of(new Knight(player)));
    board.put(new Square(3, startingY), Optional.of(new Bishop(player)));
    board.put(new Square(4, startingY), Optional.of(new Queen(player)));
    board.put(new Square(5, startingY), Optional.of(new King(player)));
    board.put(new Square(6, startingY), Optional.of(new Bishop(player)));
    board.put(new Square(7, startingY), Optional.of(new Knight(player)));
    board.put(new Square(8, startingY), Optional.of(new Rook(player)));

    final int pawnY = startingY == 1 ? startingY + 1 : startingY - 1;

    for (int x = 1; x < 9; x++) {
      board.put(new Square(x, pawnY), Optional.of(new Pawn(player)));
    }
  }

  private void initializeEmptySquares() {
    for (int x = 1; x < 9; x++) {
      for (int y = 3; y < 7; y++) {
        board.put(new Square(x, y), Optional.empty());
      }
    }
  }

  public Optional<Piece> get(final Square square) {
    return board.get(square);
  }

  public void move(final Square from, final Square to, final Player activePlayer) {
    if (!canMovePiece(from, to, activePlayer)) {
      throw new IllegalStateException("move is not possible");
    }

    board.put(to, board.get(from));
    board.put(from, Optional.empty());
  }

  private boolean canMovePiece(final Square from, final Square to, final Player activePlayer) {
    boolean pieceExistsOnTheSourceSquare = board.get(from).isPresent();
    if (!pieceExistsOnTheSourceSquare) {
      return false;
    }

    boolean playerIsActive = board.get(from).get().player().equals(activePlayer);
    if (!playerIsActive) {
      return false;
    }

    boolean notCapturingPieceOfTheSameColor = !capturedPieceOfTheSameColor(to, activePlayer);
    boolean moveIsAllowedForPiece = board.get(from).get().canMove(from, to, board);
    boolean movingToAnotherPosition = !from.equals(to);
    return notCapturingPieceOfTheSameColor && moveIsAllowedForPiece && movingToAnotherPosition;
  }

  private boolean capturedPieceOfTheSameColor(final Square to, final Player activePlayer) {
    return board
        .get(to)
        .map(captured -> captured.player().equals(activePlayer))
        .orElse(false);
  }
}
