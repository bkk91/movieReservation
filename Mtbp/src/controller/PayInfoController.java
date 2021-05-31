package controller;

import java.util.ArrayList;
import model.PayInfoDTO;

public class PayInfoController {
    
    ArrayList<PayInfoDTO> payInfoList;
    private int paymentId;
    
    public PayInfoController() {
        
        payInfoList = new ArrayList<>();
        paymentId = 1;
        
        PayInfoDTO p1 = new PayInfoDTO();
        p1.setCardNumber(3718);
        p1.setPaymentId(paymentId++);
        
    }
    
    // 사용자로부터 입력받은 PayInfoDTO 객체를 리스트에 추가해주는 add 메소드
    public void add(PayInfoDTO p) {
        p.setPaymentId(paymentId++);
        
        payInfoList.add(p);
    }
    
    // 사용자가 입력한 카드넘버가 DB의 카드넘버와 일치하는지 체크하는 access 메소드    
    public boolean access(PayInfoDTO user) {
        for(PayInfoDTO p : payInfoList) {
            if(p.getCardNumber() == user.getCardNumber()){
                return true;
            }
        }
        return false;
    }
    
    // 사용자가 요청한 id를 가진 PayInfoDTO 객체를 return해주는 selectOne()메소드
    public PayInfoDTO selectOne(int paymentId) {
        for(PayInfoDTO p : payInfoList) {
            if(p.getPaymentId() == paymentId) {
                return p;
            }
        }
        return null;
    }
    
    
}
