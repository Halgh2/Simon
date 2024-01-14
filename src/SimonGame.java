import java.util.Random;
import java.util.Scanner;

public class SimonGame {
    private Random generator;
    private String username;
    private Scanner kb;
    protected int highScore;
    protected int lowScore;
    protected int scoreSum;
    protected int gamesPlayed;
    Instructions instruction = new Instructions();

    SimonGame() {
        generator = new Random();
        kb = new Scanner(System.in);
        highScore = 0;
        lowScore = 0;
        scoreSum = 0;
        gamesPlayed = 0;
    }

    public void play() {
        char playAgain;
        System.out.print("Enter username: ");
        String username = kb.nextLine();
        instruction.addUserName(username);

        do {
            gamesPlayed++;
            System.out.println("Would you like to display instructions? (y/n)");
            String answer = kb.nextLine();
            if (answer.equals("y")){
                instruction.displayInstructions();
            }

            String gameNum = "";
            String userGuess;
            int score = 0;

            do {
                gameNum = updateGameNum(gameNum, generator);
                displayGameNum(gameNum);
                makeNumVanish();
                userGuess = getUsersGuess(kb);

                if (userGotItRight(userGuess, gameNum)) {
                    score++;
                    scoreSum++;
                }

            } while (userGotItRight(userGuess, gameNum));

            updateScores(score);

            double average = (double) scoreSum / gamesPlayed;

            PlayerStats playerStats = new PlayerStats(userGuess, gameNum, highScore, lowScore, gamesPlayed, average);
            playerStats.displayStats();

            System.out.print("Do you want to play again? y/n ");
            try {
                playAgain = kb.nextLine().toLowerCase().charAt(0);
            } catch (Exception e) {
                playAgain = 'y';
            }

        } while (playAgain != 'n');
    }

    private void updateScores(int score) {
        if (highScore == 0 || score > highScore)
            highScore = score;
        if (lowScore == 0 || score < lowScore)
            lowScore = score;
    }

    private String updateGameNum(String gn, Random gen) {
        return gn + gen.nextInt(10);
    }

    private void makeNumVanish() {
        for (int i = 0; i <= 300; i++) {
            System.out.println();
        }
    }

    private void displayGameNum(String gameNumber) {
        System.out.println("The number is: " + addCommas(gameNumber));
        int time = (gameNumber.length() < 5) ? 1000 : 500;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("ERROR in displayGameNum() method line 129");
        }
    }

    private String getUsersGuess(Scanner kb) {
        System.out.println("What is your guess? ");
        while (!kb.hasNextLine()) {
            System.out.println("What is your guess? ");
            kb.nextLine();
        }
        return "" + kb.nextLine();
    }

    private boolean userGotItRight(String userGuess, String gameNumber) {
        return (userGuess.equals(gameNumber));
    }

    private String addCommas(String number) {
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            if (count > 0 && count % 3 == 0) {
                builder.append(",");
                builder.append(number.charAt(i));
                count++;
            } else {
                builder.append(number.charAt(i));
                count++;
            }
        }
        return builder.reverse().toString();
    }
}
