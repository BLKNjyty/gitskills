package Graph.First;

import java.util.*;

public class Kruskal {
    //关键功能简易版 初始化 isSameSet union
    public static class Mylists{
        public HashMap<Node, List<Node>> setMap;  //一个点所对应的集合。相当于总表

        //初始化 输入一个node的列表集合
        public void Mylists(List<Node> nodes){
            for (Node node : nodes) {
                ArrayList<Node> list = new ArrayList<Node>();
                list.add(node);
                setMap.put(node, list);  //这个点node对应的是集合list，一开始认为每个的点都是自己的一个list
            }
        }

        //判断from,to是否是一个集合
        public boolean isSameSet(Node from,Node to){
            List<Node> fromList = setMap.get(from);
            List<Node> toList = setMap.get(to);   //从总表中拿出 from列表 to列表
            return fromList == toList;  //from to是针对edge连接的两个节点，若是无向图，from=to .这里是两个List的地址值相等，代表在总表里在一个List里
        }

        //from,to合成一个集合
        public void union(Node from,Node to){
            List<Node> fromList = setMap.get(from);
            List<Node> toList = setMap.get(to);   //从总表中拿出 from列表 to列表
            //把Tolist中的所有to节点放到FromList里
            for (Node toNode : toList) {
                fromList.add(toNode);
                //在跟新总表，把to节点归属于from集合
                setMap.put(toNode, fromList);

                //至此。所有的from节点和to节点都在FromList里，同时老tolist里的元素也在总表里归属于from

            }
        }
    }
    public static class EdgeComparator implements  Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }
    public static Set<Edge> kruskalMST(Graph graph) {
        Mylists mylists = new Mylists();   // 并查集
        ArrayList<Node> nodes = new ArrayList<>();
        for (Node node:graph.nodes.values()){
            nodes.add(node);
        }  //初始化
        mylists.Mylists(nodes);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);       //比较器从大到小排边
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!mylists.isSameSet(edge.from, edge.to)) {  //判断from,to是否是一个集合，不是说明这个边要
                result.add(edge);
                mylists.union(edge.from, edge.to);  //合并，下次就不要了
            }
        }
        return result;
    }
}
