package liuyang.a.migration.questions.prototype20210705.stub.hytera;

import liuyang.a.migration.questions.prototype20210705.CityAlmInterface;

public class CityAlmService implements CityAlmInterface {
    @Override
    public String foo(String param) {
        return "hytera bar " + param;
    }
}
