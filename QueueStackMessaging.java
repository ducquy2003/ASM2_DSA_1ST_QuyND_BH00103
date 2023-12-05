package ASM;

import java.util.Scanner;

public class QueueStackMessaging {
    public static void main(String[] args) {
        Queue<String> messageQueue = new Queue<>();
        Stack<String> messageStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu Options:");
            System.out.println("1. Input Message");
            System.out.println("2. Send Message");
            System.out.println("3. View Sent Messages");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter messages (one per line). Press Enter with an empty message to finish:");
                    String inputMessage;
                    do {
                        inputMessage = scanner.nextLine();
                        if (!inputMessage.isEmpty()) {
                            if (inputMessage.length() <= 250) {
                                messageQueue.enqueue(inputMessage);
                                System.out.println("Message enqueued successfully.");
                            } else {
                                System.out.println("Message length exceeds the maximum limit (250 characters).");
                            }
                        }
                    } while (!inputMessage.isEmpty());
                    break;
                case 2:
                    try {
                        String sentMessage = messageQueue.dequeue();
                        messageStack.push(sentMessage);
                        System.out.println("Message sent: " + sentMessage);
                    } catch (IllegalStateException e) {
                        System.out.println("Message queue is empty. Cannot send message.");
                    }
                    break;
                case 3:
                    System.out.println("Viewing Sent Messages:");
                    while (!messageStack.isEmpty()) {
                        System.out.println(messageStack.pop());
                    }
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}