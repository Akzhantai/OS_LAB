import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        int[] completionTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] waitingTime = new int[n];

        // Input arrival time and burst time for each process
        for (int i = 0; i < n; i++) {
            System.out.print("Enter arrival time for Process " + (i + 1) + ": ");
            arrivalTime[i] = scanner.nextInt();
            System.out.print("Enter burst time for Process " + (i + 1) + ": ");
            burstTime[i] = scanner.nextInt();
        }

        // Calculate completion time for each process
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
            currentTime = Math.max(currentTime, arrivalTime[i]); // Ensure process starts after arrival
            completionTime[i] = currentTime + burstTime[i];
            currentTime = completionTime[i];
        }

        // Calculate turnaround time and waiting time for each process
        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = completionTime[i] - arrivalTime[i];
            waitingTime[i] = turnaroundTime[i] - burstTime[i];
        }

        // Calculate average turnaround time, waiting time, and completion time
        double avgTurnaroundTime = calculateAverage(turnaroundTime);
        double avgWaitingTime = calculateAverage(waitingTime);
        double avgCompletionTime = calculateAverage(completionTime);

        // Output results
        System.out.println("\nProcess\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + arrivalTime[i] + "\t\t\t" + burstTime[i] + "\t\t\t" +
                    completionTime[i] + "\t\t\t" + turnaroundTime[i] + "\t\t\t" + waitingTime[i]);
        }

        System.out.println("\nAverage Turnaround Time: " + avgTurnaroundTime);
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Completion Time: " + avgCompletionTime);
    }

    private static double calculateAverage(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (double) sum / array.length;
    }
}
