package oleksii.epam.lab.spring2019.springdemofront.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class TranslationConfiguration {
    @Bean
    public MessageSource messageSource(){
        var messageSource = new ResourceBundleMessageSource();
        messageSource.addBasenames("i18n/translations");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /*
        Is not required for validation, only for resolving the message codes
     */
    @Bean
    public LocalValidatorFactoryBean getValidator(){
        var bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
