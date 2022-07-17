## 1. 函数指针



## 2. 仿函数



## 3. 匿名函数



## 3. lambda表达式

### 常用的场景

```c++
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Item {
public:
    Item(int x, int y) : a(x), b(y) {}
    int a;
    int b;
};

int main()
{
    vector<Item> vec;
    vec.push_back(Item(1, 19));
    vec.push_back(Item(10, 3));
    vec.push_back(Item(3, 7));
    vec.push_back(Item(8, 12));
    vec.push_back(Item(2, 1));

    for_each(vec.begin(), vec.end(),
        [] (const Item& item)
            { cout << item.a << " " << item.b << endl;});

    sort(vec.begin(), vec.end(),
        [] (const Item& v1, const Item& v2)
            {return v1.a < v2.a;});

    for_each(vec.begin(), vec.end(),
        [] (const Item& item)
            { cout << item.a << " " << item.b << endl;});   
    return 0;
}
```

上面的sort函数用法等价于

```c++
bool comp(const Item& v1, const Item& v2)
{
    return v1.a < v2.a;
}

int main()
{
    ...
    sort(vec.begin(), vec.end(), comp);
    ...
}
```

> 减少函数调用的开销？



e.g.

```c++
// 输出2
auto f = [](int a) -> int {return a + 1;};
cout << f(1) << endl;
```

