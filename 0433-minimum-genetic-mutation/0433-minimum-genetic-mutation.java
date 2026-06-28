class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> set = new HashSet<>(Arrays.asList(bank));

        if (!set.contains(endGene)) {
            return -1;
        }

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(startGene);
        visited.add(startGene);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                String curr = q.poll();

                if (curr.equals(endGene)) {
                    return steps;
                }

                char[] arr = curr.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char ch : genes) {
                        if (ch == original) {
                            continue;
                        }

                        arr[i] = ch;
                        String next = new String(arr);

                        if (set.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }

                    arr[i] = original;
                }
            }

            steps++;
        }

        return -1;
    }
}