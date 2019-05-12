package cn.xuchunfa.array;

/**
 * @description: 逆序对的数量
 * @author: Xu chunfa
 * @create: 2018-09-02 20:41
 **/
public class InversePairNum {

    public int InversePairs(int [] array) {
        int[] temp = new int[array.length];
        int result = countPairs(array,temp,0,array.length-1);
        return result;
    }

    public int countPairs(int[] a,int[] temp,int l,int r){
        if(l == r)
            return 0;

        int middle = (l+r)/2;
        int leftCount = countPairs(a,temp,l,middle);
        int rightCount = countPairs(a,temp,middle+1,r);

        int i = middle;
        int j = r;
        int tempLastIndex = r;
        int count = 0;
        while(i >= l && j >= middle+1){
            if(a[i] > a[j]){
                count += j-middle;
                temp[tempLastIndex--] = a[i--];
                if(count >= 1000000007)//过大取模
                    count = count % 1000000007;
            }else{
                temp[tempLastIndex--] = a[j--];
            }
        }

        while(i >= l){
            temp[tempLastIndex--] = a[i--];
        }
        while(j >= middle+1){
            temp[tempLastIndex--] = a[j--];
        }

        int k = l;
        while(k <= r){
            a[k] = temp[k];
            k++;
        }
        return (leftCount + rightCount + count)%1000000007;
    }

    public static void main(String[] args){
        InversePairNum test = new InversePairNum();
        int[] num = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(test.InversePairs(num));
    }
}
