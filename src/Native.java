
public class Native {
	
	public static void main(String[] args){
		String s0="test";
		String s1="test";
		String s2="te"+"st";
		
		String s3=new String("test");
		
		System.out.println(s0==s1);
		System.out.println(s0==s2);
		System.out.println(s3==s0);
	
	}

}
