package java_study_0122;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BufferInputOutput {

	public static void main(String[] args) {

		try (PrintStream ps = new PrintStream(new FileOutputStream("./buf.dat"));
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./buf.dat"));) {
			// 기록하기
			ps.println("Hello Bufferd Stream");
			ps.flush();

			// 읽기
			int len = bis.available(); // 읽을 데이터 크기 가져오기
			byte[] b = new byte[len]; // 읽은 데이터를 저장할 배열 생성
			bis.read(b); // 데이터 읽기
			System.out.println(new String(b)); // 읽은 데이터를 문자열로 변환해서 출력

		} catch (Exception e) {
			System.out.println("예외 : " + e.getMessage());
		}
	}

}
