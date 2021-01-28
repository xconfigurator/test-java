package liuyang.designpatterns.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @Aspect 类似JDK的java.lang.reflect.InvocationHandler
 * @author liuyang
 *
 */
public class CglibProxyDemo implements MethodInterceptor {
	
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class clazz) {
		// 设置创建子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	/**
	 * 拦截所有目标类方法的调用
	 * 
	 * @param obj
	 *            目标类实例
	 * @param method
	 *            目标方法的反射对象
	 * @param args
	 *            方法的参数
	 * @param proxy
	 *            代理类的实例
	 */
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object result = null;
		long begin = 0;
		long end = 0;
		try {
			// @Before
			begin = System.currentTimeMillis();

			// 原逻辑
			result = proxy.invokeSuper(obj, args);

			// @AfterReturning
			end = System.currentTimeMillis();
			System.out.println("#程序运行了：" + (end - begin) + "ms");
		} catch (Throwable e) {
			// @AfterThrowing
			throw e;
		} finally {
			// @After
		}

		return result;
	}

}
