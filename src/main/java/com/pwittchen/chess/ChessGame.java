package com.pwittchen.chess;

import com.pwittchen.chess.model.Board;
import com.pwittchen.chess.model.Color;
import com.pwittchen.chess.model.Player;
import com.pwittchen.chess.model.Square;

public class ChessGame implements Game {

  private final Board board;
  private final Player whitePlayer;
  private final Player blackPlayer;

  public ChessGame() {
    this.whitePlayer = new Player(Color.WHITE);
    this.blackPlayer = new Player(Color.BLACK);
    this.board = new Board(whitePlayer, blackPlayer);
  }

  @Override public void move(final Square from, final Square to) {
    board.move(from, to, activePlayer());
    toggleActivePlayer();
  }

  private void toggleActivePlayer() {
    if (whitePlayer.enabled()) {
      whitePlayer.disable();
      blackPlayer.enable();
    } else {
      whitePlayer.enable();
      blackPlayer.disable();
    }
  }

  @Override public Player activePlayer() {
    return whitePlayer.enabled() ? whitePlayer : blackPlayer;
  }

  @Override public Board board() {
    return board;
  }
}
