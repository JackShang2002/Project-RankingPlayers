package tournament;

public class Tournament {

    /**
     * @param scorecard the scores in the tournament and is not null; {@code scorecard[i][j]} represents the score of Player i in Game j. Each row in this array has {@code sets * games} entries, and each entry has a value between 0 and 5 (limits inclusive).
     * @param sets the number of sets played in the tournament, {@code sets > 0}
     * @param games the number of games per set, {@code games > 0}
     * @return a list of players in order of their performance (best to worst)
     */
    public static int[] rankPlayers(int[][] scorecard, int sets, int games) {
        int[] playerRankings;

        int[] lastSet_Scores = lastSetScores(scorecard, sets, games);
        int[][] playerCard = new int[scorecard.length][2];
        for(int i = 0; i < scorecard.length; i++){
            playerCard[i][0] = i;
            playerCard[i][1] = lastSet_Scores[i];
        }



        playerRankings = rankingTool(scorecard, playerCard, sets, games);

        return playerRankings;
    }


    //This method calculates the last set scores of each player and puts it in an array.
    private static int[] lastSetScores(int[][] scorecard, int sets, int games) {
        int[] lastSet_Scores;

        int numPlayers = scorecard.length;
        lastSet_Scores = new int[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            int playerScore = 0;
            for (int j = (sets - 1) * games; j < (sets * games); j++) {
                playerScore += scorecard[i][j];
            }
            lastSet_Scores[i] = playerScore;

        }

        return lastSet_Scores;
    }


    //This method ranks the players and puts them in an array.
    private static int[] rankingTool(int[][] scorecard, int[][] playerCard, int sets, int games){

        int[][] dummyCache = new int [1][2];
        int[][] dummyScores = playerCard;
        int[] playerRank = new int [scorecard.length];

        for (int i = 0; i < dummyScores.length; i++){
            dummyCache[0][0] = 0;
            dummyCache[0][1] = -1;

            for (int playerID = 0; playerID < dummyScores.length; playerID++){


                //If there is a tie.
                if (dummyScores[playerID][1] == dummyCache[0][1]){

                    for (int j = (sets * games) - 1; j > -1; j--){
                        if (scorecard[playerID][j] > scorecard[dummyCache[0][0]][j]){
                            dummyCache[0][0] = playerID;
                            break;
                        }

                        if(scorecard[playerID][j] < scorecard[dummyCache[0][0]][j]){
                            break;
                        }

                        if(j == 0 & scorecard[playerID][j] == scorecard[dummyCache[0][0]][j]){
                            if(playerID > dummyCache[0][0]){
                                break;
                            }
                            else{
                                dummyCache[0][0] = playerID;
                            }
                        }
                    }

                }

                //Ranking without a tie.
                if (dummyScores[playerID][1] > dummyCache[0][1]){
                    dummyCache[0][1] = dummyScores[playerID][1];
                    dummyCache[0][0] = playerID;
                }

            }

            playerRank[i] = dummyCache[0][0];
            dummyScores[dummyCache[0][0]][1] = 0;
        }

        return playerRank;
    }

}
