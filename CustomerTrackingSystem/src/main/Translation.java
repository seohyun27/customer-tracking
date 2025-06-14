package main;

//Customer의 정보를 String에서 int로, int에서 String으로 번역하기 위해 존재하는 번역 클래스

public class Translation {
    public int getIntGender(String gender) {
        if (gender.equals("남성")) {
            return 0;
        } else if (gender.equals("여성")) {
            return 1;
        } else {
            return -1;
        }
    }

    public int getIntAgeRange(String ageRange) {
        switch (ageRange) {
            case "20대 이하": return 0;
            case "20대": return 1;
            case "30대": return 2;
            case "40대": return 3;
            case "50대": return 4;
            case "60대": return 5;
            case "70대": return 6;
            case "80대 이상": return 7;
            default: return -1;
        }
    }

    public int getIntVisitRange(String visitRange) {
        switch (visitRange) {
            case "10시": return 0;
            case "11시": return 1;
            case "12시": return 2;
            case "13시": return 3;
            case "14시": return 4;
            case "15시": return 5;
            case "16시": return 6;
            case "17시": return 7;
            case "18시": return 8;
            case "19시": return 9;
            case "20시": return 10;
            default: return -1;
        }
    }

    public int getIntStayTime(String stayTime) {
        switch (stayTime) {
            case "30분 이하": return 0;
            case "30분": return 1;
            case "1시간": return 2;
            case "1시간 30분": return 3;
            case "2시간": return 4;
            case "2시간 30분": return 5;
            case "3시간": return 6;
            case "3시간 이상": return 7;
            default: return -1;
        }
    }

    public int getIntTotalPrice(String totalPrice) {
        switch (totalPrice) {
            case "20만원 이하": return 0;
            case "20만원": return 1;
            case "40만원": return 2;
            case "60만원": return 3;
            case "80만원": return 4;
            case "100만원": return 5;
            case "100만원 이상": return 6;
            default: return -1;
        }
    }

    public String getStringGender(int gender) {
        if (gender == 0) {
            return "남성";
        } else if (gender == 1) {
            return "여성";
        } else {
            return "알 수 없음";
        }
    }

    public String getStringAgeRange(int ageRange) {
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

    public String getStringVisitRange(int visitRange) {
        switch (visitRange) {
            case 0: return "10시";
            case 1: return "11시";
            case 2: return "12시";
            case 3: return "13시";
            case 4: return "14시";
            case 5: return "15시";
            case 6: return "16시";
            case 7: return "17시";
            case 8: return "18시";
            case 9: return "19시";
            case 10: return "20시";
            default: return "알 수 없음";
        }
    }

    public String getStringStayTime(int stayTime) {
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

    public String getStringTotalPrice(int totalPrice) {
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
