package ch03;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className MagicExistCondition
 * @date 2021.04.10
 */
public class MagicExistCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        Environment environment = conditionContext.getEnvironment();
        return environment.containsProperty("magic");
    }
}
