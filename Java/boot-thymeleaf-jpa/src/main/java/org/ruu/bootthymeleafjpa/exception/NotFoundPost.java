package org.ruu.bootthymeleafjpa.exception;

import org.ruu.bootthymeleafjpa.common.Common;

public class NotFoundPost extends RuntimeException{

    public NotFoundPost(Long id) {

        super(id + Common.NOT_FOUND_POST_MESSAGE);
    }
}
