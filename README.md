**CPEN 221 / Fall 2021 / Exercise 1**

Ranking Players
===============

## Overview

Consider a tournament with the following rules:

- Each tournament has P players;
- In a tournament, a player plays S sets;
- Each set involves G games.

In each game a player can get between 0 and 5 points. The tournament is won by the player with the maximum number of points in the last set of games (irrespective of performance in prior sets).

In the case that there is a tie between two players, we start with game number SG (how apt!) and work backwards to see when a player outperformed the others she/he is tied with. For instance, suppose S = 1 and G = 10. We have two players with scores {0, 1, 2, 1, 3, 4, 4, 2, 1, 3} and {0, 0, 0, 0, 0, 3, 5, 5, 5, 3}, respectively. The players are tied with 21 points but Player 2 will win because Player 2 had a higher score than Player 1 in Game 9 (so outperformed Player 1 more recently).

## Your Task

> You should implement the `static` method `rankPlayers` in the class `Tournament` that is part of the package `tournament`. 

Given a two-dimensional array, `scorecard`, of size P x SG (one row per player) with game scores, determine who wins the tournament. `scorecard[i][j]` represents the score of Player `i` in Game `j`. 

More specifically, order the players by performance using these rules. In the case that the tie cannot be resolved by looking at history then the player with the smaller identifier is deemed to have won in the tie-breaker.
The function to implement will take the 2D array `scores`, S and G as arguments and return an array of length P, with indices from the original array, as output. The first entry in the output array (index `0`) is that of the player who wins the tournament.

## Sample Testcases

We have provided some testcases to help you determine if you are on the right track. These tests are in the class `TournamentTests` (in the directory `src/test/java/tournament`). You will be using JUnit as the framework to test your work. Tests can be run from the IDE or using the command `gradle test` from the command line when the working directory is the root directory of the project.

## Logistics

**Submission Instructions**

+ Submit your work to the Github classroom repository that was created for you.
+ **Do not alter the directory/folder structure. You should retain the structure as in this repository.**
+ Do not wait until the last minute to push your work to Github. It is a good idea to push your work at intermediate points as well. _We would recommend that you get your Git and Github workflow set up at the start._

**What Should You Implement / Guidelines**

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes.
+ You can use additional **standard** Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.

## Honour Code

By submitting your work to Github you agree to the following:

+ You did not consult with any other person for the purpose of completing this activity.
+ You did not aid any other person in the class in completing their activity.
+ If you consulted any external sources, such as resources available on the World Wide Web, in completing the examination then you have cited the source. (You do not need to cite class notes or Sun/Oracle Java documentation.)
+ You are not aware of any infractions of the honour code for this activity.