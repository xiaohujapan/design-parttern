1.final,finally,finalize
[final]
在java中，final可以用来修饰类，方法和变量（成员变量或局部变量）
1.1　修饰类
当用final修饰类的时，表明该类不能被其他类所继承。final类中所有的成员方法都会隐式的定义为final方法。
1.2　修饰方法
把方法锁定，以防止继承类对其进行更改。
1.3　修饰变量
final成员变量表示常量，只能被赋值一次，赋值后其值不再改变。
　final修饰一个成员变量（属性），必须要显示初始化。这里有两种初始化方式，一种是在变量声明的时候初始化；第二种方法是在声明变量的时候不赋初值，但是要在这个变量所在的类的所有的构造函数中对这个变量赋初值。

在java中，String被设计成final类，那为什么平时使用时，String的值可以被改变呢？
　　字符串常量池是java堆内存中一个特殊的存储区域，当我们建立一个String对象时，假设常量池不存在该字符串，则创建一个，若存在则直接引用已经存在的字符串。当我们对String对象值改变的时候，例如 String a="A"; a="B" 。a是String对象的一个引用（我们这里所说的String对象其实是指字符串常量），当a=“B”执行时，并不是原本String对象("A")发生改变，而是创建一个新的对象("B")，令a引用它。

[finally]
　finally作为异常处理的一部分，它只能用在try/catch语句中，并且附带一个语句块，
只有与finally对应的try语句块得到执行的情况下，finally语句块才会执行，经常被用在需要释放资源的情况下。
finally语句块一定会执行(有特殊情况下不会执行)
例：
		try{
			System.out.println("try block");
			System.exit(0);
			return i;
		}finally{
			System.out.println("finally block");
		}

【finalize】
finalize()是在java.lang.Object里定义的，也就是说每一个对象都有这么个方法。这个方法在gc启动，该对象被回收的时候被调用。其实gc可以回收大部分的对象（凡是new出来的对象，gc都能搞定，一般情况下我们又不会用new以外的方式去创建对象），所以一般是不需要程序员去实现finalize的。 
特殊情况下，需要程序员实现finalize，当对象被回收的时候释放一些资源，比如：一个socket链接，在对象初始化时创建，整个生命周期内有效，那么就需要实现finalize，关闭这个链接。 
使用finalize还需要注意一个事，调用super.finalize();

2.强引用，软引用，弱引用，虚引用
[强引用]
只要引用存在，垃圾回收器永远不会回收
Object obj = new Object();
//可直接通过obj取得对应的对象 如obj.equels(new Object());
而这样 obj对象对后面new Object的一个强引用，只有当obj这个引用被释放之后，对象才会被释放掉，这也是我们经常所用到的编码形式。

[软引用]
非必须引用，内存溢出之前进行回收，可以通过以下代码实现
Object obj = new Object();
SoftReference<Object> sf = new SoftReference<Object>(obj);
obj = null;
sf.get();//有时候会返回null
这时候sf是对obj的一个软引用，通过sf.get()方法可以取到这个对象，当然，当这个对象被标记为需要回收的对象时，则返回null；
软引用主要用户实现类似缓存的功能，在内存足够的情况下直接通过软引用取值，无需从繁忙的真实来源查询数据，提升速度；当内存不足时，自动删除这部分缓存数据，从真正的来源查询这些数据。

[弱引用]
第二次垃圾回收时回收，可以通过如下代码实现
Object obj = new Object();
WeakReference<Object> wf = new WeakReference<Object>(obj);
obj = null;
wf.get();//有时候会返回null
wf.isEnQueued();//返回是否被垃圾回收器标记为即将回收的垃圾
弱引用是在第二次垃圾回收时回收，短时间内通过弱引用取对应的数据，可以取到，当执行过第二次垃圾回收时，将返回null。
弱引用主要用于监控对象是否已经被垃圾回收器标记为即将回收的垃圾，可以通过弱引用的isEnQueued方法返回对象是否被垃圾回收器标记。

[虚引用]
垃圾回收时回收，无法通过引用取到对象值，可以通过如下代码实现
Object obj = new Object();
PhantomReference<Object> pf = new PhantomReference<Object>(obj);
obj=null;
pf.get();//永远返回null
pf.isEnQueued();//返回是否从内存中已经删除
虚引用是每次垃圾回收的时候都会被回收，通过虚引用的get方法永远获取到的数据为null，因此也被成为幽灵引用。
虚引用主要用于检测对象是否已经从内存中删除。

虚引用与软引用和弱引用的一个区别在于：虚引用必须和引用队列 （ReferenceQueue）联合使用。当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会在回收对象的内存之前，把这个虚引用加入到与之 关联的引用队列中。
Java4种引用的级别由高到低依次为：
   强引用  >  软引用  >  弱引用  >  虚引用







