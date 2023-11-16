import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] [] board = new String[3] [3];

        board = cleanse(board);


        int round = 1;


        while (true) {
            while (true) {
                System.out.println("Round " + round + ":");
                printArray(board);

                if (gameFinished(board)) {
                    break;
                }


                if (round%2 != 0) {
                    while(true) {
                        System.out.println("X, make your move (row, col):");
                        String yourMove = scanner.nextLine();

                        String leftString = yourMove.substring(0, 1);
                        String rightString = yourMove.substring(2, 3);

                        int left = Integer.parseInt(leftString);
                        int right = Integer.parseInt(rightString);


                        if (left < 0 || left > 2 || right < 0 || right > 2) {
                            System.out.println("Invalid move: please try again.");
                            continue;
                        }

                        if (checkEmpty(board, left, right)) {
                            board[left] [right] = "X";
                            break;
                        } else {
                            System.out.println("Invalid move: please try again.");
                        }


                    }

                } else {
                    //bot turn


                    System.out.println("O, make your move (row, col):");
                    while (true) {
                        int row = generateInt();
                        int column = generateInt();
                        if (checkEmpty(board, row, column)) {
                            board[row][column] = "O";
                            break;
                        } else {
                            continue;
                        }
                    }
                }
                round++;



            }

            System.out.println("Play again? Y/N");

            String input = scanner.nextLine();

            if (input.toLowerCase().equals("n")) {
                break;
            } else if (input.toLowerCase().equals("y")) {
                round = 1;
                board = cleanse(board);

            }



        }






    }


    public static boolean gameFinished(String[][] arr) {

        for(int i = 0; i < 3; i++) {
            if (checkHorizontal(arr, i)) {

                if (arr[i][0].equals("X")) {
                    System.out.println("YOU WON!");
                } else {
                    System.out.println("YOU LOST!");
                }


                return true;
            }

        }

        for (int i = 0; i < 3; i++) {
            if (checkVertical(arr, i)) {


                if (arr[0][i].equals("X")) {
                    System.out.println("YOU WON!");
                } else {
                    System.out.println("YOU LOST!");
                }



                return true;
            }
        }

        if (checkDiagonal(arr)) {
            return true;
        }


        return false;



    }

    public static String[][] cleanse(String[][] arr) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = " ";
            }
        }

        return arr;

    }

    public static boolean checkDiagonal(String[][] arr) {
        if (arr[0][0].equals(arr[1][1]) && arr[0][0].equals(arr[2][2]) && !arr[0][0].equals(" ")) {
            if (arr[0][0].equals("X")) {
                System.out.println("YOU WON!");
            } else {
                System.out.println("YOU LOST!");
            }




            return true;
        }

        if (arr[0][2].equals(arr[1][1] )&& arr[0][2].equals(arr[0][2]) && !arr[0][2].equals(" ")){

            if (arr[0][2].equals("X")) {
                System.out.println("YOU WON!");
            } else {
                System.out.println("YOU LOST!");
            }


            return true;
        }



        return false;
    }

    public static boolean checkVertical(String[][] arr, int column) {
        if (!arr[0][column].equals(" ") && arr[0][column].equals(arr[1][column]) && arr[0][column].equals(arr[2][column])) {


            return true;

        } else {
            return false;
        }


    }

    public static boolean checkHorizontal(String[][] arr, int row) {
        String first = arr[row][0];

        if (first.equals(" ")) {
            return false;
        }


        for (int i = 1; i < 3; i++) {
            if (arr[row][i] != first) {
                return false;
            }


        }
        return true;

    }


    public static int generateInt() {
        double num = (int) (Math.random() * 3);

        return (int) num;
    }




    public static void printArray(String[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                    System.out.print("[" + arr[i] [j] + "]");




            }

            System.out.println();



        }

    }

    public static boolean checkEmpty(String[][] arr, int first, int second) {
        if (arr[first][second].equals(" ")) {
            return true;
        } else {
            return false;
        }


    }


}