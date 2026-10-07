package com.zdph.contract.fulfillment.infrastructure.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class P6SpyLogger implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String s4) {
        return !"".equals(sql.trim()) ? (DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS").format(
                LocalDateTime.now()) + " | took " + elapsed + "ms | " + category + " | connection " + connectionId + "\n " + sql + ";") : "";
    }
}
