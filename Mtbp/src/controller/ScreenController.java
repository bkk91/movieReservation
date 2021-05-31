package controller;

import java.util.ArrayList;

import model.ScreenDTO;

public class ScreenController {
    
    ArrayList<ScreenDTO> screenList;
    private int screenId;
    
    public ScreenController() {
        
        screenList = new ArrayList<>();
        screenId = 1;
        
        ScreenDTO s1 = new ScreenDTO();   
        s1.setScreenId(screenId++);
        s1.setScreenNumber("1관");
        screenList.add(s1);
        
        ScreenDTO s2 = new ScreenDTO();   
        s2.setScreenId(screenId++);
        s2.setScreenNumber("2관");
        screenList.add(s2);
        
        ScreenDTO s3 = new ScreenDTO();    
        s3.setScreenId(screenId++);    
        s3.setScreenNumber("3관");
        screenList.add(s3);
        
        ScreenDTO s4 = new ScreenDTO();    
        s4.setScreenId(screenId++);    
        s4.setScreenNumber("4관");
        screenList.add(s4);
        
    }
    // ��ũ���� add/update ��ɸ� �ִ�.
    // ����ڷκ��� �Է¹��� ScreenInfoDTO ��ü (��ȭ�����)�� ����Ʈ�� �߰����ִ� add �޼ҵ�
    public void screenAdd(ScreenDTO s) {
        s.setScreenId(screenId++);
        screenList.add(s);
    }
    
    // ��ȭ���� ������ �����ϴ� update �޼ҵ�
    public void screenUpdate(ScreenDTO updated) {
        for(ScreenDTO s: screenList) {
            if(s.getScreenId() == updated.getScreenId()) {
                s.setScreenNumber(updated.getScreenNumber());
            }
        }
    }
    
    // �����ڷκ��� ��ȭ���ǹ�ȣ�� ��ȭ���� ������ �ҷ����� selectOne�޼ҵ�
    public ScreenDTO screenSelectOne(int screenId) {
        for(ScreenDTO s: screenList) {
            if(s.getScreenId() == screenId) {
                return s;
            }
        }
        return null;
    }
    
    public ArrayList<ScreenDTO> printAll(){
        for(ScreenDTO s: screenList) {
            
        }
        return screenList;
    }
}



