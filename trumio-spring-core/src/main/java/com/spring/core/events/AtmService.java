package com.spring.core.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class AtmService {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void withdraw(int id, double amt) {
        System.out.println("[SERVICE] Processing withdrawal for Account #" + id);

        // Business logic happens here...

        // Now, broadcast the news!
        publisher.publishEvent(new WithdrawalEvent(id, amt));

        System.out.println("[SERVICE] Withdrawal method finished.");
    }
}