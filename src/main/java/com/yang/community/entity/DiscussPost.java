package com.yang.community.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * @author ywg
 * @date 2022/1/25 16:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DiscussPost {
    private int id;

    private int userId;

    private String title;

    private String content;

    private int type;

    private int status;

    private Date createTime;

    private int commentCount;//评论数量

    private double score;
}
