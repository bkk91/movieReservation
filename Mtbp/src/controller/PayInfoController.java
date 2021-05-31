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
    
    // ����ڷκ��� �Է¹��� PayInfoDTO ��ü�� ����Ʈ�� �߰����ִ� add �޼ҵ�
    public void add(PayInfoDTO p) {
        p.setPaymentId(paymentId++);
        
        payInfoList.add(p);
    }
    
    // ����ڰ� �Է��� ī��ѹ��� DB�� ī��ѹ��� ��ġ�ϴ��� üũ�ϴ� access �޼ҵ�    
    public boolean access(PayInfoDTO user) {
        for(PayInfoDTO p : payInfoList) {
            if(p.getCardNumber() == user.getCardNumber()){
                return true;
            }
        }
        return false;
    }
    
    // ����ڰ� ��û�� id�� ���� PayInfoDTO ��ü�� return���ִ� selectOne()�޼ҵ�
    public PayInfoDTO selectOne(int paymentId) {
        for(PayInfoDTO p : payInfoList) {
            if(p.getPaymentId() == paymentId) {
                return p;
            }
        }
        return null;
    }
    
    
}
