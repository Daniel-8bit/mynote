要点：熟记模板算法，算法题的代码风格与项目的代码风格不能混用
来源：Acwing 闫神


## 排序(默认升序排列)

### 快排

思路：
1. 确定分界点 ```a[l+r >> 1]```
**注：** 不可 使x = l + r >> 1; 用a[x]代替，在while的迭代过程中数组是不断变化的，那时a[x]未必还是最初的a[x]
2. 调整范围
3. 递归处理左右两段



```c++
void quick_sort(int a[], int l, int r)
{
    if(l == r) return;
    int i = l - 1;
    int j = r + 1;
    
    int x = a[l + r >>1];
    
    while(i < j) {
        // 下面两步可以简化成 while(a[++i] < x);
        do i++;
        while(a[i] < x);
        // 下面两步可以简化成 while(a[--j] > x)
        do j--;
        while(a[j] > x);
        
        if(i < j) swap(a[i], a[j]);
    }
    quick_sort(a, l, j);
    quick_sort(a, j+1, r);
}
```

**快速选择算法**
时间复杂度：O(n)

更改不等号方向即可求第k个最大的数

```C++
int quick_select(int a[], int l, int r, int k)
{
    if(l == r) return a[l];
    
    int i = l - 1;
    int j = r + 1;
    int x = a [l + r >> 1];
    
    // 按 x 划分
    while(i < j) {
        while(a[++i] < x);
        while(a[--j] > x);
        
        if(i < j) swap(a[i], a[j]);
    }
    
    // sl 左半部分小于x的元素数目
    int sl = j - l + 1;
    // 如果k小于等于sl，只需要在左半部分递归，寻找第k小的数
    if(k <= sl) return quick_select(a, l, j, k);
    // 如果k 大于 sl, 需要在右半部分递归，寻找第 k-sl小的数
    else return quick_select(a, j + 1, r, k - sl);
}

```

### 归并排序

思路：
1. 将数组不断二分，直至数组长度为1(并没有真正地把数组分成无数个小数组)
2. 边合并边排序

```c++
// 归并时需要辅助数组 int temp[N]
void merge_sort(int a[], int l, int r)
{
    if( l == r) return;
    int mid = l + r >> 1;
    merge_sort(a, l, mid);
    merge_sort(a, mid + 1, r);
    
    // temp数组的索引
    int k = 0;
    // 数组a的左半部分的最小值
    int i = l;
    // 数组a的右半部分的最小值
    int j = mid + 1;
    
    while(i <= mid && j <= r) {
        if(a[i] < a[j]) temp[k++] = a[i++];
        else temp[k++] = a[j++];
    }
    while(i <= mid) temp[k++] = a[i++];
    while(j <= r) temp[k++] = a[j++];
    
    // 将辅助数组复制给数组a
    for(i = l, j = 0; i <= r; i++,j++) a[i] = temp[j];
}
```

**归并排序的拓展 —— 逆序对问题** 

思路：
1. 暴力求解时间复杂度为O(n^2)
2. 整体和归并是一样的，只是在合并的过程中，取逆序对的值
题解：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/

注意：如果用例有空值，有可能会报stackoverflow,直接特判就好

```c++
long long getNum(int a[], int l, int r)
{
    if(l == r) return 0;
    int mid = l + r >> 1;
    long long res = getNum(a, l, mid) + getNum(a, mid + 1, r);
    
    int i = l, j = mid + 1;
    int k = 0;
    while(i <= mid && j <= r) {
        if(a[i] <= a[j]) temp[k++] = a[i++];
        else {
            res += mid - i + 1;
            temp[k++] = a[j++];
        }
    }
    while(i <= mid) temp[k++] = a[i++];
    while(j <= r) temp[k++] = a[j++];
    
    for(i = l, k = 0; i <= r; i++,k++) a[i] = temp[k];
    return res;
    
}
```
