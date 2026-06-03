class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] mark = new boolean[board.length];

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(mark, false);

            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];

                if (c >= '1' && c <= '9') {
                    if (mark[c - '1']) {
                        return false;
                    }

                    mark[c - '1'] = true;
                }
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            Arrays.fill(mark, false);

            for (int i = 0; i < board.length; i++) {
                char c = board[i][j];

                if (c >= '1' && c <= '9') {
                    if (mark[c - '1']) {
                        return false;
                    }

                    mark[c - '1'] = true;
                }
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                Arrays.fill(mark, false);

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char c = board[i + k][j + l];

                        if (c >= '1' && c <= '9') {
                            if (mark[c - '1']) {
                                return false;
                            }

                            mark[c - '1'] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
