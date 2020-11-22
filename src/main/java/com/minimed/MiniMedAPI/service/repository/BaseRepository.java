package com.minimed.MiniMedAPI.service.repository;

import com.minimed.MiniMedAPI.entity.BaseModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepository<T extends BaseModel> extends PagingAndSortingRepository<T, Long> {
}
