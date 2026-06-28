class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int curr = q.poll();

                if (curr == n * n) {
                    return moves;
                }

                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int[] pos = getPosition(next, n);
                    int r = pos[0], c = pos[1];

                    int dest = board[r][c] == -1 ? next : board[r][c];

                    if (!visited[dest]) {
                        visited[dest] = true;
                        q.offer(dest);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private int[] getPosition(int num, int n) {
        int row = n - 1 - (num - 1) / n;
        int col = (num - 1) % n;

        if (((n - 1 - row) & 1) == 1) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }
}