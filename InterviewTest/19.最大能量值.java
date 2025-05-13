/*
 * The current selected programming language is java. We emphasize the submission of a fully working codeover partially correct but efficient code. Once submitted, you cannot review this problem again. You canuse System.out,println() to debug your code. The System.out.println( may not work in case ofsyntax/runtime error. The version ofjDK being used is 1.8
Note: The main class name must be "Solution".
A random game is being played in teams by N kids, each with strength Xi. The kids stand in a line with thefir'st kid at position 1, the second at 2, and so on. A person draws M cards randomly from a box, each cardcontaining a pair of numbers that represents the position of kids belonging to the same team. Forexample, if a card contains [1, 4] and another contains [4, 3], then the kids at positions [1, 4, 3] belong tothe same team. The kids whose positions do not come up on any of the cards participate as one-personteams.
Each team's power is determined by the sum of the strengths of the kids on the team. The team with thehighest power wins. Design an algorithm that outputs the power of the winning team.

Input
The first line of the input consists of an integer- num, representing the number of kids (N)
The second line consists of N space-separated integers, representing the kids' strength.
The third line input consists of two space-separated integers - numCards and pairCount, representing thenumber oftimes the cards are drawn (M) and the number of positions of the students that make a pair (cis always equal to 2), respectively.
The next M lines consist of C space-separated integers, representing the positions of the

Output
Print an integer representing the power of the winning team.
Constraints
1snums105
0snumCardss105
0 ≤X≤ 1012, whereXrepresents kids' strength

Input :
6
11 2 3 15 8 22
3 2
1 2

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class UF {
    int[] root;
    int count;

    public UF(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        count = n;
    }
    public int count() {
        return count;
    }

    public int find(int x) {
        return root[x];
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        for (int i = 0; i < root.length; i++) {
            if (root[i] == rootY) {
                root[i] = rootX;
            }
        }
        count--;
    }
}

class Solution {
    public int findWinningTeamPower(int[] strengths, int[][] cardPositions) {
        if (strengths == null || strengths.length <= 0) {
            return 0;
        }
        int N = strengths.length;
        int numCards = cardPositions.length;
        int pairCount = cardPositions[0].length;
        UF unionFind = new UF(N);
        for (int i = 0; i < numCards; i++) {
            unionFind.union(cardPositions[i][0] - 1, cardPositions[i][1] - 1);
        }
        Map<Integer, Integer> strengthMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int root = unionFind.find(i);
            strengthMap.put(root, strengthMap.getOrDefault(root, 0) + strengths[i]);
        }
        int maxPower = 0;
        for (int power : strengthMap.values()) {
            maxPower = Math.max(power, maxPower);
        }
        return maxPower;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] strengths = new int[N];
        for (int i = 0; i < N; i++) {
            strengths[i] = sc.nextInt();
        }
        int numCards = sc.nextInt();
        int pairCount = sc.nextInt();
        int[][] cardPositions = new int[numCards][pairCount];
        for (int i = 0; i < numCards; i++) {
            for (int j = 0; j < pairCount; j++) {
                cardPositions[i][j] = sc.nextInt();
            }
        }
        sc.close();
        Solution solution = new Solution();
        int maxPower = solution.findWinningTeamPower(strengths, cardPositions);
        System.out.println(maxPower);
    }
}