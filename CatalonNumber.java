import java.util.*;
public class CatalonNumber{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int dp[]=new int[n+1];
			Arrays.fill(dp,0);
			System.out.println("Recursice  :- "+recursive(n,dp));
			iterative(n);
		}
	}
	//Recursive Method
	public static int recursive(int n,int dp[]){
		//Base Condition
		if (n==0 || n==1)
			return 1;
		if (dp[n]!=0)
			return dp[n];
		//Recursive Condition
		int ans=0;
		for(int i=1;i<=n;i++){
			ans+=recursive(i-1,dp)*recursive(n-i,dp);
		}
		dp[n]=ans;
		return dp[n];
	}
	public static void iterative(int n){
		int dp[]=new int[n+1];
		Arrays.fill(dp,0);
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++){
			for(int j=1;j<=i;j++)
			dp[i]+=dp[j-1]*dp[i-j];
		}
		for(int i=0;i<=n;i++){
			System.out.print(dp[i]+"  ");
		}
		System.out.println();
	}
}