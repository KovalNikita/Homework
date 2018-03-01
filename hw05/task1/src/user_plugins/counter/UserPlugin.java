package user_plugins.counter;

import ru.sberbank.jschool.homework.classloaders.koval.Plugin;

public class UserPlugin implements Plugin {
    /**
     * plugin operates on a String array of URLs
     * and prints the result to System.out
     *
     * @param urls - string values operated on
     */
    public void run(String[] urls) {
        System.out.println("number of urls: " + urls.length);
    }
}
