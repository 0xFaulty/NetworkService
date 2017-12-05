/*
package cloud.network.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath*:META-INF/spring.xml", ... })
public class NetInterfaceControllerTest2 {

    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @Test
    public void getInterfaceNames() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/v1/interfaces");
        request.setMethod("GET");

        MockHttpServletResponse response = new MockHttpServletResponse();

        HandlerExecutionChain handlerExecutionChain = handlerMapping.getHandler(request);

        HandlerInterceptor[] interceptors = handlerExecutionChain.getInterceptors();

        for(HandlerInterceptor interceptor : interceptors){
            interceptor.preHandle(request, response, handlerExecutionChain.getHandler());
        }

        ModelAndView mav = handlerAdapter. handle(request, response, handlerExecutionChain.getHandler());

        for(HandlerInterceptor interceptor : interceptors){
            interceptor.postHandle(request, response, handlerExecutionChain.getHandler(), mav);
        }

        assertEquals(200, response.getStatus());
    }

    @Test
    public void getInterfaceDetails() throws Exception {
    }

}*/
