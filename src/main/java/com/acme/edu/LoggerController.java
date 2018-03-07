package com.acme.edu;

import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.message.Message;
import com.acme.edu.saver.Saver;
import java.util.ArrayList;

/**
 * Управление процессом логирования
 */
class LoggerController {
    private ArrayList<Message> messageList = new ArrayList<>();
    private final Saver saver;
    private FormatVisitor formatter;

    LoggerController(Saver saver) {
        this.saver = saver;
    }

    /**
     * Обработка сообщения {@code message}
     * @param message сообщение для логирования
     */
    public void log(Message message, FormatVisitor formatter) {
        if (message.getValue() == null) return;

        if (needFlush(message)){
            flush();
        }

        this.formatter = formatter;

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
        for (Message m : messageList) {
            saver.save(formatter.format(m));
            m.resetAccumulationState();
        }
        messageList.clear();
    }

    private boolean needFlush(Message message) {
        return isCameMessageWithAnotherType(message) || message.isNeedAccumulationReset();
    }

    private boolean isCameMessageWithAnotherType(Message message) {
        return !messageList.isEmpty() &&
                messageList.get(0).getValue().getClass() != message.getValue().getClass();
    }
}