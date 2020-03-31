package com.ibsvalley.hoop.model


import com.google.gson.annotations.SerializedName
//import android.support.annotation.Keep
import androidx.annotation.Keep

@Keep
data class EgyptStatisticsModel(
    @SerializedName("countrydata") var countrydata: List<Countrydata>,
    @SerializedName("countrynewsitems") var countrynewsitems: List<Countrynewsitem>
) {
    @Keep
    data class Countrynewsitem(
        @SerializedName("stat") var stat: String,
        @SerializedName("1") var x1: X1,
        @SerializedName("10") var x10: X10,
        @SerializedName("11") var x11: X11,
        @SerializedName("12") var x12: X12,
        @SerializedName("13") var x13: X13,
        @SerializedName("14") var x14: X14,
        @SerializedName("15") var x15: X15,
        @SerializedName("16") var x16: X16,
        @SerializedName("17") var x17: X17,
        @SerializedName("18") var x18: X18,
        @SerializedName("19") var x19: X19,
        @SerializedName("2") var x2: X2,
        @SerializedName("20") var x20: X20,
        @SerializedName("21") var x21: X21,
        @SerializedName("22") var x22: X22,
        @SerializedName("23") var x23: X23,
        @SerializedName("24") var x24: X24,
        @SerializedName("25") var x25: X25,
        @SerializedName("26") var x26: X26,
        @SerializedName("27") var x27: X27,
        @SerializedName("28") var x28: X28,
        @SerializedName("29") var x29: X29,
        @SerializedName("3") var x3: X3,
        @SerializedName("30") var x30: X30,
        @SerializedName("31") var x31: X31,
        @SerializedName("32") var x32: X32,
        @SerializedName("33") var x33: X33,
        @SerializedName("34") var x34: X34,
        @SerializedName("35") var x35: X35,
        @SerializedName("36") var x36: X36,
        @SerializedName("37") var x37: X37,
        @SerializedName("38") var x38: X38,
        @SerializedName("39") var x39: X39,
        @SerializedName("4") var x4: X4,
        @SerializedName("40") var x40: X40,
        @SerializedName("41") var x41: X41,
        @SerializedName("42") var x42: X42,
        @SerializedName("43") var x43: X43,
        @SerializedName("44") var x44: X44,
        @SerializedName("45") var x45: X45,
        @SerializedName("46") var x46: X46,
        @SerializedName("47") var x47: X47,
        @SerializedName("48") var x48: X48,
        @SerializedName("49") var x49: X49,
        @SerializedName("5") var x5: X5,
        @SerializedName("50") var x50: X50,
        @SerializedName("51") var x51: X51,
        @SerializedName("52") var x52: X52,
        @SerializedName("53") var x53: X53,
        @SerializedName("54") var x54: X54,
        @SerializedName("55") var x55: X55,
        @SerializedName("56") var x56: X56,
        @SerializedName("57") var x57: X57,
        @SerializedName("6") var x6: X6,
        @SerializedName("7") var x7: X7,
        @SerializedName("8") var x8: X8,
        @SerializedName("9") var x9: X9
    ) {
        @Keep
        data class X12(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X30(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X45(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X36(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X4(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X16(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X9(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X10(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X55(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X53(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X18(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X33(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X32(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X2(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X13(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X42(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X6(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X49(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X17(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X41(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X54(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X38(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X40(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X8(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X50(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X3(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X20(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X39(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X47(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X14(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X46(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X19(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X23(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X26(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X25(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X37(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X43(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X21(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X35(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X56(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X22(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X34(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X51(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X48(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X24(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X15(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X57(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X28(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X52(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X44(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X5(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X29(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X31(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X1(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X7(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X27(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )

        @Keep
        data class X11(
            @SerializedName("image") var image: String,
            @SerializedName("newsid") var newsid: String,
            @SerializedName("time") var time: String,
            @SerializedName("title") var title: String,
            @SerializedName("url") var url: String
        )
    }

    @Keep
    data class Countrydata(
        @SerializedName("info") var info: Info,
        @SerializedName("total_active_cases") var totalActiveCases: Int,
        @SerializedName("total_cases") var totalCases: Int,
        @SerializedName("total_deaths") var totalDeaths: Int,
        @SerializedName("total_new_cases_today") var totalNewCasesToday: Int,
        @SerializedName("total_new_deaths_today") var totalNewDeathsToday: Int,
        @SerializedName("total_recovered") var totalRecovered: Int,
        @SerializedName("total_serious_cases") var totalSeriousCases: Int,
        @SerializedName("total_unresolved") var totalUnresolved: Int
    ) {
        @Keep
        data class Info(
            @SerializedName("code") var code: String,
            @SerializedName("ourid") var ourid: Int,
            @SerializedName("source") var source: String,
            @SerializedName("title") var title: String
        )
    }
}