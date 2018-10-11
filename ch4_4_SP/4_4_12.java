private class EdgeWeightedCycleFinder
    {
        private boolean[] marked;
        private DirectedEdge[] edgeTo;
        private Stack<DirectedEdge> cycle;
        private boolean[] onStack;

        public EdgeWeightedCycleFinder(EdgeWeightedDigraph g)
        {
            onStack = new boolean[g.V()];
            edgeTo = new DirectedEdge[g.V()];
            marked = new boolean[g.V()];

            for(int v=0; v<g.V(); ++v)
            {
                if(!marked[v])
                {
                    dfs(g,v);
                }
            }
        }
        private void dfs(EdgeWeightedDigraph g, int v)
        {
            marked[v] = true;
            onStack[v] = true;
            //e: v -> w
            for(DirectedEdge e : g.adj(v))
            {
                int w = e.to();
                if(hasCycle())
                {
                    return;
                }
                else if (!marked[w])
                {
                    edgeTo[w] = e;
                    dfs(g,w);
                }
                else if (onStack[w])
                {
                    cycle = new Stack<DirectedEdge>();
                    for(DirectedEdge x=edgeTo[w]; x.from()!=w; x=edgeTo[x.from()])
                    {
                        cycle.push(x);
                    }
                }
            }
        }
        private boolean hasCycle()
        {
            return cycle !=null;
        }
        private Iterable<DirectedEdge> cycle()
        {
            return cycle;
        }
    }
