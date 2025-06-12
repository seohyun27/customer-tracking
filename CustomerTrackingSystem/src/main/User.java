package main;

public abstract class User {
    protected int PW;

    public boolean checkPW(int PW) {
        if(PW == this.PW)
            return true;
        return false;
    }
}