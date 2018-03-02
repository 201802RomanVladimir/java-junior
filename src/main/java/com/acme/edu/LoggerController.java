package com.acme.edu;

import com.acme.edu.messages.Message;
import com.acme.edu.savers.Saver;
import com.acme.edu.savers.ConsoleSaverImpl;

import java.util.ArrayList;

/**
 *
 */
public class LoggerController {
    private ArrayList<Message> messageList = new ArrayList<>();
    private Saver saver = new ConsoleSaverImpl();

    public void log(Message message) {
        if (isCameMessageWithAnotherType(message) || message.isNeedAccumulationReset()){
            flush();
        }
        message.doAccumulationAction();

        if (!messageList.isEmpty() && message.isAccumulationEnabled()) {
            return;
        }

        messageList.add(message);
    }

    public void flush() {
        for (Message m: messageList) {
            saver.save(m);
            m.resetAccumulationState();
        }
        messageList.clear();
    }

    private boolean isCameMessageWithAnotherType(Message message) {
        return !messageList.isEmpty() && messageList.get(0).getValue().getClass() != message.getValue().getClass();
    }
}