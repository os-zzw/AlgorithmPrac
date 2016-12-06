package experiment1;

/**
 * Created by john(Zhewei) on 2016/12/6.
 */
public class Advertisement {
    public Integer num;//数量
    public String name;//名字
    public String email;

    @Override
    public String toString() {
        return "Advertisement{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
