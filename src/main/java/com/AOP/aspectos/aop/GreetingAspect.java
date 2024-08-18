package com.AOP.aspectos.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Aspect
@Component
public class GreetingAspect {
    // Registrar logs de esta clase
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /* Pointcut: dentro de before se especifica la clase o interface y el método donde se va a aplicar el aspect
    podemos colocar un * para indicar el aspect se va a aplicar a todos lod métodos de esa clase
    o todas las clases de un paquete, o a todos los sub paquetes de un paquete
    * */
    @Before("GreeetingServicePointcut.greetingLoggerPointcut()")
    public void loggerBefore(JoinPoint joinPoint){
        // obtener el nombre del metodo
        String method = joinPoint.getSignature().getName();
        // obtener los argumentos que se pasan como parametros a la funci[on
        String args = Arrays.toString(joinPoint.getArgs());
        //Mostrar en el logger
        logger.info("Antes - metodo: " + method + " " + "Argumentos: " + args);
    }

    @After("GreeetingServicePointcut.greetingLoggerPointcut()")
    public void loggerAfter(JoinPoint joinPoint){
        // obtener el nombre del metodo
        String method = joinPoint.getSignature().getName();
        // obtener los argumentos que se pasan como parametros a la funci[on
        String args = Arrays.toString(joinPoint.getArgs());
        //Mostrar en el logger
        logger.info("Despues - metodo: " + method + " " + "Argumentos: " + args);
    }

    @AfterReturning("GreeetingServicePointcut.greetingLoggerPointcut()")
    public void loggerAfterReturning(JoinPoint joinPoint){
        // obtener el nombre del metodo
        String method = joinPoint.getSignature().getName();
        // obtener los argumentos que se pasan como parametros a la funci[on
        String args = Arrays.toString(joinPoint.getArgs());
        //Mostrar en el logger
        logger.info("Despues de RETORNAR - metodo: " + method + " " + "Argumentos: " + args);
    }

    @AfterThrowing("GreeetingServicePointcut.greetingLoggerPointcut()")
    public void loggerAfterThrowing(JoinPoint joinPoint){
        // obtener el nombre del metodo
        String method = joinPoint.getSignature().getName();
        // obtener los argumentos que se pasan como parametros a la funci[on
//        String args = Arrays.toString(joinPoint.getArgs());
        //Mostrar en el logger
        logger.info("Despues pero ANTES de lanzar una excepcion  - metodo: " + method);
    }

    @Around("GreeetingServicePointcut.greetingLoggerPointcut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try{
            logger.info("AROUND - el método " + method + " tiene los siguientes argumentos: " + args);
            // Obtener lo que retorna el método
            result = joinPoint.proceed();
            logger.info("RETURN = " + result);
            return result;
        }catch (Throwable e){
            logger.error("Error al ejecutare el método " + method);
            throw e;
        }
    }
}
