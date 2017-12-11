package zuul;

import com.netflix.client.http.HttpRequest;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Administrator on 2017/12/9 0009.
 */

@Component
public class AccessFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(ZuulFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }



    @Value("${from}")
    String form ;

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info("send{} request {}",request.getMethod(),request.getRequestURL()+"   >>>>>"+form);
        Object token = request.getParameter("accessToken");
        log.info(request.getParameterMap().toString());
        if (token==null){
            log.warn(  "    accessToken is empty !");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            return  null ;
        }
        log.info("access token is ok ");
        return null;
    }
}
