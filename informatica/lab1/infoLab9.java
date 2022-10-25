import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class infoLab9 {

    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("input:");
        String num = inp.readLine();
        while (num.length() != 7 || !isZeroOrOne(num)){
            if (num.length() !=  7){
                System.out.println("not seven letters");
            }else {
                System.out.println("not zero or one ");
            }
            System.out.println("input:");
             num = inp.readLine();
        }
        System.out.println("result : "+ solve(num));

    }

    public  static String solve(String number){
        byte r1 = Byte.parseByte(String.valueOf(number.charAt(0)));
        byte r2 = Byte.parseByte(String.valueOf(number.charAt(1)));
        byte i1 = Byte.parseByte(String.valueOf(number.charAt(2)));
        byte r3 = Byte.parseByte(String.valueOf(number.charAt(3)));
        byte i2 = Byte.parseByte(String.valueOf(number.charAt(4)));
        byte i3 = Byte.parseByte(String.valueOf(number.charAt(5)));
        byte i4 = Byte.parseByte(String.valueOf(number.charAt(6)));
        int s1 = r1 ^ i1 ^ i2 ^i4 ;
        int s2 = r2 ^ i1 ^ i3 ^i4 ;
        int s3 = r3 ^ i2 ^ i3 ^i4 ;
        int resIndex = s1  +s2*2 +s3*4 -1;
        if (resIndex ==-1){
            System.out.println("no erorr");
            return number;
        }
        printErorrMessege(resIndex);
        StringBuilder stringBuilder = new StringBuilder(number);
        if (stringBuilder.charAt(resIndex) =='0'){
            System.out.println("=0");
            stringBuilder.setCharAt(resIndex,'1');
        }else {
            System.out.println("=1");
            stringBuilder.setCharAt(resIndex,'0');
        }
        return stringBuilder.toString();

    }

    public static void printErorrMessege(int index){
        System.out.print("error at:");
        switch (index){
            case 0:
                System.out.print("r1");
                break;
            case 1:
                System.out.print("r2");
                break;
            case 2:
                System.out.print("i1");
                break;
            case 3:
                System.out.print("r3");
                break;
            case 4:
                System.out.print("i2");
                break;
            case 5:
                System.out.print("i3");
                break;
            case 6:
                System.out.print("i4");
                break;
        }
    }

    public static boolean isZeroOrOne(String num){
        for (char number:num.toCharArray()
        ) {
            if (number != '0' && number!='1'){
                return false;
            }
        }
        return true;
    }

}
