import java.util.*;
//100% Correct
public class graph {
    Map<Integer, LinkedList<Integer>> obj = new HashMap<>();
        public  void addEdge(int a,int b,boolean isDirectional){
            LinkedList<Integer> arr1= obj.getOrDefault(a,new LinkedList<>());
            arr1.add(b);
            obj.put(a,arr1);
            if(isDirectional){
                LinkedList<Integer> arr2=obj.getOrDefault(b,new LinkedList<>());
                arr2.add(a);
                obj.put(b,arr2);
            }
        }
        public void bfsTraversal(int source){
            Queue<Integer> bfs= new LinkedList<>();
            bfs.add(source);
            Set<Integer> visited = new HashSet<>();
            visited.add(source);
            while(!bfs.isEmpty()){
                int front=bfs.poll();
                System.out.print(front+" ");
                LinkedList<Integer> a= obj.get(front);
                for(int res:a){
                    if(!visited.contains(res)){
                        bfs.add(res);
                        visited.add(res);
                    }
                }
            }
        }
        public void SSSP(int source){
            Queue<Integer> bfs= new LinkedList<>();
            bfs.add(source);
            Map<Integer,Integer> map = new HashMap<>();
            for(int res:obj.keySet()){
                map.put(res,Integer.MAX_VALUE);
            }
            map.put(source,0);
            while(!bfs.isEmpty()){
                int front=bfs.poll();
                LinkedList<Integer> arr= obj.get(front);
                for(int i:arr){
                    if(map.get(i)==Integer.MAX_VALUE){
                        bfs.add(i);
                        map.put(i,map.get(front)+1);
                    }
                }
                //System.out.println(map);
            }
            System.out.println();
            int x=0;
            for(Map.Entry p:map.entrySet()){
                if(x== map.size()-1){
                    System.out.println((int)p.getValue());
                }
                x++;
            }

        }

        public  int dfs(int source,Set<Integer> visited){
            System.out.print(source+" ");
            visited.add(source);
            List<Integer> arr= obj.get(source);
            for(int p:arr){
                if(!visited.contains(p))
                    dfs(p,visited);
            }
            return  -1;
        }

    public static void main(String[] args) {
            graph obj1= new graph();
        Set<Integer> set = new HashSet<>();
           obj1.addEdge(0,1,true);
           obj1.addEdge(0,2,true);
           obj1.addEdge(2,3,true);
           obj1.addEdge(3,1,true);
            obj1.bfsTraversal(0);
//            obj1.SSSP(2);
        System.out.println();
            LinkedList<Integer> a = new LinkedList<>();
         obj1.dfs(0,set);
    }
}
