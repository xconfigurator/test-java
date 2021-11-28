package liuyang.algorithms;

import java.util.Arrays;

/*
视频 (5:37开始看 前面的讲解一团糟)
https://www.bilibili.com/video/BV1B4411w7Hn?spm_id_from=333.999.0.0

一个非常好的网站
https://www.geeksforgeeks.org/
https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/

LeetCode题目
https://leetcode-cn.com/problems/redundant-connection/

@since 2021/11/23
@author liuyang
*/
public class DisjointSetHappygirlzt {
    public static void main(String[] args) {
        System.out.println("foo xxx");
        int[][] edges = {{1,2}, {1, 3}, {2, 3}};
        int[] edge = findRedundantConnection(edges);
        if (edge.length != 0){
            Arrays.stream(edge).forEach(System.out::println);
        }
    }

    static class DSU {
        int[] root;
        int[] size;

        public DSU(int n) {
            root = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        // pass compression
        public int find(int x) {
            if (root[x] != x) {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return false;
            if (size[rootX] < size[rootY]) {
                root[rootX] = rootY;
                size[rootY] ++;
            } else {
                root[rootY] = rootX;
                size[rootX] ++;
            }
            return true;
        }

    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n + 1);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }
}
