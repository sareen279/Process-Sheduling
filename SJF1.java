import java.util.*;

public class SJF1
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of processes");
		int p = s.nextInt();
		int at[] = new int[p];
		int bt[] = new int[p];
		int ct[] = new int[p];
		int tt[] = new int[p];
		int wt[] = new int[p];
		int rt[] = new int[p];
		int cnt = 0,time = 0,pos = 0;
		boolean flag = false;
		for(int i = 0;i < p;i++)
		{
			System.out.println("Enter the Arrival Time");
			at[i] = s.nextInt();
			System.out.println("Enter the Burst Time");
			bt[i] = s.nextInt();
			rt[i] = bt[i];
		}
		while(cnt < p)
		{
			int min = Integer.MAX_VALUE;
			flag = false;
			for(int i = 0;i < p;i++)
			{
				if(rt[i] < min && rt[i] != 0 && at[i] <= time)
				{
					min = rt[i];
					pos = i;
					flag = true;
				}
			}
			time++;
			if(flag)
			{
				rt[pos]--;
				if(rt[pos] == 0)
				{
					ct[pos] = time;
					cnt++;
				}
			}
		}
		for(int i = 0;i < p;i++)
		{
			tt[i] = ct[i] - at[i];
			wt[i] = tt[i] - bt[i];
		}
		System.out.println("AT\tBT\tCT\tTT\tWT");
		for(int i = 0;i < p;i++)
		{
			System.out.println(at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tt[i] + "\t" + wt[i]);
		}
	}
}