package main;

import java.util.ArrayList;

public class Owner extends User{
    private String ID;
    private ArrayList<Customer> customerList;

    public Owner(String ID, int PW){
        this.ID = ID;
        this.setPW(PW);
        customerList = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    // 고객 추가 메소드
    public void addCust(Customer customer) {
        customerList.add(customer);
    }

    // 고객 성별 리스트 반환
    public ArrayList<Integer> getCustGen() {
        ArrayList<Integer> genList = new ArrayList<>();
        for (Customer c : customerList) {
            genList.add(c.getGender());
        }
        return genList;
    }

    // 고객 나이대 리스트 반환
    public ArrayList<Integer> getCustAge() {
        ArrayList<Integer> ageList = new ArrayList<>();
        for (Customer c : customerList) {
            ageList.add(c.getAgeRange());
        }
        return ageList;
    }

    // 고객 입장 시간대 리스트 반환
    public ArrayList<Integer> getCustVisit() {
        ArrayList<Integer> visitList = new ArrayList<>();
        for (Customer c : customerList) {
            visitList.add(c.getVisitRange());
        }
        return visitList;
    }

    // 고객 머문 시간 리스트 반환
    public ArrayList<Integer> getCustTime() {
        ArrayList<Integer> timeList = new ArrayList<>();
        for (Customer c : customerList) {
            timeList.add(c.getStayTime());
        }
        return timeList;
    }

    // 고객 구매 가격대 리스트 반환
    public ArrayList<Integer> getCustPrice() {
        ArrayList<Integer> priceList = new ArrayList<>();
        for (Customer c : customerList) {
            priceList.add(c.getTotalPrice());
        }
        return priceList;
    }

    // 고객 정보 문자열 리스트 반환
    public ArrayList<String> getCustInfo() {
        ArrayList<String> infoList = new ArrayList<>();
        for (Customer c : customerList) {
            String info = String.format(
                    "고객ID: %d\n성별: %s\n나이대: %s\n방문시간: %s\n머문시간: %s\n구매금액대: %s",
                    c.getCID(),
                    c.getStringGender(),
                    c.getStringAgeRange(),
                    c.getStringVisitRange(),
                    c.getStringStayTime(),
                    c.getStringTotalPrice()
            );
            infoList.add(info);
        }
        return infoList;
    }
}

/*
- ID: String : 점주의 아이디
- customerList: ArrayList<Customer> : Shop Owner가 생성한 Customer의 리스트
+ Owner(ID: String, PW: int) : 점주 객체를 생성하는 생성자
+ getID(): String : 사용자의 아이디 가져오기

+ addCust(customer: Customer) : void : 새로운 고객 추가하기
+ getCustGen(): ArrayList<int> : 자신에게 등록된 모든 고객의 성별을 리스트로 가져오기
+ getCustAge(): ArrayList<int> : 자신에게 등록된 모든 고객의 나이대를 리스트로 가져오기
+ getCustVisit(): ArrayList<int> : 자신에게 등록된 모든 고객의 입장 시간대를 리스트로 가져오기
+ getCsutTime(): ArrayList<int> : 자신에게 등록된 모든 고객이 가게에 머문 시간을 리스트로 가져오기
+ getCustPrice(): ArrayList<int> : 자신에게 등록된 모든 고객이 구매한 물건의 총 가격대를 리스트로 가져오기
+ getCustInfo(): ArrayList<String> : 자신이 저장한 고객들의 모든 고객정보를 문자열 리스트 가져오기
*/