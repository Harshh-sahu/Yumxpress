/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.util;

/**
 *
 * @author harsh
 */
public class OwnerProfile {

    public static String getOwnerame() {
        return ownerame;
    }

    public static void setOwnerame(String ownerame) {
        OwnerProfile.ownerame = ownerame;
    }

    public static String getCompanyName() {
        return compnayName;
    }

    public static void setCompnayName(String compnayName) {
        OwnerProfile.compnayName = compnayName;
    }

    public static String getCompnayId() {
        return compnayId;
    }

    public static void setCompnayId(String compnayId) {
        OwnerProfile.compnayId = compnayId;
    }
    private static String ownerame;
    private static String compnayName;
    private static String compnayId;

}
