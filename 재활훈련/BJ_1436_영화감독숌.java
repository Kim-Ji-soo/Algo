import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1436_영화감독숌 {
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		while(N != 0) {
			count++;
			String str = Integer.toString(count);
			if(str.contains("666")) {
				N--;
			}
		}
		System.out.println(count);
	}
}
