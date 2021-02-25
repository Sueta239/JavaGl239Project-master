package problem;

class Vector2
{
    double x;
    double y;
    public Vector2() {
        x = 1;
        y = 0; }
    @Override
    public String toString() {
        String s = String.format("(%.2f,%.2f)", x, y);
        return s; }
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y; }
    public Vector2(Vector2 v) {
        this.x = v.x;
        this.y = v.y; }
    public void setX(double x) {
        this.x = x; }
    public double getX() {
        return x; }
    public void setY(double y) {
        this.y = y; }
    public double getY() {
        return y; }
    public double len() {
        return Math.sqrt(x * x + y * y); }
    public void x(double q) {
        x = x*q;
        y = y*q; }
    public void plus(Vector2 v2) {
        x = x+v2.x;
        y = y+v2.y; }
    public void minus(Vector2 v2) {
        x = x-v2.x;
        y = y-v2.y; }
    public Vector2 sum(Vector2 v2) {
        Vector2 sum = new Vector2(0, 0);
        sum.x = x + v2.x;
        sum.y = y + v2.y;
        return sum; }
    public static Vector2 sum(Vector2 v2, Vector2 v3) {
        Vector2 sum = new Vector2(0, 0);
        sum.x = v3.x + v2.x;
        sum.y = v3.y + v2.y;
        return sum; }

    public Vector2 mult(double q) {
        return new Vector2(x * q, y * q); }

    public double mult(Vector2 v2) {
        return x * v2.x + y * v2.y; }

    public static double mult(Vector2 v2, Vector2 v3){
        return v3.x * v2.x + v3.y * v2.y; }

    public static Vector2 mult(Vector2 v2, double q) {
        return new Vector2(v2.x * q, v2.y * q); }
    public void normalize() {
        double q  = Math.sqrt(x * x + y * y);
        if (q==0){this.y=0 ;this.x = 0;}else{
            this.y=y/q;
            this.x=x/q;} }
    public Vector2 norm() {
        double q  = Math.sqrt(x * x + y * y);
        if (q==0){this.y=0 ;this.x = 0;}else{
            this.y=y /q ;
            this.x=x /q;}
        return new Vector2(x , y ); }
}
