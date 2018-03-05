package com.acme.edu;

import com.acme.edu.message.Message;
import com.acme.edu.saver.Saver;
import com.acme.edu.saver.ConsoleSaver;

import java.util.ArrayList;

/**
 * Управление процессом логирования
 */
class LoggerController {
    private ArrayList<Message> messageList = new ArrayList<>();
    private Saver saver = new ConsoleSaver();

    /**
     * Обработка сообщения {@code message}
     * @param message сообщение для логирования
     */
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

    /**
     * Вывод накопленных сообщений из буфера
     */
    public void flush() {
        for (Message m: messageList) {
            saver.save(m);
            m.resetAccumulationState();
        }
        messageList.clear();
    }

    private boolean isCameMessageWithAnotherType(Message message) {
        return !messageList.isEmpty() &&
                messageList.get(0).getValue().getClass() != message.getValue().getClass();
    }
}