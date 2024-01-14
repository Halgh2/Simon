public class Instructions {
    private String userName;

    void addUserName(String user){
        userName = user;
    }

    void displayInstructions() {
        System.out.println("\n Welcome " + userName + " to the game!");
        System.out.println("\n" +
                "███████╗██╗███╗   ███╗ ██████╗ ███╗   ██╗\n" +
                "██╔════╝██║████╗ ████║██╔═══██╗████╗  ██║\n" +
                "███████╗██║██╔████╔██║██║   ██║██╔██╗ ██║\n" +
                "╚════██║██║██║╚██╔╝██║██║   ██║██║╚██╗██║\n" +
                "███████║██║██║ ╚═╝ ██║╚██████╔╝██║ ╚████║\n" +
                "╚══════╝╚═╝╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n" +
                "                                         \n");
        System.out.println("This is a game of Simon.");
        System.out.println("I'll flash a number on the screen.");
        System.out.println("The goal of the game is to remember the number.");
        System.out.println("I'll add one digit each time, so the game gets harder!");
        System.out.println("If the number is 5 or more digits, I'll display it for 2 seconds to help you out.");
        System.out.print("Press ENTER to begin ");
    }
}
