import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889_스타트와링크 {
	static int N; // 사람 수
	static int[][] arr; // 시너지 지표
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		arr = new int[N][N];
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];
		
		sol(0,0);
		System.out.println(answer);
	}
	public static void sol(int cnt, int depth) {
		if(depth == N/2) {
			int start = 0;
			int link = 0;
			for(int i=0; i<N; i++) {
				for(int j=i; j<N; j++) {
					if(visited[i]== true && visited[j]==true) {
						start += arr[i][j];
						start += arr[j][i];
					}
					else if(visited[i]==false && visited[j]==false) {
						link += arr[i][j];
						link += arr[j][i];
					}
				}
			}
			int min = Integer.MAX_VALUE;
			min = Math.abs(start-link);
			answer = Math.min(answer, min);
			return;
		}
		
		for(int i=cnt; i<N; i++) {
			if(visited[i]==false) {
				visited[i] = true;
				sol(i+1, depth+1);
				visited[i] = false;
			}

		}
	}
}
