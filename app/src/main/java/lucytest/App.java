/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lucytest;

import com.nhncorp.lucy.security.xss.XssSaxFilter;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        XssSaxFilter filter = XssSaxFilter.getInstance("lucy-xss-sax.xml", false);
        // String dirty = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/CbtdD5XGpmg\" style=\"width: auto;\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        String dirty = "<a src=\"https://image.wemakeprice.com\" style=\"width: auto;\">test</a>";
        String clean = filter.doFilter(dirty);
        System.out.println(clean);
        System.out.println(dirty.equals(clean));
    }
}
