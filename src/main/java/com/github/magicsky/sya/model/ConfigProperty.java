package com.github.magicsky.sya.model;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author garcia.wul@alibaba-inc.com
 */
@Data
public class ConfigProperty {

    // 不推荐使用的智能指针
    private List<String> riskSmartPointers = Lists.newArrayList(
        "auto_ptr", "std::auto_ptr", "scoped_ptr", "boost::scoped_ptr", "linked_ptr"
    );

    // 头文件以什么结尾
    private List<String> headerEndsWith = Lists.newArrayList(
        ".h", ".hh", ".hxx", ".hpp"
    );
}
