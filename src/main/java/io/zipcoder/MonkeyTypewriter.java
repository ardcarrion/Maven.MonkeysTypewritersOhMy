package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) throws InterruptedException {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
        UnsafeCopier unsafeCopier = new UnsafeCopier(introduction);
        Thread monkey = new Thread(unsafeCopier);
        Thread mono = new Thread(unsafeCopier);
        Thread antonio = new Thread(unsafeCopier);
        Thread bob = new Thread(unsafeCopier);
        Thread doris = new Thread(unsafeCopier);
        monkey.start();
        monkey.setPriority(5);
        mono.start();
        mono.setPriority(2);
        antonio.start();
        bob.start();
        bob.setPriority(3);
        doris.start();

        SafeCopier safeCopier = new SafeCopier(introduction);
        Thread jobo = new Thread(safeCopier);
        Thread amydillo = new Thread(safeCopier);
        Thread btongs = new Thread(safeCopier);
        Thread noah = new Thread(safeCopier);
        Thread zoila = new Thread(safeCopier);
        jobo.start();
        jobo.setPriority(5);
        amydillo.start();
        amydillo.setPriority(2);
        btongs.start();
        noah.start();
        noah.setPriority(3);
        zoila.start();

        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        // Print out the copied versions here.
        System.out.println(unsafeCopier.copied);
        System.out.println("locks time");
        System.out.println(safeCopier.copied);
    }
}