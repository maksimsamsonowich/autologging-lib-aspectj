package eu.senla.customlibrary.trackstatus;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class TrackStatusAspect {

    @Around("@annotation(eu.senla.customlibrary.trackstatus.TrackStatus)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        final Object proceed = joinPoint.proceed();

        log.info("total execution time: " + (System.currentTimeMillis() - startTime) + "ms");

        String args = Arrays.stream(joinPoint.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));

        log.info(joinPoint + " args [" + args + "]");

        if (proceed == null)
            log.info("returning value = void");
        else
            log.info("returning value = " + proceed);

        log.info("method " + joinPoint + " completed its execution");

        return proceed;
    }


}
