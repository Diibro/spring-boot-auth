package com.authenticationsystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageReturn {
     private String message;
     private boolean done;
}
