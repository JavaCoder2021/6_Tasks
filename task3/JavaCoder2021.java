package javacoder2021;

public class JavaCoder2021 {

    public static void main(String[] args) {
                      
        Thread one = new Thread(() -> by.epam.tasks.task3.server.Main.main(args));
        Thread two = new Thread(() -> by.epam.tasks.task3.client.Main.main(args));

        one.start();
        two.start();

        try {
            one.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            
    }

}
