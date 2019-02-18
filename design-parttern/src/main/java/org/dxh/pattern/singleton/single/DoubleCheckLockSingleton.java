package org.dxh.pattern.singleton.single;

public class DoubleCheckLockSingleton {
	
    private volatile static DoubleCheckLockSingleton instance;  
    private DoubleCheckLockSingleton (){}  
    
    public static DoubleCheckLockSingleton getInstance() {  
	    if (instance == null) {  
	        synchronized (DoubleCheckLockSingleton.class) {  
		        if (instance == null) {  
		        	instance = new DoubleCheckLockSingleton();  
		        }  
	        }  
	    }  
	    return instance;  
    }  
    
	public void showMessage(){
		System.out.println("DoubleCheck Type Loading Multi-thread Is Safe!Hello World!");
	}
}
