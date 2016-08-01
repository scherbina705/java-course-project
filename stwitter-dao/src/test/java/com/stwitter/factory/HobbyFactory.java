package com.stwitter.factory;

import com.stwitter.entity.Hobby;

/**
 * Created by A.Shcherbina
 * on 01.08.2016.
 */
public class HobbyFactory {
    private static int counter = 1;

    public static Hobby getHobby() {
        Hobby h = new Hobby();
        h.setTitle("Title" + counter);
        h.setDescription("Desc" + counter);
        counter++;
        return h;
    }
}
