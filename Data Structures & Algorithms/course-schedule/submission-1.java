class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // find course(s) with no prereqs, this is the starting point
        // track # of prereqs left for each course, every time a prereq is taken, this # goes down
        // once a course has 0 prereqs left, it can be taken (in the queue)
        // adjacency list to next course allows me to traverse, list of prereqs left for each course
        // these lists are opposite directions
        // use queue of next course to visit, loop while not empty
        // keep track of courses taken against initial numCourses, return true if equal at the end
        int coursesTaken = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> nextCourses = getNextCourseAdj(numCourses, prerequisites);
        int[] prereqsLeft = getPrereqsLeft(numCourses, prerequisites);

        for (int i = 0; i < prereqsLeft.length; i++) {
            if (prereqsLeft[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            coursesTaken++;
            for (int next : nextCourses.get(course)) {
                prereqsLeft[next]--;
                if (prereqsLeft[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return coursesTaken == numCourses;
    }

    private List<List<Integer>> getNextCourseAdj(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pr : prerequisites) {
            adj.get(pr[1]).add(pr[0]);
        }
        return adj;
    }

    private int[] getPrereqsLeft(int numCourses, int[][] prerequisites) {
        int[] prereqsLeft = new int[numCourses];
        for (int[] pr : prerequisites) {
            prereqsLeft[pr[0]]++;
        }
        return prereqsLeft;
    }
}
