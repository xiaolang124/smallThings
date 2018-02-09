import java.util.ArrayList;

public class DividePowK {
    public int pow(int k,int n){
        if(k==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(k>1000000007)
            k = k%1000000007;
        ArrayList<Long> array = new ArrayList<>();
        ArrayList<Integer> bit = new ArrayList<>();
        long m = n, temp = k, result = 1;
        while(m>0){
            array.add(temp);
            temp *= temp;
            if(temp>1000000007)
                temp = temp%1000000007;
            if(m%2==1)
                bit.add(1);
            else
                bit.add(0);
            m = m/2;
        }

        for(int i=0;i<bit.size();++i){
            if(bit.get(i)==1){
                result *= array.get(i);
                if(result>1000000007)
                    result = result%1000000007;
            }
        }
        return (int)result%1000000007;
    }
}
