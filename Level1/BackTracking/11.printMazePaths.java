import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
            Scanner scn=new Scanner(System.in);
            int n=scn.nextInt();
            int m=scn.nextInt();

            printMazePaths(0,0,n-1,m-1,"");
	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	        if(sr==dr && sc==dc){
                System.out.println(psf);
                return;
            }

            if(sc+1<=dc){ //horizontal
                printMazePaths(sr,sc+1,dr,dc,psf+"h");
            }
            
            if(sr+1<=dr){ //vertical
                printMazePaths(sr+1,sc,dr,dc,psf+"v");
            }

            
	    }

	}