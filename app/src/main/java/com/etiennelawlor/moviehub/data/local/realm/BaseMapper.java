package com.etiennelawlor.moviehub.data.local.realm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by etiennelawlor on 2/20/17.
 */

public abstract class BaseMapper<Pojo, RealmObject> {

    public abstract Pojo mapFromRealmObject(RealmObject realmObject);

    public abstract RealmObject mapToRealmObject(Pojo pojo);

    public List<Pojo> mapFromRealmList(List<RealmObject> realmObjectList) {
        List<Pojo> pojoList = null;
        if (realmObjectList != null) {
            pojoList = new ArrayList<>();
            Pojo pojo;
            for (RealmObject realmObject : realmObjectList) {
                pojo = mapFromRealmObject(realmObject);
                pojoList.add(pojo);
            }
        }
        return pojoList;
    }

    public List<RealmObject> mapToRealmList(List<Pojo> pojoList) {
        List<RealmObject> realmObjectList = null;
        if (pojoList != null) {
            realmObjectList = new ArrayList<>();
            RealmObject realmObject;
            for (Pojo pojo : pojoList) {
                realmObject = mapToRealmObject(pojo);
                realmObjectList.add(realmObject);
            }
        }
        return realmObjectList;
    }
}