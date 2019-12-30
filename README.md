Koyo Loans Backend Programming Test
===================================

This is Backend Programming Test for Koyo Loans. Goal of the test was to model the logic of the chess game.
Application does not provide any user interface and does not handle all corner cases and scenarios of the chess game.

It provides functionality described in the task only:
- modeling the board and pieces
- initializing board and pieces with default chess starting position
- allowing to move pieces from the one position to another
- validation that moved piece is owned by the correct player
- validation of the pawn movement according to the rules of chess
- validation of the bishop movement according to the rules of chess
- advanced moves like pawn promotion, en passant, castling, etc. can be ignored
- special cases like check and checkmate can be ignored

Building the application
------------------------

Application is written in Java 11 and uses [Gradle](https://gradle.org/) build system. 
In order to compile application, type in the terminal:

```
./gradlew clean build
```

**Please note**: if you are on MS Windows, replace `./gradlew` with `gradlew.bat` command

Compiled `*.jar` artifact will be located in `build/libs/` directory.

Tests
-----

Unit tests validate logic and correctness of the application code.
Tests use [JUnit](https://junit.org/junit4/) framework and [Truth](https://truth.dev/) assertion library.

In order to execute unit tests, type in the terminal:

```
./gradlew test
```

**Please note**: if you are on MS Windows, replace `./gradlew` with `gradlew.bat` command

Code style
----------

This project uses [Java Code Styles by Square](https://github.com/square/java-code-styles)