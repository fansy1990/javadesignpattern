package proxy2;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by fansy on 2016/2/14.
 */
public class Proxy {
    public static Object getNewProxy(Class itf,Object t) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String methodStr = "";
        String n="\n";
        Method[] methods = itf.getMethods();
        for(Method method:methods){
            methodStr+=n+
                    "   public void "+method.getName()+"(){"+n+
                            "       long start = System.currentTimeMillis();" +n+
                            "        t."+method.getName()+"();" +n+
                            "        long end = System.currentTimeMillis();" +n+
                            "        System.out.println(\"time:\"+(end-start));"+n+
                            "   }"
                    ;
        }

        String src =
                "package proxy2;" +n+
                "public class TmpProxy implements " +itf.getName()+"{"+n+
                "   "+itf.getName()+" t;"+ n+
                "   public TmpProxy( " +itf.getName() +" tt){"+n+
                "       this.t=tt;"+n+
                "   }" +n+
                methodStr +n+
                "}"
        ;

        // 生成文件
        System.out.println(System.getProperty("user.dir"));
        String fileName = System.getProperty("user.dir")+"/src/proxy2/TmpProxy.java";
        FileWriter fileWriter = new FileWriter(new File(fileName));
        fileWriter.write(src);
        fileWriter.flush();
        fileWriter.close();

        // 编译，并加载
        //compile
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask tt = compiler.getTask(null, fileMgr, null, null, null, units);
        tt.call();
        fileMgr.close();

        //load into memory and create an instance
        URL[] urls = new URL[] {new URL("file:/" + System.getProperty("user.dir")+"/src/")};
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("proxy2.TmpProxy");
        System.out.println(c);
        Constructor ctr = c.getConstructor(itf);
        Object m = ctr.newInstance(t);
        return m;
    }
}
