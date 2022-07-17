字符串匹配

## 暴力算法

```c++
void bf(const string& str, const string& pattern)
{
    int i = 0;
    int j = 0;
    
    while (i < str.size()) {
        if (str[i] == pattern[j]) {
            ++i;
            ++j;
            if (j == pattern.size()) {
                cout << i - j << " ";
            }
        } else {
            i = i - j + 1;
            j = 0;
        }
    }
}
```

时间复杂度比较高，i和j都有大量的回退



## kmp算法

通过next数组解决主串回退的问题，时间复杂度主要来到了next数组的这个函数中，暴力求next数组的时间复杂度为O(n^2)

```C++
vector<int> get_next1(const string& pattern)
{
    vector<int> next(pattern.size() + 1, 0);
    next[0] = -1;
    // next 数组的下标表示已匹配的长度，数组的值表示最长前后缀的长度，当 i = 1时，不存在前后缀
    for (int i = 2; i <= pattern.size(); i++) {
        // j表示可能的最长前后缀长度,从最小值1开始枚举
        for (int j = 1; j < i; j++) {
            if (pattern.substr(0, j) == pattern.substr(i - j, j)) {
                next[i] = j;
            }
        }
    }
    return next;
}

void kmp(const string& str, const string& pattern)
{
    int i = 0, j = 0;
    vector<int> next = get_next(pattern);
    while (i < str.size()) {
        if (str[i] == pattern[j]) {
            ++i;
            ++j;
            if (j == pattern.size()) {
                cout << i - j << " ";
            }
        } else {
            j = next[j];
            if (j == -1) {
                ++i;
                j = 0;
            }
        }
    }
}
```

## next数组优化

没有必要在每次匹配长度增加时都去逐个尝试next[i]的值，可以利用之前已经匹配的信息

kmp算法最难理解的实际上就是这个函数，这里说明下自己的理解。

i和上面的函数一样表示模式串已匹配的长度（0~pattern.size()）,k 表示 next[i - 1]的大小，即上一个最长前后缀的长度。

取到i时，如果模式串的最后一个字符pattern[i - 1] == pattern[k], 说明最长前后缀的长度可继续增加，更新next[i]和k的值；

如果不相等，此时还有两种情况，如果 k == 0,说明之前已匹配的模式串中没有前后缀相等的部分，此时依然不会相等，所以next[i] = 0;

如果 k != 0, 更新k的值为next[k],可以理解为一种递归。

```C++
vector<int> get_next(const string& pattern)
{
    vector<int> next(pattern.size() + 1, 0);
    next[0] = -1;
    int i = 2;
    int k = 0;
    while(i <= pattern.size()) {
        if(pattern[i - 1] == pattern[k]) {
            next[i] = k + 1;
            k = next[i];
            ++i;
        } else {
            if (k == 0) {
                next[i] = 0;
                ++i;
            }
            else {k = next[k];}
        }
    }
    return next;
}
```

优化后的kmp算法的时间复杂度为O(n + m).