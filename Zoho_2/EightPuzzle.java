public class EightPuzzle {

    static int getNullIndex(int[][] puzzle) {
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (puzzle[i][j] == 0) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    static void printPuzzle(int[][] puzzle) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (puzzle[i][j] != 0) {
                    System.out.print(" " + puzzle[i][j] + " |");
                } else {
                    System.out.print("   |");
                }
            }
            System.out.println("\n------------");
        }
        System.out.println();
    }

    static boolean checkWinner(int[][] puzzle) {
        int check = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (check == 9 && puzzle[i][j] == 0) {
                    return true;
                }
                if (puzzle[i][j] != check) {
                    return false;
                }
                check += 1;
            }
        }
        return false;
    }

    static boolean validatePosition(int i, int j) {
        return i >= 0 && i < 3 && j >= 0 && j < 3;
    }

    static void swap(int[][] puzzle, int cur_row, int cur_col, int new_row, int new_col) {
        int temp = puzzle[cur_row][cur_col];
        puzzle[cur_row][cur_col] = puzzle[new_row][new_col];
        puzzle[new_row][new_col] = temp;
    }


    static boolean solve(int[][] puzzle) {
        if (checkWinner(puzzle)) {
            printPuzzle(puzzle);
            System.out.println("YOU WON");
            return true;
        }
        printPuzzle(puzzle);
        int index = getNullIndex(puzzle);
        int row = index / 3;
        int col = index % 3;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int new_row = row + direction[0];
            int new_col = col + direction[1];
            if (validatePosition(new_row, new_col)) {
                swap(puzzle, row, col, new_row, new_col);

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] puzzle = {{2, 4, 7}, {4, 5, 6}, {8, 0, 7}};
        printPuzzle(puzzle);
        solve(puzzle);
    }
}
