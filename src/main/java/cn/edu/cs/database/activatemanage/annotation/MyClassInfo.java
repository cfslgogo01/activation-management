package cn.edu.cs.database.activatemanage.annotation;

@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
public @interface MyClassInfo {
    public enum Status {未使用,已使用}
//    String InfoText;
    Status status() default Status.未使用;
}
