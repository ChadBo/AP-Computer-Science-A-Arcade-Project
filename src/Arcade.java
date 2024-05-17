import java.io.FileReader;
import java.util.Scanner;
public class Arcade
{
    public static void main(String[] args)
    {
        //make function that has if statement to call which function is selected
        gameSelect();
    }
    
    //create & check trivia functions
    public static void triviaSelect(){
        introduction();
        CreateTrivia();
    }

    
    
    public static void gameSelect(){
        //add while loop to play more games after
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What game would you like to play?");
            System.out.println("(1) - Trivia");
            System.out.println("(2) - Number Guessing");
            System.out.println("(3) - Connections");
            System.out.println("(4) - TicTacToe");
            System.out.println("(5) - File Reader");
            System.out.println("(6) - Quit");
            System.out.print("- ");
            int selection = scanner.nextInt();
            //if statement to check which option
            if (selection == 1) {
                triviaSelect();
            }
            else if (selection == 2) {
                runGuessing();
            }
            else if (selection == 3) {
                Connections.play();
            }
            else if (selection == 3) {
                Connections.play();
            }
            else if (selection == 4) {
                makeTicTacToe();
            }
            else if (selection == 5) {
                try {
                    FileReader fr = new FileReader("./Words.txt");
                    int current;
                    while ((current = fr.read()) != -1) {
                        System.out.print((char) current);
                    }
                    fr.close();
                } catch(Exception e) {
                    System.out.println("error: " + e);
                }
            }
            else {
                break;
            }
        System.out.println();
        System.out.println("_________________________________________________________");
        System.out.println();
        }
    }
    
    //TICTACTOE
    public static void makeTicTacToe() {
        TicTacToe board = new TicTacToe();
        System.out.println();
        System.out.println("_________________________________________________________");
        System.out.println();
        ticTacToeGameLoop(board);
    }
    
    public static void ticTacToeGameLoop(TicTacToe board) {
        Scanner input = new Scanner(System.in);
        int row;
        int col;
        System.out.println();
        System.out.println("Welcome to Tic-Tac-Toe");
        System.out.println("X goes first!");
        while(true) {
            board.printBoard();
            System.out.println();
            System.out.print("What row do you want to select? ");
            row = input.nextInt();
            System.out.print("What column do you want to select? ");
            col = input.nextInt();
            if(board.pickLocation(row,col)) {
                board.takeTurn(row,col);
            }
            
            if(board.checkWin()) {
                board.printBoard();
                if((board.getTurn()-1) %2 == 0) {
                    System.out.println("Congratulations, " + "X, " + "you won!");
                }
                else {
                    System.out.println("Congratulations, " + "O, " + "you won!");
                }
                break;
            }
            else if(board.checkCat()) {
                board.printBoard();
                System.out.println("Cats game!");
                break;
            }
            System.out.println();
        }
    }
    
    //TRIVIA CODE
    public static void CreateTrivia(){
        ScoreChanger score = new ScoreChanger(0);
        
        Scanner scanner = new Scanner(System.in);
        Question one = new Question("What year was Pac-Man released to the public?", 1980, score);
        System.out.println(one);
        double numResponse = scanner.nextDouble();
        System.out.println(one.numberTrue(numResponse));
        System.out.println("new score: " + score.value);
        System.out.println("_________________________________________________________");
        ask();

        Question two = new Question("What game, produced by nintendo features an italian plumber saving a princess", "mario", score);
        System.out.println(two);
        String response = scanner.nextLine();
        response = scanner.nextLine();
        System.out.println(two.wordTrue(response));
        System.out.println("current score: " + score.value);
        System.out.println("_________________________________________________________");
        ask();
        
        Question three = new Question("What version of minecraft (_.__) added massive changes to the Nether Dimension?", 1.16, score);
        System.out.println(three);
        numResponse = scanner.nextDouble();
        System.out.println(three.numberTrue(numResponse));
        System.out.println("new score: " + score.value);
        System.out.println("_________________________________________________________");
        ask();
        
        Question four = new Question("The First Call of Duty was released in 2003. True/False", "true", score);
        System.out.println(four);
        response = scanner.nextLine();
        response = scanner.nextLine();
        System.out.println(four.wordTrue(response));
        System.out.println("new score: " + score.value);
        System.out.println("_________________________________________________________");
        ask();
        
        Question five = new Question("What is the first initial of the gorilla known for throwing barrels towards Mario?", "D", score);
        System.out.println(five);
        response = scanner.nextLine();
        System.out.println(five.wordTrue(response));
        System.out.println("new score: " + score.value);
        System.out.println("_________________________________________________________");
        ask();
        
        Question six = new Question("Fortnite released their original map for a second time in 2023. True/False", "True", score);
        System.out.println(six);
        response = scanner.nextLine();
        System.out.println(six.wordTrue(response));
        System.out.println("new score: " + score.value);
        System.out.println("_________________________________________________________");
        
        calculate(score);
    }
    static void introduction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("_________________________________________________________");
        System.out.println("");
        System.out.println("Hello! Welcome to the Chatbot Gameshow!");
        System.out.println("Feel free to respond using as many capital letters as you want!");
        System.out.println("Todays theme is Video Games!");
        System.out.println("_________________________________________________________");
        ask();
        }
    //loop of asking to begin
    static void ask() {
        Scanner scanner = new Scanner(System.in);
        String yesOrNo = "no";
        while ( !yesOrNo.equalsIgnoreCase("yes") ) {
            System.out.println("Are you ready for the question? yes/no");
            yesOrNo = scanner.nextLine();
            if( !yesOrNo.equalsIgnoreCase("yes") && !yesOrNo.equalsIgnoreCase("no")){
                System.out.println("Only 'yes' & 'no' are acceptable responses.");
            }
        }
        System.out.println("_________________________________________________________");
    }
        static void calculate(ScoreChanger score) {
        double finalScore = (double)score.value / 6 * 100;
        finalScore = Math.round(finalScore * 100.0) /100.0;
        System.out.println("Your score was " + finalScore + "%");
        failure(finalScore);
    }
    static void failure(double endScore) {
        if (endScore < 73.00) {
            System.out.println("Looks like you failed!");
        }
        else {
            System.out.println("Congratulations! You passed the trivia.");
        }
    }
    //NUMBER GAME CODE
    public static void runGuessing() {
        int answer=(int)(Math.random()*100); //DO NOT EDIT THIS LINE
        guessingIntroduction();
        guessTheNumber(answer);
    }
    
    public static void guessingIntroduction() {
        System.out.println("The computer has picked a number between 0 & 100 for you to guess!");
    }
    
    public static void guessTheNumber(int corrAnswer) {
        Scanner input = new Scanner(System.in);
        int guesses = 0;
        int guess = 1000;
        while (guess != corrAnswer) {
            System.out.print("Guess the computer's number (0-100): ");
            guess = input.nextInt();
            guesses++;
            checkGuess(guess, corrAnswer, guesses);
        }
    }
    
    public static void checkGuess(int userGuess, int answerPassthrough, int guessesPassthrough) {
        if (answerPassthrough == userGuess) {
            guessCorrect(guessesPassthrough);
        }
        else if (answerPassthrough > userGuess) {
            System.out.println("The number is higher than " + userGuess);
        }
        else {
            System.out.println("The number is lower than " + userGuess);
        }
    }
    public static void guessCorrect(int totalGuesses) {
        System.out.println("Congratulations!");
        System.out.println("You guessed the number in " + totalGuesses + " guesses");
    }
}