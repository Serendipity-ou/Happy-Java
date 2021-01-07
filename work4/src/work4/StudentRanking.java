package work4;

import java.util.Scanner;

public class StudentRanking {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int maxx = 1000;
		int n;
		int temp1;
		String temp2;
		String[] Sname = new String[maxx];
		int[] Sscore = new int[maxx];
		
		System.out.print("输入学生个数: ");
		n = input.nextInt();
		for(int i = 0; i < n; i++) {
			System.out.print("输入学生姓名: ");
			Sname[i] = input.next();
			System.out.print("输入学生成绩: ");
			Sscore[i] = input.nextInt();
		}
		for(int j = 1; j < n; j++) {
			for(int i = 1; i < n; i++) {
				if(Sscore[i-1] < Sscore[i]) {
					temp1 = Sscore[i-1];
					Sscore[i-1] = Sscore[i];
					Sscore[i] = temp1;
					temp2 = Sname[i-1];
					Sname[i-1] = Sname[i];
					Sname[i] = temp2;
				}
			}
		}
		for(int i = 0; i < n; i++) 
			System.out.println("学生: " + Sname[i] + " 成绩: " + Sscore[i]);
	}
}
