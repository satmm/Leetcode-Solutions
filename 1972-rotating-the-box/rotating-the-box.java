class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        for(int i =0;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(box[i][j]=='#')
                {
                    for(int k = j+1;k<box[i].length;k++)
                    {
                        if(box[i][k]=='.')
                        {
                            box[i][k]=box[i][j];
                            box[i][j]='.';
                            break;
                        }
                        else if(box[i][k]=='*')
                        {
                            break;
                        }
                    }
                }
            }
        }
        char grid[][] = new char[n][m];
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                grid[i][j]=box[m-1-j][i];
            }
        }
        return grid;
    }
}