import static  java.lang.Math.*;
 public  class Lab1 {

    public static void main(String[] args) {
    long[] a =new long[11];
	fillArrayOdds(a);

	double[] x =new double[13];
	fillArrayRandom(x);

	double[][] array=new double[11][13];
	for (int i=0;i<array.length;i++){
	    for (int j=0;j<array[i].length;j++){
	        long num =a[i];
	        switch ((int) num){
                case 3:
                case 11:
                case 17:
                case 19:
                case 23:
                    array[i][j]=solve2(x[j]);
                    break;
                case 7:
                    array[i][j]=solve1(x[j]);
                    break;
                default:
                    array[i][j]=solve3(x[j]);
            }
            System.out.printf("%.4f ", array[i][j]);
        }
        System.out.println();
    }
    }

    public static void  fillArrayOdds(long[] array){
        int maxNumber=23, minNumber=3;
        for (int number=maxNumber,i=0;number>=minNumber;number-=2,i++){
            array[i]=number;
        }
    }

    public static void fillArrayRandom(double[] array){
        int min =-11;
        int max =15;
        double range =abs(min)+max;
        for (int i=0;i< array.length;i++){
            array[i]= (random() * range)+min;
        }
    }

    public static double solve1(double x){
        return pow(pow(exp(x)/2,3),2);

    }

    public static double solve2(double x){
        return  pow(pow((pow(x,1/3.0)+1)/2,2),1/3.0);
    }

    public static double solve3(double x){
        double upper = pow(pow(x,1.0/3.0),log(abs(x)) +0.5);
        double downer = pow(pow(x/(x-1),3)*2,3)-0.25;
        return  pow((upper/downer)-1,3);
    }
}
