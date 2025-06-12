package main;

public class Manager extends User {

    Manager(int PW){
        this.PW = PW;
    }
}

/*
    ArrayList<Owner> ownerList;
    public ArrayList<Owner> getOwners() {
        return ownerList;
    }

    public void addOwner(Owner owner){
        ownerList.add(owner);
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
* */