package cor;

import tank.GameObject;

public interface Collider {

    public boolean collide(GameObject o1, GameObject o2);
}
