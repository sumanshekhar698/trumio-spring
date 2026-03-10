package com.spring.core.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class);

        AtmAsyncService service = context.getBean(AtmAsyncService.class);

        System.out.println("[MAIN] Requesting email receipt...");
        service.sendEmailReceipt(1234); // This returns INSTANTLY

        System.out.println("[MAIN] I am not waiting for the email! Moving on...");

        // We keep the application running for 15 seconds 
        // so we can see the @Scheduled tasks and @Async results.
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        // This creates a "latch" that waits for 1 event
        CountDownLatch latch = new CountDownLatch(1);

        // Use a Shutdown Hook to close the context cleanly
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            context.close();
            latch.countDown(); // Releases the main thread
        }));

        Thread.sleep(9000);

//        latch.countDown(); // Releases the main thread

        System.out.println("App is running... Press Ctrl+C to stop.");
        latch.await(); // Main thread sleeps here indefinitely

        context.close();
        System.out.println("[MAIN] Application Closed.");
    }
}