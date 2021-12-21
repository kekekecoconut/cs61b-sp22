public class NBody {

    public static String imageToDraw = "/images/starfield.jpg";

    public static double readRadius(String fileName){

        In in = new In(fileName);
        in.readLine();
        double radius = in.readDouble();
        return radius;

    }

    public static Body[] readBodies(String fileName){

        In in = new In(fileName);
        in.readLine();
        in.readLine();

        String line =  in.readLine();
        Body[] bodies = new Body[5];

        int i =  0;
        while (line != null ){
            String[] strs = line.split(" ");

            bodies[i] = new Body(Double.parseDouble(strs[1]), Double.parseDouble(strs[3]), Double.parseDouble(strs[5]), Double.parseDouble(strs[7]), Double.parseDouble(strs[9]), strs[strs.length-1]);

            if( i == 4 )
                break;
            i++;;
            line =  in.readLine();

        }
        return  bodies;
    }

    public static void main(String[] args) {


        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
    //    double T = 157788000.0;
    //    double dt = 25000.0;
        double radius = readRadius(filename);
    //    System.out.println("r:"+radius);

        Body[] bodies = readBodies(filename);
        int len = bodies.length;

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);

        /* Clears the drawing window. */
        StdDraw.clear();

        /* Stamps three copies of advice.png in a triangular pattern. */
        StdDraw.picture(0, 0, imageToDraw);

        for (double curT = 0; curT <= T; curT += dt){
            double[] xForces = new double[5];

            double[] yForces = new double[5];
            for (int i = 0; i < len; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);

                bodies[i].update(dt, xForces[i], yForces[i]);

            }
            /* Stamps three copies of advice.png in a triangular pattern. */
            StdDraw.picture(0, 0, imageToDraw);

            for (Body b :
                    bodies) {
        //        System.out.println("b:"+b);
                b.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

        }

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
     //   System.out.println("T:"+T);
    }
}
