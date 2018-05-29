package cn.croff.greedy;

import java.util.Scanner;

public class TaskScheduler {

    private static int leastInterval(char[] tasks, int n) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        char[] tasks = new char[length];
        for (int i = 0; i < length; i++) {
            tasks[i] = (char) scanner.nextInt();
        }
        int interval = scanner.nextInt();
        scanner.close();
        int time = leastInterval(tasks, interval);
        System.out.println(time);
    }
}
