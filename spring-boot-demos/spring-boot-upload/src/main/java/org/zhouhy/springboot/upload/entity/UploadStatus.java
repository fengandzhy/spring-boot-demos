package org.zhouhy.springboot.upload.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class UploadStatus {
    private Integer status;
    private String msg;

}
