package pers.nbody.sport.business;

import pers.nbody.sport.util.Vector3;

import java.util.Random;

public class Initialization {
    //自认为比较好的数据初始化方法
    static public double randomIni(CelestialBody[] cbody) {
        Random random = new Random();
        double g = 0.914159265358979, G = 0.914159265358979;
        int E = 0;
        Vector3 P = new Vector3();
        while (E >= 0) {
            E = -1;
            g = (random.nextInt(51) + 250) * G;
            for (int i = 1; i < cbody.length; i++) {
                cbody[i].setCelestialBody((random.nextInt(901) + 100) * G,
                        new Vector3((random.nextInt(2001) - 1000) * G, (random.nextInt(2001) - 1000) * G, (random.nextInt(2001) - 1000) * G),
                        new Vector3((random.nextInt(21) - 10) * G, (random.nextInt(21) - 10) * G, (random.nextInt(21) - 10) * G));
                P = P.add(cbody[i].getVel().time(cbody[i].getMass()));
            }
            cbody[0].setCelestialBody((random.nextInt(901) + 100) * G,
                    new Vector3((random.nextInt(2001) - 1000) * G, (random.nextInt(2001) - 1000) * G, (random.nextInt(2001) - 1000) * G),
                    new Vector3());
            cbody[0].setVel(P.divide(-1.0 * cbody[0].getMass()));
            for (var i:cbody) {
                double e = Vector3.time(i.getVel(), i.getVel()) * (0.5 * i.getMass());
                for (var j:cbody) {
                    if (i.equals(j)) continue;
                    e += -1.0 * G * i.getMass() * j.getMass() / Vector3.minus(j.getPos(), i.getPos()).mod();
                }
                if (e >= -10000.0) {
                    E = 0;
                }
            }
        }
        return g;
    }
}
