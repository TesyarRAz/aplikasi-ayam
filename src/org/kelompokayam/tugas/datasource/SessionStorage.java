/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.datasource;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author raz
 */
public class SessionStorage implements Storage<Session> {
    private static Map<String, Object> sessions = new HashMap<>();

    @Override
    public boolean write(Session data) throws Exception {
        sessions.put(data.getKey(), data.getValue());
        
        return sessions.containsKey(data.getKey());
    }
    
    public Session read(String key) throws Exception {
        if (!sessions.containsKey(key)) return null;
        
        return new Session(key, sessions.get(key));
    }

    @Override
    public Session read() throws Exception {
        throw new Exception("Unused Method");
    }
    
}
