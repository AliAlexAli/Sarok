package microsoft_imagine;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class EllenfelPalya {

    private int[][] p;

    public EllenfelPalya(int pM, int[] hajok) {
        this.p = new int[pM][pM];

        for (int i = 0; i < this.p.length; i++) {
            for (int j = 0; j < this.p.length; j++) {
                p[i][j] = 0;
            }
        }
        for (int i = 0; i < hajok.length; i++) {
            while (!plerak(hajok[i]));
        }
    }

    public boolean plerak(int hossz){            
        
        int x = (int) (Math.random() * p.length);
        int y = (int) (Math.random() * p.length);
        if (Math.random() > 0.5) {

            int c = x;

            for (int j = 0; j < hossz; j++) {
                if (y == p.length - 1) {
                    if (c >= p.length || p[c][y] == 1 || p[c][y - 1] == 1) {
                        return false;
                    }
                }
                if (y == 0) {
                    if (c >= p.length || p[x][c] == 1 || p[c][y + 1] == 1) {
                        return false;
                    }
                }
                c++;
            }
            for (int i = 0; i < hossz; i++) {
                p[x][y] = 1;
                x++;
            }
        } else {
            int c = y;
            for (int j = 0; j < hossz; j++) {
                if (x == p.length - 1) {
                    if (c >= p.length || p[x][c] == 1 || p[x - 1][c] == 1) {
                        return false;
                    }
                }
                if (x == 0) {
                    if (c >= p.length || p[x][c] == 1 || p[x + 1][c] == 1) {
                        return false;
                    }
                }
                c++;
            }
            for (int i = 0; i < hossz; i++) {
                p[x][y] = 1;
                y++;
            }
        }
        return true;
    }
    

    public int getElem(int i, int j) {
        return this.p[i][j];
    }

}