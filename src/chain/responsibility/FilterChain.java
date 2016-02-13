package chain.responsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fansy on 2016/2/13.
 */
public class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();
    int index =0;
    public FilterChain addFilter(Filter filter){
        this.filters.add(filter);
        return this;
    }

    public void doFilter(Request request,Response response,FilterChain filterChain){
//        for(Filter filter:filters){
//            filter.doFilter(request,response,filterChain);
//        }
        if(index==filters.size()) return ;
        Filter filter = filters.get(index++);
        filter.doFilter(request,response,filterChain);

    }
}
