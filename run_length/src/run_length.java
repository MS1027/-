public class run_length{
	public static void print_current_code(char code, int count) {
		if(count == 0)
			System.out.println("Encoding Error!");
		else {
			switch(code) {
			case 'B':
				if(count == 1)
					System.out.print("B");
				else
					System.out.printf("%dB", count);
				break;
				
			case 'W':
				if(count == 1)
					System.out.print("W");
				else
					System.out.printf("%dW", count);
				break;
			}
		}
	}
	public static void run_length_encoding(String screen) {
		char code = screen.charAt(0);
		int count = 1;
		
		for(int i=0; i+1<screen.length(); i++) {
			if(code != screen.charAt(i+1)) {
				// 다음에 다른 문자가 오면 현재까지의 코드 개수 출력
				print_current_code(code, count);
				code = screen.charAt(i+1);
				count = 1;
			}
			else {
				// 다음에도 같은 문자가 오면 개수 증가
				count++;
			}
		}
		// 마지막 문자 처리
		if(count != 0) {
			print_current_code(code, count);
		}
		else {
			print_current_code(screen.charAt(screen.length()-1), 1);
		}
		
	}
	public static void main(String[] args) {
		String screen = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW";
		System.out.println("Run-length encoding(RLE) Test");
		System.out.println("Input data : " + screen);
		
		System.out.print("Encoding result : ");
		run_length_encoding(screen);
	}
}