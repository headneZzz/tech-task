package com.headnezzz.techtask.Exceptions;

import java.text.MessageFormat;

public class GoodsNotFoundException extends RuntimeException{
    public GoodsNotFoundException(Long id) {
        super(MessageFormat.format("Товар с id = {0} не найден.", id));
    }
}
