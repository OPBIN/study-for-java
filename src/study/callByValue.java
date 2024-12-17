package study;

import java.util.ArrayList;
import java.util.List;

public class callByValue {

	public static void main(String[] args) {
		//A객체 둘을 생성, 내부의 a값은 각각 1과 2
		A a1 = new A(1);
		A a2 = new A(2);
		
		System.out.println("----------------init A Object----------------");
		System.out.println("a1.a ....." + a1.a); //a1.a .....1
		System.out.println("a2.a ....." + a2.a); //a2.a .....2
		
		//run 메소드 실행
		System.out.println("----------------execute run method----------------");
		run(a1, a2);
		System.out.println("a1.a ....." + a1.a); //a1.a .....11
		System.out.println("a2.a ....." + a2.a); //a2.a .....2
		
		//직접 대입
		System.out.println("----------------execute another method----------------");
		a2 = a1;
		System.out.println("a1.a ....." + a1.a); //a1.a .....11
		System.out.println("a2.a ....." + a2.a); //a2.a .....11
		
		/** 
		 * run method처럼 단순히 매개변수로 전달해서 작업하는 경우엔 
		 * 실제 a1, a2값이 아닌 해당 객체의 주소값만 던져줬으므로 해당 객체의 주소에 접근해서 값을 변경하는건 가능
		 * 매개변수끼리 주소값을 대입해줘도 call by value (주소값만을 전달) 일 뿐 call by reference 처럼 해당 참조 자체의 주도권을 넘겨준 것은 아니므로
		 * 주소값이 변경되진 않음
		 *  */
		
		//확인해보기위해 A객체 둘을 다시 생성, 내부의 a값은 각각 1과 2
		A a3 = new A(1);
		A a4 = new A(2);
		
		//예상 기댓값(11, 11)
		System.out.println(runAndSend(a3, a4).stream()
							.map(A::getA)
							.toList()
				);
		
		//실제 출력값 [11, 11]
	}
	
	//단순히 매개변수로 넘겨받아 해당 매개변수들에 대해 작업
	public static void run(A arg1, A arg2) {
		
		arg1.a = 11;
		arg2 = arg1;
	}
	
	//해당 매개변수를 작업한 결과를 전달
	public static List<A> runAndSend(A arg1, A arg2) {
		
		List result = new ArrayList();;
		arg1.a = 11;
		arg2 = arg1;
		
		result.add(arg1);
		result.add(arg2);
		
		return result;
	}
	
	
	public static class A{
		int a;
		A(int a){
			this.a= a;
		}
		int getA() {
			return this.a;
		}
	}

}
