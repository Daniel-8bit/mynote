## 字典树

一种比较特殊的数据结构，主要用于处理字符串，在解题时很好用。与传统的链表有些相似，但是不同的点在于节点的字母信息存储在数组的索引中，是一种简单的哈希。往往在题目中的字符不会太多，多则26个。不过实际工程中字符集数量比这多的多，那么必然会造成大量的空间浪费。

重点在于掌握字典树的实现，以及常用的两个方法，插入和查找；以及查找前缀。

```c++
class trie {
private:
    int end;
    trie *next[26];
}
```

完整c++代码如下：

```c++
class trie {
public:
    void insert(string word)
    {
       
    }
    
    int search(string word)
    {
        
    }
    
    int prefix(string str)
    {
        
    }
private:
    int end;
    trie *next[26];
}
```

## 经典例题

### 最大的异或

leetcode

```c++
struct Trie {
    // 左子树指向表示 0 的子节点
    Trie* left = nullptr;
    // 右子树指向表示 1 的子节点
    Trie* right = nullptr;

    Trie() {}
};

class Solution {
private:
    // 字典树的根节点
    Trie* root = new Trie();
    // 最高位的二进制位编号为 30
    static constexpr int HIGH_BIT = 30;

public:
    void add(int num) {
        Trie* cur = root;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (!cur->left) {
                    cur->left = new Trie();
                }
                cur = cur->left;
            }
            else {
                if (!cur->right) {
                    cur->right = new Trie();
                }
                cur = cur->right;
            }
        }
    }

    int check(int num) {
        Trie* cur = root;
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                // a_i 的第 k 个二进制位为 0，应当往表示 1 的子节点 right 走
                if (cur->right) {
                    cur = cur->right;
                    x = x * 2 + 1;
                }
                else {
                    cur = cur->left;
                    x = x * 2;
                }
            }
            else {
                // a_i 的第 k 个二进制位为 1，应当往表示 0 的子节点 left 走
                if (cur->left) {
                    cur = cur->left;
                    x = x * 2 + 1;
                }
                else {
                    cur = cur->right;
                    x = x * 2;
                }
            }
        }
        return x;
    }

    int findMaximumXOR(vector<int>& nums) {
        int n = nums.size();
        int x = 0;
        for (int i = 1; i < n; ++i) {
            // 将 nums[i-1] 放入字典树，此时 nums[0 .. i-1] 都在字典树中
            add(nums[i - 1]);
            // 将 nums[i] 看作 ai，找出最大的 x 更新答案
            x = max(x, check(nums[i]));
        }
        return x;
    }
};
```

```c++
class Trie {
public:
    Trie()
    {
        memset(next, 0, sizeof(next));
    }

    void insert(int num)
    {
        Trie *node = this;
        for (int i = 30; i >= 0; --i) {
            int bit = (num >> i) & 1;
            if (node->next[bit] == nullptr) {
                node->next[bit] = new Trie();
            }
            node = node->next[bit];
        }
    }

    int check(int num)
    {
        Trie *node = this;
        int x = 0;
        for (int i = 30; i >= 0; --i) {
            int bit = (num >> i) & 1;
            if (node->next[1 - bit]) {
                node = node->next[1 - bit];
                x = x * 2 + 1;
            } else {
                node = node->next[bit];
                x = x * 2;
            }
        }
        return x;

    }

private:
    Trie *next[2];
};
class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        Trie trie;
        int res = 0;
        int n = nums.size();
        for (int i = 1; i < n; i++) {
            trie.insert(nums[i-1]);
            res = max(res, trie.check(nums[i]));
        }
        return res;
    }
};
```

