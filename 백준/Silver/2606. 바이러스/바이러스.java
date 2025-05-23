import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    // 김염된 컴퓨터 개수를 세는 전역 변수
    static int count = 0;
    static List<Integer>[] adj;
    static boolean[] infected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        infected = new boolean[N + 1];
        count = 0;
        worm(1);
        System.out.println(count);
    }

    static void worm(int w) {
        infected[w] = true;
        for (int nxt : adj[w]) {
            if (!infected[nxt]) {
                count++;  // 새로 감염된 컴퓨터만 카운트
                worm(nxt);
            }
        }
    }
}