package com.example.javaexamples;

import java.util.Map;

public class Common {
    public static final int  HeaderLength = 40;
    public static final char HeaderChar   = '#';

    public static boolean init(String project) {

        for (int i=0; i<HeaderLength; ++i) {
            System.out.print(HeaderChar);
        }
        System.out.println("\n    " + project);
        for (int i=0; i<HeaderLength; ++i) {
            System.out.print(HeaderChar);
        }
        System.out.println("");

        Map<String, String> env = System.getenv();

        String http_proxy = env.get("http_proxy");
        if (http_proxy != null) {
            int httpColIndex = http_proxy.indexOf(":");
            if (httpColIndex > 0) {
                System.setProperty("http.proxyHost", http_proxy.substring(0, httpColIndex));
                System.setProperty("http.proxyPort", http_proxy.substring(httpColIndex+1, http_proxy.length()));
            }
        }

        String https_proxy = env.get("https_proxy");
        if (https_proxy != null) {
            int httpsColIndex = https_proxy.indexOf(":");
            if (httpsColIndex > 0) {
                System.setProperty("https.proxyHost", https_proxy.substring(0, httpsColIndex));
                System.setProperty("https.proxyPort", https_proxy.substring(httpsColIndex+1, https_proxy.length()));
            }
        }

        return true;
    }
}

