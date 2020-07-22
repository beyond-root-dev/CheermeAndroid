package com.cheerme.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WidgetModel {

    @SerializedName("Success")
    @Expose
    var success: Boolean? = null
    @SerializedName("Data")
    @Expose
    var data: Data? = null
    @SerializedName("Message")
    @Expose
    var message: String? = null

    class Data {
        @SerializedName("WidgetThemes")
        @Expose
        var widgetThemes: WidgetThemes? = null
        @SerializedName("WidgetLayouts")
        @Expose
        var widgetLayouts: WidgetLayouts? = null
        @SerializedName("WidgetContents")
        @Expose
        var widgetContents: WidgetContents? = null
        @SerializedName("IsVIPTierEnable")
        @Expose
        var isVIPTierEnable: Boolean? = null
        @SerializedName("IsReferralEnable")
        @Expose
        var isReferralEnable: Boolean? = null
        @SerializedName("IsAlexaEnable")
        @Expose
        var isAlexaEnable: Boolean? = null
        @SerializedName("IsLeasdershipBoardEnable")
        @Expose
        var isLeasdershipBoardEnable: Boolean? = null

    }

    class WidgetContents {
        @SerializedName("Id")
        @Expose
        var id: Int? = null
        @SerializedName("ContentTypeId")
        @Expose
        var contentTypeId: Int? = null
        @SerializedName("HeaderTitle")
        @Expose
        var headerTitle: String? = null
        @SerializedName("HeaderCaption")
        @Expose
        var headerCaption: String? = null
        @SerializedName("AccountCreationTitle")
        @Expose
        var accountCreationTitle: String? = null
        @SerializedName("AccountCreationCaption")
        @Expose
        var accountCreationCaption: String? = null
        @SerializedName("AccountCreationButtonText")
        @Expose
        var accountCreationButtonText: String? = null
        @SerializedName("PointsTitle")
        @Expose
        var pointsTitle: String? = null
        @SerializedName("PointsDescription")
        @Expose
        var pointsDescription: String? = null
        @SerializedName("ReferralsTitle")
        @Expose
        var referralsTitle: String? = null
        @SerializedName("ReferralsDescription")
        @Expose
        var referralsDescription: String? = null
        @SerializedName("ReferralsGiftDescription")
        @Expose
        var referralsGiftDescription: String? = null
        @SerializedName("VIPTitle")
        @Expose
        var vIPTitle: String? = null
        @SerializedName("VIPDescription")
        @Expose
        var vIPDescription: String? = null

    }

    class WidgetLayouts {
        @SerializedName("Id")
        @Expose
        var id: Int? = null
        @SerializedName("DesktopPlacementId")
        @Expose
        var desktopPlacementId: Int? = null
        @SerializedName("DesktopSideSpacing")
        @Expose
        var desktopSideSpacing: Double? = null
        @SerializedName("DesktopBottomSpacing")
        @Expose
        var desktopBottomSpacing: Double? = null
        @SerializedName("MobilePlacementId")
        @Expose
        var mobilePlacementId: Int? = null
        @SerializedName("MobileSideSpacing")
        @Expose
        var mobileSideSpacing: Double? = null
        @SerializedName("MobileBottomSpacing")
        @Expose
        var mobileBottomSpacing: Double? = null
        @SerializedName("VisiblityTypeId")
        @Expose
        var visiblityTypeId: Int? = null
        @SerializedName("Branding")
        @Expose
        var branding: Boolean? = null
        @SerializedName("LauncherLayoutTypeId")
        @Expose
        var launcherLayoutTypeId: Int? = null
        @SerializedName("LauncherText")
        @Expose
        var launcherText: String? = null
        @SerializedName("LauncherIconURL")
        @Expose
        var launcherIconURL: String? = null

    }

    class WidgetThemes {
        @SerializedName("Id")
        @Expose
        var id: Int? = null
        @SerializedName("ThemeStyleId")
        @Expose
        var themeStyleId: Int? = null
        @SerializedName("PrimaryColor")
        @Expose
        var primaryColor: String? = null
        @SerializedName("SecondaryColor")
        @Expose
        var secondaryColor: String? = null
        @SerializedName("BannerColor")
        @Expose
        var bannerColor: String? = null
        @SerializedName("ButtonColor")
        @Expose
        var buttonColor: String? = null
        @SerializedName("IconColor")
        @Expose
        var iconColor: String? = null
        @SerializedName("LauncherColor")
        @Expose
        var launcherColor: String? = null
        @SerializedName("HeaderFont")
        @Expose
        var headerFont: String? = null
        @SerializedName("ButtonFont")
        @Expose
        var buttonFont: String? = null
        @SerializedName("IconFont")
        @Expose
        var iconFont: String? = null
        @SerializedName("LauncherFont")
        @Expose
        var launcherFont: String? = null
        @SerializedName("BannerFont")
        @Expose
        var bannerFont: String? = null

    }

}