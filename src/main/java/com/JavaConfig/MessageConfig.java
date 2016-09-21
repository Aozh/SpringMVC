package com.JavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhaoli8 on 2016/9/20.
 */

    @Configuration
    public class MessageConfig {
     @Bean
    public MessageService mess(){
         return new MessageService();
     }
     @Bean
    public MessImp mess1(){
         return new MessImp();
     }
//     @Bean
//    public MessagePrinter messp(){
//         return new MessagePrinter(mess());
//     }
     @Bean
    public MessagePrinter me(){
         return new MessagePrinter(mess1()) ;
     }

}
