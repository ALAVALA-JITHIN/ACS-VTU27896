import java.util.*;

public class TaskScheduler{

    public static int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char c : tasks) {
            freq[c - 'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25];

        int maxCount = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        return Math.max(tasks.length,
                (maxFreq - 1) * (n + 1) + maxCount);
    }

    public static void main(String[] args) {

        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        int result = leastInterval(tasks, n);

        System.out.println("Minimum intervals: " + result);
    }
}
