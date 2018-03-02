package org.javaparser.examples.chapter3;


public class PrisonRules /* Maybe use Runnable? */ extends Thread {

    @Deprecated
    // What is
    // dibbs?
    private final String dibbs;

    public PrisonRules(final String dibbs) {
        this.dibbs = dibbs;
    }

    @Override // Is this really overridden?
    public void run() {
        System.out.println(dibbs);
    }

    public static void main(String[/* We should pass arguments in here */] args) {
        Thread t1 = new Thread(new PrisonRules("mine!") /* This should run first */);
        Thread t2 = new Thread(new PrisonRules("yoink!"));
        Thread t3 = new Thread(new PrisonRules("finders keepers!"));

        // Here Be Dragons
        t1/*(^_^)*/.start();
        t2/*(@_@)*/./*(¬_¬)*/start();
        /** We need more JavaDocs! */
        t3.start();

    }
}