package com.acme.edu.savers;

import com.acme.edu.messages.Message;

public class ConsoleSaverImpl implements Saver {
    @Override
    public void save(Message message) {
        System.out.println(message);
    }
}
