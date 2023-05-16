package 과제.과제2.HW_2_SLIST;
// 자료구조(6076) 과제 #2 (60201670 남태욱)
//package HW_2_SList;

public class Main {
	public static void main(String[] args) {	
		SList<Integer> x = new SList<Integer>();  // 연결 리스트 객체 u 생성

		x.insertFront(100);	
		x.insertFront(90); 
		x.insertFront(80); 
		x.insertFront(70); 
		x.insertFront(60); 
		x.insertFront(50); 
		x.insertFront(40);
		x.insertFront(30);
		x.insertFront(20); 
		x.insertFront(10); 
		
		System.out.println("<< 자료구조(6076/6077) 과제 #2 (학번 이름) >>");		
		System.out.println("\n----------------------------");
		System.out.print("정렬된 단순연결리스트: ");	x.print();
		
		x.insert(5);
		System.out.print("삽입 후: ");	x.print(); 
		
		x.insert(75);
		System.out.print("삽입 후: ");	x.print(); 
		
		x.insert(200);
		System.out.print("삽입 후: ");  	x.print(); 
		
		SList<Integer> y = new SList<Integer>();  
		
		y.insertFront(40);
		y.insertFront(90); 
		y.insertFront(30); 
		y.insertFront(70); 
		y.insertFront(10); 
		y.insertFront(100); 
		y.insertFront(80);	
		y.insertFront(20); 
		y.insertFront(60); 
		y.insertFront(50);
		
		System.out.println("\n----------------------------");
		System.out.print("단순연결리스트: ");	y.print();
		
		y.delete(50);
		System.out.print("삭제 후: ");  	y.print();

		y.delete(10);
		System.out.print("삭제 후: ");  	y.print();
		
		y.delete(40);
		System.out.print("삭제 후: ");  	y.print();
		
		y.delete(200);
		System.out.print("삭제 후: ");	y.print();
	}
}