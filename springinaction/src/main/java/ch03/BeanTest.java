package ch03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Bean
 * @date 2021.04.10
 */
@Configuration
public class BeanTest {

    @Bean
    @Conditional(MagicExistCondition.class)
    public MagicBean magicBean () {
        return new MagicBean();
    }
}
