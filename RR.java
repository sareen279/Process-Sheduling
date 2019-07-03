import java.util.*;

public class RR
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of processes");
		int p = s.nextInt();
		System.out.println("Enter the Quantum");
		int qt = s.nextInt();
		Queue<Integer> q = new LinkedList<>();
		int at[] = new int[p];
		int bt[] = new int[p];
		int wt[] = new int[p];
		int tt[] = new int[p];
		int rt[] = new int[p];
		int ct[] = new int[p];
		int q1[] = new int[p];
		boolean unfinished = false;
		int time = 0,tot = 0,c = p,j = 0;
		for(int i = 0;i < p;i++)
		{
			System.out.println("Enter the Arrival time for process - " + (i+1));
			at[i] = s.nextInt();
			System.out.println("Enter the Burst time for process - " + (i+1));
			bt[i] = s.nextInt();
			rt[i] = bt[i];
		}
		while(true)
		{
			c = p;
			if(tot == p)
				break;
			for(int i = 0;i < p;i++)
			{
				if(at[i] <= time && rt[i] > 0 && (!q.contains(i)) && (rt[i] == bt[i]))
					q.add(i);
			}
			if(unfinished)
				q.add(j);
			if(!q.isEmpty())
			{
				c = q.peek();
				if(rt[q.peek()] > qt)
				{
					rt[q.peek()] -= qt;
					time = time + qt;
					j = q.peek();
					q.remove();
					unfinished = true;
				}
				else
				{
					time = time + rt[q.peek()];
					rt[q.peek()] = 0;
					tot++;
					ct[q.peek()] = time;
					q.remove();
					unfinished = false;
				}
			}
			if(c == p)
				time++;
		}
		for(int i = 0;i < p;i++)
		{
			tt[i] = ct[i] - at[i];
			wt[i] = tt[i] - bt[i];
		}
		System.out.println("Process\tAT\tBT\tWT\tTT\tCT");
		for(int i = 0;i < p;i++)
		{
			System.out.println((i+1) + "\t" + at[i] + "\t" + bt[i] + "\t" + wt[i] + "\t" + tt[i] + "\t" + ct[i] + "\n");
		}
	}
}