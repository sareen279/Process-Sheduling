import java.util.*;

public class priority
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of processes");
		int p = s.nextInt();
		int bt[] = new int[p];
		int ct[] = new int[p];
		int tt[] = new int[p];
		int wt[] = new int[p];
		int pr[] = new int[p];
		for(int i = 0;i < p;i++)
		{
			System.out.println("Enter the priority for process -" + i);
			pr[i] = s.nextInt();
			System.out.println("Enter the Burst time");
			bt[i] = s.nextInt();
		}
		for(int i = 0;i < p;i++)
		{
			for(int j = 0;j < p-(i+1);j++)
			{
				if(pr[j] > pr[j+1])
				{
					int temp = pr[j];
					pr[j] = pr[j+1];
					pr[j+1] = temp;
					temp = bt[j];
					bt[j] = bt[j+1];
					bt[j+1] = temp;
				}
			}
		}
		ct[0] = bt[0];
		for(int i = 1;i < p;i++)
		{
			ct[i] = ct[i-1] + bt[i];
		}
		for(int i = 0;i < p;i++)
		{
			tt[i] = ct[i];
			wt[i] = tt[i] - bt[i];
		}
		System.out.println("PR\tBT\tCT\tTT\tWT");
		for(int i = 0;i < p;i++)
		{
			System.out.println(pr[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tt[i] + "\t" + wt[i]);
		}
	}
}