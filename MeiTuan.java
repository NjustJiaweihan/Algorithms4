import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int[][] matrix = new int[N][M];
            int[] record1 = new int[10];
            int[] record2 = new int[10];

            int flag = 0;
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                {
                    matrix[i][j] = scanner.nextInt();
                    if(flag == 0)
                    {
                        record1[matrix[i][j]]++;
                        flag = 1;
                    }
                    else
                    {
                        record2[matrix[i][j]]++;
                        flag = 0;
                    }
                }
            }

            int MaxMax1 = -1;
            int MaxMaxIndex1 = -1;
            int Max1 = -1;
            int MaxIndex1 = -1;
            for(int i=0; i<10; i++)
            {
                if(record1[i] > MaxMax1)
                {
                    MaxMax1 = record1[i];
                    MaxMaxIndex1 = i;
                }
            }
            record1[MaxMaxIndex1] = -2;
            for(int i=0; i<10; i++)
            {
                if(record1[i] > Max1)
                {
                    Max1 = record1[i];
                    MaxIndex1 = i;
                }
            }

            int MaxMax2 = -1;
            int MaxMaxIndex2 = -1;
            int Max2 = -1;
            int MaxIndex2 = -1;
            for(int i=0; i<10; i++)
            {
                if(record2[i] > MaxMax2)
                {
                    MaxMax2 = record2[i];
                    MaxMaxIndex2 = i;
                }
            }
            record2[MaxMaxIndex2] = -2;
            for(int i=0; i<10; i++)
            {
                if(record2[i] > Max2)
                {
                    Max2 = record2[i];
                    MaxIndex2 = i;
                }
            }

            if(MaxMaxIndex1 != MaxMaxIndex2)
            {
                System.out.println(N * M - MaxMax1 - MaxMax2);
            }
            else
            {
                System.out.println(Math.min(N * M - MaxMax1 - Max2, N * M - Max1 - MaxMax2));
            }
        }
    }
}
