package com.stackroute.evaluationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Reply implements Serializable {
    private User user;
    private String reply;
    private long likes;
    private long timestamp;
}