package com.june.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.june.entity.UserChapterRecord;
import com.june.entity.UserChapterRecordPk;

public interface UserChapterRecordDao extends
        PagingAndSortingRepository<UserChapterRecord, Long> {

    UserChapterRecord findByPk(UserChapterRecordPk pk);
}
