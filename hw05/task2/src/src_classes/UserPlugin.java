package encrypted_classes;

import ru.sberbank.jschool.homework.classloaders.koval.Plugin;

public class UserPlugin implements Plugin<String> {
    /**
     * plugin operates on a String array of URLs
     * and prints the result to System.out
     *
     * @param urls - string values operated on
     */
    public void run(String[] urls) {
        System.out.println("list of urls:");
        for (String url : urls) {
            System.out.println(url);
        }
    }
}
