public class PlayerStats extends SimonGame {
    private final double average;
    private String userGuess;
    private String gameNumber;

    PlayerStats(String userGuess, String gameNumber, int high, int low, int games, double avg) {
        this.userGuess = userGuess;
        this.gameNumber = gameNumber;
        this.highScore = high;
        this.lowScore = low;
        this.gamesPlayed = games;
        this.average = avg;
    }

    public void displayStats() {
        System.out.println();
        System.out.println("WRONG! You lost when the number was " + gameNumber.length() + " digits long.");

        // Switch statement for game difficulty feedback...

        System.out.println("The correct number was " + addCommas(gameNumber) + ".");
        System.out.println("You guessed " + addCommas(userGuess) + ".");
        if (gameNumber.length() != userGuess.length())
            System.out.println("Your guess had " + userGuess.length() + " digits, but the answer had " + gameNumber.length() + " digits.");
        else {
            int offBy = getNumberOffBy(userGuess, gameNumber);
            System.out.println("You were off by " + offBy);
        }
        System.out.println("Your HIGH SCORE is: " + highScore);
        System.out.println("Your LOW SCORE is: " + lowScore);
        System.out.println("Your GAMES PLAYED is: " + gamesPlayed);
        System.out.println("Your AVERAGE SCORE is: " + average);
        System.out.println();
    }

    private int getNumberOffBy(String userGuess, String gameNum) {
        int count = 0;
        for (int i = 0; i < userGuess.length(); i++) {
            if (userGuess.charAt(i) != gameNum.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private String addCommas(String number) {
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            if (count > 0 && count % 3 == 0) {
                builder.append(",");

            }
        }
        return number;
    }
}
