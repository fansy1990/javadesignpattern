package chain.responsibility;

/**
 * Created by fansy on 2016/2/13.
 */
public interface Filter {
    void doFilter(Request request,Response response,FilterChain filterChain);
}
