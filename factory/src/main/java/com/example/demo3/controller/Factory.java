package com.example.demo3.controller;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    public Map<String, Class> map = new HashMap<>();

    public Factory() {
        map.put("action-un.do", ActionUn.class);
        map.put("login.do", LoginAction.class);
        map.put("logout.do", LogoutAction.class);
        map.put("action-debut.do", ActionDebut.class);
    }

    public Action getClasse(String className) throws InstantiationException, IllegalAccessException {
        Class myclass = map.get(className);
        return (Action) myclass.newInstance();
    }

}
