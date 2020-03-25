package cn.itxiaoliu.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.List;

public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        SysException exception=null;
        if(ex instanceof SysException){
            exception=(SysException)ex;
        }else{
            exception=new SysException("系统正在维护");
        }
        ModelAndView mv=new ModelAndView();
        mv.addObject("errorMsg",exception.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
