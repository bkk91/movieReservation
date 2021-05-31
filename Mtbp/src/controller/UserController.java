package controller;

import java.util.ArrayList;
import model.UserDTO;

public class UserController {

    ArrayList<UserDTO> userList;
    private int userId;
    private int adminId;

    public UserController() {
        userList = new ArrayList<>();
        userId = 1;
        adminId = 0;

        UserDTO u1 = new UserDTO();
        u1.setGrade(1);
        u1.setUserId(userId++);
        u1.setUserName("user001");
        u1.setUserPassword("user001");
        u1.setUserNickname("Alex Kwak");
        u1.setUserAddress("서울시 강남구 대치동");
        u1.setUserPhonenumber("010-2048-XXXX");

        userList.add(u1);

        // ������ �α��� ����
        UserDTO u2 = new UserDTO();
        u2.setGrade(0);
        u2.setUserId(adminId++);
        u2.setUserName("admin001");
        u2.setUserNickname("admin001");
        u2.setUserPassword("admin001");
        u2.setUserAddress("admin001");
        u2.setUserPhonenumber("admin001");

        userList.add(u2);
        
    }
    // ����ڷκ��� �Է¹��� UserDTO ��ü(�Ϲݻ����)�� ����Ʈ�� �߰����ִ� add �޼ҵ�
    public void add(UserDTO u) {
        u.setUserId(userId++);
        u.setGrade(1);

        userList.add(u);
    }

    // ����ڰ� �Է��� �α��� ������ ��ġ�ϴ� ��ü�� ã�Ƴ���
    // �ش� ��ü�� �������ְ� ��ġ�ϴ� ��ü�� ������ null�� �������ִ�
    // auth() �޼ҵ�
    public UserDTO auth(UserDTO user) {
        for (UserDTO u : userList) {
            if (u.getUserName().equals(user.getUserName()) 
                    && u.getUserPassword().equals(u.getUserPassword())) {
                return u;
            }
        }
        return null;
    }
    
    // ����ڷκ��� �Է��� username�� ���� username�� ������
    // true�� �������ִ� validateUsername() �޼ҵ�
    public boolean validateUsername(UserDTO user) {
        for (UserDTO u : userList) {
            if (u.getUserName().equals(user.getUserName())) {
                return true;
            }
        }
        return false;
    }
    
    // ����ڰ� ��û�� id�� ���� UserDTO ��ü�� return���ִ�
    // selectOne()�޼ҵ�
    public UserDTO selectOne(int id) {
        for (UserDTO u : userList) {
            if (u.getUserId() == id) {
                return u;
            }
        }

        return null;
    }
    
    // �����ڰ� ȸ���� ������ �޼ҵ�
    public void delete(UserDTO u) {
        userList.remove(u);
    }
    
    // �����ڰ� ȸ���� ������ ������ �޼ҵ�
    public void update(UserDTO updated) {
        for(UserDTO u: userList) {
            if(u.getUserId() == updated.getUserId()) {
                u.setUserPassword(updated.getUserPassword());
                u.setUserNickname(updated.getUserNickname());
                u.setUserAddress(updated.getUserAddress());
                u.setUserPhonenumber(updated.getUserPassword());
            }
        }
    }
    
    // ȸ�� ��ü����� �����ִ� �޼ҵ�
    public ArrayList<UserDTO> printAll() {
        for (UserDTO u : userList) {
        }
        return userList;
    }
}
