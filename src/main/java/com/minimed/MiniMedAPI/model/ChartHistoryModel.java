package com.minimed.MiniMedAPI.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChartHistoryModel {
    private double irsen;
    private double ireegvi;
}
