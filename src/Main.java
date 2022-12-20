import java.util.*;

public class Main {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {


        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
        printGameBoard(gameBoard);

        while (true) {
            //prompt user for number, and draw the X at that position
            System.out.println("Enter number between 1-9");
            Scanner scanner = new Scanner(System.in);
            int playerPos = scanner.nextInt();
            //making sure the user doesnt enter any taken position from before
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("Position taken, enter another position bro!");
                playerPos = scanner.nextInt();
            }

            placePiece(gameBoard, playerPos, "player");

            //generate a new random number, and draw the O at that position
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            //making sure the cpu wont choose any taken position from before
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "cpu");
            String result = checkWinner();
            if(result.length() > 0){
                printGameBoard(gameBoard);
                System.out.println(result);
                break;
            }

            printGameBoard(gameBoard);
            result = checkWinner();
            if(result.length() > 0){
                printGameBoard(gameBoard);
                System.out.println(result);
                break;
            }

        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int position, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(position);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(position);
        }

        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner() {
        //winning combinations
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List leftCross = Arrays.asList(1, 5, 9);
        List rightCross = Arrays.asList(7, 5, 3);

        //add the combinations lists to an arrayList
        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(leftCross);
        winning.add(rightCross);

        //iterate using for-each loop to check if any arrayList has got the winning combination
        for (List l : winning) {
            //containsAll method used to see if all elements of a combination exist in an arrayList
            if (playerPositions.containsAll(l)) {
                return "Congrats, You Won.";
            } else if (cpuPositions.containsAll(l)) {
                return "go home bro.";
            }else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "TIE";
            }
        }

        return "";
    }
}