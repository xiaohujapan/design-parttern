package org.dxh.java.base.reflect;

public class TestMain {

	public static void main(String[] args) throws Exception{
		//加载顺序　当程序创建一个对类的静态成员的引用时，就会加载这个类。Class对象仅在需要的时候才会加载，static初始化是在类加载时进行的。
		//System.out.println(BaseClass.name);
		//类初始化测试
		//newClassTest();
		//类型转换测试
		InstantceTest();
	}
	
	/**
	 * 类型转换前先做检查
	 * 编译器将检查类型向下转型是否合法，如果不合法将抛出异常。向下转换类型前，可以使用instanceof判断。
	 */
	public static void InstantceTest() {
		BaseClass baseClass = new ChildClass();
		if(baseClass instanceof ChildClass) {
            // 这里可以向下转换了
            System.out.println("ok");
		}else {
			System.out.println("not ok");
		}
	}
	
	
	/**
	 * 
	 * 为了使用类而做的准备工作一般有以下3个步骤：
	 * 加载：由类加载器完成，找到对应的字节码，创建一个Class对象
	 * 链接：验证类中的字节码，为静态域分配空间
	 * 初始化：如果该类有超类，则对其初始化，执行静态初始化器和静态初始化块
	 * 
	 */
	public static void newClassTest() throws ClassNotFoundException {
	     // 不会初始化静态块
        Class clazz1 = BaseClass.class;
        System.out.println("------");
        // 会初始化
        Class clazz2 = Class.forName("org.dxh.java.base.reflect.BaseClass");
	}

}

class ChildClass extends BaseClass{}

class BaseClass {
    public static String name = "luoxn28";

    static {
        System.out.println("baseClass静态块");
    }

    public BaseClass() {
        System.out.println("baseClass构造了");
    }
}
