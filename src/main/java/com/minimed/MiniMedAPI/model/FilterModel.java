package com.minimed.MiniMedAPI.model;

import com.minimed.MiniMedAPI.entity.history.History;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FilterModel {
    private String startdate;
    private String enddate;
    private List<String> types;
    private List<String> statuses;
}
