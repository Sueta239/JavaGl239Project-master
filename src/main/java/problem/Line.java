package problem;

class Line {
    private double A;
    private double B;
    private double C;
    public Line(double x1,double y1,double x2,double y2){
        this.A=y1-y2;
        this.B=x2-x1;
        this.C=x1*y2-x2*y1;
    }
    @Override
    public String toString() {
        String s =String.format("%.2fx + %.2fy + %.2f = 0",A,B,C);
        if (C<0 ){
            s = String.format("%.2fx + %.2fy - %.2f = 0",A,B,-C);}
        if (B<0){
            s = String.format("%.2fx - %.2fy + %.2f = 0",A,-B,C);}
        if (B<0 && C<0){
            s = String.format("%.2fx - %.2fy - %.2f = 0",A,-B,-C);}
        return s;
    }}