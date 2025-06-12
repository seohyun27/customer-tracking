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

    public String getStringGender() {
        if (gender == 0) {
            return "남성";
        } else if (gender == 1) {
            return "여성";
        } else {
            return "알 수 없음";
        }
    }

    public String getStringAgeRange() {
        switch (ageRange) {
            case 0: return "20대 이하";
            case 1: return "20대";
            case 2: return "30대";
            case 3: return "40대";
            case 4: return "50대";
            case 5: return "60대";
            case 6: return "70대";
            case 7: return "80대 이상";
            default: return "알 수 없음";
        }
    }

    public String getStringVisitRange() {
        if (visitRange >= 0 && visitRange <= 10) {
            return (10 + visitRange) + "시";
        } else {
            return "알 수 없음";
        }
    }

    public String getStringStayTime() {
        switch (stayTime) {
            case 0: return "30분 이하";
            case 1: return "30분";
            case 2: return "1시간";
            case 3: return "1시간 30분";
            case 4: return "2시간";
            case 5: return "2시간 30분";
            case 6: return "3시간";
            case 7: return "3시간 이상";
            default: return "알 수 없음";
        }
    }

    public String getStringTotalPrice() {
        switch (totalPrice) {
            case 0: return "20만원 이하";
            case 1: return "20만원";
            case 2: return "40만원";
            case 3: return "60만원";
            case 4: return "80만원";
            case 5: return "100만원";
            case 6: return "100만원 이상";
            default: return "알 수 없음";
        }
    }
}

