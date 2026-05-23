class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        // add all stones
        for (int stone : stones) {
            pq.add(stone);
        }

        // keep smashing
        while (pq.size() > 1) {

            int first = pq.poll();   // largest
            int second = pq.poll();  // second largest

            // if not equal, add difference
            if (first != second) {
                pq.add(first - second);
            }
        }

        // if empty return 0
        return pq.isEmpty() ? 0 : pq.poll();
    }
}