import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888_연산자끼워넣기 {
	static int N; //수의 갯수
	static int[] num; // 숫자
	static int[] op; // 각 연산자 갯수
	static int[] arr; //연산자 순서를 담을 배열
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		st = new StringTokenizer(in.readLine(), " ");
		num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		op = new int[4];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());

		}
		arr = new int[N-1];
		for(int i=0; i<N-1; i++) {
			arr[i] = -1;
		}
		sol(0, 0);
		System.out.println(max);
		System.out.println(min);
	}
	public static void sol(int cnt, int depth) {
		if(depth == N-1) {
			int answer = num[0];
			for(int i=0; i<N-1; i++) {
				if(arr[i]==0) {
					answer += num[i+1];
				}
				else if(arr[i]==1) {
					answer -=num[i+1];
				}
				else if(arr[i]==2) {
					answer *=num[i+1];
				}
				else if(arr[i]==3) {
					answer /= num[i+1];
				}
				else {
					return;
				}
			}
			max = Math.max(answer, max);
			min = Math.min(answer, min);
			return;
		}
		
		for(int i=cnt; i<N-1; i++) { // 연산자 N-1번 뽑는 반복문

			for(int j=0; j<4; j++) { // 연산자 op 값이 존재하면 뽑아내고 다음 반복문으로 이동
				if(op[j]!=0 && i==depth) {
					arr[i] = j;
					op[j]--;
					sol(cnt+1, depth+1);
					sol(cnt, depth+1);
					op[j]++;
				}
				
			}
			
		}
			
	}
}
