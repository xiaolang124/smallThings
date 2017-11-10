There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).


    /*如果我们可以在两个数列中求出第K小的元素，便可以解决该问题
	    不妨设数列A元素个数为n，数列B元素个数为m，各自升序排序，求第k小元素
	    取A[k / 2] B[k / 2] 比较，
	    如果 A[k / 2] > B[k / 2] 那么，所求的元素必然不在B的前k / 2个元素中(证明反证法)
	    反之，必然不在A的前k / 2个元素中，于是我们可以将A或B数列的前k / 2元素删去，求剩下两个数列的
	    k - k / 2小元素，于是得到了数据规模变小的同类问题，递归解决
	    如果 k / 2 大于某数列个数，所求元素必然不在另一数列的前k / 2个元素中，同上操作就好。
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