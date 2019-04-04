【反射】
JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
要想解剖一个类,必须先要获取到该类的字节码文件对象。而解剖使用的就是Class类中的方法.所以先要获取到每一个字节码文件对应的Class类型的对象.
反射就是把java类中的各种成分映射成一个个的Java对象
例如：一个类有：成员变量、方法、构造方法、包等等信息，利用反射技术可以对一个类进行解剖，把个个组成部分映射成一个个对象。
[反射的使用] 
1、获取Class对象的三种方式
1.1 Object ——> getClass();
1.2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
1.3 通过Class类的静态方法：forName（String  className）(常用)
其中1.1是因为Object类中的getClass方法、因为所有类都继承Object类。从而调用Object类来获取

调用方法：
1.获取构造方法：
  1).批量的方法：
public Constructor[] getConstructors()：所有”公有的”构造方法
public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)
     
  2).获取单个的方法，并调用：
public Constructor getConstructor(Class… parameterTypes):获取单个的”公有的”构造方法：
public Constructor getDeclaredConstructor(Class… parameterTypes):获取”某个构造方法”可以是私有的，或受保护、默认、公有；

  调用构造方法：
Constructor–>newInstance(Object… initargs)

2、newInstance是 Constructor类的方法（管理构造函数的类）
api的解释为：
newInstance(Object… initargs)
           使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
它的返回值是T类型，所以newInstance是创建了一个构造方法的声明类的新实例对象。并为之调用

调用字段时：需要传递两个参数
第一个参数：要传入设置的对象，第二个参数：要传入实参

调用制定方法（所有包括私有的），需要传入两个参数
一个是要调用的对象（获取有反射），一个是实参


[Class对象]
每个类都会产生一个对应的Class对象，也就是保存在.class文件。所有类都是在对其第一次使用时，动态加载到JVM的，当程序创建一个对类的静态成员的引用时，就会加载这个类。Class对象仅在需要的时候才会加载，static初始化是在类加载时进行的。
类加载器首先会检查这个类的Class对象是否已被加载过，如果尚未加载，默认的类加载器就会根据类名查找对应的.class文件。
　　想在运行时使用类型信息，必须获取对象(比如类Base对象)的Class对象的引用，使用功能Class.forName(“Base”)可以实现该目的，或者使用base.class。注意，有一点很有趣，使用功能”.class”来创建Class对象的引用时，不会自动初始化该Class对象，使用forName()会自动初始化该Class对象。为了使用类而做的准备工作一般有以下3个步骤：
加载：由类加载器完成，找到对应的字节码，创建一个Class对象
链接：验证类中的字节码，为静态域分配空间
初始化：如果该类有超类，则对其初始化，执行静态初始化器和静态初始化块

