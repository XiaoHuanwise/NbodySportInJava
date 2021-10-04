package pers.nbody.sport.util;

public class Vector3 {
    private double x, y, z;

    public Vector3(double initX, double initY, double initZ) {
        this.x = initX;
        this.y = initY;
        this.z = initZ;
    }

    public Vector3() {
        this.x = this.y = this.z = 0;
    }

    public void setVector3(double x, double y, double z) {
        this.x = x; this.y = y; this.z = z;
    }
}
