# Battleship
 A Battleship implementation in Java (console app).

## Description

Battleship (also Battleships or Sea Battle) is a strategy-type guessing game for two players. It is played on ruled grids (paper or board) on which each player's fleet of ships (including battleships) is marked. The locations of the fleets are concealed from the other player. Players alternate turns calling "shots" at the other player's ships, and the objective of the game is to destroy the opposing player's fleet.

Battleship is known worldwide as a pencil and paper game that dates from World War I. It was published by various companies as a pad-and-pencil game in the 1930s and was released as a plastic board game by Milton Bradley in 1967. The game has spawned electronic versions, video games, smart device apps, and a film.

## Instructions

1) Download all the source files.
2) Compile using the command "javac BattleShip.java ComputerPlayer.java ComputerStrategies.java ExplorationStrategy.java HumanPlayer.java RandomStrategy.java ShipBoard.java StrikeBoard.java" in a terminal.
3) Run using "java BattleShip".
4) Instructions will appear in the terminal for playing the game. Some things to note:
   i) For ship placement, you input two numbers seperated by a space for the initial block and a keyword from (vertical, horizontal) for determining the direction. If you go out of bounds, you will have the chance to input the ship again in a valid way, until you manage it.
   ii) Horizontal placement starts from the starting position and extends TO THE RIGHT of the board. For example, 0 4 horizontal will place the 4-size ship in the blocks (0,4), (0,5), (0,6), (0,7).
   iii) Vertical placement starts from the starting position and extends TO THE UPPER SIDE of the board.
   iv) Your shipboard will appear at the start of the game if you play versus the computer, once placement is complete. Empty blocks are represented with '0' and blocks with ships are represented by the number of the size of the corresponding ship.
   v) For each strike, you need to input two numbers seperated by a space, representing the position you wish to hit. After each strike, you will get information about its success, plus a strikeboard, where strike positions without damage to a ship are represented with '-1' and strike positions with damage to a ship are represented with '1'.
   vi) The game ends when someone has destroyed all of the opponent's ships.
