package cn.croff.backtracking;

/**
 * 37. Sudoku Solver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all of the following rules:
 * - Each of the digits 1-9 must occur exactly once in each row.
 * - Each of the digits 1-9 must occur exactly once in each column.
 * - Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * - Empty cells are indicated by the character '.'.
 * <p>
 * Note:
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        int remains = 0;
        for (char[] row : board) {
            for (char ch : row) {
                if (ch == '.') remains++;
            }
        }

        solveSudoku(board, 0, 0, remains);
    }

    private boolean solveSudoku(char[][] board, int x, int y, int remains) {
        if (remains == 0) {
            return true;
        }

        int nextX = (x + 1) % 9;
        int nextY = (y + (x + 1) / 9) % 9;
        if (board[y][x] == '.') {
            boolean[] flags = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][x] != '.') flags[board[i][x] - '0' - 1] = true;
            }
            for (int i = 0; i < 9; i++) {
                if (board[y][i] != '.') flags[board[y][i] - '0' - 1] = true;
            }
            int boxStartX = x / 3 * 3, boxStartY = y / 3 * 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[boxStartY + i][boxStartX + j] != '.')
                        flags[board[boxStartY + i][boxStartX + j] - '0' - 1] = true;
                }
            }

            for (int i = 0; i < 9; i++) {
                if (!flags[i]) {
                    board[y][x] = (char) (i + 1 + '0');
                    if (solveSudoku(board, nextX, nextY, remains - 1)) return true;
                    board[y][x] = '.';
                }
            }
        } else {
            return solveSudoku(board, nextX, nextY, remains);
        }
        return false;
    }
}
