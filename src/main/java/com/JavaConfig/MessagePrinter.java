package com.JavaConfig;

/**
 * Created by zhaoli8 on 2016/9/20.
 */
public class MessagePrinter {

    private MessageService messageService;
    private Mess mess;


//    public MessagePrinter(MessageService messageService) {
//        this.messageService = messageService;
//    }
    public MessagePrinter(Mess mess) {
        this.mess = mess;
    }

    public void printMessage(String user) {
        System.out.println(String.format(messageService.getMessage(), user));
    }
     public void printMess(String user1) {
            System.out.println(String.format(mess.getmes(), user1));
        }
}
