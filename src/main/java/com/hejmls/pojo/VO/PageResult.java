package com.hejmls.pojo.VO;

import com.hejmls.pojo.Result;
import lombok.Data;

import java.util.List;

@Data
public class PageResult {
    private long total; //总记录数

    private List records; //当前页数据集合
}
