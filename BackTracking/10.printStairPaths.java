import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

    }

    public static void printStairPaths(int n, String path) {
        if(n==0){
            System.out.println(path);
            return;
        }
        
        for(int i=1;i<=3;i++){
            if(n-i>=0){
                printStairPaths(n-i,path+i);
            }
        }
    
    }

}