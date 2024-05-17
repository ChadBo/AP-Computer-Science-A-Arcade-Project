import java.util.Scanner;
import java.util.Arrays;

public class Connections {
    private static final String[] currentWords = {"CYPHER", "KEY", "PUZZLE", "CODE", "NEBULA", "PULSAR", "QUASAR", "SUPERNOVA", "DARK", "FOG", "LABRYNTH", "MAZE", "EPIPHANY", "INSIGHT", "REVELATION", "LIGHTBULB"};
    private static final String GUESSED = "~~~~~~~~";
    private static final String[] group1 = {"CODE", "CYPHER", "KEY", "PUZZLE"}; // sorted!
    private static final String[] group2 = {"NEBULA", "PULSAR", "QUASAR","SUPERNOVA"}; // sorted!
    private static final String[] group3 = {"DARK", "FOG", "LABRYNTH", "MAZE"}; // sorted!
    private static final String[] group4 = {"EPIPHANY", "INSIGHT", "LIGHTBULB", "REVELATION"}; // sorted!
    private static Scanner scanner = new Scanner(System.in);
    
    public static void play() {
        
        System.out.println("Welcome to Connections!");
        
        //Shuffles for printing
        shuffleArray(currentWords);
        
        //loops while all groups arent guessed: loop ends when theyre all guessed
        while(allStringsMatch(currentWords,GUESSED) != true) {
            //print in structure
            printArrayOnThreeLines(currentWords);
            
            //user input
            String[] guesses = getGuesses();
            //check if their guess is one of the groups
            if (checkIfMatchesGroup(guesses)) {
                //updates the 'currentWords' such that the next print will not display the guessed group
                updateCurrentWords(currentWords, guesses);
            }
            //will stop replaying the guessing loop if they have guessed all the groups
            if (allStringsMatch(currentWords, GUESSED)) {
                break;
            }
            
        }
    }
            
            // Check if all words are guessed - Ethan
    
    public static boolean allStringsMatch(String[] array, String target) {
        for (String str : array) {
            if (!str.equals(target)) {
                return false; // Return false if any string does not match the target
            }
        }
        System.out.println("\033[0;1m");
        System.out.println("Congratulations, you found all four groups!");
        return true; // If loop completes, all strings match the target
    }
    
    private static void updateCurrentWords(String[] currentWords, String[] groupToRemove) {
    
        for (String word : groupToRemove){
            for (int i = 0;i< currentWords.length; i++){
                if (currentWords[i].equals(word)){
                    currentWords[i] = "~~~~~~~~";
                    // break;    
                } 
            }
        }
    }

    
    private static String[] getGuesses() {
        String[] userGroup;
        while ( true ) {
            System.out.println("Enter your four guesses with a space in between: ");
            String userInput = scanner.nextLine();
            userGroup = userInput.split(" ");
            if ( userGroup.length != 4 ) {
                System.out.println("Invalid input. You must enter four words.");
            }
            else {
                break;
            }
        }
        System.out.println();
        return userGroup;
    }
    
    private static boolean checkIfMatchesGroup(String[] guesses) {
        //update to uppercase
        for(int i = 0; i<4; i++) {
            guesses[i] = guesses[i].toUpperCase();
        }

        //check if equal
        Arrays.sort(guesses);
        if (Arrays.equals(guesses, group1)) {
            // System.out.println("\033[0;1m");
            System.out.println("\033[0;1m CATEGORY GUESSED: likely to encounter on a treasure hunt");
            // System.out.println("\033[0;0m");
            return true;
        }
        if (Arrays.equals(guesses, group2)) {
            System.out.println("\033[0;1m CATEGORY GUESSED: celestial bodies");
            return true;
        }
        if (Arrays.equals(guesses, group3)) {
            System.out.println("\033[0;1m CATEGORY GUESSED: difficult to navigate");
            return true;
        }
        if (Arrays.equals(guesses, group4)) {
            System.out.println("\033[0;1m CATEGORY GUESSED: names for a good idea");
            return true;
        }
        
        return false;
    }
    
    private static void shuffleArray(String[] array)
    {
        int randomIndex;
        for (int i=0; i<array.length; i++)
        {
            randomIndex = (int)(Math.random()*array.length);
            String temp = array[randomIndex];
            array[randomIndex]= array[i];
            array[i]= temp;
        }
    }
    
    public static void printArrayOnThreeLines(String[] array) {
        int elementsPerLine = 4;
        System.out.println("\033[0;1m");
        for (int i = 0; i < array.length; i++) {
            
            System.out.print(array[i] + "    ");
            // Move to the next line after printing each group of 3 elements
            if ((i + 1) % elementsPerLine == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("\033[0;0m");
    }
}