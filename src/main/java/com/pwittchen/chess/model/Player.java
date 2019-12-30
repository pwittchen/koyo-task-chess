package com.pwittchen.chess.model;

import java.util.Objects;

public class Player {

  private final Color color;
  private boolean enabled;

  public Player(final Color color) {
    this.color = color;
    if (color.equals(Color.WHITE)) {
      enable();
    }
  }

  public boolean enabled() {
    return enabled;
  }

  public void enable() {
    this.enabled = true;
  }

  public void disable() {
    this.enabled = false;
  }

  @Override public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Player player = (Player) o;
    return color == player.color;
  }

  @Override public int hashCode() {
    return Objects.hash(color);
  }
}
