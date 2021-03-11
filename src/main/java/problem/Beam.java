package problem;

import javax.media.opengl.GL2;
import java.util.Random;

public class Beam {
    Vector2 posA;
    Vector2 posB;

    public Beam(Vector2 posA, Vector2 posB) {
        this.posA = posA;
        this.posB = posB;
    }

    public void render(GL2 gl) {
        Vector2 posC = new Vector2(posB.x - posA.x, posB.y - posA.y);//вектор b-a=c
        double q = Math.sqrt(posC.x * posC.x + posC.y * posC.y);
        posC.y = posC.y * 17 / q;
        posC.x = posC.x * 17 / q;
        Vector2 pos1 = new Vector2(posC.y + posA.x, -posC.x + posA.y);
        Vector2 pos2 = new Vector2(posC.y + posA.x + posB.x - posA.x, -posC.x + posA.y + posB.y - posA.y);

        gl.glBegin(GL2.GL_LINE_STRIP);
        gl.glColor3d(1, 0, 1);
        gl.glVertex2d(posA.x, posA.y);
        gl.glVertex2d(posB.x, posB.y);
        gl.glVertex2d(pos1.x, pos1.y);
        gl.glVertex2d(pos2.x, pos2.y);
        gl.glVertex2d(posA.x, posA.y);
        gl.glEnd();
    }
    public static Beam getRandomBeam(){
        Random r = new Random();
        double x1 = r.nextDouble()*2-1;
        double y1 = r.nextDouble()*2-1;
        double x2 = r.nextDouble()*2-1;
        double y2 = r.nextDouble()*2-1;
        return new Beam(new Vector2(x1,y1),new Vector2(x2,y2));
    }
}


