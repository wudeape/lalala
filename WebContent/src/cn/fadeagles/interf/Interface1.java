package cn.fadeagles.interf;


public interface Interface1{
	default String say(String content) {
		return "this is interface default method:the content is " + content;
	}
	
	public static String hello(String content) {
		return "this is interface static method,the content is "+ content;
	}
	
	public abstract String common(String content);
}