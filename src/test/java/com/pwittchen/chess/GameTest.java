package com.pwittchen.chess;

import com.pwittchen.chess.model.Color;
import com.pwittchen.chess.model.Player;
import com.pwittchen.chess.model.Square;
import com.pwittchen.chess.model.piece.Pawn;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class GameTest {

  @Test public void shouldMovePieceOnTheBoard() {
    // given
    final Game game = new ChessGame();
    final Square from = new Square(1, 2);
    final Square to = new Square(1, 3);

    // when
    game.move(from, to);

    // then
    assertThat(game.board().get(from).isPresent()).isFalse();
    assertThat(game.board().get(to).isPresent()).isTrue();
    assertThat(game.board().get(to).get()).isEqualTo(new Pawn(new Player(Color.WHITE)));
    assertThat(game.activePlayer()).isEqualTo(new Player(Color.BLACK));
  }

  @Test public void shouldMovePiecesOnTheBoardByTwoPlayersSequentially() {
    // given
    final Game game = new ChessGame();
    final Square fromPlayerWhite = new Square(1, 2);
    final Square toPlayerWhite = new Square(1, 3);
    final Square fromPlayerBlack = new Square(1, 7);
    final Square toPlayerBlack = new Square(1, 6);
    final Player whitePlayer = new Player(Color.WHITE);
    final Player blackPlayer = new Player(Color.BLACK);

    // when
    assertThat(game.activePlayer()).isEqualTo(whitePlayer);
    game.move(fromPlayerWhite, toPlayerWhite);
    assertThat(game.activePlayer()).isEqualTo(blackPlayer);
    game.move(fromPlayerBlack, toPlayerBlack);
    assertThat(game.activePlayer()).isEqualTo(whitePlayer);

    // then
    assertThat(game.board().get(fromPlayerWhite).isPresent()).isFalse();
    assertThat(game.board().get(toPlayerWhite).isPresent()).isTrue();
    assertThat(game.board().get(toPlayerWhite).get()).isEqualTo(new Pawn(whitePlayer));

    assertThat(game.board().get(fromPlayerBlack).isPresent()).isFalse();
    assertThat(game.board().get(toPlayerBlack).isPresent()).isTrue();
    assertThat(game.board().get(toPlayerBlack).get()).isEqualTo(new Pawn(blackPlayer));
  }

  @Test(expected = IllegalStateException.class)
  public void shouldNotMovePieceOfInactivePlayer() {
    // given
    final Game game = new ChessGame();
    final Square from = new Square(1, 7);
    final Square to = new Square(1, 6);

    // when
    game.move(from, to);

    // then an exception should be thrown
  }

  @Test(expected = IllegalStateException.class)
  public void shouldNotMovePieceWhichDoesNotExistOnTheBoard() {
    // given
    final Game game = new ChessGame();
    final Square from = new Square(1, 3);
    final Square to = new Square(1, 4);

    // when
    game.move(from, to);

    // then an exception should be thrown
  }
}