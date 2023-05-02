package test.goorm.exam;

import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());

		Stack<PhoneLog> st = new Stack<>();
		for(int i = 0 ; i < n ; i ++)
		{
			String log = br.readLine();
			if(!st.isEmpty()) {
				PhoneLog recentLog = st.peek();
				if(recentLog.getInfo().equals(log)){
					recentLog.setCnt(recentLog.getCnt() + 1);
				}else{
					st.push(new PhoneLog(log, 1));
				}
			}
			else{
				st.push(new PhoneLog(log, 1));
			}
		}
		System.out.println(st.size());
		for(PhoneLog log : st){
			System.out.println(log.getStringinfo());
		}
	}

	static class PhoneLog {
		String info;
		int cnt;

		public PhoneLog(String info, int cnt) {
			this.info = info;
			this.cnt = cnt;
		}

		public String getInfo() {
			return info;
		}

		public void setInfo(String info) {
			this.info = info;
		}

		public int getCnt() {
			return cnt;
		}

		public void setCnt(int cnt) {
			this.cnt = cnt;
		}

		public String getStringinfo(){
			String result = "";
			if(cnt > 1){
				result = String.format("%s (%d)", this.info, this.cnt);
			}
			else{
				result = this.info;
			}
			return result;
		}
	}
}