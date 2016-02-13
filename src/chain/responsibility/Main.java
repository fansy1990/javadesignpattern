package chain.responsibility;

/**
 * Created by fansy on 2016/2/13.
 */
public class Main {
    public static void main(String[] arts){
        String msg = "abcdefg";
        Request request = new Request();
        request.setRequestMsg(msg);
        Response response = new Response();
        response.setResponseMsg("default response");

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new FirstFilter());
        filterChain.addFilter(new SecondFilter());

        filterChain.doFilter(request,response,filterChain);

        System.out.println(request.getRequestMsg());
        System.out.println(response.getResponseMsg());

    }
}
