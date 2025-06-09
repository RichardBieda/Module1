package Module2.Sockets.M6;

import java.io.Serializable;

class Message implements Serializable {

     private String text;

     public Message(String text) {
         this.text = text;
     }

     public String getText() {
         return text;
     }
}
