package com.spring.core.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TelephonyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // Only return true if the 'telephonyService' bean is defined
        return context.getBeanFactory().containsBeanDefinition("telephonyService");
    }
}