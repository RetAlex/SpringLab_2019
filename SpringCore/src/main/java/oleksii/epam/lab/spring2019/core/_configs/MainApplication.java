package oleksii.epam.lab.spring2019.core._configs;


import oleksii.epam.lab.spring2019.core.beans.BeanA;
import oleksii.epam.lab.spring2019.core.beans.BeanB;
import oleksii.epam.lab.spring2019.core.spel.SpELObject;
import oleksii.epam.lab.spring2019.core.validation.NotSupportedException;
import oleksii.epam.lab.spring2019.core.validation.ObjectToValidate;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.io.IOException;
import java.nio.ByteBuffer;

@PropertySource("classpath:application.properties")
@ComponentScan({"oleksii.epam.lab.spring2019.core.beans", "oleksii.epam.lab.spring2019.core.validation"})
public class MainApplication {
    public static void main(String[] args) throws IOException {
        //The class passed to constructor is the main class from which
        ApplicationContext context = new AnnotationConfigApplicationContext(MainApplication.class);
        System.out.println("Context initialization finished");

//        useIoC(context);

//        useResource(context);

//        useValidation(context);

//        useSpEL(context);

//        useDataBuffer();
    }

    private static void useIoC(ApplicationContext context){
        System.out.println("\n------------------------- IoC (Dependency injection) usage showcase");

        Object beanA = context.getBean("beanA");
        System.out.println("Bean A is assignable to BeanA class: " + (beanA instanceof BeanA));
        try {
            context.getBean("beanB");
        }catch (NoSuchBeanDefinitionException e){
            System.out.println("Inside of catch block when trying to fetch BeanB instance by the incorrect name");
        }
        Object beanB = context.getBean("SpecialName");
        System.out.println("Bean B is assignable to BeanB class: " + (beanB instanceof BeanB));
        if(!(beanB instanceof BeanB)) throw new RuntimeException();
        BeanB castedInstance = (BeanB) beanB;
        System.out.println("Bean B has property BeanA injected: "+castedInstance.isBeanAAssigned()+"; and equals to existing bean A: "+castedInstance.getBeanA().equals(beanA));
    }

    /*
        Shows the usage of spring Resource and ResourceLoader interfaces.
        Created only for current specific showcase, shouldn't be used anywhere else.
        This method can only load small (int bytes length) resources.
     */
    private static void useResource(ApplicationContext context) throws IOException {
        System.out.println("\n------------------------- Resource usage showcase");

        Resource resourceNotExisting = context.getResource("http://dummyurl.not.exists");
        System.out.println("Dummy resource not exists: "+resourceNotExisting.exists());
        try{
            resourceNotExisting.readableChannel();
        }catch (IOException e){
            System.out.printf("Inside catch block for not existing resource: [%s] %s\n", e.getClass(), e.getMessage());
        }
        Resource resource = context.getResource("classpath:folder1/Resource01.txt");
        ByteBuffer content = ByteBuffer.allocate((int)resource.contentLength());
        resource.readableChannel().read(content);
        System.out.println("Valid resource exists: "+resource.exists());
        System.out.println("Existing resource content:");
        System.out.println(new String(content.array()));
    }

    /*
        Shows the usage of spring validation.
        This validation isn't the recommended way of validating in application and serves only as a showcase of a feature in spring core
     */
    private static void useValidation(ApplicationContext context){
        System.out.println("\n------------------------- Validation usage showcase");

        Validator validator = (Validator) context.getBean("objectValidator");
        if(!validator.supports(ObjectToValidate.class)) throw new NotSupportedException();

        ObjectToValidate validObject = new ObjectToValidate(10, "Not empty");
        Errors validObjectErrors = new BeanPropertyBindingResult(validObject, "objectToValidate");
        validator.validate(validObject, validObjectErrors);
        System.out.println("Valid object has no errors: "+!validObjectErrors.hasErrors());

        ObjectToValidate invalidObject = new ObjectToValidate(-85, "");
        Errors invalidObjectErrors = new BeanPropertyBindingResult(invalidObject, "objectToValidate");
        validator.validate(invalidObject, invalidObjectErrors);
        System.out.println("Invalid object has no errors: "+!invalidObjectErrors.hasErrors());

        for(var objectError: invalidObjectErrors.getAllErrors()){
            System.out.println("Error: "+objectError.getObjectName()+" - ["+objectError.getCode() + "] " + objectError.getDefaultMessage());
        }
    }

    /*
        Shows small fraction of the usage of spring SpEL
        To learn more, read here: https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#expressions
     */
    private static void useSpEL(ApplicationContext context){
        System.out.println("\n------------------------- SpEL usage showcase");

        SpELObject object = new SpELObject("Nikola Tesla", 10);
        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("name"); // Parse name as an expression
        System.out.println("Name expression result: " + exp.getValue(object));

        exp = parser.parseExpression("number < 10");
        System.out.println("Comparison expression result: " + exp.getValue(object, Boolean.class));
    }

    /*
        Shows usage of DataBuffer from spring core. This example is only for demonstration purposes.
     */
    private static void useDataBuffer(){
        System.out.println("\n------------------------- DataBuffer usage showcase");
        
        DefaultDataBufferFactory dataBufferFactory = new DefaultDataBufferFactory();

        DataBuffer buffer = dataBufferFactory.allocateBuffer(10);
        buffer.write("01234".getBytes());
        byte[] readBytes = new byte[3];
        buffer.read(readBytes, 0, 3);
        System.out.println("Read bytes in wave #1: "+new String(readBytes));

        buffer.write("56789".getBytes());
        readBytes = new byte[7];
        buffer.read(readBytes, 0, 7);
        System.out.println("Read bytes in wave #2: " + new String(readBytes));
    }
}
