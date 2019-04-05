【异常的分类】
Throwable是根接口
Error和Exception继承这个接口 。
・Error是无法处理的异常，比如OutOfMemoryError，一般发生这种异常，JVM会选择终止程序。因此我们编写程序时不需要关心这类异常。
・Exception，也就是我们经常见到的一些异常情况，这些异常是我们可以处理的异常，是所有异常类的父类。

「Exception」
EXCEPTION（异常）按照性质，又分为编译异常（可检测）和运行时异常（不可检测）。
・编译时异常：又叫可检查异常，通常时由语法错和环境因素（外部资源）造成的异常。比如输入输出异常IOException，数据库操作SQLException。其特点是，Java语言强制要求捕获和处理所有非运行时异常。通过行为规范，强化程序的健壮性和安全性。
・运行时异常：又叫不检查异常RuntimeException，这些异常一般是由程序逻辑错误引起的，即语义错。比如算术异常，空指针异常NullPointerException，下标越界IndexOutOfBoundsException。运行时异常应该在程序测试期间被暴露出来，由程序员去调试，而避免捕获。


「运行时错误处理方式」
一是程序不能处理的错误，二是程序应该避免而可以不去捕获的运行时异常，三是必须捕获的非运行时异常。


「处理机制」
捕获机制：try-catch-finally
try-监控区域，执行可能产生异常的代码
catch-捕获，处理异常
finally-善后处理，无论是否发生异常，代码总能执行

抛出异常：throw 手动抛出异常
声明异常：throws 声明方法可能要抛出的异常
throw：手动抛出异常，一般由程序员在方法内抛出Exception的子类异常。
throws：声明在方法名之后，告诉调用者，该方法可能会抛出异常，也就是说异常发生后会抛给调用者，由调用者处理异常。

「常见到的runtime exception」
NullPointerException - 空指针引用异常
ClassCastException - 类型强制转换异常。
IllegalArgumentException - 传递非法参数异常。
ArithmeticException - 算术运算异常
ArrayStoreException - 向数组中存放与声明类型不兼容对象异常
IndexOutOfBoundsException - 下标越界异常
NegativeArraySizeException - 创建一个大小为负数的数组错误异常
NumberFormatException - 数字格式异常
SecurityException - 安全异常
UnsupportedOperationException - 不支持的操作异常