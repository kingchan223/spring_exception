package hello.exception.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        log.info("call resolver", ex);

        try{
            if( ex instanceof IllegalArgumentException){
                log.info("IllegalArgumentException resolver to 400" );
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
                return new ModelAndView();
            }
        }catch(Exception e){
            log.error("resolver ex", ex);
        }
        return null;//null로 리턴하면 계쏙 예외가 터져서 나간다.
    }
}
