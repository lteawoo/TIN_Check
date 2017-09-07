package checksum;

public class Korea implements Checksum{
	public boolean check(String TIN) {
		//modulo 연산법
		//각자리에 가중치 곱한 뒤 더하고 11로 나눈 후 그 나머지를 11에서 뺀 숫자
		int[] weights = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		long num = Long.parseLong(TIN.replace("-", "").substring(0, 12));
		
		int ret = 0;
		
		for(int i = weights.length-1; i >= 0; i--) {
			ret += weights[i] * (num%10);
			num /= 10;
		}
		if(11 - (ret % 11) == Integer.parseInt(TIN.substring(13, 14))) {
			return true;
		} else {
			return false;
		}
	}
}