    public EdgeWeightGraph(In in)
    {
        this(in.readInt());
        this.E = in.readInt();
        while (in.hasNextLine())
        {
            String[] s = in.readLine().split(" ");
            int v = Integer.valueOf(s[0]);
            int w = Integer.valueOf(s[1]);
            double weight = Double.parseDouble(s[2]);
            Edge edge = new Edge(v, w, weight);
            adj[v].add(edge);
            adj[w].add(edge);
        }
    }
