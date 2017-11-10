There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).


    /*������ǿ��������������������KС��Ԫ�أ�����Խ��������
	    ����������AԪ�ظ���Ϊn������BԪ�ظ���Ϊm�����������������kСԪ��
	    ȡA[k / 2] B[k / 2] �Ƚϣ�
	    ��� A[k / 2] > B[k / 2] ��ô�������Ԫ�ر�Ȼ����B��ǰk / 2��Ԫ����(֤����֤��)
	    ��֮����Ȼ����A��ǰk / 2��Ԫ���У��������ǿ��Խ�A��B���е�ǰk / 2Ԫ��ɾȥ����ʣ���������е�
	    k - k / 2СԪ�أ����ǵõ������ݹ�ģ��С��ͬ�����⣬�ݹ���
	    ��� k / 2 ����ĳ���и���������Ԫ�ر�Ȼ������һ���е�ǰk / 2��Ԫ���У�ͬ�ϲ����ͺá�
    */
    public static double findMedianSortedArrays(int A[],int B[]) {
    	int m=A.length;
    	int n=B.length;
        double median = 0.0;
        if((m+n)%2==1)
        	median=(double)findKth(A, m, B, n, 0, 0, (m+n+1)/2);
        else{
        	median=(double)(findKth(A, m, B, n, 0, 0, (m+n)/2)
        			+findKth(A, m, B, n, 0, 0, (m+n)/2+1))/2;
        }
        return median;
    }
    
    public static int findKth(int[] A,int m,int[] B, int n ,int aStart,int bStart,int k){
    	if(aStart>=m)
    		return B[bStart+k-1];
    	if(bStart>=n)
    		return A[aStart+k-1];
    	if(k==1)
    		return (A[aStart]<B[bStart]?A[aStart]:B[bStart]);
    	
    	int Ak=(aStart+k/2-1>=m)?Integer.MAX_VALUE:A[aStart+k/2-1];
    	int Bk=(bStart+k/2-1>=n)?Integer.MAX_VALUE:B[bStart+k/2-1];
    	if(Ak<Bk)
    		return findKth(A, m, B, n, aStart+k/2, bStart, k-k/2);
    	else {
			return findKth(A, m, B, n, aStart, bStart+k/2, k-k/2);
		}
    		
    }