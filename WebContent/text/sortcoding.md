## 几种排序方式
# 冒泡排序  
  + 简单的实现方法是 两个循环 外层循环进行控制排序的趟数,内层循环控制比较的次数
  + 每趟过后比较的次数减一
   <pre>
   	 for (int i=0;i< arrays.length-1; i++){
     // 比较每层后就重新初始化为0
     for(int j=0; j< arrays.length-i-1; j++){
        if(arrays[j]>arrays[j+1]){
        temp = arrays[j];
        arrays[j] = arrays[j+1];
        arrays[j+1] = temp;
  }
   }

   	}

   </pre>
# 选择排序
  * 找到数组中最大的数与数组的最后一个数进行位置的调换
  *代码实现 时 
  + 两个for循环 外层循环控制排序的趟数,内层循环找打当前趟数的最大值随后与当前趟数组最后一位元素进行排序

  <pre>
  	for(int i=0 ; i< array.length-1 ;i++){
  	//新的趟数 ,将指标赋值为0
  	pos = 0;
       for( int j=0; j<array.length -i;j++){
           if( arrays[j]> arrays[pos])
           {
           	pos =j;
           }
   }
    temp = arrays[pos];
    arrays[pos]  = arrays[ arrays.length -1-i];
    array[arrays.length-1-i] = temp;
  }

 </pre>

 # 插入排序
  * 将一个元素插入到有序的数组中,未初始化的时候并不知道是否为一个有序,因此把第一个元素看成是有序的
  * 与有序的数组进行比较的时候 比它大直接放入.,比它小则移动数组的位置
  +  代码实现
  + 一个for 循环内嵌一个while ,外层还是趟数,内层while是(找到合适的位置插入)
  <pre>
  	 int temp;
  	 // 外层还是排序的趟数
  	 for ( int i=1; i<arrays.length;i++){
  	 temp = arrays[i];
  	 while( i>=1 && arrays[i-1] > temp){
  	  // 往后退一个位置,让当前的数据与之前前位进行比较
  	  arrays[i] = arrays[i-1];
  	  // 不断往前,知道退出循环
  	   i--;
  	}
  	 arrays[i] = temp;

  	}

  </pre>


  # 快速排序
  *  在数组中找到一个节点,小的放在节点左边,大的放在节点的右边
