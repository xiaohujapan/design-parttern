package org.dxh.java.base.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		/*******順番なし***********/
		//JavaAPIのタイプ
		//hashSetTestBasicType();
		//自分設定のタイプ
		//hashSetTestFreeType();
		
		/*******順番あり***********/
		setHaveOrderTest();
	}
	
	
	
	public static void setHaveOrderTest() {
		Set<String> hs = new LinkedHashSet<String>();
		hs.add("競馬　太郎");
		hs.add("競馬　二郎");
		hs.add("競馬　三郎");
		hs.add("競馬　四郎");
		
		Iterator<String> it = hs.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public static void hashSetTestBasicType() {
		Set<String> hs = new HashSet<String>();
		hs.add("競馬　太郎");
		hs.add("競馬　二郎");
		hs.add("競馬　三郎");
		hs.add("競馬　四郎");

		Iterator<String> it = hs.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public static void hashSetTestFreeType() {
		Set<Student> hs = new HashSet<Student>();
		hs.add(new Student("競馬　太郎",22));
		hs.add(new Student("競馬　二郎",35));
		hs.add(new Student("競馬　三郎",25));
		hs.add(new Student("競馬　四郎",65));
		
		Iterator<Student> it = hs.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}

}


class Student{
	private String name;
	private int age;
	
	public Student(String name, int age) {
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
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if(!(obj instanceof Student)){
			System.out.println("Type Error");
			return false;
		}
		Student other = (Student) obj;
		return this.age ==  other.age && this.name.equals(other.name);
	}
}
