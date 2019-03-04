package RecursionTest;

public class HeapSortAlgorithm<Item extends Comparable<Item>>
{
    void sort(Item a[])
    {

        int arrSize = a.length;

        //Создаём из массива сортирующее дерево
        //Максимальный элемент окажется в корне.
        for (int k = arrSize / 2; k > 0; k--)
        {
            downheap(a, k, arrSize);
        }

        //Избавляемся от максимумов
        //и перетряхиваем сортирующее дерево
        do {

            //Меняем максимум с последним элементом...
            Item T = a[0];
            a[0] = a[arrSize - 1];
            a[arrSize - 1] = T;

            //... и перестравиваем сортирующее дерево
            //для неотсортированной части массива
            arrSize = arrSize - 1;
            downheap(a, 1, arrSize);

        } while (arrSize > 1); //До последнего элемента

    }

    void downheap( Item a[], int k, int arrSize)
    {

        //В корне поддерева
        //запоминаем родителя
        Item Parent = a[k - 1];

        //Смотрим потомков в пределах ветки
        while (k <= arrSize / 2) {

            int j = k + k;// Индекс левого потомок

            //Если есть правый потомок,
            //то сравниваем его с левым
            //и из них выбираем наибольший
            if ( (j < arrSize) && (a[j - 1].compareTo(a[j])) < 0 ) j++;

            //Если родитель больше (или равен) наибольшего потомка...
            if ( Parent.compareTo(a[j - 1]) >= 0 ) {

                //... то значит всё в порядке в этой ветке
                break;

            } else { //Если родитель меньше наибольшего потомка...

                //... то потомок становится на место родителя
                a[k - 1] = a[j - 1];
                k = j;

            }
        }

        //Родитель в итоге меняется местами с наибольшим из потомков
        //(или остаётся на своём месте, если все потомки меньше его)
        a[k - 1] = Parent;

    }
}
