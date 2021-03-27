package head_first设计模式.ch11;

/**
 * @Description
 * @ClassName PersonBean
 * @Author weilc
 * @Date 2021-01-28
 * @Version 1.0
 */
public interface PersonBean {
    String getName();

    String getGender();

    String getInterests();

    int getHotOrNotRating();

    void setName(String name);

    void setGender(String gender);

    void setInterests(String interests);

    void setHotOrNotRating(int rating);
}
