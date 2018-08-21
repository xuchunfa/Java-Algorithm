/*

package cn.xuchunfa.test;

public class Test {

    //构建默认哈希表和扩容
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {//2^30
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY)//扩容两倍后的容量小于2^30 而且原表的容量大于等于默认的16
                newThr = oldThr << 1; // 是 threshold = capacity * load factor 扩容两倍。注意扩容的对象,threshold默认是16
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;//16
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);//16*0.75=12
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);//还原成链表或修剪树
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {//旧表的元素和旧表的长度作与运算,为0时表示元素在新表中的index不变
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {//为1表示元素在新表中的Index为:oldIndex + oldCap(旧索引+旧表长度)
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

    //查找红黑树中的结点
    final TreeNode<K,V> find(int h, Object k, Class<?> kc) {
        TreeNode<K,V> p = this;
        do {
            int ph, dir; K pk;
            TreeNode<K,V> pl = p.left, pr = p.right, q;
            if ((ph = p.hash) > h)
                p = pl;
            else if (ph < h)
                p = pr;
            else if ((pk = p.key) == k || (k != null && k.equals(pk)))
                return p;
            else if (pl == null)
                p = pr;
            else if (pr == null)
                p = pl;
            else if ((kc != null ||
                    (kc = comparableClassFor(k)) != null) &&
                    (dir = compareComparables(kc, k, pk)) != 0)
                p = (dir < 0) ? pl : pr;
            else if ((q = pr.find(h, k, kc)) != null)//先去右子树中去查找
                return q;//找到直接返回
            else
                p = pl;//去左子树中去查找
        } while (p != null);
        return null;
    }


    //将链表结点转化为树结点,但仍然维护链表的结构
    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)//64
            resize();//此时使用默认参数新建哈希表
        else if ((e = tab[index = (n - 1) & hash]) != null) {
            TreeNode<K,V> hd = null, tl = null;
            do {
                TreeNode<K,V> p = replacementTreeNode(e, null);//将e节点变为树结点
                if (tl == null)//tl代表树的尾结点
                    hd = p;//hd代表头结点
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;//尾结点指向新插入的结点
            } while ((e = e.next) != null);
            if ((tab[index] = hd) != null)//桶的坐标指向红黑树的头结点
                hd.treeify(tab);
        }
    }

    //真正形成红黑树的结构
    final void treeify(Node<K,V>[] tab) {
        TreeNode<K,V> root = null;
        for (TreeNode<K,V> x = this, next; x != null; x = next) {
            next = (TreeNode<K,V>)x.next;
            x.left = x.right = null;
            if (root == null) {//根节点为黑色
                x.parent = null;
                x.red = false;
                root = x;
            }
            else {
                K k = x.key;
                int h = x.hash;
                Class<?> kc = null;
                for (TreeNode<K,V> p = root;;) {
                    int dir, ph;
                    K pk = p.key;
                    if ((ph = p.hash) > h)//插入结点的哈希值小于根节点
                        dir = -1;//插入左子树
                    else if (ph < h)
                        dir = 1;
                    else if ((kc == null &&
                            (kc = comparableClassFor(k)) == null) ||
                            (dir = compareComparables(kc, k, pk)) == 0)
                        dir = tieBreakOrder(k, pk);

                    TreeNode<K,V> xp = p;
                    if ((p = (dir <= 0) ? p.left : p.right) == null) {
                        x.parent = xp;
                        if (dir <= 0)
                            xp.left = x;
                        else
                            xp.right = x;
                        root = balanceInsertion(root, x);//调整红黑树的结构
                        break;
                    }
                }
            }
        }
        moveRootToFront(tab, root);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;//哈希表为空的话,resize()初始化。默认初始容量16,负载因子0.75
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);//如果哈希表的索引位置还没元素,就直接插入
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;//目标结点直接替代
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) //插入第7个结点后将链表转化成树
                            treeifyBin(tab, hash);//
                        break;
                    }
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }


    //红黑树中通过比较hash值的大小插入树结点
    final TreeNode<K,V> putTreeVal(HashMap<K,V> map, Node<K,V>[] tab,
                                   int h, K k, V v) {
        Class<?> kc = null;
        boolean searched = false;
        TreeNode<K,V> root = (parent != null) ? root() : this;
        for (TreeNode<K,V> p = root;;) {
            int dir, ph; K pk;
            if ((ph = p.hash) > h)//传入结点的hash值小于p结点的hash值的话
                dir = -1;//选择左子树
            else if (ph < h)
                dir = 1;//选择右子树
            else if ((pk = p.key) == k || (k != null && k.equals(pk)))
                return p;//返回第一个结点,默认是根结点
            else if ((kc == null &&
                    (kc = comparableClassFor(k)) == null) ||//k所属的类没有实现Comparable接口
                    (dir = compareComparables(kc, k, pk)) == 0) {//或者类k的大小相等
                if (!searched) {
                    TreeNode<K,V> q, ch;
                    searched = true;
                    if (((ch = p.left) != null &&
                            (q = ch.find(h, k, kc)) != null) ||//左子树不为空,去左子树查找
                            ((ch = p.right) != null &&
                                    (q = ch.find(h, k, kc)) != null))//右子树不为空,去右子树查找
                        return q;
                }
                dir = tieBreakOrder(k, pk);//其他比较key的方法
            }

            TreeNode<K,V> xp = p;
            if ((p = (dir <= 0) ? p.left : p.right) == null) {//找到要插入x结点的位置
                Node<K,V> xpn = xp.next;//树结点仍然有next结点,同时要维护红黑树结点和链表结点,两者可以互相转换
                TreeNode<K,V> x = map.newTreeNode(h, k, v, xpn);//x结点在xp和xpn之间
                if (dir <= 0)
                    xp.left = x;
                else
                    xp.right = x;
                xp.next = x;
                x.parent = x.prev = xp;
                if (xpn != null)
                    ((TreeNode<K,V>)xpn).prev = x;
                moveRootToFront(tab, balanceInsertion(root, x));//红黑树插入结点后的调整
                return null;
            }
        }
    }


    //插入树结点后的红黑树结点的调整
    static <K,V> TreeNode<K,V> balanceInsertion(TreeNode<K,V> root,
                                                TreeNode<K,V> x) {
        x.red = true;//插入的结点默认红色
        for (TreeNode<K,V> xp, xpp, xppl, xppr;;) {
            if ((xp = x.parent) == null) {//插入的结点为根结点,则变为黑色
                x.red = false;
                return x;
            }
            else if (!xp.red || (xpp = xp.parent) == null)//xp为黑色
                return root;//x为根结点的子结点,为啥要返回根结点???
            if (xp == (xppl = xpp.left)) {
                if ((xppr = xpp.right) != null && xppr.red) {//父结点和叔叔结点都为红
                    xppr.red = false;//叔叔结点涂为黑色
                    xp.red = false;//父结点涂为黑色
                    xpp.red = true;//祖父结点涂为红色
                    x = xpp;//当前结点指向祖父结点
                }
                else {
                    if (x == xp.right) {//叔叔结点为黑色,当前结点是父结点的右结点
                        root = rotateLeft(root, x = xp);//以父结点为轴左旋
                        xpp = (xp = x.parent) == null ? null : xp.parent;
                    }
                    if (xp != null) {//叔叔结点为黑色,当前结点是父结点的左结点
                        xp.red = false;//父结点涂为黑色
                        if (xpp != null) {
                            xpp.red = true;//祖父结点涂为红色
                            root = rotateRight(root, xpp);//以祖父结点为轴进行右旋
                        }
                    }
                }
            }
            else {//父结点是祖父结点的右结点,与上面相反
                if (xppl != null && xppl.red) {
                    xppl.red = false;
                    xp.red = false;
                    xpp.red = true;
                    x = xpp;
                }
                else {
                    if (x == xp.left) {
                        root = rotateRight(root, x = xp);
                        xpp = (xp = x.parent) == null ? null : xp.parent;
                    }
                    if (xp != null) {
                        xp.red = false;
                        if (xpp != null) {
                            xpp.red = true;
                            root = rotateLeft(root, xpp);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        char[] ch = {'a','b','c'};
        System.out.println();
    }
}

*/
