package Q1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

/*
 * Q1966 - 프린트 큐
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int input = Integer.parseInt(br.readLine());

		while (input > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			LinkedList<int[]> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				queue.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}

			int cnt = 0;

			while (!queue.isEmpty()) {
				int[] front = queue.poll();
				boolean isMax = true;

				for (int i = 0; i < queue.size(); i++) {
					if (front[1] < queue.get(i)[1]) {
						queue.offer(front);
						for (int j = 0; j < i; j++) {
							queue.offer(queue.poll());
						}
						isMax = false;
						break;
					}
				}

				if (isMax == false) {
					continue;
				}

				cnt++;

				if (front[0] == M) {
					break;
				}
			}
			sb.append(cnt).append('\n');
			input--;
		}
		System.out.println(sb);
	}

}