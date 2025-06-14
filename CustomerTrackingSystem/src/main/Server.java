package main;

import java.util.ArrayList;

public class Server {
    private Manager manager;
    private ArrayList<Owner> ownerList;

    public Server(Manager manager) {
        this.manager = manager;
        ownerList = new ArrayList<>();
    }

    public boolean checkPW(int PW){ // 로그인 시 매니저의 비밀번호를 체크
        return this.manager.checkPW(PW);
    }

    public boolean checkPW_ID(String ID, int PW){ // 로그인 시 점주의 아이디, 비밀번호를 체크
        for (Owner owner : ownerList) {
            if (owner.getID().equals(ID)) {
                return owner.checkPW(PW);
            }
        }
        return false; // 일치하는 아이디가 없다면 false
    }

    public boolean addOwner(String ID, int PW){
        for(Owner owner : ownerList){
            if(owner.getID().equals(ID)) //똑같은 아이디를 가진 점주가 이미 존재한다면
                return false;
        }

        Owner owner = new Owner(ID, PW);
        ownerList.add(owner);
        return true;
    }

    public boolean delOwner(String ID) { // ID로 점주 삭제
        for (Owner owner : ownerList) {
            if (owner.getID().equals(ID)) {
                ownerList.remove(owner);
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getOwnerIDs() { // 서버에 저장된 점주들을 반환
        ArrayList<String> idList = new ArrayList<>();
        for (Owner owner : ownerList) {
            idList.add(owner.getID());
        }

        return idList;
    }

    public Owner getOwner(String ID) { // 특정 ID의 점주 인스턴스 반환
        for (Owner owner : ownerList) {
            if (owner.getID().equals(ID)) {
                return owner;
            }
        }
        return null; // 해당 ID의 점주 없음
    }
}