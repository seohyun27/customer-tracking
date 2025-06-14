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
        this.CID = ++CID_NUM;
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



    //===========이쪽 내용은 Owner 클래스의 getCustInfo() 함수 안으로 이동================
    // 그냥 사용 or 필요하다면 private 함수로 만들기

}