package test.doit.search;

import java.io.*;
import java.util.*;
public class P11724_연결요소의개수 {
  static ArrayList<Integer>[] A;
  static boolean visited[];

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int num = Integer.parseInt(st.nextToken());
    int cnt = Integer.parseInt(st.nextToken());

    A = new ArrayList[num + 1];

    visited = new boolean[num + 1];
    for(int i = 1 ; i <= num; i ++) {
      A[i] = new ArrayList<>();
    }

    for(int i = 1; i <= cnt; i++) {
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());

      A[first].add(second);
      A[second].add(first);
    }

    int result = 0;


    for(int i = 1; i <= num; i++) {
      if(!visited[i]){
        result++;
        dfs(i);
      }
    }
    System.out.println(result);
  }

  public static void dfs(int i) {
    if(visited[i]) {
      return;
    }

    visited[i] = true;
    for(int j = 0; j < A[i].size(); j++){
      int find = A[i].get(j);
      if(!visited[find]) {
        dfs(find);
      }
    }
  }












//  public static void main1(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    int n = Integer.parseInt(st.nextToken());
//    int m = Integer.parseInt(st.nextToken());
//    A = new ArrayList[n + 1];
//    visited = new boolean[n + 1];
//    for (int i = 1; i < n + 1; i++) { // ���� ����Ʈ �ʱ�ȭ
//      A[i] = new ArrayList<Integer>();
//    }
//    for (int i = 0; i < m; i++) {
//      st = new StringTokenizer(br.readLine());
//      int s = Integer.parseInt(st.nextToken());
//      int e = Integer.parseInt(st.nextToken());
//      A[s].add(e); // �� ���� �����̹Ƿ� �������� ������ �� ���ش�
//      A[e].add(s);
//    }
//    int count = 0;
//    for (int i = 1; i < n + 1; i++) {
//      if (!visited[i]) { // �� �湮�� ������ ���� ������ �ݺ�
//        count++;
//        DFS(i);
//      }
//    }
//    System.out.println(count);
//  }
//  static void DFS(int v) {
//    if (visited[v]) {
//      return;
//    }
//    visited[v] = true;
//    for (int i : A[v]) {
//      if (visited[i] == false) { // ���� ���� �� �湮���� �ʾҴ� ������ Ž����
//        DFS(i);
//      }
//    }
//  }
}
