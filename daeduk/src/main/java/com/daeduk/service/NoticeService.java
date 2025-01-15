package com.daeduk.service;

import java.util.List;

import com.daeduk.dto.NoticeDto;

public interface NoticeService {

    public boolean deleteCommentById(long id);

    public List<NoticeDto> getAllComments();

    public boolean addComment(String commentText);
}
