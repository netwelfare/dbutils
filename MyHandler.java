import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler{
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if ("read".equals(method.getName()))
    {
        System.out.println("this is read method");
    }
    return null;
  }
}
