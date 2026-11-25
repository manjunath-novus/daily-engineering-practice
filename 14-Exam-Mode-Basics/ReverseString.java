
public class ReverseString {

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }

        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse("HELLO"));
        System.out.println(reverse("JAVA"));
        System.out.println(reverse("NOVA"));
    }
}
