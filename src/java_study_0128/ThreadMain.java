package java_study_0128;

public class ThreadMain {

	public static void main(String[] args) {

		// Runnable 인터페이스를 구현한 클래스를 이용해서 스레드 생성 및 실행
		// 인스턴스를 1개만 마들어서 사용한다면 메모리 낭비 - 클래스를 만들었기 때문에 클래스는 메모리에서 삭제가 안됨
		Thread th1 = new Thread(new RunnableImpl());
		th1.start();

		// 클래스를 만들지 않고 사용 - anonymous class
		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i = i + 1) {
						Thread.sleep(1000);
						System.out.println("anonymous class 이용");
					}
				} catch (Exception e) {
					System.out.println("예외 : " + e.getMessage());
					e.printStackTrace();

				}
			}

		});
		th2.start();

		// 람다 이용 - 인스턴스 생성과정이 없음. 메소스 이름도 없지만 동일한 기능을 수행
		// 이름없는 메소드를 람다라고 한다.
		// 하둡 연동 할때 알아두면 유용함. 데이터처리 할때
		Thread th3 = new Thread(() -> {
			try {
				for (int i = 0; i < 10; i = i + 1) {
					Thread.sleep(1000);
					System.out.println("람다 이용");
				}
			} catch (Exception e) {
				System.out.println("예외 : " + e.getMessage());
				e.printStackTrace();

			}
		});
		th3.start();

	}

}
