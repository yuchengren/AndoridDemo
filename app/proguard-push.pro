#����
-dontwarn com.igexin.**
-keep class com.igexin.** { *; }
-keep class org.json.** { *; }

-keep class android.support.v4.app.NotificationCompat { *; }
-keep class android.support.v4.app.NotificationCompat$Builder { *; }
#����
-keep class com.meizu.** { *; }
-dontwarn com.meizu.**
#С��
-keep class com.xiaomi.** { *; }
-dontwarn com.xiaomi.push.**
-keep class org.apache.thrift.** { *; }
#��Ϊ
-keep class com.huawei.hms.** { *; }
-dontwarn com.huawei.hms.**

#push�� bean-���������ݰ�
-keep class com.mistong.push.entity.** { *; }