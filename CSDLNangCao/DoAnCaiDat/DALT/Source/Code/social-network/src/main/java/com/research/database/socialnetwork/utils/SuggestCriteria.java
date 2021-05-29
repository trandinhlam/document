package com.research.database.socialnetwork.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SuggestCriteria {
    int friendDepth;//độ sâu duyệt cây của đồ thị (bạn của bạn của bạn...), mặc định 0 là ko duyệt
    String generation;
    String city;
}
