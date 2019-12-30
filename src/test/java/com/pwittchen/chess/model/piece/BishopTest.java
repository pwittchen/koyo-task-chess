package com.pwittchen.chess.model.piece;

import com.pwittchen.chess.model.Color;
import com.pwittchen.chess.model.Piece;
import com.pwittchen.chess.model.Player;
import com.pwittchen.chess.model.Square;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class BishopTest {

  private final Map<Square, Optional<Piece>> board = new HashMap<>();

  @Before public void setUp() {
    for (int i = 1; i < 9; i++) {
      for (int j = 1; j < 9; j++) {
        board.put(new Square(i, j), Optional.empty());
      }
    }
  }

  @Test public void shouldBeAbleToGoDiagonallyTopLeft() {
    // given
    final Bishop whiteBishop = new Bishop(new Player(Color.WHITE));
    final Square from = new Square(4, 5);
    final Square to = new Square(1, 8);
    board.put(from, Optional.of(whiteBishop));

    // when
    final boolean canMove = whiteBishop.canMove(from, to, board);

    // then
    assertThat(canMove).isTrue();
  }

  @Test public void shouldBeAbleToGoDiagonallyTopRight() {
    // given
    final Bishop whiteBishop = new Bishop(new Player(Color.WHITE));
    final Square from = new Square(4, 5);
    final Square to = new Square(7, 8);
    board.put(from, Optional.of(whiteBishop));

    // when
    final boolean canMove = whiteBishop.canMove(from, to, board);

    // then
    assertThat(canMove).isTrue();
  }

  @Test public void shouldBeAbleToGoDiagonallyBottomLeft() {
    // given
    final Bishop whiteBishop = new Bishop(new Player(Color.WHITE));
    final Square from = new Square(4, 5);
    final Square to = new Square(1, 2);
    board.put(from, Optional.of(whiteBishop));

    // when
    final boolean canMove = whiteBishop.canMove(from, to, board);

    // then
    assertThat(canMove).isTrue();
  }

  @Test public void shouldBeAbleToGoDiagonallyBottomRight() {
    // given
    final Bishop whiteBishop = new Bishop(new Player(Color.WHITE));
    final Square from = new Square(4, 5);
    final Square to = new Square(8, 1);
    board.put(from, Optional.of(whiteBishop));

    // when
    final boolean canMove = whiteBishop.canMove(from, to, board);

    // then
    assertThat(canMove).isTrue();
  }

  @Test public void shouldNotBeAbleToJumpOverOtherPieces() {
    // given
    final Bishop whiteBishop = new Bishop(new Player(Color.WHITE));
    final Square from = new Square(4, 5);
    final Square to = new Square(8, 1);
    board.put(from, Optional.of(whiteBishop));
    board.put(new Square(6, 3), Optional.of(new Pawn(new Player(Color.BLACK))));

    // when
    final boolean canMove = whiteBishop.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }

  @Test public void shouldNotBeAbleToGoLeft() {
    // given
    final Bishop whiteBishop = new Bishop(new Player(Color.WHITE));
    final Square from = new Square(4, 5);
    final Square to = new Square(4, 1);
    board.put(from, Optional.of(whiteBishop));

    // when
    final boolean canMove = whiteBishop.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }

  @Test public void shouldNotBeAbleToGoRight() {
    // given
    final Bishop whiteBishop = new Bishop(new Player(Color.WHITE));
    final Square from = new Square(4, 5);
    final Square to = new Square(4, 8);
    board.put(from, Optional.of(whiteBishop));

    // when
    final boolean canMove = whiteBishop.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }

  @Test public void shouldNotBeAbleToGoTop() {
    // given
    final Bishop whiteBishop = new Bishop(new Player(Color.WHITE));
    final Square from = new Square(4, 5);
    final Square to = new Square(8, 5);
    board.put(from, Optional.of(whiteBishop));

    // when
    final boolean canMove = whiteBishop.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }

  @Test public void shouldNotBeAbleToGoBottom() {
    // given
    final Bishop whiteBishop = new Bishop(new Player(Color.WHITE));
    final Square from = new Square(4, 5);
    final Square to = new Square(4, 1);
    board.put(from, Optional.of(whiteBishop));

    // when
    final boolean canMove = whiteBishop.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }
}