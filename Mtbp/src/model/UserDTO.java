package model;

public class UserDTO {
    // 회원번호
    private int userId;
    // 회원아이디
    private String userName;
    // 회원비밀번호
    private String userPassword;
    // 회원닉네임
    private String userNickname;
    // 회원주소
    private String userAddress;
    // 회원전화번호
    private String userPhonenumber;
    // 회원등급 (일반회원 1, 관리자 0)
    private int grade;
    
    // Getter, Setter    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserNickname() {
        return userNickname;
    }
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
    public String getUserAddress() {
        return userAddress;
    }
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
    public String getUserPhonenumber() {
        return userPhonenumber;
    }
    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    // equals() User
    public boolean equals(Object o) {
        if(o instanceof UserDTO) {
            UserDTO u = (UserDTO)o;
            if(userId == u.userId) {
                return true;
            }
        }
        return false;
    }
}
