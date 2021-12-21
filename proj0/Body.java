public class Body{

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static double  G = 6.67e-11;

    public Body(double xP, double yP, double xV,double yV, double m, String img){

        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;

    }

    public Body(Body b){

        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;

    }

    public double calcDistance(Body other){

        return Math.sqrt((this.xxPos - other.xxPos) * (this.xxPos - other.xxPos) + (this.yyPos - other.yyPos) * (this.yyPos - other.yyPos));

    }

    public double calcForceExertedBy(Body other){

        double F;
        if(this.equals(other) != true){
            F = (G * this.mass * other.mass) / (calcDistance(other) * calcDistance(other));
        }else{
            F = 0;
        }
        return F;
    }

    public double calcForceExertedByX(Body other) {

        return calcForceExertedBy(other) * (other.xxPos - this.xxPos) / calcDistance(other);
    }

    public double calcForceExertedByY(Body other) {

        return calcForceExertedBy(other) * (other.yyPos - this.yyPos) / calcDistance(other);
    }

    public double calcNetForceExertedByX(Body[] others){

        double Fxs = 0.0;

        for (Body other : others) {
            if(other.equals(this))
                continue;

            Fxs = Fxs + calcForceExertedBy(other) * (other.xxPos - this.xxPos) / calcDistance(other);
        }


    //    System.out.println("Fxs:"+Fxs);

        return Fxs;

    }

    public double calcNetForceExertedByY(Body[] others){

        double Fys = 0.0;

        int i = 0;

        for (Body other : others) {

            if(other.equals(this))
                continue;

            Fys = Fys + calcForceExertedBy(other) * (other.yyPos - this.yyPos) / calcDistance(other);
        }

    //    System.out.println("Fys:"+Fys);


        return Fys;
    }

    public void update(double dt, double fX, double fY){

        double ax = fX / this.mass;
        double ay = fY / this.mass;

        this.xxVel = this.xxVel + dt * ax;
        this.yyVel = this.yyVel + dt * ay;

        this.xxPos = this.xxPos + dt * xxVel;
        this.yyPos = this.yyPos + dt * yyVel;

    //    System.out.println("Body:"+this);
    }

    public void draw(){

        StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
    }

    /*public static void main(String[] args) {


       // Body samh = new Body(1.0 , 0.0, 0.0, 0.0 ,7e5);
        Body samh = new Body(1,0,0,0,7e5,"/aaa.gif");
        Body rocinante = new Body(5,-3,0,0,9e6,"/sss.gif");
        System.out.println("calcForceExertedBy.result:"+samh.calcForceExertedBy(rocinante));


    }*/


}
