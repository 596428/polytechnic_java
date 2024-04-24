
public class RunCombination {
	public static void main(String[] args) {
		//System.out.println(recursionSum(10));
		String str01 = createString(3);
		char[] arr01 = str01.toCharArray();
		boolean[] visited = new boolean[str01.length()];
		char[] branch01 = new char[str01.length()];
		System.out.println("---순열---");
		permutation(arr01, str01.length(), branch01, 0, visited);
		
		int count = 2;
		char[] branch02 = new char[count];
		System.out.println("---조합---");
		combination(arr01, count, 0, branch02, 0);
		System.out.println("---멱집합---");
		powerset(arr01);
	}
	
	//숫자 3을 받아서 문자열 123 만들기
	static String createString(int n) {
		//배열 생성하고 값 담기 [1,2,3]
		String[]temp = new String[n];
		for(int i=0; i<n; i++) {
			temp[i] = Integer.toString(i+1);
		}
		//비어있는 StringBuilder 생성하고 for문으로 123을 문자열에 담기
		StringBuilder sb = new StringBuilder();
		for (String i : temp) {
		    sb.append(i);
		}
		// StringBuilder "123"을 문자열 "123"으로
		String str = sb.toString();
		return str;
	}
	
	
	
	static void permutation(char[]arr, int size, char[]branch, int level, boolean[]visited) {
		if(level >= size) {
			System.out.println(branch);
			return;
		}
		for(int i=0; i<size; i++) {
			if(!visited[i]) {
				branch[level++] = arr[i];
				visited[i] = true;
				permutation(arr, size, branch, level, visited);
				visited[i] = false;
				level--;
			}
		}
	}
	
	static void combination(char[]arr, int pick, int startIdx, char[]output, int numElem) {
		if(numElem==pick) {
			System.out.println(output);
			return;
		}
		for(int i=startIdx; i<arr.length; i++) {
			output[numElem++] = arr[i];
			combination(arr, pick, ++startIdx, output, numElem);
			--numElem;
		}
		
	}
	
	static void powerset(char[]arr) {
		for(int i=0; i<arr.length; i++) {
			char[]branch = new char[i];
			combination(arr,i,0,branch,0);
		}
	}
	
	public static int recursionSum(int input) {
		return input <= 0 ? 0 : input + recursionSum(--input);
	}
	
}
