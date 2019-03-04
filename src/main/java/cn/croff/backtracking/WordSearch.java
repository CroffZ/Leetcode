package cn.croff.backtracking;

/**
 * 79. Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * Example:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        if (word == null || word.isEmpty()) return false;

        // 用一个二维boolean数组记录访问过的点
        boolean[][] visited = new boolean[board.length][board[0].length];
        // 对每个点调用递归DFS查找方法
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 如果当前点的查找结果为true，则说明找到了
                if (search(board, i, j, visited, word, 0)) return true;
            }
        }
        return false;
    }

    /**
     * 递归DFS查找
     *
     * @param board   Word Board
     * @param i       当前点纵坐标
     * @param j       当前点横坐标
     * @param visited 访问记录
     * @param word    要查找的Word
     * @param index   当前查找的字符在Word中的下标
     * @return 查找结果
     */
    private boolean search(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
        // 已经查找完Word中所有字符，返回true
        if (index == word.length()) return true;
        // 越界情况和已访问过的情况，直接返回false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return false;

        if (board[i][j] == word.charAt(index)) {
            // 当前点字符与Word当前下标字符匹配，先记录visited，再继续向周围递归查找
            visited[i][j] = true;
            if ((search(board, i - 1, j, visited, word, index + 1)) ||
                    (search(board, i + 1, j, visited, word, index + 1)) ||
                    (search(board, i, j - 1, visited, word, index + 1)) ||
                    (search(board, i, j + 1, visited, word, index + 1))) return true;
            visited[i][j] = false;
        }
        return false;
    }
}
