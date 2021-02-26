
import java.util.HashMap;
import java.util.Scanner;

class Dis{
    private HashMap<String, Integer> line = new HashMap<String, Integer>();
    private int[][] dis;
    private int i = 0;
    Scanner in = new Scanner(System.in);

    Dis(){
        String str;
        while(!(str = in.next()).equals("###")){
            line.put(str, i++);
        }
        dis = new int[i][i];
    }

    public void setDis(){
        for(int j = 0; j<i; j++){
            for(int k = 0; k<i; k++){
                dis[j][k] = in.nextInt();
            }
        }
    }

    public void getDis(){
        System.out.println(dis[line.get(in.next())][line.get(in.next())]);
    }

    public void print(){
        System.out.println(line);
    }
}
public class Main {

    public static void main(String[] args){
       Dis d = new Dis();
       d.print();
       d.setDis();
       d.getDis();
    }
}
