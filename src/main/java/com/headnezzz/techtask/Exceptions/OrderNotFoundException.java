package com.headnezzz.techtask.Exceptions;

import java.text.MessageFormat;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super(MessageFormat.format("Заказ с id = {0} не найден.", id));
    }
}
