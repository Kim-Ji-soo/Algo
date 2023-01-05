import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13458_시험감독 {
	static int N; //시험장의 갯수
	static int arr[]; // 각 시험장에 있는 응시자의 수 
	static int B; // 총감독관이 한 시험장에서 감시할수 있는 응시자의 수
	static int C; // 부감독관이 한 시험장에서 감시할 수 있는 응시자의 수
	static long answer = 0; // 
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine()); 
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		arr = new int[N]; 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine(), " ");
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			answer++; // 시험장마다 총감독관 1명이 필수로 필요함
			int needSub = arr[i]-B;
			if(needSub<=0) {
				continue;
			}
			if(needSub%C!=0) {
				answer += needSub/C +1;
			}
			else {
				answer += needSub/C;
			}
		}
		System.out.println(answer);
	}

}
