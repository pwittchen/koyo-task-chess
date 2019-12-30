package com.pwittchen.chess;

import com.pwittchen.chess.model.Board;
import com.pwittchen.chess.model.Player;
import com.pwittchen.chess.model.Square;

public interface Game {

  void move(Square from, Square to);

  Player activePlayer();

  Board board();
}
