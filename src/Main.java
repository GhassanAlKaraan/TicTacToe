import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char [] [] gameBoard = {
                {' ', '|', ' ', '|', ' '},{'-', '+', '-', '+', '-'}, {' ', '|', ' ', '|', ' '},{'-', '+', '-', '+', '-'}, {' ', '|', ' ', '|', ' '}
        };
        printGameBoard(gameBoard);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number between 1-9");
        int position = scanner.nextInt();

        System.out.println(position);

        switch (position){
            case 1:
                gameBoard[0][0] = 'x';
                break;
            case 2:
                gameBoard[0][2] = 'x';
                break;
            case 3:
                gameBoard[0][4] = 'x';
                break;
            case 4:
                gameBoard[2][0] = 'x';
                break;
            case 5:
                gameBoard[2][2] = 'x';
                break;
            case 6:
                gameBoard[2][4] = 'x';
                break;
            case 7:
                gameBoard[4][0] = 'x';
                break;
            case 8:
                gameBoard[4][2] = 'x';
                break;
            case 9:
                gameBoard[4][4] = 'x';
                break;

        }
        printGameBoard(gameBoard);
    }

    public static void printGameBoard (char [][] gameBoard){
        for (char [] row : gameBoard){
            for (char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}