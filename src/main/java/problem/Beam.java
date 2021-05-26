package problem;

import javax.media.opengl.GL2;
import java.util.Random;

public class Beam
{
    Vector2 A;
    Vector2 B;
    Vector2 C;
    Vector2 D;

    public Beam(Vector2 A, Vector2 B, Vector2 C, Vector2 D) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    public void render(GL2 gl) {
        gl.glPointSize(1);
        gl.glBegin(GL2.GL_LINE_STRIP);
        gl.glVertex2d(A.x, A.y);
        gl.glVertex2d(B.x, B.y);
        gl.glVertex2d(C.x, C.y);
        gl.glVertex2d(D.x, D.y);
        gl.glVertex2d(A.x, A.y);

        gl.glEnd();
    }

    public static Beam randomBeam() {
        Random r = new Random();
        double Ax = (double) r.nextInt(50) / 25 - 1;
        double Ay = (double) r.nextInt(50) / 25 - 1;
        double Bx = (double) r.nextInt(50) / 25 - 1;
        double By = (double) r.nextInt(50) / 25 - 1;
        double k1 = (double) r.nextInt(50) / 25 - 1;
        double Cx = 0;
        if (k1<0) Cx = 100000;
        else Cx = -100000;
        if (Ax == Bx) Ax = Bx + 0.01;
        if (Ay == By) Ay = By + 0.01;
        if (Ax == Cx) Cx = Ax + 0.01;
        if (Bx == Cx) Cx = Bx + 0.01;
        double k = (Bx - Ax) / (Ay - By);
        double b = By - k * Bx;
        double Cy = k * Cx + b;
        double Dx = Cx + (Ax - Bx);
        double Dy = Cy + (Ay - By);
        Vector2 A = new Vector2(Ax, Ay);
        Vector2 B = new Vector2(Bx, By);
        Vector2 C = new Vector2(Cx, Cy);
        Vector2 D = new Vector2(Dx, Dy);
        return new Beam(A, B, C, D);
    }
    public static Vector2 insidePoint(Vector2 v, Beam r) {
        Vector2 f = new Vector2(0,0);
        if (Vector2.insideAngle(v, r.B, r.A, r.D) == true && Vector2.insideAngle(v, r.B, r.C, r.D) == true) {
            f.x = v.x;
            f.y = v.y;
        } else {
            f = null;
        }
        return f;
    }
}
