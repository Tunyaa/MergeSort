public class MergeSort {
    
    private static void mergeSort(int[] ary){
        
                                // Завершаем метод, если осталься один элемент
        if (ary.length == 1) return; 
                                //Узнаем где середина.
        int middle  = ary.length / 2; 
                                //Левая часть массива.
        int[] left  = new int[middle];  
                                //Правая часть массива.
        int[] right = new int[ary.length - middle]; 
        
        // 2*                   // Копируем массив в левую часть.
        System.arraycopy(ary, 0, left, 0, middle);
                                // Копируем массив в правую часть.
        System.arraycopy(ary, middle, right, 0, ary.length - middle);
        
        mergeSort(left);
        mergeSort(right);
        merge(ary, left, right); 
        
    }
    
    private static void merge (int[] ary, int[] left, int[] right){
        
        int i   = 0; // Переменная цикла.
        int j   = 0; // Переменная цикла.
        int n   = 0; // Переменная цикла.
        
        while (i < left.length && j < right.length)
            // 1*                   //Записываем меньший элемент в массив.
            ary[n++] = left[i] < right[j] ?  left[i++] : right[j++];
            
                                    // Переписываем элементы из левой и правой стороны в массив.
        for (int k = i; k < left.length; k++)  
            ary[n++] = left[k];
        for (int k = j; k < right.length; k++) 
            ary[n++] = right[k];
           
    }
  
  // 1*   Аналогичная запись        
        //            if (left[i] < right[j]) { //Сравниваем левый и правый элементы.
        //                ary[idx] = left[i]; //Записываем меньший элемент в массив.
        //                i++;
        //                
        //            }else{
        //                ary[idx] = right[j];
        //                j++;
        //                
        //            }
        // 2*
        //        for (int i = 0; i < middle; i++)  // Копируем массив в левую часть.
        //            left[i] = ary[i];
        //        
        //        for (int i = 0; i < ary.length - middle; i++) // Копируем массив в правую часть.
        //            right[i] = ary[i + middle];
