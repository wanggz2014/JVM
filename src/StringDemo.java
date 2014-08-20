
public class StringDemo {

	 public static void main(String[] args) {
         String hello = "Hello", lo = "lo";
         //同一个包下同一个类中的字符串常量的引用指向同一个字符串对象；
         System.out.print((hello == "Hello") + " ");
         //同一个包下不同的类中的字符串常量的引用指向同一个字符串对象；
         System.out.print((Other.hello == hello) + " ");
         //不同的包下不同的类中的字符串常量的引用仍然指向同一个字符串对象；
         System.out.print((other.Other.hello == hello) + " ");
         //由常量表达式计算出的字符串在编译时进行计算,然后被当作常量；
         System.out.print((hello == ("Hel"+"lo")) + " ");
         //在运行时通过连接计算出的字符串是新创建的，因此是不同的；
         System.out.print((hello == ("Hel"+lo)) + " ");
         //通过计算生成的字符显式调用intern方法后产生的结果与原来存在的同样内容的字符串常量是一样的
         System.out.println(hello == ("Hel"+lo).intern());
    }
	 
	public static  class Other { static String hello = "Hello"; }
}
