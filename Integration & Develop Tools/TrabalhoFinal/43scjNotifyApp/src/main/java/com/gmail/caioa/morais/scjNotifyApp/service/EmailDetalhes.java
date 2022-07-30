package com.gmail.caioa.morais.scjNotifyApp.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetalhes {

    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;

}
