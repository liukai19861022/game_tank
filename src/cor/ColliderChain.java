package cor;

import tank.GameObject;
import tank.PropertyMgr;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider{

    List<Collider> colliders = new LinkedList<Collider>();

    public ColliderChain() {
        String colliders = (String) PropertyMgr.getInstance().get("colliders");
        String[] colliderArr = colliders.split(",");
        for (String colliderStr : colliderArr) {

            try {
                Collider col = (Collider) Class.forName(colliderStr).getDeclaredConstructor().newInstance();
                add(col);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ColliderChain add(Collider col) {

        colliders.add(col);
        return this;
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        for (Iterator<Collider> iterator = colliders.iterator(); iterator.hasNext();) {
            Collider col = iterator.next();
            if (!col.collide(o1, o2)) return false;
        }

        return true;
    }
}
