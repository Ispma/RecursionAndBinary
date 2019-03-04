package RecursionTest;

import java.lang.reflect.Array;

public class BinaryFind<Item extends Comparable<Item>>
{


    private Item[] list;
    private int size= 0; //Переменная для хранения колличества элементов в нашем списке
    Class ItemClass;

    public BinaryFind(Class ItemClass)
    {
        list = (Item[]) Array.newInstance(ItemClass, 1);
        this.ItemClass = ItemClass;
    }

    public int size()
    {
        return size; // метод возвращающий число элементов списка
    }

    public Item[] getList ()
    {
        return  list;
    }

    public Item get ( int index )
    {
        if ( index < 0 || index > size - 1 )
        {
            throw new IndexOutOfBoundsException(); //Исключение
        }
        return (Item) list[index]; // Меняем переменные Object на Item
    }

    public void insert ( Item item )
    {
        if ( size == list.length )
        {
            resize( 1 + list.length ); // Увеличиваем размер массива на 1
        }
        list[size]= item; // В это пустое поле мы и вставляем item
        size++;
    }

    private void resize ( int capacity )
    {
        Item[] temp= (Item[]) Array.newInstance(ItemClass, capacity); //Создаём новый временный массив
        for ( int i= 0; i < size; i++ ) // С помощью цикла for записываем в него все элементы массива list
        {
            temp[i]= list[i];
        }
        list= temp; //Так как в джаве кроме примитивных все данные - ссылочного типа, мы присваиваем ссылку указывающую на новый массив temp массиву list
    }

    // Аналог команды присваивания
    public void set ( int index, Item item )
    {
        if ( index < 0 || index > size - 1 )
        {
            throw new IndexOutOfBoundsException(); //Исключение
        }
        list[index]= item; //Нужно обратить внимание, что в списке ничего кроме Item появиться не может
    }

    public boolean binaryFind ( Item item )
    {
        return binaryFindRec( item, 0, size() - 1 );
    }

    private boolean binaryFindRec ( Item item, int lo, int hi )
    {
        int mid= lo + ( hi - lo ) / 2;
        if ( item.compareTo(this.get(mid)) == 0 )
        {
            return true;
        }
        else if ( item.compareTo(this.get(mid)) < 0 )
        {
            return binaryFindRec( item, lo, mid - 1 );
        }
        else if ( item.compareTo(this.get(mid)) > 0 )
        {
            return binaryFindRec( item, mid + 1, hi );
        }
        return false;
    }



    @Deprecated
    public boolean delete ( Item item )
    {
        int i= 0;
        /*
        !(a || b)= !a && !b;
        !( i >= size || list[i].equals(item) )= i < size && !list[i].equals(item)
         */
        while ( i < size && !list[i].equals(item) )
        {
            i++;
        }
        if ( i == size )
        {
            return false;
        }
        // 1 2 3 4 5
        // 1 2 4 5 5
        for ( int s= 0; s < size; s++ )
        {
            list[s]= list[ s + 1 ];
        }
        list[ size - 1 ]= null;
        size--;

        if ( size == list.length / 4 && size > 0 )
        {
            resize( list.length / 2 );
        }
        return true;
    }


    @Override
    public String toString ()
    {
        String s= " ";
        for ( int i= 0; i < size; i++ )
        {
            s= s + list[i] + " ";
        }
        return s;
    }

}
