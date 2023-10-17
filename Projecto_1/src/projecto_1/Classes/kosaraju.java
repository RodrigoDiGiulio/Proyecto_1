/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projecto_1.Classes;

/**
 * La clase kosaraju, el algoritmo
 * @author RDG
 * @param <T>
 * @version 10/16/2023
 */
public class kosaraju {
    
    static final int MAX = 10000;
    static int[][] graph = new int[MAX][MAX];
    static int[][] transpose = new int[MAX][MAX];
    static stack<Integer> stack = new stack<>();
    static boolean[] visited = new boolean[MAX];

    static void DFS1(int node, int n) {
        visited[node] = true;
        for (int i = 0; i < n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                DFS1(i, n);
            }
        }
        stack.push(node);
    }

    static void DFS2(int node, int n) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 0; i < n; i++) {
            if (transpose[node][i] == 1 && !visited[i]) {
                DFS2(i, n);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS1(i, n);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpose[i][j] = graph[j][i];
            }
        }

        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                DFS2(node, n);
                System.out.println();
            }
        }
    }
}