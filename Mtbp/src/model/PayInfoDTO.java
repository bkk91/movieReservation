package model;

public class PayInfoDTO {
    // 결제번호
    private int paymentId;
    // 카드번호
    private int cardNumber;

    // Getter, Setter
    
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
    
    // equals() PayInfo
    public boolean equals(Object o) {
        if(o instanceof PayInfoDTO) {
            PayInfoDTO p = (PayInfoDTO)o;
            if(paymentId == p.paymentId) {
                return true;
            }
        }        
        return false;
    }

}
