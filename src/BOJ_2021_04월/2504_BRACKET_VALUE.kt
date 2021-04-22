package BOJ_2021_04월

import java.util.*

fun main() {
    val n = readLine()!!

    var temp = 1
    var check = false
    var sum = 0

    val stack = Stack<Char>()

    for(i in n.indices) {
        when(n[i]) {
            '(' -> {
                temp *= 2
                stack.push('(')
            }
            '[' -> {
                temp *= 3
                stack.push('[')
            }
            ')' -> {
                if(stack.empty() || stack.last() != '(') {
                    check = true
                    break
                }
                if(n[i - 1] == '(') sum += temp
                stack.pop()
                temp /= 2
            }
            ']' -> {
                if(stack.empty() || stack.last() != '[') {
                    check = true
                    break
                }
                if(n[i - 1] == '[') sum += temp
                stack.pop()
                temp /= 3
            }
        }
    }

    if(check || stack.isNotEmpty()) println(0) else println(sum)
}

/*
static int evaluate(String str) {
		int len = str.length();
		int cur = 1;
		int sum = 0;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<len; i++) {
			switch(str.charAt(i)) {
			case '(': stack.push('('); cur *= 2; break;
			case '[': stack.push('['); cur *= 3; break;
			case ')':
				if( stack.isEmpty() || stack.peek() != '(' ) return 0;
				if( str.charAt(i-1) == '(' ) sum += cur;
				stack.pop(); cur /= 2;
				break;
			case ']':
				if( stack.isEmpty() || stack.peek() != '[' ) return 0;
				if( str.charAt(i-1) == '[' ) sum += cur;
				stack.pop(); cur /= 3;
				break;
			}
		}
		if( !stack.isEmpty() ) return 0;
		return sum;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println( evaluate(str) );
	}
*/