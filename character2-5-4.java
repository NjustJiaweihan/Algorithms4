public class AlgorithmsJava
{
    public static String[] dedup(String[] a)
    {
        int N = a.length;
        int count = N;

        Arrays.sort(a);
        for (int i=0; i<N-1; ++i)
        {
            if(a[i] == a[i+1])
            {
                a[i] = null;
                count--;
            }
        }
        
        String[] aux = new String[count];
        int index = 0;
        while(index < (count-1))
        {
            for(int j=0; j<N; ++j)
            {
                if(a[j] != null)
                {
                    aux[index] = a[j];
                    index++;
                }
            }
        }
        return aux;
    }

    public static void main(String[] args)
    {
        String[] a = {"abc","abc","abb","abb","aba"};
        String[] b = AlgorithmsJava.dedup(a);
        for(int i=0, M=b.length; i<M; ++i)
        {
            System.out.println(b[i]);
        }
    }
}
