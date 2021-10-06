package pers.nbody.sport.util;

public class Vector3 {
    private double x, y, z;

    public Vector3(double initX, double initY, double initZ) {
        x = initX;
        y = initY;
        z = initZ;
    }

    public Vector3() {
        x = y = z = 0;
    }

    public void setVector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double[] getVector3() {
        return new double[] {x, y, z};
    }

    public double mod() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    static public Vector3 add (Vector3 a, Vector3 b) {
        return new Vector3(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    static public Vector3 sub(Vector3 a, Vector3 b) {
        return new Vector3(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    static public double times(Vector3 a, Vector3 b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    static public Vector3 times(double a, Vector3 b) {
        return new Vector3(a * b.x, a * b.y, a * b.z);
    }

    static public Vector3 times(Vector3 a, double b) {
        return new Vector3(a.x * b, a.y * b, a.z * b);
    }

    static public Vector3 divide (Vector3 a, double b) {
        return new Vector3(a.x / b, a.y / b, a.z / b);
    }

    public Vector3 add (Vector3 a) {
        return new Vector3(x + a.x, y + a.y, z + a.z);
    }

    public Vector3 sub(Vector3 a) {
        return new Vector3(x - a.x, y - a.y, z - a.z);
    }

    public double times(Vector3 a) {
        return x * a.x + y * a.y + z * a.z;
    }

    public Vector3 times(double a) {
        return new Vector3(a * x, a * y, a * z);
    }

    public Vector3 divide (double a) {
        return new Vector3(x / a, y / a, z / a);
    }
}
