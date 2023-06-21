package zyu.android.callback.sample1;

public class CompanyA {

    private PhoneCallback callBack;

    public CompanyA() {
    }

    public void setCallBack(PhoneCallback callBack) {
        this.callBack = callBack;
    }

    public String Work() {
        //调用接口里的方法
        String answer = callBack.Counseling();

        return answer + " ";
    }
}

