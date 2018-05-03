package cn.fadealges.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import cn.fadeagles.interf.Interface1;
import cn.fadealges.impl.Interface1Impl;

public class Java8NewFeature {

	@Test
	public void test1() {
		//ͨ���ӿ���.��̬����������
		String hello = Interface1.hello("Fadeagles");
		System.err.println(hello);
	}
	
	
	@Test
	public void test2() {
		Interface1 i=new Interface1Impl();
		String say = i.say("Fadeagles");
		System.err.println(say);
	}
	
	
	@Test
	public void test4() {
		String[] arrays= {"Hello","Fate","Fadeagles","Fairy","Destiny"};
		List<String> list = Arrays.asList(arrays);
		System.err.println("Lambda��ʽ:~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		list.forEach((index)->System.err.println(index));
		
		System.err.println("��ͳ��ʽ:~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		list.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
				System.err.println(t);
			}
		});
	}
	
	
	@Test
	public void test5() {
		String[] arrays= {"Hello","Fate","Fadeagles","Fairy","Destiny"};
		List<String> list = Arrays.asList(arrays);
		list.forEach(System.out::println);
	}
	
	
	

class Person{
	String name;
	int age;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]\n";
	}
}
	/**
	 * ��ͳ��������
	 * ���ݶ����ĳһ�����ԶԶ������н�������
	 */
	@Test
	public void test6() {
		List<Person> people=new ArrayList<Person>();
		people.add(new Person("Fade",24));
		people.add(new Person("Fate",1000));
		people.add(new Person("Destiny",299));
		people.add(new Person("Eagles",23));
		people.add(new Person("Cloud",2));
		people.add(new Person("Wind",30));
		
		Collections.sort(people,new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getAge()-o2.getAge();			//��������㣬���򲻱䣬��С���㣬���߽���
			}
			
		});
		System.err.println(people);
	}
	
	@Test
	public void test7() {
		List<Person> people=new ArrayList<Person>();
		people.add(new Person("Fade",24));
		people.add(new Person("Fate",1000));
		people.add(new Person("Destiny",299));
		people.add(new Person("Eagles",23));
		people.add(new Person("Cloud",2));
		people.add(new Person("Wind",30));
		
		Collections.sort(people,(Person a,Person b)->a.getAge()-b.getAge());
		System.err.println(people);
	}
	
	
	@Test
	public void test8() {
		Runnable r=()->{
			System.err.println("Lambda��ʽ:Runnalbe �ӿڵ� run������������");
		};
		
		r.run();
	}
	
	@Test
	public void test9() {
		Runnable r=new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.err.println("��ͳ��ʽ:Runnable �ӿڵ�run������������");
			}
			
		};
		r.run();
	}
	
	@Test
	public void test10() {
		Interface1 i=(String arg1)->{
			return arg1+"10086";
		};
		String common = i.common("Fadeagles ");
		System.err.println(common);
	}

	
	
	//��������
	/**
	 * �﷨:
	 * 	����::��̬������
	 * 	������::ʵ��������			//����ʧ��,���ǿ���ͨ��    ����.ʵ�������� ����ʽʵ��	
	 * 	����::new                //���ڹ��췽��
	 */
	@Test
	public void test11() {
		Interface1 i = String::format;      //�ӿ��еĳ��󷽷�������ڷ���ֵ,��ô�������õķ����ķ���ֵ����Ӧ��֮��ͬ,���Ҳ����ĸ���,���͵ȶ�Ҫ��ͬ
		String common = i.common("Fadeagles");
		System.err.println(common);
	}
	
	@Test
	public void test12() {
		Interface1 i=String::new;
		String common=i.common("Fadeagles");
		System.err.println(common);
	}
	
	
	@Test
	public void test13() {
		//�������÷�ʽ
		Interface1 i=String::toLowerCase;

		//Lambda��ʽ
		Interface1 i2=(content)->content.toLowerCase();
		
		//��ͳ��ʽ
		Interface1 i1=new Interface1() {

			@Override
			public String common(String content) {
				// TODO Auto-generated method stub
				return content.toLowerCase();
			}
			
		};
		String common = i.common("Fadeagles");
		System.err.println(common);
		
		
	}
	
	@Test
	public void test14() throws Exception{
		String content=new String("���,This is Fadeagles");
		Encoder encoder = Base64.getEncoder();
		byte[] bytes=encoder.encode(content.getBytes("utf-8"));	
		System.err.println(new String(bytes,"utf-8"));
		
		Decoder decoder = Base64.getDecoder();
		byte[] bytes2=decoder.decode(bytes);
		System.err.println(new String(bytes2,"utf-8"));
	}
	
	
	@Test
	public void test15() {
//		IntStream.of(new int[] {1,2,3}).forEach(System.out::println);
//		IntStream.range(1, 11).forEach(System.out::println);
		IntStream.rangeClosed(1, 11).forEach(System.out::println);
//		IntStream stream= IntStream.rangeClosed(1, 10);
		String[] array= {"100","200","30","400","30"};
		Stream<String> stream = Stream.of(array);
		Set<String> collect = stream.collect(Collectors.toSet());
		//steram�Ѿ��ر�,֮������ٴ�ʹ��stream,���׳�stream closed����
		
		
		Stream<String> stream1 = Stream.of(array);
		List<String> collect2 = stream1.collect(Collectors.toList());
		
		Stream<String> stream2 = Stream.of(array);
		Integer[] array3 = stream2.toArray(Integer[]::new);
		
		collect.stream().forEach((index)->System.err.println(index));
		collect2.stream().forEach(System.err::println);
		Stream.of(array3).forEach(System.err::println);
	}
	
	
	@Test
	public void test16() {
		String[] array= {"hello","fadeagles","i ","am","plum"};
		List<String> list=Arrays.asList(array);
		List<String> result = list.stream().map(index->index.toUpperCase()).collect(Collectors.toList());
		result.stream().forEach(System.err::println);
		
	}
	
	@Test
	public void test17() {
		IntStream is=IntStream.range(1, 101);
		int sum = is.peek(index->System.out.print(index+" ")).sum();
		System.out.println();
		System.out.println(sum);
	}
	
	@Test
	public void test18() throws Exception {
		Callable<String> callable=()->{
			String result="Hello Fadeagles,I am Plum";
			result=result.toUpperCase();
			System.err.println("Callable:"+Thread.currentThread().getId());
			return result;
		};
		FutureTask<String> f=new FutureTask<String>(callable);
		Thread t=new Thread(f);
		t.start();
		t.join();	//�ȴ�t������,��ִ�д���������ڵ��߳�(�˴�ָ���߳�)
		System.err.println("---------------------------------------------");
		String string = f.get();
		System.err.println(string);
		System.err.println("---------------------------------------------");
		System.err.println("Main Thread:"+Thread.currentThread().getId());
	}
	
	
	@Test
	public void test19() throws InterruptedException {
		//��ʵ��run�����ķ�����,�ٽ�Runnable������Ϊ�������ݸ�Thread���췽��,������Thread��strat���������߳�
		Runnable r=()->{
			System.err.println("Thread:�̵߳�IDΪ:"+Thread.currentThread().getId());
		};
		new Thread(r).start();
		//��ͨ��Thread,��ʱ��û�п���һ���߳�,���������߳���ִ��run�����е�ָ��
		Runnable r1=()->{
			System.err.println("Runnable:�̵߳�IDΪ:"+Thread.currentThread().getId());
		};
		r1.run();
		//��ȡ���̵߳�id
		System.err.println("���̵߳�IDΪ:"+Thread.currentThread().getId());
		Thread.sleep(1000);
	}
	
	class MyPerson{
		int id;
		String name;
		public MyPerson() {
			// TODO Auto-generated constructor stub
		}
		public MyPerson(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		@Override
		public String toString() {
			return "MyPerson [id=" + id + ", name=" + name + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	
	class Student extends MyPerson{
		int StudentId;

		public int getStudentId() {
			return StudentId;
		}

		public void setStudentId(int studentId) {
			StudentId = studentId;
		}
	}
	@Test
	public void test20() {
//		MyPerson mp=new Student();
//		System.err.println(mp.getClass().toString());
		Locale l=Locale.getDefault();
//		Locale l = Locale.CHINA;
		System.err.println(l.getLanguage());
		System.err.println(l.getCountry());
		System.err.println(l.getDisplayCountry());
	}
	
	@Test
	public void test21() throws RuntimeException{
		System.err.println("�׳��쳣֮ǰ");
		int i=1;
		if(i==1) {
			throw new RuntimeException("�׳�RuntimeExcption�쳣");
		}
		System.err.println("�׳��쳣֮��");
	}
	
}
