package pers.nbody.sport.util;

public class CelestialBody {
    private double mass;
    private Vector3 pos, vel;
    private Vector3[] k;
    private Vector3[] l;

    public CelestialBody() {
        mass = 0;
        pos = null;
        vel = null;
        k = new Vector3[4];
        l = new Vector3[4];
    }

    public CelestialBody(double mass, Vector3 pos, Vector3 vel) {
        this.mass = mass;
        this.pos = pos;
        this.vel = vel;
        k = new Vector3[4];
        l = new Vector3[4];
    }

    public void setCelestialBody(double mass, Vector3 pos, Vector3 vel) {
        this.mass = mass;
        this.pos = pos;
        this.vel = vel;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setPos(Vector3 pos) {
        this.pos = pos;
    }

    public void setVel(Vector3 vel) {
        this.vel = vel;
    }

    protected void setK(int x, Vector3 k) {
        this.k[x-1] = k;
    }

    protected void setL(int x, Vector3 l) {
        this.l[x-1] = l;
    }

    public double getMass() {
        return mass;
    }

    public Vector3 getPos() {
        return pos;
    }

    public Vector3 getVel() {
        return vel;
    }

    protected Vector3 getK(int x) {
        return k[x-1];
    }

    protected Vector3 getL(int x) {
        return l[x-1];
    }
}
