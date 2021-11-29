package configuration;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.ClientServiceTest;



@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);
	@Before("execution(* tn.esprit.spring.service.ClientServiceImpl.*(..))")
			public void logMethodEntry(JoinPoint joinPoint) {
			String name = joinPoint.getSignature().getName();
			logger.info("In method " + name + " : ");
			System.out.println("In method " + name + " : ");
			}
			@After("execution(* tn.esprit.spring.service.ClientServiceImpl.*(..))")
			
			public void logMethodExit(JoinPoint joinPoint) {
			String name = joinPoint.getSignature().getName();
			logger.debug("Out of " + name );
			}}