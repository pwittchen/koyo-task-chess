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

public class PawnTest {

  private final Map<Square, Optional<Piece>> board = new HashMap<>();

  @Before public void setUp() {
    for (int i = 1; i < 9; i++) {
      for (int j = 1; j < 9; j++) {
        board.put(new Square(i, j), Optional.empty());
      }
    }
  }

  @Test public void shouldBeAbleToMovePawnOneStepForwardForWhitePlayer() {
    // given
    final Pawn pawn = new Pawn(new Player(Color.WHITE));
    final Square from = new Square(4, 2);
    final Square to = new Square(4, 3);
    board.put(from, Optional.of(pawn));

    // when
    final boolean canMove = pawn.canMove(from, to, board);

    // then
    assertThat(canMove).isTrue();
  }

  @Test public void shouldBeAbleToMovePawnOneStepForwardForBlackPlayer() {
    // given
    final Pawn pawn = new Pawn(new Player(Color.BLACK));
    final Square from = new Square(4, 7);
    final Square to = new Square(4, 6);
    board.put(from, Optional.of(pawn));

    // when
    final boolean canMove = pawn.canMove(from, to, board);

    // then
    assertThat(canMove).isTrue();
  }

  @Test public void shouldBeAbleToCaptureEnemyDiagonallyRightByWhitePlayer() {
    // given
    final Pawn whitePawn = new Pawn(new Player(Color.WHITE));
    final Pawn blackPawn = new Pawn(new Player(Color.BLACK));
    final Square whitePawnLocation = new Square(4, 2);
    final Square blackPawnLocation = new Square(5, 3);
    board.put(whitePawnLocation, Optional.of(whitePawn));
    board.put(blackPawnLocation, Optional.of(blackPawn));

    // when
    final boolean canMove = whitePawn.canMove(whitePawnLocation, blackPawnLocation, board);

    // then
    assertThat(canMove).isTrue();
  }

  @Test public void shouldBeAbleToCaptureEnemyDiagonallyLeftByWhitePlayer() {
    // given
    final Pawn whitePawn = new Pawn(new Player(Color.WHITE));
    final Pawn blackPawn = new Pawn(new Player(Color.BLACK));
    final Square whitePawnLocation = new Square(4, 2);
    final Square blackPawnLocation = new Square(3, 3);
    board.put(whitePawnLocation, Optional.of(whitePawn));
    board.put(blackPawnLocation, Optional.of(blackPawn));

    // when
    final boolean canMove = whitePawn.canMove(whitePawnLocation, blackPawnLocation, board);

    // then
    assertThat(canMove).isTrue();
  }

  @Test public void shouldBeAbleToCaptureEnemyDiagonallyRightByBlackPlayer() {
    // given
    final Pawn blackPawn = new Pawn(new Player(Color.BLACK));
    final Pawn whitePawn = new Pawn(new Player(Color.WHITE));
    final Square blackPawnLocation = new Square(3, 7);
    final Square whitePawnLocation = new Square(2, 6);
    board.put(blackPawnLocation, Optional.of(blackPawn));
    board.put(whitePawnLocation, Optional.of(whitePawn));

    // when
    final boolean canMove = blackPawn.canMove(blackPawnLocation, whitePawnLocation, board);

    // then
    assertThat(canMove).isTrue();
  }

  @Test public void shouldBeAbleToCaptureEnemyDiagonallyLeftByBlackPlayer() {
    // given
    final Pawn blackPawn = new Pawn(new Player(Color.BLACK));
    final Pawn whitePawn = new Pawn(new Player(Color.WHITE));
    final Square blackPawnLocation = new Square(3, 7);
    final Square whitePawnLocation = new Square(4, 6);
    board.put(blackPawnLocation, Optional.of(blackPawn));
    board.put(whitePawnLocation, Optional.of(whitePawn));

    // when
    final boolean canMove = blackPawn.canMove(blackPawnLocation, whitePawnLocation, board);

    // then
    assertThat(canMove).isTrue();
  }

  @Test public void shouldNotBeAbleToGoDiagonallyRightToEmptyFieldByWhitePlayer() {
    // given
    final Pawn whitePawn = new Pawn(new Player(Color.WHITE));
    final Square from = new Square(4, 2);
    final Square to = new Square(5, 3);
    board.put(from, Optional.of(whitePawn));

    // when
    final boolean canMove = whitePawn.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }

  @Test public void shouldNotBeAbleToGoDiagonallyLeftToEmptyFieldByWhitePlayer() {
    // given
    final Pawn whitePawn = new Pawn(new Player(Color.WHITE));
    final Square from = new Square(4, 2);
    final Square to = new Square(3, 3);
    board.put(from, Optional.of(whitePawn));

    // when
    final boolean canMove = whitePawn.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }

  @Test public void shouldNotBeAbleToGoDiagonallyRightToEmptyFieldByBlackPlayer() {
    // given
    final Pawn blackPawn = new Pawn(new Player(Color.BLACK));
    final Square from = new Square(3, 7);
    final Square to = new Square(2, 6);
    board.put(from, Optional.of(blackPawn));

    // when
    final boolean canMove = blackPawn.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }

  @Test public void shouldNotBeAbleToGoDiagonallyLeftToEmptyFieldByBlackPlayer() {
    // given
    final Pawn whitePawn = new Pawn(new Player(Color.WHITE));
    final Square from = new Square(4, 2);
    final Square to = new Square(3, 3);
    board.put(from, Optional.of(whitePawn));

    // when
    final boolean canMove = whitePawn.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }

  @Test public void shouldNotBeAbleToGoLeft() {
    // given
    final Pawn whitePawn = new Pawn(new Player(Color.WHITE));
    final Square from = new Square(4, 2);
    final Square to = new Square(3, 2);
    board.put(from, Optional.of(whitePawn));

    // when
    final boolean canMove = whitePawn.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }

  @Test public void shouldNotBeAbleToGoRight() {
    // given
    final Pawn whitePawn = new Pawn(new Player(Color.WHITE));
    final Square from = new Square(4, 2);
    final Square to = new Square(5, 2);
    board.put(from, Optional.of(whitePawn));

    // when
    final boolean canMove = whitePawn.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }

  @Test public void shouldNotBeAbleToGoBackwardsByWhitePlayer() {
    // given
    final Pawn whitePawn = new Pawn(new Player(Color.WHITE));
    final Square from = new Square(4, 3);
    final Square to = new Square(4, 2);
    board.put(from, Optional.of(whitePawn));

    // when
    final boolean canMove = whitePawn.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }

  @Test public void shouldNotBeAbleToGoBackwardsByBlackPlayer() {
    // given
    final Pawn whitePawn = new Pawn(new Player(Color.BLACK));
    final Square from = new Square(4, 2);
    final Square to = new Square(4, 3);
    board.put(from, Optional.of(whitePawn));

    // when
    final boolean canMove = whitePawn.canMove(from, to, board);

    // then
    assertThat(canMove).isFalse();
  }
}