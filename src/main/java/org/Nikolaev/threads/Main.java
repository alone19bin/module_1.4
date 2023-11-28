package main.java.org.Nikolaev.threads;

import main.java.org.Nikolaev.threads.Foo;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();

        Runnable firstRunnable = () -> System.out.print("first");
        Runnable secondRunnable = () -> System.out.print("second");
        Runnable thirdRunnable = () -> System.out.print("third");

        startThread(() -> {
            try {
                foo.first(firstRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        startThread(() -> {
            try {
                foo.third(thirdRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        startThread(() -> {
            try {
                foo.second(secondRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void startThread(Runnable runnable) {
        new Thread(runnable).start();
    }
}
