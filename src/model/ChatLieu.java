
package model;

public class ChatLieu {
    Integer idInteger;
    String chatLieu;

    public Integer getIdInteger() {
        return idInteger;
    }

    public void setIdInteger(Integer idInteger) {
        this.idInteger = idInteger;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public ChatLieu(Integer idInteger, String chatLieu) {
        this.idInteger = idInteger;
        this.chatLieu = chatLieu;
    }

    @Override
    public String toString() {
        return "DA1{" + "idInteger=" + idInteger + ", chatLieu=" + chatLieu + '}';
    }

    public ChatLieu() {
    }
}
