public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass  = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass  = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        double rSquared = (dx * dx) + (dy * dy);
        return Math.sqrt(rSquared);
    }

    public double calcForceExertedBy(Planet p) {
        double G = 6.67e-11;
        double rSquared = this.calcDistance(p);
        rSquared = rSquared * rSquared;
        return G * (this.mass * p.mass) / rSquared;
    }

    public double calcForceExertedByX(Planet p) {
        double force = calcForceExertedBy(p);
        double r = calcDistance(p);
        return (force * (p.xxPos - this.xxPos)) / r;
    }

    public double calcForceExertedByY(Planet p) {
        double force = calcForceExertedBy(p);
        double r = calcDistance(p);
        return (force * (p.yyPos - this.yyPos)) / r;
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double netForce = 0;
        for(Planet planet : p) {
            if(planet.equals(this))
                continue;
            netForce += calcForceExertedByX(planet);
        }
        return netForce;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double netForce = 0;
        for(Planet planet : p) {
            if(planet.equals(this))
                continue;
            netForce += calcForceExertedByY(planet);
        }
        return netForce;
    }

    public void update(double dt, double fX, double fY) {
        double ax = fX / mass;
        double ay = fY / mass;
        xxVel = xxVel + (dt * ax);
        yyVel = yyVel + (dt * ay);
        xxPos = xxPos + (dt * xxVel);
        yyPos = yyPos + (dt * yyVel);
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
