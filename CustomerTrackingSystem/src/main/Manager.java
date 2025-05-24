package main;

import java.util.ArrayList;
import java.util.Iterator;

public class Manager extends User {
    ArrayList<Owner> ownerList;

    Manager(int PW){
        this.setPW(PW);
        ownerList = new ArrayList<>();
    }

    public ArrayList<Owner> getOwners() {
        return ownerList;
    }

    public void addOwner(Owner owner){
        //오너 클래스 생성자로 생성 후 리스트에 연결
    }

    public void delOwner(String ID){
        Iterator<Owner> iterator = ownerList.iterator();
        while (iterator.hasNext()) {
            Owner owner = iterator.next();
            if (owner.getID().equals(ID)) {
                iterator.remove();
                break; // 중복 ID가 없다고 가정
            }
        }
    }

    public ArrayList<String> getOwnerIDs() {
        ArrayList<String> idList = new ArrayList<>();
        for (Owner owner : ownerList) {
            idList.add(owner.getID());
        }
        return idList;
    }
}

/*+ Manager(PW: int) : 매니저 객체를 생성하는 생성자
+ getOwners() : ArrayList<Owner> : 오너 리스트 가져오기
+ addOwner(owner: Owner) : void : 새로운 오너 추가하기
+ delOwner(ID: int) : void : 해당 ID를 가진 오너 삭제하기
+ getOwnerIDs() : ArrayList<String> : 내가 생성한 오너들의 아이디만을 저장한 아이디 리스트 가져오기*/