import java.util.Scanner;

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(shuffle(n));
}

private static String shuffle(int n) throws Exception {
    String a = "c1";
    String b = "c2";
    StringBuilder sb = new StringBuilder();

    if (n<=0 || n%2==1) {
        throw new Exception("не то значение");
    }

    for (int i = 0; i < n/4; i++) {
            sb.append(a).append(b);

    }
    return sb.toString();
}