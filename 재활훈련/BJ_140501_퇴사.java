import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501_퇴사 {
	static int N; // 전체 기간
	static int[] T; // 상담 기간
	static int[] P; // 상담 금액
	static boolean[] visited;
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		T = new int[N];
		P = new int[N];
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N];
		sol(0,0);
		System.out.println(answer);
	}
	
	public static void sol(int start, int cnt) {
		if(start > N) {
			return;
		}
		for(int i=start; i<N; i++) {
			if(i+T[i]<=N && visited[i]==false) {
				for(int j=i; j<i+T[i];j++) {
					visited[j] = true;
				}

				cnt = cnt+P[i];
				sol(i+T[i],cnt);
				cnt = cnt-P[i];
				for(int j=i; j<i+T[i];j++) {
					visited[j] = false;
				}
			}
		}
		answer = Math.max(answer, cnt);
		start++;
		sol(start, 0);
	}
}
