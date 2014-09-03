
public class LCS {
	public static String LCS(String s1,String s2){
		if(s1==null || s2==null || s1.length()==0 || s2.length()==0){
			return "";
		}
		int m = s1.length() + 1;
		int n = s2.length() + 1;
		int[][] lcsTable = new int[m][n];
		int i;
		int j;
		for(i = 0;i<m;i++){
			for(j = 0;j<n;j++){
				lcsTable[i][j] = 0;
			}
		}
		
		for(i=1;i<m;i++){
			for(j=1;j<n;j++){
				int top = lcsTable[i-1][j];
				int left = lcsTable[i][j-1];
				int topLeft = s1.charAt(i-1)==s2.charAt(j-1)?lcsTable[i-1][j-1]+1:lcsTable[i-1][j-1];
				int max = max(top,left,topLeft);
				lcsTable[i][j] = max;
			}
		}
		
		String lcs = "";
		i=m-2;
		j=n-2;
		while(i>=0&&j>=0){
			if(s1.charAt(i) == s2.charAt(j)){
				lcs += s1.charAt(i);
				i--;
				j--;
			}else{
				if(lcsTable[i+1][j+1] == lcsTable[i][j]){
					i--;
					j--;
				}else{
					if(lcsTable[i+1][j] >= lcsTable[i][j+1]){
						j--;
					}else{
						i--;
					}
				}
			}
		}
		
		lcs = reverse(lcs);
		
		
		return lcs;
	}

	

	private static String reverse(String lcs) {
		// TODO Auto-generated method stub
		String res = "";
		for(int i=lcs.length();i>0;i--){
			res += lcs.charAt(i-1);
		}
		return res;
	}



	private static int max(int top, int left, int topLeft) {
		// TODO Auto-generated method stub
		int max = top;
		if(max <= left)
			max = left;
		if(max <= topLeft)
			max = topLeft;
		return max;
	}
	
	
	public static void main(String[] args){
		String s1 = "GCCCTAGCG";
		String s2 = "GCGCAATG";
		System.out.println(LCS.LCS(s1, s2));
	}
}
