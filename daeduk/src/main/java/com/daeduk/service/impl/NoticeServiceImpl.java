package com.daeduk.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daeduk.dto.NoticeDto;
import com.daeduk.entity.NoticeEntity;
import com.daeduk.repository.NoticeRepository;
import com.daeduk.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public boolean deleteCommentById(long id) {
        if (noticeRepository.existsById(id)) {
            try {
                noticeRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public List<NoticeDto> getAllComments() {

        List<NoticeEntity> noticeList = noticeRepository.findAll();
        List<NoticeDto> noticeDtos = new ArrayList<>();

        for (NoticeEntity entity : noticeList) {
            NoticeDto dto = modelMapper.map(entity, NoticeDto.class);
            noticeDtos.add(dto);
        }

        return noticeDtos;
    }

    public boolean addComment(String commentText) {
        try {
            NoticeEntity noticeEntity = new NoticeEntity();
            noticeEntity.setComment(commentText);
            noticeRepository.save(noticeEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
