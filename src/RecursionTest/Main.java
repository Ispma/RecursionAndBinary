package RecursionTest;

public class Main
{

    // Числа Фибаначчи
    // f(1)= 1; f(2)= 1; f(n)= f(n-1) + f(n-2)
    // 1; 1; 2; 3; 5; 8; 13; 21...

    public static int fiboRec ( int n )
    {
        if ( n == 1 || n == 2 )
        {
            return 1;
        }
        else
        {
            return fiboRec(n - 1 ) + fiboRec(n - 2 );
        }
    }

    // Найти факториал n
    // n! = 1 * 2 * 3 * ... * n

    public static int factRec ( int n )
    {
        if ( n == 1)
        {
            return 1;
        }
        else
        {
            // n - 1 передаётся дальше в повтороно выполняющийся метод
            // при обратном проходе вместо factRec(n - 1 ) возвращается 1, затем 2 и так далее, до тех пор пока рекурсия не завершится
            return factRec(n - 1 ) * n;
        }
    }

    // Треугольные числа
    // f(n)= f(n - 1) + n

    public static int triangleRec ( int n )
    {
        if ( n == 1 )
        {
            return 1;
        }
        else
        {
            return triangleRec(n - 1 ) + n;
        }
    }

    // Сумма цифр натурального числа
    // n= 56987; 5 + 6 + 9 + 8 + 7= 35
    // f(n)= f( n / 10 ) + n % 10
    // f (567)= f(56) + 7

    public static int digitSumRec ( int n )
    {
        if ( n < 10 )
        {
            return n;
        }
        else
        {
            return digitSumRec( n / 10 ) + n % 10;
        }

    }

    // Найти произведение чисел без операции умножения
    // f(a*b)= f( b - 1 ) + a

    public static int productRec ( int i, int s )
    {
        if ( i == 0 || s == 0 )
        {
            return 0;
        }
        else if ( s == 1)
        {
            return i;
        }
        else
        {
            return productRec( i, s - 1 ) + i;
        }
    }

    public static void main(String[] args)
    {
//        System.out.println( fiboRec(8 ));
//        System.out.println( factRec(5 ));
//        System.out.println( triangleRec(5 ));
//        System.out.println( digitSumRec(56987 ));
//        System.out.println( productRec( 25, 5 ));

        BinaryFind<String> myFind= new BinaryFind<>(String.class);

        System.out.println( "Текущий размер массива: " + myFind.size() );
        myFind.insert("sshrth");
        myFind.insert("sgrae");
        myFind.insert("derjkgbe");
        myFind.insert("dsrmgn");
        myFind.insert("dkgrj");
        myFind.insert("mjk");
        myFind.insert("qwer");
        myFind.insert("fghj");
        myFind.insert("cbbftrfghj");
        myFind.insert("nm,mnc");




        System.out.println( "\n" + myFind );
        System.out.println( "\n" + "Текущий размер массива: " + myFind.size() );

        System.out.println( "\n" + "Меняем элемент - " + myFind.get(1) );
        myFind.set( 1, "dkghdhrtheh" );
        System.out.println( "на " + myFind.get(1) );

        System.out.println( "\n" + myFind ); //Если мы указываем просто объект, то данный метод автоматически будет вызывать метод toString

        System.out.println("Сортируем массив");
        HeapSortAlgorithm secondAlgorithm= new HeapSortAlgorithm();
        secondAlgorithm.sort(myFind.getList());
        System.out.println( myFind );

        System.out.println( "\n" );
        System.out.println( myFind.binaryFind(  "cbbftrfghj") );
        System.out.println( myFind.binaryFind( "nm,mnc") );
        System.out.println( "\n" + "Текущий размер массива: " +  myFind.size() );

//        System.out.println( myFind.delete("dsrmgn"));
//        System.out.println( "\n" + myFind );
//        System.out.println( "\n" + "Текущий размер массива: " + myFind.size() );
    }
}
