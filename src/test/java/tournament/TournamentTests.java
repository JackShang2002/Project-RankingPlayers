package tournament;

import org.junit.Assert;
import org.junit.Test;

public class TournamentTests {
    @Test
    public void test1() {
        int[][] scorecard = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int sets = 1;
        int games = 10;
        int[] expResult = {0, 1};
        int[] result = Tournament.rankPlayers(scorecard, sets, games);
        Assert.assertArrayEquals(expResult, result);
    }

    @Test
    public void test_MultipleSets_MultipleGames() {
        int[][] scorecard = {{1, 3, 5, 2},
                {5, 3, 4, 4},
                {5, 4, 3, 4}};
        int sets = 2;
        int games = 2;
        int[] expResult = {1, 2, 0};
        int[] result = Tournament.rankPlayers(scorecard, sets, games);
        Assert.assertArrayEquals(expResult, result);
    }

    @Test
    public void test_MultipleSets_MultipleGames_TieBreaker_History() {
        int[][] scorecard = {{1, 3, 5, 2},
                {5, 3, 3, 4},
                {5, 4, 4, 3}};
        int sets = 2;
        int games = 2;
        int[] expResult = {1, 2, 0};
        int[] result = Tournament.rankPlayers(scorecard, sets, games);
        Assert.assertArrayEquals(expResult, result);
    }

    @Test
    public void test_MultipleSets_MultipleGames_TieBreaker_SmallestIdentifier() {
        int[][] scorecard = {{5, 3, 5, 2},
                {5, 4, 5, 2},
                {5, 4, 5, 2}};
        int sets = 2;
        int games = 2;
        int[] expResult = {1, 2, 0};
        int[] result = Tournament.rankPlayers(scorecard, sets, games);
        Assert.assertArrayEquals(expResult, result);
    }

    @Test
    public void test_MultipleSets_OneGame() {
        int[][] scorecard = {{4, 2},
                {5, 1},
                {5, 4}};
        int sets = 2;
        int games = 1;
        int[] expResult = {2, 0, 1};
        int[] result = Tournament.rankPlayers(scorecard, sets, games);
        Assert.assertArrayEquals(expResult, result);
    }

    @Test
    public void test_MultipleSets_OneGame_TieBreaker_History() {
        int[][] scorecard = {{4, 2},
                {3, 4},
                {4, 4}};
        int sets = 2;
        int games = 1;
        int[] expResult = {2, 1, 0};
        int[] result = Tournament.rankPlayers(scorecard, sets, games);
        Assert.assertArrayEquals(expResult, result);
    }

    @Test
    public void test_MultipleSets_OneGame_TieBreaker_SmallestIdentifier() {
        int[][] scorecard = {{4, 2},
                {3, 4},
                {3, 4}};
        int sets = 2;
        int games = 1;
        int[] expResult = {1, 2, 0};
        int[] result = Tournament.rankPlayers(scorecard, sets, games);
        Assert.assertArrayEquals(expResult, result);
    }


    @Test
    public void test_OneSet_OneGame() {
        int[][] scorecard = {{4},
                {5},
                {2}};
        int sets = 1;
        int games = 1;
        int[] expResult = {1, 0, 2};
        int[] result = Tournament.rankPlayers(scorecard, sets, games);
        Assert.assertArrayEquals(expResult, result);
    }

    @Test
    public void testOneSetOneGame_TieBreaker() {
        int[][] scorecard = {{5},
                {5},
                {5}};
        int sets = 1;
        int games = 1;
        int[] expResult = {0, 1, 2};
        int[] result = Tournament.rankPlayers(scorecard, sets, games);
        Assert.assertArrayEquals(expResult, result);
    }
}
