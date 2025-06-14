package main;

public class Customer {
    private int CID;
    private int gender;
    private int ageRange;
    private int visitRange;
    private int stayTime;
    private int totalPrice;
    public static int CID_NUM = 0; //전체 고객의 인스턴스의 개수

    public Customer(int gender, int ageRange, int visitRange, int stayTime, int totalPrice) {
        this.CID = ++CID_NUM; //몇 번째로 추가 고객인지를 표시
        this.gender = gender;
        this.ageRange = ageRange;
        this.visitRange = visitRange;
        this.stayTime = stayTime;
        this.totalPrice = totalPrice;
    }

    public int getCID() {
        return CID;
    }

    public int getGender() {
        return gender;
    }

    public int getAgeRange() {
        return ageRange;
    }

    public int getVisitRange() {
        return visitRange;
    }

    public int getStayTime() {
        return stayTime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}