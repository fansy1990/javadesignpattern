package chain.responsibility;

/**
 * Created by fansy on 2016/2/13.
 */
public class FirstFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setRequestMsg(request.getRequestMsg()+"-FirstFilter Request");
        filterChain.doFilter(request,response,filterChain);
        response.setResponseMsg(response.getResponseMsg()+"-FirstFilter Response");
    }
}
