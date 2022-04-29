import java.util.*;
class Student{
    String name;
    int id;
    int salary;
    Student(String name,int id,int salary){
        this.name=name;
        this.id=id;
        this.salary = salary;
    }
    Student(){

    }
}
public class graphUsingAdjacencyList {
    public static void add(ArrayList<ArrayList<Student>>arr, int a,Student b,boolean isDirectional){
        arr.get(a).add(b);
    }
    public static void display(ArrayList<ArrayList<Student>> arr){
        for(int i=0;i<arr.size();i++){
            System.out.print("head");
            for(int j=0;j<arr.get(i).size();j++){
                System.out.print("->"+arr.get(i).get(j).id);
            }
            for(int j=0;j<arr.get(i).size();j++){
                System.out.print("->"+arr.get(i).get(j).name);
            }
            for(int j=0;j<arr.get(i).size();j++){
                System.out.print("->"+arr.get(i).get(j).salary);
            }
            System.out.println();
        }
    }
    public static void bfsTraversal(Student source,ArrayList<ArrayList<Student>>a){
        Queue<Student> bfs= new LinkedList<>();
        bfs.add(source);
        Set<Student> visited= new HashSet<>();
        visited.add(source);
        int i=0;
        while(!bfs.isEmpty()&& i<a.size()){
            Student front=bfs.poll();
            if(i!=0) {
                System.out.print(front.id + " " + front.name + " " + front.salary);
                System.out.println();
            }
            ArrayList<Student> neighbourList=a.get(i);
            for(Student res:neighbourList){
                if(!visited.contains(res)) {
                    bfs.add(res);
                    visited.add(res);
                }
            }
            i++;
        }
        Student front= bfs.poll();
        System.out.println(front.id+" "+front.name+" "+front.salary);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int v=scan.nextInt();
        ArrayList<ArrayList<Student>> arr= new ArrayList<>(v);
        for(int i=0;i<v;i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<v;i++){
            Student obj = new Student(scan.next(), scan.nextInt(),scan.nextInt());
            add(arr,i,obj,true);
        }
        display(arr);
        Student obj1= new Student();
        System.out.println();
        bfsTraversal(obj1,arr);
    }
}
