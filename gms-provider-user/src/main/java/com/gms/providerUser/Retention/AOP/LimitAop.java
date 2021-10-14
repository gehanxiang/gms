package com.gms.providerUser.Retention.AOP;

import com.gms.providerUser.Common.ResultData;
import com.gms.providerUser.Common.ReturnCode;
import com.gms.providerUser.Retention.Limit;
import com.gms.providerUser.Utils.WebUtils;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

@Aspect
@Component
public class LimitAop {

    private final Map<String, RateLimiter> limitMap = Maps.newConcurrentMap();

    @Around("@annotation(com.gms.providerUser.Retention.Limit)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Limit limit = method.getAnnotation(Limit.class);
        if (limit != null) {
            String key=limit.key();
            RateLimiter rateLimiter;
            if (!limitMap.containsKey(key)) {
                rateLimiter = RateLimiter.create(limit.permitsPerSecond());
                limitMap.put(key, rateLimiter);
            }
            rateLimiter = limitMap.get(key);
            boolean acquire = rateLimiter.tryAcquire(limit.timeout(), limit.timeunit());
            if (!acquire) {
                this.responseFail(limit.msg());
                return null;
            }
        }
        return joinPoint.proceed();
    }

    private void responseFail(String msg)  {
        HttpServletResponse response=((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
        ResultData<Object> resultData = ResultData.fail(ReturnCode.LIMIT_ERROR.getCode(), msg);
        WebUtils.writeJson(response,resultData);
    }
}
