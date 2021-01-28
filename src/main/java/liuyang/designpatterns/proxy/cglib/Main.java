package liuyang.designpatterns.proxy.cglib;

// import cn.edu.hebau.liuyang.designpattern.proxy.MyObject;

public class Main {

	public static void main(String[] args) {
		CglibProxyDemo proxy = new CglibProxyDemo();
		MyObject obj = (MyObject)proxy.getProxy(MyObject.class);
		obj.someMethod();
	}

}
