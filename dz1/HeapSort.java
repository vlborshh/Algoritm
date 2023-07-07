package dz1;

public class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length;

        // Создание кучи
        for (int i = n / 2 - 1; i >= 0; i--)
            heap(arr, n, i);

        // Последовательно извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heap на уменьшенной куче
            heap(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева
    void heap(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // Если левый дочерний элемент больше
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсия
            heap(arr, n, largest);
        }
    }

    // Функция для вывода на экран
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { -2, 0, -8, 1, 11, 11, 17, 5, 16, 7 };

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.print("Результат сортировки: ");
        printArray(arr);
    }
}
