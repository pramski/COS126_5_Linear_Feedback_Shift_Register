import java.awt.*;

public class phot {
    public static Picture transform (Picture picture, LFSR lfsr){
        Color[][] newColor=new Color[picture.width()][picture.height()];
        int[][] redArray=new int[picture.width()][picture.height()];
        int[][] greenArray=new int[picture.width()][picture.height()];
        int[][] blueArray=new int[picture.width()][picture.height()];
        for (int i=0;i<picture.width();i++) {
            for (int j=0;j<picture.height();j++) {
                Color pixColor=picture.get(i,j);
                redArray[i][j]=pixColor.getRed()^lfsr.generate(8);
                greenArray[i][j]=pixColor.getGreen()^lfsr.generate(8);
                blueArray[i][j]=pixColor.getBlue()^lfsr.generate(8);
                newColor[i][j]=new Color(redArray[i][j],greenArray[i][j],blueArray[i][j]);
                picture.set(i,j,newColor[i][j]);
            }
        }
        return picture;

    }

    public static void main(String[] args){
        Picture pic=new Picture(args[0]);
        LFSR lfsr=new LFSR(args[1],Integer.parseInt(args[2]));
        transform(pic,lfsr);
        pic.show();
    }
}






