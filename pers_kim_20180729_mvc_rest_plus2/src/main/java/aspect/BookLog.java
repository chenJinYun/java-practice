package aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Create on 7/26/2018
 *
 * @Author Kim
 */
@Component
@Aspect
public class BookLog {
    private Log log = LogFactory.getLog(BookLog.class);
    private final String POINT_CUT = "execution(* service.*.*(..))";

    @Before(value = POINT_CUT)
    public void logBefored() {
        log.info("log befored");
    }

    @Around(value = POINT_CUT)
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("book log befored....");
        Object proceed = proceedingJoinPoint.proceed();
        log.info("book log after....");
        return proceed;
    }
}
