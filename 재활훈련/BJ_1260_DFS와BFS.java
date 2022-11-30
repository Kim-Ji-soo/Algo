import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {
    static int N; // 정점의 갯수
    static int M; // 간선의 갯수
    static int V; // 시작 정점의 번호 V
    static int [][] map;
    static boolean[] visited;
  
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1]; // 그래프의 인접행렬
        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        visited = new boolean[N+1];
        System.out.print(V);
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        System.out.print(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i=1; i<=N; i++){
                if(map[temp][i]==1 && visited[i]==false){
                    visited[i]=true;
                    queue.offer(i);
                    System.out.print(" "+i);
                }
            }
        }
    }

    static void dfs(int start){
        visited[start] = true;
        for(int i=1; i<=N; i++){
            if(map[start][i]==1 && visited[i]==false){
                visited[i] = true;
                System.out.print(" "+i);
                dfs(i);
            }
        }
    }
}
