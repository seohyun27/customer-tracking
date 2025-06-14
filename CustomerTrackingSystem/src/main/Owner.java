package main;

import java.util.ArrayList;

public class Owner extends User{
    private String ID;
    private ArrayList<Customer> customerList;
    private Statistics statistics;

    /*
    + addCust(custInfo: CustInfo) : boolean : 새로운 고객 추가하기
    + getCustInfo(): ArrayList<String> : 자신이 저장한 고객들의 모든 고객정보를 문자열 리스트 가져오기
    */

    public Owner(String ID, int PW){
        this.ID = ID;
        this.PW = PW;
        customerList = new ArrayList<>();
    }

    public String getID() {
        return this.ID;
    }

    // 고객 추가 메소드
    public void addCust(int gender, int ageRange,
                        int visitRange, int stayTime, int totalPrice) {
        Customer customer = new Customer(gender, ageRange, visitRange, stayTime, totalPrice);
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

    //자신이 저장한 고객들의 모든 고객정보를 문자열 리스트 가져오기
    //(가져온 Integer 정보를 한글로 바꾸는 수정 필요)
    public ArrayList<String> getCustInfo() {
        ArrayList<String> infoList = new ArrayList<>();
        Translation translation = new Translation(); // 번역 클래스 생성

        for (Customer c : customerList) {
            String info = "고객ID : " + c.getCID();
            infoList.add(info);
            info = "성별 : " + translation.getStringGender(c.getGender());
            infoList.add(info);
            info = "나이대 : " + translation.getStringAgeRange(c.getAgeRange());
            infoList.add(info);
            info = "방문 시간 : " + translation.getStringVisitRange(c.getVisitRange());
            infoList.add(info);
            info = "머문 시간 : " + translation.getStringStayTime(c.getStayTime());
            infoList.add(info);
            info = "구매 가격대 : " + translation.getStringTotalPrice(c.getTotalPrice());
            infoList.add(info);
            info = " ";
            infoList.add(info);
        }
        return infoList;
    }
}