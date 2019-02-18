package org.dxh.pattern.singleton;

import org.dxh.pattern.singleton.single.DoubleCheckLockSingleton;
import org.dxh.pattern.singleton.single.HungryIsSafeSingleObject;
import org.dxh.pattern.singleton.single.LazyIsSafeSingleObject;
import org.dxh.pattern.singleton.single.LazyNotSafeSingleObject;
import org.dxh.pattern.singleton.single.RedistIsSafeSingleton;

/**
双检锁/双重校验锁（DCL，即 double-checked locking）
JDK 版本：JDK1.5 起
是否 Lazy 初始化：是
是否多线程安全：是
实现难度：较复杂
描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
getInstance() 的性能对应用程序很关键。
 *
 */
public class SingletonPatternDemo {
   public static void main(String[] args) {
	   
	  LazyNotSafeSingleObject object = LazyNotSafeSingleObject.getInstance();
      object.showMessage();
      
	  LazyIsSafeSingleObject object2 = LazyIsSafeSingleObject.getInstance();
	  object2.showMessage();
	  
	  HungryIsSafeSingleObject object3 = HungryIsSafeSingleObject.getInstance();
	  object3.showMessage();
	  
	  DoubleCheckLockSingleton object4 = DoubleCheckLockSingleton.getInstance();
	  object4.showMessage();
	  
	  RedistIsSafeSingleton object5 = RedistIsSafeSingleton.getInstance();
	  object5.showMessage();
   }
}