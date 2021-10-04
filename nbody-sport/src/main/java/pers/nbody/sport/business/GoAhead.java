package pers.nbody.sport.business;

import pers.nbody.sport.util.Vector3;

public class GoAhead {
    //四阶龙格库塔模拟
    static public void ode4(double h, double G, CelestialBody[] last) throws NullPointerException {
        //复制天体
        int len = last.length;
        CelestialBody[] now = new CelestialBody[len];
        for (int i = 0; i < len; i++) {
            now[i] = new CelestialBody(last[i].getMass(), last[i].getPos(), last[i].getVel());
        }

        //一阶
        for (int i = 0; i < len; i++) {
            now[i].setK(1, last[i].getVel());
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                Vector3 r = now[j].getPos().minus(now[i].getPos());
                Vector3 temp = r.time(G * now[j].getMass() / Math.pow(r.mod(), 3));
                now[i].setL(1, now[i].getL(1).add(temp));
            }
        }

        //二阶
        for (int i = 0; i < len; i++) {
            now[i].setPos(last[i].getPos().add(now[i].getK(1).time(h / 2.0)));
        }

        for (int i = 0; i < len; i++) {
            now[i].setK(2, last[i].getVel().add(now[i].getL(1).time(h / 2.0)));
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                Vector3 r = now[j].getPos().minus(now[i].getPos());
                Vector3 temp = r.time(G * now[j].getMass() / Math.pow(r.mod(), 3));
                now[i].setL(2, now[i].getL(2).add(temp));
            }
        }

        //三阶
        for (int i = 0; i < len; i++) {
            now[i].setPos(last[i].getPos().add(now[i].getK(2).time(h / 2.0)));
        }

        for (int i = 0; i < len; i++) {
            now[i].setK(3, last[i].getVel().add(now[i].getL(2).time(h / 2.0)));
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                Vector3 r = now[j].getPos().minus(now[i].getPos());
                Vector3 temp = r.time(G * now[j].getMass() / Math.pow(r.mod(), 3));
                now[i].setL(3, now[i].getL(3).add(temp));
            }
        }

        //四阶
        for (int i = 0; i < len; i++) {
            now[i].setPos(last[i].getPos().add(now[i].getK(3).time(h / 2.0)));
        }

        for (int i = 0; i < len; i++) {
            now[i].setK(4, last[i].getVel().add(now[i].getL(3).time(h / 2.0)));
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                Vector3 r = now[j].getPos().minus(now[i].getPos());
                Vector3 temp = r.time(G * now[j].getMass() / Math.pow(r.mod(), 3));
                now[i].setL(4, now[i].getL(4).add(temp));
            }
        }

        //加权平均
        for (int i = 0; i < len; i++) {
            last[i].setPos(last[i].getPos().add(
                    now[i].getK(1)
                            .add(now[i].getK(2).time(2))
                            .add(now[i].getK(3).time(2))
                            .add(now[i].getK(4).time(h / 6.0))));
            last[i].setVel(last[i].getVel().add(
                    now[i].getL(1)
                            .add(now[i].getL(2).time(2))
                            .add(now[i].getL(3).time(2))
                            .add(now[i].getL(4).time(h / 6.0))));
        }
    }
}
