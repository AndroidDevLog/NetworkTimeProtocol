package com.iosdevlog.networktimeprotocol.Util;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.net.InetAddress;

/**
 * Created by iosdevlog on 2017/7/3.
 */

public class Util {
    //NTP server list: http://tf.nist.gov/tf-cgi/servers.cgi
    public static final String TIME_SERVER = "pool.ntp.org";

    public static long getCurrentNetworkTime() {
        NTPUDPClient lNTPUDPClient = new NTPUDPClient();
        lNTPUDPClient.setDefaultTimeout(3000);
        long returnTime = 0;
        try {
            lNTPUDPClient.open();
            InetAddress lInetAddress = InetAddress.getByName(TIME_SERVER);
            TimeInfo lTimeInfo = lNTPUDPClient.getTime(lInetAddress);
            // returnTime =  lTimeInfo.getReturnTime(); // local time
            returnTime = lTimeInfo.getMessage().getTransmitTimeStamp().getTime();   //server time
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lNTPUDPClient.close();
        }

        return returnTime;
    }
}
